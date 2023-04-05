package DataStructure.Tree;

import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        byte[] contentBytes = str.getBytes();

        //root.preOrder();

        byte[] codedContentBytes = huffmanZip(contentBytes);
        System.out.println(Arrays.toString(codedContentBytes));

        System.out.println(""+new String(decode(codes,codedContentBytes)));


    }

    //编写解码的方法
    public static byte[] decode(HashMap<Byte,String> codes,byte[] codedContentBytes){
        //1.将数组内数据转化成二进制
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < codedContentBytes.length; i++) {
            boolean flag = (i != codedContentBytes.length - 1);
            stringBuilder1.append(btyeToBitString(flag,codedContentBytes[i]));
        }

        //2.反转编码表
        HashMap<String,Byte> reverseCodes = new HashMap<>();
        for (Map.Entry<Byte, String> entry : codes.entrySet()) {
            reverseCodes.put(entry.getValue(),entry.getKey());
        }

        //3.匹配编码表 还原原始byte数组
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder1.length();) {
            int count = 1;
            Byte temp = null;
            while(true){
                temp = reverseCodes.get(stringBuilder1.substring(i,i+count));
                if(temp == null){
                    count++;
                }else {
                    list.add(temp);
                    break;
                }
            }
            i += count;
        }

        //4.创建数组并返回
        byte[] originalBytes = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            originalBytes[i] = list.get(i);
        }
        return originalBytes;
    }
    public static String btyeToBitString(boolean flag,byte b){
        int temp = b;
        if(flag){
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if(flag){
            return str.substring(str.length()-8);
        }else {
            return str;
        }
    }

    //编写一个方法封装下列方法
    public static byte[] huffmanZip(byte[] arr){
        //1.获取原始节点
        List<codeNode> codeNodes = createList(arr);
        //2.创建赫夫曼树
        codeNode root = createHuffmanTree(codeNodes);
        //3.获取霍夫曼编码
        HashMap<Byte,String> huffmanCode = getCodes(root,"",stringBuilder);
        byte[] codedContentBytes = getCodedBytes(arr,huffmanCode);
        return codedContentBytes;
    }

    public void preOrder(codeNode node){
        if(node == null){
            System.out.println("空树");
        }else {
            node.preOrder();
        }
    }

    public static byte[] getCodedBytes(byte[] arr,HashMap<Byte,String> codes){
        StringBuilder stringBuilder = new StringBuilder();

        for (byte b : arr) {
            stringBuilder.append(codes.get(b));
        }

        int len = (stringBuilder.length() + 7)/8;
        byte[] codedBytes = new byte[len];
        int index =0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            if(i + 8 >= stringBuilder.length()){
                codedBytes[index] = (byte)Integer.parseInt(stringBuilder.substring(i),2);
            }else {
                codedBytes[index] = (byte)Integer.parseInt(stringBuilder.substring(i,i+8),2);
            }
            index++;
        }
        return codedBytes;
    }

    public static codeNode createHuffmanTree(List<codeNode> codeNodes){
        while (codeNodes.size() > 1){
            Collections.sort(codeNodes);
            codeNode right = codeNodes.get(1);
            codeNode left = codeNodes.get(0);
            codeNode parent = new codeNode(null, right.weight+ left.weight);
            parent.left = left;
            parent.right = right;
            codeNodes.remove(1);
            codeNodes.remove(0);
            codeNodes.add(parent);
        }
        return codeNodes.get(0);
    }

    static HashMap<Byte,String> codes = new HashMap<>();

    static StringBuilder stringBuilder = new StringBuilder();

    public static HashMap<Byte,String> getCodes(codeNode node, String code, StringBuilder stringBuilder){
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if(node != null){
            if(node.data == null){
                getCodes(node.left,"0",stringBuilder1);
                getCodes(node.right,"1",stringBuilder1);
            }else{
                codes.put(node.data,stringBuilder1.toString());
            }
        }
        return codes;
    }
    public static List<codeNode> createList(byte[] arr){
        ArrayList<codeNode> codeNodes = new ArrayList<>();

        HashMap<Byte,Integer> countMap = new HashMap<>();
        for (byte b : arr) {
            if(!countMap.containsKey(b)){
                countMap.put(b,1);
            }else {
                int temp = countMap.get(b);
                temp++;
                countMap.put(b,temp);
            }
        }

        for (Map.Entry<Byte, Integer> entry : countMap.entrySet()) {
            codeNodes.add(new codeNode(entry.getKey(),entry.getValue()));
        }

        return codeNodes;
    }
}

class codeNode implements Comparable<codeNode>{
    public Byte data;//表示字母
    public int weight;//表示字母出现次数
    public codeNode left;
    public codeNode right;

    public codeNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(codeNode o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }
}
