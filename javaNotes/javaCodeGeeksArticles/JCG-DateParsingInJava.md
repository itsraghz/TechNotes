# Date Parsing in Java with Examples

## Agenda

I. Introduction
   A. Importance of sorting date strings in Java
   B. Overview of the article's purpose and content

II. Understanding Date Strings in Java
   A. Explanation of date strings and their formats
   B. Common date string formats in Java
   C. Examples of date strings

III. Converting Date Strings to Java Date Objects
   A. Using SimpleDateFormat class to parse date strings
   B. Handling different date formats and patterns
   C. Converting date strings to Java Date objects

IV. Sorting Date Strings

V. Example Code for Sorting Date Strings
   A. Step-by-step example of sorting date strings in Java
   B. Code snippets illustrating the process

VI. Handling Invalid Date Strings
   A. Dealing with invalid or malformed date strings
   B. Exception handling techniques

VII. Best Practices for Sorting Date Strings

VIII. Conclusion

## Introduction

### Importance of Date Components and Sorting them

As part of the data manipulation, *Date* plays a very important role to represent the date of an entity in any Application - irrespective of its size.

We usually prefer the `java.util.Date` to represent the Date values for capturing the various relevant attributes

* Date of Birth of an Employee, Student, Customer etc.,
* Date of Joining - for a Job / Institution
* Date an Order was placed and despatched in an E-Commerce Application
* Date when an Issue was raised/closed in a Ticket Management System etc.,

> Note: For certain events like placing an Order, raising an issue etc., we would prefer the *Time* component as well to make it very precise. However, considering the scope of this article, we don't get into the Time components instead we focus only on the Date.

As part of the data manipulation, we often need to compare the two different dates to evaluate the difference and take any business decisions, like the scenarios listed below.

* To measure the SLA (Service Level Agreements): If we find the difference between Issue Closed and Issue Raised , we find compute the total time taken to resolve an issue which can be measured against the agreed upon SLA with a customer.  
* For a meaningful Business Validation: The From and To dates when captured for an Event Management or a Ticket Booking System, the To date should be futuristic and it should NOT be earlier than the present date and/or the From Date. It is possible only when we compare the two different date values.
* To compute the financials : For a Payroll Management Application, the number of dates worked by an employee matters for calculating the appropriate wages, for which we need to calculate the Starting and End dates.

### Overview of the Article

In this article, we will see how we will store the Date values and how do we transform the representation of a Date value to and from a String format, and how do we perform the computation for finding out the difference between two dates etc., for the better business decisions.

## Understanding Date Strings in Java

Let us understand how a `Date` value is represented in the Java Language.

In Java, a date value can be represented in two different fashions.

* Literal String - Example: '2023-06-16' (16 Jun 2023) where we mention it as a String (simply, mention inside a set of double quotes), and it is mostly preferred while displaying the value to the User - in the UI Pages or the reports etc.,
* Date Object - An object of the `Date` class defined in the `java.util` package, that has several components and sub-components of a Date value, and also certain useful methods for manipulating the individual components.

In General, a `Date` object contains the following components which are most widely used in the Application that focus on the proper Date value and structure.

* The actual date - `DD/MM/YY` (where DD is the date, MM is the month, and YYYY is the Year) - it is what most of us focus in the beginning
* The time value - `HH:mm:ss` (Example: 07:59:00)
* The `AM/PM` (Anti-Meridian, Post-Meridian) component / Marker (Example: 07:59:00 AM with the AM/PM marker, OR 19:59:00 without the AM/PM marker)
* `Timezone` - where the underlying System is running (`UTC`, `GMT`, `EST`, `IST`, `PST`, `CET` etc., - Universal Coordinated Time, Greenwich Mean Time, Eastern Standard Time, Indian Standard Time, Pacific Standard Time, Central European Time)

### Explanation of date strings and their formats

As you might have guessed, when we have several components taking place in a single Date value, we have a format to represent which components we are interested in dealing with a Date.

As you have seen in the previous section, we have seen different components - which all put together make a Date format. A few examples are given below.

* `DD-MM-YY` - The simplest Date value possible with just the vital components - Date, Month and Year each represented by two digits. Example:  *16-06-23*.
* `DD-MM-YYYY` - The simplest but a bit extended Date format where we represent the year in full (4 digits). Example: *16-06-2023*.
* `HH:mm:ss` - Not so commonly used format just to represent the time components of Hours, Minutes and Seconds. Preferred *only* when you are looking for the time components and _not_ the dates. May fit in the data which all happens in the same day where the focus is ONLY on the time, as all of them are part of the same date. For example, we would like to capture the activities of the (same) day in a journal but at different times.

### Common date string formats in Java and the examples

There are certain Date formats which are commonly used in the Date API of Java, and they are given below.

