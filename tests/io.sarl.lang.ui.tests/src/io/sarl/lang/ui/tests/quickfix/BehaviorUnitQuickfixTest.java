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
package io.sarl.lang.ui.tests.quickfix;

import org.junit.Test;

@SuppressWarnings("all")
public class BehaviorUnitQuickfixTest extends AbstractSARLQuickfixTest {

	/**
	 */
	@Test
	public void fixDiscouragedBooleanExpression() {
		assertQuickFix(io.sarl.lang.validation.IssueCodes.DISCOURAGED_BOOLEAN_EXPRESSION,
				//
				// Code to fix:
				//
				multilineString(
						"event E1",
						"agent A1 {",
						"	on E1 [true] { println(\"a\") }",
						"}"),
				//
				// Label and description:
				//
				"Remove",
				//
				// Expected fixed code:
				//
				multilineString(
						"event E1",
						"agent A1 {",
						"	on E1 { println(\"a\") }",
						"}"));
	}

	/**
	 */
	@Test
	public void fixUnreachableBehaviorUnit() {
		assertQuickFix(
				io.sarl.lang.validation.IssueCodes.UNREACHABLE_BEHAVIOR_UNIT,
				//
				// Code to fix:
				//
				multilineString(
						"event E1",
						"agent A1 {",
						"	on E1 [false] { println(\"a\") }",
						"}"),
				//
				// Label and description:
				//
				"Remove",
				//
				// Expected fixed code:
				//
				multilineString(
						"event E1",
						"agent A1 {",
						"}"));
	}

}
