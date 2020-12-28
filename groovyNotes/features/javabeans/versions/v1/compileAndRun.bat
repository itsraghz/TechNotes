cls
ls -ltrh
rm -rf *.class
javac *.java
ls -ltrh
java BookBeanTest

if exist *.class goto process_it
    echo There are no .class files present...
    pause
    exit /b
:process_it
