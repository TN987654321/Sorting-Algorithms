public class BubbleSort {

    // Method to perform Bubble Sort on an integer array
    public static void bubbleSort(int[] arr) {

        boolean swapped; // Flag to optimize the sort

        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false; // Reset swapped flag for each pass
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // Compare adjacent elements
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; // A swap occurred
                }
            }
            // If no two elements were swapped in the inner loop,
            // then the array is already sorted, so break
            if (!swapped) {
                break;
            }
        }
    }

    // Method to print the elements of an array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the Bubble Sort implementation
    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original Array:");
        printArray(data);

        bubbleSort(data);

        System.out.println("Bubble Sorted Array:");
        printArray(data);
    }
}