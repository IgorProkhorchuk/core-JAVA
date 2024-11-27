Let's get started with **Attribute Precedence** in Thymeleaf!

### 1. Attribute Precedence

Thymeleaf processes template attributes in a specific order, which can affect how templates render when you use multiple attributes on a single element. Understanding this order helps you control how your pages render and troubleshoot unexpected behavior.

Here’s the attribute precedence order in Thymeleaf, from highest to lowest priority:

1. **`th:with`** – Defines local variables within a specific scope.
2. **`th:object`** – Defines the context object for other attributes.
3. **`th:each`** – Used for looping through collections.
4. **`th:remove`** – Removes the element from the DOM.
5. **Conditional Attributes**: 
   - **`th:if`** – Renders content if the condition is true.
   - **`th:unless`** – Renders content if the condition is false.
6. **Specific Attributes**: `th:text`, `th:utext`, `th:href`, etc. – Set specific properties like text, URLs, etc.
7. **General Attribute Replacement**: `th:attr` – Dynamically sets multiple attributes on an element.
8. **Fragment Inclusion**: `th:insert`, `th:replace` – Adds reusable content from fragments.
9. **DOM Manipulation**: `th:classappend`, `th:styleappend`, etc. – Modifies the class, style, or other attributes.

---

#### Example of Attribute Precedence in Action

Let's look at an example where we use multiple Thymeleaf attributes on the same element:

1. **Controller**:

   ```java
   @GetMapping("/product")
   public String getProduct(Model model) {
       model.addAttribute("available", true);
       model.addAttribute("productName", "Thymeleaf Guide");
       return "product";
   }
   ```

2. **Template**:

   ```html
   <!DOCTYPE html>
   <html xmlns:th="http://www.thymeleaf.org">
     <head>
       <title>Product Page</title>
     </head>
     <body>
       <div th:with="discounted = available ? 20 : 0" th:if="${available}">
         <p th:text="'Product: ' + ${productName}">Product Name</p>
         <p th:text="'Discount: ' + ${discounted} + '%'">Discount</p>
       </div>
     </body>
   </html>
   ```

In this example:
- `th:with` sets a local variable `discounted` based on `available`, which is processed before `th:if`.
- `th:if="${available}"` renders the `<div>` only if `available` is true, using the variable `discounted`.
- `th:text` for the `<p>` tags applies next, displaying the `productName` and `discounted` values.

Because of this order, you can rely on `th:with` to set variables before `th:if` checks the condition, and `th:if` will determine whether the content is displayed before any `th:text` attributes are processed.

---

### Practical Use Cases

- **Controlling Content Flow**: When looping through items, you can set variables with `th:with`, then conditionally display items with `th:if`, and finally apply styles or attributes based on values.
- **Optimizing Rendering**: Use higher-precedence attributes like `th:remove` to eliminate unnecessary elements, reducing DOM load and improving rendering performance.

---
