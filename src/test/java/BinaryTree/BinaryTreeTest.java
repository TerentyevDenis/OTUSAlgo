package BinaryTree;

import org.testng.annotations.Test;

public class BinaryTreeTest {

    @Test
    void test(){
        Tree tree = new Tree(12);
        int[] arr = { 1, 2, 3, 4 };
        for (int i = 0; i < 1000; i++ ){
            tree.insert(i);
        }
//        for (int i : arr){
//            tree.insert(i);
//        }
        System.out.println(tree.root.getLeft().getBalance());

    }
}
