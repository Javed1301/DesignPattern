# Starbuzz Coffee - Decorator Pattern

## **Design Principle: Favor Composition Over Inheritance**
### **What This Means**
Instead of using inheritance to add new functionality, we use **composition** (i.e., combining objects) to create flexible and reusable designs. This allows behavior to be **dynamically modified at runtime** rather than being fixed at compile time.

## **Overview of the Starbuzz Coffee Example**
Starbuzz Coffee needs a system to price beverages where customers can customize their drinks with various condiments (e.g., milk, soy, mocha, whip). Instead of creating a new subclass for every possible drink combination (which would result in class explosion), we use the **Decorator Pattern** to dynamically add features to objects.

## **How the Design Works**
### **1. Abstract Component - Beverage (Base Class)**
- `Beverage` is the **base class** (abstract class) for all drinks.
- It defines a `getDescription()` method and an abstract `cost()` method, which must be implemented by subclasses.

```java
public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
```

### **2. Concrete Components - Base Beverages**
These are specific types of beverages like **Espresso, HouseBlend, DarkRoast, and Decaf**, all extending `Beverage`.

```java
public class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    public double cost() {
        return 1.99;
    }
}
```

### **3. Abstract Decorator - CondimentDecorator**
- This class extends `Beverage` to maintain the same type.
- It requires subclasses to implement `getDescription()`.
- The `cost()` method is overridden by concrete decorators.

```java
public abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}
```

### **4. Concrete Decorators - Add-ons like Mocha, Soy, Whip, etc.**
Each condiment class **wraps a `Beverage` object** and enhances its behavior dynamically.

```java
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    public double cost() {
        return 0.20 + beverage.cost();
    }
}
```

### **5. Client Code - Making a Custom Coffee Order**
Using the **Decorator Pattern**, we can dynamically wrap objects:

```java
public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
}
```

### **Output Example:**
```
Espresso $1.99
Dark Roast, Mocha, Whip $1.49
```

## **How This Design Achieves the Goal**
### ✅ **Flexibility at Runtime**
New condiments can be added without modifying existing classes. Customers can mix and match add-ons dynamically.

### ✅ **Avoids Class Explosion**
Instead of making separate classes like `EspressoWithMochaAndWhip`, we can **wrap** objects with decorators dynamically.

### ✅ **Open/Closed Principle (OCP)**
New condiments can be added **without modifying existing code**, only by adding new decorator classes.

### ✅ **Single Responsibility Principle (SRP)**
Each class has a clear role: `Beverage` handles drinks, and `CondimentDecorator` handles add-ons.

## **Conclusion**
The **Decorator Pattern** used in the Starbuzz Coffee example allows for **dynamic behavior extension**, **reduces redundant code**, and makes the system **more maintainable and scalable**. Instead of using **inheritance**, which leads to rigid structures, we use **composition** to add functionality at runtime in a flexible and reusable way.

