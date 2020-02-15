#Spring Notes

Spring LifeCycle Methods
-------------------------

	Typically a hook that gives an opportunity to perform any operations of your choice
	during or before the construction of the instance or the Application, and also before
	the shutdown of the Application.

	1. You can't perform any operations on the Proxiesi - as they are not always available.
	2. Construction Phase - call a Proxy of DataRepository or CacheRepository
	3. Destruction Phase
	4. Leveraging JSR-250, and NOT the Spring API.

Two different but most useful methods
-------------------------------------
	1. @PostConstruct 
	-----------------
		Similar to InitializingBeanInterface
		After the properties are set on all the beans, this method is called.

		Sample Code:
		-----------
		@PostConstruct
		public void init() {
			//.. Do some initilization
		}
	
	2. @PreDestroy
	-------------- 
		Similar to DisposableBean Interface
		Executed when ApplicationContext closes

		Sample Code:
		------------
		@PreDestroy
		public void destroy() {
			//... Do some closing work
		}

		Note: The Beans of type 'prototype' are not available to this @PreDestroy method,
		as Spring BeansFactory does not have any hold on those instances, because 
		they are closed /marked for GC as and when they are out of scope.

