package sortAlgorithms;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 0, 5, 5, 6, 8, 1, 6, 3, 7, 3, 10 };
        selectionSort(arr);
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + ", ");
    }

    public static void selectionSort(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int minimumValue = arr[i];
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < minimumValue) {
                    minimumValue = arr[j];
                    index = j;
                }
            if (minimumValue != arr[i]) {
                arr[i] = arr[i] + minimumValue;
                arr[index] = arr[i] - arr[index];
                arr[i] = arr[i] - arr[index];
            }
        }
    }
}