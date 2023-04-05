package DataStructure.Recursion;

import java.util.Scanner;

public class Hanoi {
    public static void main(String[] args) {
        System.out.println("Enter the discs: ");
        Scanner scanner = new Scanner(System.in);
        int disc = scanner.nextInt();
        shift(disc,"POSE1","POSE2","POSE3");
    }
    public static void shift(int discs,String startPose,String interPose,String endPose){
        if(discs == 0){
            return;
        }
        shift(discs-1,startPose,endPose,interPose);
        System.out.println("move #" + discs + ": "+startPose+"-->"+endPose);
        shift(discs-1,interPose,startPose,endPose);
    }
}
