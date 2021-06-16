package sort;

public class HeapSort implements Sort{
    @Override
    public void sort(int[] arr) {
        // 建堆过程
        for(int i = 0; i < arr.length; i++) {
            heapInsert(arr, i); // 将每个下标位置插入至堆中
        }

        // 调堆过程
        for(int heapSize = arr.length; heapSize > 1; heapSize--) {
            // 堆顶的元素为最大值，将最大值放到数组的最后一个位置
            swap(arr, 0, heapSize - 1);
            // 在选出了一个最大值之后，heapSize需要减1执行调堆过程
            heapify(arr, heapSize - 1);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void heapInsert(int[] arr, int currentIndex) {
        int parentIndex = (currentIndex - 1) / 2; // 计算父节点下标位置
        while(arr[parentIndex] < arr[currentIndex]) { // 若父节点大于当前节点，则已经满足了大根堆性质，跳出循环
            swap(arr, parentIndex, currentIndex);
            currentIndex = parentIndex; // 移动至父节点下标位置
            parentIndex = (currentIndex - 1) / 2; // 计算父节点下标位置
        }
    }

    public void heapify(int[] arr, int heapSize) {
        int currentIndex = 0;
        int leftChildIndex = currentIndex * 2 + 1; // 计算左子节点下标
        int rightChildIndex = leftChildIndex + 1; // 计算右子节点下标
        while(leftChildIndex < heapSize) {
            // 左子节点与右子节点比较
            int largestIndex = rightChildIndex < heapSize && arr[rightChildIndex] > arr[leftChildIndex] ? rightChildIndex: leftChildIndex;
            // 子节点与当前节点比较
            largestIndex = arr[largestIndex] > arr[currentIndex] ? largestIndex: currentIndex;
            // 若当前节点已经是最大值，则满足大根堆性质，break
            if(largestIndex == currentIndex) break;

            // 将最大值交换至当前节点
            swap(arr, currentIndex, largestIndex);

            // 不断向下进行比较
            currentIndex = largestIndex;
            leftChildIndex = currentIndex * 2 + 1; // 计算左子节点下标
            rightChildIndex = leftChildIndex + 1; // 计算右子节点下标
        }
    }

    @Override
    public String getName() {
        return "HeapSort";
    }
}
