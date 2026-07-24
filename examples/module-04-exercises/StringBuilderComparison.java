public class StringBuilderComparison {
    private static final int ITERATIONS = 50_000;

    static String withString() {
        String result = "";
        for (int i = 0; i < ITERATIONS; i++) {
            result += "x";
        }
        return result;
    }

    static String withBuilder() {
        // Initial capacity avoids repeated buffer growth.
        StringBuilder result = new StringBuilder(ITERATIONS);
        for (int i = 0; i < ITERATIONS; i++) {
            result.append('x');
        }
        return result.toString();
    }

    public static void main(String[] args) {
        long startString = System.nanoTime();
        String strResult = withString();
        long endString = System.nanoTime();
        double stringMs = (endString - startString) / 1_000_000.0;

        long startBuilder = System.nanoTime();
        String builderResult = withBuilder();
        long endBuilder = System.nanoTime();
        double builderMs = (endBuilder - startBuilder) / 1_000_000.0;

        System.out.printf("String: %d chars, %.3f ms%n", strResult.length(), stringMs);
        System.out.printf("StringBuilder: %d chars, %.3f ms%n", builderResult.length(), builderMs);
    }
}