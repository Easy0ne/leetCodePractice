package algorithm.test;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: wangzk
 * @date: 2020-05-14 23:59
 */
public class StackPopOrder {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = pushA.length;
        for (int i = 0; i < len; i++) {
            map.put(pushA[i], i);
        }
        for (int i = 0; i< len; i++) {
            int base = map.get(popA[i]);
            int idx_min = base;
            for (int j = i+1; j < len; j++) {
                int idx_j = map.get(popA[j]);
                if (idx_j < base) {
                    if (idx_j < idx_min) {
                        idx_min = idx_j;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public boolean IsPopOrderOpt(int[] pushA, int[] popA) {
        int len = pushA.length;
        if ( pushA.length == 0 || popA.length == 0) return false;
        Stack<Integer> stack = new Stack<Integer>();
        int count = 0;
        for (int i = 0; i < len; i++) {
            while (stack.empty() || popA[i] != stack.peek()) {
                if (count < len) stack.push(pushA[count++]);
                else return false;
            }
            stack.pop();
        }
        return true;
    }


    public boolean IsPopOrder_NowCoder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> s = new Stack<Integer>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for(int i = 0; i< pushA.length;i++){
            s.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            while(!s.empty() &&s.peek() == popA[popIndex]){
                //出栈
                s.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return s.empty();
    }

    @Test
    public void test(){
        int[] pushA = {1,2,3,4,5};
        int[] popA1 = {4,5,3,2,1};
        String[] strA = {"1", "2", "3", "4", "5"};
        for (int i = 0; i < 30; i++) {

//            ArrayList list = Arrays.asList(pushA);
            List<Integer> list = Arrays.stream(popA1).boxed().collect(Collectors.toList());
            Collections.shuffle(list);
            int[] shuffledPopA1 = list.stream().mapToInt(Integer::valueOf).toArray();

//            System.out.println(Arrays.asList(pushA).getClass());
            System.out.println(String.format("%s %s %s %s", Arrays.toString
                    (shuffledPopA1), IsPopOrder(pushA, shuffledPopA1), IsPopOrderOpt(pushA, shuffledPopA1), IsPopOrder_NowCoder(pushA, shuffledPopA1)));
        }
    }
}
