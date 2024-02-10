#pragma once
#include "CircularLinkedListNode.h"
#include <iostream>

// Prototype
template <typename T>
class CircularLinkedList {
public:
    CircularLinkedList();

    void push_front(const T& value);
    void push_back(const T& value);
    void pop_front();
    void pop_back();
    void travel();

private:
    Node<T>* head;
    Node<T>* tail;
};

template <typename T>
CircularLinkedList<T>::CircularLinkedList() : head(nullptr), tail(nullptr) {}

template <typename T>
void CircularLinkedList<T>::push_front(const T& value) {
	Node<T>* newNode = new Node<T>(value);
	if (head == nullptr) {
		head = newNode;
		tail = newNode;
		head -> setNext(newNode);
		head -> setPrev(newNode);
		tail -> setNext(newNode);
		tail -> setPrev(newNode);
	} else {
		head -> setPrev(newNode);
		tail -> setNext(newNode);
		newNode -> setNext(head);
		newNode -> setPrev(tail);
		head = newNode;
	}
}

template <typename T>
void CircularLinkedList<T>::push_back(const T& value) {
	if (head == nullptr) {
		push_front(value);
	} else {
		Node<T>* newNode = new Node<T>(value);
		head -> setPrev(newNode);
		tail -> setNext(newNode);
		newNode -> setNext(head);
		newNode -> setPrev(tail);
		tail = newNode;
	}
}

template <typename T>
void CircularLinkedList<T>::pop_front() {
	if(head == tail) {
		delete head;
		delete tail;
		head == nullptr;
		tail == nullptr;
	} else {
		Node<T>* newHead = head -> getNext();
		tail -> setNext(newHead);
		newHead -> setPrev(newHead);
		delete head; 
		head = newHead;
	}
}

template <typename T>
void CircularLinkedList<T>::pop_back() {
	if(head == tail) {
		delete head;
		delete tail;
		head == nullptr;
		tail == nullptr;
	} else {
		Node<T>* newTail = tail -> getPrev();
		newTail -> setNext(head);
		head -> setPrev(newTail);
		delete tail; 
		tail = newTail;
	}
}

template <typename T>
void CircularLinkedList<T>::travel() {
	Node<T>* temp = head;
	do {
		std::cout << (temp -> getData()) << ' ';
		temp = temp -> getNext();
	}
	while (temp != head);
	std::cout << '\n';
}

