package exam.fiveight;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/14 21:16
 */
public class FirstMissingPositive {

    public int firstMissingPositive (int[] nums) {
        // write code here
        int maxN = 10000000;
        boolean[] visited = new boolean[maxN];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                visited[i] = true;
            }
        }
        for (int i = 1; i < maxN; i++) {
            if (!visited[i]) {
                return i;
            }
        }
        return maxN;
    }
}
