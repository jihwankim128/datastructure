#pragma once
#include "DoublyLinkedListNode.h"

// Prototype
template <typename T>
class DoublyLinkedList {
public:
    DoublyLinkedList();

	// 반복자 
    class iterator {
    public:
        iterator(Node<T>* node, bool& isReverse);

        T operator*() const;
        iterator& operator++(int);
        iterator& operator--(int);
        bool operator!=(const iterator& other) const;

    private:
        Node<T>* it;
        bool isReverse;
        
        Node<T>* getNode();
        friend class DoublyLinkedList<T>;
    };
    
    // Function
	iterator begin();
    iterator end();
	iterator rbegin();
	iterator rend();
	iterator erase(iterator it);

    void push_front(const T& value);
    void push_back(const T& value);
    void pop_front();
    void pop_back();
    void insert(iterator it, const T& value);
    void reverse();
    
    T front() const;
    T back() const;

    int getSize() const;

private:
    Node<T>* head;
    Node<T>* tail;
    int size;
    bool isReverse;
    //void insert_reverse(iterator it, const T& value);
};

/*
	반복자 명세
	생성자부터 기능까지 
*/
template <typename T>
DoublyLinkedList<T>::iterator::iterator(Node<T>* node, bool& isReverse) : it(node), isReverse(isReverse) {}

template <typename T>
T DoublyLinkedList<T>::iterator::operator*() const {
	if(it != nullptr) return it->getData();
}

template <typename T>
typename DoublyLinkedList<T>::iterator& DoublyLinkedList<T>::iterator::operator++(int) {
    if(isReverse) {
		it = it -> getPrev();
	} else {
		it = it->getNext();	
	}
    return *this;
}

template <typename T>
typename DoublyLinkedList<T>::iterator& DoublyLinkedList<T>::iterator::operator--(int) {
    if(isReverse) {
		it = it -> getNext();
	} else {
		it = it-> getPrev();	
	}
    return *this;
}

template <typename T>
bool DoublyLinkedList<T>::iterator::operator!=(const iterator& other) const {
    return it != other.it;
}

template <typename T>
Node<T>* DoublyLinkedList<T>::iterator::getNode() {
	return it;
}

// doubly linked list method
template <typename T>
DoublyLinkedList<T>::DoublyLinkedList() : head(nullptr), tail(nullptr), size(0), isReverse(false) {}


template <typename T>
typename DoublyLinkedList<T>::iterator DoublyLinkedList<T>::begin() {
	if (isReverse) {
		return iterator(tail, this -> isReverse);
	}	
	return iterator(head, this -> isReverse);
	
}

template <typename T>
typename DoublyLinkedList<T>::iterator DoublyLinkedList<T>::rbegin() {
	if (isReverse) {
		return iterator(head, this -> isReverse);
	}	
	return iterator(tail, this -> isReverse);
}

template <typename T>
typename DoublyLinkedList<T>::iterator DoublyLinkedList<T>::end() {
	return iterator(nullptr, this -> isReverse);
}

template <typename T>
typename DoublyLinkedList<T>::iterator DoublyLinkedList<T>::rend() {
	return iterator(nullptr, this -> isReverse);
}

template <typename T>
void DoublyLinkedList<T>::push_front(const T& value) {
	Node<T>* newNode = new Node<T>(value);
	if (head == nullptr) {
		head = newNode;
		tail = newNode;
	} else {
		head -> setPrev(newNode);
		newNode -> setNext(head);
		head = newNode;
	}
	size++;
}

template <typename T>
void DoublyLinkedList<T>::push_back(const T& value) {
	Node<T>* newNode = new Node<T>(value);
	if (head == nullptr) {
		head = newNode;
		tail = newNode;
	} else {
		tail -> setNext(newNode);
		newNode -> setPrev(tail);
		tail = newNode;
	}
	size++;
}

template <typename T>
void DoublyLinkedList<T>::insert(iterator it, const T& value) {
	Node<T> *node = it.getNode();	
	if (node == nullptr) {
		push_back(value);
		return;	
	} 
	
	Node<T> *prev = node -> getPrev();
	if (prev == nullptr) {
		push_front(value);
		return;
	}
	
	Node<T> *newNode = new Node<T>(value);
	
	newNode -> setNext(node);
	node -> setPrev(newNode);
	newNode -> setPrev(prev);
	prev -> setNext(newNode);
	
	size++;
}

// std::list 에서도 size가 0일 경우, error 조치를 하지 않음. 
template <typename T>
void DoublyLinkedList<T>::pop_front() {
	Node<T>* temp = head -> getNext();
	delete head;
	head = temp;
	head -> setPrev(nullptr);
	
	size--;
}

template <typename T>
void DoublyLinkedList<T>::pop_back() {
	Node<T>* temp = tail -> getPrev();
	delete tail;
	tail = temp;
	tail -> setNext(nullptr);
	
	size--;
}

// erase도 마찬가지 size에 대한 고려는 없음. 
template <typename T>
typename DoublyLinkedList<T>::iterator DoublyLinkedList<T>::erase(iterator it) {
	Node<T>* node = it.getNode();
	Node<T>* prev = node -> getPrev();
	Node<T>* next = node -> getNext();
	
	if (prev != nullptr) {
        prev->setNext(next);
    } else {
        head = next;
    }
    
    if (next != nullptr) {
        next->setPrev(prev);
    } else {
        tail = prev;
    }
    
	delete node;
	size--;
	
	if(isReverse) {
		return iterator(prev, isReverse);
	}
	return iterator(next, isReverse);
}

template <typename T>
void DoublyLinkedList<T>::reverse() {
	this -> isReverse = isReverse ? false : true;
}

template <typename T>
T DoublyLinkedList<T>::front() const{
	if (isReverse) {
		return (tail->getData());
	}
	return (head->getData());
}

template <typename T>
T DoublyLinkedList<T>::back() const{
	if (isReverse) {
		return (head->getData());
	}
	return (tail->getData());
}

template <typename T>
int DoublyLinkedList<T>::getSize() const {
	return size;
}
