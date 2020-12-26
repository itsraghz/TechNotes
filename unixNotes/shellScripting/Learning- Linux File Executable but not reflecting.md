# Linux File Executable but not reflecting

I made a .sh file and set the attributes `chmod u+x` to the file.
However there was no effect, evident from the following.

- The color of the file was not turning out to be green
- The `ls -ltrh` does not list down the `x` attribute for the file

## Issue

Upon investigating, I found out that the shell script does not
have the necessary instruction to make the path to the shell.

## Fix

Add the header line to the shell script and it works fine.

`#!/bin/bash`
