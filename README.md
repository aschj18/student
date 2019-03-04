

Student project
=====================

Example to build microservices based on [Java 8][0], [Gradle][1] and [Spring boot][2]. 
Example also include  run in [Docker][5] containers.

Prerequisites
_____________

In order to run this example on your machine you need docker installed.


How do I run this example?
--------------------------

*Run with gradle and Java*

You can run this example applications like any other Maven project. First, build the whole project by executing the following command in the top directory:

    ./gradlew clean package

After that you can start the 4 services with pure Java:

    java -jar build/libs/*.jar 
    

When everything runs fine and there are no *ERROR*s in your console output, 

*Run with Docker*

docker build -t myorg/myapp .

docker run -p 8080:8080 myorg/myapp

docker run -ti --entrypoint /bin/sh myorg/myapp



[0]: http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html
[1]: https://gradle.org/
[2]: https://spring.io/projects/spring-boot
[3]: 
[4]: 
[5]: https://www.docker.com/
