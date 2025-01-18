Building Docker images for all Java versions...
#0 building with "desktop-linux" instance using docker driver

#1 [java7 internal] load build definition from Dockerfile.java7
#1 transferring dockerfile: 274B done
#1 DONE 0.0s

#2 [java17 internal] load build definition from Dockerfile.java17
#2 transferring dockerfile: 277B done
#2 DONE 0.0s

#3 [java8 internal] load build definition from Dockerfile.java8
#3 transferring dockerfile: 274B done
#3 DONE 0.0s

#4 [java11 internal] load build definition from Dockerfile.java11
#4 transferring dockerfile: 277B done
#4 DONE 0.0s

#5 [java21 internal] load build definition from Dockerfile.java21
#5 transferring dockerfile: 277B done
#5 DONE 0.0s

#6 [java11 auth] library/openjdk:pull token for registry-1.docker.io
#6 DONE 0.0s

#7 [java21 internal] load metadata for docker.io/library/openjdk:21
#7 ...

#8 [java11 internal] load metadata for docker.io/library/openjdk:11
#8 DONE 1.7s

#9 [java11 internal] load .dockerignore
#9 transferring context: 2B done
#9 DONE 0.0s

#10 [java11 1/4] FROM docker.io/library/openjdk:11@sha256:99bac5bf83633e3c7399aed725c8415e7b569b54e03e4599e580fc9cdb7c21ab
#10 DONE 0.0s

#11 [java11 internal] load build context
#11 transferring context: 79B done
#11 DONE 0.0s

#12 [java11 3/4] COPY DateTimeExample.java .
#12 CACHED

#13 [java11 2/4] WORKDIR /app
#13 CACHED

#14 [java11 4/4] RUN javac DateTimeExample.java
#14 CACHED

#15 [java17 internal] load metadata for docker.io/library/openjdk:17
#15 DONE 1.7s

#16 [java11] exporting to image
#16 exporting layers done
#16 writing image sha256:69c701d1585f3ee667ab1bce1f9670b86779fab7cfa4c4f35f4f2b067f71be00 done
#16 naming to docker.io/library/datetimeformat-java7-vs-higher-nuances-java11 done
#16 DONE 0.0s

#17 [java17 internal] load .dockerignore
#17 transferring context: 2B done
#17 DONE 0.0s

#18 [java17 1/4] FROM docker.io/library/openjdk:17@sha256:528707081fdb9562eb819128a9f85ae7fe000e2fbaeaf9f87662e7b3f38cb7d8
#18 DONE 0.0s

#19 [java7 internal] load metadata for docker.io/library/openjdk:7
#19 DONE 1.7s

#20 [java17 internal] load build context
#20 transferring context: 79B done
#20 DONE 0.0s

#21 [java17 2/4] WORKDIR /app
#21 CACHED

#22 [java17 3/4] COPY DateTimeExample.java .
#22 CACHED

#23 [java17 4/4] RUN javac DateTimeExample.java
#23 CACHED

#24 [java7 internal] load .dockerignore
#24 transferring context: 2B done
#24 DONE 0.0s

#25 [java7 1/4] FROM docker.io/library/openjdk:7@sha256:75a05dbcd254fdde1a284c5cc47a8f7d5387cd517cbf9e66d50d45da1c695022
#25 DONE 0.0s

#26 [java7 internal] load build context
#26 transferring context: 79B done
#26 DONE 0.0s

#27 [java7 2/4] WORKDIR /app
#27 CACHED

#28 [java7 3/4] COPY DateTimeExample.java .
#28 CACHED

#29 [java17] exporting to image
#29 exporting layers done
#29 writing image sha256:ad2cb9e0214d7b811e9fb78afaf75cf2bc21fab492aa059c475fab70ff299e63 done
#29 naming to docker.io/library/datetimeformat-java7-vs-higher-nuances-java17 done
#29 DONE 0.0s

#30 [java8 internal] load metadata for docker.io/library/openjdk:8
#30 DONE 1.7s

#31 [java11] resolving provenance for metadata file
#31 DONE 0.0s

