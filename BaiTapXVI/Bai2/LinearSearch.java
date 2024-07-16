package BaiTapXVI.Bai2;

public class LinearSearch {
    public static int linearSearch(int[] input1, int value) {

        for (int i=0;i<input1.length;i++){
            if (input1[i]==value){
                return i;
            }
        }
        return -1;
    }
}
