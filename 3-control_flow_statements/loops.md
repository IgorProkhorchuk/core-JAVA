## Loops in Java

Loops are control flow statements that allow you to repeatedly execute a block of code until a certain condition is met. Java provides three main types of loops:

### 1. `for` Loop
* **Syntax:**
   ```java
   for (initialization; condition; update) {
       // Code to be executed
   }
   ```
* **Purpose:** Used for iterating over a known number of times or a collection of elements.
* **Example:**
   ```java
   for (int i = 0; i < 5; i++) {
       System.out.println("Iteration " + i);
   }
   ```

### 2. `while` Loop
* **Syntax:**
   ```java
   while (condition) {
       // Code to be executed
   }
   ```
* **Purpose:** Used when the number of iterations is unknown beforehand.
* **Example:**
   ```java
   int count = 0;
   while (count < 10) {
       System.out.println("Count: " + count);
       count++;
   }
   ```

### 3. `do-while` Loop
* **Syntax:**
   ```java
   do {
       // Code to be executed
   } while (condition);
   ```
* **Purpose:** Similar to `while` loop, but the condition is checked after the code block is executed at least once.
* **Example:**
   ```java
   int number = 0;
   do {
       System.out.println("Number: " + number);
       number++;
   } while (number < 5);
   ```

**Key points:**
* The `for` loop is often used for iterating over collections or arrays.
* The `while` and `do-while` loops are used when the number of iterations is not known in advance.
* The `do-while` loop executes the code block at least once, even if the condition is initially false.

---

## More Complex Loop Examples

### Nested Loops
* **Purpose:** Used to iterate over multiple levels of data.
* **Example:**
  ```java
  for (int i = 1; i <= 5; i++) {
      for (int j = 1; j <= i; j++) {
          System.out.print("* ");
      }
      System.out.println();
  }
  ```
  This code will print a pyramid pattern:
  ```
  *
  * *
  * * *
  * * * *
  * * * * *
  ```

### Infinite Loops
* **Purpose:** Used for continuous execution until manually stopped or a specific condition is met.
* **Example:**
  ```java
  while (true) {
      // Code that will execute indefinitely
  }
  ```
  Be cautious with infinite loops as they can cause your program to hang.

### Loop Control Statements
* **`break`:** Exits the current loop.
* **`continue`:** Skips the current iteration of the loop and proceeds to the next one.
* **Example:**
  ```java
  for (int i = 1; i <= 10; i++) {
      if (i == 5) {
          continue; // Skip the rest of the iteration
      }
      System.out.println(i);
  }
  ```
  This code will print numbers from 1 to 10, skipping 5.

### Enhanced `for` Loop (for-each loop)
* **Purpose:** Used to iterate over collections (arrays, lists, etc.).
* **Syntax:**
   ```java
   for (dataType element : collection) {
       // Code to be executed
   }
   ```
* **Example:**
  ```java
  int[] numbers = {1, 2, 3, 4, 5};
  for (int number : numbers) {
      System.out.println(number);
  }
  ```

### Looping through Strings
* **Example:**
  ```java
  String str = "Hello, world!";
  for (int i = 0; i < str.length(); i++) {
      System.out.println(str.charAt(i));
  }
  ```

