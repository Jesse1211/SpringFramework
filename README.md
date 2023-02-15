# Note:

## Install
`java --version`

`javac --version`

`mvn --version`

`gradle --version`

## Spring Initializr: 

It forms (generates) a project

###	Spring Boot Starters: 
A curated set of dependencies, given a konwn component with listed needed dependencies. => include one component == include multiple dependencies

### start.spring.io:
Web front end on Spring Initializr to view and select components

### Create Web Project

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
`ORM` - object-relational model mapping based on Hibernate. JPA is used with relational databases and NoSQL datastores.
### [Creating POJOS](https://www.geeksforgeeks.org/pojo-vs-java-beans/)
a plain old Java object is an ordinary Java object, not bound by any special restriction. 
- Add a `package` in `SpringFramework.Web1` and name it as `domain`
- Add classes `Author.java` and `Book.java` for two POJOs
- e.g. the model contains: firstName, lastName, Books. These are the objects that will we will be persisting into database with JPA. 
### JPA Id's
Add ID value for each object to make as JPA entities. Then JPA can store & retrive data from database by the entities (ID)(leakage).

To make it official JPA entity:
- Add `@Entity` notation which requires a primiary key - ID
- Add variable `id` and `@Id` to indicate its the primiary key
- Add `@GeneratedValue(strategy = GenerationType.AUTO)` for how the primiary key is generated: Automatically ID generation. Which means the value of primiary key is assigned/managed by database. 
- 
### JPA Relationships: n : n
- `@ManyToMany(mappedBy = "")` indicating the relationship between author and books
- `@JoinTable()` the table that holds relationship btn author and books. More [details](https://docs.oracle.com/javaee/7/api/javax/persistence/JoinTable.html)

## Work with Hibernate
### Equality
`Question: leakage between Object and relational models`

Implementing `equals()` and `hashCode()` method for the leakage
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
  
## Dependency Conjection & Inversion Control