### Set

In Java, a **Set** is a collection that **does not allow duplicate elements**. It is part of the **Java Collections Framework** and provides a way to store **unique elements** in an unordered fashion. The `Set` interface extends the `Collection` interface and models the mathematical concept of a set, meaning it contains no duplicate elements.

Key properties of a `Set`:
- **No duplicates**: A `Set` cannot contain two elements that are considered equal based on the `equals()` method.
- **Unordered**: The elements in a `Set` are not stored in a particular order (except in specific implementations like `TreeSet`, which stores them in natural or custom-defined order).
- **Efficient membership testing**: Checking whether an element is present in a `Set` is generally efficient (constant time in `HashSet`).

Java provides several implementations of the `Set` interface, each with different characteristics and use cases:
- **HashSet**: Uses a hash table to store elements.
- **LinkedHashSet**: Maintains the insertion order while using a hash table.
- **TreeSet**: Stores elements in a sorted order using a red-black tree.

---

### The Set Interface

The **`Set` interface** in Java is a part of `java.util` package and provides operations to manage collections of unique elements. It does not introduce new methods beyond what is inherited from the `Collection` interface, but it enforces the uniqueness of its elements.

Here are the key methods inherited from `Collection` that `Set` provides:
- **add(E element)**: Adds the specified element to the set if it's not already present.
- **remove(Object o)**: Removes the specified element from the set if it is present.
- **contains(Object o)**: Returns `true` if the set contains the specified element.
- **size()**: Returns the number of elements in the set.
- **clear()**: Removes all elements from the set.
- **iterator()**: Returns an iterator over the elements in the set.

### Implementations of Set in Java

There are several common implementations of the `Set` interface, each with unique characteristics.

---

### 1. HashSet

#### What is `HashSet`?

**`HashSet`** is the most commonly used implementation of the `Set` interface. It is backed by a **hash table** (actually a `HashMap`), which provides constant-time performance for basic operations like `add()`, `remove()`, and `contains()` (O(1) on average). However, `HashSet` makes no guarantees about the **order of elements**; the order of insertion and retrieval may be different.

#### Characteristics of `HashSet`:
1. **No duplicates**: Elements are added based on their hash values, and duplicates are not allowed.
2. **Unordered**: The elements are not stored in any particular order.
3. **Efficient operations**: Basic operations such as adding, removing, and checking the presence of elements have an average time complexity of O(1).
4. **Null elements**: A single `null` element is allowed in `HashSet`.

#### Important methods in `HashSet`:
- **add(E e)**: Adds the specified element to the set if it’s not already present.
- **contains(Object o)**: Checks if the set contains the specified element.
- **remove(Object o)**: Removes the specified element from the set if it is present.

#### Example: Basic Operations with `HashSet`
```java
import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>();
        
        // Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        // Add a duplicate element (ignored)
        fruits.add("Apple");

        // Check if an element exists
        System.out.println("Contains Banana: " + fruits.contains("Banana"));  // Output: true

        // Remove an element
        fruits.remove("Cherry");

        // Print the set
        System.out.println(fruits);  // Output: [Banana, Apple] (order is not guaranteed)
    }
}
```

#### When to use `HashSet`?
- When you need to **store unique elements** and the **order does not matter**.
- When you need **fast access** to elements for operations like searching, adding, or deleting.

---

### 2. LinkedHashSet

#### What is `LinkedHashSet`?

**`LinkedHashSet`** is a subclass of `HashSet` that preserves the **insertion order** of elements. This means that when you iterate through a `LinkedHashSet`, the elements are returned in the order in which they were added. Internally, it combines a **hash table** with a **linked list** to maintain insertion order while still providing O(1) performance for basic operations like `add()`, `remove()`, and `contains()`.

#### Characteristics of `LinkedHashSet`:
1. **No duplicates**: As with `HashSet`, duplicate elements are not allowed.
2. **Maintains insertion order**: The elements are stored in the order they were added.
3. **Efficient operations**: Similar to `HashSet`, `LinkedHashSet` offers O(1) time complexity for most operations.
4. **Null elements**: One `null` element is allowed.

