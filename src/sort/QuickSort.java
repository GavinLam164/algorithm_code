package sort;

public class QuickSort implements Sort{

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // 改写QuickBase，以支持[start,end]区间的荷兰国旗问题
    public int[] base(int[] arr, int start, int end, int K) {
        // l 表示 [start,l]为元素值小于K的区域
        // r 表示 [r,end]为元素值大于K的区域
        // i 表示 当前遍历的元素下标
        int l = start - 1, r = end + 1, i = start;
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
        // [start,l]为元素值小于K的区域
        // [r,end]为元素值大于K的区域
        // [l+1,r-1]为元素值等于K的区域，若区域交错则证明数组arr中没有等于K的元素值
        return new int[] {
                l + 1,
                r - 1
        };
    }

    private void quickSort(int[] arr, int i, int j) {
        if(i >= j) return; // 元素个数小于等于1，不需要划分直接return
        // 对于每个区域的划分来说，必须有一个值`K`，作为基准值，来辅助划分，一般会在数组中的选一个元素值作为基准值。
        // 需要注意的是，这个值若是最大值或是最小值都会产生无效的区域划分，所以最好在数组中随机选一个元素值，降低平均选中最大/小值的概率。
        int randIndex = i + (int)(Math.random() * (j - i + 1));
        int K = arr[randIndex];

        // 确定等于K的区域
        int[] range = base(arr, i, j, K);

        // 小于K的区域递归执行
        quickSort(arr, i, range[0] - 1);

        // 大于K的区域递归执行
        quickSort(arr, range[1] + 1, j);
    }

    @Override
    public String getName() {
        return "QuickSort";
    }
}
