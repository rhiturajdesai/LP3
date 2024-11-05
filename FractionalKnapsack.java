import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Item {
    int value, weight;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {


    public static Comparator<Item> comparator = (Item a, Item b) -> {
        double r1 = (double) a.value / a.weight;
        double r2 = (double) b.value / b.weight;
        return Double.compare(r2, r1);
    };

    public static double fractionalKnapsack(int W, ArrayList<Item> items) {
        Collections.sort(items, comparator);

        int currentWeight = 0;
        double finalValue = 0.0;

        for (Item item : items) {
            if (currentWeight + item.weight <= W) {

                currentWeight += item.weight;
                finalValue += item.value;
            } else {
                int remainingWeight = W - currentWeight;
                finalValue += item.value * ((double) remainingWeight / item.weight);
                break;
            }
        }

        return finalValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        ArrayList<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value and weight for item " + (i + 1) + ": ");
            int value = scanner.nextInt();
            int weight = scanner.nextInt();
            items.add(new Item(value, weight));
        }

        System.out.print("Enter the maximum capacity of the knapsack: ");
        int W = scanner.nextInt();

        double maxValue = fractionalKnapsack(W, items);
        System.out.println("Maximum value in Knapsack = " + maxValue);

        scanner.close();
    }
}
