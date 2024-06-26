public class a6_delete_key {

    private int[] heap;
    private int size;

    public a6_delete_key(int capacity) {
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

    public int extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return min;
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

    public void deleteKey(int index) {
        // Decrease the key to a very small value and then extract the minimum
        decreaseKey(index, Integer.MIN_VALUE);
        extractMin();
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && heap[parent] > heap[index]) {
            swap(parent, index);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
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
        a6_delete_key minHeap = new a6_delete_key(10);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(7);
        minHeap.insert(8);
        minHeap.insert(4);
        minHeap.insert(10);
        minHeap.insert(16);
        minHeap.insert(12);

        System.out.println("Min-Heap:");
        minHeap.printHeap();
        minHeap.deleteKey(3);
        System.out.println("Min-Heap after deleting key at index 3:");
        minHeap.printHeap();
    }
}
