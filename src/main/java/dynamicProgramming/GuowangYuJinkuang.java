package dynamicProgramming;

public class GuowangYuJinkuang {

    public static void main(String[] args) {
        int[] p = new int[]{5,5,3,4,3};
        int[] g = new int[]{400,500,200,300,350};
        int gold =maxGold(5, 10, p, g);
        System.out.println(gold);
    }

    public static int maxGold(int n, int w, int[] p, int[] g) {
        if (n == 1) {
            return w < p[n - 1] ? 0 : g[n - 1];
        }
        if (w < p[n - 1]) {
            return maxGold(n - 1, w, p, g);
        }
        return Math.max(maxGold(n - 1, w, p, g), maxGold(n - 1, w - p[n - 1], p, g) + g[n - 1]);
    }
}
