package DataStructure.HashTab;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("----------欢迎来到员工管理系统----------");
            System.out.println("请输入对应字符以操作:");
            System.out.println("add: 添加员工");
            System.out.println("find:查找员工");
            System.out.println("delete:删除员工");
            System.out.println("list:查看全部员工信息");
            System.out.println("exit:退出程序");

            String operation = scanner.next();
            switch (operation){
                    case "add":
                        System.out.println("请输入员工id:");
                        int id = scanner.nextInt();
                        System.out.println("请输入员工姓名");
                        String name = scanner.next();
                        Emp emp = new Emp(id,name);
                        hashTable.add(emp);
                        break;
                    case "find":
                        System.out.println("请输入员工id:");
                        int findId = scanner.nextInt();
                        hashTable.findEmpById(findId);
                        break;
                    case "list":
                        hashTable.list();
                        break;
                    case "delete":
                        System.out.println("请输入员工id:");
                        int deleteId = scanner.nextInt();
                        hashTable.delete(deleteId);
                        break;
                    case "exit":
                        scanner.close();
                        System.out.println("----------感谢使用员工管理系统----------");
                        break;
                }
        }
    }
}

class HashTable {
    EmpLinkedList[] empLinkedList;
    int size;

    public HashTable(int size){
        this.size = size;
        empLinkedList = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedList[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp){
        empLinkedList[hashCode(emp.id)].add(emp);
    }

    public void findEmpById(int id){
        int index = empLinkedList[hashCode(id)].findEmpById(id);
        if(index >= 0){
            System.out.println("该员工在第"+(hashCode(id)+1)+"条链表的第"+index+"位");
        }
    }

    public void delete(int id){
        empLinkedList[hashCode(id)].delete(id);
    }

    public void list(){
        for (int i = 0; i < size; i++) {
            if(empLinkedList[i] != null){
                empLinkedList[i].list(i+1);
            }
        }
    }
    public int hashCode(int id){
        return id % size;
    }
}
class Emp {
    public int id;
    public String name;
    public Emp next = null;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList {
    private Emp head;

    public void add(Emp emp){
        if(head == null){
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true){
            if(curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    public int findEmpById(int id){
        if(head == null){
            return -1;
        }

        Emp curEmp = head;
        int count = 0;
        while (true){
            if(curEmp.id == id){
                return count+1;
            }
            curEmp = curEmp.next;
            count++;
            if(curEmp == null){
                return -1;
            }
        }
    }

    public void delete(int id){
        if(head == null){
            System.out.println("删除失败");
            return;
        }else if(head.id == id){
            if(head.next == null){
                head = null;
            }else {
                head.next = head.next.next;
            }
            System.out.println("删除成功");
            return;
        } else if (head.next == null) {
            head = null;
            System.out.println("删除成功");
            return;
        }
        Emp curEmp = head;
        while (true){
            if(curEmp.next.id == id){
                curEmp.next = curEmp.next.next;
                System.out.println("删除成功");
                return;
            }
            curEmp = curEmp.next;
            if(curEmp.next == null){
                System.out.println("删除失败");
                break;
            }
        }
    }

    public void list(int no){
        if(head == null){
            System.out.println("第"+no+"条链表为空,无员工信息");
            return;
        }

        System.out.println("第"+no+"条链表的员工信息为");
        Emp curEmp = head;
        while (true){
            System.out.print("=> id = " + curEmp.id + " name = " + curEmp.name + "\t");
            if(curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }
}