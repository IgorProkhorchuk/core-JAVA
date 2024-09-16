### Abstraction

**Abstraction** is one of the fundamental concepts of object-oriented programming (OOP) in Java, along with encapsulation, inheritance, and polymorphism. Abstraction is the process of hiding the implementation details of an object or function and exposing only the essential features to the users. This allows the user to interact with objects and functions at a high level without worrying about the complexity behind them.

In Java, abstraction focuses on creating a simplified interface to interact with complex systems or objects. It allows developers to work with concepts at a higher level of functionality, without needing to understand the inner workings of the system.

Java provides two main mechanisms to achieve abstraction:
1. **Abstract Classes**
2. **Interfaces**

### Purpose of Abstraction

- **Hide complexity**: The user doesn't need to know the implementation details, only the functionality.
- **Enhance code readability**: By interacting with a simplified interface, the complexity of the code is reduced, making it easier to maintain and extend.
- **Improve flexibility and scalability**: By decoupling the implementation from the user, the internal implementation can change without affecting the external code that uses the abstraction.

### Types of Abstraction

In Java, abstraction can be achieved at two levels:
1. **Abstract Class (Partial Abstraction)**: Abstract classes allow for partial abstraction because they can have both abstract methods (without implementation) and concrete methods (with implementation).
2. **Interfaces (Complete Abstraction)**: Interfaces provide complete abstraction because they can only contain method declarations (prior to Java 8) and do not contain any implementation details. In Java 8 and later, interfaces can have default methods with implementations, but these are still abstract by nature in how they are used.

### 1. Abstract Classes

#### Definition
An **abstract class** is a class that cannot be instantiated directly. It can contain both abstract methods (without implementation) and concrete methods (with implementation). Abstract classes are meant to be extended by other classes, which provide implementations for the abstract methods.

#### Syntax of Abstract Classes:
```java
abstract class Vehicle {
    // Abstract method (no implementation)
    abstract void start();

    // Concrete method (with implementation)
    public void stop() {
        System.out.println("Vehicle has stopped.");
    }
}

class Car extends Vehicle {
    // Providing implementation for the abstract method
    @Override
    void start() {
        System.out.println("Car is starting.");
    }
}

class Main {
    public static void main(String[] args) {
        // Cannot instantiate an abstract class
        // Vehicle vehicle = new Vehicle(); // This will cause an error

        // Instantiating the subclass
        Vehicle myCar = new Car();
        myCar.start();  // Output: Car is starting.
        myCar.stop();   // Output: Vehicle has stopped.
    }
}
```

#### Key Points about Abstract Classes:
- **Cannot be instantiated**: You cannot create an object of an abstract class. It must be extended by a subclass, which provides concrete implementations for the abstract methods.
- **Can contain both abstract and concrete methods**: This allows abstract classes to define common behaviors (using concrete methods) that all subclasses share, while leaving certain methods for the subclasses to define (abstract methods).
- **Can have fields**: Abstract classes can have fields (data members), constructors, and fully defined methods.
- **Can define shared functionality**: Since abstract classes can contain concrete methods, they can provide common functionality that subclasses inherit.

#### Use Cases for Abstract Classes:
- Use abstract classes when you want to create a base class that defines common behavior or properties for all subclasses, but you also want to allow some specific behaviors to be defined by each subclass.
- When you need to share code between closely related classes (e.g., classes in the same hierarchy like `Animal` or `Vehicle`), use an abstract class.

### Example of an Abstract Class:

```java
abstract class Animal {
    // Abstract method
    abstract void sound();

    // Concrete method
    public void sleep() {
        System.out.println("The animal is sleeping.");
    }
}

class Dog extends Animal {
    // Implementing the abstract method
    @Override
    public void sound() {
        System.out.println("The dog barks.");
    }
}

class Cat extends Animal {
    // Implementing the abstract method
    @Override
    public void sound() {
        System.out.println("The cat meows.");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.sound();   // Output: The dog barks.
        dog.sleep();   // Output: The animal is sleeping.

        Animal cat = new Cat();
        cat.sound();   // Output: The cat meows.
        cat.sleep();   // Output: The animal is sleeping.
    }
}
```

In this example:
- `Animal` is an abstract class that defines an abstract method `sound()` and a concrete method `sleep()`.
- The `Dog` and `Cat` classes extend `Animal` and provide concrete implementations of the `sound()` method.
- The `sleep()` method is inherited as-is from the `Animal` class.

### 2. Interfaces

