#include <iostream>
#include <string.h>
#include "SinglyLinkedList.h"

using namespace std;

int main() {
	cout << "======= My Custom Singly Linked List =======\n";
	
    SinglyLinkedList<string> customList;
	
	customList.insert("My");
	customList.insert("Custom");
	customList.insert("Singly");
	customList.insert("Linked");
	customList.insert("List");
	
    for (auto it = customList.begin(); it != customList.end(); ++it) {
        cout << *it << ' ';
    }
	cout << "\n";
	cout << "length of list before delete : " << customList.getSize() << '\n';
	
   	auto it = customList.find("Custom");
    if (it != customList.end()) {
    	cout << "delete : " << *it << '\n';
        customList.erase(*it);
    }

    for (auto it = customList.begin(); it != customList.end(); ++it) {
        cout << *it << ' ';
    }
    cout << '\n';
    
    cout << "customList's size = " << customList.getSize();

    return 0;
}

