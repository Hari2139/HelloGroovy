package org.example

//MetaObjectProtocol_1
str = 'hello'
methodName = 'toUpperCase'
print "Does String respond to toUpperCase()? "
println String.metaClass.respondsTo(str, methodName) ? 'yes' : 'no'
print "Does str respond to toUpperCase()? "
println str.respondsTo(methodName)? 'yes' :' no'
println str.invokeMethod(methodName, null)

metaMethod = str.metaClass.getMetaMethod(methodName)
println metaMethod.invoke(str)
print "Does String respond to toUpperCase(int)? "
println String.metaClass.respondsTo(str, methodName, 5) ? 'yes' : 'no'

println "\nProperties of 'hello' are: "
'hello'.properties.each { println it }








