public class NumberOfOne {
    private static void numberOfOne(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1)
                count++;
            n = n >> 1;
        }
        System.out.printf("" + count);
    }

    public static void main(String[] args) {
        numberOfOne(8);
    }
}
