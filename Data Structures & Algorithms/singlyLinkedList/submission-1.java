class LinkedList {
    class ListNode{
        int val;
        ListNode next;

        ListNode(){};

        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next; 
        }
    }

    ListNode head;
    ListNode tail;

    public LinkedList() {}

    public int get(int index) {
        ListNode temp = head;
        while(temp!=null && --index!=-1){
            temp = temp.next;
        }

        if(temp==null) return -1;
        return temp.val;
    }

    public void insertHead(int val) {
        if(this.head == null){
            head = new ListNode(val, null);
            tail = head;
        } else{
            ListNode curr = new ListNode(val, head);
            head = curr;
        }
    }

    public void insertTail(int val) {
        if(head==null){
            insertHead(val);
            return;
        }
        ListNode curr = new ListNode(val, null);
        tail.next = curr;
        tail = curr;
    }

    public boolean remove(int index) {
        if(index == 0){
            if(head!=null){
                head = head.next;
                return true;
            } else{
                return false;
            }
        }
        ListNode temp = head;
        while(temp!=null && --index!=0){
            temp = temp.next;
        }
        if(temp!=null && temp.next!=null){
            if(tail == temp.next) { tail = temp;}
            temp.next = temp.next.next;
            return true;
        } else return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            res.add(temp.val);
            temp = temp.next;
        }
        return res;
    }
}
