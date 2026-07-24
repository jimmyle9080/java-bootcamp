import java.lang.ref.WeakReference;

public class WeakReferenceDemo {

    public static void main(String[] args) {
        System.out.println("===== Weak Reference Demonstration =====");

        System.out.println("--- Strong Reference ---");
        Person strongPerson = new Person("Strong User", 40);
        System.out.println("Before GC : " + strongPerson);
        MemoryMonitor.triggerGarbageCollection();
        System.out.println("After GC  : " + strongPerson);
        System.out.println("Object remains because a strong reference still exists.");

        System.out.println();
        System.out.println("--- Weak Reference ---");
        Person weakTarget = new Person("Weak User", 35);
        WeakReference<Person> weakReference = new WeakReference<>(weakTarget);
        System.out.println("Before removing strong reference : " + weakReference.get());

        weakTarget = null;   // only a WEAK reference remains now
        System.out.println("Strong reference removed.");
        MemoryMonitor.triggerGarbageCollection();

        Person afterGc = weakReference.get();
        System.out.println("After GC via WeakReference.get() : " + afterGc);   // often null

        System.out.println();
        System.out.println("Observation:");
        System.out.println("- WeakReference does NOT stop the GC from collecting the object");
        System.out.println("- Once only weak refs remain, the object becomes GC-eligible");
        System.out.println("- get() returns null after collection (System.gc() is a hint, so it may vary)");
    }
}