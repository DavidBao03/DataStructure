package DataStructure.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //完成将一个中缀表达式转化为后缀表达式
        //1.1+((2+3)*4)-5
        //2.因为直接对一个字符串操作并不方便,因此先将此字符串转成中缀表达式对应的List
        //  即"1+((2+3)*4)-5" => ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        //3.将得到的中缀表达式对应的List => 对应的后缀表达式的List
        //  即ArrayList [1+((2+3)*4)-5] => [3,4,+,5,*,6,-]
        String expression = "1-((2+3)*4)-5";
        List<String> strings = toInfixExpressionList(expression);
        System.out.println(strings);

        System.out.println("-----------------------------");
        List<String> list = parseSuffixEpressionList(strings);
        System.out.println(list);
        System.out.println("-----------------------------");
        //先定义一个逆波兰表达式
        //(3+4)*5-6 => 3 4 + 5 * 6 -
        //为了方便 表达式中的数字与符号之间用空格隔开
        //String suffixExpression = list.toString();

        //思路
        //1.先将"3 4 + 5 * 6 -"放入ArrayList中
        //2.将ArrayList传递给一个方法,遍历ArrayList,配合栈完成计算
        //List<String> rpnList = getListString(suffixExpression);
        int res;
        res = calculate(list);
        System.out.println(res);
    }
    //方法:将中缀表达式转化成对应的ArrayList
    public static List<String> toInfixExpressionList(String expression){
        //创建List存放中缀表达式的内容
        List<String> ls = new ArrayList<>();
        int i = 0;//一个遍历的指针
        String str;//作对多位数的拼接工作
        char c;//每遍历一个字符,就放入c中
        do {
            c = expression.charAt(i);
            //如果c是一个非数字,就直接加入ls
            if(c > '9' || c < '0'){
                ls.add(c + "");
                i++;//指针后移
            }else{//如果c是一个数字,需要判断位数
                str = "";//先将str置为空
                while(i < expression.length() && ((c = expression.charAt(i)) <= '9' && (c = expression.charAt(i)) >= '0')){
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        }while (i < expression.length());
        return ls;
    }

    //将得到的中缀表达式对应的List => 对应的后缀表达式的List
    public static List<String> parseSuffixEpressionList(List<String> ls){
        //定义两个栈
        Stack<String> s1 = new Stack<>();//符号栈
        //说明:因为s2在整个转换过程中没有pop操作,而且后面还需要逆序输出
        //因此比较麻烦,这里就不用s2而改用ArrayList
        List<String> s2 = new ArrayList<>();//存储中间结果的list
        
        //遍历ls
        for (String item : ls) {
            //如果是一个数,直接加入s2
            if(item.matches("\\d+")){
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                //如果是右括号")",则依次弹出s1栈顶的运算符并加入s2,直到遇到左括号为止
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();//!!! 将左括号"("弹出,消除小括号
            } else {
                //当item的优先级小于或等于s1栈顶运算符的优先级时
                //将s1栈顶的运算符弹出并加入到s2中,并跳转再次比较
                while(s1.size() != 0 && Operation.getValue(item) <= Operation.getValue(s1.peek())){
                    s2.add(s1.pop());
                }
                //把item压入s1栈中
                s1.push(item);
            }
        }

        //将s1中剩余的项依次弹出并加入s2
        while(s1.size() != 0){
            s2.add(s1.pop());
        }

        return s2;
    }

    //选择一个逆波兰表达式,依次将数字和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression){
        //将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String element : split) {
            list.add(element);
        }
        return list;
    }

    //完成对逆波兰表达式的计算
    public static int calculate(List<String> list){
        //创建一个数栈(只需要一个栈即可)
        Stack<String> numStack = new Stack<>();
        for (String element : list) {
            //使用正则表达式来取出数
            if(element.matches("\\d+")){//匹配的是多位数
                //入栈
                numStack.push(element);
            }else {
                //pop出两个数并运算,在入栈
                int num1 = Integer.parseInt(numStack.pop());
                int num2 = Integer.parseInt(numStack.pop());
                int res = 0;
                switch (element.charAt(0)){
                    case '+': res += num1 + num2;break;
                    case '-': res += num2 - num1;break;
                    case '*': res += num1 * num2;break;
                    case '/': res += num2 / num1;break;
                    default:break;
                }
                numStack.push(String.valueOf(res));
            }
        }
        return Integer.parseInt(numStack.pop());
    }
}

//编写一个类Operation 可以返回一个运算符对应的优先级
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法返回对应的优先级数字
    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+": result = ADD;break;
            case "-": result = SUB;break;
            case "*": result = MUL;break;
            case "/": result = DIV;break;
            default:break;
        }
        return result;
    }
}