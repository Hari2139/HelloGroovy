package org.example

//Method Injection using Category
println "Method Injection using Category --->"
println "StringUtilCategory --->"
class StringUtilCategory {
	def static toSSN(self) {
		if(self.size() == 9) {
			"${self[0..2]}-${self[3..4]}-${self[5..8]}"
		}
	}
}

use(StringUtilCategory) {
	println "123456789".toSSN()
	println new StringBuilder("987654321").toSSN()
}

try {
	println "123456789".toSSN()
} catch (MissingMethodException ex) {
	println ex.message
}

//similar to the following call
println StringUtilCategory.toSSN("647920312")

////////////////////////////////////////
println "\nFindUtil --->"
class FindUtil {
	def static extractOnly (self, closure) {
		def result = ''
		self.each {
			if(closure(it)) { result += it }
		}
		result
	}
}

use (FindUtil) {
	println "123549995".extractOnly { it == '4' || it == '5'} //should print 545
}











