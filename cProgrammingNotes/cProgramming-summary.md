# C Programming Notes

## Basics

 * Take an example of adding a few numbers and produce a sum. 
  * Adding 4 to 5 numbers, can be easily done by a human being as it is easy to store and process the data and produce a result quickly.
  * Adding 20 or more numbers, can still be possible but will need a longer time to store and process the data and it may also be error prone (possibilities of making a mistake is more).
 * Need of a Computer (which is an extension of a calculator) for the following two main reasons
  * Speed of execution (human can still do but need more time for large set of data)
  * To avoid errors (human can make mistakes - most likely when dealing with large data whereas a Computer will not mostly make any mistakes)
  * Like how a human body is having a lot of parts like, `eyes`, `ears`, `heart`, `hands` and `legs` which all are interconnected and controlled by a central authority called `Brain`, a Computer also has several different parts like `Memory`, `ALU` (Arithmetic Logic Unit) etc, which are all interconnected and controlled by a central authority called `CPU` (Central Processing Unit).
 * Computer is a *dumb terminal* or a *stupid device* as it does *NOT* have any thinking capability on its own and it needs to be _instructed_ step by step of its execution via a Program ,which is the step by step instruction of a bigger task to be carried out. Example: Addition of 25 numbers.
 * Human to Computer Interaction
  * Human speak *Regional/Spoken Languages* like `Tamil`, `English`, `Hindi`, `French` etc., to communicate with each other using the language as a communication tool. Likewise we use the *Programming Languages* like `C`, `C++`, `Java`, `PHP`, `Python` etc., to communicate with the Computer by specifying the Command/Instruction to the Program to be executed. These languages are close the human being and hence they are called as *High Level Language*.
  * Though we human speak the Regional languages with each other and use Programming Languages to specify the instruction to the Computer,a computer can only undrestand the machine language - which is also called as *Binary* (a `0` or `1`). This is close to the machine and hence it is called *Low Level Language*.
  * The programs we write in the high level languages need to be translated to the computer in a way it can understand (High Level to Low Level) and this *important phase* is called *Compilation*.
  * Later the compiled form of the source code is executed by the appropriate tool for the programming language being used. 

## History

 * C Programming Language was introduced by Dennis Ritchie in the Bell Labs in the  year 1971.
 * It had a good support for the *System Level Programming* due to its support to the kernel resources.
 * It is called as `middle level` language because of its support to both `High Level` and `Low Level` languages.

## Anatomy (Structure) of a C Program

 * The file name should be having an extension `.c`. *Example:* `HelloWorld.c`
 * Every executable statement should _end with a *semicolon*_ (`;`). It is similar to a `fullstop` in a English sentence which help us understand the end of a sentence. Likewise a Computer can easily understand the different statements with the help of this puncutation - semicolon. 
 * The main entry point of the program is the *main* method whose syntax / grammar is `int main()` and it has got a set of *curly braces* (opening - `{` and ending - `}`) to identify the boundaries of the method. 
 * *Note*: This is a limited anatomy of a C Program for the essential beginning. The additional features will be covered as we go along. 

## Life cycle of a C Program

 * *`Compilation`* - Transformation of the source code written in a High level langauge like English to the Low level language which the computer can understand
 * *`Execution`* - Running the program by means of its the compiled / intermediate version which the machine (Computer) can understand.
 * The detailed explanation of how a source code written in English like High level language be converted/translated to an intermediate language using a tool like `gcc` is available on the [*samplePgms/basics/HelloWorld.md*] (samplePgms/basics/HelloWorld.md). An alternate link in case the relative link fails, https://github.com/itsraghz/TechNotes/blob/master/cProgrammingNotes/samplePgms/basics/HelloWorld.md
 * Between Compilation and Execution, there are two other phases involved, which we will see it later once we grasp a good foundation.
   * *`Linking`* - Linking of all the relevant library files (like `stdio.h` etc.,) into the Program being executed, like `HelloWorld.c`
   * *`Loading`* - Loading the compiled version of the files and other associated piece of libraries into the memory so that it can be executed.

