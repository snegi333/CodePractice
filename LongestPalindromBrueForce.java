// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class LongestPalindromBrueForce {
    
    public static boolean isPalindrom(String input){
        String reverse = "";
        for(char ch : input.toCharArray()){
            reverse = ch + reverse;
        }
        if(input.equals(reverse)){
            return true;
        }
        return false;
    }
    
    public static ArrayList<String> allSubSequences(String input){
      int maxlen = 0;
      ArrayList<String> subSequence = new ArrayList<>();
      int len = input.length();
      for(int i=0; i<len; i++){
          String firstValue = input.charAt(i) + "";
          subSequence.add(firstValue);
          for(int j=i+1; j<len ; j++){
              firstValue = firstValue + input.charAt(j);
              subSequence.add(firstValue);
          }
      }
      return subSequence;
    }
    public static String longestPalindrom(ArrayList<String> inputList){
        // for(int i=0; i<inputList.size(); i++){
        //     if(!isPalindrom(inputList.get(i))){
        //         inputList.remove(i);
        //     }
        // }
        inputList.removeIf(s -> !isPalindrom(s));
        
        Collections.sort(inputList, (a, b) -> Integer.compare(a.length(), b.length()));
        return inputList.get(inputList.size()-1);
    }
    
    public static void main(String[] args) {
        String str = "aba";
        // System.out.println(isPalindrom(str));
        // System.out.println(allSubSequences(str));
        System.out.println(longestPalindrom(allSubSequences(str)));
         }
}
