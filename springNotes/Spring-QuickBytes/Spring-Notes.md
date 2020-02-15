# Spring Notes

##1. Annotations
----------------
	@Configuration
	@Bean
	@Value - to configure a property value bound to the configuration file [Syntax: @Value("${key.name}") ]
	@Autowired
	@Import - to load the external config file
	@PropertySource - to specify the configuration file (properties file)
	[TBD] @AliasFor
	@Profile("<Dev/Prod../">) - to specify an env specific property so that the rest of the things can be driven accordingly Ex Data Source
	@PropertySource("classpath:/application-${spring.profiles.active}.properties") - to load the env specific property file for all the @Values backed up
	@Scope("scopeName") - to determine the bean scope. Singleton(default), Prototype, Session and Request.

##2. Classes
-------------
	ApplicationContext
	AnnotationConfigApplicationContext

##3. Important Notes
------------------
	3.1. The properties being specific in the application.properties (or any other custom properties file) can be
		overridden by an environment variable - or a Command Line variable. Spring gives a precedence to those
		values set by via Command Line than the ones configured in the Properties file. It really helps in
		passing the sensitive data like Database Password etc., than storing them in the plain text files.

	3.2. Starting from Spring 3.0 version, the recommended version to configure the Beans is through Annotations, 
		though the legacy XML is still supported. Annotations reduce the code cluttering, errors in configuration,
		easy to use, Java friendly. 

	3.3. Spring Profiles helps you achieve the environment specific keys to be passed in the command line with the 
		Command Line Parameter (OR the environment variable) "spring.profiles.active" which can take any of the 
		possible values of your choice. For example, the one below sets the profile to prod for the appropriate execution.

			spring.profiles.active=prod

		Remember #1: This @Profile annotation has to be associated with a @Bean annotation which is of polymorphic type
		to get the dynamic variance based on the profile value being configured in properties file or passed as an environment
		variable during the execution.

		Remember #2: This property can be configured in application.properties as well and injected via @PropertySource with the file name
		passed as an argument. However, the thumb rule always works - where the environment property will supercede/overrride the
		values in the configuration file. 

	3.4. PropertySource with SPEL (Spring Expression Language) 
		@PropertySource can be specified with a properties file with the SPEL of the environment value configured in the Environment Value
		as follows.

			@PropertySource("classpath:/application-${spring.profiles.active}.properties") to load the environment specific property
		file for the further values configured. The actual value being looked up, will be injected to the property annotated with the
		@Value annotation. 

			@Value("${greeting.preamble"})
			private String preamble;

		There are no defaults here. Assume when there is no such environment value being configured or passed via command line, this will fail
		with the following exception thrown, which is self explanatory.

			Caused by: java.io.FileNotFoundException: class path resource [application-.properties] cannot be opened because it does not exist

	3.5. 	
