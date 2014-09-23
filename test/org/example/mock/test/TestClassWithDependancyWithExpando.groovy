package org.example.mock.test;

import org.example.mock.ClassWithDependancy

class TestClassWithDependancyWithExpando extends GroovyTestCase {

	void testMethodA() {
		def fixture = new ClassWithDependancy()
		def value = "Hari"
		def myFile = new Expando(text: '', write: { text = it})
		fixture.methodA(value, myFile)
		assertEquals "Value = $value", myFile.text
	}

	//Note: Cannot use Expando to test methodB and methodC
	//Expando is useful when we pass the dependent object as parameter

	void testMethodA_Map() {
		def fixture = new ClassWithDependancy()
		def value = "Samala"
		def text = ''
		def myFileMap = [ write: { text = it} ] //---- Map
		fixture.methodA(value, myFileMap)
		assertEquals "Value = $value", text
	}
}
