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
         * @return element element the node stores
         */
        public E getElement() {
            return element;
        } // getElement

        /**
         * Gets the previous node of the referenced node.
         * @return prev previous node
         */
        public Node<E> getPrev() {
            return prev;
        } // getPrev

        /**
         * Gets the next node of the referenced node.
         * @return next next node
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
        Node<Integer> head = new Node<Integer>(1);
        System.out.println(head.getElement());
    } // main
} // DLL