* ISO 8601 Date Format (`YYYY-MM-DD`).
	- Example: *2023-05-30*
	- This format represents the date with the year, month, and day in a specific order, separated by hyphens. It is widely used and recommended for its clarity and unambiguous nature.
* Standard Date Format (`EEE MMM dd HH:mm:ss zzz yyyy`)
	- Example: *Mon Jun 12 13:50:01 IST 2023*
	- This format includes the day of the week (EEE), the month (MMM), the day of the month (dd), the time in 24-hour format (HH:mm:ss), the timezone (zzz), and the year (yyyy). It is commonly used in some legacy systems or when dealing with date strings in specific formats.
* Short Date Format (`MM/DD/YYYY`)
	- Example: *06/06/2022*
	- This format represents the date with the month, day, and year separated by slashes. It is commonly used in the United States and other regions that follow a similar convention.
* Long Date Format (`MMM dd, yyyy`)
	- Example : *Jun 16, 2023*
	- This format represents the date with the month spelled out completely, followed by the day of the month and the year. It provides a more descriptive representation of the date and is commonly used in formal contexts.
* Custom Format
	- Example #1: *2023-06-16 23:11:02*
	- In addition to the standard formats mentioned above, custom formats can be defined using a combination of letters and symbols. For example, "yyyy-MM-dd HH:mm:ss" represents the date and time in the ISO 8601 format with hours, minutes, and seconds.
	- Example #2: *2023-Jun-16 04:28:00 PM IST Fri*
	- It is my personal favorite custom format to represent the Date String, where we have almost all the required components, including the Month represented in Wordings than in numbers - which may otherwise be confusing between MM/DD OR DD/MM when just represented as numbers.

## Converting Date Strings to Java Date Objects

Wheneve we receive an User Input to an Application, the input is usually captured in the String format (the literal value in double quotes), without the semantics of the various date components what we discussed earlier. It is alright, if we wish to retain the input value as a plain String as it is, however it may not be of any help if we want to perform any computation on the Date components - like difference between two dates, because they are just in a String format, and we don't have a way to substract a string from another (for the EndDate minus FromDate to calculate the number of days an employee has worked in a month, for example).

So it is pretty obvious that we need to transform the input from the String (`java.lang.String`) representation a Date format (an instance of `java.util.Date`), much similar to how we convert a String to a numeric - in any of the `Integer.parseInt(str)`, `Double.parseDouble(str)` etc., defined in the `java.lang` pacakge.

Know the Jargons:

* *Parsing* : Technically, the transformation of data from a raw type / literal String to the actual intended data type is called *Parsing*. We will see how we can actually parse a String to a Date value.

* *Formatting* : Likewise, when we do the reverse, when converting a Date object to a String, it is called as *formatting*.

### Using SimpleDateFormat class to parse date strings

One of the oldest and the simplest way, as it its name implies, is the `SimpleDateFormat` class which is defined in the package `java.text`, and the FQCN (Fully Qualified Class Name) is `java.text.SimpleDateFormat`.

The `SimpleDateFormat` is an extension of `DateFormat` which is an abstract class defined in the same package `java.text` and has all the constants required to construct a Date. It has also the most used method `parse()` that takes a `String` input and returns a `Date` object, matches with our requirement.

As `DateFormat` is an abstract class, we can't work with it directly, instead we use its subclass - `SimpleDateFormat` by passing in the required pattern (format to interpret the String as a Date) in the Constructor.

Let us take a simple example to convert a String to a Date using `SimpleDateFormat` class.

```java
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class SimpleDateFormatExample
{
    public static void main(String... args)
    {
        System.out.println("SimpleDateFormatExample - main()");
        String dateInStr = "2023-06-17";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateObj = null;
        try {
            dateObj = sdf.parse(dateInStr);
        } catch(ParseException parseException) {
            System.err.println("ParseException occurred while parsing a String to a Date");
            System.err.println("Error Message : " + parseException.getMessage());
        }

        System.out.println("Input - Date in String : " + dateInStr);
        System.out.println("Output - Date Object parsed : " + dateObj);
    }
}
```

The program is straight forward where we

* Import the required classes from `java.util.Date` package.
* Instantiate the `SimpleDateFormat` class with the required _pattern_ to manipulate the date object.


Compiling and Executing the program gives the following output.

```sh
➜  $ javac SimpleDateFormatExample.java
➜  $ java SimpleDateFormatExample
SimpleDateFormatExample - main()
Input - Date in String : 2023-06-17
Output - Date Object parsed : Sat Jun 17 00:00:00 IST 2023
➜  $
```

### Handling different date formats and patterns

The `SimpleDateFormat` class has a set of overloaded constructors which helps us pass a different set of inputs that would govern the parsing of a `String` to a `Date`.

The set of overloaded constructors are given below for a quick reference.

