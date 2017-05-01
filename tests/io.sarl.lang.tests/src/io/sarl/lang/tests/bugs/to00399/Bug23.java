/*
 * Copyright (C) 2014-2017 the original authors or authors.
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
package io.sarl.lang.tests.bugs.to00399;

import com.google.inject.Inject;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper;
import org.junit.Test;

import io.sarl.lang.SARLVersion;
import io.sarl.lang.sarl.SarlPackage;
import io.sarl.lang.sarl.SarlScript;
import io.sarl.tests.api.AbstractSarlTest;

/**
 * @author $Author: srodriguez$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
@SuppressWarnings("all")
public class Bug23 extends AbstractSarlTest {

	@Inject
	private CompilationTestHelper compiler;

	private String snippet = multilineString(
			"import java.util.UUID\n",
			"event AgentSpawned {",
			"  var agentID : UUID",
			"}",
			"event MyAgentSpawned extends AgentSpawned{",
			"  var titi : UUID",
			"}",
			"agent MyAgent {",
			"  on MyAgentSpawned {",
			"    System.out.println(occurrence.titi)",
			"    System.out.println(occurrence.agentID)",
			"  }",
			"}"
			);


	@Test
	public void bug23() throws Exception {
		SarlScript mas = file(snippet);
		validate(mas).assertNoErrors();
	}

	@Test
	public void myAgentSpawnedCompile() throws Exception {
		final String expectedMyAgentSpawned = multilineString(
				"import io.sarl.lang.annotation.SarlElementType;",
				"import io.sarl.lang.annotation.SarlSpecification;",
				"import io.sarl.lang.annotation.SyntheticMember;",
				"import io.sarl.lang.core.Address;",
				"import java.util.Objects;",
				"import java.util.UUID;",
				"import org.eclipse.xtext.xbase.lib.Pure;",
				"",
				"@SarlSpecification(\"" + SARLVersion.SPECIFICATION_RELEASE_VERSION_STRING + "\")",
				"@SarlElementType(" + SarlPackage.SARL_EVENT + ")",
				"@SuppressWarnings(\"all\")",
				"public class MyAgentSpawned extends AgentSpawned {",
				"  public UUID titi;",
				"  ",
				"  @SyntheticMember",
				"  public MyAgentSpawned() {",
				"    super();",
				"  }",
				"  ",
				"  @SyntheticMember",
				"  public MyAgentSpawned(final Address arg0) {",
				"    super(arg0);",
				"  }",
				"  ",
				"  @Override",
				"  @Pure",
				"  @SyntheticMember",
				"  public boolean equals(final Object obj) {",
				"    if (this == obj)",
				"      return true;",
				"    if (obj == null)",
				"      return false;",
				"    if (getClass() != obj.getClass())",
				"      return false;",
				"    MyAgentSpawned other = (MyAgentSpawned) obj;",
				"    if (!Objects.equals(this.titi, other.titi)) {",
				"      return false;",
				"    }",
				"    return super.equals(obj);",
				"  }",
				"  ",
				"  @Override",
				"  @Pure",
				"  @SyntheticMember",
				"  public int hashCode() {",
				"    int result = super.hashCode();",
				"    final int prime = 31;",
				"    result = prime * result + Objects.hashCode(this.titi);",
				"    return result;",
				"  }",
				"  ",
				"  /**",
				"   * Returns a String representation of the MyAgentSpawned event's attributes only.",
				"   */",
				"  @SyntheticMember",
				"  @Pure",
				"  protected String attributesToString() {",
				"    StringBuilder result = new StringBuilder(super.attributesToString());",
				"    result.append(\"titi  = \").append(this.titi);",
				"    return result.toString();",
				"  }",
				"  ",
				"  @SyntheticMember",
				"  private final static long serialVersionUID = -201217093L;",
				"}",
				""
				);

		this.compiler.compile(snippet, (r) -> assertEquals(expectedMyAgentSpawned,r.getGeneratedCode("MyAgentSpawned")));
	}

}
