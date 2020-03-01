# Maven Error - Not downloading the dependencies

Maven is not downloading the required dependencies specified in the `pom.xml` file
though it does not have any errors and the required artifacts (JARs) are actually
present in the mvncentral repository.

The issue is only in the IDEs like Eclipse, STS etc., whereas it runs perfectly
while running in the `Terminal` or `Command Line` through the commands `mvn clean`, 
`mvn install` etc.,

## Reasons

  * Update a proper `<proxy>` element to reach out to the mvncentral repository
  * Do the operation, 'Right Click the Project' -> 'Run' -> 'Maven Install' (this worked!)

## References

  * https://stackoverflow.com/questions/31720328/maven-not-downloading-dependencies-in-eclipse
