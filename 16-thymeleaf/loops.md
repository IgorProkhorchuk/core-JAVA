**Loops in Thymeleaf** are essential for iterating over collections, making it easy to display lists of items, like products, posts, or users, in a template.

### 8. Loops with `th:each`

The `th:each` attribute is used to iterate over collections or arrays. Within each iteration, you can access each item and its index, which makes it easy to work with lists.

#### a. Basic Loop

To loop through a list, use `th:each` on any HTML element. Inside `th:each`, you define a variable to represent each item in the list.

**Example**:

1. **Controller Setup**:
   ```java
   @GetMapping("/products")
   public String getProducts(Model model) {
       List<String> products = List.of("Laptop", "Tablet", "Smartphone");
       model.addAttribute("products", products);
       return "productList";
   }
   ```

2. **Template**:
   ```html
   <ul>
     <li th:each="product : ${products}" th:text="${product}">Product Name</li>
   </ul>
   ```

- **Explanation**:
  - `product : ${products}`: Each item in `${products}` is represented by `product` during each iteration.
  - `th:text="${product}"`: Outputs the product name inside the `<li>` element.

- **Result**:
  ```html
  <ul>
    <li>Laptop</li>
    <li>Tablet</li>
    <li>Smartphone</li>
  </ul>
  ```

---

#### b. Accessing the Loop Index

Thymeleaf provides a special `status` variable to access the index and other useful properties of the loop.

**Example**:

```html
<ul>
  <li th:each="product, iterStat : ${products}">
    <span th:text="${iterStat.index}">0</span> - <span th:text="${product}">Product</span>
  </li>
</ul>
```

- **Explanation**:
  - `product, iterStat : ${products}`: `product` is the item, and `iterStat` is the loop status.
  - `iterStat.index`: The current index of the loop (starting at 0).
  
- **Result**:
  ```html
  <ul>
    <li>0 - Laptop</li>
    <li>1 - Tablet</li>
    <li>2 - Smartphone</li>
  </ul>
  ```

#### c. Additional Loop Status Properties

The `status` variable (`iterStat` in the example above) has several properties:

- **`index`**: The 0-based index of the loop.
- **`count`**: The 1-based index (index + 1).
- **`size`**: Total number of items in the list.
- **`even`** / **`odd`**: Boolean indicating whether the current loop iteration is even or odd.
- **`first`** / **`last`**: Boolean indicating if the current iteration is the first or last.

**Example of Conditional Styling Using Loop Properties**:

```html
<ul>
  <li th:each="product, iterStat : ${products}" 
      th:classappend="${iterStat.odd}? 'odd' : 'even'" 
      th:text="${product}">Product</li>
</ul>
```

- Here, `th:classappend="${iterStat.odd}? 'odd' : 'even'"` will add the class `"odd"` to odd items and `"even"` to even items.

---

### Summary of Loop Commands

| **Command**                        | **Purpose**                                                             |
|------------------------------------|-------------------------------------------------------------------------|
| `th:each="item : ${list}"`         | Loops through each `item` in `list`.                                    |
| `th:each="item, status : ${list}"` | Loops with `status` variable to track the loop index and other details. |
| `status.index`                     | Provides the 0-based index of the loop.                                 |
| `status.count`                     | Provides the 1-based index of the loop.                                 |
| `status.size`                      | Total number of items in the loop.                                      |
| `status.even` / `status.odd`       | Checks if the current loop iteration is even or odd.                    |
| `status.first` / `status.last`     | Checks if the current iteration is the first or last in the loop.       |

---

Looping is a powerful feature in Thymeleaf, enabling you to dynamically display lists of data in your templates.