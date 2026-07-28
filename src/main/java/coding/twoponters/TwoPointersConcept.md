Two Pointers

We have already seen a variation of the two pointers technique when we learned about the sliding window, which also involves two pointers.

The main idea is to have a L (left) pointer and a R pointer, both starting at some indices of the array. They don't always have to start at the beginning of the array, as is common in the sliding window technique. The L and R pointers can start at any index of the array.
Concept

We will start the L pointer at 00 and R pointer at arr.length - 1 and increment either the L, or decrement R or both depending on the conditions given in the problem. This repeats until the pointers meet each other.
