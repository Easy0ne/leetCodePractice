package lang;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
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
}
