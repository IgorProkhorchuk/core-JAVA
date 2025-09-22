The `Files` class in Java is a utility class introduced in Java 7 as part of the NIO.2 (New I/O 2) API. It provides static methods for performing operations on files, directories, and other types of files. The `Files` class works hand-in-hand with the `Path` interface to provide a modern, comprehensive file handling API.

## Overview and Key Characteristics

**Static Utility Class**: All methods in `Files` are static, so you don't create instances of this class.

**Path-Based Operations**: All methods work with `Path` objects rather than `File` objects, providing better abstraction and cross-platform compatibility.

**Exception Handling**: Provides more specific and meaningful exceptions compared to the legacy `File` class.

**Atomic Operations**: Many operations are atomic where possible, reducing the chance of partial failures.

## File Existence and Basic Properties

### Checking File Existence
```java
Path path = Path.of("/home/user/file.txt");

// Check if file exists
boolean exists = Files.exists(path);

// Check if file doesn't exist
boolean notExists = Files.notExists(path);

// Note: If you can't determine existence (permissions, etc.), 
// both might return false
```

### File Type Checking
```java
// Check if it's a regular file
boolean isRegularFile = Files.isRegularFile(path);

// Check if it's a directory
boolean isDirectory = Files.isDirectory(path);

// Check if it's a symbolic link
boolean isSymLink = Files.isSymbolicLink(path);

// Check if file is hidden
boolean isHidden = Files.isHidden(path);
```

### File Accessibility
```java
// Check if readable
boolean readable = Files.isReadable(path);

// Check if writable
boolean writable = Files.isWritable(path);

// Check if executable
boolean executable = Files.isExecutable(path);
```

## File Attributes and Metadata

### Basic File Information
```java
try {
    // File size in bytes
    long size = Files.size(path);
    
    // Last modified time
    FileTime lastModified = Files.getLastModifiedTime(path);
    
    // Set last modified time
    FileTime newTime = FileTime.fromMillis(System.currentTimeMillis());
    Files.setLastModifiedTime(path, newTime);
    
} catch (IOException e) {
    // Handle exception
}
```

### Advanced File Attributes
```java
try {
    // Basic file attributes
    BasicFileAttributes basicAttrs = Files.readAttributes(path, BasicFileAttributes.class);
    
    System.out.println("Creation time: " + basicAttrs.creationTime());
    System.out.println("Last access time: " + basicAttrs.lastAccessTime());
    System.out.println("Last modified time: " + basicAttrs.lastModifiedTime());
    System.out.println("Is directory: " + basicAttrs.isDirectory());
    System.out.println("Is regular file: " + basicAttrs.isRegularFile());
    System.out.println("Is symbolic link: " + basicAttrs.isSymbolicLink());
    System.out.println("Size: " + basicAttrs.size());
    
    // DOS attributes (Windows)
    if (Files.getFileStore(path).supportsFileAttributeView(DosFileAttributeView.class)) {
        DosFileAttributes dosAttrs = Files.readAttributes(path, DosFileAttributes.class);
        System.out.println("Is hidden: " + dosAttrs.isHidden());
        System.out.println("Is read-only: " + dosAttrs.isReadOnly());
    }
    
    // POSIX attributes (Unix/Linux)
    if (Files.getFileStore(path).supportsFileAttributeView(PosixFileAttributeView.class)) {
        PosixFileAttributes posixAttrs = Files.readAttributes(path, PosixFileAttributes.class);
        System.out.println("Owner: " + posixAttrs.owner());
        System.out.println("Group: " + posixAttrs.group());
        System.out.println("Permissions: " + posixAttrs.permissions());
    }
    
} catch (IOException e) {
    // Handle exception
}
```

### File Permissions (POSIX Systems)
```java
try {
    // Get current permissions
    Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(path);
    
    // Set new permissions (e.g., rwxr--r--)
    Set<PosixFilePermission> newPermissions = EnumSet.of(
        PosixFilePermission.OWNER_READ,
        PosixFilePermission.OWNER_WRITE,
        PosixFilePermission.OWNER_EXECUTE,
        PosixFilePermission.GROUP_READ,
        PosixFilePermission.OTHERS_READ
    );
    Files.setPosixFilePermissions(path, newPermissions);
    
} catch (IOException e) {
    // Handle exception
}
```

## File Creation and Deletion

