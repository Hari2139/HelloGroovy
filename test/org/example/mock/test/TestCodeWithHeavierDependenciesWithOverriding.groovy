package org.example.mock.test;

import org.example.mock.CodeWithHeavierDependencies

class TestCodeWithHeavierDependenciesWithOverriding extends GroovyTestCase {

	void testMyMethod() {
		def fixture = new CodeWithHeavierDependenciesExt()
		fixture.myMethod()
		assertEquals 35, fixture.result
	}
}

//----> extend and override
class CodeWithHeavierDependenciesExt extends CodeWithHeavierDependencies {
	def result
	int someAction()  { return 25 }
	def println(text) { result = text }
}