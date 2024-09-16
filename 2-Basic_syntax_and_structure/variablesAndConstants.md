## Variables and Constants in Java

### Variables
* **Purpose:** Store data that can change during program execution.
* **Declaration:** `data type variableName;`
* **Assignment:** `variableName = value;`
* **Example:**
  ```java
  int age = 25;
  String name = "Alice";
  ```

### Constants
* **Purpose:** Store data that remains unchanged throughout the program.
* **Declaration:** `final data type constantName = value;`
* **Example:**
  ```java
  final double PI = 3.14159;
  ```

### Key differences:
| Feature | Variables | Constants |
|---|---|---|
| Value | Can change | Cannot change |
| Declaration | `data type variableName;` | `final data type constantName = value;` |
| Modification | Allowed | Not allowed |
| Usage | For storing data that may change | For storing values that remain constant |

### Best practices:
* Use meaningful variable and constant names.
* Use `final` for constants to prevent accidental modification.
* Use appropriate data types for variables.
* Initialize variables before using them.

### Example:
```java
public class Example {
    public static void main(String[] args) {
        final double PI = 3.14159;
        int radius = 5;
        double area = PI * radius * radius;

        System.out.println("Area of the circle: " + area);
    }
}
```

In this example, `PI` is a constant representing the value of pi, while `radius` and `area` are variables that can change during program execution. By using a constant for PI, we ensure that its value remains consistent throughout the program.
