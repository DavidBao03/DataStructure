package DataStructure.LinkedList.JosephLinkedList;

public class JosephLinkedListDemo {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList(125);
        //circleSingleLinkedList.showList();

        circleSingleLinkedList.problemSolving(10,20);

    }
}

class CircleSingleLinkedList{
    Boy first = null;//创建指向第一个节点的指针
    public CircleSingleLinkedList(int num){
        //判断输入数据
        if(num <= 0){
            System.out.println("数据不合理");
            return;
        }
        Boy curBoy = null;//创建指向添加节点上一个节点的指针
        for(int i = 1; i <= num; i++){
            Boy boy = new Boy(i);//创建需添加的节点
            if(i == 1){//如果是第一次添加
                first = boy;//指针指向第一个节点的
                boy.next = first;//形成环状
            } else {//如果不是第一次添加
                curBoy.next = boy;//将新节点加入链表
                boy.next = first;//形成环状
            }
            curBoy = boy;//移动指针
        }
    }

    public void showList(){
        Boy curBoy = first;//辅助指针
        while (true){
            if(curBoy.next == first){//结束条件
                System.out.println("当前编号为: "+curBoy.no);
                break;
            }
            System.out.println("当前编号为: "+curBoy.no);
            curBoy = curBoy.next;//移动指针
        }
    }

    /**
     *
     * @param startNum 从startNum开始报数 即笔记中的k
     * @param turnNum 数turnNum下 即笔记中的m
     */
    public void problemSolving(int startNum, int turnNum){
        //创建辅助指针并让其指向链表中的最后一个节点
        Boy curBoy = first;
        while (curBoy.next != first){
            curBoy = curBoy.next;
        }
        //让curBoy和first移动k-1次
        for (int i = 0; i < startNum - 1; i++) {
            first = first.next;
            curBoy = curBoy.next;
        }
        while (first != curBoy){
            //让curBoy和first移动m-1次
            for (int i = 0; i < turnNum - 1; i++) {
                first = first.next;
                curBoy = curBoy.next;
            }
            System.out.println("现在出局的是: "+first.no);
            //执行出圈操作
            first = first.next;
            curBoy.next = first;
        }
        System.out.println("最后留下的是: "+first.no);
    }
}
class Boy{
    public int no;
    public Boy next;

    public Boy(int no){
        this.no = no;
    }
}
