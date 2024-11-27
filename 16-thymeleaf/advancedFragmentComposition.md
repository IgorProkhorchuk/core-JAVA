**Advanced Fragment Composition** in Thymeleaf is essential for creating reusable components and organizing your templates effectively.

### 4. Advanced Fragment Composition

Fragments are reusable template parts in Thymeleaf, allowing you to modularize components like headers, footers, or navigation bars. Fragments make templates cleaner, easier to maintain, and enable you to use common elements across multiple pages.

#### a. Defining and Using Fragments

To create a fragment, define it in a separate file or within the same file using the `th:fragment` attribute. You can then include, replace, or insert it in other templates.

**Syntax**:
- Define a fragment using `<div th:fragment="fragmentName">...</div>`.
- Reuse the fragment using `th:insert`, `th:replace`, or `th:include`.

---

#### Example: Basic Fragment Usage

Let’s start with a simple example where we define a header fragment and reuse it in a page.

1. **Create a Fragment in `header.html`**:

   ```html
   <!DOCTYPE html>
   <html xmlns:th="http://www.thymeleaf.org">
     <body>
       <div th:fragment="headerFragment">
         <h1>My Thymeleaf Website</h1>
         <nav>
           <a href="/">Home</a> |
           <a href="/about">About</a> |
           <a href="/contact">Contact</a>
         </nav>
       </div>
     </body>
   </html>
   ```

2. **Include the Fragment in `home.html`**:

   ```html
   <!DOCTYPE html>
   <html xmlns:th="http://www.thymeleaf.org">
     <body>
       <div th:insert="~{header :: headerFragment}"></div>
       <div>
         <h2>Welcome to the Homepage</h2>
         <p>This is the main content.</p>
       </div>
     </body>
   </html>
   ```

- Here, `th:insert` includes the `headerFragment` defined in `header.html`.
- The syntax `~{header :: headerFragment}` specifies the fragment’s location (`header.html`) and its name (`headerFragment`).

---

#### b. Difference Between `th:insert`, `th:replace`, and `th:include`

- **`th:insert`**: Inserts the fragment as a child of the target element.
- **`th:replace`**: Replaces the entire target element with the fragment, including its tag.
- **`th:include`**: Inserts the fragment’s content within the target element without including the fragment’s top-level tag.

##### Example: `th:insert` vs. `th:replace`

```html
<!-- Using th:insert -->
<div th:insert="~{header :: headerFragment}"></div>

<!-- Using th:replace -->
<div th:replace="~{header :: headerFragment}"></div>
```

In the first case, `<div>` is retained, and the fragment is added as a child. In the second case, `<div>` is replaced entirely by the fragment.

---

#### c. Passing Parameters to Fragments

Thymeleaf allows passing parameters to fragments, making them even more versatile. Define parameters in the fragment using the `th:fragment` syntax, and pass values when including it.

1. **Fragment with Parameters** in `header.html`:

   ```html
   <div th:fragment="headerFragment(title)">
     <h1 th:text="${title}">Default Title</h1>
     <nav>
       <a href="/">Home</a> |
       <a href="/about">About</a> |
       <a href="/contact">Contact</a>
     </nav>
   </div>
   ```

2. **Pass Parameters in `home.html`**:

   ```html
   <div th:insert="~{header :: headerFragment('Welcome to My Site')}"></div>
   ```

In this example:
- `headerFragment(title)` accepts a `title` parameter.
- When included, `'Welcome to My Site'` is passed as the title, which is displayed in the `<h1>` tag.

---

### Practical Use Cases for Fragments

- **Headers and Footers**: Define standard headers and footers and reuse them across all pages.
- **Reusable UI Components**: Create fragments for cards, buttons, or modals that you can use throughout your site.
- **Dynamic Content**: Use fragments with parameters to dynamically alter the fragment content without rewriting HTML.

---

### Summary of Fragment Composition Commands

| **Command**       | **Purpose**                                                                                           |
|-------------------|-------------------------------------------------------------------------------------------------------|
| `th:fragment`     | Defines a reusable fragment in the template.                                                          |
| `th:insert`       | Inserts the fragment as a child of the target element.                                                |
| `th:replace`      | Replaces the target element entirely with the fragment.                                               |
| `th:include`      | Inserts the fragment content within the target element but omits the fragment’s top-level tag.        |
| `th:fragment(...)` | Allows passing parameters to a fragment for dynamic customization.                                    |

---

Advanced fragment composition is a powerful way to make your templates modular, reusable, and easier to maintain.