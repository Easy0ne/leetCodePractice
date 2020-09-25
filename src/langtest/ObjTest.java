package langtest;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/12 20:26
 */
public class ObjTest {

    public static void main(String[] args) {
        Integer integer = 5;
        ObjTest objTest = new ObjTest();
        objTest.changeInteger(integer);
        System.out.println(integer);

        int[] arr = {5};
        objTest.changeArr(arr);
        System.out.println(arr[0]);

    }

    public void changeInteger(Integer integer) {
        integer = 6;
    }

    public void changeArr(int[] arr) {
        arr[0] += 1;
    }
}
