public class BinaryTree {
    private Node root;

    // Inserção
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.data)
            root.left = insertRec(root.left, value);
        else if (value > root.data)
            root.right = insertRec(root.right, value);
        return root;
    }

    // Remoção
    public void remove(int value) {
        root = removeRec(root, value);
    }

    private Node removeRec(Node root, int value) {
        if (root == null) return root;
        if (value < root.data) {
            root.left = removeRec(root.left, value);
        } else if (value > root.data) {
            root.right = removeRec(root.right, value);
        } else {
            // Nó com um ou nenhum filho
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Nó com dois filhos
            root.data = minValue(root.right);
            root.right = removeRec(root.right, root.data);
        }
        return root;
    }

    private int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    // Pesquisa
    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node root, int value) {
        if (root == null) return false;
        if (root.data == value) return true;
        return value < root.data ? searchRec(root.left, value) : searchRec(root.right, value);
    }

    // Traversals
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }

    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    public void postOrder() {
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Verifica se é cheia
    public boolean isFull() {
        return isFullRec(root);
    }

    private boolean isFullRec(Node node) {
        if (node == null) return true;
        if (node.left == null && node.right == null) return true;
        if (node.left != null && node.right != null)
            return isFullRec(node.left) && isFullRec(node.right);
        return false;
    }

    // Verifica se é estritamente binária
    public boolean isStrict() {
        return isStrictRec(root);
    }

    private boolean isStrictRec(Node node) {
        if (node == null) return true;
        if ((node.left == null && node.right != null) || (node.left != null && node.right == null))
            return false;
        return isStrictRec(node.left) && isStrictRec(node.right);
    }

    // Verifica se é completa
    public boolean isComplete() {
        int nodeCount = countNodes(root);
        return isCompleteRec(root, 0, nodeCount);
    }

    private boolean isCompleteRec(Node node, int index, int count) {
        if (node == null) return true;
        if (index >= count) return false;
        return isCompleteRec(node.left, 2 * index + 1, count) &&
               isCompleteRec(node.right, 2 * index + 2, count);
    }

    private int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // Grau de um nó
    public int getGrau(int value) {
        Node node = findNode(root, value);
        if (node == null) return -1;
        int grau = 0;
        if (node.left != null) grau++;
        if (node.right != null) grau++;
        return grau;
    }

    private Node findNode(Node root, int value) {
        if (root == null || root.data == value) return root;
        return value < root.data ? findNode(root.left, value) : findNode(root.right, value);
    }

    // Nível da árvore
    public int nivel() {
        return altura(root);
    }

    private int altura(Node node) {
        if (node == null) return 0;
        int left = altura(node.left);
        int right = altura(node.right);
        return Math.max(left, right) + 1;
    }
}
