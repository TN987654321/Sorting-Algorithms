import java.util.Random;

public class HybridSorter
{

    /**
     * Sorts the given array using a O(n2) implementation of Insertion Sort.
     * @param array The array to be sorted.
     */
    public static void insertionSort(int[] array) 
    {
        int n = array.length;

        if(array == null || n <= 1)
        {
            return;
        }

        for(int i = 1; i < n; i++)
        {
            int key = array[i];
            int j = i - 1;

            while(j >= 0 && array[j] > key)
            {
                array[j+1] = array[j];
                j = j - 1;
            }
            array[j+1] = key;
        }
    }

    /**
     * Sorts the given array using a O(n log n) recursive implementation of Merge Sort.
     * @param array The array to be sorted.
     */
    public static void mergeSort(int[] array) 
    {
        int n = array.length;

        if(array == null || n <= 1)
        {
            return;
        }
        else
        {
            int mid = n/2;
            int[] left = new int[mid];
            int[] right = new int[n-mid];

            for(int i =0; i < mid; i++)
            {
                left[i] = array[i];
            }

            for(int i = mid; i < n; i++)
            {
                right[i-mid] = array[i];
            }

            mergeSort(left); mergeSort(right);

            merge(array,left,right);
        }
    }

    public static void merge(int[] array, int[] left, int[] right)
    {
        int i = 0, j = 0, k = 0;
        int leftSize = left.length;
        int rightSize = right.length;

        while(i < leftSize && j < rightSize)
        {
            if(left[i] <= right[j])
            {
                array[k] = left[i];
                i = i + 1;
            }
            else
            {
                array[k] = right[j];
                j = j + 1;
            }
            k = k + 1;
        }

        while(i < leftSize)
        {
            array[k] = left[i];
            i = i + 1;
            k = k + 1;
        }

        while(j < rightSize)
        {
            array[k] = right[j];
            j = j + 1;
            k = k + 1;
        }
    }

    /**
     * Sorts the given array using a O(n log n) recursive implementation of Merge Sort, 
     * but uses Insertion Sort for sub-arrays smaller than the given threshold.
     * @param array The array to be sorted.
     * @param threshold The sub-array size at which to switch to Insertion Sort.
     */
    public static void hybridSort(int[] array, int threshold) 
    {
        int n = array.length;

        if(array == null || n <= 1)
        {
            return;
        }
        else if(n < threshold)
        {
            insertionSort(array);
        }
        else
        {
            int mid = n / 2;
            int[] left = new int[mid];
            int[] right = new int[n-mid];

            for(int i =0; i < mid; i++)
            {
                left[i] = array[i];
            }

            for(int i = mid; i < n; i++)
            {
                right[i-mid] = array[i];
            }

            hybridSort(left,threshold); hybridSort(right,threshold);

            merge(array, left, right);
        }
    }

    /**
     * Runs an experimental analysis.
     */
    public static void main(String[] args) {
        int size = 50000;
        int trials = 15;
        Random rand = new Random();
        int[] masterArray = new int[size];
        for (int i = 0; i < size; i++) masterArray[i] = rand.nextInt(100000);

        System.out.println("Threshold | Avg Time (ms)");
        System.out.println("-------------------------");

        for (int t = 0; t <= 100; t += 10) {
            long startTime = System.nanoTime();
            for (int i = 0; i < trials; i++) {
                int[] copy = masterArray.clone();
                hybridSort(copy, t);
            }
            long endTime = System.nanoTime();
            double avgTime = ((endTime - startTime) / (double) trials) / 1_000_000.0;
            System.out.printf("%9d | %12.3f\n", t, avgTime);
        }
    }

}
