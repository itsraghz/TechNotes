# Output - JSONReadExample

## `JSONExample.json` file

```
C:\rags\TechNotes\javaNotes\javaPrograms\json-to-java (master)
$ cat JSONExample.json
{
     "lastName":"Smith",
    "address":{
        "streetAddress":"21 2nd Street",
         "city":"New York",
         "state":"NY",
         "postalCode":10021
    },
     "age":25,
     "phoneNumbers":[
            {
            "type":"home", "number":"212 555-1234"
            },
         {
            "type":"fax", "number":"212 555-1234"
         }
     ],
     "firstName":"John"
}
```

## Terminal Output for the Java Program

```
C:\rags\TechNotes\javaNotes\javaPrograms\json-to-java (master)
$ java -cp json-simple-1.1.1.jar;. JSONReadExample
John
Smith
25
streetAddress : 21 2nd Street
city : New York
postalCode : 10021
state : NY
number : 212 555-1234
type : home
number : 212 555-1234
type : fax

```
