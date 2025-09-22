# JAVA
### 1. **Introduction to Java**
   - [What is Java?](1-Introduction_to_Java/WhatisJava.md) 
   - [History and evolution of Java](1-Introduction_to_Java/HistoryandevolutionofJava.md)
   - [Features of Java](1-Introduction_to_Java/FeaturesofJava.md)
   - [JVM, JRE, and JDK: Differences and roles](1-Introduction_to_Java/jvmjrejdk.md)

### 2. **Basic Syntax and Structure**
   - [Structure of a Java Program](2-Basic_syntax_and_structure/StructureofaJavaProgram.md)
   - [Java Keywords](2-Basic_syntax_and_structure/javaKeywords.md)
       - [static](2-Basic_syntax_and_structure/keywords/static.md)
   - [Data types: Primitive (int, char, boolean, etc.) and Non-primitive (String, Arrays)](2-Basic_syntax_and_structure/dataTypes.md)
       - Strings. Work with strings
       - [One-dimensional and multidimensional arrays](2-Basic_syntax_and_structure/oneDimentionalMultidimentionalArrays.md)
   - [Variables and Constants](2-Basic_syntax_and_structure/variablesAndConstants.md)
   - [Comments in Java](2-Basic_syntax_and_structure/commentsInJava.md)
   - [Javadoc](2-Basic_syntax_and_structure/javadoc.md)
   - [Operators]() (arithmetic, relational, logical, etc.)
   - [Input](2-Basic_syntax_and_structure/input.md) (Scanner, BufferedReader, DataInputStream)
   - [Output]() System.out.println(2-Basic_syntax_and_structure/output.md) 

### 3. **Control Flow Statements**
   - [Conditional Statements](3-control_flow_statements/conditionalStatements.md) (if, if-else, switch)
   - [Loops](3-control_flow_statements/loops.md) (for, while, do-while)
   - [Break and Continue](3-control_flow_statements/breakAndContinue.md)

### 4. **Object-Oriented Programming (OOP) in Java**
   - [Classes and Objects](4-OOP/classesAndObjects.md)
       - ["this" concept](4-OOP/this.md)
   - [Constructors and Initialization](4-OOP/constructorsAndInitialization.md)
   - [Methods:](4-OOP/methods.md) Definition, parameters, return types
   - [Method Overloading](4-OOP/overloading.md)
   - [`this` keyword](4-OOP/thisKeyword.md)
   - [Inheritance](4-OOP/inheritance.md)
     - [`super` keyword](4-OOP/superKeyword.md)
     - [Method Overriding](4-OOP/overriding.md)
   - [Polymorphism](4-OOP/polymorphism.md)
   - [Encapsulation](4-OOP/encapsulation.md)
   - [Abstraction](4-OOP/abstraction.md) (abstract classes, interfaces)
   - [Access Modifiers](4-OOP/accessModifiers.md) (private, public, protected, default)

### 5. **Exception Handling**
   - [What is an Exception?](5-exception_handling/whatIsAnException.md)
   - [Types of Exceptions](5-exception_handling/typesOfExceptions.md) (Checked and Unchecked)
   - [Try-catch blocks](5-exception_handling/tryCatch.md)
   - [Throw, throws](5-exception_handling/throwThrows.md)
   - [Custom exceptions](5-exception_handling/customExceptions.md)

