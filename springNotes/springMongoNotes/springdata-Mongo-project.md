# Spring Data Mongo Project Execution

This is a quick reference notes for executing a demo project on Spring Data Mongo with two different profiles.

* Mongodb at localhost (localhost:27017) (Windows 10 Machine) [DEV]
* Mongodb at Mongodb.com cluster account (Remote and on cloud) [PROD]

## Spring Boot Project

The Spring Data Mongo project is available at 

```sh
C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\springdata-mongodb-demo
```

### Source Code

The program source code is as follows.

```sh
raghs@Raghs-LegionY540-TPIN:/mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo/src/main/java$ tree
.
+-- com
    +-- raghsonline
        +-- springdatamongodbdemo
            +-- model
            ¦   +-- Customer.java
            +-- repository
            ¦   +-- CustomerRepository.java
            +-- runner
            ¦   +-- MongoDbClientRunner.java
            +-- SpringdataMongodbDemoApplication.java

6 directories, 4 files
```

#### *Domain Class* - `Customer.java`

```java
raghs@Raghs-LegionY540-TPIN:/mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo/src/main/java$ cat com/raghsonline/springdatamongodbdemo/model/Customer.java
------------------------------------------------------------------------------------------------------------------------------------------------------------
       ¦ File: com/raghsonline/springdatamongodbdemo/model/Customer.java
-------+----------------------------------------------------------------------------------------------------------------------------------------------------
   1   ¦ package com.raghsonline.springdatamongodbdemo.model;
   2   ¦
   3   ¦ import org.springframework.data.annotation.Id;
   4   ¦
   5   ¦ public class Customer {
   6   ¦
   7   ¦     @Id
   8   ¦     public String id;
   9   ¦
  10   ¦     public String firstName;
  11   ¦     public String lastName;
  12   ¦
  13   ¦     public Customer(String firstName, String lastName) {
  14   ¦         this.firstName = firstName;
  15   ¦         this.lastName = lastName;
  16   ¦     }
  17   ¦
  18   ¦     @Override
  19   ¦     public String toString() {
  20   ¦         return String.format(
  21   ¦                 "Customer [id=%s, firstName=%s, lastName=%s]",
  22   ¦                 id, firstName, lastName);
  23   ¦     }
  24   ¦ }
------------------------------------------------------------------------------------------------------------------------------------------------------------
raghs@Raghs-LegionY540-TPIN:/mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo/src/main/java$
```

### Repository Class - `CustomerRepository.java`

```java
raghs@Raghs-LegionY540-TPIN:/mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo/src/main/java$ cat com/raghsonline/springdatamongodbdemo/repository/CustomerRepository.java
------------------------------------------------------------------------------------------------------------------------------------------------------------
       ¦ File: com/raghsonline/springdatamongodbdemo/repository/CustomerRepository.java
-------+----------------------------------------------------------------------------------------------------------------------------------------------------
   1   ¦ package com.raghsonline.springdatamongodbdemo.repository;
   2   ¦
   3   ¦ import com.raghsonline.springdatamongodbdemo.model.Customer;
   4   ¦ import org.springframework.data.mongodb.repository.MongoRepository;
   5   ¦
   6   ¦ import java.util.List;
   7   ¦
   8   ¦ public interface CustomerRepository extends MongoRepository<Customer, String> {
   9   ¦
  10   ¦     public Customer findByFirstName(String firstName);
  11   ¦     public List<Customer> findByLastName(String lastName);
  12   ¦ }
------------------------------------------------------------------------------------------------------------------------------------------------------------
raghs@Raghs-LegionY540-TPIN:/mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo/src/main/java$
```

#### Runner Class - `MongoDbClientRunner.java`

