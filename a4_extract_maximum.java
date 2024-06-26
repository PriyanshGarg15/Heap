//max heap
//approach
/*max heap banyenge by adding element
 1st elem is max of heap 
 now swap it with last and apply heaify down
 */


public class a4_extract_maximum {

    private int[] heap;
    private int size;

    public a4_extract_maximum(int capacity) {
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

    public int extractMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && heap[parent] < heap[index]) {
            swap(parent, index);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
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
        a4_extract_maximum maxHeap = new a4_extract_maximum(10);
        maxHeap.insert(3);
        maxHeap.insert(2);
        maxHeap.insert(1);
        maxHeap.insert(7);
        maxHeap.insert(8);
        maxHeap.insert(4);
        maxHeap.insert(10);
        maxHeap.insert(16);
        maxHeap.insert(12);

        System.out.println("Max-Heap:");
        maxHeap.printHeap();

        System.out.println("Extracted Max: " + maxHeap.extractMax());
        System.out.println("Max-Heap after extraction:");
        maxHeap.printHeap();
    }
}
