import java.util.Arrays;

/**
 * Created by hr on 2017/9/6.
 */
public class Main {
    public static void main(String[] args) {
        bubbleSort();
    }

    public static void bubbleSort() {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println("排序前：" + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        System.out.println("排序后：" + Arrays.toString(arr));
    }
}
