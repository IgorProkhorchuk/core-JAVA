### What is Method Overloading?

**Method Overloading** is a feature in Java that allows a class to have more than one method with the same name, but with different parameter lists. It is a way to achieve polymorphism in Java. The methods must differ in the type, number, or both of their parameters.

### Why Use Method Overloading?

Method overloading is used to increase the readability of the program. It allows you to define multiple methods with the same name but different functionalities, making the code more intuitive and easier to understand.

### Rules for Method Overloading

1. **Different Parameter Lists**: The overloaded methods must have different parameter lists. This can be achieved by changing the number of parameters or the type of parameters.
2. **Return Type**: The return type of the methods can be the same or different, but it does not play a role in method overloading.
3. **Access Modifiers**: The access modifiers of the methods can be the same or different.

### Examples of Method Overloading

#### Example 1: Different Number of Parameters

```java
public class MathUtils {

    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        MathUtils math = new MathUtils();
        System.out.println("Sum of 2 and 3: " + math.add(2, 3)); // Output: Sum of 2 and 3: 5
        System.out.println("Sum of 1, 2, and 3: " + math.add(1, 2, 3)); // Output: Sum of 1, 2, and 3: 6
    }
}
```

In this example, the `add` method is overloaded with two different parameter lists: one with two parameters and one with three parameters.

#### Example 2: Different Types of Parameters

```java
public class DisplayUtils {

    // Method to display an integer
    public void display(int a) {
        System.out.println("Displaying integer: " + a);
    }

    // Overloaded method to display a double
    public void display(double a) {
        System.out.println("Displaying double: " + a);
    }

    // Overloaded method to display a string
    public void display(String a) {
        System.out.println("Displaying string: " + a);
    }

    public static void main(String[] args) {
        DisplayUtils display = new DisplayUtils();
        display.display(5); // Output: Displaying integer: 5
        display.display(5.5); // Output: Displaying double: 5.5
        display.display("Hello"); // Output: Displaying string: Hello
    }
}
```

In this example, the `display` method is overloaded with different types of parameters: `int`, `double`, and `String`.

### Benefits of Method Overloading

1. **Improved Readability**: Method overloading makes the code more readable and easier to understand.
2. **Code Reusability**: It allows you to reuse the same method name for different functionalities, reducing code duplication.
3. **Flexibility**: It provides flexibility to call the same method with different types or numbers of arguments.

### Summary

- **Method Overloading**: Allows a class to have multiple methods with the same name but different parameter lists.
- **Different Parameter Lists**: Achieved by changing the number or type of parameters.
- **Benefits**: Improved readability, code reusability, and flexibility.
