# Assignment #2 — Factory Method & Abstract Factory
**Course:** Software Design Patterns  
**Topic:** Dota 2 Game Items & Equipment Sets  

---

## 1. Project Overview

This project demonstrates two creational design patterns (**Factory Method** and **Abstract Factory**) implemented in Java, based on a Dota 2 game domain.

- **Part A (Factory Method):** Implements a step-by-step creation mechanism for individual in-game items (`SunstrikeStaff` and `MightySword`).
- **Part B (Abstract Factory):** Extends the system to produce cohesive, themed equipment sets consisting of an **Item** and a **Courier** (`Light Set` vs `Shadow Set`).

---

## 2. Architecture & Design Patterns

### Part A: Factory Method
- **`Item` (Product):** Interface defining common item behavior (`castSpell()`, `castSound()`).
- **`SunstrikeStaff` / `MightySword` (Concrete Products):** Specific implementations of items.
- **`ItemFactory` (Creator):** Abstract class declaring the factory method `createItem()` and containing helper logic (`useItem()`).
- **`StaffFactory` / `SwordFactory` (Concrete Creators):** Overrides `createItem()` to instantiate specific items.

### Part B: Abstract Factory
- **`Item` & `Courier` (Abstract Products):** Interfaces for product types in the family.
- **`LightEquipmentFactory` / `ShadowEquipmentFactory` (Concrete Factories):** Ensures consistent sets of products (e.g., `LightStaff` + `LightCourier`).
- **`Hero` (Client):** Operates exclusively through `HeroEquipmentFactory`, `Item`, and `Courier` interfaces without direct `new` instantiations.

---

## 3. Clean Code Principles Applied

Below are the 5 Clean Code principles explicitly identified and justified in this repository:

### 1. Meaningful and Intention-Revealing Names
- **Justification:** Class and method names reflect domain concepts directly and adhere to standard Java naming conventions (`CamelCase` and `lowerCamelCase`).
- **Before:**
  ```java
  public interface item {
      void a();
  }
  ```

**After**
```java
public interface Item {
    void castSpell();
}
```
## 2. Dependency Inversion Principle (DIP)

**Justification**: High-level modules (the Hero client) do not depend on low-level concrete modules (ShadowBlade, LightCourier). Both depend on abstractions (HeroEquipmentFactory, Item, Courier).
Before
```Java
public class Hero {
    private LightStaff staff = new LightStaff();
}
```
After
```Java
public class Hero {
    private final Item item;
    private final Courier courier;

    public Hero(HeroEquipmentFactory factory) {
        this.item = factory.createItem();
        this.courier = factory.createCourier();
    }
}
```
## 3. Single Responsibility Principle (SRP) & Small Methods

**Justification**: Every class has a single responsibility. Factories only construct objects, products only execute item actions, and the client manages game interactions. Methods perform strictly one action.
```java
public class StaffFactory extends ItemFactory {
    @Override
    public Item createItem() {
        return new SunstrikeStaff(); // Method does exactly one thing
    }
}
```
## 4. Encapsulation & Avoiding Magic Strings
Justification: String messages and item behaviors are encapsulated within their respective domain objects instead of being hardcoded into the client or main execution methods.
before:
```java
if (type.equals("staff")) {
    System.out.println("Casting Sunstrike!");
}
```
after:
```java
// Behavior is encapsulated in the product class
public class SunstrikeStaff implements Item {
    @Override
    public void castSpell() {
        System.out.println("Casting Sunstrike from the sky!");
    }
}
```
## 5. Validated Construction / Explicit Contracts
Justification: The ItemFactory creator is explicitly declared abstract to prevent direct instantiation of incomplete factory objects, ensuring type safety and clear class hierarchies.
```java
public abstract class ItemFactory {
    public abstract Item createItem(); // Enforces implementation in subclasses
}
```
## How to run
Clone repository
```
git clone <your-repository-url>
```
Navigate to the project root and compile the source files:
```
javac -d bin src/*.java
```
Run the application
```
java -cp bin Main
```
