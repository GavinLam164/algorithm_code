package sort;

public class TestSort {
    public static void main(String[] args) {
        ArrayUtils.test(new BubbleSort());
        ArrayUtils.test(new SelectSort());
        ArrayUtils.test(new InsertionSort());
        ArrayUtils.test(new BubbleSort());
        ArrayUtils.test(new MergeSort());
        ArrayUtils.test(new QuickSort());
        ArrayUtils.test(new HeapSort());
        ArrayUtils.test(new RadixSort());
    }
}
