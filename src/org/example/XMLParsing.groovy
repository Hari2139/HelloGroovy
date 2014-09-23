package org.example

//Parsing XML (3 ways)
//1. Using DOMCategory
println "1. Parsing XML using DOMCategory --->"
document = groovy.xml.DOMBuilder.parse (new FileReader('languages.xml'));
rootElement = document.documentElement

//***** Must use 'use' with DOMCategory (`method injection`)
use(groovy.xml.dom.DOMCategory) {
	println 'Languages and Authors'
	languages = rootElement.language

	languages.each { language -> println "${language.'@name'} authored by ${language.author[0].text()}"  }

	println "------"

	def languagesByAuthor = { authorRequested ->
		languages.findAll { language ->
			language.author.any { author ->
				author.text() == authorRequested }
		}.collect {  it.'@name'}.join(", ")
	}

	//println "Languages authored by Wirth = " + languagesByAuthor('Wirth')

	authors = []
	languages.each {  language ->
		language.author.each { author ->
			author1 = author.text()
			if(!authors.any {it == author1 })  {authors << author1}}
	}

	println "Authors list = " + authors
	authors.each { println "Languages written by $it = " + languagesByAuthor(it) }
}

//////////////////////////////////////////////////////////////////////
//2. Using XMLParser
//(i) Not recommended for large document sizes (Instead use XMLSlurper).
//(ii) Does not preserve XML InfoSet.
//(iii) Ignores XML comments and processing instructions.
println "\n2. Parsing XML using XMLParser --->"
rootNode = new XmlParser().parse('languages.xml');
assert rootNode.name() == 'languages'
languages = rootNode
languages.language.each {
	println "${it.@name} authored by " + it.author.collect{it.text()}
}

//////////////////////////////////////////////////////////////////////
//3. Using XMLSlurper
//(i) Can be used on XML documents with namespaces
println "\n3. Parsing XML using XMLSlurper --->"
languages = new XmlSlurper().parse('languages.xml')
languages.language.each {
	println "${it.@name} authored by " + it.author.collect{it.text()}
}

println "\nXMLSlurper (with namespace) --->"
languages = new XmlSlurper().parse('languages_ns.xml').declareNamespace(human: 'Natural')
println "Languages = " + languages.language.collect{it.@name}
println "Natural Languages = " + languages.'human:language'.collect{it.@name}








