package org.example

println "Hello"
println 1.1.class.name //1.1 is BigDecimal
println 2.class.name //2 is Integer
println 1..8
//-----------------------------------------------
ArrayList<String> list = new ArrayList<String>();
Collection<String > coll = list;
list.add("one");
list.add("two");
list.add("three");
list.remove(0); //remove (int index)
coll.remove(0); //remove (Object o) --> But groovy treats it as above

println 'List size = ${list.size} --> Single quotes do NOT evaluate expressions'
println "List size = ${list.size}"
println "Collection size = ${coll.size}"
//-----------------------------------------------
println '-----> Operator Overloading'
println 'a'..'g' //This operator maps to the next() method on the String class.
lst = ['hello'] //ArrayList overloading
lst << 'there' //add an element to a collection
println lst
//You can use annotations in Groovy, but you canÕt define new annotations.
//The Groovy compiler does not, however, use the Java annotations like @Deprecated and @Override.
//-----> Static import
//import static Math.random as rand
//import groovy.lang.ExpandoMetaClass as EMC
println '-----> Closures'
def pickEven (n, closure) { //function that allows you to simply pick even numbers.
	for (int i =2 ; i<=n; i+=2) {
		closure(i);
	}
}

pickEven(10, {print it})
//pickEven (10) {print it} //same as above, If a closure is the last argument
//pickEven(10) { evenNumber -> println evenNumber } //same as above
total = 0
pickEven(10) {total += it}
println "\nSum of even numbers = ${total}"







