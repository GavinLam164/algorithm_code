package sort;

public class MergeSort implements Sort {
    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int i, int j) {
        if(i >= j) return; // 元素个数小于等于1，直接return
        int mid = i + (j - i) / 2;
        // 解决[i, mid]的子数组问题
        mergeSort(arr, i, mid);
        // 解决[mid+1, j]的子数组问题
        mergeSort(arr, mid + 1, j);
        // 合并两个有序数组
        merge(arr, i, mid, j);
    }

    // 改写算法原型MergeBase
    private void merge(int[] arr, int i, int m, int j) {
        int[] ret = new int[j - i + 1];
        int z = 0;
        // 通过数组下标m将arr划分为两个子数组，l为子数组A下标，r为子数组B下标
        int l = i, r = m + 1;

        while(l <= m && r <= j) {
            ret[z++] = arr[l] < arr[r] ? arr[l++]: arr[r++];
        }

        while(l <= m) {
            ret[z++] = arr[l++];
        }

        while(r <= j) {
            ret[z++] = arr[r++];
        }

        // 将ret复制回原数组
        for(z = 0; z < ret.length; z++) {
            arr[i+z] = ret[z];
        }
    }


    @Override
    public String getName() {
        return "MergeSort";
    }
}
