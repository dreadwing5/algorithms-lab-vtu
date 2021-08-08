import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class GKnapsack {

    private static void compute(double[] weights, double[] values, double capacity) {

        ItemValue[] iVal = new ItemValue[weights.length];

        double totalValue = 0; // Total value of selected items

        // Create object of ItemValue and push it to the iVal array
        for (int i = 0; i < values.length; i++) {
            iVal[i] = new ItemValue(weights[i], values[i]);
        }

        // Sort the iVal array in decreasing order based on their cost

        Arrays.sort(iVal, new Comparator<ItemValue>() {

            @Override
            public int compare(ItemValue o1, ItemValue o2) {
                return Double.compare(o2.cost, o1.cost);
            }

        });

        // Create an array to store the items that are included in the knapsack

        double[] itemSelected = new double[weights.length];
        Arrays.fill(itemSelected, 0);

        for (int i = 0; i < iVal.length; i++) {
            double currWeight = iVal[i].weight;
            double currValue = iVal[i].value;

            // Take the whole item if it is within the capacity
            if (capacity - currWeight >= 0) {
                capacity -= currWeight;
                itemSelected[i] = 1;
                totalValue += currValue;

                // If the capacity is not enough to take the whole item, then take the part of
                // it that first within the capacity

            } else {
                double part = capacity / currWeight;
                capacity = 0;
                itemSelected[i] = part;
                totalValue += part * currValue;
                break;
            }

        }

        // Print the result
        System.out.println("-----Result------");

        System.out.println(String.format("Net Profit : %.2f", totalValue));
        System.out.println("The objects picked up into knapsack are : ");
        for (double d : itemSelected) {
            System.out.printf("%.2f  ", d);

        }
        System.out.println();

    }

    static class ItemValue {
        double weight, value;
        double cost;

        public ItemValue(double weight, double value) {
            this.weight = weight;
            this.value = value;
            cost = value / weight;
        }

    }

    public static void main(String[] args) {
        int n;
        double capacity;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of items: ");
        n = input.nextInt();
        double[] values = new double[n];
        double[] weights = new double[n];

        System.out.println("Enter capacity of Knapsack : ");

        capacity = input.nextDouble();

        System.out.println("Enter the values of " + n + " items: ");

        for (int i = 0; i < n; i++) {
            values[i] = input.nextDouble();

        }

        System.out.println("Enter the weights of " + n + " items: ");
        for (int i = 0; i < n; i++) {
            weights[i] = input.nextDouble();
        }

        GKnapsack.compute(weights, values, capacity);

        input.close();
    }

}
