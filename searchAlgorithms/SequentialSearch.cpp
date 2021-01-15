#include <iostream>

using namespace std;

bool sequentialSearch(int arr[], int length, int number)
{
    for (int i = 0; i < length; i++)
        if (arr[i] == number)
        {
            cout << "The number: " << number << " exist in index: " << i << " in the array.\n";
            return true;
        }
    return false;
}

int main()
{
    int arr[] = {2, 3, 5, 6, 4, 2, 31, 46, 684, 13, 3, 8, 47, 654, 987, 4, 32, 186, 34, 52};
    int length = 20;
    int number;
    cin >> number;

    if (sequentialSearch(arr, length, number))
    {
        cout << "Found.\n";
    }
    else
    {
        cout << "Not Found.";
    }

    return 0;
}
