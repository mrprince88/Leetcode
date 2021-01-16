# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def subtreeWithAllDeepest(self, root: TreeNode) -> TreeNode:
        
        def height(root):
            if root is None:
                return 0
            return 1+max(height(root.right),height(root.left))
        
        if root is None:
            return root
        
        left=height(root.left)
        right=height(root.right)
        
        if left==right:
            return root
        
        elif left>right:
            return self.subtreeWithAllDeepest(root.left)
        else:
            return self.subtreeWithAllDeepest(root.right)
        
        

    