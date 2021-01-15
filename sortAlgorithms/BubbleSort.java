package sortAlgorithms;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 0, 5, 5, 6, 8, 1, 6, 3, 7, 3, 10 };
        bubbleSort(arr);
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + ", ");
    }

    public static void bubbleSort(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            boolean isChange = false;
            for (int i = arr.length - 1; i > j; i--) {
                if (arr[i - 1] > arr[i]) {
                    arr[i] = arr[i] + arr[i - 1];
                    arr[i - 1] = arr[i] - arr[i - 1];
                    arr[i] = arr[i] - arr[i - 1];
                    isChange = true;
                }
            }

            if (!isChange)
                break;
        }
    }
}
