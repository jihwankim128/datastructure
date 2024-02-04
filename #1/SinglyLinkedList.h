#pragma once
#include "SinglyLinkedListNode.h"

template <typename T>
class SinglyLinkedList {
public:
    SinglyLinkedList();

    class iterator {
    public:
        iterator(Node<T>* node);

        T operator*() const;
        iterator& operator++();
        bool operator!=(const iterator& other) const;

    private:
        Node<T>* it;
    };

    iterator begin();
    iterator end();
    iterator find(const T& value);

    void insert(const T& value);
    void erase(const T& value);

    int getSize();

private:
    Node<T>* head;
    int size;
};

template <typename T>
SinglyLinkedList<T>::iterator::iterator(Node<T>* node) : it(node) {}

template <typename T>
T SinglyLinkedList<T>::iterator::operator*() const {
    return it->getData();
}

template <typename T>
typename SinglyLinkedList<T>::iterator& SinglyLinkedList<T>::iterator::operator++() {
    it = it->getNext();
    return *this;
}

template <typename T>
bool SinglyLinkedList<T>::iterator::operator!=(const iterator& other) const {
    return it != other.it;
}

template <typename T>
SinglyLinkedList<T>::SinglyLinkedList() : head(nullptr), size(0) {}

template <typename T>
typename SinglyLinkedList<T>::iterator SinglyLinkedList<T>::begin() {
    return iterator(head);
}

template <typename T>
typename SinglyLinkedList<T>::iterator SinglyLinkedList<T>::end() {
    return iterator(nullptr);
}

template <typename T>
typename SinglyLinkedList<T>::iterator SinglyLinkedList<T>::find(const T& value) {
    Node<T>* node = head;
    while (node != nullptr && node->getData() != value) {
        node = node->getNext();
    }
    return iterator(node);
}

template <typename T>
void SinglyLinkedList<T>::insert(const T& value) {
    Node<T>* newNode = new Node<T>(value);
    if (head == nullptr) {
        head = newNode;
    } else {
        Node<T>* node = head;
        while (node->getNext() != nullptr) {
            node = node->getNext();
        }
        node->setNext(newNode);
    }
    size++;
}

template <typename T>
void SinglyLinkedList<T>::erase(const T& value) {
    Node<T>* node = head;
    Node<T>* prev = nullptr;

    while (node != nullptr && node->getData() != value) {
        prev = node;
        node = node->getNext();
    }

    if (node != nullptr) {
        if (prev != nullptr) {
            prev->setNext(node->getNext());
        } else {
            head = node->getNext();
        }
        delete node;
        size--;
    }
}

template <typename T>
int SinglyLinkedList<T>::getSize() {
    return size;
}

