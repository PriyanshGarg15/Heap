public class a7_build_heap {

        public int[] heap;
        public int size;
    
        public a7_build_heap(int capacity) {
            heap = new int[capacity];
            size = 0;
        }
    
        public void heapifyDown(int index) {
            int smallest = index;
            int left = 2 * index + 1;
            int right = 2 * index + 2;
    
            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }
            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }
            if (smallest != index) {
                swap(index, smallest);
                heapifyDown(smallest);
            }
        }
    
        public void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    
       
        public void buildHeap(int[] arr) {
            if (arr.length > heap.length) {
                throw new IllegalArgumentException("Array size exceeds heap capacity");
            }
            size = arr.length;
            for (int i = 0; i < arr.length; i++) {
                heap[i] = arr[i];
            }
            for (int i = size / 2 - 1; i >= 0; i--) {
                heapifyDown(i);
            }
        }

        public void printHeap() {
            for (int i = 0; i < size; i++) {
                System.out.print(heap[i] + " ");
            }
            System.out.println();
        }
    
    
        public static void main(String[] args) {
            a7_build_heap minHeap = new a7_build_heap(10);
            int[] array = {3, 2, 1, 7, 8, 4, 10, 16, 12};
    
            System.out.println("Array:");
            for (int value : array) {
                System.out.print(value + " ");
            }
            System.out.println();
    
            minHeap.buildHeap(array);
    
            System.out.println("Min-Heap:");
            minHeap.printHeap();
        }
    }
    