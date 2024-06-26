//min heap
//approach
//agar kisi point ke value decreas ekar kar kam kaedi toh bas heapifyup lagega i.e parent seh dkehe te jao bas till top
public class a5_decrease_key {

    private int[] heap;
    private int size;

    public a5_decrease_key(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public void insert(int element) {
        if (size == heap.length) {
            throw new IllegalStateException("Heap is full");
        }
        heap[size] = element;
        size++;
        heapifyUp(size - 1);
    }


    public void decreaseKey(int index, int newValue) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of range");
        }
        if (newValue > heap[index]) {
            throw new IllegalArgumentException("New value is greater than the current value");
        }
        heap[index] = newValue;
        heapifyUp(index);
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && heap[parent] > heap[index]) {
            swap(parent, index);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        a5_decrease_key minHeap = new a5_decrease_key(10);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(15);
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(45);

        System.out.println("Min-Heap:");
        minHeap.printHeap();

        minHeap.decreaseKey(2, 1);
        System.out.println("Min-Heap after decreasing key at index 2 to 1:");
        minHeap.printHeap();
    }
}
