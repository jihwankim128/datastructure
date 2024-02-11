#include <iostream>
#include <list>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(NULL);
	
	// constructor
	list<int> emptyList1;					// {}
	list<int> l1(3, 10);					// {3, 3, 3}
	list<int> l2(l1.begin(), l1.end());		// {3, 3, 3}
	list<int> l3(l1);						// {3, 3, 3}
    int arr[3] = {1, 2, 3};					
    list<int> l4 (arr, arr + 3);			// {1, 2, 3}
    
    // operator=
    list<int> emptyList2 = list<int>();		// {}
    list<int> l5 = l4;						// {1, 2, 3}
    list<int> l6 = {1, 2, 3};				// {1, 2, 3}
    
    // Iterators
    for (list<int>::iterator it = l6.begin(); it != l6.end(); it++) {
		cout << *it << " ";
	}
	cout << "\n";
	
	
    for (list<int>::reverse_iterator it = l6.rbegin(); it != l6.rend(); it++) {
		cout << *it << " ";
	}
	cout << "\n\n";
	
	// Capacity
	cout << "emptyList1 is empty ? - " << (emptyList1.empty() ? "Yes\n" : "No\n"); 
	cout << "l6 is empty ? - " << (l6.empty() ? "Yes\n" : "No\n"); 
 	cout << "size of l6 : " << l6.size() << "\n\n";
 	
 	// Element access
 	cout << "l6's front : " << l6.front() << '\n';
 	cout << "l6's back : " << l6.back() << "\n\n";
 	
 	// Modifiers
 	cout << "Stack\n";
 	l6.push_back(10);						// {1, 2, 3, 10}				
 	l6.push_back(20);						// {1, 2, 3, 10, 20}
 	while (!l6.empty()) {
 		cout << l6.back() << " ";
 		l6.pop_back();
	}
	cout << "\n";
	
	cout << "Queue\n";
	l4.push_front(10);						// {10, 1, 2, 3}
	l4.push_front(20);						// {20, 10, 1, 2, 3}
	while (!l4.empty()) {
		cout << l4.front() << " ";
		l4.pop_front();
	}
	cout << "\n";
 	
	cout << "Insert\n"; 
 	l5.insert(l5.end(), 5);					// {1, 2, 3, 5}
 	l5.insert(l5.begin(), 42);				// {42, 1, 2, 3, 5}
 	auto it = l5.begin(); 					// {42(it), 1, 2, 3, 5}
	advance(it, 2);							// {42, 1, 2(it), 3, 5} 
 	l5.insert(it, 16);						// {42, 1, 16, 2(it), 3, 5}
	l5.insert(it, 3, 25);					// {42, 1, 16, 25, 25, 25, 2(it), 3, 5}
 	l5.insert(it, {3, 0});					// {42, 1, 16, 25, 25, 25, 3, 0, 2(it), 3, 5}
 	for (it = l5.begin(); it != l5.end(); it++) {
 		cout << *it << " ";
	}
	cout << "\n"; 
	
	cout << "Erase\n";
	auto it1 = l5.begin(); 					// {42(it1), 1, 16, 25, 25, 25, 3, 0, 2, 3, 5}
	auto it2 = l5.begin();					// {42(it1, it2), 1, 16, 25, 25, 25, 3, 0, 2, 3, 5}
	advance(it2, 4);						// {42(it1), 1, 16, 25, 25(it2), 25, 3, 0, 2, 3, 5}
	cout << "value of it1 before deletion : " << *it1 << ", ";
	it1 = l5.erase(it1);					// {1(it1), 16, 25, 25(it2), 25, 3, 0, 2, 3, 5}
	cout << "value of it1 after deletion : " << *it1 << "\n";
	cout << "value of it2 before deletion : " << *it2 << ", ";
	it2 = l5.erase(it2);					// {1(it1), 16, 25, 25(it2), 3, 0, 2, 3, 5}
	cout << "value of it2 after deletion : " << *it2 << "\n";
	auto it3 = l5.erase(it1, it2);						// {25(it1, it2), 3, 0, 2, 3, 5}
	cout << "delete from it1 to it2 : ";
	for (it = l5.begin(); it != l5.end(); it++) {
		cout << *it << ' ';
	}
	cout << "\n";
	cout << "it1 = " << *it1 << ", it2 = " << *it2 << ", it3 = " << *it3 <<"\n"; 
	cout << "↑↑↑↑↑↑↑ 오류 발견, 반환 값은 it2 \n\n";
	
	// Operations
	l5.sort(); 
	cout << "Sorted N log N\n";
	for (it = l5.begin(); it != l5.end(); it++) {
		cout << *it << " ";
	}
	cout << "\n";
	
	l5.reverse();
	cout << "Reverse\n";
	for (it = l5.begin(); it != l5.end(); it++) {
		cout << *it << " ";
	}
	cout << "\n";
	
	return 0;
}
