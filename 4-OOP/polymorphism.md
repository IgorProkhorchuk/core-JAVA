Polymorphism is one of the four fundamental principles of object-oriented programming (OOP) in Java, alongside encapsulation, inheritance, and abstraction. The word "polymorphism" comes from the Greek words "poly" (many) and "morph" (form), meaning "many forms." In Java, polymorphism allows one object to take on multiple forms, meaning that a single action can behave differently depending on the context.

Polymorphism in Java can be categorized into two main types:
1. **Compile-time Polymorphism (Static Polymorphism)**: Achieved via **method overloading**.
2. **Runtime Polymorphism (Dynamic Polymorphism)**: Achieved via **method overriding** and **interfaces**.

These two types are achieved in different ways, and they serve different purposes, but both enable more flexible and scalable code.

### 1. Compile-time Polymorphism (Static Polymorphism)

#### Definition
Compile-time polymorphism occurs when the method to be called is determined at compile time. This is achieved through **method overloading** or **operator overloading** (Java does not support operator overloading, but method overloading is allowed). The term "static" refers to the fact that the binding of the method call to its definition occurs during the compilation process.

#### Method Overloading
**Method overloading** is a feature that allows a class to have multiple methods with the same name but different parameter lists (either in the number or type of parameters). Java resolves which method to invoke based on the arguments passed at compile time.

##### Example of Method Overloading:
```java
class Calculator {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method to add two doubles
    public double add(double a, double b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println(calc.add(2, 3));       // Calls add(int, int)
        System.out.println(calc.add(2, 3, 4));    // Calls add(int, int, int)
        System.out.println(calc.add(2.5, 3.5));   // Calls add(double, double)
    }
}
```

In this example:
- There are three versions of the `add()` method in the `Calculator` class.
- The method to be invoked is determined at **compile-time** based on the number and types of arguments passed to the method.

#### Characteristics of Compile-time Polymorphism:
- **Faster execution**: Because the method call is resolved at compile time, there’s no need for runtime decision-making, making this form of polymorphism faster than runtime polymorphism.
- **Flexibility**: Overloading provides flexibility in defining different behaviors for the same method name.
- **No inheritance required**: Unlike runtime polymorphism, method overloading does not require inheritance. It works purely within a class.

### 2. Runtime Polymorphism (Dynamic Polymorphism)

#### Definition
Runtime polymorphism occurs when the method to be invoked is determined at **runtime**. This is typically achieved using **method overriding**, where a subclass provides a specific implementation of a method already defined in its superclass. The actual method called depends on the object type, even if the reference variable is of the parent type. This is what makes the behavior "dynamic."

#### Method Overriding
Method overriding allows a subclass to provide a specific implementation of a method that is already present in its parent class. In overriding, the method signature (name, parameters, and return type) must be exactly the same.

##### Example of Method Overriding:
```java
class Animal {
    public void sound() {
        System.out.println("Animal makes a sound.");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks.");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Cat meows.");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Dog();  // Polymorphic reference
        myAnimal.sound();  // Calls Dog's version of sound() at runtime

        myAnimal = new Cat();  // Polymorphic reference to Cat object
        myAnimal.sound();  // Calls Cat's version of sound() at runtime
    }
}
```

In this example:
- The `sound()` method is overridden in both the `Dog` and `Cat` classes.
- Although the reference type (`myAnimal`) is `Animal`, the method that gets called at runtime depends on the actual object type (`Dog` or `Cat`). This is **runtime polymorphism**.

#### Characteristics of Runtime Polymorphism:
- **Dynamic binding**: The decision of which method to call is deferred until runtime, based on the actual object type.
- **Requires inheritance**: Runtime polymorphism depends on a subclass overriding methods from a superclass. Without inheritance, you cannot have runtime polymorphism.
- **Implementation of interfaces**: Runtime polymorphism can also be achieved by having a class implement an interface and overriding the interface's methods.

### Example with Interfaces and Runtime Polymorphism

Polymorphism can also be achieved using interfaces. When a class implements an interface, it must override the interface's methods, and the actual method that gets called at runtime is determined by the object type.

##### Example with Interfaces:
```java
interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle.");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a square.");
    }
}

public class Main {
    public static void main(String[] args) {
        Shape shape1 = new Circle();  // Polymorphic reference
        shape1.draw();  // Calls Circle's draw() method at runtime

        Shape shape2 = new Square();  // Polymorphic reference
        shape2.draw();  // Calls Square's draw() method at runtime
    }
}
```

Here, the `Shape` interface is implemented by both `Circle` and `Square`. At runtime, the actual object type (`Circle` or `Square`) determines which `draw()` method gets executed.

#### Summary of Runtime Polymorphism Features:
- **Method Overriding**: Achieved by subclass overriding methods of the superclass or by implementing an interface.
- **Late Binding**: The method to be invoked is determined at runtime, based on the object’s actual type.
- **Polymorphic References**: A parent class or interface reference can point to objects of different types (subclasses or implementing classes), and the correct method is called dynamically.
- **Extensibility**: This mechanism allows new behavior to be easily added by subclassing, without modifying existing code.

### Benefits of Polymorphism in Java

#### 1. **Code Reusability**
Polymorphism allows for the use of a single method or interface to handle multiple data types or subclasses. This reduces code duplication and improves maintainability.

Example:
```java
class Animal {
    public void eat() {
        System.out.println("Animal is eating.");
    }
}

class Lion extends Animal {
    @Override
    public void eat() {
        System.out.println("Lion is eating.");
    }
}

class Elephant extends Animal {
    @Override
    public void eat() {
        System.out.println("Elephant is eating.");
    }
}

public class Main {
    public static void feedAnimal(Animal animal) {
        animal.eat();  // Calls the correct version of eat() based on the actual object type
    }

    public static void main(String[] args) {
        feedAnimal(new Lion());      // Calls Lion's eat method
        feedAnimal(new Elephant());  // Calls Elephant's eat method
    }
}
```

This example demonstrates how polymorphism allows the same `feedAnimal()` method to work with different types of `Animal` objects.

#### 2. **Extensibility**
Polymorphism allows you to extend existing code without altering it. You can add new subclasses that override parent methods, and the code using polymorphic references will work seamlessly with the new subclasses.

Example:
```java
public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Lion();  // Extending behavior by introducing new subclasses
        myAnimal.eat();  // Will call Lion's eat method
    }
}
```

If a new class `Tiger` were added and the same `feedAnimal()` method was called, it would work without any changes.

#### 3. **Maintainability**
Since polymorphism allows you to write more general code, it makes your code easier to maintain. You can work with a superclass or an interface and allow the subclasses or implementing classes to provide specific behavior.

#### 4. **Reduces Coupling**
Polymorphism reduces the dependency between classes by allowing objects to interact through abstract interfaces or parent classes, making the system more flexible and scalable.

### Summary: Types of Polymorphism in Java

| Type of Polymorphism | Achieved By               | Binding Time  | Key Characteristics                                     |
|----------------------|---------------------------|---------------|--------------------------------------------------------|
| Compile-time Polymorphism (Static) | Method Overloading       | Compile Time  | Method calls are resolved at compile-time.              |
| Runtime Polymorphism (Dynamic)     | Method Overriding, Interfaces | Runtime      | Method calls are resolved based on the object type

 at runtime. |

### Conclusion

Polymorphism in Java is a powerful concept that enables flexibility and scalability in application development. It allows a single method or object to behave differently based on the context, reducing code duplication, promoting reusability, and enabling dynamic behavior at runtime. Whether it's through method overloading at compile-time or method overriding and interfaces at runtime, polymorphism forms the cornerstone of effective object-oriented design.