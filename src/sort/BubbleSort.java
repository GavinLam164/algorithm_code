package sort;

public class BubbleSort implements Sort {

    @Override
    public String getName() {
        return "BubbleSort";
    }

    @Override
    public void sort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 1; j < arr.length - i; j++) {
                if(arr[j-1]> arr[j]) {
                    int tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
