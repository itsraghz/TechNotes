# Console Output for the simple way of loading a property file

Does not work as suggested in the stackoverflow website [Properties file in python (similar to Java Properties)] (https://stackoverflow.com/a/8220790/1001242) - as follows.

  * Rename the `.properties` file to `.py` file
  * import the file on top of your python script
  * Print the property directly with reference to the imported script name

## Console Output

```
C:\rags\TechNotes\pythonNotes\samplePgms\io\propertiesFile (master)                                      
¿ python 1_props_file_simple.py                                                                          
Traceback (most recent call last):                                                                       
  File "1_props_file_simple.py", line 3, in <module>                                                     
    import dbProps                                                                                       
  File "C:\rags\TechNotes\pythonNotes\samplePgms\io\propertiesFile\dbProps.py", line 3, in <module>      
    dbName = PYTHON_MYSQL_DEMO                                                                           
NameError: name 'PYTHON_MYSQL_DEMO' is not defined                                                       
                                                                                                         
C:\rags\TechNotes\pythonNotes\samplePgms\io\propertiesFile (master)                                      
¿                                                                                                      
```
