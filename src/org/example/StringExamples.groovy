package org.example

println 'He said, "That is Groovy"'
//Groovy uses lazy evaluation.
what = new StringBuffer('fence')
text = "The cow jumped over the $what"
println text
what.replace(0, 5, "moon")
println text

//special strings
println "double quote".class.name
println 'single quote'.class.name
forwardSlashString = /forward slash/
println forwardSlashString.class.name
val = "A"
println "double quote $val".class.name //--> GStringImpl
println 'single quote $val'.class.name
forwardSlashString = /forward slash $val/
println forwardSlashString.class.name //--> GStringImpl

//Lazy evaluation problem
price = 568.23
company = 'Google'
quote = "Today $company stock closed at $price"; println quote
stocks = [Apple : 130.01, Microsoft : 35.95]
stocks.each { key, value ->
	company = key
	price = value
	println quote
}
//Closures in Groovy are what help you define some code now but execute it later.
companyClosure = {it.write(company)} //or companyClosure = {-> company } This is a no-parameter closure
priceClosure = {it.write("$price")} //or priceClosure = {-> price }
quote = "Today ${companyClosure} stock closed at ${priceClosure}"
stocks.each { key, value ->
	company = key
	price = value
	println quote
}
//or better
//quote = "Today ${-> company } stock closed at ${-> price }"
//Multi line String - use ''' or """

//String Convenience Methods
str = "This is a rainy day!"
str -= "rainy "
println str
for(str in 'held'..'helf') { print "$str " }

//Regular Expressions
//JDK package java.util.regex
obj = ~"hello"; println obj.getClass().name
pattern = ~"(G|g)roovy"
text = 'Groovy is Hip'
if(text =~ pattern) { println 'match' } else { println 'NO match' } //partial match
if(text ==~ pattern) { println 'match' } else { println 'NO match' } //exact match
//The =~ operator returns a matcher object (java.util.regex.Matcher)
//If the match results in multiple matches, then the matcher contains an array of the matches.
matcher = 'Groovy is groovy' =~ /(G|g)roovy/
print "Size of matcher is ${matcher.size()} "
println "with elements ${matcher[0]} and ${matcher[1]}."
//replace
str = 'Groovy is groovy, really groovy'; println str
result = (str =~ /groovy/).replaceAll('hip'); println result










