package org.example.dsl


class MyDateUtilityDslImpl {
	static int getDays(Integer self) {
		self
	}

	//Calendar is an interface
	//but getInstance will return implementation for java.util.GregorianCalendar
	//To make this work
	static Calendar getAgo(Integer self) {
		def calendar = Calendar.instance
		calendar.add(Calendar.DAY_OF_MONTH, -self) //subtract number of days
		calendar
	}

	static Date at(Calendar self, Map time) {
		def hour = 0
		def minute = 0
		time.each {key, value ->
			hour = key.toInteger()
			minute = value.toInteger()
		}
		self.set(Calendar.HOUR_OF_DAY, hour)
		self.set(Calendar.MINUTE, minute)
		self.set(Calendar.SECOND, 0)
		self.time
	}
}

use (MyDateUtilityDslImpl) {
	println "Now = " + Calendar.instance.time
	println "2 days ago at 4:30 = " + 2.days.ago.at(4:30)
}