#### Example: Basic Operations with `LinkedHashSet`
```java
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        Set<String> fruits = new LinkedHashSet<>();
        
        // Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        // Add a duplicate element (ignored)
        fruits.add("Apple");

        // Print the set (insertion order is maintained)
        System.out.println(fruits);  // Output: [Apple, Banana, Cherry]
    }
}
```

#### When to use `LinkedHashSet`?
- When you need to store **unique elements** but want to **preserve the insertion order**.
- When you need fast performance similar to `HashSet`, but with an order guarantee.

---

### 3. TreeSet

#### What is `TreeSet`?

**`TreeSet`** is a `NavigableSet` implementation based on a **red-black tree**. It stores the elements in a **sorted order**, either according to the **natural ordering** of the elements (if they implement the `Comparable` interface) or a **custom comparator** provided at the set’s creation.

#### Characteristics of `TreeSet`:
1. **No duplicates**: As with other `Set` implementations, duplicates are not allowed.
2. **Sorted order**: The elements are stored in ascending order, or in a custom order defined by a `Comparator`.
3. **Efficient search**: `TreeSet` provides O(log n) time complexity for basic operations like `add()`, `remove()`, and `contains()`.
4. **Navigable methods**: `TreeSet` provides methods like `first()`, `last()`, `ceiling()`, `floor()`, etc., to navigate through the sorted set.

#### Example: Basic Operations with `TreeSet`
```java
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        Set<String> fruits = new TreeSet<>();
        
        // Add elements
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Cherry");

        // Print the set (elements are sorted)
        System.out.println(fruits);  // Output: [Apple, Banana, Cherry]

        // Access first and last elements
        System.out.println("First element: " + ((TreeSet<String>) fruits).first());  // Output: Apple
        System.out.println("Last element: " + ((TreeSet<String>) fruits).last());  // Output: Cherry
    }
}
```

#### When to use `TreeSet`?
- When you need **unique elements** that are **sorted**.
- When you need to efficiently retrieve elements based on their **sorted position** or use the **navigation methods** like `first()`, `last()`, or `subSet()`.

---

### Comparing HashSet, LinkedHashSet, and TreeSet

| Feature                 | `HashSet`                           | `LinkedHashSet`                       | `TreeSet`                            |
|-------------------------|-------------------------------------|---------------------------------------|--------------------------------------|
| **Underlying Data Structure** | Hash table                        | Hash table + Linked list               | Red-black tree                       |
| **Order**                | Unordered                           | Insertion order preserved              | Sorted order                         |
| **Duplicate Elements**   | Not allowed                         | Not allowed                           | Not allowed                          |
| **Null Elements**        | One `null` element allowed          | One `null` element allowed             | No `null` elements allowed           |
| **Time Complexity (average)** | O(1) for `add()`, `remove()`, `contains()` | O(1) for `add()`, `remove()`, `contains()` | O(log n) for `add()`, `remove()`, `contains()` |
| **Usage**                | When order is not important         | When insertion order matters           | When sorted order is required        |

---

### Other Specialized Sets in Java

1. **EnumSet**
   - A specialized `Set` implementation designed for use with enum types.
   - It is extremely fast and space-efficient but can only be used with enums.
   - `EnumSet` is

 internally represented as a **bit vector**, providing very fast performance.

2. **CopyOnWriteArraySet**
   - Part of the `java.util.concurrent` package, it is a thread-safe variant of `Set`.
   - It uses a **copy-on-write** strategy, which means the entire set is copied every time it is modified.
   - This set is ideal for use cases where read operations greatly outnumber write operations.

---

### Conclusion

- The `Set` interface in Java represents an unordered collection of unique elements.
- **`HashSet`** is the go-to choice for most situations where order does not matter, and efficient operations are required.
- **`LinkedHashSet`** is used when the insertion order must be preserved.
- **`TreeSet`** is ideal for situations where elements need to be sorted.
- Choosing the right `Set` implementation depends on your specific use case, especially whether you need ordering or sorting, and how you prioritize performance.