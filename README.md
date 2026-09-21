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
