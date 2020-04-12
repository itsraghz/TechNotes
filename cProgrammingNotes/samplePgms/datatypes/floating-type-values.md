# Float datatype

 * To deal with the decimal values, we use the `float` keyword for handing the values with the fractions (decimal points).
 * For example, the value of the mathematical constant `PI` is *3.14*, which needs to be stored with at least two decimal value `.14` afer the whole number `3`, else it will lose its significance.

## Program that deals with the floating value on integer data type

```
raghs@LAPTOP-63DBKP7Q:~/cPgms/newDir/floatDemo$ cat FloatingInt.c
#include <stdio.h>

int main()
{
        //pi = 3.14
        int pi = 3.14;
        printf("The value of PI is :  %d\n", pi);
}
```
### Source code with the line numbers for explanation

```
     1  #include <stdio.h>
     2
     3  int main()
     4  {
     5          //pi = 3.14
     6          int pi = 3.14;
     7          printf("The value of PI is :  %d\n", pi);
     8  }
```

#### Explanation

 * Line 6 : Store the value `3.14` into a variable `pi` of type `int`.
 * Line 7 : Print the value of `pi` using the `%d` format specifier of `printf` statement with the variable `pi` of type `int`.

### Compilation and Execution

```
raghs@LAPTOP-63DBKP7Q:~/cPgms/newDir/floatDemo$ gcc FloatingInt.c -o FloatingInt.out
raghs@LAPTOP-63DBKP7Q:~/cPgms/newDir/floatDemo$ ls -ltrh
total 32K
-rw-rw-rw- 1 raghs raghs  108 Apr 13 00:55 FloatingInt.c
-rwxrwxrwx 1 raghs raghs 8.2K Apr 13 00:58 FloatingInt.out
raghs@LAPTOP-63DBKP7Q:~/cPgms/newDir/floatDemo$ ./FloatingInt.out
The value of PI is :  3
raghs@LAPTOP-63DBKP7Q:~/cPgms/newDir/floatDemo$
```

#### Explanation
 
  As you see, the program does not complain on the value being stored inappropriately. Meaning, the value with the decimal/ fraction part `3.14` being stored into a variable of type `int` (which is to store the *whole numbers*), is being truncated and stored partially as in

  ```
    int pi = 3;
  ```

   That is why when we execute the program, the output is just `3` and not `3.14`. This is also called *truncation* (or `possible loss of precision`), which is actually improved in the language `Java`, taken from both `C` and `C++` and improved upon further to avoid such known overheads/issues.

## Program uses floating value with the right data type (float)

 Now, let us write the same Program using the different but *right* datatype which is `float`. For a change, we make use of both the data types in two different variables to distinguish in the output.

```
#include <stdio.h>

int main()
{
        //pi = 3.14
        int pi = 3.14; // (int pi=3;)
        float floatPI = 3.14;
        printf("The value of PI is :  %d\n", pi);
        printf("The value of PI (float) is : %f\n",floatPI);
}
```

### Source code with the line numbers for explanation

```
     1  #include <stdio.h>
     2
     3  int main()
     4  {
     5          //pi = 3.14
     6          int pi = 3.14; // (int pi=3;)
     7          float floatPI = 3.14;
     8          printf("The value of PI is :  %d\n", pi);
     9          printf("The value of PI (float) is : %f\n",floatPI);
    10  }
```

 Please make a note that the format specifier being used in the `printf` statement is different here and it should be appropriate for the datatype the variable being used. For the floating datatype, the format specifier is `%f`.

### Compilation and Execution

```
raghs@LAPTOP-63DBKP7Q:~/cPgms/newDir/floatDemo$ gcc Floating.c -o Floating.out
lsraghs@LAPTOP-63DBKP7Q:~/cPgms/newDir/floatDemo$ ls -ltrh
total 48K
-rw-rw-rw- 1 raghs raghs  108 Apr 13 00:55 FloatingInt.c
-rwxrwxrwx 1 raghs raghs 8.2K Apr 13 00:58 FloatingInt.out
-rw-rw-rw- 1 raghs raghs  199 Apr 13 01:04 Floating.c
-rwxrwxrwx 1 raghs raghs 8.2K Apr 13 01:04 Floating.out
raghs@LAPTOP-63DBKP7Q:~/cPgms/newDir/floatDemo$ ./Floating.out
The value of PI is :  3
The value of PI (float) is : 3.140000
raghs@LAPTOP-63DBKP7Q:~/cPgms/newDir/floatDemo$
```

## Explanation
 
 The output clearly indicates that value being stored in the `float` datatype has no loss of precision and displays the value exactly as what we had stored. 
 
 *Note:* 
  * Remember,we had to use the different format specifier `%f` in the `printf` method to display the value in the right form - float in this example.
  * The actual output has a few zeroes (`0`) at the end , which can be ignore, as the zeroes at the end do not have any significance.
  * The format of the output can be controlled later using the different value for the *format specifier* where we can specify how many digits we want in the output. Fo r now, it is alright with the output what we got `3.140000`.


## Different Exercise for extra knowledge

 Try running the same program with the format specifier as `%d` (for int) to print the value of a variable of type of `float`. You get an inappropriate/garbage value.

### Program

```
raghs@LAPTOP-63DBKP7Q:~/cPgms/newDir/floatDemo$ cat Floating.c
#include <stdio.h>

int main()
{
        //pi = 3.14
        int pi = 3.14; // (int pi=3;)
        float floatPI = 3.14;
        printf("The value of PI is :  %d\n", pi);
        printf("The value of PI (float) is : %d\n",floatPI);
}
```

### Source code with the line numbers for explanation

```
raghs@LAPTOP-63DBKP7Q:~/cPgms/newDir/floatDemo$ cat -n Floating.c
     1  #include <stdio.h>
     2
     3  int main()
     4  {
     5          //pi = 3.14
     6          int pi = 3.14; // (int pi=3;)
     7          float floatPI = 3.14;
     8          printf("The value of PI is :  %d\n", pi);
     9          printf("The value of PI (float) is : %d\n",floatPI);
    10  }
```

 * Line # 9: has the format specifier as `%d` for the variable `floatPI`, which is of the data type `float`.

### Compilation and Execution

```
raghs@LAPTOP-63DBKP7Q:~/cPgms/newDir/floatDemo$ gcc Floating.c  -o Floating.out
Floating.c: In function `main`:
Floating.c:9:40: warning: format `%d` expects argument of type `int`, but argument 2 has type `double` [-Wformat=]
  printf("The value of PI (float) is : %d\n",floatPI);
                                       ~^
                                       %f
raghs@LAPTOP-63DBKP7Q:~/cPgms/newDir/floatDemo$ ./Floating.out
The value of PI is :  3
The value of PI (float) is : -897490336
raghs@LAPTOP-63DBKP7Q:~/cPgms/newDir/floatDemo$
```

### Explanation

 As you see above, the Compilation had issued a warning stating that the value being printed with the `%d` format specifier is actually of type `double` (which is the  higher version of `float`). However the program did not stop in generating the `.out` file. 

 When we run the program, the output is having a *garbage* value which is a random, inappropriate value to indicate that something went wrong. Here, we get a large value in negative `-897490336`.
