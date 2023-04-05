package DataStructure.LinkedList.DoubleLinkedList;
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"1","一");
        HeroNode hero2 = new HeroNode(2,"2","二");
        HeroNode hero4 = new HeroNode(4,"4","四");
        HeroNode hero3 = new HeroNode(4,"三","三");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero4);

        doubleLinkedList.showList();
        System.out.println("-------------------------------------");

        doubleLinkedList.delete(1);
        doubleLinkedList.delete(3);

        doubleLinkedList.showList();
        System.out.println("-------------------------------------");

        doubleLinkedList.upData(hero3);

        doubleLinkedList.showList();
        System.out.println("-------------------------------------");
    }
}

class DoubleLinkedList{
    HeroNode head = new HeroNode(0,"","");

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
        heroNode.prev = temp;
    }

    public void delete(int no){
        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if(temp == null){
                break;
            }
            if(temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
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
    public  HeroNode next;
    public  HeroNode prev;
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
