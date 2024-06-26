//min heap insertion
//o(log(n))
//last meh insert kardo then parent dkehte raho jab tak bada heh swaping


public class a1_insertion_heap {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        int element = 0;

        System.out.println("Before insertion:");
        printArray(arr, n);

        arr = insertElement(arr, n, element);

        System.out.println("After insertion:");
        printArray(arr, n + 1);
    }

    public static int[] insertElement(int[] arr, int n, int element) {
        int[] newArr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            newArr[i] = arr[i];
        }

        newArr[n] = element;

        
        int i = n;
        while (i > 0 && newArr[parent(i)] > newArr[i]) {
            swap(newArr, i, parent(i));
            i = parent(i);
        }

        return newArr;
    }

    public static int parent(int i) {
        return (i - 1) / 2;
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

