# Lab 1 — Short Answers
Jimmy Le-Nguyen

**1. What does javac do?**
javac is the Java compiler. It reads .java source files and translates them into .class files containing JVM bytecode. It checks syntax and types at compile time; it does not run the program.

**2. What is bytecode?**
Bytecode is the compiled, platform-neutral instruction format inside a .class file (opcodes like getstatic, ldc, invokevirtual, iadd). It is not machine code for a specific CPU. it is the instruction set the JVM reads and executes.

**3. Why is bytecode platform-independent?**
The same .class bytecode runs on any OS that has a compatible JVM, with no recompiling. Each OS has its own JVM, but they all read the identical bytecode. Compile once, run anywhere. The JVM adapts universal bytecode to the specific machine.

**4. What is the role of the JVM?**
The Java Virtual Machine loads .class files, verifies and links them, and executes the bytecode. It manages memory (stack, heap, metaspace) and garbage collection, and translates bytecode into actions on the OS/hardware at runtime. Running "java" starts a JVM.

**5. Where are objects stored?**
On the heap — a shared region for all objects created with new (e.g. new Employee(101, "Aman")). Objects live there until no longer referenced, then garbage collection reclaims them.

**6. Where are method calls / frames stored?**
On the stack. Each call pushes a frame holding its parameters, locals, and return address; the frame is popped when the method returns. Primitive locals live in the frame; object variables hold a stack reference pointing to the heap object.

**7. What happens when a class is loaded?**
A class loader finds the .class file, loads it, links it (verify, prepare static fields, resolve references), and initializes it (run static initializers). Core JDK classes load first via the bootstrap loader; app classes load later via the application loader. My "java -verbose:class Employee" run loaded 640 classes — over 400 JDK classes before Employee appeared at line 419 — showing the JVM loads a large web of classes to start even a tiny program.

## Heap flag note (Step 10 / Checkpoint C)
Observed from PrintFlagsFinal: InitialHeapSize, MaxHeapSize, and UseG1GC (G1 is the default garbage collector). Running MemoryDemo with -Xms64m -Xmx64m still succeeded at 100,000 objects; -Xmx caps the maximum heap and allocation beyond it fails fast (see Experiment C). Forward look: CRM services on the same JDK are still "bytecode + heap + threads" — same model, just more classes and objects under Spring Boot.