### Creating Files
```java
try {
    // Create a new empty file
    Path newFile = Files.createFile(path);
    
    // Create file with specific attributes
    Set<PosixFilePermission> permissions = EnumSet.of(
        PosixFilePermission.OWNER_READ,
        PosixFilePermission.OWNER_WRITE
    );
    FileAttribute<Set<PosixFilePermission>> fileAttributes = 
        PosixFileAttributes.asFileAttribute(permissions);
    Path secureFile = Files.createFile(path, fileAttributes);
    
    // Create temporary file
    Path tempFile = Files.createTempFile("prefix", ".tmp");
    Path tempFileInDir = Files.createTempFile(tempDir, "prefix", ".tmp");
    
} catch (FileAlreadyExistsException e) {
    // File already exists
} catch (IOException e) {
    // Other I/O error
}
```

### Creating Directories
```java
try {
    // Create a single directory
    Path newDir = Files.createDirectory(path);
    
    // Create directory hierarchy (like mkdir -p)
    Path dirHierarchy = Files.createDirectories(Path.of("/home/user/new/deep/directory"));
    
    // Create temporary directory
    Path tempDir = Files.createTempDirectory("prefix");
    Path tempDirInParent = Files.createTempDirectory(parentDir, "prefix");
    
} catch (FileAlreadyExistsException e) {
    // Directory already exists
} catch (IOException e) {
    // Other I/O error
}
```

### Deleting Files and Directories
```java
try {
    // Delete file or empty directory
    Files.delete(path);
    
    // Delete if exists (no exception if doesn't exist)
    boolean deleted = Files.deleteIfExists(path);
    
} catch (NoSuchFileException e) {
    // File doesn't exist
} catch (DirectoryNotEmptyException e) {
    // Directory is not empty
} catch (IOException e) {
    // Other I/O error
}
```

## Reading Files

### Reading Entire File Content
```java
try {
    // Read all bytes
    byte[] bytes = Files.readAllBytes(path);
    
    // Read all lines as List<String>
    List<String> lines = Files.readAllLines(path);
    
    // Read all lines with specific charset
    List<String> linesUtf8 = Files.readAllLines(path, StandardCharsets.UTF_8);
    
    // Read entire file as String (Java 11+)
    String content = Files.readString(path);
    String contentUtf8 = Files.readString(path, StandardCharsets.UTF_8);
    
} catch (IOException e) {
    // Handle exception
}
```

### Streaming File Content
```java
try {
    // Stream lines (for large files)
    try (Stream<String> lines = Files.lines(path)) {
        lines.filter(line -> line.contains("search"))
             .forEach(System.out::println);
    }
    
    // Stream lines with charset
    try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
        long count = lines.count();
    }
    
} catch (IOException e) {
    // Handle exception
}
```

### Creating Readers
```java
try {
    // Create BufferedReader
    try (BufferedReader reader = Files.newBufferedReader(path)) {
        String line;
        while ((line = reader.readLine()) != null) {
            // Process line
        }
    }
    
    // Create BufferedReader with charset
    try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
        // Process file
    }
    
    // Create InputStream
    try (InputStream inputStream = Files.newInputStream(path)) {
        // Process stream
    }
    
    // Create InputStream with options
    try (InputStream inputStream = Files.newInputStream(path, StandardOpenOption.READ)) {
        // Process stream
    }
    
} catch (IOException e) {
    // Handle exception
}
```

## Writing Files

### Writing Entire Content
```java
try {
    // Write bytes
    byte[] data = "Hello World".getBytes();
    Files.write(path, data);
    
    // Write bytes with options
    Files.write(path, data, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    
    // Write lines
    List<String> lines = Arrays.asList("Line 1", "Line 2", "Line 3");
    Files.write(path, lines);
    
    // Write lines with charset and options
    Files.write(path, lines, StandardCharsets.UTF_8, 
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    
    // Write string (Java 11+)
    Files.writeString(path, "Hello World");
    Files.writeString(path, "Hello World", StandardCharsets.UTF_8, 
                      StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    
} catch (IOException e) {
    // Handle exception
}
```

### Creating Writers
```java
try {
    // Create BufferedWriter
    try (BufferedWriter writer = Files.newBufferedWriter(path)) {
        writer.write("Hello World");
        writer.newLine();
        writer.write("Second line");
    }
    
    // Create BufferedWriter with charset and options
    try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8,
                                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
        writer.write("Appended content");
    }
    
    // Create OutputStream
    try (OutputStream outputStream = Files.newOutputStream(path)) {
        outputStream.write("Hello".getBytes());
    }
    
} catch (IOException e) {
    // Handle exception
}
```

## Standard Open Options

The `StandardOpenOption` enum provides various options for file operations:

