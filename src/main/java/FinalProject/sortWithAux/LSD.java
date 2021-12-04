package FinalProject.sortWithAux;

import FinalProject.common.ConvertToUTF8;
import FinalProject.common.PinYin4jUtils;

public class LSD {
        public static void sort(String[] a)
        { // Sort a[] on leading W characters.
            int N = a.length;
            int R = 256;
            int W=0;
            String[] pinyinNames=new String[N];
            for(int i=0;i<N;i++){
                pinyinNames[i]= PinYin4jUtils.hanziToPinyin(a[i])+" "+ ConvertToUTF8.convertStringToUTF8(a[i]);
                W=Math.max(pinyinNames[i].length(),W);
            }
            for(int i=0;i<N;i++){
                if(pinyinNames[i].length()<W){
                    for(int j=pinyinNames[i].length();j<W;j++){
                        pinyinNames[i]+=" ";
                    }
                }
            }
            String[] aux = new String[N];
            String[] auxChinese = new String[N];
            for (int d = W-1; d >= 0; d--)
            { // Sort by key-indexed counting on dth char.
                int[] count = new int[R+1]; // Compute frequency counts.
                for (int i = 0; i < N; i++)
                    count[pinyinNames[i].charAt(d) + 1]++;
                for (int r = 0; r < R; r++) // Transform counts to indices.
                    count[r+1] += count[r];
                for (int i = 0; i < N; i++){// Distribute.
                    int index=count[pinyinNames[i].charAt(d)]++;
                    aux[index] = pinyinNames[i];
                auxChinese[index] = a[i];}
                for (int i = 0; i < N; i++){ // Copy back.
                    pinyinNames[i] = aux[i];
                    a[i]=auxChinese[i];
                }
            }
        }

    public static void main(String[] args) {
    }
}
