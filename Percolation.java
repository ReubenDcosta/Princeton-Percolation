import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int n;
    private final boolean[][] grid;
    private final WeightedQuickUnionUF uf;
    private final WeightedQuickUnionUF ufFullCheck;
    private final int virtualTop;
    private final int virtualBottom;
    private int openSiteCount;

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("n must be > 0");
        this.n = n;
        grid = new boolean[n][n];
        uf = new WeightedQuickUnionUF(n * n + 2);          // Includes virtual top and bottom
        ufFullCheck = new WeightedQuickUnionUF(n * n + 1); // Only virtual top (for fullness check)
        virtualTop = n * n;
        virtualBottom = n * n + 1;
        openSiteCount = 0;
    }

    private void validate(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n)
            throw new IllegalArgumentException("Index out of bounds");
    }

    private int xyTo1D(int row, int col) {
        return (row - 1) * n + (col - 1);
    }

    public void open(int row, int col) {
        validate(row, col);
        if (isOpen(row, col)) return;

        grid[row - 1][col - 1] = true;
        openSiteCount++;

        int index = xyTo1D(row, col);

        if (row == 1) {
            uf.union(index, virtualTop);
            ufFullCheck.union(index, virtualTop);
        }

        if (row == n) {
            uf.union(index, virtualBottom); // not for ufFullCheck
        }

        // Up
        if (row > 1 && isOpen(row - 1, col)) {
            int neighbor = xyTo1D(row - 1, col);
            uf.union(index, neighbor);
            ufFullCheck.union(index, neighbor);
        }

        // Down
        if (row < n && isOpen(row + 1, col)) {
            int neighbor = xyTo1D(row + 1, col);
            uf.union(index, neighbor);
            ufFullCheck.union(index, neighbor);
        }

        // Left
        if (col > 1 && isOpen(row, col - 1)) {
            int neighbor = xyTo1D(row, col - 1);
            uf.union(index, neighbor);
            ufFullCheck.union(index, neighbor);
        }

        // Right
        if (col < n && isOpen(row, col + 1)) {
            int neighbor = xyTo1D(row, col + 1);
            uf.union(index, neighbor);
            ufFullCheck.union(index, neighbor);
        }
    }

    public boolean isOpen(int row, int col) {
        validate(row, col);
        return grid[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {
        validate(row, col);
        if (!isOpen(row, col)) return false;
        int index = xyTo1D(row, col);
        return ufFullCheck.find(index) == ufFullCheck.find(virtualTop);
    }

    public int numberOfOpenSites() {
        return openSiteCount;
    }

    public boolean percolates() {
        return uf.find(virtualTop) == uf.find(virtualBottom);
    }
}
