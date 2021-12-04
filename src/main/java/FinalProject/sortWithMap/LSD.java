package FinalProject.sortWithMap;

import FinalProject.common.ConvertToUTF8;
import FinalProject.common.PinYin4jUtils;

import java.util.HashMap;
import java.util.Map;

public class LSD {
        public static void sort(String[] a)
        { // Sort a[] on leading W characters.
            Map<String,String> map= new HashMap<>();
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
                map.put(pinyinNames[i],a[i]);
            }
            String[] aux = new String[N];
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
               }
                for (int i = 0; i < N; i++){ // Copy back.
                    pinyinNames[i] = aux[i];
                }
            }
            for(int i=0;i<a.length;i++){
                a[i]=map.get(pinyinNames[i]);
            }
        }

}
