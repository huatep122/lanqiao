package chap3;

import java.util.Arrays;
import java.util.Scanner;

public class topK {
    static int[] heap;
    static int k;
    static int index = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        k = scanner.nextInt();
        heap = new int[k];
        int x = scanner.nextInt();
        while (x != -1) {
            deal(x);
            x = scanner.nextInt();
        }
        System.out.println(Arrays.toString(heap));
    }

    private static void deal(int x) {
        if (index < k) {
            heap[index++] = x;
            if (index == k)
                heapify(heap);
        } else {
            if (x > heap[0]) {
                heap[0] = x;
                adjustHeap(heap, 0, k);
            }
            System.out.println(Arrays.toString(heap));
        }
    }

    private static void adjustHeap(int[] heap, int i, int k) {
        int j = 2 * i + 1;
        if (j <= k - 1) {
            if ((j + 1 <= k - 1) && (heap[j] > heap[j + 1])) j++;
            if (heap[j]<heap[i]){
                swap(heap,i,j);
                adjustHeap(heap,j,k);
            }
        }
    }
    private static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
    private static void heapify(int[] heap) {
        for (int i = (heap.length >> 1) - 1; i >= 0; i--) {
            adjustHeap(heap, i, k);
        }
    }
}
