package org.example.mock

class CodeWithHeavierDependencies {

	public void myMethod() {
		def value = someAction() + 10
		println value
	}

	int someAction () {
		Thread.sleep(1000)
		Math.random()
	}
}
