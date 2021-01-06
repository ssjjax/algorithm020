/**
 * @author Suisijia
 * @create 2021-01-01 16:31
 */
public class ImplementTriePrefixTree {}

/*
* 个人理解：
insert方法中：
每次都是先扩一个出去，然后每次再以倒数第二个的trie[]作为某字母存储的信息。这样实现之后，第一行的Trie对象本身没有值，且最后一行的Trie[]，是空的。
按此题的解题方式，每行的Trie[]中并没有存任何字母，都是以数组索引的位置 来 判断某字符串是否存在
* */
class Trie {
    private boolean isEnd;
    private Trie[] next;
    public Trie(){
        isEnd = false;
        next = new Trie[26];
    }
    public void insert(String word) {
        char[] words = word.toCharArray();
        Trie curr = this;
        for (int i = 0; i < words.length; i++) {
            int n = words[i] - 'a';
            if (curr.next[n] == null) {
                curr.next[n] = new Trie();
            }
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }
    private Trie searchPrefix(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        for (int i = 0; i < words.length; i++) {
            int n = words[i] - 'a';
            node = node.next[n];
            if (node == null) {
                return null;
            }
        }
        return node;
    }
}