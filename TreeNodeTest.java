/**
 * Created by RJYWORK on 2019/12/10
 * Description:
 */
public class TreeNodeTest {
    int leftVal = 0;
    int rightVal = 0;
    boolean flag = false;
    TreeNodeTest left = null;
    TreeNodeTest right = null;
    TreeNodeTest father = null;

    public TreeNodeTest(int height){
        if (height>0){
            this.left = new TreeNodeTest(height -1);
            this.left.father = this;
            this.right = new TreeNodeTest(height -1);
            this.right.father = this;
        }
    }
    public TreeNodeTest(){}

    public int deep(){
        if (this.left == null && this.right == null){
            this.leftVal = 0;
            this.rightVal = 0;
            return 1;
        }
        else if (this.left == null){
            this.right.deep();
            this.leftVal = 0;
            this.rightVal = Math.max(this.right.rightVal, this.right.leftVal) + 1;
            return 1 + this.rightVal;
        }
        else if (this.right == null){
            this.left.deep();
            this.rightVal = 0;
            this.leftVal = Math.max(this.left.rightVal, this.left.leftVal) + 1;
            return 1 + this.leftVal;
        }
        else{
            this.left.deep();
            this.right.deep();
            this.leftVal = Math.max(this.left.rightVal, this.left.leftVal) + 1;
            this.rightVal = Math.max(this.right.rightVal, this.right.leftVal) + 1;
            System.out.println(this.leftVal);
            System.out.println(this.rightVal);
            return this.leftVal + this.rightVal + 1;
        }
    }


    public static void main(String[] args){
        TreeNodeTest root = new TreeNodeTest();
        root.left = new TreeNodeTest();
        root.left.left = new TreeNodeTest();
        root.left.right = new TreeNodeTest();
        root.left.right.left = new TreeNodeTest();
        root.right = new TreeNodeTest();
        root.right.left = new TreeNodeTest();
        root.right.right = new TreeNodeTest();
        root.right.right.left = new TreeNodeTest();
        root.right.right.left.left = new TreeNodeTest();
        System.out.println("deep函数返回值" + root.deep());
        System.out.println("节点存储的值" + "左边：" + root.leftVal + "右边:" + root.rightVal);
    }
}
