# RestService
=============

This is an example of a Rest embedded server in a java application using 
Jersey and Jetty. 

The 'RestService' directory has the source code for the servv 

The 'RestService/main/test' directory has a project to test the Rest interface.


Compiling using Maven
---------------------
To compile the server using Maven type:
mvn install in the 'RestService' directory.

To run the server type:  
java -cp target/RestService-1-jar-with-dependencies.jar com.alex.server.MinimalServerRest

To compile and run the test project type mvn test in the 'RestService'
directory (for the tests to succeed the server must be running).


API Examples 
------------
Show all users
http://localhost:9999/transfers/getUser/1

Show balance for user1
http://localhost:9999/transfers/getUser/1

Transfer 100.0 from user1 to user2
http://localhost:9999/transfers/transfer/1/2/100.0