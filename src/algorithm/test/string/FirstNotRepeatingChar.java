package algorithm.test.string;
import java.util.*;

/**
 * @author wangzk
 * @date 2019-04-10 23:33
 */
public class FirstNotRepeatingChar {
    //运行时间：72ms
    //
    //占用内存：11424k
    public int myFirstNotRepeatingChar(String str){
        if(str == null || str.length() == 0) return -1;
        HashMap<Character, Integer> alphabetCountMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> alphabetPosMap = new LinkedHashMap<Character, Integer>();
        for(int i=0; i<str.length(); i++){
            Character alphabet = str.charAt(i);
            Integer count = alphabetCountMap.get(alphabet);
            if (count != null){
                count++;
                alphabetPosMap.remove(alphabet);
            }else {
                count = 1;
                alphabetPosMap.put(alphabet, i);
            }
            alphabetCountMap.put(alphabet, count);
        }
        // alphabetPosMap.forEach();
        if (!alphabetPosMap.isEmpty()){
            return alphabetPosMap.entrySet().iterator().next().getValue();
        } else{
            return -1;
        }
    }

    //运行时间：42ms
    //占用内存：9536k
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0) return -1;
        HashMap<Character, Integer> alphabetCountMap = new HashMap<Character, Integer>();
        for(int i=0; i<str.length(); i++){
            Character alphabet = str.charAt(i);
            Integer count = alphabetCountMap.get(alphabet);
            if (count != null){
                count++;
            }else {
                count = 1;
            }
            alphabetCountMap.put(alphabet, count);
        }
        for(int i=0; i<str.length(); i++){
            if(alphabetCountMap.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args){
        String s = "google";
        String s2 = "";
        String s3 = "aaabb";
        String s4 = "a";
        FirstNotRepeatingChar firstNotRepeatingChar = new FirstNotRepeatingChar();
        System.out.println(firstNotRepeatingChar.FirstNotRepeatingChar(s));
        System.out.println(firstNotRepeatingChar.FirstNotRepeatingChar(s2));
        System.out.println(firstNotRepeatingChar.FirstNotRepeatingChar(s3));
        System.out.println(firstNotRepeatingChar.FirstNotRepeatingChar(s4));


    }
}
