# Module 1 — Pre-Lab Exercise Notes
Jimmy Le-Nguyen · java-bootcamp

## Exercise 1 — Hello World
1. Code compiles and runs — Pass
2. Can explain the result — Pass
Note: javac compiled Hello.java into Hello.class (bytecode); java ran the class and printed "Hello, JVM!".

## Exercise 2 — Platform Independence (WORA)
1. Code compiles and runs — Pass
2. Can explain the result — Pass
Note: Ran the existing Hello.class with `java Hello` (no recompile). The JVM runs the bytecode, not the .java source. Any OS with a compatible JVM runs the same .class unchanged — Write Once, Run Anywhere.

## Exercise 3 — Control Flow
1. Code compiles and runs — Pass
2. Can explain the result — Pass
Note: if picked "even" (4 % 2 == 0), for counted 1–5, while counted down from 3, switch matched day 2 to "Tuesday".

## Exercise 4 — Watch Class Loading
1. Code compiles and runs — Pass
2. Can explain the result — Pass
Note: With -verbose:class, String and its related classes loaded from "shared objects file" (bootstrap loader) before my code ran; Hello loaded ~1s later from my own folder path (application loader).


## Exercise 5- Variable 
1. Code complies and runs - pass 
2. can explain the result - pass 
   3. Each variable holds a different type of data — whole numbers (int/long), a decimal (double), a true/false flag (boolean), a single character (char), and text (String) — and printing each shows its stored value.

## Exercise 6-Methods 
1. Code complies and runs - Pass
2. Can explain 
   3. main calls add(10, 20) which returns 30, and greet("Aman") which returns "Hello, Aman!" — each call gets its own stack frame that holds its parameters and is discarded once it returns its value.


## Exercise 7 — Objects and Classes
1. Code compiles and runs — Pass
2. Can explain the result — Pass
   Person = class/blueprint; new Person("Aman",21) built an object on the heap with its own name/age fields set by the constructor; person is a stack reference pointing to it; display() printed the object's data.
   EOF

## Exercise 8 — Inspect Bytecode
1. Code compiles and runs — Pass
2. Can explain the result — Pass
   Note: javap -c Person disassembled the class. Found in my output: new (line 0 of main = create Person object), ldc (line 4 = load "Aman"), invokevirtual (line 13 = call display()). Proves javac turns Java into JVM bytecode that java runs.
   EOF