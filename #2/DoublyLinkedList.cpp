#include <list>
#include <iostream> 
#include "DoublyLinkedList.h"

using namespace std;

int main() {
	DoublyLinkedList<int> customList;
	
	printf("push_back : 40, 50, 60\n");
	customList.push_back(40);
	customList.push_back(50);
	customList.push_back(60);
	
	printf("push_front : 30, 20, 10\n");
	customList.push_front(30);
	customList.push_front(20);
	customList.push_front(10);
	
	printf("pop_front\n");
	customList.pop_front();

	printf("pop_back\n\n");
	customList.pop_back();
	
	printf("begin() and rbegin() before reverse\n");
	printf("begin val : %d, rbegin val : %d\n", *(customList.begin()), *(customList.rbegin()));
	printf("front() and back() before reverse\n");
	printf("front : %d, back : %d\n", customList.front(), customList.back());
	
	printf("Forward Travel\n");
	for(auto it = customList.begin(); it != customList.end(); it++) {
		cout << *it << ' ';
	}
	cout << "\n\n";
	
	customList.reverse();
	
	printf("begin() and rbegin() after reverse\n");
	printf("begin val : %d, rbegin val : %d\n", *(customList.begin()), *(customList.rbegin()));
	printf("front() and back() before reverse\n");
	printf("front : %d, back : %d\n", customList.front(), customList.back());
	
	printf("Reversed Travel\n");
	for(auto it = customList.begin(); it != customList.end(); it++) {
		cout << *it << ' ';
	}
	cout << "\n\n";

	DoublyLinkedList<int>::iterator it = customList.begin();
	it++;
	printf("value of it : %d\n", *it);
	
	it = customList.erase(it);
	printf("value of it after erase : %d\n", *it);
	
	it = customList.erase(customList.begin());
	printf("value of it after erase front : %d\n", *it);
	
	it++;
	it = customList.erase(it);
	printf("value of it after erase back : %d\n", *it);
	
	printf("Travel after erase\n");
	for(auto it = customList.begin(); it != customList.end(); it++) {
		cout << *it << ' ';
	}
	cout << "\n\n";
	
	customList.insert(it, 20);
	printf("Travel after insert\n");
	for(auto it = customList.begin(); it != customList.end(); it++) {
		cout << *it << ' ';
	}
	cout << "\n\n";
	
	return 0;
}
