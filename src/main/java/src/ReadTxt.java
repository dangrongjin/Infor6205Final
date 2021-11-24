package src;

import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;


public class ReadTxt  {


    /**
     *
     * @return 以数组的形式返回所有名字的拼音
     * @throws IOException
     */
    public static  String [] getAllChineseName()  {


        //1.创建一个格式化输出对象
        HanyuPinyinOutputFormat outputF = new HanyuPinyinOutputFormat();
        //2.设置好格式
        outputF.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        outputF.setCaseType(HanyuPinyinCaseType.LOWERCASE);

        String [] pinyinName = null;

        try {

            Path path = Paths.get("src/main/resources/shuffledChinese.txt");
            byte[] data = Files.readAllBytes(path);
            String result = new String(data, "utf-8");
            String s = PinYin4jUtils.hanziToPinyin(result);
            pinyinName = s.split("\\r?\\n");
        }


        catch (IOException e){

        }


        return pinyinName;


    }

    public static void main(String[] args) throws IOException {

        String [] s = getAllChineseName();
        System.out.println(s[0]);

        Arrays.stream(s).forEach(System.out::println);

       
//        Path path = Paths.get("src/main/resources/shuffledChinese.txt");
//        byte[] data = Files.readAllBytes(path);
//        String result = new String(data, "utf-8");
//        String [] pinyinName = result.split("\\r?\\n");
//        for (int i = 0; i < pinyinName.length; i++) {
//            System.out.println(pinyinName[i]);
//        }
       // Arrays.stream(pinyinName).forEach(System.out::println);

    }
}
