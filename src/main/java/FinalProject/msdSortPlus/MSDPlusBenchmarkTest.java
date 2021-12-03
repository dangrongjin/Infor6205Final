package FinalProject.msdSortPlus;

import FinalProject.*;
import edu.neu.coe.huskySort.sort.huskySort.PureHuskySort;
import edu.neu.coe.huskySort.sort.huskySortUtils.HuskyCoderFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class MSDPlusBenchmarkTest {

   static MSDSort msd = new MSDSort();
   static quickSort quick = new quickSort();


    /**
     *   using the [] [] is the same efficiency as list
     */

   static HashMap<String,Object> map  = new HashMap<>();
   static Timer t1 = new Timer();
    static PureHuskySort pureHuskySort=new PureHuskySort(HuskyCoderFactory.englishCoder,false,false);


    public static void main(String[] args) {
        msdBenchmarkRes();
        huskysortBenchmarkRes();
        quicksortBenchmarkRes();
    }



    public static void quicksortBenchmarkRes(){
        double time5 = t1.repeat(2, () -> map, t -> {
                    quickSort.quicksort((String[]) map.get("list"));
                    return t;
                }, t -> preDataProcess(t,1000000),
                t -> { postDataProcess(t);
                }
        );

        t1.resume();
        System.out.println(time5 +"the max");
    }


    /**
     *
     */


    public static void huskysortBenchmarkRes(){
        double time5 = t1.repeat(2, () -> map, t -> {
                    pureHuskySort.sort((String[]) map.get("list"));
                    return t;
                }, t -> preDataProcess(t,1000000),
                t -> { postDataProcess(t);
                }
        );

        t1.resume();
        System.out.println(time5 +"the max");


    }


    /**
     * msd benchmarkTest
     */
    public static void msdBenchmarkRes(){


            double time5 = t1.repeat(5, () -> map, t -> {
                msd.msdSort((String[]) map.get("list"));
                return t;
            }, t -> preDataProcess(t,1000000),
                    t -> { postDataProcess(t);
                    }
            );

            t1.resume();
            System.out.println(time5 +"the max");


    }

    /**
     *  Data preprocessing, map.get("list") pinyinNames map.get(resmap) <pinyinnames,chineseNames>  One-to-one correspondence
     *   n: choose initial data interception length 初始数据截取长度
     * @param map
     * @param n  choose initial data interception length 初始数据截取长度
     * @return
     */
    public static HashMap<String,Object> preDataProcess(HashMap<String,Object> map, int n){
        String [] pinyinNames = ReadTxt.getAllChineseNameToPinyin(n);
        String [] chineseNames = ReadTxt.getAllChineseName(n);
        for(int i=0;i<pinyinNames.length;i++){
            pinyinNames[i]+= ConvertToUTF8.convertStringToUTF8(chineseNames[i]);
        }
        map.put("list",pinyinNames); //排序的拼音list
        //汉语 和拼音 映射的map
        HashMap<String,String> resmap = new HashMap<>();
        for (int i = 0; i<pinyinNames.length;i++) {
            resmap.put(pinyinNames[i],chineseNames[i]);
        }
        map.put("resmap",resmap);
        return map;
    }

    /**
     *
     * 拿到排序好的 拼音[], 将其转化为 汉字，需要同 map中的resmap进行映射
     *
     * @param
     * @return
     */
    public static String []  postDataProcess(HashMap<String,Object> map){
         String [] s = ((String[]) map.get("list"));
        HashMap<String, String> resultmap = (HashMap<String, String>) map.get("resmap");
         String [] res = new String[s.length];

        for (int i = 0; i < res.length; i++) {
            res [i] = resultmap.get(s[i]);
        }
        return res;
    }

}



