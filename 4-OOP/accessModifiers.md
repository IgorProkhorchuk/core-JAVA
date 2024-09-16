### Access Modifiers

In Java, **access modifiers** are keywords used to define the visibility or scope of classes, variables, methods, and constructors. They help in controlling how different parts of a Java program can access other parts of the code, ensuring encapsulation and security. Java has four main access modifiers:

1. **Private**
2. **Default (Package-Private)**
3. **Protected**
4. **Public**

Each of these modifiers determines the accessibility level of the class members and classes themselves.

### Access Modifiers and Their Scope

| Access Modifier | Within Class | Within Package | Subclass (Outside Package) | World (Outside Package) |
|-----------------|--------------|----------------|----------------------------|--------------------------|
| `private`       | Yes          | No             | No                         | No                       |
| `default`       | Yes          | Yes            | No                         | No                       |
| `protected`     | Yes          | Yes            | Yes (through inheritance)   | No                       |
| `public`        | Yes          | Yes            | Yes                        | Yes                      |

#### 1. **Private Modifier**

The `private` modifier restricts the visibility of a class member (variable, method, constructor) to **within the class itself**. If a field or method is marked as `private`, it cannot be accessed by other classes or even subclasses.

##### Syntax:
```java
class Example {
    private int data;

    private void displayData() {
        System.out.println(data);
    }
}
```

In this example:
- The field `data` and method `displayData()` are `private`, so they cannot be accessed outside the `Example` class.

##### Key Features of `private`:
- Only accessible within the **same class**.
- Used to implement **encapsulation**.
- Typically, private fields are accessed and modified using **public getter and setter** methods.
  
##### Example:
```java
class BankAccount {
    // Private fields
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Public method to access private field
    public double getBalance() {
        return balance;
    }

    // Public method to modify private field
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Private helper method
    private void showTransactionMessage() {
        System.out.println("Transaction complete.");
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        account.deposit(500);
        System.out.println("Balance: " + account.getBalance());

        // The following line would cause a compile-time error
        // account.showTransactionMessage(); // Error: showTransactionMessage() has private access in BankAccount
    }
}
```

#### 2. **Default (Package-Private) Modifier**

When no access modifier is specified, Java applies the **default** access modifier, also known as **package-private**. Members with default access are accessible **within the same package** but not from outside the package.

##### Syntax:
```java
class Example {
    int data; // default access

    void displayData() { // default access
        System.out.println(data);
    }
}
```

In this example:
- The field `data` and method `displayData()` have **default** access, meaning they can be accessed by other classes within the same package but not by classes in other packages.

##### Key Features of Default (Package-Private):
- Accessible within the **same package**.
- Not accessible from classes in **other packages**.
- Often used when you want to expose the class members to other classes within the same package but hide them from classes in other packages.

##### Example:
```java
// File: com/example/Person.java
package com.example;

class Person {
    String name; // Default access

    void setName(String name) {
        this.name = name;
    }
}

// File: com/example/Main.java
package com.example;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Alice");
        System.out.println(person.name); // Accessible within the same package
    }
}
```

In this example, the `name` field and `setName()` method have default access, so they are accessible within the `com.example` package.

#### 3. **Protected Modifier**

The `protected` modifier allows access to class members **within the same package** and to **subclasses** (even if they are in different packages). This is useful when you want to restrict access but allow subclasses to inherit and modify the behavior of the class members.

##### Syntax:
```java
class Example {
    protected int data; // protected access

    protected void displayData() { // protected access
        System.out.println(data);
    }
}
```

In this example:
- The `data` field and `displayData()` method are marked as `protected`, meaning they can be accessed by other classes in the same package and by subclasses in other packages.

##### Key Features of `protected`:
- Accessible within the **same package**.
- Accessible from **subclasses**, even in **other packages**.
- Often used when you want to allow access to class members by subclasses but restrict access from other non-related classes.

##### Example:

