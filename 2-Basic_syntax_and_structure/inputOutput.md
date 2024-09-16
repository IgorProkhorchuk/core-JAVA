## Input and Output in Java: Scanner Class and System.out.println

### Input: Scanner Class
The `Scanner` class is a simple text scanner that allows reading values of various data types from different sources, such as the console, files, or strings. It provides methods to read integers, floating-point numbers, strings, and more.

**Basic usage:**
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read from the console

        // Read an integer
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // Read a double
        System.out.print("Enter a double: ");
        double decimal = scanner.nextDouble();

        // Read a string
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        // Print the values
        System.out.println("You entered: " + number + ", " + decimal + ", " + text);
    }
}
```
**Common Scanner methods:**
* **nextInt():** Reads the next integer from the input.
* **nextDouble():** Reads the next double from the input.
* **nextFloat():** Reads the next float from the input.
* **next():** Reads the next word (whitespace-delimited) from the input.
* **nextLine():** Reads the next line of text from the input.

### Output: System.out.println()
The `System.out.println()` method is used to print text or the values of variables to the console. It automatically adds a newline character at the end of the line
```java
System.out.println("Hello, World!");
int age = 25;
System.out.println("My age is: " + age);
```
**Formatting output:**
You can use `printf()` or `format()` methods to format the output in a specific way. For example:

```java
System.out.printf("Pi is approximately %.2f", Math.PI); // Prints Pi with two decimal places
```

**Other output methods:**
* **System.out.print():** Prints text without adding a newline.
* **System.out.printf():** Prints formatted text using placeholders and format specifiers.
* **System.out.format():** Similar to `printf()`, but returns a formatted string instead of printing it directly.

By effectively using the `Scanner` class for input and `System.out.println()` for output, you can create interactive Java programs that communicate with the user and display meaningful information.
