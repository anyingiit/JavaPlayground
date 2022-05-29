package Random;

public class Random {
    public static int[] generateRandoms(int scope) {
        int[] result = new int[scope];
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(scope);
        }
        return result;
    }
}
