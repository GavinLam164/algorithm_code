package sort;

import java.util.Arrays;

public class ArrayUtils {
    // 排序测试用例执行次数
    public static int testNum = 1000;

    public static int createRandom(int base) {
        return (int)(Math.random() * base);
    }

    public static int[] createRandomArray(int length, int base) {
        int[] arr = new int[length];
        for(int i = 0; i < length; i++) {
            arr[i] = createRandom(base);
        }
        return arr;
    }

    public static void test(Sort sortImp) {
        ArrayUtils.test(sortImp, 100, 100);
    }

    public static int[] copy(int[] arr) {
        int[] ret = new int[arr.length];
        for(int i = 0; i < ret.length; i++) {
            ret[i] = arr[i];
        }
        return ret;
    }

    public static void test(Sort sortImp, int length, int base) {
        boolean isSuccess = true;
        outer: for(int i = 0; i < testNum; i++) {
            int[] arr = createRandomArray(length, base);
            int[] testArr = copy(arr);
            Arrays.sort(arr);
            sortImp.sort(testArr);
            for(int j = 0; j < arr.length; j++) {
                if(arr[j] != testArr[j]) {
                    isSuccess = false;
                    break outer;
                }
            }
        }
        System.out.println(sortImp.getName() + ": " + (isSuccess ? "success": "error"));
    }
}
