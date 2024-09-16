## Break and Continue Statements in Java

**Break** and **continue** are control flow statements used to modify the behavior of loops.

### Break Statement
* **Purpose:** Exits the innermost loop it is contained within.
* **Usage:**
  - To terminate a loop prematurely based on a condition.
  - To break out of nested loops.

**Example:**
```java
for (int i = 1; i <= 10; i++) {
    if (i == 5) {
        break; // Exits the loop when i is 5
    }
    System.out.println(i);
}
```

### Continue Statement
* **Purpose:** Skips the current iteration of a loop and proceeds to the next iteration.
* **Usage:**
  - To avoid executing certain code within a loop based on a condition.

**Example:**
```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        continue; // Skips the rest of the iteration when i is 3
    }
    System.out.println(i);
}
```

**Key points:**

* `break` and `continue` can only be used within loops.
* `break` terminates the entire loop, while `continue` only skips the current iteration.
* Nested loops can have multiple `break` and `continue` statements, affecting the innermost loop they are contained within.

**Additional examples:**

**Using `break` to exit a nested loop:**
```java
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= 3; j++) {
        if (i == 2 && j == 2) {
            break; // Exits the inner loop
        }
        System.out.print(i + " " + j + " ");
    }
    System.out.println();
}
```

**Using `continue` to skip even numbers:**
```java
for (int i = 1; i <= 10; i++) {
    if (i % 2 == 0) {
        continue; // Skips even numbers
    }
    System.out.println(i);
}
```