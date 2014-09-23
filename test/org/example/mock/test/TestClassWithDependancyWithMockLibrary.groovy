package org.example.mock.test;

import groovy.mock.interceptor.MockFor
import groovy.mock.interceptor.StubFor

import org.example.mock.ClassWithDependancy

class TestClassWithDependancyWithMockLibrary extends GroovyTestCase {

	void testMethodB_StubFor() {
		def fixture = new ClassWithDependancy()
		def value = "Hari"
		def myFileStub = new StubFor(FileWriter)
		def text = ''
		myFileStub.demand.write  { text = it }
		myFileStub.demand.close {}

		myFileStub.use { fixture.methodB(value) }

		assertEquals "Value = $value", text
	}

	//This test should fail, because we demanded that 'close' be called
	//on the file writer, but methodB did not close the fileWriter
	void testMethodB_MockFor() {
		def fixture = new ClassWithDependancy()
		def value = "Hari"
		def myFileStub = new MockFor(FileWriter)
		def text = ''
		myFileStub.demand.write  { text = it }
		myFileStub.demand.close {}

		myFileStub.use { fixture.methodB(value) }

		assertEquals "Value = $value", text
	}

	//This test should pass, because we closed the fileWriter
	void testMethodC_MockFor() {
		def fixture = new ClassWithDependancy()
		def value = "Hari"
		def myFileStub = new MockFor(FileWriter)
		def text = ''
		myFileStub.demand.write  { text = it }
		myFileStub.demand.close {}

		myFileStub.use { fixture.methodC(value) }

		assertEquals "Value = $value", text
	}
}
