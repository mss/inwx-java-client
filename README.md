inwx.com XML-RPC Java Client
=========
You can access all functions of our frontend via an application programming interface (API). Our API is based on the XML-RPC protocol and thus can be easily addressed by almost all programming languages. The documentation and programming examples in PHP, Java, Ruby and Python can be downloaded here.

There is also an OT&E test system, which you can access via ote.inwx.com. Here you will find the known web interface which is using a test database. On the OTE system no actions will be charged. So you can test how to register domains etc.

Documentation
------
You can view a detailed description of the API functions in our documentation. The documentation as PDF ist part of the Projekt. You also can read the documentation online http://www.inwx.de/en/help/apidoc

Building
--------
This project uses Maven to manage building and the dependencies.  Either import the project as a Maven project into your favourite IDE or execute `mvn clean package` on the command line.  The client will be available as `target/inwx-client.jar`.  The dependencies will be available under `target/dependency/`.

Example
-------
This project includes ax example client implementation.  Just execute `com.inwx.Example.main()`.  For example: `java -cp "target/inwx-client.jar:target/dependency/*" com.inwx.Example`

License
----
MIT
