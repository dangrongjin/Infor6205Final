package FinalProject.sortWithAux;

import FinalProject.common.ConvertToUTF8;
import FinalProject.common.PinYin4jUtils;

public class quickSort {


    public static void quicksort(String [] chineseNames){
        String[] pinyinNames=new String[chineseNames.length];
        for(int i=0;i<chineseNames.length;i++){
            pinyinNames[i]= PinYin4jUtils.hanziToPinyin(chineseNames[i])+" "+ ConvertToUTF8.convertStringToUTF8(chineseNames[i]);
        }
        sort(pinyinNames,0, pinyinNames.length-1, chineseNames);
    }

    public static void sort(String[] A, int left, int right,String[] chinese) {
        if (right > left) {
            // Choose outermost elements as pivots
            if (A[right].compareTo(A[left])<0) {swap(A, left, right);swap(chinese,left,right);}
            String p = A[left], q = A[right];
            // Partition A according to invariant below
            int l = left + 1, g = right - 1, k = l;
            while (k <= g) {
                if (A[k].compareTo(p)<0) {
                    swap(A, k, l);
                    swap(chinese,k,l);
                    ++l;
                } else if (A[k].compareTo(q)>=0) {
                    while (A[g].compareTo(q)>0 && k < g) --g;
                    swap(A, k, g);
                    swap(chinese,k,g);
                    --g;
                    if (A[k].compareTo(p)<0) {
                        swap(A, k, l);
                        swap(chinese,k,l);
                        ++l;
                    }
                }
                ++k;
            }
            --l; ++g;
            // Swap pivots to final place
            swap(A, left, l); swap(A, right, g);
            swap(chinese,left,l);swap(chinese,right,g);
            // Recursively sort partitions
            sort(A, left, l - 1,chinese);
            sort(A, l + 1, g - 1,chinese);
            sort(A, g + 1, right,chinese);
        }
    }
    public static void swap(String[] a, int i, int j) {
        String temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}
