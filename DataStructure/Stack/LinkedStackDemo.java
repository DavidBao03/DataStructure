package DataStructure.Stack;

public class LinkedStackDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"1","一");
        HeroNode hero2 = new HeroNode(2,"2","二");
        HeroNode hero4 = new HeroNode(4,"4","四");
        HeroNode hero5 = new HeroNode(5,"5","五");
        HeroNode hero6 = new HeroNode(6,"6","六");
        HeroNode hero3 = new HeroNode(3,"3","三");

        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push(hero1);
        linkedStack.push(hero2);
        linkedStack.push(hero4);
        linkedStack.push(hero5);
        linkedStack.push(hero6);
        linkedStack.push(hero3);
        linkedStack.showList();
        System.out.println("----------------------------------");

        try{
            linkedStack.pop();
            linkedStack.pop();
            linkedStack.pop();
            linkedStack.pop();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        linkedStack.showList();
    }

}
class LinkedStack {
    private final HeroNode head = new HeroNode(0,"","");
    private HeroNode top = head;

    public boolean isEmpty(){
        return top == null;
    }
    public void push(HeroNode heroNode){
        while(top.next != null){
            top = top.next;
        }
        top.next = heroNode;
    }

    public HeroNode pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        } else if (head.next.next == null) {
            HeroNode next = head.next;
            head.next = null;
            return next;
        }
        HeroNode temp = head;
        while (temp.next != top){
            temp = temp.next;
        }
        HeroNode res = top;
        top.next = null;
        top = temp;
        return res;
    }

    public void showList(){
        if(top == null){
            System.out.println("栈空");
            return;
        }
        HeroNode temp = head.next;
        while(temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode {
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