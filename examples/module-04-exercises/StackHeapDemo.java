public class StackHeapDemo {
    static class Person {
        String name;
        Person(String name) {
            this.name = name;                 // reference field on the heap object
        }
    }

    static void printPerson(Person person) {
        int nameLength = person.name.length();                       // local primitive
        System.out.printf("%s has %d letters.%n", person.name, nameLength);
    }

    public static void main(String[] args) {
        int count = 1;                        // primitive in main's frame
        Person person = new Person("Aman");   // reference in main's frame → object on heap
        printPerson(person);
        System.out.println("Count: " + count);
    }
}