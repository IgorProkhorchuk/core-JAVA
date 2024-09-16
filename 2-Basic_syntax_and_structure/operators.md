## Operators in Java

Operators are symbols that perform specific operations on operands (values or variables). Java provides a wide range of operators, including:

### Arithmetic Operators
* **Addition:** `+`
* **Subtraction:** `-`
* **Multiplication:** `*`
* **Division:** `/`
* **Modulo:** `%` (returns the remainder of division)

### Relational Operators
* **Equal to:** `==`
* **Not equal to:** `!=`
* **Greater than:** `>`
* **Less than:** `<`
* **Greater than or equal to:** `>=`
* **Less than or equal to:** `<=`

### Logical Operators
* **Logical AND:** `&&`
* **Logical OR:** `||`
* **Logical NOT:** `!`

### Bitwise Operators
* **Bitwise AND:** `&`
* **Bitwise OR:** `|`
* **Bitwise XOR:** `^`
* **Bitwise NOT:** `~`
* **Left shift:** `<<`
* **Right shift:** `>>`
* **Unsigned right shift:** `>>>`

### Assignment Operators
* **Simple assignment:** `=`
* **Addition assignment:** `+=`
* **Subtraction assignment:** `-=`
* **Multiplication assignment:** `*=`
* **Division assignment:** `/=`
* **Modulo assignment:** `%=`
* **Bitwise AND assignment:** `&=`
* **Bitwise OR assignment:** `|=`
* **Bitwise XOR assignment:** `^=`
* **Left shift assignment:** `<<=`
* **Right shift assignment:** `>>=`
* **Unsigned right shift assignment:** `>>>=`

### Ternary Operator
* **Condition ? expression1 : expression2**
* Evaluates the condition and returns the result of expression1 if true, otherwise expression2.

### Example:
```java
int x = 10;
int y = 5;

// Arithmetic operators
int sum = x + y;
int difference = x - y;
int product = x * y;
int quotient = x / y;
int remainder = x % y;

// Relational operators
boolean isEqual = x == y;
boolean isNotEqual = x != y;
boolean isGreaterThan = x > y;
boolean isLessThan = x < y;

// Logical operators
boolean isTrue = true && false;
boolean isFalse = true || false;
boolean isNegated = !true;

// Bitwise operators
int result = x & y; // Bitwise AND

// Assignment operators
x += 5; // Equivalent to x = x + 5

// Ternary operator
int max = (x > y) ? x : y;
```
