Text formatting in Thymeleaf can help improve the display of dates, numbers, and other information based on locale and style. 

Let’s look into the essentials for **number formatting**, **date formatting**, and **internationalization** (i18n).

---

### 1. Number Formatting

Thymeleaf allows you to format numbers (integers, decimals, percentages, etc.) using the `#numbers.formatXXX` utility methods.

#### Example: Formatting Currency and Percentages

1. **Controller**:
   Add values to the model for demonstration:

   ```java
   @GetMapping("/formatting")
   public String formattingExample(Model model) {
       model.addAttribute("price", 1999.99);
       model.addAttribute("discount", 0.15);
       return "formatting";
   }
   ```

2. **Template**:
   Use `#numbers.formatCurrency` and `#numbers.formatPercent` for displaying values:

   ```html
   <!DOCTYPE html>
   <html xmlns:th="http://www.thymeleaf.org">
     <head>
       <title>Number Formatting</title>
     </head>
     <body>
       <h1>Product Information</h1>
       <p>Price: <span th:text="${#numbers.formatCurrency(price)}"></span></p>
       <p>Discount: <span th:text="${#numbers.formatPercent(discount)}"></span></p>
     </body>
   </html>
   ```

   - `#numbers.formatCurrency(price)` displays `1999.99` as `€1,999.99` (or your locale's currency format).
   - `#numbers.formatPercent(discount)` displays `0.15` as `15%`.

---

### 2. Date Formatting

Date formatting in Thymeleaf uses the `#dates` utility for standard date-time patterns.

#### Example: Formatting Dates and Times

1. **Controller**:
   Add a `LocalDateTime` to the model:

   ```java
   import java.time.LocalDateTime;

   @GetMapping("/dateExample")
   public String dateExample(Model model) {
       model.addAttribute("now", LocalDateTime.now());
       return "dateExample";
   }
   ```

2. **Template**:
   Use `#dates.format` with a pattern to display dates in different formats:

   ```html
   <!DOCTYPE html>
   <html xmlns:th="http://www.thymeleaf.org">
     <head>
       <title>Date Formatting</title>
     </head>
     <body>
       <h1>Date and Time</h1>
       <p>Full Date: <span th:text="${#dates.format(now, 'MMMM d, yyyy')}"></span></p>
       <p>ISO DateTime: <span th:text="${#dates.formatISO(now)}"></span></p>
       <p>Custom Format: <span th:text="${#dates.format(now, 'yyyy-MM-dd HH:mm:ss')}"></span></p>
     </body>
   </html>
   ```

   - `#dates.format(now, 'MMMM d, yyyy')` displays something like "October 28, 2024."
   - `#dates.formatISO(now)` formats the date in ISO standard, e.g., "2024-10-28T14:45:00."
   - `#dates.format(now, 'yyyy-MM-dd HH:mm:ss')` custom formats as "2024-10-28 14:45:00."

---

### 3. Internationalization (i18n)

For multi-language support, Thymeleaf lets you use messages properties files to define localized messages.

1. **Create Properties Files**:
   - In `src/main/resources`, create `messages.properties` for English and `messages_de.properties` for German.

   ```properties
   # messages.properties
   welcome=Welcome
   price=Price
   discount=Discount
   date=Date
   ```

   ```properties
   # messages_de.properties
   welcome=Willkommen
   price=Preis
   discount=Rabatt
   date=Datum
   ```

2. **Template**:
   Use `#{message_key}` in your templates to access localized messages:

   ```html
   <!DOCTYPE html>
   <html xmlns:th="http://www.thymeleaf.org">
     <head>
       <title>Internationalization Example</title>
     </head>
     <body>
       <h1 th:text="#{welcome}">Welcome</h1>
       <p th:text="#{price}">Price</p>
       <p th:text="#{discount}">Discount</p>
       <p th:text="#{date}">Date</p>
     </body>
   </html>
   ```

   When you switch the locale, Thymeleaf will display the correct language.

3. **Changing Locale in Spring Boot**:
   To switch locales, you can add a `LocaleChangeInterceptor` in your Spring Boot configuration.

   ```java
   import org.springframework.context.annotation.Bean;
   import org.springframework.context.annotation.Configuration;
   import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
   import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
   import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
   import org.springframework.web.servlet.i18n.SessionLocaleResolver;

   import java.util.Locale;

   @Configuration
   public class WebConfig implements WebMvcConfigurer {

       @Bean
       public SessionLocaleResolver localeResolver() {
           SessionLocaleResolver resolver = new SessionLocaleResolver();
           resolver.setDefaultLocale(Locale.ENGLISH);
           return resolver;
       }

       @Bean
       public LocaleChangeInterceptor localeChangeInterceptor() {
           LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
           interceptor.setParamName("lang");
           return interceptor;
       }

       @Override
       public void addInterceptors(InterceptorRegistry registry) {
           registry.addInterceptor(localeChangeInterceptor());
       }
   }
   ```

   Now, you can change the language by adding `?lang=de` (for German) to the URL, and it will load `messages_de.properties`.

---

### Cheatsheet for Formatting and i18n

| **Command**                         | **Description**                                                                                   |
|-------------------------------------|---------------------------------------------------------------------------------------------------|
| `#numbers.formatCurrency(var)`      | Formats `var` as currency according to the locale.                                                |
| `#numbers.formatPercent(var)`       | Formats `var` as a percentage.                                                                    |
| `#dates.format(var, 'pattern')`     | Formats `var` with a specified date-time pattern.                                                 |
| `#dates.formatISO(var)`             | Formats `var` in ISO date format.                                                                 |
| `#{message_key}`                    | Retrieves a localized message from properties file.                                               |
| `LocaleChangeInterceptor`           | Allows locale changes by adding `lang` parameter to URLs, e.g., `?lang=de`.                       |

---
