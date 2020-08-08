package algorithm.test;

import java.util.*;

/**
 * @author wangzk
 * @date 2018-10-13 21:30
 */
public class Cost_BFS {
    public static final int mw = 1000;
    public static int[][] Graph = {
            { 0, 4, 3,mw,mw},
            { 4, 0,mw, 4, 5},
            { 3,mw, 0, 2,mw},
            {mw, 4, 2, 0, 3},
            {mw, 5,mw, 3, 0},
    };
    int start = 0;
    int end = 4;
    public static final HashMap cityNumber = new HashMap<>();
    static{
        cityNumber.put(0,"A");
        cityNumber.put(1,"B");
        cityNumber.put(2,"C");
        cityNumber.put(3,"D");
        cityNumber.put(4,"E");
    }

    public class State{
        int node;
        int cost;
        State pre;
        State(int node, int cost, State pre){
            this.node = node;
            this.cost = cost;
            this.pre = pre;
        }

        public int getCost() {
            return this.cost;
        }

        public int getNode() {
            return node;
        }

        public void setPre(State pre) {
            this.pre = pre;
        }

        public boolean isAncestorOf(State state2){  //用于查询本节点在代价树到state2的路径上是否已经出现过了
            if(state2.pre == null) return false;
            if(this.node == 0) return true;
            while(state2.node != 0){
                if(state2.node == this.node) return true;
                else state2 = state2.pre;
            }
            return false;
        }
    }

    /*public class SortedList{
        public class StateNode{
            State state;
            StateNode next;
            public StateNode(State state) {this.state = state;}
        }
        StateNode head;
        public SortedList(){
            this.head = null;
        }
        public void insert(State state){
            StateNode node = new StateNode(state);

        }
    }*/

    public void printPath(State state){
        if(state == null || state.pre == null) return;
        Stack<State> s = new Stack<>();
        while (state.node != 0){
            s.push(state);
            state = state.pre;
        }
        s.push(new State(start,0,null));
        while(!s.empty()){
            if(s.size()==1) System.out.println(cityNumber.get(s.pop().node));
            else System.out.print(cityNumber.get(s.pop().node) + "->");
        }
    }


    public void bfsCost(){
        State s_0 = new State(start,0,null);
        //TreeSet<State> ts = new TreeSet<>((state1,state2)-> state1.cost - state2.cost);
        //Lamda表达式逆序排序
        TreeSet<State> ts = new TreeSet<State>(Comparator.comparing(State::getCost).thenComparing((State state)-> -state.getNode()));
        ts.add(s_0);
        while (!ts.isEmpty()){
            State s_n = ts.pollFirst();

            if(s_n != s_0) System.out.println(cityNumber.get(s_n.node)+"<-"+cityNumber.get(s_n.pre.node));
            if(s_n.node == end){
                System.out.println("find shortest path:");
                printPath(s_n);
                System.out.println("Shortest cost is: "+s_n.cost);
                return;
            }
            for (int i = 0; i < Graph.length; i++) {
                int cost = Graph[s_n.node][i];
                if(cost == 0 || cost == mw) continue;
                State s_n_child = new State(i, s_n.cost+cost, s_n);
                if(s_n_child.isAncestorOf(s_n)) continue;
                ts.add(s_n_child);//有个坑：TreeSet的唯一性不仅要求hash值唯一性、对象唯一性，而且还要求不能插入与已有元素等值的对象(根据所给comparator)
            }
        }
    }


    public static void main(String[] args) {
        Cost_BFS cb = new Cost_BFS();
        cb.bfsCost();
    }
}
