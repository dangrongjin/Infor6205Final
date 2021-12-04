package FinalProject.drjWorkPackage;

import FinalProject.common.ConvertToUTF8;
import FinalProject.common.PinYin4jUtils;


public class test {
    public static void main(String[] args) {

        test();

    }

    public static void test(){
        String [] s = {"姜文", "江文"};
        String [] coder = new String[s.length];
        System.out.println("原始数据--------------------------");
        for (int i = 0; i < s.length; i++) {
            coder[i] = PinYin4jUtils.hanziToPinyin(s[i])+" "+ConvertToUTF8.convertStringToUTF8(s[i]);
            System.out.println(s[i]+"  "+coder[i]);
        }
        System.out.println("原始数据--------------------------");
        System.out.println("排序顺序--------------------------");
        MSDSort.msdSort(coder,s);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]+"  "+coder[i]);
        }
        System.out.println("排序顺序--------------------------");
    }

}
