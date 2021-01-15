#include <iostream>

using namespace std;

void printArray(int arr[], int length)
{
    for (int i = 0; i < length; i++)
        cout << arr[i] << ", ";
}

void selectionSort(int arr[], int length)
{
    int index = 0;
    for (int i = 0; i < length - 1; i++)
    {
        int minimumValue = arr[i];
        for (int j = i + 1; j < length; j++)
            if (arr[j] < minimumValue)
            {
                minimumValue = arr[j];
                index = j;
            }
        if (minimumValue != arr[i])
        {
            arr[i] = arr[i] + minimumValue;
            arr[index] = arr[i] - arr[index];
            arr[i] = arr[i] - arr[index];
        }
    }
}

int main()
{
    int arr[] = {0, 5, 5, 6, 8, 1, 6, 3, 7, 3, 10};
    int length = 10;
    selectionSort(arr, length);
    printArray(arr, length);

    return 0;
}
