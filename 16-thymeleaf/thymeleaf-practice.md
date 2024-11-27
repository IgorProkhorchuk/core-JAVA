Thymeleaf is a powerful template engine for Java-based applications, especially popular in Spring Boot projects. It allows you to create dynamic, server-rendered HTML pages with seamless integration of HTML5 templates.

To get started with Thymeleaf, we'll walk through setting up a simple Spring Boot project and then explore some basic Thymeleaf syntax. Here's a quick overview of the setup and initial usage:

### Step 1: Setting Up Thymeleaf in a Spring Boot Project

1. **Create a Spring Boot project**:
   - You can use [Spring Initializr](https://start.spring.io/) to generate a new Spring Boot project.
   - Select the following dependencies:
     - **Spring Web** (for creating a web application)
     - **Thymeleaf** (for our templating engine)
   
   - Download the generated project, unzip it, and open it in your IDE.

2. **Thymeleaf Dependency**:
   - Spring Boot auto-configures Thymeleaf when you add the dependency. If you created a project without it, you can add this to your `pom.xml` for Maven:

     ```xml
     <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-thymeleaf</artifactId>
     </dependency>
     ```

3. **Folder Structure**:
   - Thymeleaf templates should go in the `src/main/resources/templates` directory. Spring Boot looks here by default.

### Step 2: Creating a Simple Thymeleaf Template

1. **Create an HTML File**:
   - In the `templates` folder, create a file called `index.html`.
   - Write a simple Thymeleaf template:

     ```html
     <!DOCTYPE html>
     <html xmlns:th="http://www.thymeleaf.org">
       <head>
         <title>Thymeleaf Demo</title>
       </head>
       <body>
         <h1>Welcome to Thymeleaf!</h1>
         <p th:text="'Hello, ' + ${name} + '!'" />
       </body>
     </html>
     ```

   - Here, we use the `th:text` attribute, which is one of Thymeleaf’s core features. It binds the expression inside `th:text` to a variable in our controller.

### Step 3: Creating a Controller

1. **Set up a Controller to Pass Data to Thymeleaf**:
   - In the `src/main/java` directory, create a package like `com.example.demo.controller`.
   - Inside this package, create a new class called `DemoController`.

   - Here’s a basic controller setup:

     ```java
     package com.example.demo.controller;

     import org.springframework.stereotype.Controller;
     import org.springframework.ui.Model;
     import org.springframework.web.bind.annotation.GetMapping;

     @Controller
     public class DemoController {

         @GetMapping("/")
         public String index(Model model) {
             model.addAttribute("name", "Thymeleaf Learner");
             return "index";
         }
     }
     ```

   - This controller adds an attribute (`name`) to the `Model` object, which makes it accessible in the Thymeleaf template.

### Step 4: Run the Application

1. **Run the Application**:
   - Start your Spring Boot application. In your terminal or IDE, use:

     ```bash
     ./mvnw spring-boot:run
     ```

2. **View the Template**:
   - Open a browser and go to `http://localhost:8080`.
   - You should see "Hello, Thymeleaf Learner!" displayed on the page, rendered from your Thymeleaf template.

---

This setup lets you start using Thymeleaf expressions and variables.

Let's dive into some of the most useful Thymeleaf features: **loops**, **conditionals**, and **form handling**. These will give you more control over the HTML content rendered by the server.

### 1. Using Loops

Thymeleaf makes it easy to display lists of items using the `th:each` attribute. Here’s how to use it:

1. **Update the Controller** to add a list of names:

   ```java
   @GetMapping("/names")
   public String names(Model model) {
       List<String> names = List.of("Alice", "Bob", "Charlie");
       model.addAttribute("names", names);
       return "names";
   }
   ```

2. **Create a Template for the List**:

   - In `src/main/resources/templates`, create a `names.html` file:

     ```html
     <!DOCTYPE html>
     <html xmlns:th="http://www.thymeleaf.org">
       <head>
         <title>Name List</title>
       </head>
       <body>
         <h1>Names List</h1>
         <ul>
           <li th:each="name : ${names}" th:text="${name}"></li>
         </ul>
       </body>
     </html>
     ```

   - The `th:each` attribute iterates over each item in the `names` list, and `th:text="${name}"` displays each item inside an `<li>` tag.

### 2. Adding Conditionals

You can use conditionals to display content based on certain conditions, using `th:if` and `th:unless`.

1. **Update the Controller** to add a flag variable:

   ```java
   @GetMapping("/conditional")
   public String conditional(Model model) {
       model.addAttribute("isAdmin", true); // Change to false to test
       return "conditional";
   }
   ```

2. **Create a Template with Conditional Content**:

   - In `src/main/resources/templates`, create `conditional.html`:

     ```html
     <!DOCTYPE html>
     <html xmlns:th="http://www.thymeleaf.org">
       <head>
         <title>Conditional Example</title>
       </head>
       <body>
         <h1>Welcome, User</h1>
         <p th:if="${isAdmin}">You have administrator privileges.</p>
         <p th:unless="${isAdmin}">You are a regular user.</p>
       </body>
     </html>
     ```

   - `th:if="${isAdmin}"` shows the element only if `isAdmin` is `true`.
   - `th:unless="${isAdmin}"` shows the element only if `isAdmin` is `false`.

### 3. Handling Forms with Thymeleaf

Forms in Thymeleaf allow you to handle user input easily. Here’s how to create a simple form and bind it to a model.

1. **Create a Model Class** for user input data:

   - In `src/main/java/com/example/demo/model`, create a `User` class:

     ```java
     package com.example.demo.model;

     public class User {
         private String name;
         private int age;

         // Getters and Setters
         public String getName() { return name; }
         public void setName(String name) { this.name = name; }

         public int getAge() { return age; }
         public void setAge(int age) { this.age = age; }
     }
     ```

2. **Create a Controller Method** to handle form submission:

   ```java
   import com.example.demo.model.User;

   @GetMapping("/form")
   public String showForm(Model model) {
       model.addAttribute("user", new User());
       return "form";
   }

   @PostMapping("/submitForm")
   public String submitForm(@ModelAttribute User user, Model model) {
       model.addAttribute("submittedUser", user);
       return "result";
   }
   ```

3. **Create a Form Template**:

   - In `src/main/resources/templates`, create `form.html`:

     ```html
     <!DOCTYPE html>
     <html xmlns:th="http://www.thymeleaf.org">
       <head>
         <title>Form Example</title>
       </head>
       <body>
         <h1>User Form</h1>
         <form th:action="@{/submitForm}" th:object="${user}" method="post">
           <label>Name: <input type="text" th:field="*{name}" /></label><br/>
           <label>Age: <input type="number" th:field="*{age}" /></label><br/>
           <button type="submit">Submit</button>
         </form>
       </body>
     </html>
     ```

   - `th:object="${user}"` binds the form to the `User` object.
   - `th:field="*{name}"` and `th:field="*{age}"` bind each form input to the corresponding field in the `User` model.

4. **Display Submitted Data**:

   - Create `result.html` to show the submitted data:

     ```html
     <!DOCTYPE html>
     <html xmlns:th="http://www.thymeleaf.org">
       <head>
         <title>Form Result</title>
       </head>
       <body>
         <h1>Form Submission Result</h1>
         <p>Name: <span th:text="${submittedUser.name}"></span></p>
         <p>Age: <span th:text="${submittedUser.age}"></span></p>
       </body>
     </html>
     ```

### Running the Application

- Now, run the application and go to `http://localhost:8080/form` to test the form submission.
- After submitting, it should display the `result.html` page with the entered data.

---

Here's a summary of our progress so far, along with a handy cheatsheet of the Thymeleaf commands and syntax we've covered.

---

### **Progress Summary**

1. **Project Setup**: Created a Spring Boot project with Thymeleaf dependency and organized the template files in the `src/main/resources/templates` directory.
2. **Basic Thymeleaf Syntax**:
   - Displayed dynamic content using variables from the controller.
   - Used Thymeleaf expressions in HTML tags for basic text rendering.
3. **Looping with `th:each`**: Rendered lists of items by looping over data from the model.
4. **Conditionals with `th:if` and `th:unless`**: Showed or hid content based on conditions.
5. **Form Handling**:
   - Created a form with `th:field` for binding inputs to model properties.
   - Used `th:action` to specify form submission endpoints.
   - Processed form data in the controller and displayed it on a result page.

---

### **Thymeleaf Cheatsheet**

| **Command**          | **Description**                                                                                     |
|----------------------|-----------------------------------------------------------------------------------------------------|
| `th:text="${var}"`   | Replaces the element's content with the value of `var`.                                             |
| `th:each="item : ${list}"` | Loops over `list`, binding each element to `item`.                                    |
| `th:if="${condition}"` | Displays the element only if `condition` is true.                                                 |
| `th:unless="${condition}"` | Displays the element only if `condition` is false.                                         |
| `th:action="@{/url}"` | Sets the form's action to the specified URL path.                                                  |
| `th:object="${modelAttribute}"` | Binds a form to an object, making its properties available with `th:field`.            |
| `th:field="*{property}"` | Binds a form field to a specific property in the model object.                                  |
| `@{}`                  | Used for URL expressions, resolving paths relative to the server's root.                          |
| `${variable}`          | Accesses a variable from the model passed in the controller.                                      |
| `*{property}`          | Accesses a property within an object bound to the form with `th:object`.                          |

---

