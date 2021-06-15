package sort;

public class QuickBase {

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int[] base(int[] arr, int K) {
        // l 表示 [0,l]为元素值小于K的区域
        // r 表示 [r,arr.length - 1]为元素值大于K的区域
        // i 表示 当前遍历的元素下标
        int l = -1, r = arr.length, i = 0;
        while(i < r) { // 当前遍历的元素下标碰到了元素值大于K的区域，表示区域划分结束
            if(arr[i] < K) {
                swap(arr, ++l, i);
                i++; // [0,i]的元素我们已经遍历过了，所以`i++`
            }else if(arr[i] > K) {
                swap(arr, --r, i);
                // 交换后的arr[i]我们没有判断，所以i不可以加1
            }else {
                i++; // 元素值arr[i] == K，直接i++跳过即可
            }
        }
        // 区域划分结束
        // [0,l]为元素值小于K的区域
        // [r,arr.length - 1]为元素值大于K的区域
        // [l+1,r-1]为元素值等于K的区域，若区域交错则证明数组arr中没有等于K的元素值
        return new int[] {
                l + 1,
                r - 1
        };
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtils.createRandomArray(10, 10);
        int[] range = new QuickBase().base(arr, 5);
        for(int i: arr) {
            System.out.print(i + "\t");
        }
        System.out.println("");
        System.out.println(range[0] + "->" + range[1]);
    }
}
