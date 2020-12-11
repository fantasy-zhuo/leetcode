//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1430 👎 0


package com.fantasy.code.leetcode.editor.cn;

import com.fantasy.code.leetcode.editor.cn.entity.ListNode;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：合并两个有序链表
public class P21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
        // TO TEST

        ListNode l1 = new ListNode();
        l1.add(1);
        l1.add(2);
        l1.add(4);

        l1.print();

        ListNode l2 = new ListNode();
        l2.add(1);
        l2.add(3);
        l2.add(4);
        System.out.println();

        l2.print();
        ListNode listNode = solution.mergeTwoLists(l1, l2);
        System.out.println();

        listNode.print();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * // 添加新的结点
     *     public void add(int newval) {
     *         ListNode newNode = new ListNode(newval);
     *         if(this.next == null)
     *             this.next = newNode;
     *         else
     *             this.next.add(newval);
     *     }
     *
     *     // 打印链表
     *     public void print() {
     *         System.out.print(this.val);
     *         if(this.next != null)
     *         {
     *             System.out.print("-->");
     *             this.next.print();
     *         }
     *     }
     *
     *     public int getVal() {
     *         return val;
     *     }
     *
     *     public ListNode setVal(int val) {
     *         this.val = val;
     *         return this;
     *     }
     *
     *     public ListNode getNext() {
     *         return next;
     *     }
     *
     *     public ListNode setNext(ListNode next) {
     *         this.next = next;
     *         return this;
     *     }
     * }
     */
    class Solution {
        /**
         * 把两个链表的值拿出来放在一个数组或者list里面再进行排序，排序后再创建新的链表
         * @param l1
         * @param l2
         * @return
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            if (l1 == null && l2 == null)
                return new ListNode();

            List<Integer> list = new ArrayList<>();

            if (l1 != null){
                ListNode node = l1;

                while(node!=null){
                    list.add(node.getVal());
                    node = node.getNext();
                }
            }
            if (l2 != null){
                ListNode node = l2;

                while(node!=null){
                    list.add(node.getVal());
                    node = node.getNext();
                }
            }

            int[] arr = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                arr[i] = list.get(i);
            }
            System.out.println();

            System.out.println("排序前 = " + Arrays.toString(arr));

            int temp;

            //冒泡排序
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length-1-i; j++) {
                    if (arr[j] > arr[j+1]){

                        temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }

            System.out.println("排序后 = " + Arrays.toString(arr));

            ListNode listNode = new ListNode();

            for (int i = 0; i < arr.length; i++) {
                listNode.add(arr[i]);
            }
            return listNode;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}