### 6. **Java Collections Framework**
   - [Overview of Collections](6-Java_Collections_Framework/owerviewOfCollections.md)
   - List, Set, Map
       - [List](6-Java_Collections_Framework/list.md) (ArrayList, LinkedList)
       - [Set](6-Java_Collections_Framework/set.md) (HashSet, TreeSet, LinkedHashSet)
           - [ConcurrentSkipListSet](6-Java_Collections_Framework/concurrentSkipListSet.md)
       - [Map]() (HashMap, TreeMap LinkedHashMap, Hashtable, ConcurrentHashMap)
   - [Iterators](6-Java_Collections_Framework/iterators.md)
   - [Comparable and Comparator interfaces](6-Java_Collections_Framework/comparableComparator.md)

   #### Core Collections
      1. **List Interfaces and Implementations**
         - [ArrayList](6-Java_Collections_Framework/list.md)
         - LinkedList
         - Vector
         - Stack
         - CopyOnWriteArrayList
         - CopyOnWriteArraySet

      2. **Set Interfaces and Implementations**
         - HashSet
         - LinkedHashSet
         - TreeSet
         - EnumSet
         - ConcurrentSkipListSet
         - CopyOnWriteArraySet

      3. **Queue Interfaces and Implementations**
         - PriorityQueue
         - ArrayDeque
         - LinkedList (also a Queue)
         - ConcurrentLinkedQueue
         - ConcurrentLinkedDeque
         - BlockingQueue implementations:
         * ArrayBlockingQueue
         * LinkedBlockingQueue
         * PriorityBlockingQueue
         * DelayQueue
         * SynchronousQueue
         * LinkedTransferQueue

      4. **Map Interfaces and Implementations**
         - HashMap
         - LinkedHashMap
         - TreeMap
         - WeakHashMap
         - IdentityHashMap
         - EnumMap
         - Hashtable
         - ConcurrentHashMap
         - ConcurrentSkipListMap

   #### Specialized Collections
      1. **Unmodifiable/Immutable Collections (Java 9+)**
         - List.of()
         - Set.of()
         - Map.of()

      2. **Abstract Collection Classes**
         - AbstractList
         - AbstractSet
         - AbstractQueue
         - AbstractMap

      3. **Utility Collections**
         - Collections.singleton()
         - Collections.singletonList()
         - Collections.emptyList()
         - Collections.unmodifiableList()

   #### Additional Collections
      1. **Guava Collections** (from Google Guava library)
         - ImmutableList
         - ImmutableSet
         - ImmutableMap
         - Multiset
         - Multimap
         - BiMap

      2. **Apache Commons Collections**
         - Various extended collection types

### 7. **Generics**
   - [Introduction to Generics](7-Generics/introductionToGenerics.md)
   - [Generic Methods](7-Generics/genericMethods.md)
   - [Bounded Type Parameters](7-Generics/boundedTypeParameters.md)

### 8. **File Handling in Java**
   - [File Class](8-file_Handling/fileClass.md)
   - [Path Class](8-file_Handling/pathClass.md)
   - [Files Class](8-file_Handling/filesClass.md)
   - [Reading and Writing to Files](8-file_Handling/readinWritingToFiles.md)
   - [BufferedReader, BufferedWriter](8-file_Handling/bufferedReaderBufferedWriter.md)
   - [Serialization and Deserialization](8-file_Handling/serializationDeserialization.md)

### 9. **Multithreading**
   - [Introduction to Threads](9-Multithreading/introductionToThreads.md)
   - [Creating Threads (Runnable Interface, Thread class)](9-Multithreading/creatingThreads.md)
   - [Thread Lifecycle](9-Multithreading/threadLifecycle.md)
   - [Synchronization and Inter-thread Communication](9-Multithreading/syncInterThreadCommunication.md)
   - [Thread Priority](9-Multithreading/threadPriority.md)

### 10. **Java 8 Features (and beyond)**
   - [Lambda Expressions](10-Java_8_features_and_beyond/lambdaExpressions.md)
   - Stream API
   - Functional Interfaces
   - Default and Static Methods in Interfaces
   - Optional class
   - Method References

### 11. **Java Memory Management**
   - Stack vs Heap
   - Garbage Collection
   - Strong, Weak, Soft, and Phantom References

### 12. **Working with Databases**
   - JDBC (Java Database Connectivity)
   - Connecting Java to a Database
   - CRUD Operations using JDBC

### 13. **Networking in Java**
   - Sockets
   - URL and URLConnection classes
   - HTTP Requests

### 14. **Popular Libraries and Frameworks**
   - Maven and Gradle (Dependency Management)
       - [Fat Jar (Uber Jar)](14-01-Maven/fatJar-UberJar.md)
   - Spring Framework (Introduction)
       - [Spring Security Filters](14-1-springBoot/securityFilters.md)
   - Hibernate (Introduction)

### 15. **Best Practices and Design Patterns**
   - DRY, SOLID principles
   - Common design patterns (Singleton, Factory, Observer, etc.)

---

