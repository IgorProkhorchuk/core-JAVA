### **1. `th:action`**
The `th:action` attribute in Thymeleaf is used to specify the target URL for a form submission. It dynamically resolves the URL, allowing it to adapt to different contexts, such as environment variables, request parameters, or controller mappings. 

#### **Key Points**:
- **Dynamic URL Generation**: Generates the URL based on Thymeleaf expressions or URL mapping.
- **Relative and Absolute URLs**: Supports both types.
- **Path Variables**: Can include dynamic path variables.

#### **Syntax**:
```html
<form th:action="@{/path}" method="post">
```

#### **Usage Scenarios**:
- To direct the form submission to a controller endpoint dynamically.
- To include path variables or query parameters in the action URL.

#### **Examples**:
1. **Simple URL**:
   ```html
   <form th:action="@{/submitForm}" method="post">
   ```

2. **Dynamic URL with Path Variables**:
   ```html
   <form th:action="@{/user/{id}(id=${user.id})}" method="post">
   ```

3. **Dynamic URL with Query Parameters**:
   ```html
   <form th:action="@{/search(param=${searchParam})}" method="get">
   ```

---

### **2. `th:object`**
The `th:object` attribute is used to bind a form to a model object, enabling Thymeleaf to map form fields to the object's properties automatically.

#### **Key Points**:
- **Form-Binding**: Sets a specific object as the form's command object.
- **Prefix for Fields**: Simplifies referencing properties of the bound object in form fields.

#### **Syntax**:
```html
<form th:object="${modelObject}">
```

#### **Usage Scenarios**:
- When creating forms that directly map to Java objects.
- When working with Spring MVC `@ModelAttribute` or `@RequestBody`.

#### **Examples**:
1. **Binding to an Object**:
   ```html
   <form th:object="${user}" th:action="@{/register}" method="post">
       <input type="text" th:field="*{name}" />
       <input type="email" th:field="*{email}" />
   </form>
   ```
   In this example, `user` is the object bound to the form, and the `name` and `email` fields correspond to its properties.

2. **Nested Objects**:
   ```html
   <form th:object="${order}">
       <input type="text" th:field="*{customer.name}" />
       <input type="text" th:field="*{customer.address}" />
   </form>
   ```
   Here, `order` is the form object, and `customer` is a nested object within it.

---

### **3. `th:field`**
The `th:field` attribute is used to bind an HTML form input field to a property of the object specified by `th:object`. It automatically populates the input field's `name`, `id`, and `value` attributes.

#### **Key Points**:
- **Two-Way Binding**: Updates the object property with the form field's value and pre-populates the field with the object's current value.
- **Automatic Naming**: Generates the `name` and `id` attributes based on the bound property.

#### **Syntax**:
```html
<input th:field="*{propertyName}" />
```

#### **Usage Scenarios**:
- When creating form fields tied to an object's properties.
- For seamless integration with backend validation frameworks.

#### **Examples**:
1. **Basic Binding**:
   ```html
   <input type="text" th:field="*{name}" />
   ```
   This binds the input field to the `name` property of the object specified by `th:object`.

2. **Dropdown Binding**:
   ```html
   <select th:field="*{role}">
       <option value="USER">User</option>
       <option value="ADMIN">Admin</option>
   </select>
   ```

3. **Checkbox Binding**:
   ```html
   <input type="checkbox" th:field="*{active}" />
   ```

---

### **4. `th:value`**
The `th:value` attribute is used to set the `value` attribute of an input field dynamically. It is commonly used for pre-filling form fields with data.

#### **Key Points**:
- **One-Way Binding**: Unlike `th:field`, it doesn't handle two-way data binding or validation.
- **Explicit Value Setting**: Provides more control for specific cases.

#### **Syntax**:
```html
<input type="text" th:value="${valueExpression}" />
```

#### **Usage Scenarios**:
- For fields that need to display data without being tied to an object.
- When using calculated or preprocessed values.

#### **Examples**:
1. **Static Value**:
   ```html
   <input type="text" th:value="${user.name}" />
   ```

2. **Default Value**:
   ```html
   <input type="text" th:value="${user.name ?: 'Default Name'}" />
   ```

3. **Dynamic Calculations**:
   ```html
   <input type="text" th:value="${#dates.format(user.birthdate, 'yyyy-MM-dd')}" />
   ```

---

### **Comparison Between `th:field` and `th:value`**:
| Feature            | `th:field`                          | `th:value`                      |
|---------------------|-------------------------------------|----------------------------------|
| **Binding Type**    | Two-way (binds to object property) | One-way (sets static/dynamic value) |
| **Usage**           | Form input bound to an object      | Pre-filling fields without binding |
| **Validation**      | Integrated with Spring validation  | No validation support           |

---

These attributes work together to simplify form creation in Thymeleaf, integrating seamlessly with backend frameworks like Spring Boot.