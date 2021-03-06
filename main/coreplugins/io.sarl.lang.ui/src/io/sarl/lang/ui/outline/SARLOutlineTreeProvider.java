/*
 * $Id$
 *
 * SARL is an general-purpose agent programming language.
 * More details on http://www.sarl.io
 *
 * Copyright (C) 2014-2017 the original authors or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.sarl.lang.ui.outline;

import javax.inject.Named;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.outline.impl.EStructuralFeatureNode;
import org.eclipse.xtext.xbase.annotations.ui.outline.XbaseWithAnnotationsOutlineTreeProvider;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

import io.sarl.lang.jvmmodel.SarlJvmModelAssociations;
import io.sarl.lang.sarl.SarlAction;
import io.sarl.lang.sarl.SarlBehaviorUnit;
import io.sarl.lang.sarl.SarlCapacityUses;
import io.sarl.lang.sarl.SarlConstructor;
import io.sarl.lang.sarl.SarlField;
import io.sarl.lang.sarl.SarlRequiredCapacity;
import io.sarl.lang.sarl.SarlScript;
import io.sarl.lang.util.Utils;

/**
 * Customization of the default outline structure.
 *
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 * @see "https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#outline"
 */
public class SARLOutlineTreeProvider extends XbaseWithAnnotationsOutlineTreeProvider {

	@Inject
	private SarlJvmModelAssociations associations;

	@Inject
	@Named("DiagnosticDecorator")
	private ILabelDecorator diagnoticDecorator;

	@Inject
	private CommonTypeComputationServices services;

	/** Create a node for the SARL script.
	 *
	 * @param parentNode the parent node.
	 * @param modelElement the feature container for which a node should be created.
	 */
	protected void _createChildren(DocumentRootNode parentNode, SarlScript modelElement) {
		if (!Strings.isNullOrEmpty(modelElement.getPackage())) {
			// Create the node for the package declaration.
			createEStructuralFeatureNode(
					parentNode, modelElement,
					XtendPackage.Literals.XTEND_FILE__PACKAGE,
					this.imageDispatcher.invoke(getClass().getPackage()),
					// Do not use the text dispatcher below for avoiding to obtain
					// the filename of the script.
					modelElement.getPackage(),
					true);
		}
		// Create the nodes for the import declarations.
		/*if (modelElement.getImportSection() != null && !modelElement.getImportSection().getImportDeclarations().isEmpty()) {
			createNode(parentNode, modelElement.getImportSection());
		}*/
		// Create a node per type declaration.
		for (final XtendTypeDeclaration topElement : modelElement.getXtendTypes()) {
			createNode(parentNode, topElement);
		}
	}

	/** Create a node for the given feature container.
	 *
	 * @param parentNode the parent node.
	 * @param modelElement the feature container for which a node should be created.
	 */
	@SuppressWarnings("checkstyle:cyclomaticcomplexity")
	protected void _createNode(DocumentRootNode parentNode, XtendTypeDeclaration modelElement) {
		//
		// The text region is set to the model element, not to the model element's name as in the
		// default implementation of createStructuralFeatureNode().
		// The text region computation is overridden in order to have a correct link to the editor.
		//
		final boolean isFeatureSet = modelElement.eIsSet(XtendPackage.Literals.XTEND_TYPE_DECLARATION__NAME);
		final EStructuralFeatureNode elementNode = new EStructuralFeatureNode(
				modelElement,
				XtendPackage.Literals.XTEND_TYPE_DECLARATION__NAME,
				parentNode,
				this.imageDispatcher.invoke(modelElement),
				this.textDispatcher.invoke(modelElement),
				modelElement.getMembers().isEmpty() || !isFeatureSet);
		final EObject primarySourceElement = this.associations.getPrimarySourceElement(modelElement);
		final ICompositeNode parserNode = NodeModelUtils.getNode(
				(primarySourceElement == null) ? modelElement : primarySourceElement);
		elementNode.setTextRegion(parserNode.getTextRegion());
		//
		boolean hasConstructor = false;
		if (!modelElement.getMembers().isEmpty()) {
			EObjectNode capacityUseNode = null;
			EObjectNode capacityRequirementNode = null;

			for (final EObject feature : modelElement.getMembers()) {
				if (feature instanceof SarlConstructor) {
					hasConstructor = true;
					createNode(elementNode, feature);
				} else if (feature instanceof SarlField
						|| feature instanceof SarlAction
						|| feature instanceof SarlBehaviorUnit
						|| feature instanceof XtendTypeDeclaration) {
					createNode(elementNode, feature);
				} else if (feature instanceof SarlCapacityUses) {
					capacityUseNode = createCapacityUseNode(elementNode, (SarlCapacityUses) feature, capacityUseNode);
				} else if (feature instanceof SarlRequiredCapacity) {
					capacityRequirementNode = createRequiredCapacityNode(elementNode,
							(SarlRequiredCapacity) feature, capacityRequirementNode);
				}
			}
		}
		if (!hasConstructor && modelElement instanceof XtendClass) {
			createInheritedConstructors(elementNode, (XtendClass) modelElement);
		}
	}

