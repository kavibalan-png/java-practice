public class HighestAltitude {
    public static void main(String[] args) {
        int[] gain = {-5, 1, 5, 0, -7};

        int altitude = 0;
        int max = 0;

        for (int g : gain) {
            altitude += g;
            if (altitude > max)
                max = altitude;
        }

        System.out.println(max);
    }
}