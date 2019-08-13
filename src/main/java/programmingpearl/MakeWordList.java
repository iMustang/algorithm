package programmingpearl;

import java.util.HashSet;
import java.util.Scanner;

/**
 * title: MakeWordList
 * description: 找出输入文本中出现的所有单词
 */
public class MakeWordList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(MakeWordList.class.getResourceAsStream("/makeFileList.txt"));
        HashSet<String> set = new HashSet<>();
        while (scanner.hasNext()) {
            set.add(scanner.next());
        }
        for (String str : set) {
            System.out.println(str);
        }
    }
}