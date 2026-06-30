### Varargs

(short for variable-length arguments) is a programming feature that allows a function
or method to accept an arbitrary number of arguments. Instead of forcing a developer to pack arguments into an array
manually, or writing endless method overloads for different parameter counts, the syntax lets you pass comma-separated
values directly.

#### Java

"..." (varargs) means, how it behaves at runtime, and important caveats.
In Java a parameter declared with ... (e.g. int... nums) is varargs — syntactic sugar for an array parameter. Inside the
method it is an array (int[] nums). It is not a Collection.

How it works (examples)
Declaration:

```java
void foo(int... nums) { /* nums is int[] inside */ }
```

Calls allowed:

```java
foo(1,2,3); // callers pass a sequence of values

foo(); // empty — inside method nums.length == 0

foo(new int[] {
    1, 2
}); // you can pass an array explicitly
```

Inside the method:

```java
nums is
an int[];
// you can iterate
for(
int n :nums){...}
```

You can treat it like any array: nums.length, nums[0], etc.

### Python

Python handles dynamic arguments using the *args syntax for positional arguments and **kwargs for keyword arguments.
Elements are packed into a tuple.pythondef sum_numbers(*args):

```python
return sum(args) # 'args' is treated as a tuple
print(sum_numbers(5, 10, 15)) # Output: 30
```

### unmodifiable, immutable, and mutable In Java

unmodifiable, immutable, and mutable are related, but not the same.

1) Mutable list
   A mutable list can be changed after creation:
    1. add
    2. remove
    3. set/replace elements
2) Unmodifiable list
   is a list that cannot be modified after creation. You can create an unmodifiable list using
   `Collections.unmodifiableList()` or `List.of()` in Java. However, if the underlying list is modified, the
   unmodifiable view will reflect those changes.
    1. add() fails
    2. remove() fails
    3. set() fails
3) Immutable list cannot change at all. Its contents never change.

**Important difference**
* Unmodifiable means: you cannot modify it through this list object.
* Immutable means: the object itself never changes.