```java
// Common options
StandardOpenOption.READ          // Open for read access
StandardOpenOption.WRITE         // Open for write access
StandardOpenOption.APPEND        // Append to existing file
StandardOpenOption.TRUNCATE_EXISTING  // Truncate to zero length
StandardOpenOption.CREATE        // Create new file if it doesn't exist
StandardOpenOption.CREATE_NEW    // Create new file, fail if exists
StandardOpenOption.DELETE_ON_CLOSE   // Delete when closed
StandardOpenOption.SPARSE        // Sparse file
StandardOpenOption.SYNC          // Synchronous writes
StandardOpenOption.DSYNC         // Synchronous data writes

// Example usage
try (BufferedWriter writer = Files.newBufferedWriter(path, 
    StandardOpenOption.CREATE, 
    StandardOpenOption.APPEND,
    StandardOpenOption.SYNC)) {
    writer.write("Synchronized appended content");
}
```

## File Copying and Moving

### Copying Files
```java
try {
    // Simple copy
    Path copied = Files.copy(sourcePath, targetPath);
    
    // Copy with options
    Files.copy(sourcePath, targetPath, 
               StandardCopyOption.REPLACE_EXISTING,
               StandardCopyOption.COPY_ATTRIBUTES,
               LinkOption.NOFOLLOW_LINKS);
    
    // Copy from InputStream
    try (InputStream inputStream = new FileInputStream(sourceFile)) {
        Files.copy(inputStream, targetPath);
    }
    
    // Copy to OutputStream
    try (OutputStream outputStream = new FileOutputStream(targetFile)) {
        Files.copy(sourcePath, outputStream);
    }
    
} catch (IOException e) {
    // Handle exception
}
```

### Moving Files
```java
try {
    // Simple move/rename
    Path moved = Files.move(sourcePath, targetPath);
    
    // Move with options
    Files.move(sourcePath, targetPath,
               StandardCopyOption.REPLACE_EXISTING,
               StandardCopyOption.ATOMIC_MOVE);
    
} catch (IOException e) {
    // Handle exception
}
```

### Copy Options
```java
// Standard copy options
StandardCopyOption.REPLACE_EXISTING   // Replace target if exists
StandardCopyOption.COPY_ATTRIBUTES    // Copy file attributes
StandardCopyOption.ATOMIC_MOVE        // Move atomically (for move operations)

// Link options
LinkOption.NOFOLLOW_LINKS            // Don't follow symbolic links
```

## Directory Operations

### Listing Directory Contents
```java
try {
    // List immediate children
    try (Stream<Path> paths = Files.list(directoryPath)) {
        paths.filter(Files::isRegularFile)
             .forEach(System.out::println);
    }
    
    // Walk directory tree
    try (Stream<Path> paths = Files.walk(directoryPath)) {
        paths.filter(Files::isRegularFile)
             .filter(path -> path.toString().endsWith(".txt"))
             .forEach(System.out::println);
    }
    
    // Walk with max depth
    try (Stream<Path> paths = Files.walk(directoryPath, 2)) {
        // Only go 2 levels deep
        paths.forEach(System.out::println);
    }
    
    // Walk with visit options
    try (Stream<Path> paths = Files.walk(directoryPath, FileVisitOption.FOLLOW_LINKS)) {
        paths.forEach(System.out::println);
    }
    
} catch (IOException e) {
    // Handle exception
}
```

### Finding Files
```java
try {
    // Find files matching a pattern
    try (Stream<Path> paths = Files.find(startPath, Integer.MAX_VALUE,
            (path, attrs) -> path.toString().endsWith(".java"))) {
        paths.forEach(System.out::println);
    }
    
    // Find with BiPredicate
    try (Stream<Path> paths = Files.find(startPath, 3,
            (path, attrs) -> attrs.isRegularFile() && attrs.size() > 1024)) {
        paths.forEach(System.out::println);
    }
    
} catch (IOException e) {
    // Handle exception
}
```

### Directory Tree Walking with FileVisitor
```java
try {
    Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println("File: " + file);
            return FileVisitResult.CONTINUE;
        }
        
        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            System.err.println("Failed to visit: " + file + " (" + exc.getMessage() + ")");
            return FileVisitResult.CONTINUE;
        }
        
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            System.out.println("Entering directory: " + dir);
            return FileVisitResult.CONTINUE;
        }
        
        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            System.out.println("Leaving directory: " + dir);
            return FileVisitResult.CONTINUE;
        }
    });
} catch (IOException e) {
    // Handle exception
}
```

## Symbolic Links

