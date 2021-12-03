package FinalProject;

import java.util.ArrayList;
import java.util.Arrays;


public class MSDBenchmarkTest {

   static MSDSort msd = new MSDSort();
   static quickSort quick = new quickSort();


    /**
     *   using the [] [] is the same efficiency as list
     */

   static ArrayList<String []> list  = new ArrayList<>();
   static   Timer t1 = new Timer();



    public static void main(String[] args) {
        msdBenchmarkRes();
//        quicksortBenchmarkRes();
//        double time1 = t1.repeat(5, () -> list, t -> {
//
//            Arrays.sort(t.get(0));
//            return null;
//        }, t -> {
//            preDataProcess(t,1000000);
//            return null;
//        }, null);
//
//        t1.resume();
//        System.out.println(time1);
    }

    /**
     *
     */
    public  static void quicksortBenchmarkRes(){
//            double time1 = t1.repeat(5, () -> list, t -> {
//
//                quick.quicksort(t.get(0),t.get(1));
//                return null;
//            }, t -> {
//                preDataProcess(t,100000);
//                return null;
//            }, null);
//
//            t1.resume();
//            System.out.println(time1);
//
//            double time2 = t1.repeat(5, () -> list, t -> {
//                quick.quicksort(t.get(0),t.get(1));
//                return null;
//            }, t -> {
//                preDataProcess(t,200000);
//                return null;
//            }, null);
//
//            t1.resume();
//            System.out.println(time2);
//
//            double time3 = t1.repeat(5, () -> list, t -> {
//                quick.quicksort(t.get(0),t.get(1));
//                return null;
//            }, t -> {
//                preDataProcess(t,400000);
//                return null;
//            }, null);
//
//            t1.resume();
//            System.out.println(time3);
//
//            double time4 = t1.repeat(5, () -> list, t -> {
//                quick.quicksort(t.get(0),t.get(1));
//                return null;
//            }, t -> {
//                preDataProcess(t,800000);
//                return null;
//            }, null);
//
//            t1.resume();
//            System.out.println(time4);

            double time5 = t1.repeat(5, () -> list, t -> {
                quick.quicksort(t.get(0),t.get(1));
                return t;
            }, t -> {
                preDataProcess(t,1000000);
                return null;
            }, null);

            t1.resume();
            System.out.println(time5 +"the max");
    }

    /**
     * msd benchmarkTest
     */
    public static void msdBenchmarkRes(){

//            double time1 = t1.repeat(5, () -> list, t -> {
//                msd.msdSort(t.get(0),t.get(1));
//                return null;
//            }, t -> {
//                preDataProcess(t,100000);
//                return null;
//            }, null);
//
//            t1.resume();
//            System.out.println(time1);
//
//            double time2 = t1.repeat(5, () -> list, t -> {
//                msd.msdSort(t.get(0),t.get(1));
//                return null;
//            }, t -> {
//                preDataProcess(t,200000);
//                return null;
//            }, null);
//
//            t1.resume();
//            System.out.println(time2);
//
//            double time3 = t1.repeat(5, () -> list, t -> {
//                msd.msdSort(t.get(0),t.get(1));
//                return null;
//            }, t -> {
//                preDataProcess(t,400000);
//                return null;
//            }, null);
//
//            t1.resume();
//            System.out.println(time3);
//
//            double time4 = t1.repeat(5, () -> list, t -> {
//                msd.msdSort(t.get(0),t.get(1));
//                return null;
//            }, t -> {
//                preDataProcess(t,800000);
//                return null;
//            }, null);
//
//            t1.resume();
//            System.out.println(time4);

            double time5 = t1.repeat(20, () -> list, t -> {
                msd.msdSort(t.get(0),t.get(1));
                return null;
            }, t -> {
                preDataProcess(t,1000000);
                return null;
            },  null
            );

            t1.resume();
            System.out.println(time5 +"the max");


    }

    /**
     *  Data preprocessing, list.get(0) pinyinNames list.get(1)chineseNames
     *   n: Initial data interception length 初始数据截取长度
     * @param list
     * @param n
     * @return
     */
    public static ArrayList<String []> preDataProcess(ArrayList list,int n){
        String [] pinyinNames = ReadTxt.getAllChineseNameToPinyin(n);
        String [] chineseNames = ReadTxt.getAllChineseName(n);
        for(int i=0;i<pinyinNames.length;i++){
            pinyinNames[i]+= ConvertToUTF8.convertStringToUTF8(chineseNames[i]);
        }
        list.clear();
        list.add(0,pinyinNames);
        list.add(1,chineseNames);
        return list;
    }

//    public static ArrayList<String []> postDataProcess(ArrayList list,int n){
//        System.out.println(list);
//        return list;
//    }

}



