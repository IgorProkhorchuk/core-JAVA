### Definition

A **method** in Java is a block of code that performs a specific task. Methods are used to define the behavior of objects and to reuse code. Here's a basic structure of a method:

```java
public returnType methodName(parameters) {
    // method body
}
```

### Parameters

Parameters are variables that are passed to a method when it is called. They allow you to pass data into the method. Parameters are defined within the parentheses of the method declaration. There are two types of parameters:

1. **Formal Parameters**: These are the parameters defined in the method declaration.
    ```java
    public void greet(String name) {
        System.out.println("Hello, " + name);
    }
    ```

2. **Actual Parameters**: These are the values passed to the method when it is called.
    ```java
    greet("Alice"); // "Alice" is the actual parameter
    ```

### Return Types

The return type of a method specifies the type of value the method returns. If a method does not return any value, its return type is `void`. Here are some examples:

1. **Void Return Type**: The method does not return any value.
    ```java
    public void displayMessage() {
        System.out.println("This is a message.");
    }
    ```

2. **Primitive Return Type**: The method returns a primitive data type (e.g., `int`, `double`, `boolean`).
    ```java
    public int add(int a, int b) {
        return a + b;
    }
    ```

3. **Object Return Type**: The method returns an object.
    ```java
    public String getGreeting() {
        return "Hello, World!";
    }
    ```

### Example

Let's put it all together with a complete example:

```java
public class Calculator {

    // Method with void return type
    public void displayMessage() {
        System.out.println("Welcome to the Calculator!");
    }

    // Method with primitive return type
    public int add(int a, int b) {
        return a + b;
    }

    // Method with object return type
    public String getGreeting() {
        return "Hello, User!";
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // Calling methods
        calc.displayMessage(); // Output: Welcome to the Calculator!
        int sum = calc.add(5, 3); // sum = 8
        System.out.println("Sum: " + sum); // Output: Sum: 8
        String greeting = calc.getGreeting(); // greeting = "Hello, User!"
        System.out.println(greeting); // Output: Hello, User!
    }
}
```

In this example:
- The `displayMessage` method has a `void` return type and does not return any value.
- The `add` method has an `int` return type and returns the sum of two integers.
- The `getGreeting` method has a `String` return type and returns a greeting message.

### Summary

- **Methods**: Blocks of code that perform specific tasks.
- **Parameters**: Variables passed to methods to provide input data.
- **Return Types**: Specify the type of value a method returns (`void`, primitive types, or objects).
