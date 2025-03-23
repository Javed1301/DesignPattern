Here’s a detailed and well-structured **`README.md`** for your project. 📚🚀

---

# 🎉 Decorator Pattern Implementation in Input/Output Streams

## 📚 Project Overview
This project demonstrates the use of the **Decorator Design Pattern** to enhance input and output streams dynamically. The system allows you to apply multiple decorators (like encryption, uppercase transformation, logging, compression, etc.) to different types of input sources such as:

- 📂 **File Input**  
- 📝 **String Input**  
- ⌨️ **Console Input**  

The objective is to showcase **dynamic behavior modification** of streams without altering their core logic.

---

## 🎯 Project Goal
The main objective of this project is to:
- Demonstrate how to extend functionality using the **Decorator Pattern**.
- Create flexible and easily maintainable code that follows key **SOLID** principles.
- Implement a system where different types of data streams can be dynamically enhanced with various functionalities (encryption, uppercase conversion, logging, compression, etc.).

---

## 🏗️ Design Principles Used
### ✅ 1. **Single Responsibility Principle (SRP)**
- Each class has a single responsibility.
    - `EncryptionDecorator` → Handles encryption.
    - `UppercaseDecorator` → Converts text to uppercase.
    - `CompressionDecorator` → Compresses input.
    - `LoggingDecorator` → Adds logging capabilities.

### ✅ 2. **Open/Closed Principle (OCP)**
- The system is **open for extension but closed for modification**.
    - Adding new decorators or features only requires creating a new class without modifying the existing code.

### ✅ 3. **Liskov Substitution Principle (LSP)**
- All decorator classes can be used interchangeably with the base `InputStreamComponent` class.

### ✅ 4. **Interface Segregation Principle (ISP)**
- Each class implements only what is necessary to modify the behavior of streams.

### ✅ 5. **Dependency Inversion Principle (DIP)**
- High-level modules (`StreamController`) depend on abstractions (`InputStreamComponent`), not concrete classes.

---

## 🔥 Decorator Pattern in Action
### 🎭 Core Components
1. **`InputStreamComponent` (Abstract Class)**
   - Defines the basic interface for reading data and acts as the base component.

2. **Concrete Stream Implementations:**
   - `FileInputStreamComponent` – Reads data from a file.
   - `StringInputStream` – Reads data from a string.
   - `ConsoleInputStream` – Reads data from console input.

3. **Decorator Base Class:**
   - `DataStreamDecorator` – Abstract decorator class that wraps around `InputStreamComponent`.

4. **Concrete Decorators:**
   - `EncryptionDecorator` – Encrypts the input.
   - `UppercaseDecorator` – Converts the input to uppercase.
   - `CompressionDecorator` – Simulates data compression.
   - `LoggingDecorator` – Logs each byte read from the stream.

---

## 📄 File Structure
```
/streams
├── ConsoleInputStream.java
├── DataStreamDecorator.java
├── EncryptionDecorator.java
├── FileInputStreamComponent.java
├── InputStreamComponent.java
├── LoggingDecorator.java
├── StringInputStream.java
├── UppercaseDecorator.java
├── CompressionDecorator.java
└── StreamController.java
MainApp.java
README.md
test.txt
```

---

## 📝 Explanation of Each Segment

### 1. **`InputStreamComponent.java`**
- Abstract base class defining core methods:
  - `read()` – Reads a single byte.
  - `close()` – Closes the stream.

---

### 2. **Concrete Stream Classes**
- **`FileInputStreamComponent.java`**
    - Reads data from a file using `FileInputStream`.
    
- **`StringInputStream.java`**
    - Reads data from a string using `ByteArrayInputStream`.

- **`ConsoleInputStream.java`**
    - Reads user input from the console.

---

### 3. **`DataStreamDecorator.java`**
- Abstract class extending `InputStreamComponent`.
- Wraps an `InputStreamComponent` to add additional functionality dynamically.

---

### 4. **Concrete Decorators**
- **`EncryptionDecorator.java`**
    - Encrypts the data using a simple XOR encryption.
    
- **`UppercaseDecorator.java`**
    - Converts the data to uppercase.
    
- **`CompressionDecorator.java`**
    - Simulates data compression.

- **`LoggingDecorator.java`**
    - Logs the data while reading.

---

### 5. **`StreamController.java`**
- Main controller that:
    - Reads from file, string, and console.
    - Applies decorators dynamically based on user choice.
    - Manages stream closing and cleanup.

---

### 6. **`MainApp.java`**
- Main entry point for the application.
- Executes all the processes:
    - Reads from file, string, and console.
    - Applies decorators dynamically using a switch-case.

---

## 🔄 Flow of Code
1. **User Input:**
   - Choose an input source (file, string, or console).
   - Select one or more decorators dynamically.

2. **Stream Initialization:**
   - Create a base stream based on user input.
   - Apply selected decorators.

3. **Stream Processing:**
   - Read and process data from the decorated stream.
   - Close the stream gracefully.

4. **Stream Closing:**
   - Ensures the stream and the `Scanner` are closed properly.

---

## 📊 Usage Instructions
1. **Compile the Project:**
```bash
javac MainApp.java streams/*.java
```

2. **Run the Application:**
```bash
java MainApp
```

3. **Input Options:**
- File: Place a `test.txt` file in the root directory.
- String: Provide a sample string to process.
- Console: Enter input manually in the console.

---

## 🧠 Key Concepts Demonstrated
- **Decorator Pattern** – Extending functionality dynamically.
- **Loose Coupling** – Easy addition of new decorators without modifying the base code.
- **Clean Architecture** – Separation of concerns and easy-to-read modular code.
- **Multiple Input Handling** – Read from different sources (file, string, console).
- **Flexible Extension** – Add more decorators or input streams with minimal code changes.

---

## ⚡ Possible Enhancements
1. **Error Handling:**
   - Better handling for file not found or invalid input.
2. **Advanced Encryption:**
   - Implement stronger encryption algorithms.
3. **GUI Integration:**
   - Create a user-friendly GUI to interact with the system.

---

## 🤝 Contributing
Feel free to submit pull requests with improvements, suggestions, or bug fixes. Let's make this project even better!

---

## 📝 License
This project is licensed under the MIT License. Feel free to use, modify, and distribute it as needed.

---

Happy Coding! 🎉🚀

--- 

This should be an excellent and informative **`README.md`** for your project! Let me know if you'd like any modifications or additional sections! 😎💡