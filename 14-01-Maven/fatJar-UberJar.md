### What Is a Fat JAR (Uber JAR)?

A **Fat JAR** (or Uber JAR) is a JAR file that contains:
1. **Your project's compiled code**.
2. **All of your project's dependencies** in a single file.

This is useful when:
- You want to distribute your application as a standalone executable.
- Your project depends on libraries not available on the runtime classpath.

### Why Use a Fat JAR?

- Standard JAR files only include your project's compiled code, not its dependencies.
- When running such a JAR, you'd need to manually include dependencies using the `-cp` or `--class-path` option.
- A Fat JAR eliminates this hassle by bundling everything into a single file.

---

### How Does Maven Help?

Maven, with plugins like **Shade** or **Assembly**, automates the creation of a Fat JAR by:
- Collecting all the dependencies declared in your `pom.xml`.
- Packaging them along with your code into a single JAR.

---

### Detailed Explanation of Plugins

#### **1. Maven Shade Plugin**
The **Shade Plugin** is specifically designed for creating Fat JARs. It handles dependency conflicts and lets you customize how classes and resources are merged.

#### Steps to Use the Maven Shade Plugin:

1. **Add the Plugin to Your `pom.xml`**:
   ```xml
   <build>
       <plugins>
           <plugin>
               <groupId>org.apache.maven.plugins</groupId>
               <artifactId>maven-shade-plugin</artifactId>
               <version>3.4.1</version>
               <executions>
                   <execution>
                       <phase>package</phase>
                       <goals>
                           <goal>shade</goal>
                       </goals>
                       <configuration>
                           <createDependencyReducedPom>true</createDependencyReducedPom>
                       </configuration>
                   </execution>
               </executions>
           </plugin>
       </plugins>
   </build>
   ```

   - **`createDependencyReducedPom`**: Generates a simplified POM file to avoid double-loading dependencies during runtime.

2. **Build the Fat JAR**:
   Run the following command:
   ```bash
   ./mvnw package
   ```
   
3. **Result**:
   The Fat JAR will be located in the `target/` directory. Its name might be:
   ```
   myapp-1.0-SNAPSHOT-shaded.jar
   ```

---

#### **2. Maven Assembly Plugin**
The **Assembly Plugin** is more general-purpose. It can package dependencies, resources, or anything else. It's slightly more complex but very flexible.

#### Steps to Use the Maven Assembly Plugin:

1. **Add the Plugin to Your `pom.xml`**:
   ```xml
   <build>
       <plugins>
           <plugin>
               <groupId>org.apache.maven.plugins</groupId>
               <artifactId>maven-assembly-plugin</artifactId>
               <version>3.6.0</version>
               <configuration>
                   <descriptorRefs>
                       <descriptorRef>jar-with-dependencies</descriptorRef>
                   </descriptorRefs>
               </configuration>
               <executions>
                   <execution>
                       <id>make-assembly</id>
                       <phase>package</phase>
                       <goals>
                           <goal>single</goal>
                       </goals>
                   </execution>
               </executions>
           </plugin>
       </plugins>
   </build>
   ```

2. **Build the Fat JAR**:
   Run the following command:
   ```bash
   ./mvnw package
   ```

3. **Result**:
   The Fat JAR will be located in the `target/` directory. Its name will include `-jar-with-dependencies`, such as:
   ```
   myapp-1.0-SNAPSHOT-jar-with-dependencies.jar
   ```

---

### Differences Between Shade and Assembly

| Feature                 | Maven Shade Plugin                      | Maven Assembly Plugin                  |
|-------------------------|-----------------------------------------|---------------------------------------|
| **Purpose**              | Specialized for Fat JARs               | General-purpose bundling tool         |
| **Handles Dependency Conflicts** | Yes                             | No                                     |
| **Customizable**         | Highly (merge strategies, relocations) | Less customization for dependency handling |
| **Ease of Use**          | Easy for Fat JARs                      | Slightly more complex                 |

---

### Example: Running the Fat JAR

Once you have your Fat JAR:
```bash
java -jar target/myapp-1.0-SNAPSHOT-shaded.jar
```

---

### Advanced Configuration (Shade Plugin)

- **Relocating Dependencies**:
  Sometimes, dependencies might have conflicting class names. Shade lets you relocate them to avoid conflicts:
  ```xml
  <configuration>
      <relocations>
          <relocation>
              <pattern>com.example.conflict</pattern>
              <shadedPattern>com.example.shaded.conflict</shadedPattern>
          </relocation>
      </relocations>
  </configuration>
  ```

- **Merging Resources**:
  You can define how resources (e.g., `META-INF/` files) should be merged:
  ```xml
  <configuration>
      <filters>
          <filter>
              <artifact>*:*</artifact>
              <excludes>
                  <exclude>META-INF/*.SF</exclude>
                  <exclude>META-INF/*.DSA</exclude>
              </excludes>
          </filter>
      </filters>
  </configuration>
  ```

---

This approach allows you to deliver a single, standalone JAR, simplifying deployment and usage. 
