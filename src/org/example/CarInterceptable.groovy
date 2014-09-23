package org.example

//Intercepting methods using approach 1 ->
//implement GroovyInterceptable interface
//Note: This approach is NOT advisable
//(due to
//   a.we might not be the authors of the class,
//   b.we want to intercept a Java class,
//   c.we want to introduce interception dynamically)
//But if we want to apply filters - validation, verification etc., this is a good approach.
class CarIntercept implements GroovyInterceptable {

	def check() {
		System.out.println "checking..."
	}
	def start() {
		System.out.println "starting..."
	}
	def drive() {
		System.out.println "driving..."
	}

	def invokeMethod (String name, args) {
		System.out.print "Method $name is intercepted..."

		if('check' != name) {
			System.out.print "running filter..."
			CarIntercept.metaClass.getMetaMethod('check').invoke(this, null)
		}

		def validMethod = CarIntercept.metaClass.getMetaMethod(name, args)
		if(validMethod != null) {
			validMethod.invoke(this, args)
		}
		else {
			return CarIntercept.metaClass.invokeMethod(this, name, args)
		}
	}
}

car = new CarIntercept()
car.start()
car.drive()
car.check()

try {
	car.speed()
} catch (Exception ex) {
	println ex
}