```java
raghs@Raghs-LegionY540-TPIN:/mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo/src/main/java$ cat com/raghsonline/springdatamongodbdemo/runner/MongoDbClientRunner.java
------------------------------------------------------------------------------------------------------------------------------------------------------------
       ¦ File: com/raghsonline/springdatamongodbdemo/runner/MongoDbClientRunner.java
-------+----------------------------------------------------------------------------------------------------------------------------------------------------
   1   ¦ package com.raghsonline.springdatamongodbdemo.runner;
   2   ¦
   3   ¦ import com.raghsonline.springdatamongodbdemo.model.Customer;
   4   ¦ import com.raghsonline.springdatamongodbdemo.repository.CustomerRepository;
   5   ¦ import org.springframework.beans.factory.annotation.Autowired;
   6   ¦ import org.springframework.boot.CommandLineRunner;
   7   ¦ import org.springframework.stereotype.Component;
   8   ¦
   9   ¦ @Component
  10   ¦ public class MongoDbClientRunner implements CommandLineRunner {
  11   ¦
  12   ¦     @Autowired
  13   ¦     private CustomerRepository customerRepository;
  14   ¦
  15   ¦
  16   ¦     @Override
  17   ¦     public void run(String... args) {
  18   ¦         System.out.println("MongoDbClientRunner - run() method invoked");
  19   ¦
  20   ¦         customerRepository.deleteAll();
  21   ¦
  22   ¦         //save a couple of customers
  23   ¦         customerRepository.save(new Customer("Alice", "Smith"));
  24   ¦         customerRepository.save(new Customer("Bob", "Smith"));
  25   ¦
  26   ¦         //fetch All Customers
  27   ¦         System.out.println("Customers found with findAll()");
  28   ¦         System.out.println("-------------------------------");
  29   ¦         for(Customer customer : customerRepository.findAll()) {
  30   ¦             System.out.println(customer);
  31   ¦         }
  32   ¦         System.out.println();
  33   ¦
  34   ¦         //fetch an individual customer
  35   ¦         System.out.println("Customer found with findByFirstName(\"Alice\")");
  36   ¦         System.out.println("----------------------------------------------");
  37   ¦         System.out.println(customerRepository.findByFirstName("Alice"));
  38   ¦
  39   ¦         System.out.println("Customers found with findByLastName(\"Smith\"");
  40   ¦         System.out.println("---------------------------------------------");
  41   ¦         for(Customer customer : customerRepository.findByLastName("Smith")) {
  42   ¦             System.out.println(customer);
  43   ¦         }
  44   ¦
  45   ¦         System.out.println("MongoDbClientRunner - run() method completed");
  46   ¦     }
  47   ¦ }
------------------------------------------------------------------------------------------------------------------------------------------------------------
raghs@Raghs-LegionY540-TPIN:/mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo/src/main/java$
```

#### Main class - `SpringdataMongodbDemoApplication.java`

```java
raghs@Raghs-LegionY540-TPIN:/mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo/src/main/java$ cat com/raghsonline/springdatamongodbdemo/SpringdataMongodbDemoApplication.java
------------------------------------------------------------------------------------------------------------------------------------------------------------
       ¦ File: com/raghsonline/springdatamongodbdemo/SpringdataMongodbDemoApplication.java
-------+----------------------------------------------------------------------------------------------------------------------------------------------------
   1   ¦ package com.raghsonline.springdatamongodbdemo;
   2   ¦
   3   ¦ import org.springframework.boot.SpringApplication;
   4   ¦ import org.springframework.boot.autoconfigure.SpringBootApplication;
   5   ¦
   6   ¦ @SpringBootApplication
   7   ¦ public class SpringdataMongodbDemoApplication {
   8   ¦
   9   ¦     public static void main(String[] args) {
  10   ¦         SpringApplication.run(SpringdataMongodbDemoApplication.class, args);
  11   ¦     }
  12   ¦
  13   ¦ }
------------------------------------------------------------------------------------------------------------------------------------------------------------
raghs@Raghs-LegionY540-TPIN:/mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo/src/main/java$
```

### List of profiles/ properties files

