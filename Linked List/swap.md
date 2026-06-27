first create an function to reverse .

take left and right 
initialise left as head;

loop  
  initialise right with left 
  loop again to find the group right value
  check if you got valid right value
    if yes then store the right next as nextleft 
    first iteration will store the head 
    then prevlength with join the reversed sublist with right address
    increament prevleft left
    if left is null break;
  break loop
if off number of nodes in ll
  last link will be joined using left pointer
return res



1. Create a helper function to reverse a linked list of size `2`.
2. Initialize `left` as the head of the linked list.
3. Traverse the list group by group:
   * Set `right = left`.
   * Move `right` to the end of the current group (2nd node).
4. Check if a valid group of size `2` exists.
   * If not, stop the traversal.
5. Store `right.next` in `nextLeft` so that the starting node of the next group is not lost after reversal.
6. Reverse the current group.
7. If this is the first reversed group, store `right` (the new head after reversal) in `res`.
8. Otherwise, connect the tail of the previous reversed group (`prevLeft`) to `right`, which is the head of the current reversed group.
9. Update:
   * `prevLeft = left` (after reversal, `left` becomes the tail of the current group).
   * `left = nextLeft` (move to the next group).
10. If `left` becomes `null`, all groups have been processed, so exit the loop.
11. After the loop, if the linked list has an odd number of nodes, connect the last processed group's tail (`prevLeft`) to `left`, which points to the remaining node.
12. Return `res`, the head of the modified linked list.

