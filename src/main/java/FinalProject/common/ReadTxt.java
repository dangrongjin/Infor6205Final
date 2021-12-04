package FinalProject.common;

import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;


public class ReadTxt  {


    /**
     *  return chinese names [] according n length
     *  eg n=3 : {张三，李四，王五}
     * @param n
     * @return
     */
    public static String [] getAllChineseName(int n){
        HanyuPinyinOutputFormat outputF = new HanyuPinyinOutputFormat();

        String [] pinyinName = null;
        String [] res= null;

        try {
            Path path = Paths.get("src/main/resources/shuffledChinese.txt");
            byte[] data = Files.readAllBytes(path);
            String s = new String(data, "utf-8");
            pinyinName = s.split("\\r?\\n");
            if (n> pinyinName.length){
                n= pinyinName.length;
            }
            res = new String[n];
            res = new String[n];
            for (int i = 0; i < n; i++) {
                res[i] = pinyinName[i];
            }

        }
        catch (IOException e){

        }


        return res;

    }


    /**
     *  return chinese names to pinyin [] according n length
     *  eg n=3 : {zhang1 san1,li3 si4，wang2 wu3}
     * @param n
     * @return
     */
    public static  String [] getAllChineseNameToPinyin(int n)  {


        //1.创建一个格式化输出对象
        HanyuPinyinOutputFormat outputF = new HanyuPinyinOutputFormat();
        //2.设置好格式

        String [] pinyinName = null;
        String [] res= null;
        try {
            Path path = Paths.get("src/main/resources/shuffledChinese.txt");
            byte[] data = Files.readAllBytes(path);
            String result = new String(data, "utf-8");
            String s = PinYin4jUtils.hanziToPinyin(result);
            pinyinName = s.split("\\r?\\n");
            if (n> pinyinName.length){
                n= pinyinName.length;
            }
            res = new String[n];
            for (int i = 0; i < n; i++) {
                res[i] = pinyinName[i];
            }
        }


        catch (IOException e){

        }


        return res;


    }

    public static void main(String[] args) throws IOException {

        String [] s = getAllChineseNameToPinyin(10000000);
//        System.out.println(s[0]);
//        System.out.println(s.length);
        Arrays.stream(s).forEach(System.out::println);

       


    }
}
