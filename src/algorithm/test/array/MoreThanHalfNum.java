package algorithm.test.array;

import org.junit.Test;

import java.util.HashMap;

/**
 * @description:
 * @author: wangzk
 * @date: 2020-07-22 15:19
 */

/*
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) return 0;
        int n = array.length;
        if (n == 1) {       //注意n==1时，进不了下面的if判断
            return array[0];
        }
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for(int num: array) {
            if (countMap.containsKey(num)){
                countMap.put(num, countMap.get(num)+1);
                if (countMap.get(num) > n/2) return num;
            } else {
                countMap.put(num, 1);
            }
        }
        return 0;
//        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(countMap.entrySet());
////        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
////            @Override
////            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
////                return o1.getValue() - o2.getValue();
////            }
////        });
//        //前面的数减后面的数是负数为升序，正数为降序。
//        Collections.sort(entryList, (o1, o2) -> o2.getValue() - o1.getValue());
//        System.out.println(entryList.get(0));
//        return entryList.get(0).getKey();
    }

    @Test
    public void testMoreThanHalfNum() {
        int[] arr = {1,2,3,2,2,2,5,4,2};
        int[] arr2 = {1,1,2,2,1,1,3};
        System.out.println(MoreThanHalfNum_Solution(arr));
    }
}
