public class DisjointSet {

    private int[] forest;

    public DisjointSet(int size) {
        forest = new int[size];
        for (int i = 0; i < size; i++) {
            forest[i] = -1;
        }
    }

    public int findSet(int v) {
        // First pass
        int root = v;
        while (forest[root] >= 0) {
            root = forest[root];
        }
        // Second pass
        while (forest[v] >= 0) {
            int parent = forest[v];
            forest[v] = root;
            v = parent;
        }
        return root;
    }

    public void unionSet(int a, int b) {
        int rootA = findSet(a);
        int rootB = findSet(b);
        if (rootA != rootB) {
            if (forest[rootA] > forest[rootB]) {
                int tmp = rootA;
                rootA = rootB;
                rootB = tmp;
            }
            int heightB = forest[rootB];
            forest[rootB] = rootA;
            forest[rootA] += heightB;
        }
    }

    public void printForest() {
        for (int i = 0; i < forest.length; i++) {
            System.out.printf("% 4d", forest[i]);
            System.out.print(" ");
        }
        System.out.print("\n");
        for (int i = 0; i < forest.length; i++) {
            System.out.printf("%4d ", i);
        }
        System.out.print("\n");
    }

}
