package programmingpearl.str;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * title: MakeWordCount
 * description: 统计输入中的单词个数
 */
public class MakeWordCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(MakeWordList.class.getResourceAsStream("/makeFileList.txt"));
        HashMap<String, Integer> map = new HashMap<>();
        String key;
        while (scanner.hasNext()) {
            key = scanner.next();
            map.put(key, map.get(key) == null ? 1 : map.get(key) + 1);
        }
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}