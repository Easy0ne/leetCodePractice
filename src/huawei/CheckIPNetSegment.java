package huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/27 10:51
 */
public class CheckIPNetSegment {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String mask = cin.nextLine();
            String ip1 = cin.nextLine();
            String ip2 = cin.nextLine();
            System.out.println(checkNetSegment(mask, ip1, ip2));
        }
    }

    public static int checkNetSegment(String mask, String ip1, String ip2)
    {
        int[] maskNums, ip1Nums, ip2Nums;
        try {
            maskNums = checkIllegalMask(mask);
            ip1Nums = checkIllegalIP(ip1);
            ip2Nums = checkIllegalIP(ip2);
            if (maskNums == null || ip1Nums == null || ip2Nums == null) {
                return 1;
            }
        } catch (NumberFormatException e) {
            return 1;
        }

        int[] netAddr1 = new int[4];
        int[] netAddr2 = new int[4];
        for (int i = 0; i <= maskNums[4]; i++) {
            netAddr1[i] = (ip1Nums[i]&maskNums[i]);
            netAddr2[i] = (ip2Nums[i]&maskNums[i]);
            if (netAddr1[i] != netAddr2[i]){
                return 2;
            }
        }
        return 0;
    }

    public static int[] checkIllegalMask(String mask) throws NumberFormatException {
        String[] maskSegs = mask.split("\\.");
        if (maskSegs.length != 4) return null;
        int[] maskSegNums = new int[5];
        boolean flag_last_num = false;
        for (int i = 0; i < 4; i++) {
            maskSegNums[i] = Integer.valueOf(maskSegs[i]);
            int num = maskSegNums[i];
            if (num != 255){
                if (flag_last_num && num != 0) {
                    return null;
                }
                flag_last_num = true;
                maskSegNums[4] = i;
                boolean flag_last_num1 = false;
                for (int j = 0; j < 8; j++) {
                    if ((num&1) == 1) {
                        flag_last_num1 = true;
                    } else {
                        if (flag_last_num1)
                            return null;
                    }
                    num = num>>1;
                }
            }
        }
        return maskSegNums;
    }


    public static int[] checkIllegalIP(String ip) throws NumberFormatException {
        String[] ipSegs = ip.split("\\.");
        if(ipSegs.length != 4) return null;
        int[] ipSegNums = new int[4];
        for (int i = 0; i < 4; i++) {
            ipSegNums[i] = Integer.valueOf(ipSegs[i]);
            if(ipSegNums[i] > 255 || ipSegNums[i] < 0)
                return null;
        }
        return ipSegNums;
    }
}
