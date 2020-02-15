#Spring Notes

Annotation based Configuration
------------------------------
	- aka Component (based) scanning
	- Another way of configuring the ApplicationContext

Component
----------
	- @Component - indiactes that a class should be loaded into the BeanFactory
	- Tpyical stereotypes - @Controller, @Service, @Repository etc.,
	- Scans a base package to load all the appropriate beans automatically
	- Some of the stereotypes add additional behavior to the class through the proxy, eg, @Repository

Dependency Injection with Component Scanning
--------------------------------------------
	- Achieved through the @Autowired annotation
	- @Qualifier is used when multiple implementation of an interface are needed
	- Properties injected with @Value

Starting Component Scanning
---------------------------
	- Requires XML or Java configuration
	- Base package is defined in this configuration
	- Scanning occurs during startup
	- Benefit: No Need to declare @Bean for every other class, rather add an appropriate stereotype annotation

