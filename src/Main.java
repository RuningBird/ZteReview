import java.util.Arrays;

/**
 * Created by hr on 2017/9/6.
 */
public class Main {
    public static void main(String[] args) {
        MySort ms = new MySort();
        ms.qkSort(0, ms.arr.length - 1);
        ms.showArr("排序后：");
    }
}

class MySort {
    int[] arr = {5, 4, 3, 2, 1};
//    int[] arr = {26, 53, 67, 48, 57, 13, 48, 32, 60, 50};


    /*交换类：快速排序*/
    public void qkSort(int low, int high) {
        if (low < high) {
            int pos = qkPass(low, high);
            qkSort(low, pos - 1);
            qkSort(pos + 1, high);
        }
    }

    private int qkPass(int low, int high) {
        int x = arr[low];
        while (low < high) {
            while (low < high && x < arr[high]) {
                high--;
            }

            if (low < high) {
                arr[low] = arr[high];
                low++;
            }

            while (low < high && x > arr[low]) {
                low++;
            }

            if (low < high) {
                arr[high] = arr[low];
                high--;
            }

        }
        arr[low] = x;
        return low;
    }

    /* 插入类：希尔排序
     * 是直接插入排序的改进
     */
    public void shellSort() {
        int[] delta = {5, 3, 1};
        for (int i : delta) { // 以每一个间隔d进行直接插入排序
            shellInsert(i);
        }
    }

    /*希尔排序：直接插入排序*/
    private void shellInsert(int d) {
        for (int i = d; i < arr.length; i++) { //第二个元素开始
            int temp = arr[i];
            int j = i - d; //前一个元素的下表
            // 当前位置的值temp比前一个元素的值小
            while (j >= 0 && temp < arr[j]) { //寻找插入位置,j>=0要放在前面
                arr[j + d] = arr[j];
                j = j - d;
            }
            arr[j + d] = temp;//值插入正确的位置
        }
    }

    /*希尔排序：直接插入排序*/
    private void shellInsert1(int d) {
        int temp;
        int j = 0;
        for (int i = d; i < arr.length; i++) {
            temp = arr[i];
            for (j = i - d; j >= 0; j -= d) {//i-d 前一个元素的下标，一直到第一个元素的位置
                if (temp < arr[j]) {
                    arr[j + d] = arr[j]; // 寻找插入位置
                } else {
                    break;
                }
            }
            arr[j + d] = temp;//插入到正确的位置
        }
    }

    /*交换类：冒泡排序*/
    public void bubbleSort() {
        System.out.println("排序前：" + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    public void showArr(String s) {
        System.out.println(s + Arrays.toString(arr));
    }
}
