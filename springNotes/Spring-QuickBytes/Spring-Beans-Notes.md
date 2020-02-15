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

Spring Bean Autowiring
----------------------
	Helps achieving a good encapsulation of the attributes and the dependency management
	In Spring, it is taken care by the IoC Container.
	Is a boon and curse - depends on how you use Autowiring.
	If not properly used, Autowiring can lead to a poorly written code.

	Types of Autowiring
	-------------------
	1. Field Level Injection
		- Private methods can be autowired
		- Difficult to be tesed by the other public API - like Unit Testing and Mocking frameworks. 
		- Not recommended until situation really demands.

		Sample Code:
		------------
		@Autowired
		private final InventoryService inventoryService;

	2. Setter Level Injection
		- Downside is you might possibly allow the other components to allow the data to be modified
		- Depends on the situation, as long as the data modified does not alter the scope/state of the application
		- Used for optional dependencies
		- Used for Changing dependencies

		Sample Code:
		------------
		private InventoryService inventoryService; //leave the private field as it is

		@Autowired
		public void setInventoryService(InventoryService inventoryService) {
			this.inventoryService = inventoryService;
		}

	3. Constructor Injection
		- Preferred method for most situations for all dependencies
		- Attribute should be final, class should be immutable
		- Provides a much better level of encapsulation and OO design

		Sample Code
		-----------
		private InventoryService inventoryService; //field is untouched and left as private

		@Autowired
		public OrderServiceImpl(InventoryService inventoryService) { //constructor
			this.inventoryService = inventoryService;
		}
 	
