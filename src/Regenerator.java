/**
 *
 * @author xbp1
 */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Regenerator {
    public static <E> LinkedBinaryTree<E> preAndIn(List<? extends E> preorder, List<? extends E> inorder) {
        if(preorder.isEmpty()) {
            return new LinkedBinaryTree<>();
        }
        else {
            int indexOfRootInorder = inorder.indexOf(preorder.get(0));
            return new LinkedBinaryTree<>(preorder.get(0),
                    preAndIn((List<? extends E>) preorder.subList(1, indexOfRootInorder + 1), (List<E>) inorder.subList(0, indexOfRootInorder)),
                    preAndIn((List<? extends E>) preorder.subList(indexOfRootInorder + 1, preorder.size()), (List<E>) inorder.subList(indexOfRootInorder + 1, preorder.size()))
            );
        }
    }
}