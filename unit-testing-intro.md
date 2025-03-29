Unit testing is a process of testing individual units or components of a program to ensure they work as expected. The most commonly used framework for unit testing in Java is **JUnit**.

### Steps to Get Started with Unit Testing

1. **Set Up JUnit:**
   - Add the JUnit library to your project.
     - For Maven: 
       ```xml
       <dependency>
           <groupId>org.junit.jupiter</groupId>
           <artifactId>junit-jupiter</artifactId>
           <version>5.10.0</version>
           <scope>test</scope>
       </dependency>
       ```
     - For Gradle:
       ```gradle
       testImplementation 'org.junit.jupiter:junit-jupiter:5.10.0'
       ```

2. **Create a Test Class:**
   - Name your test classes with a meaningful name, typically appending `Test` to the name of the class you're testing. For example, `CalculatorTest` for a `Calculator` class.

3. **Write Test Methods:**
   - Test methods should be annotated with `@Test`.
   - Each test should focus on one functionality or scenario.

4. **Run Tests:**
   - Use your IDE's built-in test runner or command line.

---

### Example

#### Class to Test: Calculator.java
```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }
}
```

#### Test Class: CalculatorTest.java
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.subtract(3, 2));
    }
}
```

---

### Key JUnit Annotations
- `@Test`: Marks a method as a test method.
- `@BeforeEach`: Runs before each test method.
- `@AfterEach`: Runs after each test method.
- `@BeforeAll`: Runs once before all test methods in the class.
- `@AfterAll`: Runs once after all test methods in the class.
- `@Disabled`: Skips the test method.

---

