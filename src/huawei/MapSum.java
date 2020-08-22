package huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @description: HJ8 合并表记录
 * @author: wangzk
 * @date: 2020/8/22 10:09
 */
public class MapSum {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            if (n <= 0) continue;
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int key = cin.nextInt();
                int value = cin.nextInt();
                if(hashMap.containsKey(key)) {
                    hashMap.put(key, hashMap.get(key) + value);
                } else {
                    hashMap.put(key, value);
                }
            }
            TreeMap<Integer, Integer> treeMap = new TreeMap<>(hashMap);
            for(Map.Entry<Integer, Integer> entry: treeMap.entrySet())
                System.out.println(entry.getKey() + " " + entry.getValue());

        }
    }
}
