public class MethodsDemo {

    // square — overloaded for four numeric types (same name, different parameter type)
    public static int square(int n) {
        return n * n;
    }
    public static long square(long n) {
        return n * n;
    }
    public static float square(float n) {
        return n * n;
    }
    public static double square(double n) {
        return n * n;
    }

    public static void main(String[] args) {
        System.out.println("square(4)    = " + square(4));      // int    -> int version
        System.out.println("square(4L)   = " + square(4L));     // long   -> long version
        System.out.println("square(2.5f) = " + square(2.5f));   // float  -> float version
        System.out.println("square(2.5)  = " + square(2.5));    // double -> double version
    }
}