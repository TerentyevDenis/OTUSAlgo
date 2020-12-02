package BinaryTree;

import java.util.Objects;

public class Node {
    private int value;

    private Node left;

    private Node right;

    private int height;

    private int balance;

    private Node parent;

    public Node(int value,Node parent) {
        this.value = value;
        this.parent = parent;
        balance = 0;
        height = 1;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void insert(int value){
        if (this.value == value) return;
        if (this.value > value){
            if (left != null) {
                left.insert(value);
            } else {
                left = new Node(value,this);
                left.countHeight();
            }
        } else {
            if (right != null) {
                right.insert(value);
            } else {
                right = new Node(value,this);
                right.countHeight();
            }
        }
    }

    public Node search(int value){
        if(this.value == value){
            return this;
        }
        if (this.value < value){
            if (right != null) {
               return right.search(value);
            } else return null;
        } else {
            if (left != null) {
              return   left.search(value);
            } else return null;
        }
    }

    public Node searchToBalance(){
        Node result;
        if(Math.abs(this.balance) > 1){
            return this;
        }
        if (right != null) {
           result = right.searchToBalance();
            if (result != null){
                return result;
            }
        }
        if (left != null) {
            result = left.searchToBalance();
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    public void countHeight(){
            if(this.getLeft() == null && this.getRight() == null) {
                balance = 0;
                height = 1;
            }
            if (this.getLeft() != null && this.getRight() != null) {
                this.setHeight(Math.max(this.getLeft().getHeight(), this.getRight().getHeight()) + 1);
                this.setBalance(this.getLeft().getHeight() - this.getRight().getHeight());
            }
            if (this.getLeft() != null && this.getRight() == null) {
                this.setHeight(this.getLeft().getHeight()+1);
                this.setBalance(this.getLeft().getHeight());
            }
            if (this.getRight() != null && this.getLeft() == null ) {
                this.setHeight(this.getRight().getHeight()+1);
                this.setBalance(-this.getRight().getHeight());
            }
            if (parent != null){
                parent.countHeight();
            }
    }

    public void littleRightSpin() {
        Node left = this.left;
        Node leftRight = this.left ==null? null:this.left.getRight();
        if (left != null) {
            left.setRight(this);
            left.setParent(this.parent);
            if (this.getParent() != null) {
                if (this.parent.getRight() != null && this.parent.getRight().equals(this)) {
                    this.parent.setRight(left);
                } else {
                    this.parent.setLeft(left);
                }
            }
        }
        this.parent = left;
        this.left = leftRight;
        if (leftRight!=null) {
            leftRight.setParent(this);
        }
       this.countHeight();
    }

    public void bigRightSpin(){
        this.left.littleLeftSpin();
        this.littleRightSpin();
    }

    public void littleLeftSpin() {
        Node right = this.right;
        Node rightLeft = this.right == null? null:this.right.getLeft();
        if (right != null) {
            right.setLeft(this);
            right.setParent(this.parent);
            if(this.parent != null ) {
                if (this.parent.getRight() != null && this.parent.getRight().equals(this)) {
                    this.parent.setRight(right);
                } else {
                    this.parent.setLeft(right);
                }
            }
        }
        this.parent = right;
        this.right=rightLeft;
        if(rightLeft != null) {
            rightLeft.setParent(this);
        }
        this.countHeight();
    }
    public void bigLeftSpin(){
        this.right.littleRightSpin();
        this.littleLeftSpin();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
