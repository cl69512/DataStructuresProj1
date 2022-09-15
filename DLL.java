/**
 * Implements a doubly linked list.
 */
public class DLL<E> {

    // Fields of the DLL class
    private Node<E> head;
    private Node<E> tail;
    private int counter;

    /**
     * Constructs a doubly linked list.
     */
    public <E>DLL() {
        head = null;
        tail = null;
        counter = 0;
    } // DLL

    /**
     * Implements a node for the linked list implementation.
     */
    static class Node<E> {
        // Fields of the node class
        private E element;
        private Node<E> prev;
        private Node<E> next;

        /**
        * Node constructor with all fields null.
        */
        public Node() {
            element = null;
            prev = null;
            next = null;
        } // Node

        /**
         * Node constructor with a specified element.
         * @param element element the node stores
         */
        public Node(E element) {
            this.element = element;
            prev = null;
            next = null;
        } // Node

        /**
         * Node constructor with a specified elemnt, prev, and next.
         * @param element element the node stores
         * @param prev previous node
         * @param next next node
         */
        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        } // Node

        /**
         * Gets the element of the referenced node.
         * @return element the node stores
         */
        public E getElement() {
            return element;
        } // getElement

        /**
         * Gets the previous node of the referenced node.
         * @return previous node
         */
        public Node<E> getPrev() {
            return prev;
        } // getPrev

        /**
         * Gets the next node of the referenced node.
         * @return next node
         */
        public Node<E> getNext() {
            return next;
        } // getNext

        /**
         * Sets the element of the referenced node.
         * @param element element the node stores
         */
        public void setElement(E element) {
            this.element = element;
        } // setElement

        /**
         * Sets the previous node of the referenced node.
         * @param prev previous node
         */
        public void setPrev(Node<E> prev) {
            this.prev = prev;
        } // setPrev

        /**
         * Sets the next node of the referenced node.
         * @param next next node
         */
        public void setNext(Node<E> next) {
            this.next = next;
        } // setNext
    } // Node


    /**
     * Runs the doubly linked list program by constructing one
     * and performing operations on it with the various methods.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        DLL<Integer> list = new DLL<Integer>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        DLL<Integer>.Node<Integer> node = new Node<Integer>(6);
        System.out.println(list.toString());
    } // main

    /**
     * Returns the number of elements in the list.
     * @return number of elements in list
     */
    public int size() {
        return counter;
    } // size

    /**
     * Adds the given element to the end of the list.
     * @param element item to be stored in the node
     */

    public void addLast(E element) {
        // Checks if list is empty and makes new node the head and tail
        if(this.size() == 0) {
            this.head = new Node<E>(element);
            this.tail = this.head;
        } else {
            // Makes new node and sets the tail to it
            Node<E> temp = new Node<E>(element);
            this.tail.setNext(temp);
            temp.setPrev(this.tail);
            this.tail = temp;
        } // if
        counter++;
    } // addLast

    /**
     * Creates and returns a string of each element in the list.
     * @return String of each element
     */
    public String toString() {
        if(this.size() == 0) {
            return "null";
        } // if
        String elements = new String("null <-- ");
        Node<E> temp = this.head;
        // Goes through each node and adds the element to the string
        while(temp != null) {
            elements = elements + temp.getElement();
            temp = temp.getNext();
            if(temp == null) {
                elements = elements + " --> null";
                break;
            } else {
                elements = elements + " <--> ";
            } // if
        } // while
        return elements;
    } // toString

    /**
     * Returns the element at the given index of the list.
     * @param index location of the element
     * @return element at given index
     */
    public E get(int index) {
        // Bound checking
        if (index > (this.size() - 1) || index < 0 || this.size() == 0) {
            return null;
        } // if
        // Loops through nodes until reaching index
        Node<E> temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        } // for
        return temp.getElement();
    } // get

    /**
     * Finds the element passed into it and returns reference to its node.
     * @param element element to find
     * @return Node containing element
     */
    public Node<E> find(E element) {
        if (this.size() == 0) {
            return null;
        } // if
        Node<E> temp = this.head;
        // Loops through each node and checks if its element is the element
        for (int i = 0; i < this.size(); i++) {
            if (temp.getElement() == element) {
                return temp;
            } else {
                temp = temp.getNext();
            } // if
        } // for
        return null;
    } // find

    /**
     * Replaces element at index with the given element and returns old element.
     * @param index location to replace element
     * @param element element to replace old one
     * @return replaced element
     */
    public E set(int index, E element) {
        // Bounds checking
        if (index > (this.size() - 1) || index < 0 || this.size() == 0) {
            return null;
        } // if
        Node<E> temp = this.head;
        // Loops through nodes until reaching index
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        } // for
        E oldElement = temp.getElement();
        temp.setElement(element);
        return oldElement;
    } // set
} // DLL
