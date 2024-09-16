## Structure of a Java Program

A Java program is typically composed of several key elements:

### 1. Package Declaration (Optional)
* **Purpose:** Defines the package to which the class belongs.
* **Syntax:** `package packageName;`

### 2. Import Statements (Optional)
* **Purpose:** Imports classes or packages from other locations.
* **Syntax:** `import packageName.ClassName;`

### 3. Class Definition
* **Purpose:** Defines a blueprint for creating objects.
* **Syntax:**
   ```java
   public class ClassName {
       // Class members (fields and methods)
   }
   ```

### 4. Class Members
* **Fields:** Variables that store data within an object.
   * **Syntax:** `data type variableName;`
* **Methods:** Blocks of code that perform specific tasks.
   * **Syntax:**
     ```java
     public returnType methodName(parameterList) {
         // Method body
     }
     ```

### 5. Main Method (Required)
* **Purpose:** The entry point of a Java application.
* **Syntax:**
   ```java
   public static void main(String[] args) {
       // Main method body
   }
   ```

### Example:
```java
package myPackage;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
    }
}
```

**Key points:**
* **Class names:** Start with an uppercase letter.
* **Variable and method names:** Start with a lowercase letter and use camelCase for multiple words.
* **Comments:** Use `//` for single-line comments and `/* */` for multi-line comments.
* **Indentation:** Use consistent indentation to improve readability.

