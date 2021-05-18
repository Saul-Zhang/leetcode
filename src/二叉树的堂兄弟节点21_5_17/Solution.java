package 二叉树的堂兄弟节点21_5_17;


//Definition for a binary tree node.
class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {

  int x;
  int y;
  int xParent;
  int xDepth;
  int yParent;
  int yDepth;

  public boolean isCousins(TreeNode root, int x, int y) {
    this.x = x;
    this.y = y;
    preOrderTraverse(root, root, 1);
    return xParent != yParent && xDepth == yDepth;
  }

  public void preOrderTraverse(TreeNode root, TreeNode parent, int depth) {
    if (root != null) {
      if (root.val == x) {
        this.xParent = parent.val;
        this.xDepth = depth;
      }
      if (root.val == y) {
        this.yParent = parent.val;
        this.yDepth = depth;
      }

//      System.out.print(root.val + "(" + parent.val + depth + ")" + "->");
      preOrderTraverse(root.left, root, depth + 1);
      preOrderTraverse(root.right, root, depth + 1);
    }
  }

  public static void main(String[] args) {

    TreeNode treeNode5 = new TreeNode(5);
    TreeNode treeNode4 = new TreeNode(4, null, null);
    TreeNode treeNode3 = new TreeNode(3, null, treeNode5);
    TreeNode treeNode2 = new TreeNode(2, null, treeNode4);
    TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);

//    new Solution().preOrderTraverse(treeNode1, treeNode1, 1);
    System.out.println(new Solution().isCousins(treeNode1, 5, 4));
  }
}