## Tools

 We will mostly use any of the following tools.

### Compiler

 We will certainly need a *Compiler* which is again a software/tool that helps us to transform/compile/convert the source code written in a High Level language to the low level language, that is understandable by a Computer.

 | Operating System    | Tool           | Mode        | Advantages      | Disadvantages   |
 |:--------: |:-------------: | :---------: |:--------------: |:--------------: |
 | N/A    | GDB C Compiler | Online | * You can easily execute a C Program directly without any installation, as it runs on a browser. * It has the support for the Syntax highlighting, Compiling and Executing the Source Code all in one place. * You can use it anywhere and anytime, as long as you have a good Internet Connection. | * It needs an active Internet connection always to run. * You can't store the files into your computer hard drive directly (Example: `C:\\CPrograms`). You need to manually save the contents from the browser to your computer by using the available save options in the menu. * You cannot see the intermidate files of the compilation as it is hidden inside the execution phase. |
 | Windows | Turbo C | Offline | * You can directly type the source code, compile and execute the source code all at one place, and also can save the files easily in to your hard drive for any future needs. * It has the syntax highlighting features for the language. * It is offline and you do *NOT* need any Internet Connection. | * You need to download and install the software in your machine, however it is only one time. * Similar to GDB C Compiler, you cannot see or watch out the intermediate files being generated as a result of compilation. * Can run only on your machine. Can't take it outside your computer directly. |
 | Linux | GNU C Compiler (GCC) | Offline | * Readily available in almost all the Unix/Linux/Mac based Operating Systems as most of the runtime and kernal related binaries are based on C. * Offers a good native support for the language. * Can watch out (monitor) the intermediate file (`a.out` unless overridden) after compilation if you want. | * None for this activity, as of now. * Can run only in your machine. Can't take it outside your computer direclty. |

Note: 

 * For a quick and easy demostration or testing, we can use an online compiler.
 * *Example:* [GDB Online Compiler] (https://www.onlinegdb.com/online_c_compiler)

### Editors/IDEs (Integrated Development Environment)

  *Note*: 
 * The comparison chart given below is purely based on the assumption of the students/practitioners who are absolute beginners. 
 * The tools can very well be tamed / customized with the rich set of plugins to have more facilities. 
 * You may please explore the documentation of the respective tool for its features, depending on your personal choice if you wish to choose a different tool than the ones recommended here.

 | Operating System | Tool  | Type | Purpose | Recommended | Remarks |
 | :--------------: | :---: | :--: | :-----: | :---------: | :-----: |
 | Linux/Unix  | Vi/Vim | Enhanced | Typing Source Code|  No | Visual/Vi Improved Edior. Mostly available in Unix/Linux OS. It needs a bit of practicing on VI commands, hence not recommended for absoulte beginners. You may need to use the tools like `gcc` for compiling and executing. |
 | Linux/Unix  | Nano   | Enhanced | Typing Source Code|  Yes | Simplest editor and hence recommended for absolute beginners. Similar to Vi/Vim, you may need a tool like gcc to compile and exeute the programs, unless you have a plugin to do so inside the editor. |
 | Windows     | Notepad  | Plain  | Typing Source Code|  No | The basic and plain version of an editor. Available by default. Not recommended because it does not show  / higlight any syntax errors.|
 | Windows     | Turbo C | Enhanced | Typing, Compiling, Executing | Yes | A very good advanced, enhanced editor which has the support for syntax highlighting, compilation and execution of the source code all at one. *Note* The execution style is different from the tools like `gcc` where Turbo C does not show the intermediate file `a.out` directly to you.|
 | Windows    | NotePad++ | Enhanced | Typing Source Code| No | Enhanced source code editor that highlights the syntax and stuff. You can't execute the source code though directly. You can't shuffle the source code easily between the Notepad++ to Turbo C for compiling and executing. |
 | Windows    | VS Code | Enhanced | Typing Source Code| No | Similar to Notepad++. |

