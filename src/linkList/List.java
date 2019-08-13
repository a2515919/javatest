package linkList;

/**
 * @author ZHOU
 * 单链表
 */
public class List {
    Node head;
    int length;
    public void addNode(Node node){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
    }

    /**
     * 连表中的位置从1开始
     * @param index
     */
    public void delNodeByIndex(int index){
        //判断是否为正确的输入
        if(index<1||index>length){
            System.out.println("input error!");
            return;
        }
        int i=1;
        Node temp =head;
        while(temp.next!=null){
            if(i==index){
                temp.next=temp.next.next;
                return;
            }
            temp=temp.next;
        }
    }




}
