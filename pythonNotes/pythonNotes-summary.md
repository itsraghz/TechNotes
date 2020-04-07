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
### Operators

  Apart from the standard operators for addition (`+`), substraction (`-`), multiplication (`*`), division (`/`), and modulus (`%`), Python offers a few more as follows. 

  * Integer Division - `//`. As the division operator (`/`) always returns a decimal value (float), the Integer division helps to get the whole number.
  * Exponentiation - `**`. An easy alternative for the `math.pow()`, which does the same thing. Example: `5 ** 2` gives the value of 25, which is `5 raised to the power of 2`. 
  * Order of operations - Parentheses are meaningful in Python. When it comes to computation, Python always computes what is in parentheses first.
  * Evaluation Rule - Similar to `BODMAS`, Python follows a different rule - *PEMDAS* - parentheses first, exponentiation second, multiplication/division third, and addition/subtraction fourth.
  
### Whitespaces

 * In Python, spaces after a number or symbol do not carry any meaning. So, `5**3` and `5 ** 3` both result in 125.
 * Spaces are meant to enhance readability. Although there is no correct way to space code, spaces are generally encouraged between operands and operators. 
 * Thus, `5 ** 3` is _preferable_.

### Variables
  
  * Python is completely object oriented, and not "statically typed". You do not need to declare variables before using them, or declare their type. Every variable in Python is an object.

### Data types

#### Numeric Types 

 * 8 and 8.0 - is equivalent in Mathematics (represent the same value but in different types) but *not* in Programming languages like Python. 
 * Integer - a whole number both positive and negative, including zero (0). Represented as `int`. Examples: 3, -2, 0 and 1000.
 * Float - rational numbers expessed as fractions (decimal point). Represented as `float`. Example: 3.0, -2.0, 47.45 and 200.001.
 * Python types can be obtained explicitly by using `type()` with a value inside it as a parameter. Example: `type(10)` gives `int`.
 * Any mathematical operations on {int, float} (example: int + flat) gives a `float`, otherwise the information/data will be lost. When possible, Python converts types to preserve information. Example : `5 + 3.14` gives `8.14` and NOT `8`.
 * Conversion: The datatype / value can be converted from one to another using an appropriate method whose name bears the datatype. Example: `int(7.99999)` gives the floating value as an integer as `7`. Similarly, `float(6)` gives back `6.0`.
 * 

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

