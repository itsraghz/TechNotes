# Python Notes

## Reference URLs

  * https://www.learnpython.org/

## Basics 

  * `print` - was a statement in Python2 whereas it is a function in Python3. It must be invoked with a parantheses. like, `print("Hello World!");`
  * Python uses indentation for blocks, instead of curly braces. Both tabs and spaces are supported, but the standard indentation requires standard Python code to use four spaces.
  *  You can check the version of python using `python --version` in the command line or the terminal. 
     ```
     ¿ python --version
     Python 3.8.0
     ```

## Variables
  
  * Python is completely object oriented, and not "statically typed". You do not need to declare variables before using them, or declare their type. Every variable in Python is an object.

## f-String

  * String or Variable Interpolation is possible through the new `f` formatting specifier in Python3. 
  * Python 3.6 added new string interpolation method called literal string interpolation and introduced a new literal prefix f. This new way of formatting strings is powerful and easy to use. It provides access to embedded Python expressions inside string constants.
  * Example: 
  	```
	name = 'World'
	program = 'Python'
	print(f'Hello {name}! This is {program}')
	```
  * Output : 
  	```
	 Hello World! This is Python
	```
## PEP8 style conversion

  * Python scripts at times have an error on the console while running the scripts stating that `Incosistent use of tabs and spaces in indentaion`. For which an easy waay to use a tool called [*`autopep8`*](https://pypi.org/project/autopep8/) which is an utility to be installed separately using the `pip`. 
  * Command to use `autopep8 -i <python_script.py>`
  * Example: 
     ```
     C:\rags\TechNotes\pythonNotes\samplePgms\util (master)
     ¿ autopep8 -i employee_password_encrypt.py

     C:\rags\TechNotes\pythonNotes\samplePgms\util (master)
     ¿
     ```
  * Command to install the `autopep8` is : `pip install --upgrade autopep8`

