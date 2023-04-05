package DataStructure.Stack;
public class Calculator2_0 {
    public static void main(String[] args) {
        String expression = "30+6*20-20";//所计算的表达式
        ArrayStackCal numStack = new ArrayStackCal(expression.length());//创建数栈
        ArrayStackCal operatorStack = new ArrayStackCal(expression.length());//创建符号栈

        int index = 0;//创建索引
        while(index < expression.length()){//遍历表达式
            char c = expression.charAt(index);
            if(isNum(c)){//判断当前字是否为数字
                String num = "";
                num += c;
                if(index == expression.length() - 1){//判断当前字是最后一位数字
                    numStack.push(Integer.parseInt(num));
                }else if(isNum(expression.charAt(index+1))){//判断当前字的下一位是否为数字
                    num += expression.charAt(++index);
                    numStack.push(Integer.parseInt(num));
                }else numStack.push(Integer.parseInt(num));
            }else {
                if(operatorStack.isEmpty()){
                    operatorStack.push(c);
                }else if(priority(c) >= priority((char) operatorStack.peek())){
                    operatorStack.push(c);
                }else {
                    int num1;
                    int num2 ;
                    char operator;
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    operator = (char) operatorStack.pop();
                    int res = cal(num1,num2,operator);
                    numStack.push(res);
                    operatorStack.push(c);
                }
            }
            index++;
        }

        while(!operatorStack.isEmpty()){
            int num1;
            int num2;
            char operator;
            num1 = numStack.pop();
            num2 = numStack.pop();
            operator = (char) operatorStack.pop();
            int res = cal(num1,num2,operator);
            numStack.push(res);
        }

        System.out.println(numStack.pop());
    }


    public static int cal(int num1, int num2, char operator){
        int res;
        switch (operator){
            case '+': res = num1 + num2;break;
            case '-': res = num2 - num1;break;
            case '*': res = num1 * num2;break;
            case '/': res = num2 / num1;break;
            default: res = 0;
        }
        return res;
    }

    public static boolean isNum(char c){
        return c >= '0' && c <= '9';
    }

    public static int priority(char c){
        if(c == '*'|| c == '/'){
            return 1;
        }else return 0;
    }
}

class ArrayStackCal{
    private final int maxSize;
    private final int[] arr;
    private int top = -1;

    public ArrayStackCal(int maxSize){
        arr = new int[maxSize];
        this.maxSize = maxSize;
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int data){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        arr[top] = data;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        return arr[top--];
    }

    public int peek(){
        return arr[top];
    }
}