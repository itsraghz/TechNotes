[Home](../) | [03_GroovyInstallation](../03_GroovyInstallation)

# Groovy Installation

## Dependency

Ensure you have the following in your machine.

* Appropriate and compatible version of *Java* installed on your machine, as Groovy runs on JVM.
* `JAVA_HOME` environment variable is set
* `%JAVA_HOME%\bin` is appended to the `PATH` environment variable.

## Installation of Groovy

Installing Groovy is very easy in the modern versions.

Being a Java product, it is available as a JAR (Java Archive File) for use.

Let us follow the *DESVU* OR *DISVU* strategy.

* D - Download
* E - Extract / I - Install
* S - Set up
* V - Verify
* U - Use it

## Download
Head over to [Apache Website](https://groovy.apache.org/download.html) and download the latest version of Groovy JAR file bundled in a zip file.
As on date, the latest version is *3.0.7*.

## Extract

Extract the zip file and store in the preferred location.

In my PC, I store all of such stuff into the folder `C:\installedSoft\` and the groovy extracted folder goes into the folder as `c:\installedSoft\groovy-3.0.7\`

## Set Path

We now need to set the path to the groovy *executable* which is usually located inside the `bin` subdirectory of the main directory
of the extracted software.

Command to set the path in the Windows OS is as follows.

* Set the `GROOVY_HOME` environment variable to `c:\installedSoft\groovy-3.0.7`.
* Set the Groovy executable path to the `PATH` environment variable as `SET PATH=%PATH%;%GROOVY_HOME%\bin`

> The settings in the other OS'es like Linux, Mac OS will have its own variance for the path separator `/` instead of '\' and ':' instead of ';' respectively.

## Verify

Go to a Command Prompt or the Terminal and type `groovy -v` OR `groovy --version` in the prompt.

If all went well, you should see the following output.

```
C:\Users\Raghavan Muthu
λ groovy -v
Groovy Version: 3.0.7 JVM: 14.0.2 Vendor: Oracle Corporation OS: Windows 10
```

## Use it

You can start using Groovy in the following ways.

| Execution  | Invocation | Remarks |
| ---------- | ---------- | ------- |
| Groovysh - REPL |
| groovyConsole   |
| Groovy compiler in Terminal |
