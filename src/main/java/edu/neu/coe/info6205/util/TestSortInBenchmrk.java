package edu.neu.coe.info6205.util;

import edu.neu.coe.info6205.sort.elementary.InsertionSort;


public class TestSortInBenchmrk {


    public static void main(String[] args) {
        TestSortInBenchmrk createArray = new TestSortInBenchmrk();
        InsertionSort ins = new InsertionSort();
        final int zzz = 20;
        boolean warmFlag = true;


        for (int i = 80000; i <80001 ; i=i*2) {


            Comparable[] array1 = createArray.orderArray(i);
            Comparable[] array2 = createArray.reOrderArray(i);
            Comparable[] array3 = createArray.partOrderArray(i);
            Comparable[] array4 = createArray.randomArray(i);


            Timer t1 = new Timer();


            double time1 = t1.repeat(5, () -> zzz, t -> {
                        ins.sort(array1, 0, array1.length - 1);
                        return null;
                    },
                    (null),
                    (null)
            );
            System.out.println("length :" +i+ ","+"order"+" time :" +time1);

            t1.resume();


            double time2 = t1.repeat(5, () -> zzz, t -> {
                        ins.sort(array2, 0, array2.length - 1);
                        return null;
                    },
                    (null),
                    (null)
            );
            System.out.println("length :" +i+ ","+"reOrder"+" time :" +time2);


            t1.resume();
            double time3 = t1.repeat(5, () -> zzz, t -> {
                        ins.sort(array3, 0, array3.length - 1);
                        return null;
                    },
                    (null),
                    (null)
            );
            System.out.println("length :" +i+ ","+"partOrder"+" time :" +time3);

            t1.resume();

            double time4 = t1.repeat(5, () -> zzz, t -> {
                        ins.sort(array4, 0, array4.length - 1);
                        return null;
                    },
                    (null),
                    (null)
            );
            System.out.println("length :" +i+ ","+"random"+" time :" +time4);
            t1.resume();




        }




    }







    public  static Comparable[] orderArray(int n){
        Comparable[] arrayList = new Comparable[n];
        for (int i = 0; i < n; i++) {
            arrayList[i] = i;
        }
        return arrayList;
    }

    public static Comparable[]  reOrderArray(int n){
        Comparable[] arrayList = new Comparable[n];
        for (int i = 0; i < n; i++) {
            arrayList[i] = n-i-1;
        }
        return arrayList;
    }


    public static Comparable[]  partOrderArray(int n){
        Comparable[] arrayList = new Comparable[n];
        for (int i = 0; i < n/2; i++) {
            arrayList[i] = i;
        }
        for (int i = n/2; i < n; i++) {
            arrayList[i] = ((int) (Math.random()*20000));
        }

        return arrayList;
    }

    public static Comparable[] randomArray(int n){
        Comparable[] arrayList = new Comparable[n];
        for (int i = 0; i < n; i++) {
            arrayList[i] = ((int)  (Math.random()*20000)) ;
        }
        return arrayList;
    }



}
