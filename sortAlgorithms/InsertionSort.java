package sortAlgorithms;

public class InsertionSort {
	public static void main(String[] args) {
		int myArray[] = { 25, 35, 5, 7, 71, 3, 32, 56, 12, 65, 35, 78, 32, 45, 987 };

		for (int i = 0; i < myArray.length - 1; i++) {
			if (myArray[i] <= myArray[i + 1]) {
				continue;
			} else if (i == 0) {
				myArray[i] = myArray[i] + myArray[i + 1];
				myArray[i + 1] = myArray[i] - myArray[i + 1];
				myArray[i] = myArray[i] - myArray[i + 1];
				continue;
			}

			for (int j = i + 1; j > 0; j--) {
				if (myArray[j] >= myArray[j - 1]) {
					break;
				}
				myArray[j] = myArray[j] + myArray[j - 1];
				myArray[j - 1] = myArray[j] - myArray[j - 1];
				myArray[j] = myArray[j] - myArray[j - 1];
			}
		}

		for (int num : myArray) {
			System.out.print(num + ", ");
		}
	}
}