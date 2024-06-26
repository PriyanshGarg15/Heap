// approach
/*
  replace first with last
  decrease size(i.e exclude last element)
  heapifydown th given array
 */

 //o(log(n))
public class a2_removing_root_from_heap {
    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 2, 5, 6, 7, 8, 4};
        int n = arr.length;
        System.out.println("Before removal:");
        printArray(arr, n);
        arr = removeMin(arr, n);
        System.out.println("After removal:");
        printArray(arr, n - 1);
    }

    public static int[] removeMin(int[] arr, int n) {
        if (n == 0) {
            throw new IllegalArgumentException("Heap is empty");
        }

        // Replace the root of the heap with the last element
        arr[0] = arr[n - 1];

        // Reduce the size of the heap by 1
        n--;

        // Heapify the root element to maintain the heap property
        heapify(arr, n, 0);

        // Return the array with the reduced size
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[i] = arr[i];
        }

        return newArr;
    }

    public static void heapify(int[] arr, int n, int i) {
        int smallest = i; // Initialize smallest as root
        int left = 2 * i + 1; // left child index
        int right = 2 * i + 2; // right child index

        // If left child is smaller than root
        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }

        // If right child is smaller than smallest so far
        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }

        // If smallest is not root
        if (smallest != i) {
            swap(arr, i, smallest);
            // Recursively heapify the affected sub-tree
            heapify(arr, n, smallest);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
