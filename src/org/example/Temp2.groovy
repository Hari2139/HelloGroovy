package org.example

//result = "diff -Bb UsingGroovy.groovy TakeHelp.groovy".execute().text
String [] command = [
	'diff',
	'-Bb',
	'UsingGroovy.groovy',
	'TakeHelp.groovy',
	'>>',
	'out.txt'
]
result = command.execute().text
println result
println "\n" + new File("out.txt").text


