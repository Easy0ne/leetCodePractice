package algorithm.test;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangzk
 * @date 2020-02-29 22:46
 */
public class SimpleTest {

    @Test
    public void test() {
        SimpleTest simpleTest = new SimpleTest();
        int a = 011;
        char c_1 = '\u0001';
        String s = "\u0001";
        char c_a = 'a';
        char c_A = 'A';
        System.out.println(a + "\n" + c_1 + "\n" + s);
        System.out.printf("%d", (int) c_a - (int) c_A);
        for (char c = 'A'; c < 'a'; c++) {
            System.out.print(c);
        }
        simpleTest.testScanner();
    }

    @Test
    public void testSwitch() {
        int i = 1;
        switch (i) {
            case 0:
                System.out.println(0);
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
            default:
                System.out.println("de");
        }
        int a = i = 2;
        System.out.printf("%d, %d", a, i, "\n");
    }

    @Test
    public void testScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("scan beginning");
        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            System.out.printf("scan.next is  %d\n", i);
        }
        if (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            System.out.printf("scan.next is  %s \n", str);
        }
        if (scanner.hasNext()) {
            String str = scanner.next();
            System.out.printf("scan.next is %s \n", str);
        }
        StringBuilder sbd = new StringBuilder();

    }

    @Test
    public void testPP() {
        int a = 0;
        System.out.println(a++);
        System.out.println(++a);
    }

    @Test
    public void testInt() {
        float a = 1/2f;
        System.out.println(1/2);
        System.out.println((float) 1/2);
        System.out.println(a);
    }

//    public static void main(String[] args) {
////创建一个150x50，RGB高彩图，类型可自定
//        BufferedImage img = new BufferedImage(1366, 768, BufferedImage.TYPE_INT_RGB);
////取得图形
//        Graphics g = img.getGraphics();
////设置黑色
//        g.setColor(Color.BLACK);
////填充
//        g.fillRect(0, 0, img.getWidth(), img.getHeight());
////在d盘创建个文件
//        File file = new File("D:/test.png");
//        try {
////以png方式写入，可改成jpg其他图片
//            ImageIO.write(img, "PNG", file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void testIntern() {
        String s = "a1";
        String s1 = new String("a1");
        String s2 = s1.intern();
        String ss1 = "a1" + 5;
        String ss2 = 5 + "a1";

        System.out.println("s == s1 ?" + (s == s1));
        System.out.println("s1 == s2 ? " + (s1 == s2));
        System.out.println("s == s2 ? " + (s == s2));
        System.out.println(ss1);
        System.out.println(ss2);
    }

    public int rnd(int min, int max) {
        return (int) (min+Math.random()*(max-min+1));
    }

    @Test
    public void testRandom() {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<10000; i++) {
            int x = rnd(0, 2);
            if(!map.containsKey(x)) {
                map.put(x, 0);
            }
            map.put(x, map.get(x)+1);
        }
        for (Map.Entry e: map.entrySet()){
            System.out.println(e.getKey()+" "+ e.getValue());
        }
    }

    @Test
    public void testOptPriority() {
        int i = 10;
        System.out.println((float)i/3);
        System.out.println((float)(i/3) == 3);
    }

    @Test
    public void verifyMyFunc() {
        System.out.println((float)543792409/57);
        System.out.println((double)543792409/57);
        System.out.println(543792409/57);
        System.out.println(Math.sqrt(1 + 8 * 1000000000));
        System.out.println(Math.pow(2, 31));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.sqrt(1 + 8 * 4950));
        int[] arr = new int[10];
        arr[0] = 1;
        System.out.println(arr[1]);
    }

    @Test
    public void testArrayCopy() {
        int[] arr = {0,1,2,3};
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, 1)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 1, 4)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 1,1)));
    }

    @Test
    public void testArray2List() {

        int[] intArr = {1,2,3};
        Integer[] integerArr = {4,5,6};
        ArrayList<Integer> iaList;
        List<Integer> iList;
        ArrayList<Integer> iaList1 = new ArrayList<Integer>(){{add(7);add(8);add(9);}};

        // Integer[] to ArrayList
        System.out.println("Integer[] to ArrayList");
        iaList= new ArrayList<Integer>(Arrays.asList(integerArr));
        System.out.println(iaList);
        iList = Arrays.stream(integerArr).collect(Collectors.toList());
        System.out.println(iList);
        iaList = Arrays.stream(integerArr).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(iaList);


        // int[] to ArrayList
        System.out.println("int[] to ArrayList");
        iList = Arrays.stream(intArr).boxed().collect(Collectors.toList());
        System.out.println(iList);
        iaList = Arrays.stream(intArr).boxed().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(iaList);


        // List to Integer[]
        System.out.println("List to Integer[]");
        integerArr = iaList1.toArray(new Integer[iaList.size()]);
        System.out.println(Arrays.toString(integerArr));

        // List to int[]
        System.out.println("List to int[]");
        intArr = iaList1.stream().mapToInt(Integer::valueOf).toArray();
        System.out.println(Arrays.toString(intArr));

        // Integer[] to int[]
        System.out.println("Integer[] to int[]");
        intArr = Arrays.stream(integerArr).mapToInt(Integer::valueOf).toArray();
        System.out.println(Arrays.toString(intArr));

        // int[] to Integer[]
        System.out.println("int[] to Integer[]");
        integerArr = Arrays.stream(intArr).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(integerArr));
    }



}
