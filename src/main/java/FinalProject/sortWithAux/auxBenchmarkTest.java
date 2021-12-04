package FinalProject.sortWithAux;

import FinalProject.common.ConvertToUTF8;
import FinalProject.common.ReadTxt;
import FinalProject.common.Timer;


import java.util.ArrayList;

public class auxBenchmarkTest {


    static MSDSort msd = new MSDSort();
    static quickSort quick = new quickSort();
    static timSort tim = new timSort();
    static  LSD  lsd  = new LSD();


    /**
     *   using the [] [] is the same efficiency as list
     */

    static ArrayList<String []> list  = new ArrayList<>();
    static Timer t1 = new Timer();



    public static void main(String[] args) {
        System.out.println("using aux-------------------------");
        msdBenchmarkRes();
        quicksortBenchmarkRes();
        timsortBenchmarkRes();
        lsdsortBenchmarkRes();
        System.out.println("using aux-------------------------");


    }

    public static  void lsdsortBenchmarkRes(){
        double time1 = t1.repeat(5, () -> list, t -> {

            lsd.sort(t.get(0));
            return null;
        }, t -> {
            preDataProcess(t,100000);
            return null;
        }, null);

        t1.resume();
        System.out.println("lsdsort 100000 :"+time1);

        double time2 = t1.repeat(5, () -> list, t -> {
            lsd.sort(t.get(0));
            return null;
        }, t -> {
            preDataProcess(t,200000);
            return null;
        }, null);

        t1.resume();
        System.out.println("lsdsort 200000 :"+time2);

        double time3 = t1.repeat(5, () -> list, t -> {
            lsd.sort(t.get(0));
            return null;
        }, t -> {
            preDataProcess(t,400000);
            return null;
        }, null);

        t1.resume();
        System.out.println("lsdsort 400000 :"+time3);

        double time4 = t1.repeat(5, () -> list, t -> {
            lsd.sort(t.get(0));
            return null;
        }, t -> {
            preDataProcess(t,800000);
            return null;
        }, null);

        t1.resume();
        System.out.println("lsdsort 800000 :"+time4);

        double time5 = t1.repeat(5, () -> list, t -> {
            lsd.sort(t.get(0));
            return t;
        }, t -> {
            preDataProcess(t,1000000);
            return null;
        }, null);

        t1.resume();
        System.out.println("lsdsort 1000000the max :"+time5 );
    }


    public static  void timsortBenchmarkRes(){
        double time1 = t1.repeat(5, () -> list, t -> {

            tim.sort(t.get(0));
            return null;
        }, t -> {
            preDataProcess(t,100000);
            return null;
        }, null);

        t1.resume();
        System.out.println("timsort 100000 :"+time1);

        double time2 = t1.repeat(5, () -> list, t -> {
            tim.sort(t.get(0));
            return null;
        }, t -> {
            preDataProcess(t,200000);
            return null;
        }, null);

        t1.resume();
        System.out.println("timsort 200000 :"+time2);

        double time3 = t1.repeat(5, () -> list, t -> {
            tim.sort(t.get(0));
            return null;
        }, t -> {
            preDataProcess(t,400000);
            return null;
        }, null);

        t1.resume();
        System.out.println("timsort 400000 :"+time3);

        double time4 = t1.repeat(5, () -> list, t -> {
            tim.sort(t.get(0));
            return null;
        }, t -> {
            preDataProcess(t,800000);
            return null;
        }, null);

        t1.resume();
        System.out.println("timsort 800000 :"+time4);

        double time5 = t1.repeat(5, () -> list, t -> {
            tim.sort(t.get(0));
            return t;
        }, t -> {
            preDataProcess(t,1000000);
            return null;
        }, null);

        t1.resume();
        System.out.println("timsort 1000000the max :"+time5 );
    }



    public  static void quicksortBenchmarkRes(){
        double time1 = t1.repeat(5, () -> list, t -> {

            quick.quicksort(t.get(0));
            return null;
        }, t -> {
            preDataProcess(t,100000);
            return null;
        }, null);

        t1.resume();
        System.out.println("quicksort 100000 :"+time1);

        double time2 = t1.repeat(5, () -> list, t -> {
            quick.quicksort(t.get(0));
            return null;
        }, t -> {
            preDataProcess(t,200000);
            return null;
        }, null);

        t1.resume();
        System.out.println("quicksort 200000 :"+time2);

        double time3 = t1.repeat(5, () -> list, t -> {
            quick.quicksort(t.get(0));
            return null;
        }, t -> {
            preDataProcess(t,400000);
            return null;
        }, null);

        t1.resume();
        System.out.println("quicksort 400000 :"+time3);

        double time4 = t1.repeat(5, () -> list, t -> {
            quick.quicksort(t.get(0));
            return null;
        }, t -> {
            preDataProcess(t,800000);
            return null;
        }, null);

        t1.resume();
        System.out.println("quicksort 800000 :"+time4);

        double time5 = t1.repeat(5, () -> list, t -> {
            quick.quicksort(t.get(0));
            return t;
        }, t -> {
            preDataProcess(t,1000000);
            return null;
        }, null);

        t1.resume();
        System.out.println("quicksort 1000000the max :"+time5 );
    }

    /**
     * msd benchmarkTest
     */
    public static void msdBenchmarkRes(){

        double time1 = t1.repeat(5, () -> list, t -> {
            msd.msdSort(t.get(0));
            return null;
        }, t -> {
            preDataProcess(t,100000);
            return null;
        }, null);

        t1.resume();
        System.out.println("msdsort 100000 :"+time1);

            double time2 = t1.repeat(5, () -> list, t -> {
                msd.msdSort(t.get(0));
                return null;
            }, t -> {
                preDataProcess(t,200000);
                return null;
            }, null);

            t1.resume();
            System.out.println("msdsort 200000 :"+time2);

            double time3 = t1.repeat(5, () -> list, t -> {
                msd.msdSort(t.get(0));
                return null;
            }, t -> {
                preDataProcess(t,400000);
                return null;
            }, null);

            t1.resume();
            System.out.println("msdsort 400000 :"+time3);

            double time4 = t1.repeat(5, () -> list, t -> {
                msd.msdSort(t.get(0));
                return null;
            }, t -> {
                preDataProcess(t,800000);
                return null;
            }, null);

            t1.resume();
            System.out.println("msdsort 800000 :"+time4);

            double time5 = t1.repeat(5, () -> list, t -> {
                msd.msdSort(t.get(0));
                return null;
            }, t -> {
                preDataProcess(t,1000000);
                return null;
            },  null
            );

            t1.resume();
            System.out.println("msdsort 1000000 the max:"+time5);


    }

    /**
     *  Data preprocessing, list.get(0) pinyinNames list.get(1)chineseNames
     *   n: Initial data interception length 初始数据截取长度
     * @param list
     * @param n
     * @return
     */
    public static ArrayList<String []> preDataProcess(ArrayList list,int n){
        String [] chineseNames = ReadTxt.getAllChineseName(n);
        list.clear();
        list.add(chineseNames);
        return list;
    }


}
