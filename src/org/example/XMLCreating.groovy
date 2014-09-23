package org.example

import groovy.xml.StreamingMarkupBuilder

//Creating XML (2 ways)
//1.
//use GStringÕs ability to embed expressions into a string +
//GroovyÕs facility for creating multi line strings.
println "\n1. Creating XML using GString --->"
langs = ['C++' : 'Stroustrup', 'Java' : 'Gosling', 'Lisp' : 'McCarthy']
content = ''

langs.each { language, author ->
	format = """
	  <language name = "${language}">
	    <author>$author</author>
	  </language>
	"""
	content += format
}

xml = "<languages>$content</languages>"

println xml

//2. Use the MarkupBuilder or StreamingMarkupBuilder
//StreamingMarkupBuilder has less memory usage (use it for larger file sizes in MB)
println "\n1. Creating XML using StreamingMarkupBuilder --->"
xml = new StreamingMarkupBuilder().bind{
	mkp.xmlDeclaration() //`mkp` is the builder support property
	mkp.declareNamespace(computer: "Computer")
	languages{
		comment << "Created using StreamingMarkupBuilder"
		langs.each { key, value ->
			computer.language(name: key) { author(value) }
		}
	}
}

println xml











