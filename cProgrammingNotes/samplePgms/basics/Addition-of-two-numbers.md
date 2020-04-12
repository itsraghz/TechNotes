# Addition of Two numbers

## Problem Statement

 Write a C Program to compute the sum of two numbers. 

## Source Code

```
#include <stdio.h>

int main()
{
        int a = 2;
        int b = 3;
        int c = a + b;
        printf ("%d\n", c);
}
```

## Source Code with line numbers - for explanation

```
     1  #include <stdio.h>
     2
     3  int main()
     4  {
     5          int a = 2;
     6          int b = 3;
     7          int c = a + b;
     8          printf ("%d\n", c);
     9  }
```

## Compilation

```
raghs@LAPTOP-63DBKP7Q:~/cPgms$ gcc Addition.c -o Addition.out
raghs@LAPTOP-63DBKP7Q:~/cPgms$ ls -ltrh
total 40K
-rw-rw-rw- 1 raghs raghs   96 Apr 11 20:12 Addition.c
-rwxrwxrwx 1 raghs raghs 8.2K Apr 13 00:30 Addition.out
```

 The `gcc` tool helps us to compile the source code. By default it produces an intermdiate file (compiled version) called `a.out`. Here we want to have a different file of our choice, which we specify through the argument `-o Addition.out`. 

## Execution

```
raghs@LAPTOP-63DBKP7Q:~/cPgms$ ./Addition.out
5
raghs@LAPTOP-63DBKP7Q:~/cPgms$
```

## Explanation

 When we run the program using the intermediate file generated `./Addition.out`, the intermediate file gets executed and prints the output that is the sum of the two numbers `2` and `3` - which is `5`.

 We want the prompt in the Terminal to come to the next line, and hence we added the newline character `\n` at the end of the message in the `printf` statement. 
