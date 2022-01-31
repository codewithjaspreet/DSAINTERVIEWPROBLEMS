public class MorrisPreOrder {
      
  public static TreeNode getRightMostNode(TreeNode rightMost , TreeNode curr){
      
    while(rightMost.right !=null && rightMost.right != curr){
        rightMost = rightMost.right;
    }
    return rightMost;
}

public static ArrayList<Integer> morrisPreTraversal(TreeNode Treenode) {
  ArrayList<Integer> ans = new ArrayList<>();
  TreeNode curr   = Treenode;
  while(curr !=null){
      TreeNode left = curr.left;
      if(left == null){
          ans.add(curr.val);
          curr = curr.right;
      }
      else{
          TreeNode rightMostNode = getRightMostNode(left , curr);
          
          if(rightMostNode.right == null){
              ans.add(curr.val);
              rightMostNode.right = curr; // thread creation
              curr = curr.left;
          }
          else{
              rightMostNode.right = null;  // thread cut down
              curr = curr.right;
              
          }
      }
  }
  return ans;
}

}
