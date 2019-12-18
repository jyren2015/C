import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by RJYWORK on 2019/12/10
 * Description:
 */
public class ParenthesisNode {
    private String string;
    public int count = 0;
    ParenthesisNode left = null;
    ParenthesisNode right = null;
    ParenthesisNode father = null;
    int tag = 0;

    public ParenthesisNode(String s){
        this.string = s;
    }

    public boolean valid(String[] strings, int p){
        Stack<String> stack = new Stack<>();
        for (int i = 0; i<p;i++) {
            if (strings[i].equals("(")) {
                stack.push("(");
            }
            if (strings[i].equals(")")) {
                if (!stack.empty() && stack.peek().equals("(")) {
                    stack.pop();
                }
                else return false;
            }
        }
        return stack.empty();
    }

    public boolean isValid2(String[] strings, int p, int n){
        Stack<String> stack = new Stack<>();
        for (int i = 0; i<p;i++) {
            if (strings[i].equals("(")) {
                stack.push("(");
            }
            if (strings[i].equals(")")) {
                if (!stack.empty() && stack.peek().equals("(")) {
                    stack.pop();
                }
            }
        }
        return stack.size() <= 2 * n - p;
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        String[] strings = new String[2*n];
//        if(n == 0) {//递归初始化二叉树
//            System.out.println("一条路径结束");
//        }
//        else {
//            ParenthesisNode move = this;
//            move.left = new ParenthesisNode("(");
//            move.right = new ParenthesisNode(")");
//            move.left.generateParenthesis(n-1);
//            move.right.generateParenthesis(n-1);
//        }

        ParenthesisNode move = this;
        System.out.println("初始化" + move.string);
        System.out.println("初始化tag:" + move.tag);
        System.out.println("初始化left:" + move.left);
        System.out.println("初始化right:" + move.right);
        System.out.println("初始化father:" + move.father);
        int i = 0;

        while (true) {
            if (move.string.equals("root") && move.tag == 1) return list;
            if (i < 2 * n && move.tag == 0) {
                move.left = new ParenthesisNode("(");
                this.count++;
                strings[i] = "(";
                System.out.println("第" + i + "层左儿子结点已建立");
                if (isValid2(strings, i, n)){
                    move.left.father = move;
                    i++;
                    move.tag++;
                    move = move.left;
                    System.out.println("move转为其左儿子，现在i为" + i);
                }
                else {
                    System.out.println("第" + i + "层左儿子结点不符合规则，i并未增长");
                    move.tag++;
                }
            } else if (i < 2 * n && move.tag == 1) {
                move.right = new ParenthesisNode(")");
                this.count++;
                strings[i] = ")";
                System.out.println("第" + i + "层右儿子结点已建立");
                if (isValid2(strings, i, n)){
                    move.right.father = move;
                    i++;
                    move.tag++;
                    move = move.right;
                    System.out.println("move转为其右儿子，现在i为" + i);
                }
                else {
                    System.out.println("第" + i + "层右儿子结点不符合规则，i并未增长");
                    move.tag++;
                }
            } else if (i < 2*n && move.tag == 2){
                System.out.println("访问过了，直接回退");
                i--;
                move = move.father;
                move.left = null;
                move.right = null;
            }else {
                System.out.println("检查");
                if (valid(strings, i)){
                    System.out.println("符合，加入结果集中");
                    StringBuilder final_str = new StringBuilder();
                    for (String s : strings) {
                        final_str.append(s);
                    }
                    list.add(final_str.toString());
                }
                i--;
                move = move.father;
            }
        }
    }

    public static void main(String[] args){
        ParenthesisNode parenthesisNode = new ParenthesisNode("root");
        System.out.println(parenthesisNode.generateParenthesis(12));
        System.out.println("共建立了多少个结点：" + parenthesisNode.count);
    }
}
