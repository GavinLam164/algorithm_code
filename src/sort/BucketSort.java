package sort;

public class BucketSort implements Sort{
    @Override
    public void sort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int v: arr) { // 获取数值范围
            max = Math.max(max, v);
        }
        // 准备桶用于计数
        int[] bucket = new int[max + 1];
        for(int v: arr) {
            bucket[v]++;
        }
        int index = 0;
        for(int i = 0; i < bucket.length; i++) {
            while(bucket[i] > 0) { // 取出计数结果, i为出现的元素值，bucket[i]为i出现的次数
                arr[index++] = i;
                bucket[i]--;
            }
        }
    }

    @Override
    public String getName() {
        return "BucketSort";
    }
}
