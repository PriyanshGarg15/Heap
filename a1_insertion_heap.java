//we will run insertion for min heap insertion (suppose we will add 0 in heap of 1 2 3 4 5 6 7 8)
//o(log(n)) is tc to do insertion in heap
//last meh insert kardo then parent dkehte raho jab tak bada heh keep swapping swaping


public class a1_insertion_heap {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        int element = 0;

        System.out.println("Before insertion:");
        printArray(arr, n);

        int[] ans = insertElement(arr, n, element);

        System.out.println("After insertion:");
        printArray(ans, n + 1);
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

    public static void swap(int[] newarr, int i, int j) {
        int temp = newarr[i];
        newarr[i] = newarr[j];
        newarr[j] = temp;
    }

    public static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

