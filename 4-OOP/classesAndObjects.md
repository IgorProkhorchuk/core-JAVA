
### Classes

A **class** in Java is a blueprint for creating objects. It defines a datatype by bundling data and methods that work on the data into one single unit. Here's a detailed breakdown:

1. **Definition**: A class is defined using the `class` keyword followed by the class name. The class body is enclosed within curly braces `{}`.
    ```java
    public class Car {
        // fields
        String color;
        String model;
        int year;

        // methods
        void displayDetails() {
            System.out.println("Model: " + model + ", Color: " + color + ", Year: " + year);
        }
    }
    ```

2. **Fields**: These are variables that hold the data of the class. In the example above, `color`, `model`, and `year` are fields of the `Car` class.

3. **Methods**: These are functions defined inside a class that describe the behaviors of the objects created from the class. The `displayDetails` method in the example above is a method of the `Car` class.

4. **Constructors**: These are special methods that are called when an object is instantiated. They initialize the object's fields.
    ```java
    public Car(String model, String color, int year) {
        this.model = model;
        this.color = color;
        this.year = year;
    }
    ```

### Objects

An **object** is an instance of a class. When a class is defined, no memory is allocated until an object of that class is created. Here's how objects work:

1. **Instantiation**: Creating an object from a class is called instantiation. This is done using the `new` keyword.
    ```java
    Car myCar = new Car("Tesla Model S", "Red", 2022);
    ```

2. **Accessing Fields and Methods**: Once an object is created, you can access its fields and methods using the dot `.` operator.
    ```java
    myCar.displayDetails(); // Output: Model: Tesla Model S, Color: Red, Year: 2022
    ```

3. **State and Behavior**: Objects have states and behaviors. The state is represented by the fields (data) and the behavior is represented by the methods (functions).

### Example

Let's put it all together with a complete example:

```java
public class Car {
    // fields
    String color;
    String model;
    int year;

    // constructor
    public Car(String model, String color, int year) {
        this.model = model;
        this.color = color;
        this.year = year;
    }

    // method
    void displayDetails() {
        System.out.println("Model: " + model + ", Color: " + color + ", Year: " + year);
    }

    public static void main(String[] args) {
        // creating an object
        Car myCar = new Car("Tesla Model S", "Red", 2022);
        
        // accessing method
        myCar.displayDetails();
    }
}
```

In this example:
- We define a `Car` class with fields, a constructor, and a method.
- We create an object `myCar` of the `Car` class.
- We call the `displayDetails` method on the `myCar` object to print its details.

### Summary

- **Class**: A blueprint for creating objects. It defines fields and methods.
- **Object**: An instance of a class. It has state (fields) and behavior (methods).
