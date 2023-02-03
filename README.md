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
ORM - object-relational mapping based on Hibernate. JPA is used with relational databases and NoSQL datastores.
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


