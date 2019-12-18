import java.util.ArrayList;
import java.util.List;

/**
 * Created by RJYWORK on 2019/12/12
 * Description:
 */
public class LongestValidParentheses {
    public int[] extract(String s, int[] pos){
        int[] pos1 = new int[2];
        if (s.charAt(pos[0]) == '(' && s.charAt(pos[1]) == ')'){
            pos1[0] = pos[0];
            pos1[1] = pos[1];
            while (pos[0] - 1 >= 0 && pos[1] + 1 <s.length() && s.charAt(pos[0] - 1) == '(' && s.charAt(pos[1] + 1) == ')'){
                pos[0] = pos[0] - 1;
                pos[1] = pos[1] + 1;
                pos1[0] = pos[0];
                pos1[1] = pos[1];
            }
        }
        return pos1;
    }
    public List<int[]> merge(String s, List<int[]> list){
        List<int[]> list1 = new ArrayList<>();
        boolean is = false;
        if (list.size() == 0) return list;
        else {
            int pointer = 0;
            int[] pos;
            while (pointer < list.size()) {
                pos = list.get(pointer);
                while (pointer + 1 < list.size() && pos[1] + 1 == list.get(pointer + 1)[0]){
                    is = true;
                    pos[1] = list.get(pointer + 1)[1];
                    pointer = pointer + 1;
                }
                pos = extract(s, pos);
                list1.add(pos.clone());
                pointer = pointer + 1;
            }
        }
        if (is) return list1;
        else return list;
    }
    public int longestValidParentheses(String s) {
        int i = 0;
        int j = i+1;
        List<int[]> list = new ArrayList<>();
        int max = 0;
        int[] pos = new int[2];
        while (j<s.length()){
            pos[0] = i;
            pos[1] = j;
            if (s.charAt(pos[0]) == '(' && s.charAt(pos[1]) == ')'){
                pos = extract(s, pos);
                max = Math.max(max, pos[1] - pos[0] + 1);
                list.add(pos.clone());
                i = pos[1] + 1;
            }
            else {
                i++;
            }
            j = i + 1;
        }

        System.out.println("list长度:" + list.size());
        for (int[] ints : list) {
            System.out.println("每一对数字为：" + ints[0] + "+" + ints[1]);
        }
        int size = list.size();
        list = merge(s, list);
        while (list.size() != size){
            size = list.size();
            list = merge(s, list);
        }
        for (int[] ints : list) {
            max = Math.max(max, ints[1] - ints[0] + 1);
            System.out.println("返回前list每一对数字为：" + ints[0] + "+" + ints[1]);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        String ssssssssssss = ")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())";
        System.out.println(longestValidParentheses.longestValidParentheses(ssssssssssss));
    }
}
