```
C:\raghs\prfsnl\groovyPgms\features\javabeans\GroovyClasses
λ ls
BookTest.groovy  BookTestPrivate.groovy

C:\raghs\prfsnl\groovyPgms\features\javabeans\GroovyClasses
λ groovyc BookTest.groovy

C:\raghs\prfsnl\groovyPgms\features\javabeans\GroovyClasses
λ ls
Book.class  BookTest.groovy  BookTestPrivate.groovy

C:\raghs\prfsnl\groovyPgms\features\javabeans\GroovyClasses
λ javap -c Book.class > javap-Book-dot-class.txt

C:\raghs\prfsnl\groovyPgms\features\javabeans\GroovyClasses
λ ls
Book.class  BookTest.groovy  BookTestPrivate.groovy  javap-Book-dot-class.txt

C:\raghs\prfsnl\groovyPgms\features\javabeans\GroovyClasses
λ groovyc BookTestPrivate.groovy

C:\raghs\prfsnl\groovyPgms\features\javabeans\GroovyClasses
λ ls
Book.class              BookTest.groovy         javap-Book-dot-class.txt
BookPrivateField.class  BookTestPrivate.groovy

C:\raghs\prfsnl\groovyPgms\features\javabeans\GroovyClasses
λ javap -c BookPrivateField.class > javap-Book-dot-class-private-field.txt

C:\raghs\prfsnl\groovyPgms\features\javabeans\GroovyClasses
λ
```
