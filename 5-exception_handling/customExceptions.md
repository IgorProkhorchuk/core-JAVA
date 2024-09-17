### Custom Exceptions

In Java, while the standard exception classes (`IOException`, `NullPointerException`, etc.) cover most error conditions, there are situations where predefined exceptions don't adequately describe the error scenario. In such cases, you can create **custom exceptions** to represent specific error conditions in your application. Custom exceptions are user-defined exception classes that extend one of Java's exception classes, typically `Exception` or `RuntimeException`.

---

### Why Use Custom Exceptions?

Custom exceptions make it easier to:
1. **Communicate specific error conditions**: Custom exceptions allow you to provide meaningful messages that describe the exact error in your application.
2. **Improve code clarity**: By creating specific exceptions for unique situations, you can make your code more readable and maintainable.
3. **Handle domain-specific errors**: In complex applications, generic exceptions may not provide enough context. Custom exceptions allow you to handle domain-specific issues in a more controlled manner.

---

### How to Create a Custom Exception

Custom exceptions are simply Java classes that extend either `Exception` (for checked exceptions) or `RuntimeException` (for unchecked exceptions). They inherit all the behavior of the base exception class, and you can add additional fields or methods if needed.

#### Steps to Create a Custom Exception:
1. **Extend** a standard exception class (`Exception` for checked exceptions, `RuntimeException` for unchecked exceptions).
2. **Provide constructors** to allow the custom exception to accept error messages or other arguments.
3. Optionally, you can add custom behavior or fields to provide more context for the exception.

---

### Example: Creating a Custom Checked Exception

Let's create a custom checked exception called `InsufficientBalanceException`, which will be thrown when there is not enough balance in a bank account.

```java
// Custom checked exception
public class InsufficientBalanceException extends Exception {

    // Constructor with default error message
    public InsufficientBalanceException() {
        super("Insufficient balance in the account.");
    }

    // Constructor with custom error message
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
```

#### Explanation:
- The class `InsufficientBalanceException` extends `Exception`, meaning it's a **checked exception**.
- It has two constructors:
  - One that uses a default error message.
  - Another that allows passing a custom message.
- Since it's a checked exception, it must be handled with a `try-catch` block or declared with `throws` in method signatures.

---

#### Using the Custom Checked Exception

Now, let’s use `InsufficientBalanceException` in a `BankAccount` class to simulate withdrawing money from an account.

```java
public class BankAccount {
    private double balance;

    // Constructor to initialize the balance
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Method to withdraw money that throws custom exception
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Withdrawal amount exceeds balance.");
        }
        balance -= amount;
        System.out.println("Withdrawal successful! Remaining balance: " + balance);
    }
    
    // Getter for balance
    public double getBalance() {
        return balance;
    }
}

public class CustomCheckedExceptionTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00);

        try {
            account.withdraw(1500.00);  // This will throw InsufficientBalanceException
        } catch (InsufficientBalanceException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
```

#### Explanation:
- The `withdraw(double amount)` method checks if the withdrawal amount exceeds the current balance.
- If the condition is met, an `InsufficientBalanceException` is thrown.
- The `main` method attempts to withdraw more than the available balance, triggering the exception, which is caught and handled using a `try-catch` block.

---

### Example: Creating a Custom Unchecked Exception

Unchecked exceptions extend `RuntimeException`. Let’s create a custom unchecked exception called `InvalidAgeException`, which will be thrown when an invalid age (e.g., negative) is provided.

```java
// Custom unchecked exception
public class InvalidAgeException extends RuntimeException {

    // Constructor with default error message
    public InvalidAgeException() {
        super("Invalid age provided.");
    }

    // Constructor with custom error message
    public InvalidAgeException(String message) {
        super(message);
    }
}
```

#### Explanation:
- The class `InvalidAgeException` extends `RuntimeException`, so it's an **unchecked exception**.
- Like the previous example, it provides constructors for default and custom error messages.
- Since it’s unchecked, it doesn’t need to be declared in method signatures or caught explicitly.

