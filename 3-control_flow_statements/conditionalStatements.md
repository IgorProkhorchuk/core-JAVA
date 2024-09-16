## Conditional Statements in Java

Conditional statements allow you to execute different code blocks based on specific conditions. Java provides three main types of conditional statements:

### 1. `if` Statement
* **Syntax:**
   ```java
   if (condition) {
       // Code to execute if the condition is true
   }
   ```
* **Example:**
   ```java
   int age = 25;
   if (age >= 18) {
       System.out.println("You are an adult.");
   }
   ```

### 2. `if-else` Statement
* **Syntax:**
   ```java
   if (condition) {
       // Code to execute if the condition is true
   } else {
       // Code to execute if the condition is false
   }
   ```
* **Example:**
   ```java
   int number = 0;
   if (number > 0) {
       System.out.println("Number is positive.");
   } else {
       System.out.println("Number is not positive.");
   }
   ```

### 3. `if-else if-else` Statement
* **Syntax:**
   ```java
   if (condition1) {
       // Code to execute if condition1 is true
   } else if (condition2) {
       // Code to execute if condition1 is false and condition2 is true
   } else {
       // Code to execute if none of the conditions are true
   }
   ```
* **Example:**
   ```java
   int grade = 90;
   if (grade >= 90) {
       System.out.println("Grade A");
   } else if (grade >= 80) {
       System.out.println("Grade B");
   } else if (grade >= 70) {
       System.out.println("Grade C");
   } else {
       System.out.println("Grade F");
   }
   ```

**Key points:**
* Conditions are evaluated to either `true` or `false`.
* The code block within the `if` or `else` statement is executed only if the corresponding condition is true.
* You can nest conditional statements within each other for more complex logic.
