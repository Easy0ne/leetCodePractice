package algorithm.test;

/**
 * @author wangzk
 * @date 2018-07-24 14:41
 */
public class FindNumInSortedArray {
    public boolean Find(int target, int [][] array){
        if(array == null || array.length == 0){
            return false;
        }
        int rows = array.length;
        int cols = array[0].length;

        //attention! when rows==1 & clos==0, the array is not null
        if(cols == 0){
            return false;
        }
        int maxRow = rows-1;
        int maxCol = cols-1;
        int minRow = 0;
        int minCol = 0;
        if(array[rows-1][cols-1] <target || array[0][0] > target){
            return false;
        }

        //find the maxCol and maxRow
        for(int i=0; i<cols-1; i++){
            if( array[0][i] == target){
                return true;
            }
            if(array[0][i+1] > target){
                maxCol = i;
                break;
            }
        }
        for(int j=0; j<rows-1; j++){
            if(array[j][0] == target){
                return true;
            }
            if(array[j+1][0] > target){
                maxRow = j;
                break;
            }
        }
        if(array[maxRow][maxCol] < target){
            return false;
        }

        //find the minRow and minCol
        for(int p=maxCol; p>0; p--){
            if(array[maxRow][p] == target){
                return true;
            }
            if(array[maxRow][p-1] < target){
                minCol = p;
                break;
            }
        }
        for(int q=maxRow; q>0; q--){
            if(array[q][maxCol] == target){
                return true;
            }
            if(array[q-1][maxCol] < target){
                minRow = q;
                break;
            }
        }
        if(array[minRow][minCol] > target ){
            return false;
        }
        for(int i=minRow; i<=maxRow; i++){
            for(int j=minCol; j<=maxCol; j++){
                if(array[i][j] == target){
                    return true;
                }
            }
        }

        return false;
    }
}
