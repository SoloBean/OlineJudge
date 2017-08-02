package rotateList;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		int length = 0;
		ListNode cal = head;
		while(cal != null){
			cal = cal.next;
			length++;
		}
		if(k == 0 || head == null){
			return head;
		}
		k = k % length;
		if(k == 0){
			return head;
		}
        ListNode front = head;
        ListNode behind = head;
        ListNode frontFront = head;
        for(int i = 0; i < k; i++){
        	frontFront = front;
        	front = front.next;
        }
        while(front.next != null){
        	front = front.next;
        	behind = behind.next;
        }
        ListNode newHead = behind.next;
        behind.next = null;
        front.next = head;
        return newHead;
    }
	
	public static void main(String[] args){
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode f = new ListNode(5);
//		a.next = b;
//		b.next = c;
//		c.next = d;
//		d.next = f;
//		f.next = null;
		RotateList t = new RotateList();
		ListNode head = t.rotateRight(a, 1);
		ListNode point = head;
		while(point != null){
			System.out.println(point.val);
			point = point.next;
		}
	}
}
