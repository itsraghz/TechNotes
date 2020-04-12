# Addition of Two numbers

## Problem Statement

 Write a C Program to compute the sum of two numbers, which are obtained from the users. 
 
 *Note*: This way the program will be generic and run for any set of inputs by the User duing the runtime. Otherwise, the program will always produce a fixed output everytime we run. 

## Source Code

```
raghs@LAPTOP-63DBKP7Q:~/cPgms/newDir$ cat Addition.c
#include <stdio.h>

int main()
{
        int a;
        int b;
        int c;
        printf("Enter the 1st number to add :  ");
        scanf("%d", &a); // & - memory location of a
        printf("Enter the 2nd number to add : " );
        scanf("%d", &b);
        c = a + b;
        printf("The sum of two numbers is : %d\n", c);
}
```

## Source Code with line numbers - for explanation

```
     1  #include <stdio.h>
     2
     3  int main()
     4  {
     5          int a;
     6          int b;
     7          int c;
     8          printf("Enter the 1st number to add :  ");
     9          scanf("%d", &a); // & - memory location of a
    10          printf("Enter the 2nd number to add : " );
    11          scanf("%d", &b);
    12          c = a + b;
    13          printf("The sum of two numbers is : %d\n", c);
    14  }
```

### Explanation

 * Line No. 9 and 11 - we use a new method called `scanf` which is similar to the `printf` as it is defined in the `stdio.h` header file. 
 * However it differs on the functionality as it helps us to scan the variable from the keyboard (to get an input from the User), like how a *Scanner* scans the document from the outside document andgets it inside the Computer after scanning, wheresa the `printf` does the reverse - prints the content from the Computer to screen.
 * Another difference is that the `scanf` method uses the `&` character that represents the *address* of the variable to store the value to the variable directly. It is similar to the *location* where we specify for the scanned documents to be stored in the Computer locally, whereas the `printf` does not need/use the memory location, as it is printing the value of the variable. 

## Compilation

```
raghs@LAPTOP-63DBKP7Q:~/cPgms/newDir$ gcc Addition.c -o Addition.out
raghs@LAPTOP-63DBKP7Q:~/cPgms/newDir$ ls -ltrh
total 68K
-rw-rw-rw- 1 raghs raghs  293 Apr 13 00:36 Addition.c
-rwxrwxrwx 1 raghs raghs 8.3K Apr 13 00:37 Addition.out
raghs@LAPTOP-63DBKP7Q:~/cPgms/newDir$
```

 The `gcc` tool helps us to compile the source code. By default it produces an intermdiate file (compiled version) called `a.out`. Here we want to have a different file of our choice, which we specify through the argument `-o Addition.out`. 

## Execution

```
raghs@LAPTOP-63DBKP7Q:~/cPgms/newDir$ ./Addition.out
Enter the 1st number to add :  5
Enter the 2nd number to add : 7
The sum of two numbers is : 12
raghs@LAPTOP-63DBKP7Q:~/cPgms/newDir$
```

## Explanation

 When we run the program using the intermediate file generated `./Addition.out`, the intermediate file gets executed differently this time. It asks for the input from the user for the 2 numbers to add and then it computes the sum and prints the output in the screen. 

  The sample execution we saw above has got the input numbers 5 and 7 and the program printed the output 12. The user can modify his inputs for the subsequent executions and the program will compute the result and print it accordingly. This way we do NOT need to change the program everytime and recompile it, if we had written it like the previous program which had a fixed inputs `2` and `3` and hence was always producing the fixed output `5` everytime we run the program.

 We want the prompt in the Terminal to come to the next line, and hence we added the newline character `\n` at the end of the message in the `printf` statement. 
