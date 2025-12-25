1. Why does inorder traversal of a BST return sorted order?
   Because inorder visits nodes left root  right, and in a BST all left values are smaller and all right values are larger.

2. Example of insertion order that creates an unbalanced BST + its inorder traversal
   Insertion order:
   1, 2, 3, 4, 5
   This creates a straight line (every node goes to the right).
   Inorder traversal:
   1, 2, 3, 4, 5

3. Recursive vs iterative traversal
   Recursive uses the call stack, iterative uses an explicit stack/queue.
   Recursive is simpler, iterative avoids deep‑recursion limits.

4. Depth‑first vs breadth‑first
   DFS goes down a branch before moving sideways.
   BFS visits level by level using a queue.

5. When prefer BFS?
   When you need the closest or shallowest result first, like shortest paths or level‑based processing.


