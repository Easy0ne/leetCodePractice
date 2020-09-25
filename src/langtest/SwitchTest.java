package langtest;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/24 10:02
 */
public class SwitchTest {

    public static void main(String[] args) {
        SwitchTest switchTest = new SwitchTest();
        switchTest.defaultTest(0);
        System.out.println();
        switchTest.defaultTest(5);
    }

    public void defaultTest(int i) {
        switch (i) {

            case 0:
                System.out.println(0);  //没有break语句的话，会一直向下执行(不再判断case)，直到遇到break或switch结束
            default:                    //先匹配其他case，其他case都没有匹配上，则从default开始顺序执行
                System.out.println(10);
            case 1:
                System.out.println(1);
//                break;
            case 2:
                System.out.println(2);
//                break;

        }
    }
}
