import java.util.PriorityQueue;

public class a9_kth_largest_in_array_leetcode_215 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int kthLargest = findKthLargest(arr, k);
        System.out.println(k + "th largest element is " + kthLargest);
    }

    public static int findKthLargest(int[] nums, int k) {
        // Create a min heap using a PriorityQueue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // Add the first k elements to the min heap
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        // Process the remaining elements
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll(); // Remove the smallest element
                minHeap.add(nums[i]); // Add the current element
            }
        }

        // The root of the min heap is the k-th largest element
        return minHeap.peek();
    }
}
