package src;

import java.nio.charset.StandardCharsets;

public class ConvertToUTF {

    public static void main(String[] args) {
        char c1 = '啊';
        char c2 = '波';
        System.out.println(Character.toString(c1).getBytes(StandardCharsets.UTF_8));
        System.out.println(Character.toString(c2).getBytes(StandardCharsets.UTF_8));
    }
}