| Constructor | Description |
| --------- | ------------- |
| `SimpleDateFormat()` | Constructs a SimpleDateFormat using the default pattern and date format symbols for the default FORMAT locale. |
| `SimpleDateFormat(String pattern)` | Constructs a SimpleDateFormat using the given pattern and the default date format symbols for the default FORMAT locale. |
| `SimpleDateFormat(String pattern, DateFormatSymbols formatSymbols)` | Constructs a SimpleDateFormat using the given pattern and date format symbols. |
| `SimpleDateFormat(String pattern, Locale locale)` | Constructs a SimpleDateFormat using the given pattern and the default date format symbols for the given locale. |

Mostly we would use the 2nd flavor - `SimpleDateFormat(String pattern)` where we would be interested in the pattern, and letting it work with the default `Locale`.

The different but most widely used patterns are given below.

| Date and Time Pattern |	Result |
| --------------- | ----------- |
| `yyyy.MM.dd G 'at' HH:mm:ss z` | 2001.07.04 AD at 12:08:56 PDT |
| `EEE, MMM d, ''yy` | Wed, Jul 4, '01 |
| `h:mm a` | 12:08 PM |
| `hh 'o''clock' a, zzzz` | 12 o'clock PM, Pacific Daylight Time |
| `K:mm a, z` | 0:08 PM, PDT |
| `yyyyy.MMMMM.dd GGG hh:mm aaa` | 02001.July.04 AD 12:08 PM |
| `EEE, d MMM yyyy HH:mm:ss Z` | Wed, 4 Jul 2001 12:08:56 -0700 |
| `yyMMddHHmmssZ` | 	010704120856-0700 |
| `yyyy-MM-dd'T'HH:mm:ss.SSSZ` | 2001-07-04T12:08:56.235-0700 |
| `yyyy-MM-dd'T'HH:mm:ss.SSSXXX` | 2001-07-04T12:08:56.235-07:00 |
| `YYYY-'W'ww-u` | 2001-W27-3 |

*Sample Program with different date patterns*


```java
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class TryingOutDatePatterns
{
    public static void main(String... args)
    {
        String[] dateArray = new String[]{"2023-07-11", "2023-Jul-11"};
        String[] patternArray = new String[]{"yyyy-MM-dd", "yyyy-MMM-dd"};
        SimpleDateFormat sdf = null;
        Date dateObj = null;
        
        for(int i=0; i < dateArray.length; i++) 
        {
            System.out.println("Date : " + dateArray[i] + " | pattern : " + patternArray[i]);
            sdf = new SimpleDateFormat(patternArray[i]);        
            
            try {
                dateObj = sdf.parse(dateArray[i]);
            }catch(ParseException parseException) {
                System.err.println("Exception occurred while parsing a Date from String");
                System.err.println("Error Message : " + parseException.getMessage());
            }
            System.out.println("Date Object parsed with the pattern [" + patternArray[i] + "] : " + dateObj);
        }
    }
}
```

*DateFormatSymbols* is a public class for encapsulating localizable date-time formatting data, such as the names of the months, the names of the days of the week, and the time zone data. `SimpleDateFormat` uses `DateFormatSymbols` to encapsulate this information.

Typically you *shouldn't use DateFormatSymbols directly*. Rather, you are encouraged to create a date-time formatter with the DateFormat class's factory methods: `getTimeInstance`, `getDateInstance`, or `getDateTimeInstance`. These methods automatically create a `DateFormatSymbols` for the formatter so that you don't have to. 

> Note: The different `DateFormatSymbols` can be looked at here - [https://docs.oracle.com/javase/8/docs/api/java/text/DateFormatSymbols.html](https://docs.oracle.com/javase/8/docs/api/java/text/DateFormatSymbols.html)

### Converting date strings to Java Date objects

Now that we have seen

### Best Practices

*Synchronization*

Date formats are not synchronized. It is recommended to create separate format instances for each thread. If multiple threads access a format concurrently, it must be synchronized externally.

## Sorting Date Strings

## Example Code for Sorting Date Strings

### Step-by-step example of sorting date strings in Java

### Code snippets illustrating the process

## Handling Invalid Date Strings

### Dealing with invalid or malformed date strings

### Exception handling techniques

### Best Practices for Sorting Date Strings

### Conclusion

## References

* https://docs.oracle.com/javase/8/docs/api/java/util/Date.html
* https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
* https://docs.oracle.com/javase/8/docs/api/java/text/DateFormat.html
*
## Rough


Until Java 8, this was the most popular choice.

From Java 8 onwards, we have a new class named `DateTimeFormatter`, introduced in the totally brand new package called `java.time` and a specialized package of it - `java.time.format`.  Hence the FQCN (Fully Qualified Class Name) is `java.time.format.DateTimeFormatter`.
