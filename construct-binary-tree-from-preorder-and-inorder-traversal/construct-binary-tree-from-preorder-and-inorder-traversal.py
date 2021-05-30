# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        def solver(bound=None):
            if not inorder or inorder[0]==bound: return None
            root=TreeNode(preorder.pop(0))
            root.left=solver(root.val)
            inorder.pop(0)
            root.right=solver(bound)
            return root
        
        return solver()