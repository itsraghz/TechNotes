# C Programming - Assignment 1

## Problem Statement

 Write a C Program that obtains the two numbers from the User as an input in the Command Line.
 Assign both the values to the same variable (first variable) and find the sum. 
 Observe the change if any on the Compilation and Execuction.

## Source Code

```
#include <stdio.h>

int main()
{
	int a ;
	int b ;
	int c;
	printf("Enter the 1st number to add : ");
	scanf("%d", &a);
	printf("Enter the 2nd number to add : ");
	scanf("%d", *&a*); // assigning this 2nd value also to the same variable 'a'.
	c = a + b;
	printf("The sum of the two numbers is : %d\n", c);
}
```

## Compilation

## Execution

## Explanation
