public class th {
    public static void main(String[] args) {
        int n = 4;

        Float[] values = new Float[n + 1];
        int[] weights = new int[n + 1];

        values[1] = 5f;
        values[2] = 3f;
        values[3] = 2f;
        values[4] = 1f;
        weights[1] = 3;
        weights[2] = 2;
        weights[3] = 1;
        weights[4] = 4;

        int C = 7;

        Float[][] tab = new Float[C + 1][n + 1];

        for(int v = 0; v <= C; v++) {
            tab[v][0] = 0f;
        }

        for(int i = 1; i <= n; i++) {
            for(int v = 0; v <= C; v++) {
                if(v < weights[i]) {
                    tab[v][i] = tab[v][i - 1];
                }
                else {
                    tab[v][i] = Math.max(tab[v][i - 1], tab[v - weights[i]][i - 1] + values[i]);
                }
            }
        }

        System.out.println("Valeur optimale " + tab[C][n]);

        int[] x = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            x[i] = 0;
        }

        int k = n;
        while(C > 0 && k > 0) {
            if(!tab[C][k].equals(tab[C][k - 1])) {
                x[k] = x[k] + 1;
                C = C - weights[k];
            }
            k--;
        }

        System.out.println("Selected Objects : ");

        for(int j = 1; j <= n; j++) {
            if(x[j] == 1) {
                System.out.println("Object " + j + " Value " + values[j]);
            }
        }
    }
}
