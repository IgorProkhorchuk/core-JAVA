## Primitive and Non-Primitive Data Types in Java

Java provides two main categories of data types: primitive and non-primitive (reference).

### Primitive Data Types
* **Direct representation:** Occupy a fixed amount of memory.
* **Direct manipulation:** Values are stored directly in variables.
* **Performance:** Generally faster than non-primitive types.

**Types:**
* [**boolean:**](data_types/boolean.md) Represents true or false values.
* [**byte:**](data_types/byte.md) Represents a single byte of data (8 bits).
* [**short:**](data_types/short.md) Represents a 16-bit signed integer.
* [**int:**](data_types/int.md) Represents a 32-bit signed integer.
* [**long:**](data_types/long.md) Represents a 64-bit signed integer.
* [**float:**](data_types/float.md) Represents a 32-bit floating-point number.
* [**double:**](data_types/double.md) Represents a 64-bit floating-point number.
* [**char:**](data_types/char.md) Represents a single character (Unicode code point).

### Non-Primitive (Reference) Data Types
* **Indirect representation:** Store a reference to the actual data.
* **Indirect manipulation:** Variables hold references to objects.
* **Flexibility:** Can represent complex data structures.

**Types:**
* **Class:** Defines a blueprint for creating objects.
* **Interface:** Defines a contract for classes to implement.
* **Array:** A collection of elements of the same data type.
* **String:** Represents a sequence of characters.
* **Enum** A special data type that allows a variable to be a set of predefined constants.

### Example:
```java
// Primitive data types
int age = 25;
double salary = 50000.5;
char initial = 'A';
boolean isStudent = true;

// Non-primitive data types
String name = "Alice";
int[] numbers = {1, 2, 3, 4, 5};
```

**Key differences:**
* **Memory allocation:** Primitive data types are allocated on the stack, while non-primitive data types are allocated on the heap.
* **Equality:** Primitive data types are compared using `==` for equality, while non-primitive data types are compared using the `equals()` method.
* **Mutability:** Primitive data types are immutable (their values cannot be changed), while non-primitive data types can be mutable (their values can be changed).

**Choosing the right data type:**
* **Primitive:** For simple, atomic values.
* **Non-primitive:** For complex data structures or when you need to create objects.
