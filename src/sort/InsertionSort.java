package sort;

public class InsertionSort implements Sort{
    @Override
    public void sort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0 && arr[j-1] > arr[j]; j--) {
                int tmp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = tmp;
            }
        }
    }

    @Override
    public String getName() {
        return "InsertionSort";
    }
}
