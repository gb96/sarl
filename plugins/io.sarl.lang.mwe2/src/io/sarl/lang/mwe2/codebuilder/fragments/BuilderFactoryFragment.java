/*
 * $Id$
 *
 * SARL is an general-purpose agent programming language.
 * More details on http://www.sarl.io
 *
 * Copyright (C) 2014-2016 the original authors or authors.
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

package io.sarl.lang.mwe2.codebuilder.fragments;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess.BindingFactory;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.XtendFileAccess;

/** Generator of the script builder types.
 *
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
public class BuilderFactoryFragment extends AbstractSubCodeBuilderFragment {

	@Inject
	private BuilderFactoryContributions contributions;

	/** Replies the custom implementation for the builder factory.
	 *
	 * @return the implementation.
	 */
	@Pure
	public TypeReference getBuilderFactoryImplCustom() {
		String runtimeBasePackage = getBasePackage();
		return new TypeReference(runtimeBasePackage + ".CodeBuilderFactoryCustom"); //$NON-NLS-1$
	}

	/** Replies the contributions.
	 *
	 * @return the contributions.
	 */
	protected BuilderFactoryContributions getContributions() {
		return this.contributions;
	}

	@Override
	@SuppressWarnings("checkstyle:all")
	public void generate() {
		super.generate();
		final TypeReference runtimeModule = getNaming().getRuntimeModule(getGrammar());
		final TypeReference factory = getBuilderFactoryImpl();
		StringConcatenationClient content = new StringConcatenationClient() {
			@SuppressWarnings("synthetic-access")
			@Override
			protected void appendTo(TargetStringConcatenation it) {
				it.append("/**"); //$NON-NLS-1$
				it.append(" * Creates {@link ICodeBuilder}s to insert SARL code snippets."); //$NON-NLS-1$
				it.append(" */"); //$NON-NLS-1$
				it.newLine();
				it.append("@SuppressWarnings(\"all\")"); //$NON-NLS-1$
				it.newLine();
				it.append("public class "); //$NON-NLS-1$
				it.append(factory.getSimpleName());
				it.append(" {"); //$NON-NLS-1$
				it.newLineIfNotEmpty();
				it.newLine();
				it.append("\t@"); //$NON-NLS-1$
				it.append(Inject.class);
				it.newLine();
				it.append("\tprivate "); //$NON-NLS-1$
				it.append(IResourceFactory.class);
				it.append(" resourceFactory;"); //$NON-NLS-1$
				it.newLineIfNotEmpty();
				it.newLine();
				it.append("\tprivate String fileExtension;"); //$NON-NLS-1$
				it.newLineIfNotEmpty();
				it.newLine();
				it.append("\t@"); //$NON-NLS-1$
				it.append(Inject.class);
				it.newLine();
				it.append("\tprivate "); //$NON-NLS-1$
				it.append(Provider.class);
				it.append("<"); //$NON-NLS-1$
				it.append(ImportManager.class);
				it.append("> importManagerProvider;"); //$NON-NLS-1$
				it.newLineIfNotEmpty();
				it.newLine();
				it.append("\t@"); //$NON-NLS-1$
				it.append(Inject.class);
				it.newLine();
				it.append("\tpublic void setFileExtensions(@"); //$NON-NLS-1$
				it.append(Named.class);
				it.append("("); //$NON-NLS-1$
				it.append(Constants.class);
				it.append(".FILE_EXTENSIONS) String fileExtensions) {"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\tthis.fileExtension = fileExtensions.split(\"[:;,]+\")[0];"); //$NON-NLS-1$
				it.newLine();
				it.append("\t}"); //$NON-NLS-1$
				it.newLineIfNotEmpty();
				it.newLine();
				it.append("\t/** Compute a unused URI for a synthetic resource."); //$NON-NLS-1$
				it.newLine();
				it.append("\t * @param resourceSet - the resource set in which the resource should be located."); //$NON-NLS-1$
				it.newLine();
				it.append("\t * @return the uri."); //$NON-NLS-1$
				it.newLine();
				it.append("\t */"); //$NON-NLS-1$
				it.newLine();
				it.append("\t@"); //$NON-NLS-1$
				it.append(Pure.class);
				it.newLine();
				it.append("\tprotected "); //$NON-NLS-1$
				it.append(URI.class);
				it.append(" computeUnusedUri("); //$NON-NLS-1$
				it.append(ResourceSet.class);
				it.append(" resourceSet) {"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\tString name = \"__synthetic\";"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\tfor (int i = 0; i < Integer.MAX_VALUE; ++i) {"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\t\t"); //$NON-NLS-1$
				it.append(URI.class);
				it.append(" syntheticUri = "); //$NON-NLS-1$
				it.append(URI.class);
				it.append(".createURI(name + i + \".\" + getScriptFileExtension());"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\t\tif (resourceSet.getResource(syntheticUri, false) == null) {"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\t\t\treturn syntheticUri;"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\t\t}"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\t}"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\tthrow new IllegalStateException();"); //$NON-NLS-1$
				it.newLine();
				it.append("\t}"); //$NON-NLS-1$
				it.newLineIfNotEmpty();
				it.newLine();
				it.append("\t/** Replies the script's file extension."); //$NON-NLS-1$
				it.newLine();
				it.append("\t */"); //$NON-NLS-1$
				it.newLine();
				it.append("\t@"); //$NON-NLS-1$
				it.append(Pure.class);
				it.newLine();
				it.append("\tpublic String getScriptFileExtension() {"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\treturn this.fileExtension;"); //$NON-NLS-1$
				it.newLine();
				it.append("\t}"); //$NON-NLS-1$
				it.newLineIfNotEmpty();
				it.newLine();
				it.append("\t/** Replies the resource factory."); //$NON-NLS-1$
				it.newLine();
				it.append("\t *"); //$NON-NLS-1$
				it.newLine();
				it.append("\t * @return the resource factory."); //$NON-NLS-1$
				it.newLine();
				it.append("\t */"); //$NON-NLS-1$
				it.newLine();
				it.append("\t@"); //$NON-NLS-1$
				it.append(Pure.class);
				it.newLine();
				it.append("\tprotected "); //$NON-NLS-1$
				it.append(IResourceFactory.class);
				it.append(" getResourceFactory() {"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\treturn this.resourceFactory;"); //$NON-NLS-1$
				it.newLine();
				it.append("\t}"); //$NON-NLS-1$
				it.newLineIfNotEmpty();
				it.newLine();
				it.append("\t/** Replies the name of the foo package."); //$NON-NLS-1$
				it.newLine();
				it.append("\t *"); //$NON-NLS-1$
				it.newLine();
				it.append("\t * @return the name of the foo package."); //$NON-NLS-1$
				it.newLine();
				it.append("\t */"); //$NON-NLS-1$
				it.newLine();
				it.append("\t@"); //$NON-NLS-1$
				it.append(Pure.class);
				it.newLine();
				it.append("\tprotected String getFooPackageName() {"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\treturn \""); //$NON-NLS-1$
				it.append(Strings.convertToJavaString(GrammarUtil.getNamespace(getGrammar())));
				it.append(".foo\";"); //$NON-NLS-1$
				it.newLine();
				it.append("\t}"); //$NON-NLS-1$
				it.newLineIfNotEmpty();
				it.newLine();
				it.append("\t/** Create a synthetic resource."); //$NON-NLS-1$
				it.newLine();
				it.append("\t *"); //$NON-NLS-1$
				it.newLine();
				it.append("\t * @param resourceSet the resourceSet."); //$NON-NLS-1$
				it.newLine();
				it.append("\t * @return the resource."); //$NON-NLS-1$
				it.newLine();
				it.append("\t */"); //$NON-NLS-1$
				it.newLine();
				it.append("\t@"); //$NON-NLS-1$
				it.append(Pure.class);
				it.newLine();
				it.append("\tprotected "); //$NON-NLS-1$
				it.append(Resource.class);
				it.append(" createResource("); //$NON-NLS-1$
				it.append(ResourceSet.class);
				it.append("  resourceSet) {"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\t"); //$NON-NLS-1$
				it.append(URI.class);
				it.append(" uri = computeUnusedUri(resourceSet);"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\t"); //$NON-NLS-1$
				it.append(Resource.class);
				it.append(" resource = getResourceFactory().createResource(uri);"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\tresourceSet.getResources().add(resource);"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\treturn resource;"); //$NON-NLS-1$
				it.newLine();
				it.append("\t}"); //$NON-NLS-1$
				it.newLineIfNotEmpty();
				it.newLine();
				it.append("\t/** Replies a provider for the given type."); //$NON-NLS-1$
				it.newLine();
				it.append("\t * <p>The provider uses a local context singleton of the import manager."); //$NON-NLS-1$
				it.newLine();
				it.append("\t * @param type the type of the object to provide."); //$NON-NLS-1$
				it.newLine();
				it.append("\t * @return the provider."); //$NON-NLS-1$
				it.newLine();
				it.append("\t */"); //$NON-NLS-1$
				it.newLine();
				it.append("\t@"); //$NON-NLS-1$
				it.append(Pure.class);
				it.newLine();
				it.append("\tprotected <T> "); //$NON-NLS-1$
				it.append(Provider.class);
				it.append("<T> getProvider(Class<T> type) {"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\t"); //$NON-NLS-1$
				it.append(runtimeModule);
				it.append(" runtimeModule = new "); //$NON-NLS-1$
				it.append(runtimeModule);
				it.append("();"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\t"); //$NON-NLS-1$
				it.append(ImportManager.class);
				it.append(" importManager = this.importManagerProvider.get();"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\t"); //$NON-NLS-1$
				it.append(Module.class);
				it.append(" mergedModule = "); //$NON-NLS-1$
				it.append(Modules2.class);
				it.append(".mixin(runtimeModule, new CodeBuilderModule(importManager));"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\t"); //$NON-NLS-1$
				it.append(Injector.class);
				it.append(" injector = "); //$NON-NLS-1$
				it.append(Guice.class);
				it.append(".createInjector(mergedModule);"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\treturn injector.getProvider(type);"); //$NON-NLS-1$
				it.newLine();
				it.append("\t}"); //$NON-NLS-1$
				it.newLineIfNotEmpty();
				it.newLine();
				it.append("\tprivate static class CodeBuilderModule extends "); //$NON-NLS-1$
				it.append(AbstractModule.class);
				it.append(" {"); //$NON-NLS-1$
				it.newLineIfNotEmpty();
				it.newLine();
				it.append("\t\tprivate final "); //$NON-NLS-1$
				it.append(ImportManager.class);
				it.append(" importManager;"); //$NON-NLS-1$
				it.newLineIfNotEmpty();
				it.newLine();
				it.append("\t\tpublic CodeBuilderModule("); //$NON-NLS-1$
				it.append(ImportManager.class);
				it.append(" importManager) {"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\t\tthis.importManager = importManager;"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\t}"); //$NON-NLS-1$
				it.newLineIfNotEmpty();
				it.newLine();
				it.append("\t\t@Override"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\tprotected void configure() {"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\t\tbind("); //$NON-NLS-1$
				it.append(ImportManager.class);
				it.append(".class).toInstance(this.importManager);"); //$NON-NLS-1$
				it.newLine();
				it.append("\t\t}"); //$NON-NLS-1$
				it.newLineIfNotEmpty();
				it.newLine();
				it.append("\t}"); //$NON-NLS-1$
				it.newLineIfNotEmpty();
				it.newLine();
				for (StringConcatenationClient client : generateMembers()) {
					it.append(client);
				}
				it.append("}"); //$NON-NLS-1$
				it.newLineIfNotEmpty();
				it.newLine();
			}

		};
		JavaFileAccess createJavaFile = getFileAccessFactory().createJavaFile(factory, content);
		createJavaFile.writeTo(getSrcGen());
	}

	/** Generate the members.
	 *
	 * @return the code.
	 */
	protected Iterable<StringConcatenationClient> generateMembers() {
		return getContributions().getContributions();
	}

	@Override
	public void generateXtendStubs() {
		super.generateXtendStubs();
		TypeReference stub = getBuilderFactoryImplCustom();
		StringConcatenationClient content = new StringConcatenationClient() {
			@Override
			protected void appendTo(TargetStringConcatenation it) {
				it.append("/** User-defined builder factory of the " + getLanguageName() //$NON-NLS-1$
						+ " scripts."); //$NON-NLS-1$
				it.newLine();
				it.append(" */"); //$NON-NLS-1$
				it.newLine();
				it.append("class "); //$NON-NLS-1$
				it.append(stub);
				it.append(" extends "); //$NON-NLS-1$
				it.append(getBuilderFactoryImpl());
				it.append(" {"); //$NON-NLS-1$
				it.newLineIfNotEmpty();
				it.newLine();
				it.append("}"); //$NON-NLS-1$
				it.newLine();
			}

		};
		XtendFileAccess xtendFile = getFileAccessFactory().createXtendFile(stub, content);
		IFileSystemAccess2 fileSystem = getSrc();
		if (!fileSystem.isFile(xtendFile.getPath())) {
			xtendFile.writeTo(fileSystem);
		}
	}

	@Override
	@SuppressWarnings("checkstyle:all")
	public void generateJavaStubs() {
		super.generateJavaStubs();
		final TypeReference stub = getBuilderFactoryImplCustom();
		StringConcatenationClient content = new StringConcatenationClient() {
			@Override
			protected void appendTo(TargetStringConcatenation it) {
				it.append("/** User-defined builder factory of the " + getLanguageName() + " scripts."); //$NON-NLS-1$//$NON-NLS-2$
				it.newLine();
				it.append(" */"); //$NON-NLS-1$
				it.newLine();
				it.append("public class "); //$NON-NLS-1$
				it.append(stub);
				it.append(" extends "); //$NON-NLS-1$
				it.append(getBuilderFactoryImpl());
				it.append(" {"); //$NON-NLS-1$
				it.newLineIfNotEmpty();
				it.newLine();
				it.append("}"); //$NON-NLS-1$
				it.newLine();
			}

		};
		JavaFileAccess javaFile = getFileAccessFactory().createJavaFile(stub, content);
		IFileSystemAccess2 fileSystem = getSrc();
		if (!fileSystem.isFile(javaFile.getPath())) {
			javaFile.writeTo(fileSystem);
		}
	}

	@Override
	public void generateBindings(BindingFactory factory) {
		super.generateBindings(factory);
		IFileSystemAccess2 fileSystem = getSrc();
		TypeReference type;
		if ((fileSystem.isFile(getBuilderFactoryImplCustom().getJavaPath()))
				|| (fileSystem.isFile(getBuilderFactoryImplCustom().getXtendPath()))) {
			type = getBuilderFactoryImplCustom();
		} else {
			type = getBuilderFactoryImpl();
		}
		factory.addfinalTypeToType(getBuilderFactoryImpl(), type);
	}

}
