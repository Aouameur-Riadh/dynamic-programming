public class ex {
    public static void main(String[] args) {
        int n = 8;

        Float[] values = new Float[n + 1];
        int[] weights = new int[n + 1];

        values[1] = 0f;
        values[2] = 1f;
        values[3] = 2f;
        values[4] = 3f;
        values[5] = 4f;
        values[6] = 5f;
        values[7] = 6f;
        values[8] = 7f;


        weights[1] = 7;
        weights[2] = 6;
        weights[3] = 5;
        weights[4] = 4;
        weights[5] = 3;
        weights[6] = 2;
        weights[7] = 1;
        weights[8] = 0;

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
