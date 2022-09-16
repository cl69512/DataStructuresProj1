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
    public <T>DLL() {
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
        DLL<Integer> list = new DLL<>();
        list.insert(0, 1);
        list.insert(1, 2);
        list.insert(0, 0);
        list.addLast(3);
        System.out.println(list.toString());
        System.out.println(list.clone().toString());
        System.out.println(list.deepClone().toString());
    } // main

    /**
     * Returns the number of elements in the list.
     * @return number of elements in list
     */
    public int size() {
        return this.counter;
    } // size

    /**
     * Returns true if there are not any elements in the list.
     * @return true is empty, false is not
     */
    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        } else {
            return false;
        }
    } // isEmpty

    /**
     * Returns (but does not remove) the first element of the list.
     * @return first element of list
     */
    public E first() {
        Node<E> elementToReturn = this.head;
        if (elementToReturn == null) {
            return null;
        } else {
            return elementToReturn.getElement();
        } // if
    } // first

    /**
     * Returns (but does not remove) the last element of the list
     * @return last element of list
     */
    public E last() {
        Node<E> lastElement = this.tail;
        if (lastElement == null) {
            return null;
        } else {
            return lastElement.getElement();
        } // if
    } // last

    /**
     * Removes and rerurns the first element in the list.
     * @return removed element
     *
     */
    public E removeFirst() {
        Node<E> temp = new Node<>();
        if (this.head != null) {
            temp = this.head;
            if (this.head.getNext() == null) {
                this.head = null;
            } else {
                this.head = head.getNext();
                this.head.setPrev(null);
            } // if
        } else {
            return null;
        } // if
        this.counter--;
        return temp.getElement();
    } // removeFirst

    /**
     * Removes and rerurns the last element in the list.
     * @return removed element
     *
     */
    public E removeLast() {
        Node<E> temp = new Node<>();
        if (this.head != null) {
            temp = this.tail;
            if (this.head.getNext() == null) {
                this.head = null;
            } else {
                // traverse to the second last element of list
                this.tail = this.tail.getPrev();
                this.tail.setNext(null);
            } // if
        } else {
            return null;
        } // if
        this.counter--;
        return temp.getElement();
    } // removeLast

     /**
     * Adds the given element to the end of the list.
     * @param element item to be stored in the node
     */
    public void addLast(E element) {
        // Checks if list is empty and makes new node the head and tail
        if(this.size() == 0) {
            this.head = new Node<>(element);
            this.tail = this.head;
        } else {
            // Makes new node and sets the tail to it
            Node<E> temp = new Node<>(element);
            this.tail.setNext(temp);
            temp.setPrev(this.tail);
            this.tail = temp;
        } // if
        this.counter++;
    } // addLast

    /**
     * Adds the elemented inputted to the beginning of the list.
     * @param element item to be stored
     */
    public void addFirst(E element) {
        // Checks if list is empty and makes new node the head and tail
        if(this.size() == 0) {
            this.head = new Node<>(element);
            this.tail = this.head;
        } else {
            Node<E> temp = new Node<>(element);
            temp.setNext(head);
            temp.setPrev(null);
            if (head != null) {
                head.setPrev(temp);
            }
            head = temp;
        } // if
        this.counter++;
    } // addFirst


    /**
     * Creates and returns a string of each element in the list.
     * @return String of each element
     */
    public String toString() {
        if(this.size() == 0) {
            return "null";
        } // if
        String elements = "null <-- ";
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


    /**
    * Removes an element at the specified position from the list.
    * @param index location of the element to remove
    * @return the element that was removed
    */
    public E remove(int index) {
        // removing first node
        if(index == 0 && this.size() == 1) {
            E deletedElement = this.head.getElement();
            this.clear();
            return deletedElement;
        } // if
        if (index == 0) {
            E deletedElement = this.head.getElement();
            this.head.getNext().setPrev(null);
            this.head = this.head.getNext();
            this.counter--;
            return deletedElement;
        } // if
        // removing last node
        if(index == (this.size() - 1)) {
            E deletedElement = this.tail.getElement();
            this.tail.getPrev().setNext(null);
            this.counter--;
            return deletedElement;
        }
        // Finds the node to remove
        if (this.size() != 0 && this.size() > index) {
            Node<E> temp = this.head;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            } // for
            // Removes the element
            E deletedElement = temp.getElement();
            temp.getNext().setPrev(temp.getPrev());
            temp.getPrev().setNext(temp.getNext());
            if (index == 0) {
                this.head.getNext().setPrev(null);
                this.head = temp.getNext();
            } // if
            // decrease the size by 1
            this.counter--;
            return temp.getElement();
        } // if
        else {
            return null;
        } // else
    } // remove

    /**
    * inserts the element at a specific position
    * @param index location to insert the element
    * @param element element to insert
    * @return the element
    */
    public void insert(int index, E element) {
        // return if null
        if((this.size() + 1) < index) {
            return;
        } // if
        if (element == null) {
            return;
        } // if
        Node<E> temp = this.head;
        if(this.size() == index) {
            this.addLast(element);
            return;
        } // if
        if(index == 0) {
            this.addFirst(element);
            return;
        } // if
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        } // for
        Node<E> insertNode = new Node<>(element, temp.getPrev(), temp);
        temp.getPrev().setNext(insertNode);
        temp.setPrev(insertNode);
        if (index == 0) {
            this.head = insertNode;
        } // if
        this.counter++;
    } // insert

    /**
    * The remove method removes the specified node from the list.
    * @param x node to remove
    */
    public void remove (Node<E> x) {
        //if the x or the head is null, return
        if (this.head == null || x == null) {
            return;
        } // if

        // if it is the only node
        if (this.size() == 1) {
            this.clear();
            return;
        } // if

        //if x is the head node
        if (this.head.equals(x)) {
            this.head = x.getNext();
            x.getNext().setPrev(null);
            this.counter--;
            return;
        } // if
        // if x is the tail node
        if (this.tail.equals(x)) {
            this.tail = x.getPrev();
            x.getPrev().setNext(null);
            this.counter--;
            return;
        } // if

        // next changes if the node that's deleted isn't the last node
        if ( x.getNext() != null ) {
            x.getPrev().setNext(x.getNext());
        } // if

        // prev changes if the node that's deleted isn't the first node
        if ( x.getPrev() != null ) {
            x.getNext().setPrev(x.getPrev());
        } // if
        this.counter--;
        return;
    } // remove

    /**
    * Removes all elements from the list
    */
    public void clear() {
        if(this.size() == 0) {
            return;
        } // if
        this.head.setNext(null);
        this.tail.setPrev(null);
        this.head = null;
        this.tail = this.head;
        this.counter = 0;
    } // void

    /**
    * Creates a new sequence of nodes whose values are equal to the
    * objects in the original list.
    * @return deep clone of the list
    */
    public DLL<E> deepClone() {
        DLL<E> copyList = new DLL<E>();
        // if no elements in list
        if(this.size() == 0) {
            return copyList;
        } // if

        // Setting up variables for list
        Node<E> temp = this.head;
        Node<E> newHead = null;
        Node<E> newTail = null;
        copyList.counter = 0;

        while(temp != null) {
            // For first node
            if (temp.getPrev() == null) {
                newHead = new Node<>(temp.getElement());
                newTail = newHead;
                copyList.counter++;
            } else {
                newTail.setNext(new Node<E>(temp.getElement(), newTail, null));
                newTail = newTail.getNext();
                copyList.counter++;
            } // if
            temp = temp.getNext();
        } // while
        // Declaring the head and tail
        copyList.head = newHead;
        copyList.tail = newTail;
        return copyList;
    } // deepClone

    /**
     * Switches the positions of two nodes in the list.
     * @param x first node
     * @param y second node
     */
    public void swap(Node<E> x, Node<E> y) {
        Node<E> xPrevNode = x.getPrev();
        Node<E> xNextNode = x.getNext();
        Node<E> yPrevNode = y.getPrev();
        Node<E> yNextNode = y.getNext();

        // Swapping head and tail
        if(x.equals(this.head) && y.equals(this.tail)) {
            x.setPrev(yPrevNode);
            x.setNext(null);
            y.setPrev(null);
            y.setNext(xNextNode);
            xNextNode.setPrev(y);
            yPrevNode.setNext(x);
            this.head = y;
            this.tail = x;
            return;
        } // if

        // Assigns head and tail if needed
        if(this.head.equals(x)) {
            this.head = y;
        } // if
        if(this.tail.equals(y)) {
            this.tail = x;
        }
        // Checks if x and y are next to each other
        if(yPrevNode.equals(x)) {
            if(yNextNode != null) {
                yNextNode.setPrev(x);
            } // if
            if(xPrevNode != null) {
                y.setPrev(xPrevNode);
            } else {
                y.setPrev(null);
            } // if
            y.setNext(x);
            if(yNextNode != null) {
                x.setNext(yNextNode);
            } else {
                x.setNext(null);
            } // if
            x.setPrev(y);
            if(xPrevNode != null) {
                xPrevNode.setNext(y);
            } // if
        } else {
            x.setPrev(yPrevNode);
            if (yNextNode != null) {
                x.setNext(yNextNode);
            } else {
                x.setNext(null);
            } // if
            if (xPrevNode != null) {
                y.setPrev(xPrevNode);
            } else {
                y.setPrev(null);
            } // if
            y.setNext(xNextNode);
            if (xPrevNode != null) {
                xPrevNode.setNext(y);
            } // if
            yPrevNode.setNext(x);
            xNextNode.setPrev(y);
            if (yNextNode != null) {
                yNextNode.setPrev(x);
            } // if
        } // if
    } // swap

    /**
    * Returns a shallow copy of the DLL.
    * @return shallow copy of the list
    */
    public DLL<E> clone() {
	    DLL<E> copyList = new DLL<E>();
	    copyList = this;
	    copyList.head = this.head;
	    copyList.tail = this.tail;
	    copyList.counter = this.counter;
        return copyList;
	} // clone


} // DLL
