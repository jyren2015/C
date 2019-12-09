import java.util.*;
import java.lang.Character;
public class Solution{
    class Node {
        public String str_node;
        public Node[] child;
        public Node father = null;
        public int flag = 0;
        public boolean flag1 = false;

        public Node(String digits, HashMap<Character, String[]> map, String root) {
            if (digits.length() == 0) {
                this.str_node = root;
                this.child = null;
                System.out.println(this.str_node);
                System.out.println("一条路径结束");
            } else {
                this.str_node = root;
                System.out.println(this.str_node);
                this.child = new Node[map.get(digits.charAt(0)).length];
                for (int i = 0; i < map.get(digits.charAt(0)).length; i++) {
                    this.child[i] = new Node(digits.substring(1), map, map.get(digits.charAt(0))[i]);
                    this.child[i].father = this;
                }
            }
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23794"));
    }
}
