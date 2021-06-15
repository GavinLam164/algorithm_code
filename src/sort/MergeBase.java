package sort;

public class MergeBase {
    public int[] base(int[] A, int[] B) {
        int[] ret = new int[A.length + B.length];
        int i = 0, j = 0, z = 0;

        while(i < A.length && j < B.length) {
            ret[z++] = A[i] < B[j] ? A[i++]: B[j++];
        }

        while(i < A.length) {
            ret[z++] = A[i++];
        }

        while(j < B.length) {
            ret[z++] = B[j++];
        }
        return ret;
    }
}
