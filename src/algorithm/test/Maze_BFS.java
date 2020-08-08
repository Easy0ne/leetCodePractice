package algorithm.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wangzk
 * @date 2018-10-06 21:14
 */
public class Maze_BFS {
    //定义坐标，可用来表示节点或当前位置（状态）
    public class Pos{
        int row;
        int col;
        public Pos(int row,int col){
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null){
                return false;
            }
            if(this == obj){
                return true;
            }
            if(obj instanceof Pos){
                Pos anotherPos = (Pos) obj;
                if(anotherPos.col == this.col && anotherPos.row == this.row){
                    return true;
                }
            }
            return false;
        }
    }

    Pos pos_start;
    Pos pos_end;
    Queue<Pos> q = new LinkedList<Pos>();
    int[][] maze = {
            {0,1,0,0,0},
            {0,1,0,1,0},
            {0,0,0,0,0},
            {0,1,1,1,0},
            {0,0,0,1,0}
    };
    int height = maze.length;
    int width = maze[0].length;
    //使用二维数组pre记录每个状态的父节点，同时也可用来判断某个节点是否已被扩展(?= null)
    Pos[][] pre = new Pos[height][width];

    public Maze_BFS(){
        this.pos_start = new Pos(0,0);
        this.pos_end = new Pos(height-1 , width-1);
        for(int i=0;i<pre.length;i++){
            for(int j=0;j<pre[0].length;j++){
                pre[i][j]=null;
            }
        }
    }

    public Pos up(Pos pos_n){
        if((pos_n.row > 0) && (maze[pos_n.row-1][pos_n.col] != 1)) return new Pos(pos_n.row-1, pos_n.col);
        return pos_n;
    }

    public Pos down(Pos pos_n){
        if((pos_n.row < maze.length-1) &&(maze[pos_n.row+1][pos_n.col] !=1)) return new Pos(pos_n.row+1, pos_n.col);
        return pos_n;
    }

    public Pos left(Pos pos_n){
        if((pos_n.col > 0) &&(maze[pos_n.row][pos_n.col-1] != 1)) return new Pos(pos_n.row, pos_n.col-1);
        return pos_n;
    }

    public Pos right(Pos pos_n){
        if((pos_n.col < maze[0].length-1) && (maze[pos_n.row][pos_n.col+1] != 1)) return new Pos(pos_n.row, pos_n.col+1);
        return pos_n;
    }

    //输出走迷宫的过程（最短路径的）
    public void printPath(Pos pos){
        //Pos pos = pre[pos_end.row][pos_end.col];
        if(pos.row == pos_start.row && pos.col == pos_start.col){
            //有个坑，clone方法只能深拷贝一维数组，二维数组拷贝的是引用，也就是……会改变原数组的值
            //int[][] maze_copy = maze.clone();
            int[][] maze_copy = copyOf2d(maze);
            maze_copy[pos.row][pos.col] = 3;    //用3来表示当前位置（-1显得不对齐）
            printMazeSate(maze_copy);
            return;
        } else{
            printPath(pre[pos.row][pos.col]);
            //int[][] maze_copy = maze.clone();
            int[][] maze_copy = copyOf2d(maze);
            maze_copy[pos.row][pos.col] = 3;
            System.out.println("step");
            printMazeSate(maze_copy);
        }
    }

    //输出当前位置
    public void printMazeSate(int[][] maze){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(j == width-1) {
                    System.out.println(maze[i][j]);
                }else{
                    System.out.print(maze[i][j]+", ");
                }
            }
        }
    }

    //二维数组的深拷贝
    public static int[][] copyOf2d(int[][] source){
        int[][] target = new int[source.length][];
        for (int i = 0; i < source.length; i++) {
            target[i] = Arrays.copyOf(source[i], source[i].length);
        }
        return target;
    }


    public void BFS(){
        pre[pos_start.row][pos_start.col] = pos_start;
        q.offer(pos_start);
        while(!q.isEmpty()){
            Pos pos_n = q.poll();
            //System.out.println(pos_n.row+","+pos_n.col);
            if(pos_n.equals(this.pos_end)){
                System.out.println("found shortest path:");
                printPath(pos_n);
                return;
            }
            //移动顺序：下右上左
            Pos pos_down = this.down(pos_n);
            if(!pos_n.equals(pos_down) && pre[pos_down.row][pos_down.col]==null){
                pre[pos_down.row][pos_down.col] = pos_n;
                q.offer(pos_down);
            }
            Pos pos_right = this.right(pos_n);
            if(!pos_n.equals(pos_right) && pre[pos_right.row][pos_right.col]==null){
                pre[pos_right.row][pos_right.col] = pos_n;
                q.offer(pos_right);
            }
            Pos pos_up = this.up(pos_n);
            if(!pos_n.equals(pos_up) && pre[pos_up.row][pos_up.col]==null){
                pre[pos_up.row][pos_up.col] = pos_n;
                q.offer(pos_up);
            }
            Pos pos_left = this.left(pos_n);
            if(!pos_n.equals(pos_left) && pre[pos_left.row][pos_left.col]==null){
                pre[pos_left.row][pos_left.col] = pos_n;
                q.offer(pos_left);
            }
        }
    }

    public static void main(String[] args) {
        Maze_BFS maze_bfs = new Maze_BFS();
        maze_bfs.BFS();
    }
}
