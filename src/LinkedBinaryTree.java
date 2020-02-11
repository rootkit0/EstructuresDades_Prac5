/**
 *
 * @author xbp1
 */

import java.util.NoSuchElementException;

public class LinkedBinaryTree<E> implements BinaryTree<E> {
    private Node<E> root;
    private static class Node<E> {
        private final E elem;
        private final Node<E> left;
        private final Node<E> right;
        
        public Node(E elem, Node<E> left, Node<E> right) {
            this.elem = elem;
            this.left = left;
            this.right = right;
        }
        
        @Override
        public boolean equals(Object obj) {
            if(obj == null || !(obj instanceof Node)) {
                return false;
            }
            else {
                Node<E> node = (Node<E>) obj;
                return this.left.elem.equals(node.left.elem) && this.right.elem.equals(node.right.elem);
            }
        }
    }
    
    public LinkedBinaryTree() {
        root = null;
    }
    
    public LinkedBinaryTree(E elem) {
        root = new Node<>(elem, null, null);
    }
    
    public LinkedBinaryTree(E e, LinkedBinaryTree<E> left, LinkedBinaryTree<E> right) {
        Node<E> esquerra = (left == null ? null : left.root);
        Node<E> dreta = (right == null ? null : right.root);
        
        root = new Node<>(e, esquerra, dreta);
    }
    
    public LinkedBinaryTree(Node<E> root) {
        this.root = root;
    }
    
    @Override
    public E elem() throws NoSuchElementException {
        if(isEmpty()) {
            throw new NoSuchElementException("Arbre buit");
        }
        else {
            return root.elem;
        }
    }

    @Override
    public BinaryTree<E> left() throws NoSuchElementException {
        if(isEmpty()) {
            throw new NoSuchElementException("Arbre buit");
        }
        else {
            return new LinkedBinaryTree<>(root.left);
        }
    }

    @Override
    public BinaryTree<E> right() throws NoSuchElementException {
        if(isEmpty()) {
            throw new NoSuchElementException("Arbre buit");
        }
        else {
            return new LinkedBinaryTree<>(root.right);
        }
    }

    @Override
    public boolean isEmpty() throws NoSuchElementException {
        return root == null;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof LinkedBinaryTree)) {
            return false;
        }
        else {
            LinkedBinaryTree<E> arbre = (LinkedBinaryTree<E>) obj;
            return this.root.equals(arbre.root);
        }
    }
}
