# **Pizza Store Factory - Design Patterns Explained**

## **📌 Overview**
This project demonstrates the **Factory Method Design Pattern** using a **Pizza Store** example, inspired by Chapter 4 of *Head First Design Patterns*. The goal is to create a flexible, scalable system for making different styles of pizzas while adhering to SOLID design principles.

## **🎯 Key Features**
- Implements the **Factory Method Pattern** to create pizzas dynamically.
- Uses **Encapsulation** to separate object creation from the client.
- Supports multiple **pizza types** and **regional styles (NY, Chicago)**.
- Provides a **structured workflow** for preparing and serving pizzas.

---

## **📂 Project Structure**
```
├── src/
│   ├── pizzas/
│   │   ├── Pizza.java
│   │   ├── NYStyleCheesePizza.java
│   │   ├── NYStylePepperoniPizza.java
│   │   ├── ChicagoStyleCheesePizza.java
│   │   ├── ChicagoStylePepperoniPizza.java
│   ├── stores/
│   │   ├── PizzaStore.java
│   │   ├── NYPizzaStore.java
│   │   ├── ChicagoPizzaStore.java
│   ├── PizzaTestDrive.java
│   ├── README.md
```

---

## **🛠️ Design Patterns Used**
### **1️⃣ Factory Method Pattern**  
✅ **Why?**
- Allows dynamic creation of different pizzas **without modifying client code**.
- Decouples **object creation** from the main program.
- Provides an **interface for creating objects** in a superclass but lets subclasses decide which class to instantiate.

✅ **Where?**
- `PizzaStore` defines an **abstract** `createPizza()` method.
- `NYPizzaStore` and `ChicagoPizzaStore` **override** this method to return region-specific pizzas.

---

### **2️⃣ Encapsulation & Abstraction**
✅ **Why?**
- Hides the **complexity of pizza creation** from the client.
- Ensures each pizza type follows the **same preparation process**.

✅ **Where?**
- `PizzaStore.orderPizza()` manages the steps (`prepare()`, `bake()`, `cut()`, `box()`), ensuring uniformity.
- `Pizza` defines a **base class**, allowing for consistent structure.

---

### **3️⃣ Open-Closed Principle (OCP)**  
✅ **Why?**
- New **pizza types** or **new regional stores** can be added **without modifying existing code**.

✅ **Where?**
- `PizzaStore.createPizza()` is **open for extension** (new pizza styles) but **closed for modification**.

---

## **📜 Classes & Their Responsibilities**
### **1️⃣ `Pizza (Abstract Class)`**
- Defines common properties (`name`, `dough`, `sauce`, `toppings`).
- Implements general methods (`prepare()`, `bake()`, `cut()`, `box()`).
- Allows **subclasses to specify variations**.

### **2️⃣ `NYStyleCheesePizza`, `ChicagoStyleCheesePizza`, etc.**
- Extend `Pizza` to define specific **NY and Chicago-style pizzas**.
- Override `cut()` method in **Chicago-style pizzas** (cut into squares).

### **3️⃣ `PizzaStore (Abstract Factory)`**
- Defines `orderPizza()`, which ensures **consistent steps** for making any pizza.
- Declares `createPizza()` **(to be implemented by subclasses)**.

### **4️⃣ `NYPizzaStore`, `ChicagoPizzaStore` (Concrete Factories)**
- Implement `createPizza()` to **return region-specific pizzas**.

### **5️⃣ `PizzaTestDrive (Client Code)`**
- Simulates ordering pizzas from **both NY and Chicago stores**.

---

## **🚀 How to Run**
1. Compile all Java files:
   ```sh
   javac src/**/*.java
   ```
2. Run the test drive:
   ```sh
   java src.PizzaTestDrive
   ```
3. Expected output:
   ```
   Preparing NY Style Sauce and Cheese Pizza
   Baking NY Style Sauce and Cheese Pizza
   Cutting NY Style Sauce and Cheese Pizza
   Boxing NY Style Sauce and Cheese Pizza
   Ethan ordered a NY Style Sauce and Cheese Pizza

   Preparing Chicago Style Deep Dish Cheese Pizza
   Baking Chicago Style Deep Dish Cheese Pizza
   Cutting the pizza into square slices
   Boxing Chicago Style Deep Dish Cheese Pizza
   Joel ordered a Chicago Style Deep Dish Cheese Pizza
   ```

---

## **✨ Conclusion**
- The **Factory Method Pattern** allows **flexibility & scalability** in pizza creation.
- New **pizza types** or **regional stores** can be added **without modifying existing logic**.
- Encapsulation ensures a **consistent workflow** across different pizzas.
- The design follows the **Open-Closed Principle (OCP)**, making it **easily extendable**.

This project provides a **real-world example** of how factory patterns work in software development. 🍕🚀

