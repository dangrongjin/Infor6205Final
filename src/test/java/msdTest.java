
import FinalProject.sortWithAux.MSDSort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


public class msdTest {


        // 1 姓不同 名不同 不同又分为音不同， 音调同，字不同
            // 11完完全全不同
        @Test
        public void test11(){
                String [] input = {"王五", "李四","张三"};
                String [] except = {"李四", "王五","张三"};
                MSDSort.msdSort(input);
                assertArrayEquals(input, except);
        }
            //12 音调不同
        @Test
        public void test12(){
                String [] input = {"姜问", "姜文"};
                String [] except = {"姜文", "姜问"};
                MSDSort.msdSort(input);
                assertArrayEquals(input, except);
        }
          //12 音调不同
        @Test
        public void test13(){
                String [] input = {"苗星人", "妙星人","喵星人","秒星人"};
                String [] except = {"喵星人", "苗星人","秒星人","妙星人"};
                MSDSort.msdSort(input);
                assertArrayEquals(input, except);
        }


        //12 音调同，按照utf-8顺序
        @Test
        public void test14(){
                String [] input ={"江文", "姜文"};
                String [] except =  {"姜文", "江文"};
                MSDSort.msdSort(input);
                assertArrayEquals(input, except);
        }

        //21 姓同 名不同
        @Test
        public void test21(){
                String [] input ={"江文", "姜文"};
                String [] except =  {"姜文", "江文"};
                MSDSort.msdSort(input);
                assertArrayEquals(input, except);
        }



}
