**Fragment Inclusion** in Thymeleaf allows you to break your templates into reusable components. This is incredibly helpful for modularity, especially for layouts that share common sections, like headers, footers, and navigation bars.

### 9. Fragment Inclusion

Fragments let you define sections in a template that can be reused across different pages. This keeps your code DRY (Don’t Repeat Yourself) and makes it easy to maintain consistent layouts.

---

#### a. Defining Fragments

Fragments are defined using the `th:fragment` attribute, typically inside a separate file (like a `fragments.html`) but can also be part of the same template.

**Example: Creating a `fragments.html` file**:
```html
<!-- fragments.html -->
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
  <body>
    <header th:fragment="header">
      <h1>Welcome to Our Site</h1>
      <nav>
        <a th:href="@{/}">Home</a> |
        <a th:href="@{/about}">About</a> |
        <a th:href="@{/contact}">Contact</a>
      </nav>
    </header>
    
    <footer th:fragment="footer">
      <p>&copy; 2024 Your Site. All rights reserved.</p>
    </footer>
  </body>
</html>
```

- **Explanation**:
  - `th:fragment="header"`: Defines a fragment named `header`.
  - `th:fragment="footer"`: Defines a fragment named `footer`.

---

#### b. Including Fragments in Other Templates

To include a fragment in another template, use the `th:insert` or `th:replace` attributes.

- **`th:insert`**: Inserts the fragment content into the current element, keeping both the current element and the fragment element.
- **`th:replace`**: Replaces the current element entirely with the fragment content.

**Example**:

```html
<!-- main.html -->
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
  <body>
    <!-- Insert Header Fragment -->
    <div th:insert="~{fragments :: header}"></div>
    
    <main>
      <h2>Main Content Here</h2>
      <p>This is where the main content of the page goes.</p>
    </main>
    
    <!-- Insert Footer Fragment -->
    <div th:insert="~{fragments :: footer}"></div>
  </body>
</html>
```

- **Explanation**:
  - `~{fragments :: header}`: Refers to the `header` fragment in the `fragments.html` file.
  - `~{fragments :: footer}`: Refers to the `footer` fragment in the `fragments.html` file.

> **Tip**: Use `th:replace` instead of `th:insert` if you want to replace the surrounding `<div>` element with the fragment itself.

---

#### c. Passing Parameters to Fragments

You can pass parameters to fragments, making them more flexible and customizable.

**Example: Adding a Customizable Header**:
1. **Define Fragment with Parameters**:
   ```html
   <!-- fragments.html -->
   <header th:fragment="header(title)">
     <h1 th:text="${title}">Default Title</h1>
     <nav>
       <a th:href="@{/}">Home</a> |
       <a th:href="@{/about}">About</a> |
       <a th:href="@{/contact}">Contact</a>
     </nav>
   </header>
   ```

2. **Use Fragment with Parameters**:
   ```html
   <!-- main.html -->
   <div th:replace="~{fragments :: header(title='Welcome to My Site')}"></div>
   ```

- **Explanation**:
  - `th:fragment="header(title)"`: Defines a `header` fragment that accepts a parameter called `title`.
  - `th:replace="~{fragments :: header(title='Welcome to My Site')}"`: Passes the value `'Welcome to My Site'` to the `title` parameter.

---

### Summary of Fragment Inclusion

| **Command**                      | **Purpose**                                                       |
|----------------------------------|-------------------------------------------------------------------|
| `th:fragment="name"`             | Defines a fragment with the specified `name`.                     |
| `th:insert="~{template :: name}"`| Inserts the fragment without replacing the current element.       |
| `th:replace="~{template :: name}"`| Replaces the current element entirely with the fragment.         |
| `th:fragment="name(param1, ...)"`| Defines a fragment that accepts parameters.                       |
| `th:replace="~{template :: name(param='value')}"`| Passes parameters to the fragment.   |

---

Using fragments, you can create templates that are both modular and flexible, enabling you to build and manage a consistent look across your application.