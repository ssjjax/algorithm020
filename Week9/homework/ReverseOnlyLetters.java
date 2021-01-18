/**
 * @author Suisijia
 * @create 2021-01-18 11:44
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        for (int i = 0,j = arr.length - 1; i < j; i++,j--) {
            while(i < j && !Character.isLetter(arr[i])) i++;
            while(i < j && !Character.isLetter(arr[j])) j--;
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return String.valueOf(arr);
    }
}
