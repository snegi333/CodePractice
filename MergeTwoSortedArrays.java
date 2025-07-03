import java.util.*;
public class MergeTwoSortedArrays
{
    public static List<Integer> mergeTwoSortedArrays(int[] arr1, int[] arr2){
        List<Integer> result = new ArrayList<>();
        int a1 = 0;
        int a2 = 0;
        int newLen = arr1.length+arr2.length;
        while(a2<arr2.length && a1<arr1.length){
            if(arr1[a1]>arr2[a2]){
                result.add(arr2[a2]);
                a2++;
            } else {
                result.add(arr1[a1]);
                a1++;
            }
        }
        while(a1<arr1.length){
            result.add(arr1[a1]);
            a1++;
        }

        while(a2<arr2.length){
            result.add(arr2[a2]);
            a2++;
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7,9};
        int[] arr2 = {2,4,6,8};
        System.out.println(mergeTwoSortedArrays(arr1, arr2));
    }
}
