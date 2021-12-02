package edu.neu.coe.info6205.util;

import edu.neu.coe.info6205.sort.elementary.InsertionSort;


public class TestBenchMark {



    public static void main(String[] args) {
        TestSortInBenchmrk createArray = new TestSortInBenchmrk();
        InsertionSort ins = new InsertionSort();
        final Comparable[]  zzz = new Comparable[5000];





            Timer t1 = new Timer();



            double time4 = t1.repeat(10, () -> zzz, t -> {
                ins.sort(t, 0,t.length);
                return null;
            }, t -> {
                randomArray(t);
                return null;
            }, null);

            t1.resume();

        }


    public static Comparable[] randomArray(Comparable[] c){

        for (int i = 0; i < c.length; i++) {
            c[i] = ((int)  (Math.random()*20000)) ;
        }
        return c;
    }



}