### Creating and Managing Symbolic Links
```java
try {
    // Create symbolic link
    Path link = Files.createSymbolicLink(linkPath, targetPath);
    
    // Read symbolic link target
    Path target = Files.readSymbolicLink(linkPath);
    
    // Check if path is symbolic link
    boolean isSymLink = Files.isSymbolicLink(path);
    
} catch (IOException e) {
    // Handle exception
} catch (UnsupportedOperationException e) {
    // File system doesn't support symbolic links
}
```

## File Comparison

### Comparing Files
```java
try {
    // Compare file content (reads entire files)
    boolean identical = Files.isSameFile(path1, path2);
    
    // Check if paths refer to same file (may be different paths to same file)
    boolean sameFile = Files.isSameFile(path1, path2);
    
    // Mismatch comparison (finds first differing byte)
    long mismatchPosition = Files.mismatch(path1, path2);
    // Returns -1 if files are identical, otherwise position of first difference
    
} catch (IOException e) {
    // Handle exception
}
```

## File Store Information

### Getting File Store Information
```java
try {
    FileStore store = Files.getFileStore(path);
    
    System.out.println("File store: " + store.name());
    System.out.println("Type: " + store.type());
    System.out.println("Total space: " + store.getTotalSpace());
    System.out.println("Usable space: " + store.getUsableSpace());
    System.out.println("Unallocated space: " + store.getUnallocatedSpace());
    System.out.println("Read-only: " + store.isReadOnly());
    
    // Check supported file attribute views
    boolean supportsPosix = store.supportsFileAttributeView(PosixFileAttributeView.class);
    boolean supportsDos = store.supportsFileAttributeView(DosFileAttributeView.class);
    
} catch (IOException e) {
    // Handle exception
}
```

## Error Handling and Exception Types

The Files class throws various specific exceptions:

```java
try {
    // Various file operations
    Files.readAllLines(path);
} catch (NoSuchFileException e) {
    // File doesn't exist
    System.err.println("File not found: " + e.getFile());
} catch (AccessDeniedException e) {
    // Permission denied
    System.err.println("Access denied: " + e.getFile());
} catch (FileAlreadyExistsException e) {
    // File already exists (for create operations)
    System.err.println("File already exists: " + e.getFile());
} catch (DirectoryNotEmptyException e) {
    // Directory not empty (for delete operations)
    System.err.println("Directory not empty: " + e.getFile());
} catch (NotDirectoryException e) {
    // Expected directory but found file
    System.err.println("Not a directory: " + e.getFile());
} catch (FileSystemException e) {
    // Other file system related errors
    System.err.println("File system error: " + e.getMessage());
} catch (IOException e) {
    // General I/O error
    System.err.println("I/O error: " + e.getMessage());
}
```

## Best Practices and Performance Considerations

### Resource Management
```java
// Always use try-with-resources for streams and readers/writers
try (Stream<String> lines = Files.lines(path)) {
    return lines.collect(Collectors.toList());
} catch (IOException e) {
    // Handle exception
}

// For large files, prefer streaming over reading all at once
// Good for large files
try (Stream<String> lines = Files.lines(path)) {
    return lines.filter(line -> line.contains("pattern"))
                .findFirst();
}

// Avoid for large files
List<String> allLines = Files.readAllLines(path); // Loads entire file into memory
```

### Atomic Operations
```java
// For critical operations, use atomic moves when possible
Path tempFile = Files.createTempFile(targetPath.getParent(), "temp", ".tmp");
try {
    // Write to temporary file first
    Files.write(tempFile, data);
    
    // Atomic move to final location
    Files.move(tempFile, targetPath, StandardCopyOption.ATOMIC_MOVE);
} catch (IOException e) {
    // Clean up temp file if something goes wrong
    Files.deleteIfExists(tempFile);
    throw e;
}
```

### Efficient Directory Traversal
```java
// Use Files.walk() for simple traversals
try (Stream<Path> paths = Files.walk(startPath)) {
    long count = paths.filter(Files::isRegularFile).count();
}

// Use Files.walkFileTree() for complex logic or when you need control over traversal
Files.walkFileTree(startPath, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
    new SimpleFileVisitor<Path>() {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            // Custom processing
            return FileVisitResult.CONTINUE;
        }
    });
```

The `Files` class represents a comprehensive and modern approach to file I/O in Java, providing a rich set of operations while maintaining good performance characteristics and proper error handling. It's designed to work seamlessly with the `Path` interface and provides a much more intuitive and powerful API compared to the legacy `File` class.