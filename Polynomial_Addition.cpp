// Programmed by R Barathi Shankar || 2024503063
// Program to perform polynomial addition using linked list
#include<iostream>
using namespace std;
struct polynode {
    float coef;
    int exp;
    polynode* next;
}; //declaring a linked list for polynomial terms
polynode* p1 = nullptr;
polynode* p2 = nullptr;
polynode* p3 = nullptr;
void read(polynode** p) {
    int n;
    cout << "Enter the number of terms in polynomial: ";
    cin >> n;

    polynode* cur = nullptr;
    for (int i = 0; i < n; i++) {
        polynode* newnode = new polynode;
        cout << "Enter coefficient: ";
        cin >> newnode->coef;
        cout << "Enter exponent: ";
        cin >> newnode->exp;
        newnode->next = nullptr;
        if (*p == nullptr) {
            *p = newnode;
            cur = newnode;
        } else {
            cur->next = newnode;
            cur = newnode;
        }
    }
}
void add() {
    polynode* cur1 = p1;
    polynode* cur2 = p2;
    polynode* cur = nullptr;
    while (cur1 != nullptr && cur2 != nullptr) {
        polynode* newnode = new polynode;
        newnode->next = nullptr;
        if (cur1->exp == cur2->exp) {
            newnode->exp = cur1->exp;
            newnode->coef = cur1->coef + cur2->coef;
            cur1 = cur1->next;
            cur2 = cur2->next;
        }
        else if (cur1->exp > cur2->exp) {
            newnode->exp = cur1->exp;
            newnode->coef = cur1->coef;
            cur1 = cur1->next;
        }
        else {
            newnode->exp = cur2->exp;
            newnode->coef = cur2->coef;
            cur2 = cur2->next;
        }
        if (p3 == nullptr) {
            p3 = newnode;
            cur = newnode;
        } else {
            cur->next = newnode;
            cur = newnode;
        }
    }
    while (cur1 != nullptr) {
        polynode* newnode = new polynode{cur1->coef, cur1->exp, nullptr};
        cur->next = newnode;
        cur = newnode;
        cur1 = cur1->next;
    }
    while (cur2 != nullptr) {
        polynode* newnode = new polynode{cur2->coef, cur2->exp, nullptr};
        cur->next = newnode;
        cur = newnode;
        cur2 = cur2->next;
    }
}
void print() {
    polynode* cur = p3;
    if (!cur) {
        cout << "Polynomial is empty\n";
        return;
    }
    while (cur != nullptr) {
        cout << cur->coef << "x^" << cur->exp;
        if (cur->next != nullptr) cout << " + ";
        cur = cur->next;
    }
    cout << endl;
}
int main() {
    int ck = 0;
    cout << "Program to add 2 polynomials using linked list\n";
    cout << "NOTE: Enter terms in decreasing order of exponents.\n\n";
    while(1)
    {
        p1 = p2 = p3 = nullptr;

        cout << "Enter data for polynomial 1 -\n";
        read(&p1);
        cout << "\nEnter data for polynomial 2 -\n";
        read(&p2);

        add();
        cout << "Resultant sum: ";
        print();

        cout << "\n\nEnter -\n'0' to Exit program\n'Other number' to Add another polynomial\nChoice: ";
        cin >> ck;
        if (ck == 0) {
            cout << "Program terminated\n";
            return 0;
        }
    }
}
//COMPLETED
