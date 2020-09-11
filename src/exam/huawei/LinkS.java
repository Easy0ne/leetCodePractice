package exam.huawei;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/2 20:22
 */
public class LinkS {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String s0 = cin.nextLine();
            String[] strings = s0.split(",");
            int n = Integer.valueOf(strings[0]);
            int m = Integer.valueOf(strings[1]);
            char[][] chars = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = cin.nextLine();
                chars[i] = s.toCharArray();
            }

            List<List<List<Integer>>> linkSs = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (chars[i][j] == 'S') {
                        List<Integer> pos = new ArrayList<>(2);
                        pos.add(i);
                        pos.add(j);
                        boolean seen = false;
                        for(List<List<Integer>> linkS : linkSs) {
                            if(linkS.contains(pos)) {
                                seen = true;
                            }
                        }
                        if (seen) break;
                        List<List<Integer>> newLinkS = new LinkedList<>();
                        linkS(chars, i, j, newLinkS);
                        linkSs.add(newLinkS);
                    }
                }
            }
            System.out.println(linkSs.size());
        }
    }

    public static void linkS(char[][] chars, int i, int j, List<List<Integer>> linkS) {
        List<Integer> pos = new ArrayList<>(2);
        pos.add(i); pos.add(j);
        linkS.add(pos);
        if (j+1 < chars[0].length && chars[i][j+1] == 'S') {
            linkS(chars, i, j+1, linkS);
        }
        if (i+1 < chars.length && chars[i+1][j] == 'S') {
            linkS(chars, i+1, j, linkS);
        }
    }
}
