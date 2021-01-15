#include <iostream>

using namespace std;

void printArray(int arr[], int length)
{
    for (int i = 0; i < length; i++)
        cout << arr[i] << ", ";
}

void bubbleSort(int arr[], int length)
{
    for (int j = 0; j < length; j++)
    {
        bool isChange = false;
        for (int i = length - 1; i > j; i--)
        {
            if (arr[i - 1] > arr[i])
            {
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

int main()
{
    int arr[] = {0, 5, 5, 6, 8, 1, 6, 3, 7, 3, 10};
    int length = 10;
    bubbleSort(arr, length);
    printArray(arr, length);

    return 0;
}
