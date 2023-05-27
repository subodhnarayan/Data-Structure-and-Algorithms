import java.util.*;

public class BST {
    public static class node {
        char data;
        node left;
        node right;

        node(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static node insert(node root, char val) {
        if (root == null) {
            root = new node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void preorder(node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data + " ");
    }

    public static boolean search(node root, char key) {
        if (root == null) {
            return false;
        }
        if (root.data > key) {
            return search(root.left, key);
        } else if (root.data == key) {
            return true;
        } else {
            return search(root.right, key);
        }
    }

    public static node delete(node root, char key) {
        if (root.data > key) {
            root.left = delete(root.left, key);
        } else if (root.data < key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            node is = inodersucessor(root.right);
            root.data = is.data;
            root.right = delete(root, is.data);
        }
        return root;
    }

    public static node inodersucessor(node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static int height(node root) {
        if (root == null) {
            return 0;
        }
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        int height = Math.max(leftheight, rightheight) + 1;
        return height;
    }

    public static void printinrange(node root, char x, char y) {
        if (root == null) {
            return;
        }
        if (root.data >= x && root.data <= y) {
            printinrange(root.left, x, y);
            System.out.println(root.data);
            printinrange(root.right, x, y);
        } else if (root.data >= y) {
            printinrange(root.left, x, y);
        } else {
            printinrange(root.right, x, y);
        }
    }

    public static char largest(node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    public static char smallest(node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    public static int countnode(node root) {
        if (root == null) {
            return 0;
        }
        int leftcount = countnode(root.left);
        int rightcount = countnode(root.right);
        return leftcount + rightcount + 1;
    }

    public static int sumofnodes(node root) {
        if (root == null) {
            return 0;
        }
        int leftsum = sumofnodes(root.left);
        int rightsum = sumofnodes(root.right);
        return leftsum + rightsum + root.data;
    }

    public static void levelorder(node root) {
        Queue<node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            node curr = q.remove();
            if (curr == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    public static int levelofnode(node root, char key) {
        Queue<node> q = new LinkedList<>();
        int level = 1;
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            node curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                    level++;
                }
            } else {
                if (curr.data == key) {
                    return level;
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
            }
        }
        return -1;
    }

    public static int countexternalnode(node root) {
        if (root == null) {
            return 0;
        } else if (root.right == null && root.right == null)

        {
            return 1;
        } else {
            int leftcount = countexternalnode(root.left);
            int rightcount = countexternalnode(root.right);
            return leftcount + rightcount;
        }
    }

    public static int countinternalnode(node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        } else {
            int leftcount = countinternalnode(root.left);
            int rightcount = countinternalnode(root.right);
            return leftcount + rightcount + 1;
        }
    }

    public static void main(String args[]) {
        // System.out.println("my name is subodh narayan sah");
        BST b = new BST();
        char str[] = { 'e', 'a', 'c', 'd', 'f', 'g', 'h', 'k' };
        node root = null;
        for (int i = 0; i < str.length; i++) {
            root = insert(root, str[i]);
        }
        // System.out.println(root.data);
        System.out.println("The inorder transval of the tree is");
        inorder(root);
        System.out.println();
        System.out.println("The preorder transval of the tree is");
        preorder(root);
        System.out.println();
        System.out.println("The postorder transval of the tree is");
        preorder(root);
        System.out.println();
        if (search(root, 'a')) {
            System.out.println("Match found");
        } else {
            System.out.println("match not found");
        }
        // delete(root, 'd');
        inorder(root);
        System.out.println();
        System.out.println(height(root));
        printinrange(root, 'a', 'g');
        System.out.println("The smallest character is " + smallest(root));
        System.out.println("The greatest character is " + largest(root));
        System.out.println("The number of node in binary tree is " + countnode(root));
        System.out.println("The number of node in binary tree is " + sumofnodes(root));
        levelorder(root);
        System.out.println("The level of g is " + levelofnode(root, 'g'));
        System.out.println("The number of external node is " + countexternalnode(root));
        System.out.println("The number of interal node is " + countinternalnode(root));
    }
}