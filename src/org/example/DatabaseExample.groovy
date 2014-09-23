package org.example

import groovy.sql.Sql

//DatabaseExample
sql = Sql.newInstance('jdbc:mysql://localhost:3306/public',
		'root', 'passw0rd', 'com.mysql.jdbc.Driver')

println 'sql.connection.catalog = ' + sql.connection.catalog

//printf "%-20s%s\n", "City", "Temperature"
//sql.eachRow('select * from weather') {
//	printf "%-20s%s\n", it[0], it[1]
//}

rows = sql.rows('SELECT * from weather')
println "Weather info available for ${rows.size()} cites"

//Get the columns of the table at runtime
processMeta = { metaData ->
	println "Meta data: " + metaData
	metaData.columnCount.times { i ->
		printf "%-21s", metaData.getColumnLabel(i+1).toUpperCase()
	}
	println ""
}

sql.eachRow('SELECT * from weather limit 2', processMeta) {
	printf "%-20s%s\n", it[0], it[1]
}

return

/////////////////////////////////////////////
//Access Microsoft Excel
//Note: ODBC drivers from Sun are not available for OSX, so we cannot execute the following code.
println "Access Microsoft Excel --->"
sql = Sql.newInstance(
		"""jdbc:odbc:Driver={Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm, *.xlsb)};
	DBQ=/Users/Hari/Documents/GroovyAndGrails_workspace/GroovyProject1/weather.xlsx;
	READONLY=false;""", '', '', 'sun.jdbc.odbc.JdbcOdbcDriver')

println "City\t\tTemperature"
sql.eachRow('SELECT * FROM [temperatures$]') { println "${it.city}\t\t${it.temperature}"  }









