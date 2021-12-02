/**
 * @author: Joseph Li @ Dancincloud
 * Date: 11/9/21 11:12
 **/
package edu.neu.coe.info6205.sort.par;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class SumTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 50;

    private int start, end;

    public SumTask(int start, int end){
        super();
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute(){
        if (end - start <= THRESHOLD) {
            int result = 0;
            for (int i = start; i <= end; i++) {
                result += i;
            }
            return result;
        } else {
            int mid = (start + end) / 2;
            SumTask firstTask = new SumTask(start, mid);
            SumTask secondTask = new SumTask(mid + 1, end);
            invokeAll(firstTask,secondTask);

            return firstTask.join() + secondTask.join();
        }
    }

    public static void main(String[] args) {

        int N = 1000000;

        int result1 = 0;
        for (int i = 1; i <= N; i++) {
            result1 += i;
        }
        System.out.println("[Serial Computing] Sum{1, ..., 1000000} = " + result1);

        try {
            ForkJoinPool pool = new ForkJoinPool();
            ForkJoinTask<Integer> task = pool.submit(new SumTask(1, N));
            long result2 = task.get();
            System.out.println("[Parallel Computing] Sum{1, ..., 1000000} = " + result2);
            pool.awaitTermination(2, TimeUnit.SECONDS);
            pool.shutdown();
        }catch (Exception e){
            System.out.println("Someting went wrong");
        }

    }
}
