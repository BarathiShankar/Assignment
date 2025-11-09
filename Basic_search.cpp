//Program to create a - Binary search cum Linear searching Program using C++
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int ar[10];
void read() {
    cout << "Enter the array elements \n";
    for (int i = 0; i < 10; i++) {
        cout << "Element " << i + 1 << " : ";
        cin >> ar[i];
    }
}
void print(int arr[], int size) {
    cout << "Array elements: ";
    for (int i = 0; i < size; i++) {
        cout << arr[i] << "\t";
    }
    cout << endl;
}
void linearSearch() {
    read();
    int target;
    cout << "Enter element to search: ";
    cin >> target;
    bool found = false;
    int index = -1;
    for (int i = 0; i < 10; i++) {
        if (ar[i] == target) {
            found = true;
            index = i;
            break;
        }
    }
    if (found)
        cout << "Element found at position: " << index + 1 << endl;
    else
        cout << "Element not found in the array\n";
}
void binarySearch() {
    read();
  sort(ar, ar + 10);
    cout << "Sorted array for Binary Search:\n";
    print(ar, 10);
    int target;
    cout << "Enter element to search: ";
    cin >> target;
    int low = 0, high = 9, mid;
    bool found = false;
    int index = -1;
    while (low <= high) {
        mid = (low + high) / 2;
        if (ar[mid] == target) {
            found = true;
            index = mid;
            break;
        }
        else if (ar[mid] < target) {
            low = mid + 1;
        }
        else {
            high = mid - 1;
        }
    }
    if (found)
        cout << "Element found at position: " << index + 1 << " in sorted array\n";
    else
        cout << "Element not found in the array\n";
}
int main() {
    int o;
    while (true) {
        cout << "\n\nMain Menu -\n0. Exit Program\n1. Linear Search\n2. Binary Search\nEnter your choice : ";
        cin >> o;
        switch (o) {
            case 0:
                cout << "Program Terminated\n";
                return 0;
            case 1:
                linearSearch();
                break;
            case 2:
                binarySearch();
                break;
            default:
                cout << "Invalid entry, try again\n";
        }
    }
}
//COMPLETED
