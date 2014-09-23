package org.example;

import org.codehaus.groovy.runtime.typehandling.NumberMath

class ExpectException extends GroovyTestCase {

	void testException () {
		shouldFail(ArithmeticException) { NumberMath.divide(2,0) }
	}
}
