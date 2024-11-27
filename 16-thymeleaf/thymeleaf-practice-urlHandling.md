**URL handling**, **fragments**, and **advanced form handling**. 

### 1. URL Handling with Thymeleaf

In Thymeleaf, URLs can be dynamically generated, which is particularly useful for linking to different parts of your application. Here are the common ways to handle URLs:

- **Relative URLs**: Use `@{/path}` to specify a URL relative to the application root.

#### Example

```html
<a th:href="@{/about}">About Us</a>
```

- **Parameterized URLs**: Use `@{/path(param1=${value1}, param2=${value2})}` to pass parameters.

#### Example

```java
@GetMapping("/user/{id}")
public String getUser(@PathVariable String id, Model model) {
    model.addAttribute("userId", id);
    return "user";
}
```

In the `user.html` template:

```html
<a th:href="@{/user/{id}(id=${userId})}">View User Profile</a>
```

This will produce a link like `/user/123` if `userId` is `123`.

---

### 2. Using Fragments for Reusable Components

Fragments allow you to create reusable pieces of HTML, which is useful for common elements like headers, footers, or navigation menus.

1. **Create a Fragment Template**:
   - In the `src/main/resources/templates`, create a file named `fragments.html`.
   
   ```html
   <!-- fragments.html -->
   <!DOCTYPE html>
   <html xmlns:th="http://www.thymeleaf.org">
     <body>
       <!-- Header Fragment -->
       <div th:fragment="header">
         <h1>My Awesome Application</h1>
         <nav>
           <a th:href="@{/}">Home</a> |
           <a th:href="@{/about}">About</a>
         </nav>
       </div>
       
       <!-- Footer Fragment -->
       <div th:fragment="footer">
         <footer>
           <p>&copy; 2024 My Awesome Application</p>
         </footer>
       </div>
     </body>
   </html>
   ```

2. **Include the Fragment in Other Templates**:

   In `index.html`, add references to the fragments using `th:insert`:

   ```html
   <!DOCTYPE html>
   <html xmlns:th="http://www.thymeleaf.org">
     <head>
       <title>Index Page</title>
     </head>
     <body>
       <!-- Include header -->
       <div th:insert="fragments :: header"></div>

       <p>Welcome to the index page!</p>

       <!-- Include footer -->
       <div th:insert="fragments :: footer"></div>
     </body>
   </html>
   ```

   Here, `th:insert="fragments :: header"` means "include the `header` fragment from `fragments.html`."

---

### 3. Advanced Form Handling

Let's build on what we learned with form handling by adding form validation and error messages. Spring Boot's validation annotations can be integrated with Thymeleaf to display messages based on validation rules.

1. **Update the Model** with Validation Annotations:

   - In `User` model, add annotations for validation:

     ```java
     import jakarta.validation.constraints.Min;
     import jakarta.validation.constraints.NotBlank;

     public class User {
         @NotBlank(message = "Name is required")
         private String name;

         @Min(value = 18, message = "Age must be at least 18")
         private int age;

         // Getters and setters
     }
     ```

2. **Configure the Controller to Validate**:

   - Update the controller to handle validation errors using `@Valid` and `BindingResult`:

     ```java
     @PostMapping("/submitForm")
     public String submitForm(@Valid @ModelAttribute User user, BindingResult result, Model model) {
         if (result.hasErrors()) {
             return "form";
         }
         model.addAttribute("submittedUser", user);
         return "result";
     }
     ```

3. **Add Error Display in the Form Template**:

   - Modify `form.html` to display validation error messages:

     ```html
     <!DOCTYPE html>
     <html xmlns:th="http://www.thymeleaf.org">
       <head>
         <title>Form Example with Validation</title>
       </head>
       <body>
         <h1>User Form</h1>
         <form th:action="@{/submitForm}" th:object="${user}" method="post">
           <label>Name:
             <input type="text" th:field="*{name}" />
             <span th:if="${#fields.hasErrors('name')}" th:errors="*{name}">Name Error</span>
           </label><br/>

           <label>Age:
             <input type="number" th:field="*{age}" />
             <span th:if="${#fields.hasErrors('age')}" th:errors="*{age}">Age Error</span>
           </label><br/>

           <button type="submit">Submit</button>
         </form>
       </body>
     </html>
     ```

   - `th:errors="*{field}"` displays the error message from the validation annotations if there’s a problem with that field.

---

### Summary of New Commands

| **Command**                        | **Description**                                                                                           |
|------------------------------------|-----------------------------------------------------------------------------------------------------------|
| `@{/path}`                         | Creates a relative URL for navigation.                                                                    |
| `@{/path(param1=${value1})}`       | Passes parameters within a URL.                                                                           |
| `th:fragment="name"`               | Defines a fragment with a specific name to be reused.                                                     |
| `th:insert="template :: fragment"` | Includes a specified fragment from another template.                                                      |
| `@Valid`                           | Validates an object using annotations.                                                                    |
| `BindingResult`                    | Holds validation results, allowing error checking in the controller.                                      |
| `th:errors="*{field}"`             | Displays validation error messages for a specific field in a form.                                        |
| `th:if="${#fields.hasErrors('field')}"` | Checks if a specific field has validation errors for conditional error display. |

---

This setup prepares you to create modular, user-friendly, and validated forms in Thymeleaf