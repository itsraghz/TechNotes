# Spring Notes

Spring Bean
-----------
	A Typical POJO class can be converted to a bean with the Annotation @Bean.
	Can be used in the other classes wherever it is needed - with @Autowired annotation, 
		where Spring IOC Container serves the references of this bean to the consumers
	Scope can be specified with an additional annotation @Scope("<NameOfScope>")

Spring Bean Scopes
-------------------
	1. Singleton
		- Default scope
		- One instance per Context (ApplicationContext)
		- Be Careful with the Static data
		- Available till the container shuts down

	2. Prototype
		- New Instance everytime it is referred
		- Definition is stored in the factory, but instances are not
		- Eligible for GC the minute the instance is going out of scope/task, not until the container shuts down
		- Very useful for the transient data or types that flex based on application state

	3. Session
		- Applicable only in the Web environment (Spring-Web)
		- One instance of the bean per user Session
		- Goes out of scope when the session itself is invalidated
		- Definition stored in the bean factory, instances are not

	4. Request
		- Applicable only in the Web environment (Spring-Web) - like Session
		- One instance per request (HttpRequest)
		- Defintion stored in the bean factory, instances are not
		- Eligible for GC once the instance is out of scope (on the request)
 	