	private void createInheritedConstructors(EStructuralFeatureNode elementNode, XtendClass modelElement) {
		final JvmTypeReference extend = modelElement.getExtends();
		if (extend != null) {
			final LightweightTypeReference reference = Utils.toLightweightTypeReference(extend, this.services);
			if (reference != null) {
				final JvmType type = reference.getType();
				if (type instanceof JvmDeclaredType) {
					for (final JvmConstructor constructor : ((JvmDeclaredType) type).getDeclaredConstructors()) {
						createNode(elementNode, constructor);
					}
				}
			}
		}
	}

	private EObjectNode createCapacityUseNode(EStructuralFeatureNode elementNode, SarlCapacityUses feature,
			EObjectNode oldCapacityUseNode) {
		EObjectNode capacityUseNode = oldCapacityUseNode;
		if (capacityUseNode == null) {
			capacityUseNode = createEObjectNode(
					elementNode, feature,
					this.imageDispatcher.invoke(feature),
					this.textDispatcher.invoke(feature),
					false);
		}
		for (final JvmParameterizedTypeReference item : feature.getCapacities()) {
			createEObjectNode(
					capacityUseNode, item,
					this.imageDispatcher.invoke(item),
					this.textDispatcher.invoke(item),
					true);
		}
		return capacityUseNode;
	}

	private EObjectNode createRequiredCapacityNode(EStructuralFeatureNode elementNode, SarlRequiredCapacity feature,
			EObjectNode oldCapacityRequirementNode) {
		EObjectNode capacityRequirementNode = oldCapacityRequirementNode;
		if (capacityRequirementNode == null) {
			capacityRequirementNode = createEObjectNode(
					elementNode, feature,
					this.imageDispatcher.invoke(feature),
					this.textDispatcher.invoke(feature),
					false);
		}
		for (final JvmParameterizedTypeReference item : feature.getCapacities()) {
			createEObjectNode(
					capacityRequirementNode, item,
					this.imageDispatcher.invoke(item),
					this.textDispatcher.invoke(item),
					true);
		}
		return capacityRequirementNode;
	}

	/** Replies if the type declaration element is a leaf in the outline.
	 *
	 * @param modelElement the model element.
	 * @return <code>true</code> if it is a leaf, <code>false</code> otherwise.
	 */
	@SuppressWarnings("static-method")
	protected boolean _isLeaf(XtendTypeDeclaration modelElement) {
		return modelElement.getMembers().isEmpty();
	}

	/** Replies if the member element is a leaf in the outline.
	 *
	 * @param modelElement the model element.
	 * @return <code>true</code> if it is a leaf, <code>false</code> otherwise.
	 */
	@SuppressWarnings("static-method")
	protected boolean _isLeaf(XtendMember modelElement) {
		return true;
	}

	/** Replies if the JVM elements are leafs in the outline.
	 *
	 * @param modelElement the model element.
	 * @return <code>true</code> if it is a leaf, <code>false</code> otherwise.
	 */
	@SuppressWarnings("static-method")
	protected boolean _isLeaf(JvmIdentifiableElement modelElement) {
		return true;
	}

	@Override
	protected EObjectNode createEObjectNode(
			IOutlineNode parentNode,
			EObject modelElement, Image image, Object text,
			boolean isLeaf) {
		final SARLEObjectNode objectNode = new SARLEObjectNode(modelElement, parentNode, image, text, isLeaf);
		configureNode(parentNode, modelElement, objectNode);
		return objectNode;
	}

	private void configureNode(IOutlineNode parentNode, EObject modelElement, SARLEObjectNode objectNode) {
		final EObject primarySourceElement = this.associations.getPrimarySourceElement(modelElement);
		final ICompositeNode parserNode = NodeModelUtils.getNode(
				(primarySourceElement == null) ? modelElement : primarySourceElement);

		if (parserNode != null) {
			objectNode.setTextRegion(parserNode.getTextRegion());
		}

		if (isLocalElement(parentNode, modelElement)) {
			objectNode.setShortTextRegion(this.locationInFileProvider.getSignificantTextRegion(modelElement));
		}

		objectNode.setStatic(isStatic(modelElement));
	}

	private static boolean isStatic(EObject element) {
		if (element instanceof JvmFeature) {
			return ((JvmFeature) element).isStatic();
		}
		if (element instanceof JvmDeclaredType) {
			return ((JvmDeclaredType) element).isStatic();
		}
		if (element instanceof XtendMember) {
			try {
				return ((XtendMember) element).isStatic();
			} catch (Exception exception) {
				// Some XtendMember does not support
			}
		}
		return false;
	}

	/** Get the image for the Xtend members.
	 *
	 * @param modelElement the member.
	 * @return the image.
	 */
	protected Image _image(XtendMember modelElement) {
		final Image img = super._image(modelElement);
		return this.diagnoticDecorator.decorateImage(img, modelElement);
	}

}
