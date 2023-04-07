# Note:

## Install
`java --version`

`javac --version`

`mvn --version`

`gradle --version`

### Create Web Project
Start: start.spring.io

Definition: Maven Project + Java 17 + SpringBoot 3.0.2

Dependencies: Spring Web, Spring Data JPA, H2 Database

Metadata: 
	Group: SpringFramework
	Artifact: Web1
	Name: Web1
	Description: 1# Web application 
	Package name: SpringFramework.Web1
	Packaging: Jar

## [JPA](https://blog.csdn.net/weixin_45764765/article/details/107755857?ops_request_misc=&request_id=&biz_id=102&utm_term=leakage%20JPA%20JAva&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-2-107755857.142^v72^pc_new_rank,201^v4^add_ask&spm=1018.2226.3001.4187): Java Presistence API
### JPA Model: 
JPA is used with relational databases and NoSQL datastores
### [Creating POJO](https://www.geeksforgeeks.org/pojo-vs-java-beans/)
Plain Ordinary Java Object is an ordinary Java object - Java Beans, not bound by any special restriction. 
- two POJOs: `Author.java` and `Book.java`
- e.g. the model contains: firstName, lastName, Books. These are the objects that will we will be persisting into database with JPA. 
### `ORM` 实体关系映射 - Object-Relational model Mapping based on Hibernate. 
To make it official JPA entity:
- `@Entity` = Table: requires a primiary key - ID
- `@Id` = primary key: Add ID value for each object to make as JPA entities. Then JPA can store & retrive data from database by the entities (ID)(leakage).
- `@GeneratedValue(strategy = GenerationType.AUTO)`: Automatically ID generation.
### JPA Relationships: n : n
- one-to-one, one-to-many, many-to-one, many-to-many.
- `@ManyToMany(mappedBy = "")` indicating the relationship between author and books
- `@JoinTable()` the table that holds relationship btn author and books. More [details](https://docs.oracle.com/javaee/7/api/javax/persistence/JoinTable.html)

## Hibernate: 
一个轻量级的ORM框架, 它将 pojo 与数据库表建立映射关系.
### Equality
``Question: leakage between Object and relational models: Solve by implementing `equals()` and `hashCode()` method for the leakage``
- base equality on the `Id` as the object equality.
- rewrite the methods. Hibernate and set will consider as same object iff two objects has same ID. 

### Spring Data JPA: database operations
- Works with Hibernate. 
- Set up repo by building an interface which includes the implementation: `CrudRepository<type = Author, id_value = Long>`. It gives the implementation of methods (commands) for db operation.

## Initializing data & creating entities
bootstrap
- in BootStrapData by `CommandLineRunner`
- `@Component`: set as a spring managed component
- `dependency injection` the instances into constructor
- `run()`: set up information for author and book, and add in a book to the author, and author to the book by removing the constructor
- details for setting and saving data: see inside the file
- *`publisherRepository.save(publisher);` It MUST be the last one to save. `WHY???`*
- *Hibernate generates SQL DDL statement for creating database tables and inserting data based on JPA definition - defined below*

## Utilize H2 database console
Url: localhost:8080 (port can be found in console output when running the program)
- in `application.properties`: set `spring.h2.console.enabled=true`. 
- Then output console will print `H2 console available at '/h2-console'. Database available at`*<JDBC URL for location of database in menory>*
- Browse `http://localhost:8080/h2-console/` for login page. And make sure the JDBC URL matches. 
- Then able to modify & visualize database. 

## MVC: Model View Controller
design pattern for GUI and Web Applications
- Model: POJO with collection of properties
- View: JSP, Thymeleaf or HTML..
- Controller: Java class implemented to handle requesting mapping. Works in cojunction with a service (operations) which contains business logic. 
  
### Spring MVC:
check `springMVC.pdf`

- Spring Controllers `\Controllers\BookController`:
  - Annotate Controller Class with `@Controller`: registeres class as a Spring Brean and as a Controller in Spring MVC
  - To map mathods to http req paths by `@RequestMapping` to return data to `View`
- View: by [Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.1/usingthymeleaf.html#introducing-thymeleaf) Templates
  - add thyeleaf in configuration
  - command examples: `xmlns:th="http://www.thymeleaf.org"`, `th:each`, `th:text `
  - url: `http://localhost:8080/books`
  

## Dependency Injection & Inversion Control in OOP
### SOLID Principles of OOP:
- S: Single Responsibility Principle
- O: Open CLosed Principle
- L: Liskov Substitution Principle
- I: Interface Segregation Principle
- D: Dependency Inversion Principle

### Inversion of Control loC: 
the runtime environment of the code
- The control of DI is inverted to the framework
- Spring is in control of the injection of dependencies

### Dependency Injection DI:
The composition of the classes

- Let Framework do the management: No need to create a Controller Object, it's done by SpringFramework instead of SpringContexts. SpringFramework creates a new instance of the controller class, and put it into the context. Spring manages the construction of the controller, we just need to ask Spring to provide the object. 
- Dependency Injection is where a needed dependency is injected by another object. 
- Be pragmatic in what is and is not being managed in the Spring Context
- Types (through Junit test without spring):
  - By class properties: `/test/../PropertyIjectedControllerTest.java`
  - By Setters: `/text/../SetterInjectorCOntroller`
  - By Constructor: *best*
    - `private final` in controller: unable to change object if inside the object code
    - `/text/../ConstructorInjectedController`:
      - `controller = new ConstructorInjectedController(new GreetingServiceImp())`: creating a new constructor injected a controller and also at the same time creating that greeting service.
- Better using with interfaces rather than concrete class


- Controller selects one bean over multiple beans (class, setter, constructor services) for DI (多类型冲突):
  - Qualifier: `@Qualifier("beanName")` with `@Service("beanName")`
  - Primary Beans: `Primary`

- Spring Profiles: `I18nController` and `I18nEnglishGreetingService`
  - Different characteristics in beans which in configuration (data source). Two beans with different characteristics, they have same @Service("BeanName"), then distinguish them by @Profile("feature") -> controling Spring context among beans which to be loaded into the context at runtime
  - Allows to control Spring application in difference runtime environments
  - Run a profile for MySQL: controlling MySQL beans with a profile
  - `@Profile("beanName")`
  - `spring.profiles.active = beanName`
  - default profile (no active profiles enabled): `@Profile("", "default")`. Lower priority than active profiles

### Spring beans
life cycle : https://blog.csdn.net/keepfriend/article/details/121281051?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522168031147516800215054378%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=168031147516800215054378&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_click~default-2-121281051-null-null.142^v80^pc_new_rank,201^v4^add_ask,239^v2^insert_chatgpt&utm_term=spring%20bean&spm=1018.2226.3001.4187


### simple Project - Joke generator:
- `../spring5-jokes-app`
- Costume banner: http://patorjk.com/software/taag/#p=display&f=Big&t=This%20is%20Jesse


## Spring Pet Clinc
- database oriented application
- database: H2 (mySQL)
- 3 bean profiles
- caching: setting up configuring 
- Unit Testing: JUint5
- Info:
  - Maven, Java 17, SpringBoot 3.0.5
- Dependencies:
  - DevTools, Lombok, Spring Web, Thymeleaf, SPring Data JPA, H2 Database, MySQL Driver, SPring Boot Actuator