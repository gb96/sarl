/*
 * $Id$
 *
 * File is automatically generated by the Xtext language generator.
 * Do not change it.
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
package io.sarl.lang.codebuilder.appenders;

import io.sarl.lang.codebuilder.builders.ISarlAgentBuilder;
import io.sarl.lang.codebuilder.builders.ISarlAnnotationTypeBuilder;
import io.sarl.lang.codebuilder.builders.ISarlArtifactBuilder;
import io.sarl.lang.codebuilder.builders.ISarlBehaviorBuilder;
import io.sarl.lang.codebuilder.builders.ISarlCapacityBuilder;
import io.sarl.lang.codebuilder.builders.ISarlClassBuilder;
import io.sarl.lang.codebuilder.builders.ISarlEnumerationBuilder;
import io.sarl.lang.codebuilder.builders.ISarlEventBuilder;
import io.sarl.lang.codebuilder.builders.ISarlInterfaceBuilder;
import io.sarl.lang.codebuilder.builders.ISarlSkillBuilder;
import io.sarl.lang.codebuilder.builders.ISarlSpaceBuilder;
import io.sarl.lang.codebuilder.builders.IScriptBuilder;
import io.sarl.lang.sarl.SarlScript;
import java.io.IOException;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
import org.eclipse.xtext.xbase.lib.Pure;

/** Appender of Sarl scripts.
 *
 */
@SuppressWarnings("all")
public class ScriptSourceAppender extends AbstractSourceAppender implements IScriptBuilder {

	private IScriptBuilder builder;

	/** Find the reference to the type with the given name.
	 * @param typeName the fully qualified name of the type
	 * @return the type reference.
	 */
	public JvmParameterizedTypeReference newTypeRef(String typeName) {
		return this.builder.newTypeRef(typeName);
	}

	/** Find the reference to the type with the given name.
	 * @param context the context for the type reference use
	 * @param typeName the fully qualified name of the type
	 * @return the type reference.
	 */
	public JvmParameterizedTypeReference newTypeRef(Notifier context, String typeName) {
		return this.builder.newTypeRef(context, typeName);
	}

	public IJvmTypeProvider getTypeResolutionContext() {
		return this.builder.getTypeResolutionContext();
	}

	public ScriptSourceAppender(IScriptBuilder builder) {
		this.builder = builder;
	}

	public void build(ISourceAppender appender) throws IOException {
		if (!isFinalized()) {
			finalizeScript();
		}
		build(this.builder.getScript(), appender);
	}

	/** Create the internal Sarl script.
	 */
	public void eInit(Resource resource, String packageName, IJvmTypeProvider context) {
		this.builder.eInit(resource, packageName, context);
	}

	/** Replies the Sarl script.
	 */
	@Pure
	public SarlScript getScript() {
		return this.builder.getScript();
	}

	/** Replies the resource to which the script is attached.
	 */
	@Pure
	public Resource eResource() {
		return getScript().eResource();
	}

	/** Finalize the script.
	 *
	 * <p>The finalization includes: <ul>
	 * <li>The import section is created.</li>
	 * </ul>
	 */
	public void finalizeScript() {
		this.builder.finalizeScript();
	}

	/** Replies if the script was finalized.
	 */
	public boolean isFinalized() {
		return this.builder.isFinalized();
	}

	@Override
	@Pure
	public String toString() {
		return this.builder.toString();
	}

	/** Create a SarlEvent builder.
	 * @param name - the name of the SarlEvent.
	 * @return the builder.
	 */
	public ISarlEventBuilder addSarlEvent(String name) {
		 return this.builder.addSarlEvent(name);
	}

	/** Create a SarlCapacity builder.
	 * @param name - the name of the SarlCapacity.
	 * @return the builder.
	 */
	public ISarlCapacityBuilder addSarlCapacity(String name) {
		 return this.builder.addSarlCapacity(name);
	}

	/** Create a SarlAgent builder.
	 * @param name - the name of the SarlAgent.
	 * @return the builder.
	 */
	public ISarlAgentBuilder addSarlAgent(String name) {
		 return this.builder.addSarlAgent(name);
	}

	/** Create a SarlBehavior builder.
	 * @param name - the name of the SarlBehavior.
	 * @return the builder.
	 */
	public ISarlBehaviorBuilder addSarlBehavior(String name) {
		 return this.builder.addSarlBehavior(name);
	}

	/** Create a SarlSkill builder.
	 * @param name - the name of the SarlSkill.
	 * @return the builder.
	 */
	public ISarlSkillBuilder addSarlSkill(String name) {
		 return this.builder.addSarlSkill(name);
	}

	/** Create a SarlSpace builder.
	 * @param name - the name of the SarlSpace.
	 * @return the builder.
	 */
	public ISarlSpaceBuilder addSarlSpace(String name) {
		 return this.builder.addSarlSpace(name);
	}

	/** Create a SarlArtifact builder.
	 * @param name - the name of the SarlArtifact.
	 * @return the builder.
	 */
	public ISarlArtifactBuilder addSarlArtifact(String name) {
		 return this.builder.addSarlArtifact(name);
	}

	/** Create a SarlClass builder.
	 * @param name - the name of the SarlClass.
	 * @return the builder.
	 */
	public ISarlClassBuilder addSarlClass(String name) {
		 return this.builder.addSarlClass(name);
	}

	/** Create a SarlInterface builder.
	 * @param name - the name of the SarlInterface.
	 * @return the builder.
	 */
	public ISarlInterfaceBuilder addSarlInterface(String name) {
		 return this.builder.addSarlInterface(name);
	}

	/** Create a SarlEnumeration builder.
	 * @param name - the name of the SarlEnumeration.
	 * @return the builder.
	 */
	public ISarlEnumerationBuilder addSarlEnumeration(String name) {
		 return this.builder.addSarlEnumeration(name);
	}

	/** Create a SarlAnnotationType builder.
	 * @param name - the name of the SarlAnnotationType.
	 * @return the builder.
	 */
	public ISarlAnnotationTypeBuilder addSarlAnnotationType(String name) {
		 return this.builder.addSarlAnnotationType(name);
	}

}

