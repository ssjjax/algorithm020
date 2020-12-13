import java.util.*;

/**
 * @author Suisijia
 * @create 2020-12-14 0:19
 */

//单向BFS
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 1）：将 wordList 放入哈希表，便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        // ？？
        wordSet.remove(beginWord);

        // 2）：图的BFS，必须使用 队列 和 visited 哈希表
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // 3）：执行BFS，包含起点，因此初始化时步数为 1
        int step = 1;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                // 依次遍历当前队列中的单词
                String currentWord = queue.poll();
                // 若 currentWord 能修改 1 个字符与 endWord 相同，则返回 step + 1
                if (changeWordEveryOneLetter(currentWord, endWord, queue, visited, wordSet)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    /**
     * 尝试对 currentWord 修改每一个字符，看是否能与 endWord 匹配
     */
    private boolean changeWordEveryOneLetter(String currentWord, String endWord,
                                             Queue<String> queue, Set<String> visited, Set<String> wordSet) {
        char[] charArray = currentWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            // 先保存，然后恢复
            char originChar = charArray[i];
            for (char k = 'a'; k <= 'z'; k++) {
                if (k == originChar) {
                    continue;
                }
                //如：对hit来说，nextWord依次为ait bit cit ... 之后第二轮为hat hbt hct ...
                charArray[i] = k;
                String nextWord = String.valueOf(charArray);
                // (此句为true，只能说明nextWord这个词在词典中，但并不一定是endWord)
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        // 注：添加到队列后，必须马上标记为已访问
                        visited.add(nextWord);
                    }
                }
            }
            // 恢复
            charArray[i] = originChar;
        }
        return false;
    }
}
