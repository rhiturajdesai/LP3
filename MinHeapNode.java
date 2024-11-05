import java.util.PriorityQueue;
import java.util.Scanner;

class MinHeapNode {
    char data;
    int freq;
    MinHeapNode left, right;

    MinHeapNode(char data, int freq) {
        this.data = data;
        this.freq = freq;
    }
}

public class HuffmanCoding {

    static class Compare implements java.util.Comparator<MinHeapNode> {
        public int compare(MinHeapNode left, MinHeapNode right) {
            return left.freq - right.freq;
        }
    }

    static void printCodes(MinHeapNode root, String str) {
        if (root == null) return;
        if (root.data != '$') System.out.println(root.data + ": " + str);
        printCodes(root.left, str + "0");
        printCodes(root.right, str + "1");
    }

    static void huffmanCodes(char[] data, int[] freq) {
        PriorityQueue<MinHeapNode> minHeap = new PriorityQueue<>(new Compare());
        for (int i = 0; i < data.length; i++) {
            minHeap.add(new MinHeapNode(data[i], freq[i]));
        }

        while (minHeap.size() > 1) {
            MinHeapNode left = minHeap.poll();
            MinHeapNode right = minHeap.poll();
            MinHeapNode top = new MinHeapNode('$', left.freq + right.freq);
            top.left = left;
            top.right = right;
            minHeap.add(top);
        }

        printCodes(minHeap.poll(), "");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of characters: ");
        int n = scanner.nextInt();
        char[] arr = new char[n];
        int[] freq = new int[n];

        System.out.print("Enter characters: ");
        for (int i = 0; i < n; i++) arr[i] = scanner.next().charAt(0);

        System.out.print("Enter frequencies: ");
        for (int i = 0; i < n; i++) freq[i] = scanner.nextInt();

        huffmanCodes(arr, freq);
        scanner.close();
    }
}
