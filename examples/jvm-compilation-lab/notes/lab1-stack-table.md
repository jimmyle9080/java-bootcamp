# Calculator — Stack vs Heap Table

| Code element | Memory area |
| ------------ | ----------- |
| Locals x, y, sum in main | Stack (locals in main frame) |
| Parameters a, b and local result in add | Stack (add frame) |
| Method call add(x, y) | New stack frame pushed, then popped on return |
| Class metadata for Calculator | Metaspace |
| Temporary String for "Sum = " + sum | Heap (String / builder intermediates) |

## Call flow (main -> add -> return)
1. main frame holds x=10, y=20, sum.
2. Calling add(x,y) pushes a NEW add frame holding a=10, b=20, result.
3. add computes iadd -> result=30, then ireturn.
4. add frame is popped (discarded); 30 returns to main and lands in sum.
5. main prints "Sum = 30".
Each call gets its own short-lived frame holding its parameters/locals; the frame is destroyed when the method returns. Primitive ints stay in frames; the String concatenation creates objects on the heap.
