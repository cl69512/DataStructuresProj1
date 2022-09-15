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
        list.addLast(1);
        list.removeLast();
        System.out.println(list.toString());
    } // main

    /**
     * Returns the number of elements in the list.
     * @return number of elements in list
     */
    public int size() {
        return counter;
    } // size

    public boolean isEmpty() {
        if (this.size() == 0) {
            System.out.println("List is empty.");
            return true;
        } else {
            System.out.println("List is not empty.");
            return false;
        }
    } // isEmpty

    /**
     * Returns (but does not remove) the first element of the list.
     * @return
     */
    public E first() {
        Node<E> elementToReturn = this.head;
        if (elementToReturn == null) {
            System.out.println("The list is empty and does not contain any elements.");
            return null;
        } else {
            System.out.println("The first element in the list is " + elementToReturn.getElement() + ".");
            return elementToReturn.getElement();
        }
    } // first

    /**
     * Returns (but does not remove) the last element of the list
     * @return
     */
    public E last() {
        Node<E> lastElement = this.tail;
        if (lastElement == null) {
            System.out.println("The list is empty and does not contain any elements.");
            return null;
        } else {
            System.out.println("The last element in the list is " + lastElement.getElement() + ".");
            return lastElement.getElement();
        }
    } // last

    /**
     * Removes and rerurns the first element in the list.
     * @return
     *
     */
    public E removeFirst() {
        Node<E> temp = new Node<>();
        if (this.head != null) {
            if (this.head.next == null) {
                this.head = null;
                System.out.println("First item in list removed. No items left.");
            } else {
                temp = this.head;
                head = head.next;
                head.setPrev(null);
                System.out.println("First item in list removed.");
                return temp.getElement();
            }
        } else {
            System.out.println("List is empty, nothing to remove.");
        }
        return temp.getElement();
    } // removeFirst

    /**
     * Removes and rerurns the last element in the list.
     * @return
     *
     */
    public E removeLast() {
        Node<E> temp = new Node<>();
        if (this.head != null) {
            if (this.head.next == null) {
                this.head = null;
                System.out.println("Last and only item removed. List is now empty.");
            } else {
                // traverse to the second last element of list
                temp = tail;
                tail = tail.prev;
                tail.next = null;
                System.out.println("Last item in the list removed.");
            }
        } else {
            System.out.println("List is empty, nothing to remove.");
        }
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
        counter++;
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
        counter++;
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
    * @return the element that was removed
    */
    public E remove(int index) {

        if (this.size() != 0 && this.size() > index) {
            Node<E> temp = head.getPrev();
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            } // for

            E deletedElement = temp.getNext().getElement();
            temp.getNext().getNext().setPrev(temp);
            temp.setNext(temp.getNext().getNext());

            if (index == 0) {
                head = temp.getNext();
            } // if
            // decrease the size by 1
            counter--;

            return temp.getElement();

        } // if
        else {
            return null;
        } // else
    } // remove

    /**
    * inserts the element at a specific position
    * @return the element
    */
    public void insert(int index, E element) {
        // return if null
        if (element == null) {
            return;
        } // if
        // if the DLL is empty, the head of the node will be the element
        if (this.size() == 0) {
           head = new Node(element, null, null);
           head.setNext(head);
           head.setPrev(head);
       } // if
        else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            } // for
            Node insertNode = new Node(element, temp.getPrev(), temp);
            temp.getPrev().setNext(insertNode);
            temp.setPrev(insertNode);
            if (index == 0) {
                head = insertNode;
            } // if
            counter++;
        } // else
    } // insert

    /**
    * The remove method removes the specified node from the list.
    * @param x node to remove
    */
    public void remove (Node x) {

        //if the x or the head is null, return
        if ( head == null || x == null) {
            return;
        } // if

        //if x is the head node
        if ( head == x) {
            head = x.getNext();
        } // if

        // next changes if the node that's deleted isn't the last node
        if ( x.getNext() != null ) {
            x.getPrev().setNext(x.getNext());
        } // if

        // prev changes if the node that's deleted isn't the first node
        if ( x.getPrev() != null ) {
            x.getNext().setPrev(x.getPrev());
        } // if
        counter--;
        return;
    } // remove

    /**
    * Removes all elements from the list
    */
    public void clear() {
        DLL <E> newList = new DLL <E>();
    } // void

    /**
    * Creates a new sequence of nodes whose values are equal to the
    * objects in the original list
    */
    public DLL<E> deepClone() throws CloneNotSupportedException {
        DLL copyList = new DLL<E>();

        if (this.size() > 0) {
            copyList.head = new Node<>(head.getElement());
            Node <E> middle = head.getNext();
            Node <E> anotherTail = copyList.head;

            while (middle != null) {
                Node <E> newNode = new Node<> (middle.getElement());

                anotherTail.setNext(newNode);
                anotherTail = newNode;
                middle = middle.getNext();
            } // while
        } // if
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

        // Checks if x and y are next to each other
        if(yPrevNode.equals(x)) {
            y.setPrev(xPrevNode);
            y.setNext(x);
            x.setNext(yNextNode);
            x.setPrev(y);
        } else {
            x.setPrev(yPrevNode);
            x.setNext(yNextNode);
            y.setPrev(xPrevNode);
            y.setNext(xNextNode);
        } // if
    } // swap


} // DLL
