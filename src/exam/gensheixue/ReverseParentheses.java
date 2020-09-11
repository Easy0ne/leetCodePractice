package exam.gensheixue;

/**
 * @description:
 * @author: wangzk
 * @date: 2020-08-07 20:07
 */
class solution {
    public String reverseParentheses(String s) {
        return reverseParenthesesHelper(s, 0, s.length());
    }

    public String reverseParenthesesHelper(String s, int start, int end) {
        String subString = s.substring(start, end+1);
        int count = 0;
        for (int i = 0; i < subString.length(); i++) {
            if (subString.charAt(i) == '(') {
                count += 1;
            }
        }
        if (subString.startsWith("(") && subString.endsWith(")") && count == 1) {
            return null;
        }
        return null;
    }
}

public class ReverseParentheses {

}
