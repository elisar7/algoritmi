package Tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertTrue;

public class Tests {
    private Tree tree1;
    private Tree tree2;

    @Before
    public void createTree() throws Exception {
        tree1 = new Tree(13);
        tree1.add(new Node(5), 13);
        tree1.add(new Node(12), 13);
        tree1.add(new Node(1), 5);
        tree1.add(new Node(3), 5);
        tree1.add(new Node(4), 5);
        tree1.add(new Node(2), 3);
        tree1.add(new Node(10), 12);
        tree1.add(new Node(11), 12);
        tree1.add(new Node(6), 10);
        tree1.add(new Node(7), 10);
        tree1.add(new Node(8), 10);
        tree1.add(new Node(9), 10);

        tree2 = new Tree(6);
        tree2.add(new Node(1), 6);
        tree2.add(new Node(5), 6);
        tree2.add(new Node(3), 5);
        tree2.add(new Node(4), 5);
        tree2.add(new Node(2), 3);
    }

    @Test
    public void testSize() {
        int actual1 = tree1.size();
        int actual2 = tree2.size();
        int expected1 = 13;
        int expected2 = 6;
        assertTrue(actual1 == expected1 && actual2 == expected2);
    }

    @Test
    public void testMaxGrade() {
        int actual1 = tree1.maxGrade();
        int actual2 = tree2.maxGrade();
        int expected1 = 4;
        int expected2 = 2;
        assertTrue(actual1 == expected1 && actual2 == expected2);
    }

    @Test
    public void testDepth() {
        int actual1 = tree1.depth();
        int actual2 = tree2.depth();
        int expected1 = 3;
        int expected2 = 3;
        assertTrue(actual1 == expected1 && actual2 == expected2);
    }

    @Test
    public void testIsBin() {
        Boolean actual1 = tree1.isBin();
        Boolean actual2 = tree2.isBin();
        Boolean expected1 = false;
        Boolean expected2 = true;
        assertTrue(actual1 == expected1 && actual2 == expected2);
    }

    @Test
    public void testBinarySearchTree() {
        Tree binaryTree = new Tree();
        binaryTree = tree1.binarySearchTree(new IntegerComparator());
        assertTrue(binaryTree.isBin());
    }

    class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i1.compareTo(i2);
        }
    }

}
