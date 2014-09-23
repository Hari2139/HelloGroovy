package org.example

//Method Synthesis by defining methodMissing in the POGO
println "Method Synthesis by defining methodMissing in the POGO -->"

class Person1 {
	def allowedGames = ['Tennis', 'BasketBall']
	
	def methodMissing(String name, args){
		println "Inside missingMethod() for $name"
		def methodInList = allowedGames.find  { it == name.split('play')[1] }
		
		if(methodInList) {
		//if(allowedGames.contains(name.split('play')[1])) {
			println "Synthesising $name..."
			
			//define a closure for injecting
			def game = { Object [] vargs -> 
				return "Playing ${name.split('play')[1]}..."
			}
			
			//Cache the injected method
			Person1.metaClass."$name" = game
			
			//Invoke the injected method
			//return Person1.metaClass.invokeMissingMethod(this, name, args)
			return game(args)
		}
		else {
			throw new MissingMethodException(name, Person1.class, args)
		}
	}
	
	static {Person1.metaClass}
}

hari = new Person1()
println hari.playTennis()
println hari.playTennis()

try {
	println hari.playFootBall()
} catch (MissingMethodException ex) {
	println ex.message
}












