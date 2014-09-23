package org.example.mock.test;

import org.example.mock.CodeWithHeavierDependencies

class TestCodeWithHeavierDependenciesWithCategory extends GroovyTestCase {

	void testMyMethod() {
		def fixture = new CodeWithHeavierDependencies()
		use(MockHelper) {
			fixture.myMethod()
			assertEquals 35, MockHelper.result
		}
	}
}

//---> define category
class MockHelper {
	def static result
	def static someAction (self) { return 25 }
	def static println(self, text) { result = text }
}