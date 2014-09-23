package org.example.mock.test;

import org.example.mock.CodeWithHeavierDependencies

class TestCodeWithHeavierDependenciesWithEMC extends GroovyTestCase {

	void testMyMethod() {
		def result
		def emc = new ExpandoMetaClass(CodeWithHeavierDependencies)
		emc.println = { text -> result = text }
		emc.someAction = { -> 25 }
		emc.initialize()

		def testObj = new CodeWithHeavierDependencies()
		testObj.metaClass = emc

		testObj.myMethod()

		assertEquals 35, result
	}
}
