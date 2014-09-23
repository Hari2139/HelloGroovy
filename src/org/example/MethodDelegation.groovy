package org.example

//MethodDelegation
ExpandoMetaClass.enableGlobally()

class Worker {
	def simpleWork1(spec) { println "Worker - work1 - spec = $spec" }
	def simpleWork2() { println "Worker - work2" }
}

class Expert {
	def advancedWork1(spec) { println "Expert - work1 - spec = $spec" }
	def advancedWork2() { println "Expert - work2" }
}

class Manager {
	{ delegateCallsTo Worker, Expert, GregorianCalendar }

	def schedule() { println "scheduling..." }
}

Object.metaClass.delegateCallsTo = { Class... classOfDelegates ->
	//Create list of objects from classes
	//def objectsToDelegate = classOfDelegates.collect { it.newInstance() }
	def objectsToDelegate = classOfDelegates*.newInstance() //using spread operator

	delegate.metaClass.methodMissing = { String name, args ->
		println delegate.class.simpleName + ".$name() -> methodMissing()"

		//Find the object that can respond to the requested method
		def delegateTo = objectsToDelegate.find { it.metaClass.respondsTo(it, name, args) }

		if(delegateTo) {
			println "Found delegateTo ${delegateTo.class.simpleName} that responds to $name."
			println "Injecting $name to delegate (${delegate.class.simpleName})"

			//Inject the method in the delegate
			delegate.metaClass."$name" = { Object [] varArgs ->
				def params = varArgs?:null
				return delegateTo.invokeMethod(name, params)
			}
			return delegateTo.invokeMethod(name, args)

		} else {
			return new MissingMethodException(name, delegate.class, args)
		}
	}
}

////////
peter = new Manager()
peter.simpleWork1('fast')
peter.simpleWork1('quality')
peter.simpleWork2()
peter.simpleWork2()
peter.advancedWork1('fast')
peter.advancedWork2()
peter.advancedWork1('quality')

println "Is 2008 a leap year? " + peter.isLeapYear(2008)





