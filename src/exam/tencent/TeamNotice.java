package exam.tencent;

import java.util.*;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/6 20:44
 */
public class TeamNotice {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            int[][] teamPersonNos = new int[m][];
            boolean[][] isPersonTeam = new boolean[n][m];
            List<Integer> teamsWith0 = new LinkedList<>();
            for (int j = 0; j < m; j++) {
                int nOfj = cin.nextInt();
                int[] personNosOfj = new int[nOfj];
                for (int i = 0; i < nOfj; i++) {
                    int no = cin.nextInt();
                    personNosOfj[i] = no;
                    isPersonTeam[no][j] = true;
                    if (no == 0) {
                        teamsWith0.add(j);
                    }
                }
                teamPersonNos[j] = personNosOfj;
            }

            boolean[] noticed = new boolean[n];
            List<Integer> noticedPersons = new ArrayList<>();
            for (int tno: teamsWith0) {
                for (int pno: teamPersonNos[tno]) {
                    noticed[pno] = true;
                    noticedPersons.add(pno);
                }
            }
            boolean[] visitedTeam = new boolean[m];


            int temp = 0;
            int p = noticedPersons.size();
            while (true){
                boolean flag = false;
                for (int k = 0;; k++) {
                    if (k >= p) {
                        break;
                    }
                    for (int j = 0; j < m; j++) {
                        if (isPersonTeam[noticedPersons.get(k)][j] && !visitedTeam[j]) {
                            visitedTeam[j] = true;
                            flag = true;
                            for (int i = 0; i < teamPersonNos[j].length; i++) {
                                noticed[teamPersonNos[j][i]] = true;
                                noticedPersons.add(teamPersonNos[j][i]);
                                temp ++;
                                p++;
                            }
                        }
                    }
                }
                if (!flag) break;
            }


            int counter = 0;
            for (int i = 0; i < n; i++) {
                if (noticed[i]) {
                    counter++;
                }
            }
            System.out.println(counter);
        }
    }
}
