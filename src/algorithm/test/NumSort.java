package algorithm.test;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wangzk
 * @date 2020-03-07 10:58
 */
public class NumSort {
    /*
    * 注意 交换可能会破坏稳定性
    * 冒泡、选择、快排都用到了交换，但冒泡不会破坏稳定性
    * 希尔排序的不稳定不是交换造成的，而是多个子数组内的插入排序造成的。
    * */
    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i=n-1; i>0; i--) {
            boolean flag = false;
            for (int j=0; j<=i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if (flag) break;
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        int maxIdx = 0, n = arr.length;
        for (int i=n-1; i>0; i--){
            maxIdx = 0;
            for (int j=1; j<=i; j++){
                if (arr[j] > arr[maxIdx]) maxIdx = j;
            }
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        int n = arr.length;
        for (int i=1; i<n; i++) {
            int valueI = arr[i];
            int insertIdx = i;
            for (int j=i-1; j>=0 && arr[j]>valueI; j--) {
                    arr[j+1] = arr[j];
                    insertIdx --;
            }
            arr[insertIdx] = valueI;
        }
        return arr;
    }

    public static int[] shellSort(int[] arr) {
        int n = arr.length;
        int h = 1;
        while (h < n/3) h = h*3 +1;
        while (h>0) {
            for (int i=h; i<n; i++) {
                int valueI = arr[i];
                int shellIdx = i;
                for (int j=i-h; j>=0 && arr[j]>valueI; j-=h) {
                    arr[j+h] = arr[j];
                    shellIdx -= h;
                }
                arr[shellIdx] = valueI;
            }
            h = (h-1)/3;
        }
        return arr;
    }


    public static int[] mergeSort(int[] arr) {
        int n = arr.length;
        int[] workSpace = new int[n];
        recMergeSort(arr, 0, n-1, workSpace);
        return arr;
    }


    public static void recMergeSort(int[] arr, int left, int right, int[] workSpace) {
        if (left<right) {
            int mid = (left+right)/2;
            recMergeSort(arr, left, mid, workSpace);
            recMergeSort(arr, mid+1, right, workSpace);
            merge(arr, left, mid, right, workSpace);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] workSpace) {
        int leftPtr=left, rightPtr=mid+1, size=right-left+1, j=0;
        while (leftPtr <= mid && rightPtr <=right) {
            if (arr[leftPtr] < arr[rightPtr]) workSpace[j++] = arr[leftPtr++];
            else workSpace[j++] = arr[rightPtr++];
        }
        while (leftPtr <= mid) workSpace[j++] = arr[leftPtr++];
        while (rightPtr <= right) workSpace[j++] = arr[rightPtr++];
        for (int i=0; i<size; i++) arr[left+i] =workSpace[i];
//        System.out.println("workSpace: " + Arrays.toString(workSpace));
//        System.out.println(Arrays.toString(arr));
    }


    /*
    * 快速排序
    *
    * */
    public static int[] quickSort(int[] arr) {
        int n = arr.length;
        recQuickSort(arr, 0, n-1);
        return arr;
    }

    public static void recQuickSort(int[] arr, int left, int right) {
        if (right-left >1) {
            int pivotIdx = partition(arr, left, right);
            recQuickSort(arr, left, pivotIdx - 1);
            recQuickSort(arr, pivotIdx + 1, right);
        } else if (arr[left] > arr[right])  swap(arr, left, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int midIdx = (left+right)/2;
        int pivotIdx, pivot;
        if ((arr[left]-arr[right]) * (arr[left]-arr[midIdx]) < 0) pivotIdx = left;
        else pivotIdx = (arr[right]-arr[left]) * (arr[right]-arr[midIdx]) < 0 ? right : midIdx;
        pivot=arr[pivotIdx];
        System.out.println("pivotIdx :" + pivotIdx + "\t pivot:" + pivot);
        swap(arr, pivotIdx, right);
        System.out.println("pivot on right :"+ Arrays.toString(arr));
        int leftPtr=left, rightPtr=right-1;
//        while (leftPtr<rightPtr) {
//            while (arr[leftPtr] < pivot) leftPtr++;
//            while (arr[rightPtr] > pivot) rightPtr--;
//            swap(arr, leftPtr, rightPtr);
//        }
        while (true) {
            while (arr[leftPtr] < pivot) leftPtr++;
            while (arr[rightPtr] > pivot) rightPtr--;
            if (leftPtr >= rightPtr) break;
            swap(arr, leftPtr, rightPtr);
        }
        swap(arr, leftPtr, right);
        System.out.println("after partition :"+ Arrays.toString(arr));
        return leftPtr;
    }

    /*
    堆排序
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = ((n - 2) >> 1); i >= 0; i--) {
            maxHeapify(arr, i, n - 1);
        }
        for (int j = n - 1; j >= 0; j--) {
            swap(arr, 0, j);
            maxHeapify(arr, 0, j - 1);
        }
    }

    private static void maxHeapify(int[] arr, int sIdx, int eIdx) {    //在sIdx后的节点(以其为根)满足堆性质的基础上，构建以节点sIdx为根的子堆
        int maxIdx = sIdx, lIdx = sIdx * 2 + 1, rIdx = sIdx * 2 + 2;
        if (lIdx <= eIdx && arr[lIdx] > arr[maxIdx]) maxIdx = lIdx;
        if (rIdx <= eIdx && arr[rIdx] > arr[maxIdx]) maxIdx = rIdx;
        if (maxIdx != sIdx) {
            swap(arr, sIdx, maxIdx);
            maxHeapify(arr, maxIdx, eIdx);
        }
    }




    public static void main(String[] args) {
        int[] arr = {3, 4, 15, 36, 26, 27, 4, 2, 19, 48, 44};
        int[] arr4Merge = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
//        System.out.println(Arrays.toString(bubbleSort(arr)));
//        System.out.println(Arrays.toString(selectionSort(arr)));
//        System.out.println(Arrays.toString(insertionSort(arr)));
//        System.out.println(Arrays.toString(shellSort(arr)));
//        System.out.println(Arrays.toString(mergeSort(arr4Merge)));
        System.out.println(Arrays.toString(quickSort(arr4Merge)));
    }

    @Test
    public void test() {
        int[] arr ={3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
