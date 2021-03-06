/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bst;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TreeTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Linear", BinaryTree.build(new Integer[]{1, 2, 3, 4, 5, 6, 7}), false},
                {"Sorted", BinaryTree.build(new Integer[]{4, 2, 6, 1, 3, 5, 7}), true},
                {"Sortish", BinaryTree.build(new Integer[]{4, 2, 6, 1, 5, 3, 7}), false},
                {"Sortish", BinaryTree.build(
                        new String[]{"really", "fun", "time", "please", "act", null, "responsibly"}), false},
        });
    }

    private String name;
    private BinaryTree.Node<Integer> root;
    private Boolean sorted;

    public TreeTest(String name, BinaryTree.Node<Integer> root, Boolean sorted) {
        this.name = name;
        this.root = root;
        this.sorted = sorted;
    }

    @Override
    public String toString() {
        return "The tree \"" + this.name + "\" " +
                "is" + (this.sorted ? " " : " not ") + "sorted. \n" + this.root;
    }

    @Test
    public void test() {
        assertEquals(this.toString(), sorted, ExerciseBst.isBinarySearchTree(root));
    }
}
