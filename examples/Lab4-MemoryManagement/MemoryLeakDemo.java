import java.util.ArrayList;
import java.util.List;

public class MemoryLeakDemo {

    static class Employee {
        private final int id;
        private final String name;
        private final byte[] profileData = new byte[256];

        Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            printUsage();
            return;
        }

        String mode = args[0].toLowerCase();
        switch (mode) {
            case "leak" -> demonstrateLeak();
            case "fix" -> demonstrateFix();
            default -> printUsage();
        }
    }

    private static void demonstrateLeak() {
        System.out.println("===== Memory Leak Demonstration =====");
        System.out.println("Adding employees to a static list that is never cleared...");
        MemoryMonitor.printMemoryReport("Before Allocation");

        List<Employee> employees = LEAK_HOLDER.employees;
        int targetCount = 1_000_000;
        int step = 100_000;

        for (int i = 1; i <= targetCount; i++) {
            employees.add(new Employee(i, "Employee-" + i));
            if (i % step == 0) {
                System.out.println();
                System.out.println("Added " + i + " employees");
                MemoryMonitor.printMemoryReport("After " + i + " Objects");
            }
        }

        System.out.println();
        System.out.println("Observation:");
        System.out.println("- Memory keeps increasing because objects remain reachable");
        System.out.println("- GC cannot collect objects that are still referenced");
        System.out.println("- The static list (" + employees.size() + " items) is never cleared");
    }

    private static void demonstrateFix() {
        System.out.println("===== Memory Leak Fix Demonstration =====");
        MemoryMonitor.printMemoryReport("Before Allocation");

        List<Employee> employees = new ArrayList<>();   // LOCAL, not static
        int count = 500_000;
        for (int i = 1; i <= count; i++) {
            employees.add(new Employee(i, "Employee-" + i));
        }
        System.out.println("Added " + employees.size() + " employees to a local list");
        MemoryMonitor.printMemoryReport("After Allocation");

        System.out.println();
        System.out.println("Clearing list to remove strong references...");
        employees.clear();   // drop references to every Employee
        employees = null;    // drop the list itself too

        System.out.println("Triggering Garbage Collection...");
        MemoryMonitor.triggerGarbageCollection();

        MemoryMonitor.printMemoryReport("After GC");

        System.out.println();
        System.out.println("Observation:");
        System.out.println("- Clearing the list removes references to the objects");
        System.out.println("- Objects become unreachable and GC-eligible");
        System.out.println("- Used memory drops after GC");
    }

    private static void printUsage() {
        System.out.println("Usage:");
        System.out.println("  java MemoryLeakDemo leak");
        System.out.println("  java MemoryLeakDemo fix");
    }

    private static class LeakHolder {
        private final List<Employee> employees = new ArrayList<>();
    }

    private static final LeakHolder LEAK_HOLDER = new LeakHolder();
}