### 2. Utility Objects

Thymeleaf comes with several utility objects that can simplify your template code by allowing you to perform various operations without needing complex Java code in your controller. Here are the most commonly used utility objects:

- **`#strings`**: For string manipulation.
- **`#dates`**: For date and time formatting.
- **`#numbers`**: For number formatting.
- **`#objects`**: For general object manipulation.

#### a. String Manipulation with `#strings`

The `#strings` utility object provides methods for manipulating strings. Here are some useful methods:

- `#strings.capitalize(string)`: Capitalizes the first letter of a string.
- `#strings.toUpperCase(string)`: Converts a string to uppercase.
- `#strings.toLowerCase(string)`: Converts a string to lowercase.
- `#strings.contains(string, substring)`: Checks if a string contains a substring.

##### Example: String Manipulation

1. **Controller**:

   ```java
   @GetMapping("/stringExample")
   public String stringExample(Model model) {
       model.addAttribute("message", "hello world");
       return "stringExample";
   }
   ```

2. **Template**:

   ```html
   <!DOCTYPE html>
   <html xmlns:th="http://www.thymeleaf.org">
     <head>
       <title>String Manipulation</title>
     </head>
     <body>
       <h1>String Utility Example</h1>
       <p th:text="${#strings.capitalize(message)}"></p>
       <p th:text="${#strings.toUpperCase(message)}"></p>
       <p th:text="${#strings.toLowerCase(message)}"></p>
       <p th:text="${#strings.contains(message, 'world') ? 'Contains ''world''' : 'Does not contain ''world'''}"></p>
     </body>
   </html>
   ```

This will display:
- "Hello world"
- "HELLO WORLD"
- "hello world"
- "Contains 'world'"

---

#### b. Date Manipulation with `#dates`

The `#dates` utility object allows you to manipulate and format date and time values. You can use methods like:

- `#dates.format(date, pattern)`: Formats a date according to the specified pattern.
- `#dates.formatISO(date)`: Formats a date in ISO format.
- `#dates.now()`: Gets the current date and time.

##### Example: Date Manipulation

1. **Controller**:

   ```java
   import java.time.LocalDate;

   @GetMapping("/dateExample")
   public String dateExample(Model model) {
       model.addAttribute("today", LocalDate.now());
       return "dateExample";
   }
   ```

###### or alternative controller id you have troubles with `LocalDate` class
  ```java
    @GetMapping("/dateExample")
    public String dateExample(Model model) {
        LocalDate localDate = LocalDate.now();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        model.addAttribute("today", date);
        return "dateExample";
    }
  ```

2. **Template**:

   ```html
   <!DOCTYPE html>
   <html xmlns:th="http://www.thymeleaf.org">
     <head>
       <title>Date Utility Example</title>
     </head>
     <body>
       <h1>Date Utility Example</h1>
       <p>Today: <span th:text="${#dates.format(today, 'dd/MM/yyyy')}"></span></p>
       <p>ISO Format: <span th:text="${#dates.formatISO(today)}"></span></p>
     </body>
   </html>
   ```

This will display:
- Today's date in `dd/MM/yyyy` format.
- Today's date in ISO format.

---

#### c. Number Manipulation with `#numbers`

The `#numbers` utility object is used for formatting numbers, currencies, and percentages. Here are some common methods:

- `#numbers.formatDecimal(value)`: Formats a decimal number.
- `#numbers.formatCurrency(value)`: Formats a number as currency.
- `#numbers.formatPercent(value)`: Formats a number as a percentage.

##### Example: Number Manipulation

1. **Controller**:

   ```java
   @GetMapping("/numberExample")
   public String numberExample(Model model) {
       model.addAttribute("price", 49.99);
       model.addAttribute("discount", 0.20);
       return "numberExample";
   }
   ```

2. **Template**:

   ```html
   <!DOCTYPE html>
   <html xmlns:th="http://www.thymeleaf.org">
     <head>
       <title>Number Utility Example</title>
     </head>
     <body>
       <h1>Number Utility Example</h1>
       <p>Price: <span th:text="${#numbers.formatCurrency(price)}"></span></p>
       <p>Discount: <span th:text="${#numbers.formatPercent(discount)}"></span></p>
     </body>
   </html>
   ```

This will display:
- The price formatted as currency.
- The discount formatted as a percentage.

---

#### d. Object Manipulation with `#objects`

The `#objects` utility allows for general object manipulation, such as checking if an object is null or accessing properties:

- `#objects.isNull(object)`: Checks if an object is null.
- `#objects.get(object, property)`: Accesses a property of an object.

##### Example: Object Manipulation

1. **Controller**:

   ```java
   @GetMapping("/objectExample")
   public String objectExample(Model model) {
       model.addAttribute("user", null); // Simulating a null user for demonstration
       return "objectExample";
   }
   ```

2. **Template**:

   ```html
   <!DOCTYPE html>
   <html xmlns:th="http://www.thymeleaf.org">
     <head>
       <title>Object Utility Example</title>
     </head>
     <body>
       <h1>Object Utility Example</h1>
       <p th:if="${#objects.isNull(user)}">User is not available.</p>
     </body>
   </html>
   ```

This will display:
- "User is not available." if the `user` object is null.

---

### Summary of Utility Objects

| **Utility Object** | **Methods**                                         | **Description**                                               |
|---------------------|----------------------------------------------------|---------------------------------------------------------------|
| `#strings`          | `capitalize`, `toUpperCase`, `toLowerCase`, `contains` | Manipulates and checks strings.                              |
| `#dates`            | `format(date, pattern)`, `formatISO(date)`, `now()` | Formats and manipulates dates.                               |
| `#numbers`          | `formatDecimal(value)`, `formatCurrency(value)`, `formatPercent(value)` | Formats numbers, currencies, and percentages.                |
| `#objects`          | `isNull(object)`, `get(object, property)`        | General object manipulation and property access.             |

---
