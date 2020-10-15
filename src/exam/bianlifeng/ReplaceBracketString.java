package exam.bianlifeng;

import java.util.*;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/10/10 19:27
 */
public class ReplaceBracketString {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String template = cin.nextLine();
            int n = cin.nextInt();
            cin.nextLine();
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String line = cin.nextLine();
                String[] strs = line.split("->");
                map.put(strs[0], strs[1]);
            }
            Stack<int[]> stack = new Stack<>();
//            Stack<int[]> stack1 = new Stack<>();
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < template.length(); i++) {
                if (template.charAt(i) == '{' && template.charAt(i+1) == '{') {
                    stack.push(new int[]{i, -1});
                }
                if (template.charAt(i) == '}' && template.charAt(i+1) == '}' && !stack.isEmpty()) {
                    int[] temp = stack.pop();
                    temp[1] = i;
                    list.add(temp);
                }
            }

            boolean[] flags = new boolean[list.size()];
            for (int i = list.size()-1; i >= 0; i--) {
                if (map.containsKey(template.substring(list.get(i)[0]+2, list.get(i)[1]))) {
                    flags[i] = true;
                }
            }
            int end = 0;
            for (int i = 0; i < list.size(); i++) {
                if (flags[i] && list.get(i)[0] >= end) {
                    end = list.get(i)[1];
                    String target = template.substring(list.get(i)[0]+2, list.get(i)[1]);
                    StringBuilder sb = new StringBuilder(target);
                    sb.insert(0, "{{").append("}}");
                    template = template.replace(sb, map.get(target));
                }
            }

            StringBuilder templateBuilder = new StringBuilder(template);
            for (int i = 0; i < list.size(); i++) {
                if (!flags[i] && template.charAt(list.get(i)[0]) == '{' && list.get(i)[1] > list.get(i)[0]+2) {
                    int start1 = list.get(i)[0], start2 = list.get(i)[1];
                    templateBuilder.replace(start1, start1+2, "");
                    templateBuilder.replace(start2-2, start2+2-2, "");
                }

            }

            System.out.println(templateBuilder);
        }
    }
}
