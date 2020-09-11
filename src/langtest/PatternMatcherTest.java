package langtest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/9 11:19
 */
public class PatternMatcherTest {

    public static void main(String[] args) {
        PatternMatcherTest patternMatcherTest = new PatternMatcherTest();
        patternMatcherTest.testReplace();
    }

    public void testMatch() {
        Pattern p = Pattern.compile("([a-z\\|A-Z]+)(\\d+)(\\d+[a-z|A-Z]+)");
        Matcher m = p.matcher("aA2323Aa");
        m.find();
        for (int i = 0; i <= m.groupCount(); i++) {
            System.out.println(String.format("group(%d) is %s,\t\t start(%d) is %d,\t\t end(%d) is %d",
                    i, m.group(i), i, m.start(i), i, m.end(i)));
        }
    }

    public void testReplace() {
        String s = "A man, a plan, a canal: Panama";
//        String s1 = s.replaceAll("[^a-z\\|A-Z\\|0-9]+", "");
        String s1 = s.replaceAll("[^a-zA-Z0-9]+", "");
        System.out.println(s1.equalsIgnoreCase(new StringBuilder(s1).reverse().toString()));
    }
}
