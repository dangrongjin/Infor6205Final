package FinalProject.sortWithMap;

public class Insertion {
    public static void sort(String[] a,int lo,int hi,int d){
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1], d); j--){
                swap(a, j, j-1);
            }
    }
    public static void swap(String[] a, int i, int j) {
        String temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
    private static boolean less(String v, String w, int d)
    {
        for (int i = d; i < Math.min(v.length(), w.length()); i++)
        {
            if (v.charAt(i) < w.charAt(i)) return true;
            if (v.charAt(i) > w.charAt(i)) return false;
        }
        return v.length() < w.length();
    }
    private static int charAt(String s, int d)
    { if (d < s.length()) return s.charAt(d); else return -1; }

}
