Inheritance is a fundamental concept in object-oriented programming (OOP), including Java. It allows a new class (subclass or child class) to inherit properties and behaviors (fields and methods) from an existing class (superclass or parent class). This promotes code reuse and establishes a natural hierarchy between classes.

In Java, inheritance is established using the `extends` keyword. Let’s dive deep into various aspects of inheritance in Java.

### 1. **Basic Concept of Inheritance**
When a class inherits from another class, it acquires the fields and methods of the parent class. This allows the child class to:
- Use methods and fields of the parent class as if they were its own.
- Add new methods and fields or modify the inherited ones.

Here's a basic example:

```java
// Parent Class (Super Class)
class Animal {
    String name;
    
    public void eat() {
        System.out.println("This animal eats food.");
    }
}

// Child Class (Sub Class)
class Dog extends Animal {
    
    public void bark() {
        System.out.println("The dog barks.");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name = "Buddy"; // Inherited field
        dog.eat();          // Inherited method
        dog.bark();         // Child class's own method
    }
}
```

In this example, the `Dog` class inherits from the `Animal` class, so the `Dog` object can access the `name` field and the `eat()` method from `Animal`. In addition, it has its own method `bark()`.

### 2. **Types of Inheritance in Java**
Java supports **single inheritance** and **multilevel inheritance** but **not multiple inheritance** using classes.

#### a. **Single Inheritance**
A child class inherits from only one parent class. This is the most straightforward form of inheritance.

```java
class Parent {
    public void display() {
        System.out.println("This is the parent class.");
    }
}

class Child extends Parent {
    public void show() {
        System.out.println("This is the child class.");
    }
}
```

Here, `Child` inherits from `Parent`, forming a direct parent-child relationship.

#### b. **Multilevel Inheritance**
A class can inherit from another class, which in turn inherits from yet another class, forming a chain. For example:

```java
class Animal {
    public void eat() {
        System.out.println("Animal eats.");
    }
}

class Mammal extends Animal {
    public void walk() {
        System.out.println("Mammal walks.");
    }
}

class Dog extends Mammal {
    public void bark() {
        System.out.println("Dog barks.");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();  // Inherited from Animal
        dog.walk(); // Inherited from Mammal
        dog.bark(); // Defined in Dog
    }
}
```

Here, `Dog` inherits from `Mammal`, which in turn inherits from `Animal`. As a result, `Dog` inherits both `walk()` and `eat()` methods.

#### c. **Multiple Inheritance (Not Supported with Classes)**
Java does not support multiple inheritance with classes, i.e., a class cannot directly inherit from more than one class. For example, the following is **not allowed**:

```java
class A {
    // Some code
}

class B {
    // Some code
}

// This is not allowed in Java
class C extends A, B {
    // Some code
}
```

However, **multiple inheritance** is supported using **interfaces** (discussed below).

### 3. **Method Overriding in Inheritance**
When a subclass provides its own implementation of a method that is already defined in its parent class, this is called **method overriding**. Overriding allows the subclass to change or extend the behavior of methods it inherits.

To override a method, the method in the subclass must have:
- The same name as the method in the parent class.
- The same parameter list (i.e., method signature).
- The same or a more accessible access modifier.

Here’s an example of method overriding:

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

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.sound();  // Output: Animal makes a sound.
        
        Dog dog = new Dog();
        dog.sound();     // Output: Dog barks. (overridden method)
    }
}
```

In this case, the `Dog` class overrides the `sound()` method from the `Animal` class to provide its own implementation.

#### The `@Override` Annotation
It’s a good practice to use the `@Override` annotation when overriding a method. This helps to catch errors if the method signature doesn’t match exactly with the method in the parent class.

### 4. **The `super` Keyword**
The `super` keyword is used in Java to refer to the parent class. It serves several purposes:

#### a. **Calling the Parent Class’s Constructor**
When a child class is instantiated, the constructor of the parent class is automatically called before the child class’s constructor. However, you can explicitly call a specific parent class constructor using `super()`.

```java
class Animal {
    public Animal() {
        System.out.println("Animal constructor called.");
    }
}

class Dog extends Animal {
    public Dog() {
        super(); // Calls the Animal constructor
        System.out.println("Dog constructor called.");
    }
}
```

The output would be:
```
Animal constructor called.
Dog constructor called.
```

#### b. **Calling the Parent Class’s Method**
The `super` keyword can also be used to call a method from the parent class when it has been overridden in the child class.

```java
class Animal {
    public void sound() {
        System.out.println("Animal makes a sound.");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        super.sound();  // Calls the parent class method
        System.out.println("Dog barks.");
    }
}
```

Output:
```
Animal makes a sound.
Dog barks.
```

Here, `super.sound()` calls the `sound()` method from the `Animal` class, and the `Dog` class adds its behavior after that.

### 5. **Inheritance and Constructors**
In Java, constructors are **not inherited**. However, when you create an instance of a subclass, the parent class’s constructor is always invoked before the subclass’s constructor.

If the parent class has a no-argument constructor, it will be called automatically. But if the parent class has parameterized constructors, you must explicitly call them from the subclass using `super()`.

### 6. **Inheritance and Access Control**
Access to the inherited fields and methods depends on the access modifier (e.g., `private`, `protected`, `public`, `default`):
- **private**: The members of the parent class marked as `private` cannot be accessed directly by the subclass.
- **protected**: Subclass has access to `protected` members of the parent class, even if they are in different packages.
- **public**: Subclass can access `public` members of the parent class.
- **default (package-private)**: Subclass can access default members only if they are in the same package as the parent class.

### 7. **Final Keyword and Inheritance**
- **Final Classes**: If a class is marked as `final`, it cannot be extended.
  
  ```java
  final class Animal {
      // Code
  }
  
  // This is not allowed
  class Dog extends Animal {
      // Code
  }
  ```

- **Final Methods**: If a method is marked as `final`, it cannot be overridden in the subclass.
  
  ```java
  class Animal {
      public final void sound() {
          System.out.println("Animal makes a sound.");
      }
  }
  
  class Dog extends Animal {
      // This would cause a compile-time error
      @Override
      public void sound() {
          System.out.println("Dog barks.");
      }
  }
  ```

### 8. **Multiple Inheritance via Interfaces**
While Java doesn't support multiple inheritance through classes, it allows multiple inheritance through **interfaces**. An interface defines a contract that a class can implement, and a class can implement multiple interfaces.

```java
interface CanRun {
    void run();
}

interface CanBark {
    void bark();
}

class Dog implements CanRun, CanBark {
    public void run() {
        System.out.println("Dog is running.");
    }

    public void bark() {
        System.out.println("Dog is barking.");
    }
}
```

In this example, `Dog` implements two interfaces, allowing it to inherit behaviors from multiple sources.

### Summary of Inheritance in Java
- **Single inheritance** allows a subclass to inherit from one superclass.
- **Multilevel inheritance** allows a subclass to inherit from a parent class that is itself a child of another class.
- **Method overriding** allows a subclass to provide a specific implementation of a method inherited from a superclass.
- **The `super` keyword** is used to access the parent class’s members.
- **Multiple inheritance** is not supported using classes but can be achieved using interfaces.
- **Access control** defines what members of the parent class are accessible in the child class based on access modifiers.