#32 [java8 internal] load .dockerignore
#32 transferring context: 2B done
#32 DONE 0.0s

#33 [java8 1/4] FROM docker.io/library/openjdk:8@sha256:86e863cc57215cfb181bd319736d0baf625fe8f150577f9eb58bd937f5452cb8
#33 DONE 0.0s

#34 [java8 internal] load build context
#34 transferring context: 79B done
#34 DONE 0.0s

#35 [java8 2/4] WORKDIR /app
#35 CACHED

#36 [java8 3/4] COPY DateTimeExample.java .
#36 CACHED

#37 [java8 4/4] RUN javac DateTimeExample.java
#37 CACHED

#7 [java21 internal] load metadata for docker.io/library/openjdk:21
#7 DONE 1.7s

#38 [java8] exporting to image
#38 exporting layers done
#38 writing image sha256:481aac2e6845fe38b15572ff435210a1f01a8f948069e7341cd9af8ba4a9b02e done
#38 naming to docker.io/library/datetimeformat-java7-vs-higher-nuances-java8 done
#38 DONE 0.0s

#39 [java21 internal] load .dockerignore
#39 transferring context: 2B done
#39 DONE 0.0s

#40 [java17] resolving provenance for metadata file
#40 DONE 0.0s

#41 [java21 1/4] FROM docker.io/library/openjdk:21@sha256:af9de795d1f8d3b6172f6c55ca9ba1c5768baa11bb2dc8af7045c7db9d4c33ac
#41 DONE 0.0s

#42 [java21 internal] load build context
#42 transferring context: 79B done
#42 DONE 0.0s

#43 [java8] resolving provenance for metadata file
#43 DONE 0.0s

#44 [java21 3/4] COPY DateTimeExample.java .
#44 CACHED

#45 [java21 2/4] WORKDIR /app
#45 CACHED

#46 [java21 4/4] RUN javac DateTimeExample.java
#46 CACHED

#47 [java21] exporting to image
#47 exporting layers done
#47 writing image sha256:3b4cc73bc8d469e338b0f5d60b6cd911895d19cce0f1b7845b6229e435a7b708 done
#47 naming to docker.io/library/datetimeformat-java7-vs-higher-nuances-java21 done
#47 DONE 0.0s

#48 [java21] resolving provenance for metadata file
#48 DONE 0.0s

#49 [java7 4/4] RUN javac DateTimeExample.java
#49 3.946 DateTimeExample.java:2: error: package java.time does not exist
#49 3.947 import java.time.LocalDate;
#49 3.947                 ^
#49 3.952 DateTimeExample.java:3: error: package java.time.format does not exist
#49 3.952 import java.time.format.DateTimeFormatter;
#49 3.952                        ^
#49 4.586 DateTimeExample.java:44: error: cannot find symbol
#49 4.586         LocalDate date = LocalDate.of(2024, 12, 30);
#49 4.586         ^
#49 4.586   symbol:   class LocalDate
#49 4.587   location: class DateTimeExample
#49 4.591 DateTimeExample.java:44: error: cannot find symbol
#49 4.592         LocalDate date = LocalDate.of(2024, 12, 30);
#49 4.592                          ^
#49 4.592   symbol:   variable LocalDate
#49 4.592   location: class DateTimeExample
#49 4.597 DateTimeExample.java:47: error: cannot find symbol
#49 4.597         DateTimeFormatter formatterYear = DateTimeFormatter.ofPattern("yyyy-MM-dd");
#49 4.597         ^
#49 4.597   symbol:   class DateTimeFormatter
#49 4.598   location: class DateTimeExample
#49 4.603 DateTimeExample.java:47: error: cannot find symbol
#49 4.603         DateTimeFormatter formatterYear = DateTimeFormatter.ofPattern("yyyy-MM-dd");
#49 4.603                                           ^
#49 4.603   symbol:   variable DateTimeFormatter
#49 4.604   location: class DateTimeExample
#49 4.648 DateTimeExample.java:51: error: cannot find symbol
#49 4.648         DateTimeFormatter formatterWeekYear = DateTimeFormatter.ofPattern("YYYY-MM-dd");
#49 4.648         ^
#49 4.648   symbol:   class DateTimeFormatter
#49 4.648   location: class DateTimeExample
#49 4.653 DateTimeExample.java:51: error: cannot find symbol
#49 4.654         DateTimeFormatter formatterWeekYear = DateTimeFormatter.ofPattern("YYYY-MM-dd");
#49 4.654                                               ^
#49 4.654   symbol:   variable DateTimeFormatter
#49 4.654   location: class DateTimeExample
#49 4.701 8 errors
#49 ERROR: process "/bin/sh -c javac DateTimeExample.java" did not complete successfully: exit code: 1
------
 > [java7 4/4] RUN javac DateTimeExample.java:
