package org.example.mock

class ClassWithDependancy {

	def methodA (val, file) {
		file.write ("Value = $val")
	}

	def methodB (val) {
		def file = new FileWriter("output.txt")
		file.write ("Value = $val")
	}

	def methodC (val) {
		def file = new FileWriter("output.txt")
		file.write ("Value = $val")
		file.close()
	}
}
