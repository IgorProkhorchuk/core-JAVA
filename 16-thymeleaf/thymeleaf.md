**Thymeleaf**, a popular Java template engine often used in Spring Boot projects.

In Thymeleaf, you can create a base layout file, similar to a Django base template, and then extend it in other templates. Here’s a quick overview of how to set this up:

### 1. Define a Base Template
Create a base layout file, e.g., `base.html`, with placeholders for sections that will vary in other pages. For example:

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title th:text="${pageTitle}">Default Title</title>
</head>
<body>
    <header>
        <!-- Common header content -->
    </header>
    
    <main>
        <!-- This is where the page-specific content goes -->
        <div th:replace="~{::mainContent}"></div>
    </main>
    
    <footer>
        <!-- Common footer content -->
    </footer>
</body>
</html>
```

### 2. Create a Child Template
In your other templates, you can inherit and replace specific sections. For example, in `home.html`:

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head th:replace="base :: head"></head>
<body>
    <header th:replace="base :: header"></header>
    
    <div>
        <div th:fragment="mainContent">
            <h1>Welcome to Home Page</h1>
            <p>This content is unique to the Home page.</p>
        </div>
    </div>
    
    <footer th:replace="base :: footer"></footer>
</body>
</html>
```

### Notes
- `th:replace` and `th:fragment` are used for specifying sections to override or include.
- You can use `th:text` and other Thymeleaf expressions to populate dynamic content.

Just like in Django, this approach allows you to maintain a clean, DRY structure by defining a single base template and overriding specific sections in individual page templates.

Here’s a list of common Thymeleaf expressions used to dynamically render content in Spring Boot templates:

### 1. **Variable Expressions**
   - `th:text="${variable}"` - Outputs the value of a variable.
   - `th:utext="${variable}"` - Outputs unescaped HTML content.
   - `th:object="${object}"` - Sets an object as the default context for variables.

### 2. **Conditional Expressions**
   - `th:if="${condition}"` - Renders content if the condition is true.
   - `th:unless="${condition}"` - Renders content if the condition is false.

### 3. **URL Expressions**
   - `th:href="@{/path}"` - Generates a URL.
   - `th:src="@{/images/picture.jpg}"` - Sets an image source URL.

### 4. **Text and Attribute Expressions**
   - `th:text="${variable}"` - Replaces content with the text from a variable.
   - `th:attr="attrName=${value}"` - Sets a custom attribute.
   - `th:classappend="${condition} ? 'className' : 'anotherClassName'"` - Conditionally appends a class.

### 5. **Message Expressions**
   - `th:text="#{messageKey}"` - Retrieves a message from properties files.
   - `th:text="#{messageKey(parameter1, parameter2)}"` - Retrieves a message with parameters.

### 6. **Iteration Expressions**
   - `th:each="item : ${list}"` - Iterates over a list or array.
   - `th:each="key, value : ${map}"` - Iterates over a map with key-value pairs.

### 7. **Fragment Expressions**
   - `th:insert="~{templateName::fragmentName}"` - Inserts a fragment from another template.
   - `th:replace="~{templateName::fragmentName}"` - Replaces content with a fragment.

### 8. **Switch/Case Expressions**
   - `th:switch="${variable}"` - Initiates a switch statement.
   - `th:case="'value'"` - Defines a case within a switch.

### 9. **Inline JavaScript Expressions**
   - `th:inline="javascript"` - Allows inlining Thymeleaf variables in JavaScript code.

### 10. **Utility Expressions**
   - `#dates.format(date, 'yyyy-MM-dd')` - Formats dates.
   - `#numbers.formatDecimal(number, 0, 2)` - Formats numbers.
   - `#strings.append(prefix, suffix)` - Concatenates strings.
   - `#maps.entrySet(map)` - Accesses a map’s entries.
