**Inline Text Processing** in Thymeleaf lets you format and manipulate text inline within text nodes. Inline text processing is useful for scenarios where you need to format or combine strings within a sentence, rather than in separate attributes.

### 3. Inline Text Processing

In Thymeleaf, inline text processing allows you to evaluate expressions directly inside text nodes, avoiding the need for multiple `th:text` attributes. This is particularly handy for mixing static and dynamic content in a single line.

There are two main types of inline text processing:

1. **Text Inlining with `|...|` Syntax**:
   - Use `|...|` syntax to embed Thymeleaf expressions within static text. This allows for seamless text integration without breaking it up into multiple `th:text` attributes.
   - **Syntax**: Place dynamic expressions within the `|` pipes.

2. **Variable Expressions within Text**:
   - Use `${...}` for variable expressions or `#{...}` for message expressions within `|...|` syntax.

---

#### Example of Text Inlining with `|...|` Syntax

Let’s see how inline text processing can make text formatting cleaner in Thymeleaf templates.

1. **Controller**:

   ```java
   @GetMapping("/inlineText")
   public String inlineTextExample(Model model) {
       model.addAttribute("name", "Thymeleaf User");
       model.addAttribute("course", "Thymeleaf Basics");
       return "inlineText";
   }
   ```

2. **Template**:

   ```html
   <!DOCTYPE html>
   <html xmlns:th="http://www.thymeleaf.org">
     <head>
       <title>Inline Text Processing</title>
     </head>
     <body>
       <h1>Welcome Message</h1>
       <p th:text="|Hello, ${name}! Welcome to the ${course} course.|">
         Placeholder text.
       </p>
     </body>
   </html>
   ```

In this example:
- The `|...|` syntax allows you to embed `${name}` and `${course}` directly within the sentence.
- When the page renders, it displays: `"Hello, Thymeleaf User! Welcome to the Thymeleaf Basics course."`

#### Key Points
- Inline text processing combines dynamic variables with static text.
- The use of `|...|` keeps the entire sentence in one tag, making it more readable and concise.

---

#### Using Conditional Logic Inside Inline Text

You can also use inline expressions with conditional logic to modify text content dynamically.

**Example**:

1. **Controller**:

   ```java
   @GetMapping("/conditionalInline")
   public String conditionalInlineExample(Model model) {
       model.addAttribute("role", "admin");
       return "conditionalInline";
   }
   ```

2. **Template**:

   ```html
   <!DOCTYPE html>
   <html xmlns:th="http://www.thymeleaf.org">
     <head>
       <title>Conditional Inline Text</title>
     </head>
     <body>
       <p th:text="|You are ${role == 'admin' ? 'an administrator' : 'a regular user'} on this site.|">
         Placeholder text.
       </p>
     </body>
   </html>
   ```

This will display:
- `"You are an administrator on this site."` if the role is `admin`.
- `"You are a regular user on this site."` if the role is anything else.

#### Use Cases for Inline Text Processing

- **Personalized Greetings**: Use `|Hello, ${username}|` for creating custom greetings.
- **Notifications**: Display messages with dynamic data, e.g., `|You have ${count} new messages.|`.
- **Conditional Text**: Create context-dependent messages with conditional logic directly in the text node.

---

### Summary of Inline Text Processing

| **Syntax**                 | **Description**                                                                                         |
|----------------------------|---------------------------------------------------------------------------------------------------------|
| `|Hello, ${name}!|`        | Inserts the value of `name` within the sentence.                                                        |
| `|You are ${role == 'admin' ? 'an administrator' : 'a user'}|` | Conditional logic to change text based on variable value.        |

Inline text processing is a powerful way to make your templates more concise, readable, and adaptable for various scenarios without extra `th:text` attributes.

---
