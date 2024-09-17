### Types of Exceptions

In Java, exceptions are classified into two broad categories based on how and when they are checked by the Java compiler:
1. **Checked Exceptions**
2. **Unchecked Exceptions**

These categories help in distinguishing between exceptions that need to be explicitly handled (checked exceptions) and those that occur due to programming errors or logical mistakes (unchecked exceptions).

---

### 1. Checked Exceptions

Checked exceptions are exceptions that are checked by the **compiler** at **compile time**. The compiler ensures that these exceptions are handled explicitly, either by using a `try-catch` block or by declaring the exception using the `throws` clause in the method signature. If checked exceptions are not handled properly, the program will not compile.

Checked exceptions are usually conditions that are beyond the control of the programmer and are often related to external resources (like file handling, network operations, etc.).

#### Common Checked Exceptions in Java:

1. **IOException**
   - This exception is thrown when an input-output operation fails or is interrupted. Examples include file handling errors, network connection issues, or when trying to access a file that does not exist.
   - Example:
     ```java
     import java.io.File;
     import java.io.FileReader;
     import java.io.IOException;

     public class CheckedExample {
         public static void main(String[] args) {
             try {
                 File file = new File("nonexistentfile.txt");
                 FileReader reader = new FileReader(file);  // May throw FileNotFoundException
             } catch (IOException e) {
                 System.out.println("File not found or some I/O error occurred.");
             }
         }
     }
     ```

2. **SQLException**
   - Thrown when there is a problem with database operations, such as connection issues, invalid queries, or issues while retrieving data.
   - Example:
     ```java
     import java.sql.Connection;
     import java.sql.DriverManager;
     import java.sql.SQLException;

     public class DatabaseConnection {
         public static void main(String[] args) {
             try {
                 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "pass");
             } catch (SQLException e) {
                 System.out.println("Database connection failed.");
             }
         }
     }
     ```

3. **ClassNotFoundException**
   - Thrown when an application attempts to load a class through its name, but the class definition cannot be found.
   - Example:
     ```java
     public class ClassNotFoundExample {
         public static void main(String[] args) {
             try {
                 Class.forName("SomeClass");  // Class not found at runtime
             } catch (ClassNotFoundException e) {
                 System.out.println("Class not found.");
             }
         }
     }
     ```

4. **FileNotFoundException**
   - Thrown when a program tries to open a file that does not exist.
   - Example:
     ```java
     import java.io.File;
     import java.io.FileNotFoundException;
     import java.util.Scanner;

     public class FileNotFoundExample {
         public static void main(String[] args) {
             try {
                 Scanner scanner = new Scanner(new File("example.txt"));
             } catch (FileNotFoundException e) {
                 System.out.println("File not found.");
             }
         }
     }
     ```

5. **InterruptedException**
   - Thrown when a thread is interrupted while it is waiting, sleeping, or performing another operation.
   - Example:
     ```java
     public class InterruptedExample {
         public static void main(String[] args) {
             try {
                 Thread.sleep(1000);  // Throws InterruptedException if the thread is interrupted
             } catch (InterruptedException e) {
                 System.out.println("Thread was interrupted.");
             }
         }
     }
     ```

**Handling Checked Exceptions**:
- You must either **handle** these exceptions using `try-catch` blocks or **declare** them using the `throws` keyword in the method signature.
  
  Example of declaring a checked exception:
  ```java
  public void readFile() throws IOException {
      FileReader reader = new FileReader("file.txt");
  }
  ```

---

### 2. Unchecked Exceptions

Unchecked exceptions, also known as **runtime exceptions**, are exceptions that are not checked by the compiler at **compile time**. These exceptions occur due to logical or programming errors, such as accessing an invalid array index or calling methods on a `null` object reference. Since they are typically caused by coding mistakes, Java does not force the developer to handle them explicitly.

Unchecked exceptions are subclasses of `java.lang.RuntimeException`.

#### Common Unchecked Exceptions in Java:

1. **NullPointerException**
   - Thrown when a program attempts to access an object or invoke a method on a reference that is `null` (i.e., no object).
   - Example:
     ```java
     public class NullPointerExample {
         public static void main(String[] args) {
             String str = null;
             System.out.println(str.length());  // Throws NullPointerException
         }
     }
     ```

