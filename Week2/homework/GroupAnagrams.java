import java.util.*;

/**
 * @author Suisijia
 * @create 2020-11-29 20:52
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0 ) {
            return new ArrayList();
        }
        Map<String, List> map = new HashMap<>();
        for (String s : strs) {
            char[] letters = new char[26];
            for (char c : s.toCharArray()) {
                letters[c - 'a']++;
            }
            String key = String.valueOf(letters);
            if (!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
