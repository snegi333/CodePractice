public class FrogJump {

    static int recurr(int index, int[] a){
        if(index==0){
            return 0;
        }
        int left = recurr(index-1, a) + Math.abs(a[index] - a[index-1]);
        int right = 0;
        if(index>1) {
            right = recurr(index - 2, a) + Math.abs(a[index] - a[index - 2]);
        }
        int result = Math.min(left, right);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {30,10,60,10,60,50};
        System.out.println(recurr(arr.length-1, arr));
    }
}