4.648         DateTimeFormatter formatterWeekYear = DateTimeFormatter.ofPattern("YYYY-MM-dd");
4.648         ^
4.648   symbol:   class DateTimeFormatter
4.648   location: class DateTimeExample
4.653 DateTimeExample.java:51: error: cannot find symbol
4.654         DateTimeFormatter formatterWeekYear = DateTimeFormatter.ofPattern("YYYY-MM-dd");
4.654                                               ^
4.654   symbol:   variable DateTimeFormatter
4.654   location: class DateTimeExample
4.701 8 errors
------

=========================================
Running Java 7 example
=========================================

#0 building with "desktop-linux" instance using docker driver

#1 [java7 internal] load build definition from Dockerfile.java7
#1 transferring dockerfile: 274B done
#1 DONE 0.0s

#2 [java7 internal] load metadata for docker.io/library/openjdk:7
#2 DONE 0.9s

#3 [java7 internal] load .dockerignore
#3 transferring context: 2B done
#3 DONE 0.0s

#4 [java7 1/4] FROM docker.io/library/openjdk:7@sha256:75a05dbcd254fdde1a284c5cc47a8f7d5387cd517cbf9e66d50d45da1c695022
#4 DONE 0.0s

#5 [java7 internal] load build context
#5 transferring context: 79B done
#5 DONE 0.0s

#6 [java7 2/4] WORKDIR /app
#6 CACHED

#7 [java7 3/4] COPY DateTimeExample.java .
#7 CACHED

#8 [java7 4/4] RUN javac DateTimeExample.java
#8 3.927 DateTimeExample.java:2: error: package java.time does not exist
#8 3.927 import java.time.LocalDate;
#8 3.927                 ^
#8 3.931 DateTimeExample.java:3: error: package java.time.format does not exist
#8 3.931 import java.time.format.DateTimeFormatter;
#8 3.932                        ^
#8 4.554 DateTimeExample.java:44: error: cannot find symbol
#8 4.555         LocalDate date = LocalDate.of(2024, 12, 30);
#8 4.555         ^
#8 4.555   symbol:   class LocalDate
#8 4.555   location: class DateTimeExample
#8 4.560 DateTimeExample.java:44: error: cannot find symbol
#8 4.560         LocalDate date = LocalDate.of(2024, 12, 30);
#8 4.560                          ^
#8 4.560   symbol:   variable LocalDate
#8 4.560   location: class DateTimeExample
#8 4.565 DateTimeExample.java:47: error: cannot find symbol
#8 4.565         DateTimeFormatter formatterYear = DateTimeFormatter.ofPattern("yyyy-MM-dd");
#8 4.565         ^
#8 4.565   symbol:   class DateTimeFormatter
#8 4.565   location: class DateTimeExample
#8 4.570 DateTimeExample.java:47: error: cannot find symbol
#8 4.571         DateTimeFormatter formatterYear = DateTimeFormatter.ofPattern("yyyy-MM-dd");
#8 4.571                                           ^
#8 4.571   symbol:   variable DateTimeFormatter
#8 4.571   location: class DateTimeExample
#8 4.615 DateTimeExample.java:51: error: cannot find symbol
#8 4.615         DateTimeFormatter formatterWeekYear = DateTimeFormatter.ofPattern("YYYY-MM-dd");
#8 4.615         ^
#8 4.615   symbol:   class DateTimeFormatter
#8 4.615   location: class DateTimeExample
#8 4.620 DateTimeExample.java:51: error: cannot find symbol
#8 4.620         DateTimeFormatter formatterWeekYear = DateTimeFormatter.ofPattern("YYYY-MM-dd");
#8 4.620                                               ^
#8 4.621   symbol:   variable DateTimeFormatter
#8 4.621   location: class DateTimeExample
#8 4.668 8 errors
#8 ERROR: process "/bin/sh -c javac DateTimeExample.java" did not complete successfully: exit code: 1
------
 > [java7 4/4] RUN javac DateTimeExample.java:
