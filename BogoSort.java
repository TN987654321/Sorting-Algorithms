import java.util.Random;

public class BogoSort 
{

    public static void main(String[] args) {

        int[] arr = {
            143, -927, 512, -341, 889, -78, 604, -661, 92, -503,
            -118, 735, -244, 991, 367, -820, 451, -159, -906, 284,
            -377, 660, -55, 843, -728, 129, -402, 577, -314, 956,
            -687, 205, -972, 41, -268, 806, -111, 390, -884, 674,
            52, -597, 487, -213, 753, -39, 615, -481, 173, -832,
            -260, 900, -745, 122, -566, 934, -342, 310, -955, 708,
            -23, 571, -499, 269, -644, 847, -313, 94, -708, 682,
            -126, 403, -961, 588, -300, 27, -736, 764, -192, 640,
            -867, 320, -134, 852, -455, 501, -785, 233, -62, 719,
            -473, 388, -551, 944, -387, 266, -910, 179, -704, 531
        };

        infiniteBogoSort(arr);
    }

    public static void infiniteBogoSort(int[] array) {
        Random rand = new Random();

        while (true) {
            shuffle(array, rand);

            if (isSorted(array)) {
                System.out.println("Sorted!");
                break;
            }
        }
    }

    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) return false;
        }
        return true;
    }

    private static void shuffle(int[] array, Random rand) {
        for (int i = 0; i < array.length; i++) {
            int j = rand.nextInt(array.length);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}