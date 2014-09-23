package org.example

//methods on Collections: each(), collect( ), find( ), findAll( ), any( ), and every( )
//you can also use them on any object!!
obj = 2
println obj.dump() //peek an object
obj = [1, 2, 3]
println obj.dump()
println obj.inspect() //inspect tells you what input would be needed to create an object.
//If unimplemented on a class, it simply returns what toString( ) returns.

println "\nContext method --->"
lst = [4, 5, 6]
lst.identity {
	//same as lst.with
	println size
	println contains(5)
}

//Indirect property access
println "\nIndirect property access --->"
class Car {
	int miles, fuelLevel

	def run() { println "Running...." }
	def run(int miles) { println "Running $miles miles..." }
}

Car car1 = new Car(miles: 100, fuelLevel: 1)
println "Miles = ${car1.miles}, fuel level = ${car1.fuelLevel}"
//or
println "Miles = ${car1['miles']}, fuel level = ${car1['fuelLevel']}"

properties = ['miles', 'fuelLevel']
car1[properties[1]] = 2
properties.each { name -> println "$name = ${car1[name]}" }

//Indirect method invoke
//Easier than reflections
//All objects support this
println "\nIndirect method invoke --->"
car2 = new Car()
car2.invokeMethod("run", null)
car2.invokeMethod("run", 200)

//Executing command line
println "\nExecuting command line --->"
String [] command = [
	'groovy',
	'-e',
	'print "Groovy!"'
]
println "PATH = ${System.getenv('PATH')}"
println "Calling ${command.join(' ')}"
println command.execute()
println command.execute().text

//Threads
println "\nThreads --->"
//To create a thread (no need to create an instance of 'Thread' or 'Runnable'
Thread.start {
	println "Thread created"
	sleep (2) { println "Interrupted" }
	println "Fininshed"
}
//Daemon thread -> exists only when non-daemon thread is active/alive
Thread.startDaemon {
	println "Daemon thread started"
	sleep (1) { println "Interrupted" }
	println "Daemon thread Fininshed"
}

//java.io Extensions
println "java.io Extensions --->"
new File("output.txt").withWriter { file -> file << "Hello. My name is Hari." }

println "\n" + new File("input.txt").text