4.615         DateTimeFormatter formatterWeekYear = DateTimeFormatter.ofPattern("YYYY-MM-dd");
4.615         ^
4.615   symbol:   class DateTimeFormatter
4.615   location: class DateTimeExample
4.620 DateTimeExample.java:51: error: cannot find symbol
4.620         DateTimeFormatter formatterWeekYear = DateTimeFormatter.ofPattern("YYYY-MM-dd");
4.620                                               ^
4.621   symbol:   variable DateTimeFormatter
4.621   location: class DateTimeExample
4.668 8 errors
------

-----------------------------------------


=========================================
Running Java 8 example
=========================================

Running on Java 8:
---
Date Format Demonstration - yyyy vs YYYY

Java 7 Style (using SimpleDateFormat):
yyyy format: 2024-12-30
YYYY format: 2025-12-30
Note: In Java 7, SimpleDateFormat's YYYY might not handle week-based years correctly

Java 8+ Style (using DateTimeFormatter):
yyyy format: 2024-12-30
YYYY format: 2025-12-30
Note: In Java 8+, YYYY correctly handles week-based years
- yyyy represents the calendar year
- YYYY represents the week-based year (ISO week date)
  December 30, 2024 falls in the first week of 2025,
  hence YYYY shows 2025 instead of 2024

-----------------------------------------


=========================================
Running Java 11 example
=========================================

Running on Java 11:
---
Date Format Demonstration - yyyy vs YYYY

Java 7 Style (using SimpleDateFormat):
yyyy format: 2024-12-30
YYYY format: 2025-12-30
Note: In Java 7, SimpleDateFormat's YYYY might not handle week-based years correctly

Java 8+ Style (using DateTimeFormatter):
yyyy format: 2024-12-30
YYYY format: 2025-12-30
Note: In Java 8+, YYYY correctly handles week-based years
- yyyy represents the calendar year
- YYYY represents the week-based year (ISO week date)
  December 30, 2024 falls in the first week of 2025,
  hence YYYY shows 2025 instead of 2024

-----------------------------------------


=========================================
Running Java 17 example
=========================================

Running on Java 17:
---
Date Format Demonstration - yyyy vs YYYY

Java 7 Style (using SimpleDateFormat):
yyyy format: 2024-12-30
YYYY format: 2025-12-30
Note: In Java 7, SimpleDateFormat's YYYY might not handle week-based years correctly

Java 8+ Style (using DateTimeFormatter):
yyyy format: 2024-12-30
YYYY format: 2025-12-30
Note: In Java 8+, YYYY correctly handles week-based years
- yyyy represents the calendar year
- YYYY represents the week-based year (ISO week date)
  December 30, 2024 falls in the first week of 2025,
  hence YYYY shows 2025 instead of 2024

-----------------------------------------


=========================================
Running Java 21 example
=========================================

Running on Java 21:
---
Date Format Demonstration - yyyy vs YYYY

Java 7 Style (using SimpleDateFormat):
yyyy format: 2024-12-30
YYYY format: 2025-12-30
Note: In Java 7, SimpleDateFormat's YYYY might not handle week-based years correctly

Java 8+ Style (using DateTimeFormatter):
yyyy format: 2024-12-30
YYYY format: 2025-12-30
Note: In Java 8+, YYYY correctly handles week-based years
- yyyy represents the calendar year
- YYYY represents the week-based year (ISO week date)
  December 30, 2024 falls in the first week of 2025,
  hence YYYY shows 2025 instead of 2024

-----------------------------------------

Cleaning up...
All versions completed!
