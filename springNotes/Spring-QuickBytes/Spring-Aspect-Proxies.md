#Spring Notes

Spring Proxy or Aspect
======================
	- Proxy is nothing but an Aspect
	- Since Spring 4.3.0, everything is a Proxy
	- A potential element to impact the running of the application
	- Aspects add various behaviors to your class during runtime
	- Common Aspects - Transaction Management, Cache
	- You can write custom aspects 
	- Spring leverages two primary mechanisms for Proxy
		# JDK based - Interface based model
		# CGLIB based proxies - Sub class based model
	- Aspects can have a very positive reaction towards code reduction
	- Behavior added to classes only impacted by calls through the proxy
	- Behavior added is applicable at runtime ONLY to the public methods, and NOT private methods
	- Proxies operate outside the class
	- *Note* : The stack trace will NOT have the entries on the proxies as they are NOT a part of the same class, 
		unlike the typical method calls. It should be noted down during the JDBC/Database Interactions as
		there are lot of internal calls happen through proxy.
	
