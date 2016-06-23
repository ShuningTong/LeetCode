import java.util.Stack;

// the thinking for this problem is as following:
// preorder decides we will always encounter null node as a left node first
// because it is a left node null, so next node must be its sibling, so that we can cross them out
// if the second node of a cross out pair is a null node, then the next node must be upper one level node, which is the sibling of the parent of the cross out pair, so we can cross them out too.
public class VerifyPreorderSerializationOfBinaryTree {

    public static void main(String[] args){
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(isValidSerialization(preorder));
        String preorder2 = "1,#";
        System.out.println(isValidSerialization(preorder2));
        String preorder3 = "9,#,#,1";
        System.out.println(isValidSerialization(preorder3));
        String preorder4 = "1";
        System.out.println(isValidSerialization(preorder4));
        String preorder5 = "#";
        System.out.println(isValidSerialization(preorder5));
    }

    public static boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.equals("#") || preorder.equals("")){
            return true;
        }
        String[] preorderArray = preorder.split(",");
        if (preorderArray.length < 3 || !(preorderArray[preorderArray.length - 1].equals("#") && preorderArray[preorderArray.length - 2].equals("#"))){
            return false;
        }
        Stack<String> stack = new Stack<>();
        boolean afterExistNull = false;
        boolean secondOfCrossOutNull = false;
        for (String s: preorderArray){
            if (secondOfCrossOutNull){
                stack.pop();
                secondOfCrossOutNull = false;
                if (s.equals("#")){
                    secondOfCrossOutNull = true;
                }
            }else if (!afterExistNull){
                stack.push(s);
                if (s.equals("#")){
                    afterExistNull = true;
                }
            }else{
                stack.pop();
                afterExistNull = false;
                if (s.equals("#")){
                    secondOfCrossOutNull = true;
                }
            } 
            if (stack.empty()){
                return false;
            }
        }
        if (stack.size() == 1){
            return true;
        }else{
            return false;
        }
    }
}