#### Definition
An **interface** in Java is a blueprint for a class. It defines a contract that the implementing classes must follow by providing method declarations (but no implementations, prior to Java 8). Interfaces achieve **complete abstraction**, meaning the user of the interface doesn't know or care about the underlying implementation.

#### Syntax of an Interface:
```java
interface Vehicle {
    // Abstract method (implicitly public and abstract)
    void start();

    // Since Java 8, an interface can have default methods
    default void stop() {
        System.out.println("Vehicle has stopped.");
    }
}

class Car implements Vehicle {
    // Providing implementation for the abstract method
    @Override
    public void start() {
        System.out.println("Car is starting.");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        myCar.start();  // Output: Car is starting.
        myCar.stop();   // Output: Vehicle has stopped.
    }
}
```

#### Key Points about Interfaces:
- **100% abstraction** (before Java 8): Prior to Java 8, interfaces could only declare methods without implementation. This means interfaces were entirely abstract.
- **Cannot have fields**: Interfaces cannot have instance variables (except for constants, which are implicitly `public`, `static`, and `final`).
- **Multiple inheritance**: A class can implement multiple interfaces, allowing for a form of multiple inheritance in Java.
- **Default and static methods (Java 8+)**: Since Java 8, interfaces can have `default` methods with concrete implementations, and `static` methods as well.
- **Functional interfaces (Java 8+)**: With Java 8, the concept of functional interfaces was introduced. These interfaces contain exactly one abstract method and are used in lambda expressions.

#### Example of Multiple Inheritance with Interfaces:

```java
interface Drivable {
    void drive();
}

interface Flyable {
    void fly();
}

class FlyingCar implements Drivable, Flyable {
    @Override
    public void drive() {
        System.out.println("Driving the car.");
    }

    @Override
    public void fly() {
        System.out.println("Flying the car.");
    }
}

public class Main {
    public static void main(String[] args) {
        FlyingCar flyingCar = new FlyingCar();
        flyingCar.drive();  // Output: Driving the car.
        flyingCar.fly();    // Output: Flying the car.
    }
}
```

In this example, `FlyingCar` implements two interfaces (`Drivable` and `Flyable`), demonstrating how a class can inherit behavior from multiple interfaces.

### Abstract Class vs Interface

| Feature               | Abstract Class                               | Interface                                      |
|-----------------------|----------------------------------------------|------------------------------------------------|
| **Methods**            | Can have both abstract and concrete methods  | Can only have abstract methods (before Java 8) |
| **Fields**             | Can have instance variables                  | Cannot have instance variables (only constants)|
| **Access Modifiers**   | Methods can have any access modifier         | Methods are implicitly `public` and `abstract` |
| **Multiple Inheritance**| Single inheritance only                     | Multiple inheritance is allowed                |
| **Instantiation**      | Cannot be instantiated                       | Cannot be instantiated                         |
| **Default Methods**    | No default methods                           | Can have default and static methods (Java 8+)  |

### Benefits of Abstraction

1. **Reduced Complexity**: By exposing only relevant details and hiding unnecessary complexities, abstraction makes the code easier to use and understand.
2. **Increased Flexibility**: Abstraction enables code to change and evolve without breaking other parts of the application that rely on the abstracted functionality.
3. **Better Modularity**: Code is divided into distinct components (interfaces and abstract classes) that focus on specific responsibilities, promoting modular design.
4. **Reusability**: Abstraction encourages the use of common interfaces or base classes, which can be reused by different parts of the application or by different applications.
5. **Loose Coupling**: Abstraction reduces dependencies between different components in a system. This makes the system more flexible and scalable, as changes to one component are less likely to affect others.

### When to Use Abstraction

- **Abstract Classes**: Use an abstract class when you have common functionality that should be shared across several closely related classes. Abstract classes are ideal when the classes share a common base and you want to provide some default behavior (using concrete methods) while leaving other methods to be defined by subclasses.
  
- **Interfaces**: Use interfaces when you need to define a contract for unrelated classes that may not share a common base. Interfaces are ideal

 when you need multiple inheritance, or when you want to provide a standardized way for classes to interact with each other without being tightly coupled to a specific implementation.

### Conclusion

Abstraction in Java allows developers to focus on what an object does rather than how it does it. By using abstract classes and interfaces, Java promotes flexibility, maintainability, and scalability in application design. While abstract classes provide partial abstraction, interfaces provide complete abstraction. Together, they form the foundation for writing flexible, reusable, and modular code.