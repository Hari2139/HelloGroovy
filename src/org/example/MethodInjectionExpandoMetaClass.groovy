package org.example

//Method Injection Expando Meta Class
println "Method Injection Expando Meta Class --->"
println "Inject instance method --->"
Integer.metaClass.daysFromNow = {
	->
	Calendar today = Calendar.instance
	today.add(Calendar.DAY_OF_MONTH, delegate) //<--- delegate
	today.time
}

println "2 days from now = " + 2.daysFromNow()
//If you want to omit the parenthesis during the call, then setup a property
//by creating a method like getDaysFromToday()
//println "2 days from today = " + 2.daysFromNow

//////////////////////////////////////////////////////////
println "\nInject static method --->"
Integer.metaClass.static.isEven = { val -> val % 2 == 0 } //Note: do NOT use delegate

println "Is 2 even? " + Integer.isEven(2)
println "Is 5 even? " + Integer.isEven(5)

//////////////////////////////////////////////////////////
println "\nInject an additional constructor --->"
Integer.metaClass.constructor << { Calendar cal ->
	println "Invoking injected constructor ..."
	new Integer(cal.get(Calendar.DAY_OF_YEAR))
	//or just cal.get(Calendar.DAY_OF_YEAR) -> Groovy will autobox
}

printf "Today is %dth day of the year.\n", new Integer(Calendar.instance)

//////////////////////////////////////////////////////////
println "\nReplacing an existing constructor --->"
Integer.metaClass.constructor = { int val ->
	println "Intercepting existing constructor call ..."
	constructor = Integer.class.getConstructor(Integer.TYPE)
	constructor.newInstance(val)
}

println new Integer(4)
println new Integer(Calendar.instance)

//////////////////////////////////////////////////////////
println "\nInjecting methods into Specific Instances --->"
class Person {}

def emc = new ExpandoMetaClass(Person)
emc.sing { -> "singing..." }
emc.initialize()

hari = new Person()
jewelli = new Person()

jewelli.metaClass = emc

println "Jewelli = " + jewelli.sing()

try {
	println "Hari = " + hari.sing()
} catch (MissingMethodException ex) {
	println ex.message
}











