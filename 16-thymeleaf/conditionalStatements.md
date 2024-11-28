**Conditional Statements** in Thymeleaf are incredibly useful for displaying or hiding elements based on specific conditions. This helps in creating dynamic, interactive templates.

### 7. Conditional Statements

Thymeleaf provides various attributes that let you apply conditions in templates, such as `th:if`, `th:unless`, and `th:switch`. These allow you to show or hide elements, making your templates responsive to the data they receive.

---

#### a. `th:if` and `th:unless`

- **`th:if`**: Displays an element only if the specified condition is `true`.
- **`th:unless`**: Displays an element only if the specified condition is `false`.

**Example**:

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
  <body>
    <p th:if="${isUserLoggedIn}">Welcome back!</p>
    <p th:unless="${isUserLoggedIn}">Please log in to continue.</p>
  </body>
</html>
```

- If `${isUserLoggedIn}` is `true`, the message “Welcome back!” will be displayed.
- If `${isUserLoggedIn}` is `false`, the message “Please log in to continue.” will appear instead.

#### b. `th:switch` and `th:case`

For cases where you need to display one of multiple options based on a specific value, you can use `th:switch` with `th:case`.

- **`th:switch`**: Acts as a control expression.
- **`th:case`**: Specifies possible cases to match within the `th:switch`.

**Example**:

1. **Template with `th:switch`**:
   ```html
   <div th:switch="${userRole}">
     <p th:case="'admin'">Welcome, Administrator!</p>
     <p th:case="'user'">Welcome, User!</p>
     <p th:case="*">Welcome, Guest!</p>
   </div>
   ```

2. **Explanation**:
   - If `${userRole}` is `"admin"`, it displays “Welcome, Administrator!”
   - If `${userRole}` is `"user"`, it displays “Welcome, User!”
   - The `*` in `th:case="*"` acts as a default case, shown if none of the previous cases match.

#### c. Combining Conditions with Logical Operators

Thymeleaf allows combining conditions using logical operators like `&&` (and), `||` (or), and `!` (not) within `th:if` or `th:unless` statements.

**Example**:

```html
<p th:if="${isUserLoggedIn} && ${hasAdminRights}">Admin Access Granted</p>
<p th:if="${isUserLoggedIn} && !${hasAdminRights}">Standard User Access</p>
```

- The first line displays “Admin Access Granted” if both `${isUserLoggedIn}` and `${hasAdminRights}` are `true`.
- The second line shows “Standard User Access” if `${isUserLoggedIn}` is `true` but `${hasAdminRights}` is `false`.

---

### Summary of Conditional Statements

| **Command**                | **Purpose**                                                 |
|----------------------------|-------------------------------------------------------------|
| `th:if="${condition}"`     | Displays element only if `condition` is `true`.             |
| `th:unless="${condition}"` | Displays element only if `condition` is `false`.            |
| `th:switch="${expression}"`| Creates a switch block, evaluated by `th:case`.             |
| `th:case="value"`          | Specifies a case in `th:switch`, where `value` can be a default (`*`). |

---

Conditional statements add flexibility to your templates, allowing you to customize content based on the data provided to the page.