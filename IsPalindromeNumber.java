public class IsPalindromeNumber {

    public boolean isPalindrome(int x) {
        int rev = 0;
        int temp =x;
        while(temp>0){
            int quo = temp%10;
            rev = rev*10 + quo;
            temp=temp/10;
        }
        if (rev != x){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindromeNumber obj = new IsPalindromeNumber();
        System.out.println(obj.isPalindrome(121)); // true
        System.out.println(obj.isPalindrome(-121)); // false
        System.out.println(obj.isPalindrome(10));   // false
    }
}
