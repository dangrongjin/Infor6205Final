import FinalProject.sortWithAux.LSD;
import FinalProject.sortWithAux.timSort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class lsdTest {


    /**
     * first according to the English alphabetical order
     * second  if english are same, according to tone
     * third   if both english and tone are same, according unf-8 order
     */
    @Test
    public void test1(){
        String [] input = {"王五", "李四","张三"};
        String [] except = {"李四", "王五","张三"};
        LSD.sort(input);
        assertArrayEquals(input, except);
    }
    @Test
    public void test2(){
        String [] input = {"王鑫", "王欣","王新"};
        String [] except = {"王新", "王欣","王鑫"};
        LSD.sort(input);
        assertArrayEquals(input, except);
    }


    @Test
    public void test3(){
        String [] input = {"李云", "张云","江云"};
        String [] except = {"江云", "李云","张云"};
        LSD.sort(input);
        assertArrayEquals(input, except);
    }


    // 音调不同
    @Test
    public void test4(){
        String [] input = {"姜问", "姜文"};
        String [] except = {"姜文", "姜问"};
        LSD.sort(input);
        assertArrayEquals(input, except);
    }

    @Test
    public void test5(){
        String [] input = {"苗星人", "妙星人","喵星人","秒星人"};
        String [] except = {"喵星人", "苗星人","秒星人","妙星人"};
        LSD.sort(input);
        assertArrayEquals(input, except);
    }


    @Test
    public void test6(){
        String [] input ={"江文", "姜文"};
        String [] except =  {"姜文", "江文"};
        LSD.sort(input);
        assertArrayEquals(input, except);
    }


    @Test
    public void test7(){
        String [] input ={"李新", "李溪","李兴"};
        String [] except =  {"李溪", "李新","李兴"};
        LSD.sort(input);
        assertArrayEquals(input, except);
    }

    @Test
    public void test8(){
        String [] input ={"王慈", "王得","王啊","王波"};
        String [] except =  {"王啊", "王波","王慈","王得"};
        LSD.sort(input);
        assertArrayEquals(input, except);
    }

    @Test
    public void test9(){
        String [] input ={"王汪汪", "王啊得","王啊啊","王啊"};
        String [] except =  {"王啊", "王啊啊","王啊得","王汪汪"};
        LSD.sort(input);
        assertArrayEquals(input, except);
    }
    @Test
    public void test10(){
        String [] input  ={"刘持平", "洪文胜","樊辉辉","苏会敏","高民政","曹玉德","袁继鹏","舒冬梅","杨腊香","许凤山","王广风","黄锡鸿"};
        String [] except ={"曹玉德", "樊辉辉","高民政","洪文胜","黄锡鸿","刘持平","舒冬梅","苏会敏","王广风","许凤山","杨腊香","袁继鹏"};
        LSD.sort(input);
        assertArrayEquals(input, except);
    }
}
