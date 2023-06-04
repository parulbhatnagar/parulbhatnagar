package org.example;

public class AddTwoNumbersListNode {
    public static void main(String[] args) {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * Example 1:
         * Input: l1 = [2,4,3], l2 = [5,6,4]
         * Output: [7,0,8]
         * Explanation: 342 + 465 = 807.
         *
         * Example 2:
         * Input: l1 = [0], l2 = [0]
         * Output: [0]
         *
         * Example 3:
         * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
         * Output: [8,9,9,9,0,0,0,1]
         *
         * Constraints:
         * The number of nodes in each linked list is in the range [1, 100].
         * 0 <= Node.val <= 9
         * It is guaranteed that the list represents a number that does not have leading zeros.
         */

        ListNode returnListNode=null;
        int returnListNodeValue, carry=0;


        if (l1!= null && l2!= null){
            returnListNodeValue = (l1.val+l2.val)%10;
            carry = (l1.val+l2.val)/10;
            returnListNode = new ListNode(returnListNodeValue);
            if (l1.next != null){
                // adding carry for next addtion
                l1.next.val += carry;
            } else if (l2.next != null) {
                l2.next.val += carry;
            } else if (carry !=0){
                returnListNode.next = new ListNode(carry);
                return returnListNode;
            }else {
                return returnListNode;
            }
            returnListNode.next = addTwoNumbers(l1.next,l2.next);
        } else if (l1!=null && l2==null) {
            returnListNodeValue = (l1.val)%10;
            carry = (l1.val)/10;
            returnListNode = new ListNode(returnListNodeValue);
            if (l1.next != null){
                // adding carry for next addtion
                l1.next.val += carry;
            }else if (carry !=0){
                returnListNode.next = new ListNode(carry);
                return returnListNode;
            } else {
                return returnListNode;
            }
            returnListNode.next = addTwoNumbers(l1.next,null);
        }else if (l1==null && l2!=null) {
            returnListNodeValue = (l2.val)%10;
            carry = (l2.val)/10;
            returnListNode = new ListNode(returnListNodeValue);
            if (l2.next != null){
                // adding carry for next addtion
                l2.next.val += carry;
            }else if (carry !=0){
                returnListNode.next = new ListNode(carry);
                return returnListNode;
            } else {
                return returnListNode;
            }
            returnListNode.next = addTwoNumbers(l2.next,null);
        }
        return returnListNode;

    }
}