---

#### Using the Custom Unchecked Exception

Let’s apply `InvalidAgeException` in a `Person` class that validates a person's age.

```java
public class Person {
    private int age;

    // Method to set age, throws InvalidAgeException if age is negative
    public void setAge(int age) {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be negative: " + age);
        }
        this.age = age;
    }
    
    public int getAge() {
        return age;
    }
}

public class CustomUncheckedExceptionTest {
    public static void main(String[] args) {
        Person person = new Person();
        
        try {
            person.setAge(-5);  // This will throw InvalidAgeException
        } catch (InvalidAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
```

#### Explanation:
- The `setAge(int age)` method validates the input. If the age is negative, it throws an `InvalidAgeException`.
- The `main` method sets the age to a negative value, triggering the exception.
- Although `InvalidAgeException` is an unchecked exception, it is caught in a `try-catch` block for demonstration purposes. However, catching unchecked exceptions is not mandatory.

---

### Custom Exception Best Practices

1. **Use meaningful names**: The exception class name should clearly describe the error condition. For example, `InsufficientBalanceException` is better than something generic like `AccountException`.
2. **Add constructors for flexibility**: Include constructors that accept both a default message and a custom message, and possibly other arguments (such as an error code or additional details).
3. **Extend the appropriate class**:
   - Extend `Exception` for **checked exceptions** when you want to force the caller to handle the exception.
   - Extend `RuntimeException` for **unchecked exceptions** when the error is likely caused by a programming mistake or bad logic.
4. **Avoid overuse of custom exceptions**: Don’t create custom exceptions for every possible error condition. Use them sparingly and only when they add meaningful value.
5. **Override `toString()` and `getMessage()` if necessary**: If you need to provide additional information about the exception, consider overriding these methods to display more details.
6. **Document custom exceptions**: Clearly document when and why a custom exception might be thrown, so other developers understand the scenarios in which they should expect it.

---

### Custom Exception with Additional Fields

Sometimes, custom exceptions might need additional information (e.g., error codes, user IDs, etc.). You can add extra fields to store such information.

#### Example:
```java
// Custom exception with additional fields
public class InvalidTransactionException extends Exception {
    private int errorCode;

    // Constructor with custom message and error code
    public InvalidTransactionException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    // Getter for error code
    public int getErrorCode() {
        return errorCode;
    }

    // Override toString to provide detailed info
    @Override
    public String toString() {
        return "Error Code: " + errorCode + ", Message: " + getMessage();
    }
}

public class CustomExceptionWithFieldsTest {
    public static void main(String[] args) {
        try {
            throw new InvalidTransactionException("Transaction failed due to insufficient funds.", 1001);
        } catch (InvalidTransactionException e) {
            System.out.println(e.toString());  // Displays error code and message
        }
    }
}
```

#### Explanation:
- The custom exception `InvalidTransactionException` includes an additional field `errorCode`, which stores an error code specific to the exception.
- The constructor initializes both the message and the error code.
- The `toString()` method is overridden to provide a detailed error message that includes the error code.

---

### Summary of Custom Exceptions in Java

1. **Definition**: Custom exceptions allow you to create exceptions tailored to your specific error conditions.
2. **Checked and Unchecked**: You can create both checked (extending `Exception`) and unchecked (extending `RuntimeException`) custom exceptions.
3. **Usage**: Custom exceptions provide more meaningful error messages and help in identifying domain-specific errors.
4. **Implementation**: Custom exceptions are classes that extend standard exception classes and may include additional fields or methods to provide more context.
5. **Best Practices**: Use custom exceptions sparingly, name them meaningfully, and ensure proper documentation.

By understanding and using custom exceptions, you can handle exceptional situations in a more controlled and informative way, making your Java applications more robust, maintainable, and easier to debug.