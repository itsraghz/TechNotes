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
  * Python variables are dynamically typed. Meaning ,they get a datatype during the runtime depending on the value they are assigned with.
  * The following code snippet shows the dynamic data type allocation in action.
```
C:\Users\ragha\.jupyter {git}{hg}
{lamb} python
Python 3.8.0 (tags/v3.8.0:fa919fd, Oct 14 2019, 19:37:50) [MSC v.1916 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license" for more information.
>>> y = 10
>>> type(y)
<class 'int'>
>>> y =  y - 10.0
>>> y
0.0
>>> type (y)
<class 'float'>
>>>
```
 * Reassigning variables in terms of themselves. Use `+=` shorthand operator to assign the value of the variable to itself after the operation being performed (here it is an addition). Example: `x += 1` is equivalent to `x = x + 1`.
 * Variable naming convention is recommended to have an indicative of their meaning/purpose like `name`,`age` etc., than just a short form of `x`, `y` etc.,
 * There are a few restrictions on the naming conventions. A variable in Python can*not* start with _numbers_, _most_ special characters, _keywords_, or _built-in types_. Variables also can't contain spaces in between if it has more than one word. Example: `my name` is not a valid name, rather it can be given as `my_name`. 
 * According to Python conventions, it's best to use lowercase letters and to avoid special characters altogether as they will often cause errors.

### Keywords

 * Keywords are the reserved words that have a special meaning to the compiler and they can't be used for the other/normal variables in a Python program/script. For exaample, `int` is a special word (reserved word or a keyword) that indicates that the variable following will have a numeral value associated with it. 
 * To get to know the list of keywords in the currently running version of python, you can use the following code snippet.*Note*: `keyword` is a module (a different pacckage that contains the variable `kwlist`) and it is not by default (naturally) available in your current Python script. Hence, it needs to be expliciltly made available (hence the name *import*) via the keyword `import`.

 ```
import keyword
print (keyword.kwlist)
 ```
 You get the following output.
 ```
['False', 'None', 'True', 'and', 'as', 'assert', 'async', 'await', 'break', 'class', 'continue', 'def', 'del', 'elif', 'else', 'except', 'finally', 'for', 'from', 'global', 'if', 'import', 'in', 'is', 'lambda', 'nonlocal', 'not', 'or', 'pass', 'raise', 'return', 'try', 'while', 'with', 'yield']
 ```

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

