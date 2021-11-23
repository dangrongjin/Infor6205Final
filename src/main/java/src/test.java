package src;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.Arrays;

public class test {


        public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
            //1.创建一个格式化输出对象
            HanyuPinyinOutputFormat outputF = new HanyuPinyinOutputFormat();
            //2.设置好格式
            outputF.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
            outputF.setCaseType(HanyuPinyinCaseType.LOWERCASE);
            char ch='间';
            String str[] = PinyinHelper.toHanyuPinyinStringArray(ch);
            //3.打印输出
            System.out.println(Arrays.toString(str));
            //结果为:[jian, jian],因为间有多音,但是我们选择的音调类型是WITHOUT_TONE,所以拼音数组后面也没有对应音调数字

            String s = PinYin4jUtils.hanziToPinyin("王羲之");
            System.out.println(s);

        }
    }

