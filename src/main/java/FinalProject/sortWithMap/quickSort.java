package FinalProject.sortWithMap;

import FinalProject.common.ConvertToUTF8;
import FinalProject.common.PinYin4jUtils;

import java.util.HashMap;
import java.util.Map;

public class quickSort {


    public static void quicksort(String [] chineseNames){
        Map<String,String> map=new HashMap<>();
        String[] pinyinNames=new String[chineseNames.length];
        for(int i=0;i<chineseNames.length;i++){
            pinyinNames[i]= PinYin4jUtils.hanziToPinyin(chineseNames[i])+" "+ConvertToUTF8.convertStringToUTF8(chineseNames[i]);
            map.put(pinyinNames[i],chineseNames[i]);
        }
        sort(pinyinNames,0, pinyinNames.length-1);
        for(int i=0;i<chineseNames.length;i++){
            chineseNames[i]=map.get(pinyinNames[i]);
        }
    }

    public static void sort(String[] A, int left, int right) {
        if (right > left) {
            // Choose outermost elements as pivots
            if (A[right].compareTo(A[left])<0) {swap(A, left, right);}
            String p = A[left], q = A[right];
            // Partition A according to invariant below
            int l = left + 1, g = right - 1, k = l;
            while (k <= g) {
                if (A[k].compareTo(p)<0) {
                    swap(A, k, l);
                    ++l;
                } else if (A[k].compareTo(q)>=0) {
                    while (A[g].compareTo(q)>0 && k < g) --g;
                    swap(A, k, g);
                    --g;
                    if (A[k].compareTo(p)<0) {
                        swap(A, k, l);
                        ++l;
                    }
                }
                ++k;
            }
            --l; ++g;
            // Swap pivots to final place
            swap(A, left, l); swap(A, right, g);
            // Recursively sort partitions
            sort(A, left, l - 1);
            sort(A, l + 1, g - 1);
            sort(A, g + 1, right);
        }
    }
    public static void swap(String[] a, int i, int j) {
        String temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}
