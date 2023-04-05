package DataStructure.LinkedList.SingleLinkedList;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"1","一");
        HeroNode hero2 = new HeroNode(2,"2","二");
        HeroNode hero4 = new HeroNode(4,"4","四");
        HeroNode hero5 = new HeroNode(5,"5","五");
        HeroNode hero6 = new HeroNode(6,"6","六");
        HeroNode hero3 = new HeroNode(3,"3","三");
        HeroNode heroTemp = new HeroNode(7,"4","三");
        HeroNode hero7 = new HeroNode(7,"3","三");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero5);
        singleLinkedList.add(hero6);

        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero7);

        singleLinkedList.upData(heroTemp);

        singleLinkedList.delete(2);
        singleLinkedList.delete(7);

        singleLinkedList.showList();

        System.out.println(getLength(singleLinkedList.getHead()));

        HeroNode res = findLastIndexNode(singleLinkedList.getHead(),-8);
        System.out.println(res);

        reverseList(singleLinkedList.getHead());
        singleLinkedList.showList();

        System.out.println();
        reversePrintList(singleLinkedList.getHead());
    }

    //一些常见问题:
    //获取到单链表中有效结点的个数:
    public static int getLength(HeroNode head){
        if(head.next == null){
            return 0;
        }
        HeroNode cur = head.next;
        int length = 0;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }

    //获取到链表中倒数第N个有效节点:
    //思路:1.先向方法传递头节点与倒数第index个元素
    //    2.获取链表长度size,遍历到第(size - index)个元素即可
    public static HeroNode findLastIndexNode(HeroNode head , int index){
        if (head.next == null){
            return null;
        }
        HeroNode cur = head.next;
        int size = getLength(head);
        if(index <= 0 || index > size){
            return null;
        }
        for(int i = 0 ; i < size - index ; i++){
            cur = cur.next;
        }
        return cur;
    }

    //单链表的反转
    public static void reverseList(HeroNode head){
        //若链表为空或只有一个元素 直接返回即可
        if(head.next == null || head.next.next == null){
            return;
        }
        HeroNode reverseHead = new HeroNode(0,"","");//创建新的头节点存放数据
        HeroNode cur = head.next;//创建临时变量遍历链表
        HeroNode next = null;//创建变量指向上一个指针的下一个节点
        //创建该变量的目的是因为在将新节点放入新链表后
        //原链表会断开,导致[cur]指针不能正常遍历原链表
        while (cur != null){
            next = cur.next;//变量指向[cur]的下一个节点
            cur.next = reverseHead.next;//将新节点放入新链表的最前面
            reverseHead.next = cur;//连接新链表头节点与新节点
            cur = next;//移动指针
        }
        head.next = reverseHead.next;//将旧链表连入新链表中
        reverseHead.next = null;//删除旧链表头节点
    }

    //单链表的逆序打印
    //利用栈数据结构先入后出的特点实现
    public static void reversePrintList(HeroNode head){
        //若链表为空则无法打印
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //创建新栈
        Stack<HeroNode> heroNodeStack = new Stack<>();
        HeroNode cur = head.next;//辅助变量遍历链表
        while (cur != null){
            heroNodeStack.add(cur);//数据进栈
            cur = cur.next;//移动指针
        }
        //打印输出栈
        while (heroNodeStack.size() > 0){
            //取出栈顶数据并打印
            HeroNode res = heroNodeStack.pop();
            System.out.println(res);
        }
    }
}
class SingleLinkedList{
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead(){
        return head;
    }
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        Boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no > heroNode.no){
                break;
            }else if(temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.println("编号已存在,添加失败");
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void delete(int no){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("未能找到该编号");
        }
    }

    public void upData(HeroNode newHeroNode){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if(temp == null){
                break;
            }
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else {
            System.out.println("未能找到该编号");
        }

    }
    public void showList(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no , String name , String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
