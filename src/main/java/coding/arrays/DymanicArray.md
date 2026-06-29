# Design Dynamic Array (Resizable Array)

Design a Dynamic Array (aka a resizable array) class, such as an `ArrayList` in Java or a `vector` in C++.

### Operations

Your `DynamicArray` class should support the following operations:

- `DynamicArray(int capacity)` — initialize an empty array with a capacity of `capacity` (where `capacity > 0`).
- `int get(int i)` — return the element at index `i`. Assume that index `i` is valid.
- `void set(int i, int n)` — set the element at index `i` to `n`. Assume that index `i` is valid.
- `void pushback(int n)` — append the element `n` to the end of the array. If the array is full, call `resize()` first.
- `int popback()` — pop and return the element at the end of the array. Assume that the array is non-empty.
- `void resize()` — double the capacity of the array.
- `int getSize()` — return the number of elements in the array.
- `int getCapacity()` — return the current capacity of the array.

### Constraints & Assumptions

- The index `i` provided to `get(int i)` and `set(int i)` is guaranteed to be in the range `0 <= i < size()`.

### Example

#### Example 1
**Input:**
```json
["Array", 1, "getSize", "getCapacity"]
```
