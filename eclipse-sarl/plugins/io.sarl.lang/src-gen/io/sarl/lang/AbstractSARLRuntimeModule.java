/*
 * $Id$
 *
 * File is automatically generated by the Xtext language generator.
 * Do not change it.
 *
 * SARL is an general-purpose agent programming language.
 * More details on http://www.sarl.io
 *
 * Copyright 2014-2017 the original authors and authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.sarl.lang;

import com.google.inject.Binder;
import com.google.inject.Provider;
import com.google.inject.name.Names;
import io.sarl.lang.actionprototype.DefaultActionPrototypeProvider;
import io.sarl.lang.actionprototype.IActionPrototypeProvider;
import io.sarl.lang.codebuilder.CodeBuilderFactory;
import io.sarl.lang.codebuilder.builders.BlockExpressionBuilderImpl;
import io.sarl.lang.codebuilder.builders.ExpressionBuilderImpl;
import io.sarl.lang.codebuilder.builders.FormalParameterBuilderImpl;
import io.sarl.lang.codebuilder.builders.IBlockExpressionBuilder;
import io.sarl.lang.codebuilder.builders.IExpressionBuilder;
import io.sarl.lang.codebuilder.builders.IFormalParameterBuilder;
import io.sarl.lang.codebuilder.builders.ISarlActionBuilder;
import io.sarl.lang.codebuilder.builders.ISarlAgentBuilder;
import io.sarl.lang.codebuilder.builders.ISarlAnnotationTypeBuilder;
import io.sarl.lang.codebuilder.builders.ISarlBehaviorBuilder;
import io.sarl.lang.codebuilder.builders.ISarlBehaviorUnitBuilder;
import io.sarl.lang.codebuilder.builders.ISarlCapacityBuilder;
import io.sarl.lang.codebuilder.builders.ISarlClassBuilder;
import io.sarl.lang.codebuilder.builders.ISarlConstructorBuilder;
import io.sarl.lang.codebuilder.builders.ISarlEnumLiteralBuilder;
import io.sarl.lang.codebuilder.builders.ISarlEnumerationBuilder;
import io.sarl.lang.codebuilder.builders.ISarlEventBuilder;
import io.sarl.lang.codebuilder.builders.ISarlFieldBuilder;
import io.sarl.lang.codebuilder.builders.ISarlInterfaceBuilder;
import io.sarl.lang.codebuilder.builders.ISarlSkillBuilder;
import io.sarl.lang.codebuilder.builders.ISarlSpaceBuilder;
import io.sarl.lang.codebuilder.builders.IScriptBuilder;
import io.sarl.lang.codebuilder.builders.ITypeParameterBuilder;
import io.sarl.lang.codebuilder.builders.SarlActionBuilderImpl;
import io.sarl.lang.codebuilder.builders.SarlAgentBuilderImpl;
import io.sarl.lang.codebuilder.builders.SarlAnnotationTypeBuilderImpl;
import io.sarl.lang.codebuilder.builders.SarlBehaviorBuilderImpl;
import io.sarl.lang.codebuilder.builders.SarlBehaviorUnitBuilderImpl;
import io.sarl.lang.codebuilder.builders.SarlCapacityBuilderImpl;
import io.sarl.lang.codebuilder.builders.SarlClassBuilderImpl;
import io.sarl.lang.codebuilder.builders.SarlConstructorBuilderImpl;
import io.sarl.lang.codebuilder.builders.SarlEnumLiteralBuilderImpl;
import io.sarl.lang.codebuilder.builders.SarlEnumerationBuilderImpl;
import io.sarl.lang.codebuilder.builders.SarlEventBuilderImpl;
import io.sarl.lang.codebuilder.builders.SarlFieldBuilderImpl;
import io.sarl.lang.codebuilder.builders.SarlInterfaceBuilderImpl;
import io.sarl.lang.codebuilder.builders.SarlSkillBuilderImpl;
import io.sarl.lang.codebuilder.builders.SarlSpaceBuilderImpl;
import io.sarl.lang.codebuilder.builders.ScriptBuilderImpl;
import io.sarl.lang.codebuilder.builders.TypeParameterBuilderImpl;
import io.sarl.lang.compiler.SarlCompiler;
import io.sarl.lang.controlflow.ExtendedSARLEarlyExitComputer;
import io.sarl.lang.controlflow.ISarlEarlyExitComputer;
import io.sarl.lang.controlflow.SARLEarlyExitComputer;
import io.sarl.lang.documentation.DocumentationFormatter;
import io.sarl.lang.documentation.EcoreDocumentationBuilder;
import io.sarl.lang.documentation.IDocumentationFormatter;
import io.sarl.lang.documentation.IEcoreDocumentationBuilder;
import io.sarl.lang.documentation.SarlDocumentationProvider;
import io.sarl.lang.formatting2.SARLFormatter;
import io.sarl.lang.formatting2.SARLFormatterPreferenceKeys;
import io.sarl.lang.generator.GeneratorConfigProvider2;
import io.sarl.lang.generator.IGeneratorConfigProvider2;
import io.sarl.lang.generator.SARLGeneratorConfigProvider;
import io.sarl.lang.generator.SarlOutputConfigurationProvider;
import io.sarl.lang.jvmmodel.SARLJvmModelInferrer;
import io.sarl.lang.jvmmodel.SarlJvmModelAssociations;
import io.sarl.lang.parser.SARLSyntaxErrorMessageProvider;
import io.sarl.lang.parser.antlr.SARLAntlrTokenFileProvider;
import io.sarl.lang.parser.antlr.SARLParser;
import io.sarl.lang.parser.antlr.internal.InternalSARLLexer;
import io.sarl.lang.sarl.SarlFactory;
import io.sarl.lang.scoping.SARLImplicitlyImportedFeatures;
import io.sarl.lang.scoping.SARLScopeProvider;
import io.sarl.lang.scoping.SARLSerializerScopeProvider;
import io.sarl.lang.serializer.SARLEcoreDocumentationSyntacticSequencer;
import io.sarl.lang.serializer.SARLSemanticSequencer;
import io.sarl.lang.services.SARLGrammarAccess;
import io.sarl.lang.typesystem.SARLExpressionHelper;
import io.sarl.lang.typesystem.SARLReentrantTypeResolver;
import io.sarl.lang.validation.DefaultFeatureCallValidator;
import io.sarl.lang.validation.IFeatureCallValidator;
import io.sarl.lang.validation.SARLConfigurableIssueCodesProvider;
import io.sarl.lang.validation.SARLEarlyExitValidator;
import io.sarl.lang.validation.SARLFeatureNameValidator;
import io.sarl.lang.validation.SARLValidator;
import java.util.Properties;
import org.eclipse.xtend.core.compiler.UnicodeAwarePostProcessor;
import org.eclipse.xtend.core.compiler.XtendGenerator;
import org.eclipse.xtend.core.conversion.IntUnderscoreValueConverter;
import org.eclipse.xtend.core.conversion.JavaIDValueConverter;
import org.eclipse.xtend.core.conversion.StringValueConverter;
import org.eclipse.xtend.core.conversion.XtendValueConverterService;
import org.eclipse.xtend.core.documentation.XtendFileHeaderProvider;
import org.eclipse.xtend.core.imports.XtendImportedTypesUsageCollector;
import org.eclipse.xtend.core.imports.XtendImportsConfiguration;
import org.eclipse.xtend.core.imports.XtendTypeUsageCollector;
import org.eclipse.xtend.core.linking.RuntimeLinker;
import org.eclipse.xtend.core.linking.XtendEObjectAtOffsetHelper;
import org.eclipse.xtend.core.macro.AbstractFileSystemSupport;
import org.eclipse.xtend.core.macro.JavaIOFileSystemSupport;
import org.eclipse.xtend.core.macro.declaration.IResourceChangeRegistry;
import org.eclipse.xtend.core.macro.declaration.NopResourceChangeRegistry;
import org.eclipse.xtend.core.naming.XtendQualifiedNameProvider;
import org.eclipse.xtend.core.parser.XtendPartialParsingHelper;
import org.eclipse.xtend.core.resource.XtendLocationInFileProvider;
import org.eclipse.xtend.core.resource.XtendResourceDescriptionManager;
import org.eclipse.xtend.core.resource.XtendResourceDescriptionStrategy;
import org.eclipse.xtend.core.scoping.AnonymousClassConstructorScopes;
import org.eclipse.xtend.core.typesystem.LocalClassAwareTypeNames;
import org.eclipse.xtend.core.typesystem.TypeDeclarationAwareBatchTypeResolver;
import org.eclipse.xtend.core.typesystem.XtendTypeComputer;
import org.eclipse.xtend.core.validation.CachingResourceValidatorImpl;
import org.eclipse.xtend.core.validation.XtendImplicitReturnFinder;
import org.eclipse.xtend.core.xtend.XtendFactory;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.common.types.xtext.ClasspathBasedTypeScopeProvider;
import org.eclipse.xtext.common.types.xtext.TypesAwareDefaultGlobalScopeProvider;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.impl.IDValueConverter;
import org.eclipse.xtext.conversion.impl.STRINGValueConverter;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.documentation.IEObjectDocumentationProviderExtension;
import org.eclipse.xtext.documentation.IFileHeaderProvider;
import org.eclipse.xtext.findReferences.TargetURICollector;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.formatting2.FormatterPreferenceValuesProvider;
import org.eclipse.xtext.formatting2.FormatterPreferences;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.IShouldGenerate;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.ITokenToStringConverter;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.antlr.AntlrTokenToStringConverter;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;
import org.eclipse.xtext.parser.antlr.IPartialParsingHelper;
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.LexerBindings;
import org.eclipse.xtext.parser.antlr.LexerProvider;
import org.eclipse.xtext.parser.antlr.SyntaxErrorMessageProvider;
import org.eclipse.xtext.parser.antlr.UnorderedGroupHelper;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.resource.containers.ResourceSetBasedAllContainersStateProvider;
import org.eclipse.xtext.resource.containers.StateBasedContainerManager;
import org.eclipse.xtext.resource.impl.EagerResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.IgnoreCaseLinking;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer;
import org.eclipse.xtext.serializer.tokens.SerializerScopeProviderBinding;
import org.eclipse.xtext.service.SingletonBinding;
import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.annotations.DefaultXbaseWithAnnotationsRuntimeModule;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.output.TraceAwarePostProcessor;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer;
import org.eclipse.xtext.xbase.conversion.XbaseValueConverterService;
import org.eclipse.xtext.xbase.imports.IImportsConfiguration;
import org.eclipse.xtext.xbase.imports.ImportedTypesCollector;
import org.eclipse.xtext.xbase.imports.TypeUsageCollector;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelTargetURICollector;
import org.eclipse.xtext.xbase.resource.BatchLinkableResourceStorageFacade;
import org.eclipse.xtext.xbase.scoping.XImportSectionNamespaceScopeProvider;
import org.eclipse.xtext.xbase.scoping.batch.ConstructorScopes;
import org.eclipse.xtext.xbase.scoping.batch.IBatchScopeProvider;
import org.eclipse.xtext.xbase.scoping.batch.ImplicitlyImportedFeatures;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.util.ExtendedEarlyExitComputer;
import org.eclipse.xtext.xbase.typesystem.util.HumanReadableTypeNames;
import org.eclipse.xtext.xbase.util.XExpressionHelper;
import org.eclipse.xtext.xbase.validation.EarlyExitValidator;
import org.eclipse.xtext.xbase.validation.FeatureNameValidator;
import org.eclipse.xtext.xbase.validation.ImplicitReturnFinder;

/**
 * Manual modifications go to {@link SARLRuntimeModule}.
 */
