package src.Benchmark;
import src.ConvertToUTF8;
import src.MSDSort;
import src.ReadTxt;

import java.util.ArrayList;


public class MSDBenchmarkTest {

    public static void main(String[] args) {

        MSDSort me = new MSDSort();
        ArrayList<String []> list  = new ArrayList<>();





        Timer t1 = new Timer();



        double time1 = t1.repeat(10, () -> list, t -> {
            me.msdSort(t.get(0),t.get(1));
            return null;
        }, t -> {
            preDataProcess(t);
            return null;
        }, null);

        t1.resume();
        System.out.println(time1);

    }


    public static ArrayList<String []> preDataProcess(ArrayList list){
        String [] pinyinNames = ReadTxt.getAllChineseNameToPinyin();
        String [] chineseNames = ReadTxt.getAllChineseName();
        for(int i=0;i<pinyinNames.length;i++){
            pinyinNames[i]+= ConvertToUTF8.convertStringToUTF8(chineseNames[i]);
        }
        list.add(pinyinNames);
        list.add(chineseNames);
        return list;
    }



}



