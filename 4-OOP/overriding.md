Method overriding in Java is a feature that allows a subclass (child class) to provide a specific implementation of a method that is already defined in its superclass (parent class). The subclass "overrides" the method of the parent class, changing its behavior while maintaining the same method signature (method name and parameter list). This feature is an integral part of **runtime polymorphism** (dynamic method dispatch) and enables **late binding** of methods.

### Why Use Method Overriding?

Method overriding allows for more specialized behavior in subclasses while ensuring that the general structure remains the same. It is especially useful when we want to:
- **Customize or extend the behavior** of an inherited method without altering the parent class.
- Implement **runtime polymorphism**, which allows Java to decide at runtime which method (parent’s or child’s) to execute based on the object being referred to.

### Syntax of Method Overriding

The method in the subclass must have the following characteristics:
1. **Same method name** as in the parent class.
2. **Same parameter list** (number and types of parameters) as in the parent class.
3. **Same or more accessible access modifier** (public, protected, etc.).
4. The return type must be the same or a **covariant return type** (more on this later).

Example of Method Overriding:
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
        Animal myDog = new Dog();  // Create an object of type Dog
        myDog.sound();  // This will call the overridden method in Dog class
    }
}
```

In this example:
- The method `sound()` is defined in the `Animal` class, and it is overridden by the `Dog` class.
- The `Dog` class provides a more specific implementation of `sound()`.
- Even though the `myDog` object is of type `Animal`, the `sound()` method of the `Dog` class is called because the actual object is of type `Dog`. This demonstrates **runtime polymorphism**.

### Key Points about Method Overriding

#### 1. **Access Modifiers in Overriding**
The overridden method in the subclass must have the same or **more accessible** access modifier than the method in the parent class.
- If the parent class method is `protected`, the overriding method can be `protected` or `public`, but not `private` or default (package-private).
- If the parent class method is `public`, the overriding method must also be `public`.

Example:
```java
class Animal {
    protected void sleep() {
        System.out.println("Animal is sleeping.");
    }
}

class Dog extends Animal {
    @Override
    public void sleep() {
        System.out.println("Dog is sleeping.");
    }
}
```

In this case, both the parent class `sleep()` method and the child class `sleep()` method have `protected` access.

#### 2. **Return Types and Covariant Return Types**
The return type of the overriding method in the subclass must either:
- Be the **same** as the parent class method, or
- Be a **subtype** of the parent class method's return type (this is known as a **covariant return type**).

Example:
```java
class Animal {
    public Animal getAnimal() {
        return new Animal();
    }
}

class Dog extends Animal {
    @Override
    public Dog getAnimal() {  // Covariant return type
        return new Dog();
    }
}
```

Here, the method `getAnimal()` in the `Dog` class overrides the method in `Animal` class. The return type `Dog` is a subclass of `Animal`, making this a valid covariant return type.

#### 3. **Static Methods Cannot Be Overridden**
Static methods belong to the class rather than to any specific instance. As a result, static methods **cannot** be overridden. If a subclass defines a static method with the same name and parameters as the parent class, it is considered **method hiding**, not overriding.

Example of method hiding:
```java
class Animal {
    public static void sound() {
        System.out.println("Animal makes a sound.");
    }
}

class Dog extends Animal {
    public static void sound() {
        System.out.println("Dog barks.");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal.sound();  // Calls Animal's sound method (static method)
        Dog.sound();     // Calls Dog's sound method (method hiding, not overriding)
    }
}
```

In this case, the `sound()` method in `Dog` **hides** the `sound()` method in `Animal`, but no overriding occurs because they are static.

#### 4. **Final Methods Cannot Be Overridden**
If a method in the parent class is marked as `final`, it cannot be overridden in the subclass. This ensures that the method’s behavior is consistent and cannot be changed by any subclass.

Example:
```java
class Animal {
    public final void sound() {
        System.out.println("Animal makes a sound.");
    }
}

class Dog extends Animal {
    // This would cause a compile-time error
    // public void sound() {
    //     System.out.println("Dog barks.");
    // }
}
```

Since `sound()` is declared as `final` in the `Animal` class, attempting to override it in the `Dog` class results in a compile-time error.

#### 5. **The `super` Keyword in Method Overriding**
When a method is overridden, the `super` keyword can be used to call the parent class’s version of the method. This is useful if you want to retain some of the parent class’s behavior in addition to the new behavior in the subclass.

Example:
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

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();  // Calls Dog's sound method, which also calls Animal's sound method
    }
}
```

Output:
```
Animal makes a sound.
Dog barks.
```

In this example, the `sound()` method in the `Dog` class calls the `sound()` method in the `Animal` class using `super.sound()` and then adds its own behavior.

#### 6. **Runtime Polymorphism**
Method overriding is key to achieving runtime polymorphism in Java. When an overridden method is called on an object, the version of the method that is executed is determined by the actual type of the object at runtime, not by the reference type.

Example:
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
        Animal myAnimal = new Dog();  // Upcasting
        myAnimal.sound();  // Calls Dog's sound method (runtime polymorphism)

        myAnimal = new Cat();  // Upcasting to Cat
        myAnimal.sound();  // Calls Cat's sound method (runtime polymorphism)
    }
}
```

In this example:
- The reference variable `myAnimal` is of type `Animal`, but it can hold objects of any subclass of `Animal` (such as `Dog` or `Cat`).
- At runtime, the actual method (`sound()`) of the object type (either `Dog` or `Cat`) is called, demonstrating **runtime polymorphism**.

#### 7. **Annotations (`@Override`)**
Java provides the `@Override` annotation, which you can use to explicitly state that a method is overriding a method from a superclass. While this annotation is not required, it is good practice because:
- It makes the code more readable and self-explanatory.
- The compiler will issue an error if the method doesn’t correctly override the method in the parent class (e.g., if there’s a typo in the method signature).

Example:
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
```

By using `@Override`, you make it clear that `sound()` in `Dog` is an overridden method from `Animal`.

### Summary of Key Features in Method Overriding
- **Same method signature**: Overridden methods must have the same name, parameters, and return type as the parent method (or a covariant return type).
- **Access modifiers**: The overriding method must not be more restrictive in access than the parent method.
- **Annotations**: Use the `@Override` annotation to clarify that the method is overriding a parent method.
- **Cannot override static methods**: Static methods cannot be overridden; they can only be hidden.
- **Final methods**: Methods declared `final` in the parent class cannot be overridden.
- **`super` keyword**: Can be used in the overriding method to call the parent class’s version of the method.
-

 **Runtime polymorphism**: The method that gets executed depends on the runtime type of the object, not the reference type.

### Conclusion

Method overriding in Java is a powerful feature that allows a subclass to define its own version of a method inherited from a parent class. It plays a crucial role in runtime polymorphism and ensures flexibility and scalability in object-oriented programming by allowing different types of objects to behave in their own unique ways while sharing a common interface.