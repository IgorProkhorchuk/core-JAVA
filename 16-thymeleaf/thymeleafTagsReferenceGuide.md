Here's a **Thymeleaf Tag Reference Guide** to help you get a quick overview of the most commonly used Thymeleaf tags.

---

### Core Thymeleaf Tags and Attributes

#### 1. **Variable Expressions**
   - **`${...}`**: Evaluates and outputs the value of the specified variable.
   - **`*{...}`**: Shorthand used within forms to refer to bound object properties.

#### 2. **Text and Content Display**
   - **`th:text`**: Replaces the element’s content with the result of an expression.
   - **`th:utext`**: Similar to `th:text` but renders HTML as unescaped, potentially allowing HTML injection (use with caution).

#### 3. **Attributes Manipulation**
   - **`th:href`**: Sets the `href` attribute in elements like `<a>` tags.
   - **`th:src`**: Sets the `src` attribute in elements like `<img>` tags.
   - **`th:class`, `th:style`, etc.**: Sets any attribute dynamically, e.g., class, style.
   - **`th:attr`**: Used to set multiple attributes at once.
   - **`th:attrprepend`, `th:attrappend`**: Adds values to existing attributes.

#### 4. **Conditional Evaluation**
   - **`th:if`**: Renders the element only if the expression is `true`.
   - **`th:unless`**: Renders the element only if the expression is `false`.

#### 5. **Iteration**
   - **`th:each`**: Iterates over a collection or array, rendering the element for each item.
   - **`th:each="item : ${items}"`**: Defines the variable `item` for each element in `items`.

#### 6. **Fragment and Layout Management**
   - **`th:fragment`**: Defines a fragment that can be reused in other templates.
   - **`th:replace`**: Replaces the current element with a specified fragment.
   - **`th:insert`**: Inserts a fragment into the current element without replacing it.

#### 7. **Forms and Input Binding** - [link](formsAndInput.md)
   - **`th:action`**: Specifies the URL where the form should be submitted.
   - **`th:object`**: Binds the form to an object, typically a model attribute.
   - **`th:field`**: Binds an input field to a specific property in the bound object.
   - **`th:value`**: Sets the value of an input field.

#### 8. **Inline JavaScript and Text**
   - **`th:inline="text"`**: Enables inline processing for text.
   - **`th:inline="javascript"`**: Enables inline JavaScript expressions.

#### 9. **Switch Statements**
   - **`th:switch`**: Acts like a switch statement; used with `th:case`.
   - **`th:case`**: Defines each case within a `th:switch`.

#### 10. **Localization and Message Resolution**
   - **`th:text="#{message.key}"`**: Retrieves a message from a properties file.
   - **`#{message.key(param)}`**: Passes parameters to messages.

#### 11. **Others**
   - **`th:remove`**: Removes the element from the DOM based on a condition.
   - **`th:include`**: Inserts the content of another template file (deprecated; use `th:replace` instead).
   - **`th:with`**: Defines local variables within a scope, useful in complex expressions.

---

### Utility Objects

Thymeleaf provides **expression utility objects** for common operations:
- **`#strings`**: String manipulation functions.
- **`#dates`**: Date operations.
- **`#numbers`**: Formatting numbers.
- **`#bools`**: Boolean evaluation functions.
- **`#arrays`, `#lists`, `#sets`, `#maps`**: Functions to work with collections.
- **`#ids`**: Generates unique IDs.
- **`#fields`**: Provides error-checking for forms.

---

### Summary Cheat Sheet

| **Thymeleaf Tag/Attribute** | **Description**                                      |
|-----------------------------|------------------------------------------------------|
| `${...}`                    | Variable expression                                  |
| `*{...}`                    | Bound property expression in forms                   |
| `th:text`                   | Replaces content with evaluated expression           |
| `th:utext`                  | Outputs unescaped HTML                               |
| `th:href` / `th:src`        | Sets `href` or `src` attribute dynamically           |
| `th:attr`                   | Sets multiple attributes                             |
| `th:if`, `th:unless`        | Conditional rendering                                |
| `th:each`                   | Loops over collections                               |
| `th:fragment`               | Defines reusable fragment                            |
| `th:replace`, `th:insert`   | Inserts/replaces content with fragment               |
| `th:action`, `th:object`    | Binds form action URL and object                     |
| `th:field`, `th:value`      | Binds input fields to model properties               |
| `th:inline`                 | Enables inline processing                            |
| `th:switch`, `th:case`      | Switch-case control flow                            |
| `th:text="#{msg.key}"`      | Retrieves localized message                          |
| `th:remove`                 | Removes element based on a condition                 |
| `th:with`                   | Defines local variables in scope                     |

This list should serve as a quick reference as you continue to build more complex Thymeleaf templates. 