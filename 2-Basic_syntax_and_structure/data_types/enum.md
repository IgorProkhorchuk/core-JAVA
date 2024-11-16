An **enum** in Java is a special data type used to define a collection of constants. It provides a way to define a set of related values that are immutable and type-safe. Enums are particularly useful when you need to represent fixed sets of constants, such as days of the week, colors, or directions.

### Syntax of Enum in Java

To declare an enum, use the `enum` keyword:

```java
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
```

Here, `Day` is an enum that contains seven constants: `MONDAY`, `TUESDAY`, and so on.

---

### Using Enums in Java

1. **Accessing Enum Values**:
   You can refer to enum values directly using their names.

   ```java
   Day today = Day.WEDNESDAY;
   System.out.println("Today is: " + today);
   ```

2. **Switch Statements with Enums**:
   Enums are commonly used with `switch` statements.

   ```java
   public class EnumExample {
       public static void main(String[] args) {
           Day today = Day.MONDAY;

           switch (today) {
               case MONDAY:
                   System.out.println("Start of the workweek!");
                   break;
               case FRIDAY:
                   System.out.println("End of the workweek!");
                   break;
               case SATURDAY:
               case SUNDAY:
                   System.out.println("It's the weekend!");
                   break;
               default:
                   System.out.println("Midweek day.");
           }
       }
   }
   ```

3. **Iterating Over Enum Values**:
   Use the `values()` method to iterate through all constants in an enum.

   ```java
   for (Day day : Day.values()) {
       System.out.println(day);
   }
   ```

4. **Enum with Fields and Methods**:
   Enums can have fields, methods, and constructors. This is useful when constants need additional data.

   ```java
   public enum Planet {
       MERCURY(3.303e+23, 2.4397e6),
       VENUS(4.869e+24, 6.0518e6),
       EARTH(5.976e+24, 6.37814e6),
       MARS(6.421e+23, 3.3972e6);

       private final double mass;   // in kilograms
       private final double radius; // in meters

       Planet(double mass, double radius) {
           this.mass = mass;
           this.radius = radius;
       }

       public double surfaceGravity() {
           double G = 6.67300E-11;
           return G * mass / (radius * radius);
       }
   }
   ```

   Usage:

   ```java
   public class Main {
       public static void main(String[] args) {
           for (Planet p : Planet.values()) {
               System.out.printf("Planet: %s, Surface Gravity: %.2f%n", p, p.surfaceGravity());
           }
       }
   }
   ```

---

### Key Points About Enums:
- **Type-Safe**: Enums restrict variables to predefined constants, reducing bugs.
- **Immutable**: Enum constants cannot be modified.
- **Built-in Methods**:
  - `values()` returns an array of all constants in the enum.
  - `ordinal()` gives the position of the constant (0-based).
  - `name()` returns the name of the constant as a `String`.

---
