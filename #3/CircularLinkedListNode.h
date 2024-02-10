#pragma once

template <typename T>
class Node {
public:
    Node(T data);
    
    T getData() const;
    Node* getNext() const;
    Node* getPrev() const;

    void setNext(Node* node);
    void setPrev(Node* node);

private:
    T data;
    Node* next;
    Node* prev;
};

template <typename T>
Node<T>::Node(T data) : data(data), next(nullptr), prev(nullptr) {}

template <typename T>
T Node<T>::getData() const {
    return data;
}

template <typename T>
Node<T>* Node<T>::getNext() const {
    return next;
}

template <typename T>
Node<T>* Node<T>::getPrev() const {
    return prev;
}

template <typename T>
void Node<T>::setNext(Node* node) {
    next = node;
}

template <typename T>
void Node<T>::setPrev(Node* node) {
    prev = node;
}

