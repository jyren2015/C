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
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.equals("")) return list;
        HashMap<Character, String[]> map = new HashMap<>();
        String[] digit2 = {"a", "b", "c"};
        String[] digit3 = {"d", "e", "f"};
        String[] digit4 = {"g", "h", "i"};
        String[] digit5 = {"j", "k", "l"};
        String[] digit6 = {"m", "n", "o"};
        String[] digit7 = {"p", "q", "r", "s"};
        String[] digit8 = {"t", "u", "v"};
        String[] digit9 = {"w", "x", "y", "z"};
        map.put('2', digit2);
        map.put('3', digit3);
        map.put('4', digit4);
        map.put('5', digit5);
        map.put('6', digit6);
        map.put('7', digit7);
        map.put('8', digit8);
        map.put('9', digit9);
        Node root = new Node(digits, map, "root");
        Node move = root;
        List<String> test = new ArrayList<>();
        System.out.println("over");
        System.out.println(root.str_node);
        String final_str = "";
        int tag = 0;
        while (true){
            if (move.str_node.equals("root") && move.flag1) break;
            if (move.child == null){
                test.add(final_str);
                tag ++;
                final_str = final_str.substring(0, final_str.length()-1);
                move = move.father;
            }
            else if (move.flag1){
                final_str = final_str.substring(0, final_str.length()-1);
                move = move.father;
            }
            else {
                final_str = final_str + move.child[move.flag].str_node;
                move.flag++;
                if (move.flag == move.child.length) move.flag1 = true;
                move = move.child[move.flag-1];
            }
        }
        System.out.println("tag=" + tag);
        return test;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23794"));
    }
}