2. **ArrayIndexOutOfBoundsException**
   - Thrown when an array is accessed with an invalid index (an index that is negative or greater than the array length).
   - Example:
     ```java
     public class ArrayIndexExample {
         public static void main(String[] args) {
             int[] arr = {1, 2, 3};
             System.out.println(arr[5]);  // Throws ArrayIndexOutOfBoundsException
         }
     }
     ```

3. **ArithmeticException**
   - Thrown when an illegal arithmetic operation is attempted, such as dividing a number by zero.
   - Example:
     ```java
     public class ArithmeticExample {
         public static void main(String[] args) {
             int result = 10 / 0;  // Throws ArithmeticException (division by zero)
         }
     }
     ```

4. **ClassCastException**
   - Thrown when an object is cast to a subclass that it is not an instance of.
   - Example:
     ```java
     public class ClassCastExample {
         public static void main(String[] args) {
             Object obj = new String("Hello");
             Integer num = (Integer) obj;  // Throws ClassCastException
         }
     }
     ```

5. **IllegalArgumentException**
   - Thrown when an illegal or inappropriate argument is passed to a method.
   - Example:
     ```java
     public class IllegalArgumentExample {
         public static void main(String[] args) {
             int num = Integer.parseInt("abc");  // Throws IllegalArgumentException
         }
     }
     ```

6. **NumberFormatException**
   - Thrown when an attempt is made to convert a string to a numeric type, but the string does not have the appropriate format.
   - Example:
     ```java
     public class NumberFormatExample {
         public static void main(String[] args) {
             String invalidNumber = "123a";
             int num = Integer.parseInt(invalidNumber);  // Throws NumberFormatException
         }
     }
     ```

**Handling Unchecked Exceptions**:
- While unchecked exceptions do not require mandatory handling, it is still a good practice to anticipate and handle them to improve the robustness of the program.
  
  Example:
  ```java
  public class UncheckedExceptionHandling {
      public static void main(String[] args) {
          try {
              String str = null;
              System.out.println(str.length());
          } catch (NullPointerException e) {
              System.out.println("Null object reference found.");
          }
      }
  }
  ```

---

### 3. Errors

Errors in Java are serious problems that are not intended to be handled by applications. Errors usually indicate conditions that a reasonable application cannot recover from. Java programs do not generally handle errors because they represent issues with the Java Virtual Machine (JVM), the environment, or system resources.

Errors are part of the `java.lang.Error` class, which is a subclass of `java.lang.Throwable`, just like exceptions.

#### Common Errors in Java:

1. **OutOfMemoryError**
   - Thrown when the JVM runs out of memory and cannot allocate more objects.
   - Example:
     ```java
     public class OutOfMemoryExample {
         public static void main(String[] args) {
             int[] arr = new int[Integer.MAX_VALUE];  // May cause OutOfMemoryError
         }
     }
     ```

2. **StackOverflowError**
   - Thrown when a stack overflow occurs, typically due to excessive deep recursion.
   - Example:
     ```java
     public class StackOverflowExample {
         public static void main(String[] args) {
             recursiveMethod();  // Recursively calls itself indefinitely
         }

         public static void recursiveMethod() {
             recursiveMethod();  // Causes StackOverflowError
         }
     }
     ```

3. **NoClassDefFoundError**
   - Thrown when the JVM tries to load a class that was available at compile-time but is missing at runtime.
   - Example:
     ```java
     public class NoClassDefFoundExample {
         public static void main(String[] args) {
             // A runtime error due to missing class definition
         }
     }
     ```

---

### Summary of Exception Types

| Type                  | Category         | Description                                                                  |
|-----------------------|------------------|------------------------------------------------------------------------------|
| **Checked Exceptions** | Compile-time     | Exceptions that must be handled explicitly. Examples: `IOException`, `SQLException`.|
| **Unchecked Exceptions** | Runtime         | Exceptions that occur due to logical errors in code. Examples: `NullPointerException`, `ArithmeticException`.|
| **Errors**             | Runtime          | Serious problems related to the JVM or the environment. Examples: `OutOfMemoryError`, `StackOverflowError`.|



---

### Conclusion

Java provides a structured mechanism to deal with errors and exceptions. While **checked exceptions** are used for external conditions that the programmer cannot control, **unchecked exceptions** occur due to programming errors. **Errors**, on the other hand, represent severe issues that an application cannot recover from. Handling exceptions properly ensures that programs are more reliable, robust, and user-friendly.