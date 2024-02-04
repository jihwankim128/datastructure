#pragma once

template <typename T>
class Node {
public:
    Node(T data);
    
    T getData() const;
    Node* getNext() const;

    template <typename U>
    friend class SinglyLinkedList;

    void setNext(Node* node);

private:
    T data;
    Node* next;
};

// Node Ŭ���� ���ø��� ����
template <typename T>
Node<T>::Node(T data) : data(data), next(nullptr) {}

template <typename T>
T Node<T>::getData() const {
    return data;
}

template <typename T>
Node<T>* Node<T>::getNext() const {
    return next;
}

template <typename T>
void Node<T>::setNext(Node* node) {
    next = node;
}

