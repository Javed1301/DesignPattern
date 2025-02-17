### **Composite Pattern from "Gang of Four" (GoF) and Additional Example**
The **Composite Pattern**, as explained in the **Gang of Four (GoF) book**, allows treating **individual objects** and **groups of objects (composites)** in a **uniform way**. The pattern helps in building a tree structure where both **leaf and composite elements implement the same interface**.

#### **📌 Example from GoF: Graphics Objects (Shapes)**
In the **GoF book**, the Composite Pattern is demonstrated with **graphic objects (Shapes)** that can either be simple (like circles, rectangles) or complex (like a group of shapes).

---

### **1️⃣ GoF-Inspired Example in Java**
#### **Step 1: Define the Component Interface**
```java
interface Graphic {
    void draw(); // Common method for both simple and composite objects
}
```
✅ **Defines a uniform interface** for both individual objects (like `Circle`) and composite objects (like `Group`).  

---

#### **Step 2: Implement Leaf Nodes (Simple Objects)**
```java
class Circle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}
```
✅ **`Circle` and `Rectangle` are leaf nodes** since they **don't contain any child elements**.  
✅ They directly **implement the `draw()` method**.  

---

#### **Step 3: Implement Composite Nodes**
```java
import java.util.ArrayList;
import java.util.List;

class Group implements Graphic {
    private List<Graphic> children = new ArrayList<>();

    public void add(Graphic graphic) {
        children.add(graphic);
    }

    public void remove(Graphic graphic) {
        children.remove(graphic);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Group:");
        for (Graphic graphic : children) {
            graphic.draw(); // Calls draw() recursively on child objects
        }
    }
}
```
✅ The `Group` class **acts as a composite object** because it **contains multiple `Graphic` elements** (both `Circle`, `Rectangle`, and other `Group` objects).  
✅ The **`draw()` method calls `draw()` on all child elements recursively**, ensuring that the tree structure is handled automatically.  

---

#### **Step 4: Creating and Using the Composite Structure**
```java
public class CompositePatternExample {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Rectangle rectangle1 = new Rectangle();

        Group group1 = new Group();
        group1.add(circle1);
        group1.add(rectangle1);

        Circle circle2 = new Circle();
        Group group2 = new Group();
        group2.add(circle2);
        group2.add(group1); // Adding group1 inside group2

        System.out.println("Drawing entire structure:");
        group2.draw(); // This should recursively draw all elements
    }
}
```
✅ We first create **individual objects** (`circle1`, `rectangle1`).  
✅ We then **group them together** inside `group1`.  
✅ Another `group2` contains a `circle2` and `group1`.  
✅ Finally, calling `group2.draw()` **recursively prints all elements inside the hierarchy**.

---

### **📌 Another Real-World Example: Company Hierarchy**
In real-world applications, we often see **hierarchical structures** like a **company with employees and managers**.

#### **Step 1: Define the Common Interface**
```java
interface Employee {
    void showDetails();
}
```

---

#### **Step 2: Implement Leaf Nodes (Employees)**
```java
class Developer implements Employee {
    private String name;
    private String role;

    public Developer(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public void showDetails() {
        System.out.println(name + " is a " + role);
    }
}

class Designer implements Employee {
    private String name;
    private String specialty;

    public Designer(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    @Override
    public void showDetails() {
        System.out.println(name + " specializes in " + specialty);
    }
}
```
✅ `Developer` and `Designer` are leaf nodes because they **don’t manage other employees**.  

---

#### **Step 3: Implement the Composite Class (Manager)**
```java
import java.util.ArrayList;
import java.util.List;

class Manager implements Employee {
    private String name;
    private List<Employee> subordinates = new ArrayList<>();

    public Manager(String name) {
        this.name = name;
    }

    public void addEmployee(Employee e) {
        subordinates.add(e);
    }

    public void removeEmployee(Employee e) {
        subordinates.remove(e);
    }

    @Override
    public void showDetails() {
        System.out.println("Manager: " + name);
        for (Employee e : subordinates) {
            e.showDetails();
        }
    }
}
```
✅ **Managers can have multiple employees under them (both developers, designers, or even other managers).**  
✅ `showDetails()` calls `showDetails()` **recursively for each subordinate**.  

---

#### **Step 4: Creating and Using the Composite Structure**
```java
public class CompanyHierarchy {
    public static void main(String[] args) {
        Developer dev1 = new Developer("Alice", "Backend Developer");
        Developer dev2 = new Developer("Bob", "Frontend Developer");

        Designer des1 = new Designer("Charlie", "UI/UX Designer");

        Manager techLead = new Manager("David");
        techLead.addEmployee(dev1);
        techLead.addEmployee(dev2);

        Manager headOfDesign = new Manager("Eve");
        headOfDesign.addEmployee(des1);

        Manager ceo = new Manager("Frank");
        ceo.addEmployee(techLead);
        ceo.addEmployee(headOfDesign);

        System.out.println("Company Structure:");
        ceo.showDetails();
    }
}
```
✅ **`CEO` (Frank) is the root of the hierarchy**, who manages `techLead` and `headOfDesign`.  
✅ **Managers handle their own subordinates**, which could be other managers or employees.  
✅ **The structure is flexible and can grow dynamically**.

---

## **📌 Why Is the Composite Pattern Also Called a "Wrapper Function"?**
Yes, the Composite Pattern **can sometimes be referred to as a "wrapper function"**, because:

1. The **composite class (e.g., `Folder`, `Group`, `Manager`) wraps a list of elements**, allowing **the same method (`showDetails()`, `draw()`) to work on both individual and group elements**.
2. **Recursive Calls**: The pattern **recursively calls methods on all child elements**, similar to how wrapper functions call another function inside themselves.
3. **Abstraction**: The user **doesn’t need to know** whether they are dealing with a single element (`File`, `Developer`) or a group (`Folder`, `Manager`); the **composite object "wraps" the complexity**.

---

## **📌 When to Use the Composite Pattern?**
The **Composite Pattern** is useful when:

✔️ You need to represent **hierarchical structures** (e.g., file systems, organization charts, UI components).  
✔️ You want to **treat individual objects and groups of objects uniformly**.  
✔️ You want **recursive operations** (e.g., printing all elements in a tree).  
✔️ You need a **flexible and scalable** system where new elements can be added dynamically.

---

## **📌 Key Takeaways**
| Feature | Explanation |
|---------|------------|
| **Defines a common interface** | Allows treating both **individual objects and composite objects the same way**. |
| **Encapsulates hierarchy** | `Folders` can contain both **files and other folders**, creating a tree structure. |
| **Recursive Behavior** | Composite objects call their method on **all children recursively**. |
| **Flexibility** | Easily extendable to **add new types of elements**. |

---

## **Conclusion**
The **Composite Pattern** is one of the most powerful **structural patterns** for managing hierarchical structures in **file systems, UI elements, organization charts, and more**. It provides a **unified way to handle both individual elements and groups**, making the code more **scalable and maintainable**. 🚀