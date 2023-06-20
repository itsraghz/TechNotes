# Output


## Compile and Execute - `WriteAShellScript.java`

```sh
➜  io git:(master) ✗ exa -l
.rw-r--r--  908 raghavan.muthu 20 Jun 08:23 WriteAShellScript.class
.rw-r--r--  389 raghavan.muthu 19 Jun 23:58 WriteAShellScript.java
➜  io git:(master) ✗ java WriteAShellScript 
File [hello.sh] has been written
➜  io git:(master) ✗ exa -l
.rw-r--r--   53 raghavan.muthu 20 Jun 08:24 hello.sh
.rw-r--r--  908 raghavan.muthu 20 Jun 08:23 WriteAShellScript.class
.rw-r--r--  389 raghavan.muthu 19 Jun 23:58 WriteAShellScript.java
➜  io git:(master) ✗ ./hello.sh 
zsh: permission denied: ./hello.sh
➜  io git:(master) ✗ 
```

## Compile and Execute - `WriteAndMakeExecutableShellScript.java`

```sh
➜  io git:(master) ✗ javac WriteAndMakeExecutableShellScript.java 
➜  io git:(master) ✗ exa -l
.rw-r--r-- 1.4k raghavan.muthu 20 Jun 08:42 WriteAndMakeExecutableShellScript.class
.rw-r--r--  683 raghavan.muthu 20 Jun 08:42 WriteAndMakeExecutableShellScript.java
.rw-r--r--  389 raghavan.muthu 19 Jun 23:58 WriteAShellScript.java
.rw-r--r--  389 raghavan.muthu 19 Jun 23:58 WriteAShellScript.class
.rw-r--r--   53 raghavan.muthu 20 Jun 08:24 hello.sh
➜  io git:(master) ✗ java WriteAndMakeExecutableShellScript 
File [hello.sh] has been written
The file permissions are set to be executed by the User!
➜  io git:(master) ✗ exa -l
.r-x------   53 raghavan.muthu 20 Jun 08:43 hello.sh
.rw-r--r-- 1.4k raghavan.muthu 20 Jun 08:42 WriteAndMakeExecutableShellScript.class
.rw-r--r--  683 raghavan.muthu 20 Jun 08:42 WriteAndMakeExecutableShellScript.java
.rw-r--r--  389 raghavan.muthu 19 Jun 23:58 WriteAShellScript.java
➜  io git:(master) ✗ ./hello.sh 
hello, world - via Java Program
```

> Note: As the Java program changes the permission bits of the file `hello.sh`, you need to rerun the programs to get back a particular version with the right bits. 
> Example, if you want to have the `hello.sh` with the permission bits set to `644`, you should run the program `MakeAShellScript` and vice versa.

