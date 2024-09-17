### Comparable and Comparator interfaces

In Java, **`Comparable`** and **`Comparator`** are two interfaces used for sorting objects in collections. Both interfaces define methods that help compare objects to determine their ordering. The choice between `Comparable` and `Comparator` depends on how you want to implement the comparison logic and where the sorting behavior needs to be applied.

---

### `Comparable` Interface

The **`Comparable`** interface defines a **natural ordering** for objects of a class. When a class implements `Comparable`, it can be compared with other objects of the same class.

#### Key Features:
- It is part of the **`java.lang`** package.
- A class that implements `Comparable` needs to override the `compareTo()` method.
- The `compareTo()` method is used to define the **natural ordering** of the objects.
- Typically used when you have a **single way** of comparing objects (i.e., only one comparison logic).
- Implementing `Comparable` affects the objects’ **default sorting order** in collections like `TreeSet`, `TreeMap`, and `Collections.sort()`.

#### Syntax of `Comparable` Interface:
```java
public interface Comparable<T> {
    int compareTo(T obj);
}
```

#### `compareTo()` Method:
- Returns a negative integer if the current object is **less than** the argument object.
- Returns `0` if the current object is **equal to** the argument object.
- Returns a positive integer if the current object is **greater than** the argument object.

---

### Example of `Comparable` Implementation

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Implementing the compareTo() method
    @Override
    public int compareTo(Student other) {
        // Natural ordering by age
        return this.age - other.age;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

public class ComparableExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 25));
        students.add(new Student("Bob", 20));
        students.add(new Student("Charlie", 22));

        // Sorting the list using Comparable (natural ordering by age)
        Collections.sort(students);

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
```

#### Output:
```
Student{name='Bob', age=20}
Student{name='Charlie', age=22}
Student{name='Alice', age=25}
```

In the example above:
- The `Student` class implements the `Comparable` interface.
- The `compareTo()` method is defined to compare students by age. When the list of students is sorted, they are ordered by their age in ascending order.

---

### `Comparator` Interface

The **`Comparator`** interface is used when we want to define multiple ways of comparing objects or when we don't have control over the class’s source code to implement `Comparable`.

#### Key Features:
- It is part of the **`java.util`** package.
- It provides a way to define **custom ordering** for objects, without modifying the class itself.
- A class can have **multiple comparators** to define different comparison strategies.
- It allows sorting based on multiple attributes.
- Used with methods like `Collections.sort()` or `Arrays.sort()`.

#### Syntax of `Comparator` Interface:
```java
public interface Comparator<T> {
    int compare(T obj1, T obj2);
}
```

#### `compare()` Method:
- Returns a negative integer if the first object is **less than** the second object.
- Returns `0` if the first object is **equal to** the second object.
- Returns a positive integer if the first object is **greater than** the second object.

---

### Example of `Comparator` Implementation

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

// Custom Comparator to sort by name
class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
}

// Custom Comparator to sort by age in descending order
class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s2.age - s1.age;
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 25));
        students.add(new Student("Bob", 20));
        students.add(new Student("Charlie", 22));

        // Sorting by name using NameComparator
        Collections.sort(students, new NameComparator());
        System.out.println("Sorted by name:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Sorting by age using AgeComparator
        Collections.sort(students, new AgeComparator());
        System.out.println("Sorted by age (descending):");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
```

#### Output:
```
Sorted by name:
Student{name='Alice', age=25}
Student{name='Bob', age=20}
Student{name='Charlie', age=22}

Sorted by age (descending):
Student{name='Alice', age=25}
Student{name='Charlie', age=22}
Student{name='Bob', age=20}
```

In this example:
- Two `Comparator` implementations (`NameComparator` and `AgeComparator`) are used to sort the `Student` objects.
- **`NameComparator`** sorts the students alphabetically by name.
- **`AgeComparator`** sorts the students by age in **descending order**.

---

### Key Differences Between `Comparable` and `Comparator`

| Feature             | Comparable                                   | Comparator                                   |
|---------------------|----------------------------------------------|---------------------------------------------|
| **Package**         | `java.lang`                                  | `java.util`                                 |
| **Method**          | `compareTo(Object obj)`                      | `compare(Object obj1, Object obj2)`         |
| **Purpose**         | Defines natural ordering of objects          | Defines custom ordering of objects          |
| **Implementation**  | Class itself must implement `Comparable`     | A separate class implements `Comparator`    |
| **Number of Sorts** | Only one way of comparison (natural order)    | Multiple ways of comparison possible        |
| **Modification**    | Modifies the class by implementing `Comparable` | Does not modify the class; external to the class |
| **Used With**       | `Collections.sort()`                         | `Collections.sort()`, `Arrays.sort()`       |

---

### When to Use `Comparable` and `Comparator`

- **Use `Comparable`** when:
  - You need to define a **single, natural sorting** order for the class.
  - You want the sorting logic to be part of the class itself.

- **Use `Comparator`** when:
  - You need to define **multiple sorting criteria** or external sorting.
  - You don't have control over the source code of the class you want to sort.
  - You want to keep sorting logic **separate from the class** being sorted.

---

### Java 8 Enhancements

With Java 8, **`Comparator`** has been enhanced with **lambda expressions** and several **static and default methods** that make writing comparators easier.

#### Example with Lambda Expressions:
```java
import java.util.*;

public class LambdaComparatorExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 25));
        students.add(new Student("Bob", 20));
        students.add(new Student("Charlie", 22));

        // Sort by name using lambda expression
        students.sort((s1, s2) -> s1.name.compareTo(s2.name));

        // Sort by age using lambda expression
        students.sort((s1, s2) -> s1.age - s2.age);

        students.forEach(System.out::println);
    }
}
```

#### Default Methods in `Comparator` Interface:
- **`thenComparing()`**: Enables chaining multiple comparators for secondary sorting.
  
  ```java
  students.sort(Comparator.comparing(Student::getAge)
                          .thenComparing(Student::getName));
  ```

- **`reversed()`**: Reverses the comparison order.
  
  ```java
  students.sort(Comparator.comparing(Student::getAge).reversed());
  ```

---

### Conclusion

- **`Comparable`** is used to define a **natural order** within the class itself, and it provides a single comparison logic.
- **`Comparator`** is used to define **custom ordering** outside the class, which is useful for multiple or external sorting strategies.
- The decision to use `Comparable` or `Comparator` depends on the need for single or multiple sorting criteria and whether you want the comparison logic to be inside or outside the class.