```java
// File: com/example/Animal.java
package com.example;

public class Animal {
    protected String type;

    protected void setType(String type) {
        this.type = type;
    }
}

// File: com/example/Main.java
package com.example;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.setType("Mammal");
        System.out.println(animal.type); // Accessible within the same package
    }
}

// File: com/example2/Dog.java
package com.example2;

import com.example.Animal;

public class Dog extends Animal {
    public void displayType() {
        // Protected member is accessible in subclass
        setType("Dog");
        System.out.println(type); // Accessible due to inheritance
    }
}
```

In this example:
- The `Animal` class defines the `type` field and `setType()` method as `protected`, meaning they are accessible within the `com.example` package and also to the `Dog` class, which extends `Animal` from a different package (`com.example2`).

#### 4. **Public Modifier**

The `public` modifier makes a class, method, or variable accessible from **anywhere** in the Java program, including from different classes, packages, or modules.

##### Syntax:
```java
public class Example {
    public int data; // public access

    public void displayData() { // public access
        System.out.println(data);
    }
}
```

In this example:
- The `data` field and `displayData()` method are marked as `public`, meaning they can be accessed from anywhere in the program, including other classes and packages.

##### Key Features of `public`:
- **Accessible from anywhere**: Any class or package can access `public` members, regardless of their location.
- The most open form of access in Java, suitable for APIs or functionality that should be freely available across the application.

##### Example:

```java
// File: com/example/Car.java
package com.example;

public class Car {
    public String model;

    public Car(String model) {
        this.model = model;
    }

    public void showModel() {
        System.out.println("Model: " + model);
    }
}

// File: com/example/Main.java
package com.example;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Tesla Model 3");
        car.showModel(); // Output: Model: Tesla Model 3
    }
}

// File: com/other/OutsidePackage.java
package com.other;

import com.example.Car;

public class OutsidePackage {
    public static void main(String[] args) {
        Car car = new Car("Audi A4");
        car.showModel(); // Accessible because Car and its methods are public
    }
}
```

In this example:
- The `Car` class and its methods (`model` and `showModel()`) are marked as `public`, so they can be accessed from both the `com.example` and `com.other` packages.

### Access Modifiers for Classes

Java applies access modifiers not only to class members (fields, methods) but also to classes themselves. However, only two access modifiers can be applied to classes: `public` and **default** (package-private).

#### 1. **Public Class**

If a class is marked as `public`, it can be accessed from **anywhere** in the program. However, a Java file can only contain one `public` class, and the name of the file must match the name of the `public` class.

##### Syntax:
```java
public class Example {
    // Class body
}
```

#### 2. **Default (Package-Private) Class**

If no access modifier is specified for a class, it is treated as **package-private** (default). This means the class can only be accessed by other classes in the **same package** and cannot be accessed from outside the package.

##### Syntax:
```java
class Example {
    // Class body
}
```

### Access Modifiers for Constructors

Constructors in Java can also have access modifiers, which control how objects of the class can be created. For example:
- A `private` constructor restricts object creation to within the class itself (commonly used in **singleton** patterns).
- A `public` constructor allows objects to be created freely from anywhere.

### Example of Access

 Modifiers in Use

```java
package com.example;

public class Person {
    // Private field (only accessible within the Person class)
    private String name;

    // Public constructor (accessible from anywhere)
    public Person(String name) {
        this.name = name;
    }

    // Public method (accessible from anywhere)
    public String getName() {
        return name;
    }

    // Protected method (accessible within package and subclasses)
    protected void printDetails() {
        System.out.println("Person: " + name);
    }
}

// Main class
package com.example;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Alice");

        // Accessing public method
        System.out.println(person.getName());

        // Accessing protected method (works because it's in the same package)
        person.printDetails();
    }
}
```

### Summary of Access Modifiers

- **Private**: Accessible only within the class. Use it to hide the internal details.
- **Default (Package-Private)**: Accessible within the same package. Use it when you want package-level visibility.
- **Protected**: Accessible within the same package and by subclasses in different packages. Use it to allow subclass access while restricting access to unrelated classes.
- **Public**: Accessible from anywhere in the program. Use it for methods, fields, or classes that need to be visible everywhere.

Understanding and using access modifiers appropriately is essential for maintaining **encapsulation**, improving **security**, and enforcing **code boundaries** in Java programs.