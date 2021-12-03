package FinalProject.msdSortPlus;

import FinalProject.PinYin4jUtils;

import java.util.HashMap;

public class test {
    public static void main(String[] args) {
//        HashMap<String, Object> map = new HashMap<>();
//        HashMap<String, Object> map111 = new HashMap<>();
//        map.put("123",map111);
//        map.put("123",map111);
//        map.put("123",map111);
//        map.put("123",map111);
//        map.put("123",map111);

        char a='姚';
        System.out.println(PinYin4jUtils.charToPinyin(a,false,"/n"));
    }
}
