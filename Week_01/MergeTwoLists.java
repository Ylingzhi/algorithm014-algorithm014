public class MergeTwoLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        // 添加新的结点
        public void add(int newval) {
            ListNode newNode = new ListNode(newval);
            if(this.next == null) {
                this.next = newNode;
            } else {
                this.next.add(newval);
            }
        }

        // 打印链表
        public void print() {
            System.out.print(this.val);
            if(this.next != null)
            {
                System.out.print("->");
                this.next.print();
            }
        }
    }

    //递归方式解决
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //判断给出的连表是否为空，为空直接返回另一个不为空的链表即可
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //比较链表的起始值大小，返回小的值
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            //递归输出结果
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        MergeTwoLists mg = new MergeTwoLists();
        ListNode l1 = new ListNode(1);
        l1.add(2);
        l1.add(4);
        ListNode l2 = new ListNode(1);
        l2.add(3);
        l2.add(4);

        ListNode listNode = mg.mergeTwoLists(l1, l2);
        listNode.print();
    }
}
