package org.example

//Groovy takes the already powerful Java collections and makes their API simpler and easier.
//added a number of convenience methods
//closures as parameters
lst = [10, 20, 30, 40, 50, 60]
println lst.getClass().name
//last element
println "last element = " + lst[lst.size() - 1] //java way
println "last element = " + lst[-1] //groovy way
println lst[2..5] //java.util.RandomAccessSubList -> holds an offset into the original list!!!
lst << 7
println lst
total = 0
lst.each  {total += it} //Passing a closure as an argument
println total
println lst.collect {it * 2}

//Convenience Methods
lst = ['Programming', 'In', 'Groovy']
count = 0
lst.each { count += it.size() }
println count
//or
println lst.collect { it.size() }.sum()
//or
println lst.inject(0) { carryOver, element -> carryOver + element.size() }

lst[0] = ['Be', 'Productive'] //[["Be", "Productive"], "In", "Groovy"]
lst = lst.flatten() //["Be", "Productive", "In", "Groovy"]
println lst - ['Productive', 'In'] //["Be", "Groovy"]

println lst.collect { it.size() }
println lst*.size() //Spread operator

//--------------MAP-------------------
langs = ['C++' : 'Stroustrup', 'Java' : 'Gosling', 'Lisp' : 'McCarthy']
println langs.getClass().name
println langs['Java']
println langs.Java
println langs.'C++'
println langs.findAll { language, author -> language.size() > 3 }
println langs.any {language, author -> 
	language =~ "[^A-Za-z]" } //Does any language name have a non-alphabetic character?
println langs.every {language, author ->
	language =~ "[^A-Za-z]" } //Do all language names have a non-alphabetic character?

friends = [ briang = 'Brian Goetz', brians = 'Brian Sletten', 
	davidb = 'David Bock', davidg = 'David Geary',
	scottd = 'Scott Davis', scottl = 'Scott Leberknight', 
	stuarth = 'Stuart Halloway']
groupByFirstName = friends.groupBy { it.split(' ')[0] }
groupByFirstName.each { firstName, buddies -> println "$firstName : ${buddies.join(', ')}"}





















