package langtest;

import org.junit.Test;

import java.util.*;
import java.util.stream.*;
/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/14 15:02
 */
/*
在小规模的集合(<10000)中，stream的效率其实不如iterator，但遍历开销基本上都小于1毫秒，即使是成倍的差距也可忽略不计；
而stream的写法要比iterator高效且易读，尤其是要进行多种操作时。
在超大规模的集合中(>1000w)，stream的遍历效率要好于iterator，但也不会好太多，parallelStream会好很多(前提时能用到多核)。

ref: https://blog.csdn.net/Al_assad/article/details/82356606
 */
class DataDemo {
    int data;
    String str;
}

public class SteamTest {

    public void testIntegerStreamMap(){
        List<Integer> itgList = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            itgList.add(random.nextInt());
        }

        //Stream
        List<Integer> streamList = itgList.stream()
                .mapToInt(x -> x)
                .map(x -> x+1)
                .filter(x -> x>200)
                .sorted()
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        //iterator
        List<Integer> iteratorList = new ArrayList<Integer>();
        for (Integer i : itgList)
            if(i+1 > 200)
                iteratorList.add(i+1);
        Collections.sort(iteratorList);

        //forEach
        List<Integer> eachList = new ArrayList<Integer>();
        iteratorList.forEach(x -> eachList.add(x+1));

        //ParallelStream
        List<Integer> parallelStreamList = itgList.parallelStream()
                .mapToInt(x -> x)
                .map(x -> x+1)
                .filter(x -> x>200)
                .sorted()
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

    }


    @Test
    public void testStringStream() {
        List<String> strList = new ArrayList<String>();
//        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            strList.add("str");
        }
        String strResult = strList.stream()
                .collect(Collectors.joining(","));
        System.out.println(strResult);

        StringBuilder sb = new StringBuilder();
        for (String str: strList)
            sb.append(str).append(",");
        String strbResult = sb.length()==0? "" : sb.substring(0, sb.length()-1);
        System.out.println(strbResult);

    }


    @Test
    public void testTransform() {

        /*
        关键在对Stream的使用上
        首先是将其接入到stream上
        数组通过Arrays.stream()
        集合(List和Set，Map得获取Set或List)直接通过.stream()

        然后是中间转的操作
        Integer到int使用mapToInt(x -> x)
        int到Integer使用boxed()

        最后是stream到终端
        导出为int[]使用.toArray();
        导出为Integer[]使用.toArray(Integer::new);
        导出为List使用.collect(Collectors.toList());
        导出为LinkedList/ArrayList使用.collect(Collectors.toCollect(ArrayList::new));
         */

        Random random = new Random();

        // IntStream to int[]
        int[] ints = random.ints(5, 0, 10)
                .toArray();

        // IntStream to Integer[]
        Integer[] integers = random.ints(5, 0, 10)
                .boxed().toArray(Integer[]::new);

        // IntStream to List<Integer>
        List<Integer> integerList = random.ints(5, 0,10)
                .boxed().collect(Collectors.toList());

        // List<Integer> to Integer[]
        Integer[] integers1 = integerList.stream()
                .toArray(Integer[]::new);

        // List<Integer> to int[]
        int[] ints1 = integerList.stream()
                .mapToInt(x -> x)
                .toArray();

        // int[] to List<Integer>
        List<Integer> integerList1 = Arrays.stream(ints)
                .boxed()
                .collect(Collectors.toList());

        // int[] to Integer[]
        Integer[] integers2 = Arrays.stream(ints)
                .boxed()
                .toArray(Integer[]::new);

        // Integer[] to List<Integer>
        List<Integer> integerList2 = Arrays.stream(integers)
                .collect(Collectors.toList());

        // Integer[] to int[]
        int[] ints2 = Arrays.stream(integers)
                .mapToInt(x -> x)
                .toArray();


        /*
        -------------------------------------------------------------------
         */
        // String to Set<Character>
        String s = "12,23,34,45,55";
        Set<Character> characterSet = s.chars()
                .mapToObj(x -> (char) x)
                .collect(Collectors.toSet());

        LinkedHashSet<Character> characterLinkedHashSet = s.chars()
                .mapToObj(x -> (char) x)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println(characterLinkedHashSet);
    }
}
