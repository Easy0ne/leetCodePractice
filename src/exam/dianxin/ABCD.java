package exam.dianxin;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/10/15 19:12
 */
public class ABCD {

    public static void main(String[] args) {
        for (int i = 1000; i <= 8888; i++) {
            func2(i);
        }
    }

    public static void func2(int num) {
        int temp = num;
        int[] nums = new int[4];
        for (int i = 3; i >= 0; i--) {
            nums[i] = temp % 10;
            temp /= 10;
        }
        int num2 = 1000 * nums[1] + 100 * nums[2] + 10 * nums[3] + nums[0];
        if (num < 1000 || num2 < 1000) return;
        if (num + num2 == 8888 && num != num2) {
            System.out.println(nums[0] + " " + nums[1] + " " + nums[2] + " " + nums[3]);
        }
    }

    public static void func1() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        int num1 = 1000 * i + 100 * j + 10 * k + l;
                        int num2 = 1000 * j + 100 * k + 10 * l + i;
                        if ((i!=j || j!=k || k!=l || l!=i) && num1+num2 == 8888) {
                            System.out.println(i + " " + j + " " + k + " " + l);
                        }
                    }
                }
            }

        }
    }


}
