package FinalProject.msdSortPlus;

public class MSDSort {


    private static int R = 256;
    private static final int M = 15;
    private static String[] aux;


    private static int charAt(String s, int d) {

        if (d < s.length()) return s.charAt(d);
        else return -1;
    }

    public static void msdSort(String[] a) {

        int N = a.length;
        aux = new String[N];


        msdSort(a, 0, N - 1, 0);
    }

    private static void msdSort(String[] a, int lo, int hi, int d) {

        if (hi <= lo + 15) {
            //Insertion.sort(a, lo, hi, d, chinese);
            Insertion.sort(a, lo, hi, d);
            return;
        }
        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++)
            count[charAt(a[i], d) + 2]++;
        for (int r = 0; r < R + 1; r++)
            count[r + 1] += count[r];
        for (int i = lo; i <= hi; i++) {
            int s = count[charAt(a[i], d) + 1]++;
            aux[s] = a[i];

        }
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }

        for (int r = 0; r < R; r++)
            msdSort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
    }






}
