package BinaryTree;

public class Tree {

    public Node root;

    public Tree(int value) {
        this.root = new Node(value,null);
    }

    public void insert(int value){
        root.insert(value);
        rebalance();
    }

    public boolean search(int value){
        return root.search(value) != null;
    }

    public void deleting(int value){
        Node node = root.search(value);
        if (node == null) return;
        if (node.getLeft()==null || node.getRight()==null){
            deleteOne(node);
        } else {
            Node lastLeftMode = node.getLeft();
            while (lastLeftMode.getLeft()!=null){
                lastLeftMode = lastLeftMode.getLeft();
            }
            svopNodesValues(node,lastLeftMode);
            deleteOne(lastLeftMode);
        }
    }

    public void rebalance(){
        Node problem = root.searchToBalance();
        boolean changeRoot;
        if (problem == null) return;
        changeRoot = problem.equals(root);
        if (problem.getBalance() == 2
                && problem.getLeft().getBalance() >=0){
            if (changeRoot){
                root = problem.getLeft();
            }
            problem.littleRightSpin();
        }

        if (problem.getBalance() == 2
                && problem.getLeft().getBalance() <=0){
            if (changeRoot){
                root = problem.getLeft().getRight();
            }
            problem.bigRightSpin();
        }

        if (problem.getBalance() == -2
                && problem.getRight().getBalance() <= 0){
            if (changeRoot){
                root = problem.getRight();
            }
            problem.littleLeftSpin();
        }
        if (problem.getBalance() == -2
                && problem.getRight().getBalance() >= 0){
            if (changeRoot){
                root = problem.getRight().getLeft();
            }
            problem.bigLeftSpin();
        }
        rebalance();
    }


    private void deleteOne(Node node){
        if (node.getRight()!=null){
            if (node.getParent().getRight() != null && node.getParent().getRight().equals(node)){
                node.getParent().setRight(node.getRight());
            } else {
                node.getParent().setLeft(node.getRight());
            }
            node.getRight().countHeight();
            return;
        }

        if (node.getLeft()!=null){
            if (node.getParent().getRight() != null && node.getParent().getRight().equals(node)){
                node.getParent().setRight(node.getLeft());
            } else {
                node.getParent().setLeft(node.getLeft());
            }
            node.getLeft().countHeight();
            return;
        }
        if (node.getParent().getRight() != null && node.getParent().getRight().equals(node)){
            node.getParent().setRight(null);
        } else {
            node.getParent().setLeft(null);
        }
    }

    private void svopNodesValues(Node first, Node second){
        int value = first.getValue();
        first.setValue(second.getValue());
        second.setValue(value);
    }

}