The available list of profiles and the corresponding `.properties` file (can be a `.yml` file as well - if preferred) in the `src/main/resources` directory - are shown below.

```sh
raghs@Raghs-LegionY540-TPIN:/mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo/src/main/resources$ ls -ltrh
total 8.0K
-rwxrwxrwx 1 raghs raghs 1.3K Dec 31 00:12 application.properties
-rwxrwxrwx 1 raghs raghs 1.3K Jan  1 18:35 application-mongocluster.properties

```

### The Executable JAR file

The console output for the *executable* `.jar` file inside the `target` directory of the project. 

> The executable `.jar` file can be created by invoking the command `mvn clean install` in the project home directory.

```sh
raghs@Raghs-LegionY540-TPIN:/mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo/target$ pwd
/mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo/target
raghs@Raghs-LegionY540-TPIN:/mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo/target$ ls -ltrh
total 14M
drwxrwxrwx 1 raghs raghs 4.0K Jan  1 18:48 generated-sources
drwxrwxrwx 1 raghs raghs 4.0K Jan  1 18:48 maven-status
drwxrwxrwx 1 raghs raghs 4.0K Jan  1 18:48 classes
drwxrwxrwx 1 raghs raghs 4.0K Jan  1 18:48 generated-test-sources
drwxrwxrwx 1 raghs raghs 4.0K Jan  1 18:48 test-classes
drwxrwxrwx 1 raghs raghs 4.0K Jan  1 18:49 surefire-reports
drwxrwxrwx 1 raghs raghs 4.0K Jan  1 18:49 maven-archiver
-rwxrwxrwx 1 raghs raghs 6.8K Jan  1 18:49 springdata-mongodb-demo-0.0.1-SNAPSHOT.jar.original
-rwxrwxrwx 1 raghs raghs  14M Jan  1 18:49 springdata-mongodb-demo-0.0.1-SNAPSHOT.jar

raghs@Raghs-LegionY540-TPIN:/mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo/target$ 

```

### Spring Boot Profiles 

There are two profiles

* default (`application.properties`) to connect to the Mongodb @ localhost
* mongocluster (`application-mongocluster.properties`)

#### Default Profile - `application.properties`

```java
raghs@Raghs-LegionY540-TPIN:/mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo$ cat src/main/resources/application.properties
------------------------------------------------------------------------------------------------------------------------------------------------------------
       ¦ File: src/main/resources/application.properties
-------+----------------------------------------------------------------------------------------------------------------------------------------------------
   1   ¦ #default it listens to the localhost:27017
   2   ¦   
------------------------------------------------------------------------------------------------------------------------------------------------------------
raghs@Raghs-LegionY540-TPIN:/mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo$
```

#### Mongo Cluster Profile - `application-mongocluster.properties`

```java
raghs@Raghs-LegionY540-TPIN:/mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo$ cat src/main/resources/application-mongocluster.properties
------------------------------------------------------------------------------------------------------------------------------------------------------------
       ¦ File: src/main/resources/application-mongocluster.properties
-------+----------------------------------------------------------------------------------------------------------------------------------------------------
   1   ¦ #default it listens to the localhost:27017
   2   ¦
   3   ¦ spring.data.mongodb.uri=mongodb+srv://m001-student:<Password>@raghscluster.lxy8a.mongodb.net/myFirstDatabase
   4   ¦ spring.data.mongodb.database=myFirstDatabase
   5   ¦
------------------------------------------------------------------------------------------------------------------------------------------------------------
raghs@Raghs-LegionY540-TPIN:/mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo$
```

### Command to activate the profiles 

```java
java -Dspring.profiles.active=<ProfileName> jar <ExecutableJarFile.jar>
```
## Execution

The execution of the Spring Boot project with the different profiles and the Console Output for the respective execution is given in the file [springdata-Mongo-profiles-execution.md](./springdata-Mongo-profiles-execution.md).

