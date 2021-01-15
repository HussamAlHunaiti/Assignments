#include <iostream>

using namespace std;

void printArray(int arr[], int length)
{
    for (int i = 0; i < length; i++)
        cout << arr[i] << ", ";
}

void insertionSort(int myArray[], int length)
{
    for (int i = 0; i < length - 1; i++)
    {
        if (myArray[i] <= myArray[i + 1])
        {
            continue;
        }
        else if (i == 0)
        {
            myArray[i] = myArray[i] + myArray[i + 1];
            myArray[i + 1] = myArray[i] - myArray[i + 1];
            myArray[i] = myArray[i] - myArray[i + 1];
            continue;
        }

        for (int j = i + 1; j > 0; j--)
        {
            if (myArray[j] >= myArray[j - 1])
            {
                break;
            }
            myArray[j] = myArray[j] + myArray[j - 1];
            myArray[j - 1] = myArray[j] - myArray[j - 1];
            myArray[j] = myArray[j] - myArray[j - 1];
        }
    }
}

int main()
{
    int arr[] = {0, 5, 5, 6, 8, 1, 6, 3, 7, 3, 10};
    int length = 10;
    insertionSort(arr, length);
    printArray(arr, length);

    return 0;
}
