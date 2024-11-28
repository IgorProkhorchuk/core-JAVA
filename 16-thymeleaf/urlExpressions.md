**URL expressions** allow you to create dynamic URLs that adapt to different contexts, such as resource files, links, and controllers within the application.

### 6. URL Expressions

In Thymeleaf, URL expressions are used to generate URLs dynamically within templates. These expressions are handy for linking to other pages, including assets like CSS and JavaScript, and navigating between controller endpoints.

#### Syntax
- **Basic Syntax**: `@{...}`
- Inside `@{...}`, you specify the path, which can be relative, absolute, or parameterized.

---

#### a. Linking to Static Resources

To link to static resources (e.g., CSS, JavaScript, images) in the `src/main/resources/static` directory, you use the `@{...}` syntax. Thymeleaf will automatically resolve the path based on your application’s structure.

**Example**:

1. **Add Resources to `src/main/resources/static`**:
   - `styles.css` in `src/main/resources/static/css/`
   - `logo.png` in `src/main/resources/static/images/`

2. **Include Resources in Template**:
   ```html
   <!DOCTYPE html>
   <html xmlns:th="http://www.thymeleaf.org">
     <head>
       <link rel="stylesheet" th:href="@{/css/styles.css}">
     </head>
     <body>
       <img th:src="@{/images/logo.png}" alt="Logo">
     </body>
   </html>
   ```

- `@{/css/styles.css}` generates the URL for `styles.css` located in the `static/css` folder.
- `@{/images/logo.png}` provides the path for `logo.png` in `static/images`.

---

#### b. Dynamic Links to Controller Endpoints

Thymeleaf also uses URL expressions to generate links to specific controller endpoints. This is particularly helpful for internal navigation, as Thymeleaf adapts URLs based on your routing setup.

**Example**:

1. **Controller Endpoint**:
   ```java
   @GetMapping("/user/{id}")
   public String getUserProfile(@PathVariable("id") String userId, Model model) {
       model.addAttribute("userId", userId);
       return "userProfile";
   }
   ```

2. **Link to Endpoint in Template**:
   ```html
   <a th:href="@{/user/{id}(id=${userId})}">View Profile</a>
   ```

- `@{/user/{id}(id=${userId})}` generates a URL for the `/user/{id}` route, replacing `{id}` with the actual value of `${userId}`.
- If `${userId}` is `123`, this link would resolve to `/user/123`.

---

#### c. URL Parameters

Thymeleaf URLs can also include query parameters, which is useful for search pages or paginated views.

**Example**:

1. **URL with Parameters**:
   ```html
   <a th:href="@{/search(query=${query}, page=${page})}">Search Results</a>
   ```

2. **Generated URL**:
   - If `${query}` is `thymeleaf` and `${page}` is `2`, this URL becomes `/search?query=thymeleaf&page=2`.

---

#### d. Context Relative URLs

If you need to generate URLs that are relative to the application’s root, use the context-relative format by starting the path with a `/`.

**Example**:
```html
<a th:href="@{/contact}">Contact Us</a>
```

This would generate a link to the `/contact` path relative to the application’s root URL.

---

### Summary of URL Expressions

| **Expression**                        | **Purpose**                                                  |
|---------------------------------------|--------------------------------------------------------------|
| `@{/path/to/resource}`                | Links to a static resource in `src/main/resources/static`.   |
| `@{/controller/{id}(id=${id})}`       | Links to a dynamic endpoint with path variable `{id}`.       |
| `@{/search(query=${query}, page=${page})}` | Links with query parameters.                           |
| `@{/relative/path}`                   | Context-relative URL from the application root.              |

URL expressions simplify linking within your Thymeleaf templates, keeping them adaptable and readable. 