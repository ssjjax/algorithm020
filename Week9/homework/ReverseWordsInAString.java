import java.util.Arrays;
import java.util.Collections;

/**
 * @author Suisijia
 * @create 2021-01-18 11:41
 */
//覃超版本
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ",words);
    }
}
