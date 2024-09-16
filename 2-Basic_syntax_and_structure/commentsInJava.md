## Comments in Java

Comments are used to explain the purpose of code, make it more readable, and aid in debugging. Java supports two types of comments:

### Single-line comments
* **Syntax:** `// Comment`
* **Purpose:** Used for short, single-line comments.
* **Example:**
  ```java
  int age = 25; // This line stores the age in the age variable
  ```

### Multi-line comments
* **Syntax:** `/* Comment */`
* **Purpose:** Used for longer, multi-line comments.
* **Example:**
  ```java
  /* This is a multi-line
     comment that spans
     multiple lines */
  ```

### Best practices:
* **Use comments judiciously:** Don't comment every line of code. Focus on explaining the logic and purpose of blocks of code.
* **Be concise:** Write clear and concise comments. Avoid excessive verbosity.
* **Stay up-to-date:** Ensure that comments reflect the current state of the code. Update them as necessary.
* **Use consistent formatting:** Maintain consistent indentation and spacing in your comments.

**Example:**
```java
public class Example {
    public static void main(String[] args) {
        // This is a single-line comment
        int number = 10;

        /* This is a multi-line comment
         * that explains the purpose of
         * the following code */
        if (number > 0) {
            System.out.println("Number is positive.");
        } else if (number < 0) {
            System.out.println("Number is negative.");
        } else {
            System.out.println("Number is zero.");
        }
    }
}
```
