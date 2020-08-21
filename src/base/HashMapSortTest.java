package base;

import algorithm.test.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/20 18:27
 */
public class HashMapSortTest {
    public HashMap<String, Integer> unsortedMap = new HashMap<>();

    {
        unsortedMap.put("key3", 5);
        unsortedMap.put("key2", 4);
        unsortedMap.put("key1", 3);
        unsortedMap.put("key4", 2);
        unsortedMap.put("key5", 1);
    }

    public void sortByTreeMap() {
        TreeMap<String, Integer> treeMap = new TreeMap<>(unsortedMap);
        System.out.println(treeMap);
    }

    public void sortByCollectionsSort() {
        //这种方法比较灵活，可以根据key排序，也可以根据value，结果可以只有key/value，也可以都保存
        List<HashMap.Entry<String, Integer>> listOfMap = new ArrayList<>(unsortedMap.entrySet());
        Collections.sort(listOfMap, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
        System.out.println(listOfMap);
    }

    public void sortByStreamApi() {
        //这里对key进行排序
        List<String> sortedKeyList = unsortedMap.keySet().stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        System.out.println(sortedKeyList);
    }

    public static void main(String[] args) {
        HashMapSortTest hashMapSortTest = new HashMapSortTest();
//        hashMapSortTest.sortByTreeMap();
//        hashMapSortTest.sortByCollectionsSort();
        hashMapSortTest.sortByStreamApi();
    }
}
