// Date - class in java.util, java.sql in Java
// different date values based on Calendars, Timezones etc., 

// Groovy offers the java.util classes by default in any Groovy Script
def today = new Date()
println today // Sun Jan 10 10:38:56 IST 2021


// what if we want to customize the format/output, like you only want the date ? Or the time? or the timezone? etc.,
// You have something called DateFormat
// DateFormat is a class - in java.text package (Abstract Class)
// We use SimpleDateFormat in Java in the same java.text package as a default implementation class shipped along with the JDK.
// https://docs.oracle.com/javase/7/docs/api/java/text/DateFormat.html
// https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html


// *************************************************************************************
// 1. From Date Object to different representation/style for retreival/printing --> format()
// 2. From a Date in Text/Input to a Date Object in runtime --> parse()
// *************************************************************************************

import java.text.SimpleDateFormat

def datePattern = "YYYY-MM-DD"
def sdfDate = new SimpleDateFormat(datePattern)
println sdfDate
def dateAlone = sdfDate.format(today)
println "DatePattern : [" + datePattern + "], date formatted : " + dateAlone

def formatDate(date, pattern)
{
    new SimpleDateFormat(pattern).format(date)
}

println formatDate(today, datePattern)

def timePattern = "HH:mm:ss:S a z Z"
println formatDate(today, timePattern)

////////////////////////////////////////////////////////////////

sdfDate.getMetaClass().getMethods().each {
    if(it.name.contains('parse')){
        println it
    }
}

//public java.util.Date java.text.DateFormat.parse(java.lang.String) throws java.text.ParseException
// Takes a String, gives you back a Date object

// NOTE: The format should be in exact sync between the actual date Input and the pattern we specify including the separator
// else, the parse() or format() methods will throw an error stating -> Unparseable date

def dateInString = "2021-03-31"
datePattern = "yyyy-MM-dd"
def dateTimePattern = "yyyy-MM-dd HH:mm:ss"
def sdfParseSimple = new SimpleDateFormat(datePattern)
def parsedDate = sdfParseSimple.parse(dateInString)
println "parsedDate :: " + parsedDate
sdfParseSimple = new SimpleDateFormat(dateTimePattern)
def formattedDateTime = sdfParseSimple.format(today)
println "formattedDateTime :: " + formattedDateTime


/* -------------------------------------------------- */
/*           Shyam - Realtime Exercise                */
/* --------------------------------------------------- */
Date dateObj = new Date()
println dateObj.getClass()

dateObj.getMetaClass().getMethods().each {
    if(it.name.contains('parse')){
        println it
    }
}


//def ccStartDate = Date.parse("yyyy-MM-dd'T'HH:mm:ss", c.startDate[0].text().toString()).format("yyyy-MM-dd");

// Recieve the input date in the exact format -> yyyy-MM-dd'T'HH:mm:ss
// Then parse the date value from c.startDate[0] - to get the Date Object
// finally, you format the date object with ONLY the date component -<> format('yyyy-MM-dd')

println ""

def exerciseDateToday = new Date()
println exerciseDateToday
def exerciseDatePattern = "yyyy-MM-dd"

def exerciseSDF = new SimpleDateFormat(exerciseDatePattern)
def exerciseDateAlone = exerciseSDF.format(exerciseDateToday)
println "exerciseDateAlone : "+ exerciseDateAlone
println "exerciseDateAlone of type : " + exerciseDateAlone.class

exerciseSDF.getMetaClass().getMethods().each {
    if(it.name.contains('format')){
        println it
    }
}

/* Exercise Objective 
    Input : comes in Date and Time
    Output: Need only in Date (DateAlone)
    
    Format method Syntax : public final java.lang.String java.text.DateFormat.format(java.util.Date)
    Takes a Date object and gives a String
*/
def execiseDateTimeStr = "2021-01-10 11:25:00"
def exerciseDateTimePattern = "yyyy-MM-dd HH:mm:ss"
//exerciseDateTimePattern = "yyyy-MM-dd" // works fine, takes the 00:00:00 for time
//exerciseDateTimePattern = "yyyy MM dd" // will NOT work, pattern format mismatch for date value [Error: Unparseable date: "2021-01-10 11:25:00"]
// Until I change the value, OR there is a change in the actual input value.
//execiseDateTimeStr = "2021 01 10 11:25:00"
def exerciseSDFDateTimeObj = new SimpleDateFormat(exerciseDateTimePattern)
def parsedExerciseDateTime = exerciseSDFDateTimeObj.parse(execiseDateTimeStr)
println parsedExerciseDateTime
