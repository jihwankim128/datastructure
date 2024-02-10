#include <iostream>
#include "CircularLinkedList.h"

using namespace std;

int main() {
	CircularLinkedList<int> customList;
	
	cout << "===== push_back & travel =====\n";
	for (int i = 10; i <= 50; i += 10) {
		customList.push_back(i);
	}
	customList.travel();
	
	cout << "\n===== push_front & travel =====\n";
	for (int i = 1; i <= 5; i++) {
		customList.push_front(i);
	}
	customList.travel();
	
	cout << "\npop_front & pop_back & travel \n";
	customList.pop_front();
	customList.pop_back();
	customList.travel();
	
	return 0;
}
