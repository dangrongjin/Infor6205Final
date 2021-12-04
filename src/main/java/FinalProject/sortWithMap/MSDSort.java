package FinalProject.sortWithMap;
import FinalProject.common.ConvertToUTF8;
import FinalProject.common.PinYin4jUtils;

import java.util.HashMap;
import java.util.Map;

public class MSDSort {
    private static String[] pinyin;
    private static Map<String,String> map=new HashMap<>();
    private static int R = 256; // radix
    private static final int M = 15; // cutoff for small subarrays
    private static String[] aux;
    private static int charAt(String s, int d)
    { if (d < s.length()) return s.charAt(d); else return -1; }
    public static void msdSort(String[] a)
    {
        int N = a.length;
        pinyin=new String[N];
        for(int i=0;i<N;i++){
            pinyin[i]= PinYin4jUtils.hanziToPinyin(a[i])+" "+ConvertToUTF8.convertStringToUTF8(a[i]);
            map.put(pinyin[i],a[i]);
        }
        aux = new String[N];
        msdSort(pinyin, 0, N-1, 0);
        for(int i=0;i<a.length;i++){
            a[i]=map.get(pinyin[i]);
        }
    }
    private static void msdSort(String[] pinyin, int lo, int hi, int d)
    { // Sort from a[lo] to a[hi], starting at the dth character.
        if (hi <= lo + M)
        { Insertion.sort(pinyin, lo, hi, d); return; }
        int[] count = new int[R+2]; //s Compute frequency counts.
        for (int i = lo; i <= hi; i++)
            count[charAt(pinyin[i], d) + 2]++;
        for (int r = 0; r < R+1; r++) // Transform counts to indices.
            count[r+1] += count[r];
        for (int i = lo; i <= hi; i++) // Distribute.
        { int s=count[charAt(pinyin[i], d) + 1]++;
            aux[s] = pinyin[i];
            }
        for (int i = lo; i <= hi; i++) // Copy back.
        {pinyin[i] = aux[i - lo];
            }
// Recursively sort for each character value.
        for (int r = 0; r < R; r++)
            msdSort(pinyin, lo + count[r], lo + count[r+1] - 1, d+1);
    }

}