@SuppressWarnings("all")
public abstract class AbstractSARLRuntimeModule extends DefaultXbaseWithAnnotationsRuntimeModule {

	protected Properties properties = null;

	@Override
	public void configure(Binder binder) {
		properties = tryBindProperties(binder, "io/sarl/lang/SARL.properties");
		super.configure(binder);
	}
	
	public void configureLanguageName(Binder binder) {
		binder.bind(String.class).annotatedWith(Names.named(Constants.LANGUAGE_NAME)).toInstance("io.sarl.lang.SARL");
	}
	
	public void configureFileExtensions(Binder binder) {
		if (properties == null || properties.getProperty(Constants.FILE_EXTENSIONS) == null)
			binder.bind(String.class).annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).toInstance("sarl");
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessFragment2
	public ClassLoader bindClassLoaderToInstance() {
		return getClass().getClassLoader();
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessFragment2
	public Class<? extends IGrammarAccess> bindIGrammarAccess() {
		return SARLGrammarAccess.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public Class<? extends IParser> bindIParser() {
		return SARLParser.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public Class<? extends ITokenToStringConverter> bindITokenToStringConverter() {
		return AntlrTokenToStringConverter.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public Class<? extends IAntlrTokenFileProvider> bindIAntlrTokenFileProvider() {
		return SARLAntlrTokenFileProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public Class<? extends Lexer> bindLexer() {
		return InternalSARLLexer.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public Class<? extends ITokenDefProvider> bindITokenDefProvider() {
		return AntlrTokenDefProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public Provider<? extends InternalSARLLexer> provideInternalSARLLexer() {
		return LexerProvider.create(InternalSARLLexer.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public void configureRuntimeLexer(Binder binder) {
		binder.bind(Lexer.class)
			.annotatedWith(Names.named(LexerBindings.RUNTIME))
			.to(InternalSARLLexer.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public Class<? extends IUnorderedGroupHelper> bindIUnorderedGroupHelper() {
		return UnorderedGroupHelper.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.validation.ValidatorFragment2
	@SingletonBinding(eager=true)
	public Class<? extends SARLValidator> bindSARLValidator() {
		return SARLValidator.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.serializer.SerializerFragment2
	public Class<? extends ISemanticSequencer> bindISemanticSequencer() {
		return SARLSemanticSequencer.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.serializer.SerializerFragment2
	public Class<? extends ISerializer> bindISerializer() {
		return Serializer.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.formatting.Formatter2Fragment2
	public Class<? extends IFormatter2> bindIFormatter2() {
		return SARLFormatter.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.formatting.Formatter2Fragment2
	public void configureFormatterPreferences(Binder binder) {
		binder.bind(IPreferenceValuesProvider.class).annotatedWith(FormatterPreferences.class).to(FormatterPreferenceValuesProvider.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.scoping.ImportNamespacesScopingFragment2
	public Class<? extends IBatchScopeProvider> bindIBatchScopeProvider() {
		return SARLScopeProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.scoping.ImportNamespacesScopingFragment2
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE)).to(XImportSectionNamespaceScopeProvider.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.scoping.ImportNamespacesScopingFragment2
	public void configureIgnoreCaseLinking(Binder binder) {
		binder.bindConstant().annotatedWith(IgnoreCaseLinking.class).to(false);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2
	public Class<? extends IContainer.Manager> bindIContainer$Manager() {
		return StateBasedContainerManager.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2
	public Class<? extends IAllContainersState.Provider> bindIAllContainersState$Provider() {
		return ResourceSetBasedAllContainersStateProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2
	public void configureIResourceDescriptionsPersisted(Binder binder) {
		binder.bind(IResourceDescriptions.class).annotatedWith(Names.named(ResourceDescriptionsProvider.PERSISTED_DESCRIPTIONS)).to(ResourceSetBasedResourceDescriptions.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return TypesAwareDefaultGlobalScopeProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends CodeBuilderFactory> bindCodeBuilderFactory() {
		return CodeBuilderFactory.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends IDocumentationFormatter> bindIDocumentationFormatter() {
		return DocumentationFormatter.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	@SingletonBinding
	public Class<? extends IEcoreDocumentationBuilder> bindIEcoreDocumentationBuilder() {
		return EcoreDocumentationBuilder.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends IEObjectDocumentationProvider> bindIEObjectDocumentationProvider() {
		return SarlDocumentationProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends IEObjectDocumentationProviderExtension> bindIEObjectDocumentationProviderExtension() {
		return SarlDocumentationProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends ISyntacticSequencer> bindISyntacticSequencer() {
		return SARLEcoreDocumentationSyntacticSequencer.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public void configureconfigureAbstractTypeScopeProviderForSourceAppender(Binder binder) {
		binder.bind(AbstractTypeScopeProvider.class).annotatedWith(Names.named("io.sarl.lang.codebuilder.appenders.SourceAppender.providerType")).to(ClasspathBasedTypeScopeProvider.class);
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends IExpressionBuilder> bindIExpressionBuilder() {
		return ExpressionBuilderImpl.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends IBlockExpressionBuilder> bindIBlockExpressionBuilder() {
		return BlockExpressionBuilderImpl.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends IFormalParameterBuilder> bindIFormalParameterBuilder() {
		return FormalParameterBuilderImpl.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends ITypeParameterBuilder> bindITypeParameterBuilder() {
		return TypeParameterBuilderImpl.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends ISarlConstructorBuilder> bindISarlConstructorBuilder() {
		return SarlConstructorBuilderImpl.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends ISarlActionBuilder> bindISarlActionBuilder() {
		return SarlActionBuilderImpl.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends ISarlBehaviorUnitBuilder> bindISarlBehaviorUnitBuilder() {
		return SarlBehaviorUnitBuilderImpl.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends ISarlFieldBuilder> bindISarlFieldBuilder() {
		return SarlFieldBuilderImpl.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends ISarlEnumLiteralBuilder> bindISarlEnumLiteralBuilder() {
		return SarlEnumLiteralBuilderImpl.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends ISarlEventBuilder> bindISarlEventBuilder() {
		return SarlEventBuilderImpl.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends ISarlCapacityBuilder> bindISarlCapacityBuilder() {
		return SarlCapacityBuilderImpl.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends ISarlAgentBuilder> bindISarlAgentBuilder() {
		return SarlAgentBuilderImpl.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends ISarlBehaviorBuilder> bindISarlBehaviorBuilder() {
		return SarlBehaviorBuilderImpl.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends ISarlSkillBuilder> bindISarlSkillBuilder() {
		return SarlSkillBuilderImpl.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends ISarlSpaceBuilder> bindISarlSpaceBuilder() {
		return SarlSpaceBuilderImpl.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends ISarlClassBuilder> bindISarlClassBuilder() {
		return SarlClassBuilderImpl.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends ISarlInterfaceBuilder> bindISarlInterfaceBuilder() {
		return SarlInterfaceBuilderImpl.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends ISarlEnumerationBuilder> bindISarlEnumerationBuilder() {
		return SarlEnumerationBuilderImpl.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends ISarlAnnotationTypeBuilder> bindISarlAnnotationTypeBuilder() {
		return SarlAnnotationTypeBuilderImpl.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public Class<? extends IScriptBuilder> bindIScriptBuilder() {
		return ScriptBuilderImpl.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends IEarlyExitComputer> bindIEarlyExitComputer() {
		return SARLEarlyExitComputer.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	@SingletonBinding
	public SarlFactory bindSarlFactoryToInstance() {
		return SarlFactory.eINSTANCE;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends XbaseCompiler> bindXbaseCompiler() {
		return SarlCompiler.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends SARLExpressionHelper> bindSARLExpressionHelper() {
		return SARLExpressionHelper.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends IGeneratorConfigProvider2> bindIGeneratorConfigProvider2() {
		return GeneratorConfigProvider2.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends EarlyExitValidator> bindEarlyExitValidator() {
		return SARLEarlyExitValidator.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends FormatterPreferenceKeys> bindFormatterPreferenceKeys() {
		return SARLFormatterPreferenceKeys.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends ExtendedEarlyExitComputer> bindExtendedEarlyExitComputer() {
		return ExtendedSARLEarlyExitComputer.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends IJvmModelInferrer> bindIJvmModelInferrer() {
		return SARLJvmModelInferrer.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends IFeatureCallValidator> bindIFeatureCallValidator() {
		return DefaultFeatureCallValidator.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends ImplicitlyImportedFeatures> bindImplicitlyImportedFeatures() {
		return SARLImplicitlyImportedFeatures.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends ISarlEarlyExitComputer> bindISarlEarlyExitComputer() {
		return SARLEarlyExitComputer.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends JvmModelAssociator> bindJvmModelAssociator() {
		return SarlJvmModelAssociations.Impl.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends IActionPrototypeProvider> bindIActionPrototypeProvider() {
		return DefaultActionPrototypeProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends FeatureNameValidator> bindFeatureNameValidator() {
		return SARLFeatureNameValidator.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends XExpressionHelper> bindXExpressionHelper() {
		return SARLExpressionHelper.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends DefaultReentrantTypeResolver> bindDefaultReentrantTypeResolver() {
		return SARLReentrantTypeResolver.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends ConfigurableIssueCodesProvider> bindConfigurableIssueCodesProvider() {
		return SARLConfigurableIssueCodesProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends IOutputConfigurationProvider> bindIOutputConfigurationProvider() {
		return SarlOutputConfigurationProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends IContextualOutputConfigurationProvider> bindIContextualOutputConfigurationProvider() {
		return SarlOutputConfigurationProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends IGeneratorConfigProvider> bindIGeneratorConfigProvider() {
		return SARLGeneratorConfigProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends IFileHeaderProvider> bindIFileHeaderProvider() {
		return XtendFileHeaderProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends ILinker> bindILinker() {
		return RuntimeLinker.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends XbaseValueConverterService.IntUnderscoreValueConverter> bindXbaseValueConverterService$IntUnderscoreValueConverter() {
		return IntUnderscoreValueConverter.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends AbstractFileSystemSupport> bindAbstractFileSystemSupport() {
		return JavaIOFileSystemSupport.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends ImplicitReturnFinder> bindImplicitReturnFinder() {
		return XtendImplicitReturnFinder.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends STRINGValueConverter> bindSTRINGValueConverter() {
		return StringValueConverter.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends EObjectAtOffsetHelper> bindEObjectAtOffsetHelper() {
		return XtendEObjectAtOffsetHelper.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	@SingletonBinding
	public Class<? extends ISyntaxErrorMessageProvider> bindISyntaxErrorMessageProvider() {
		return SARLSyntaxErrorMessageProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends IResourceValidator> bindIResourceValidator() {
		return CachingResourceValidatorImpl.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return XtendQualifiedNameProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends ITypeComputer> bindITypeComputer() {
		return XtendTypeComputer.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends ImportedTypesCollector> bindImportedTypesCollector() {
		return XtendImportedTypesUsageCollector.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	@SingletonBinding
	public XtendFactory bindXtendFactoryToInstance() {
		return XtendFactory.eINSTANCE;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends IResourceDescription.Manager> bindIResourceDescription$Manager() {
		return XtendResourceDescriptionManager.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public void configureSerializerIScopeProvider(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(SerializerScopeProviderBinding.class).to(SARLSerializerScopeProvider.class);
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends IImportsConfiguration> bindIImportsConfiguration() {
		return XtendImportsConfiguration.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends MutableFileSystemSupport> bindMutableFileSystemSupport() {
		return JavaIOFileSystemSupport.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends IDValueConverter> bindIDValueConverter() {
		return JavaIDValueConverter.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	@SingletonBinding
	public XbaseFactory bindXbaseFactoryToInstance() {
		return XbaseFactory.eINSTANCE;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends IResourceStorageFacade> bindIResourceStorageFacade() {
		return BatchLinkableResourceStorageFacade.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return XtendValueConverterService.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends DefaultBatchTypeResolver> bindDefaultBatchTypeResolver() {
		return TypeDeclarationAwareBatchTypeResolver.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends ConstructorScopes> bindConstructorScopes() {
		return AnonymousClassConstructorScopes.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends IShouldGenerate> bindIShouldGenerate() {
		return IShouldGenerate.Always.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends TargetURICollector> bindTargetURICollector() {
		return JvmModelTargetURICollector.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	@SingletonBinding
	public Class<? extends SyntaxErrorMessageProvider> bindSyntaxErrorMessageProvider() {
		return SARLSyntaxErrorMessageProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends IDefaultResourceDescriptionStrategy> bindIDefaultResourceDescriptionStrategy() {
		return XtendResourceDescriptionStrategy.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends TraceAwarePostProcessor> bindTraceAwarePostProcessor() {
		return UnicodeAwarePostProcessor.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends IResourceChangeRegistry> bindIResourceChangeRegistry() {
		return NopResourceChangeRegistry.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public void configureIResourceDescriptions(Binder binder) {
		binder.bind(IResourceDescriptions.class).to(EagerResourceSetBasedResourceDescriptions.class);
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends JvmModelGenerator> bindJvmModelGenerator() {
		return XtendGenerator.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends TypeUsageCollector> bindTypeUsageCollector() {
		return XtendTypeUsageCollector.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends HumanReadableTypeNames> bindHumanReadableTypeNames() {
		return LocalClassAwareTypeNames.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends IPartialParsingHelper> bindIPartialParserHelper() {
		return XtendPartialParsingHelper.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends ILocationInFileProvider> bindILocationInFileProvider() {
		return XtendLocationInFileProvider.class;
	}
	
}
