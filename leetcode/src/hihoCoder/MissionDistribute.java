package hihoCoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
/*
题目1 : 任务分配
描述
给定 N 项任务的起至时间( S1, E1 ), ( S2, E2 ), ..., ( SN, EN )， 计算最少需要多少台机器才能按时完成所有任务。
同一时间一台机器上最多进行一项任务，并且一项任务必须从头到尾保持在一台机器上进行。任务切换不需要时间。
输入
第一行一个整数 N，(1 ≤ N ≤ 100000)，表示任务的数目。 以下 N 行每行两个整数 Si, Ei，(0 ≤ Si < Ei ≤ 1000000000)，表示任务的起至时间。

输出
输出一个整数，表示最少的机器数目。

样例输入
5
1 10
2 7
6 9
3 4
7 10
样例输出
3
 */
import java.util.PriorityQueue;

/**
 * 
 * @author Jiexin Guo
 */
public class MissionDistribute {
    private static class Mission implements Comparable<Mission>{
        public int startTime;
        public int endTime;
        /* (non-Javadoc)
         * @see java.lang.Comparable#compareTo(java.lang.Object)
         */
        @Override
        public int compareTo(Mission o) {
            return this.startTime-o.startTime;
        }
        /**
         * @param startTime
         * @param endTime
         */
        public Mission(int startTime, int endTime) {
            super();
            this.startTime = startTime;
            this.endTime = endTime;
        }
        
    }
    public static void main(String[] args) {

        try (InputStreamReader is = new InputStreamReader(System.in);
                BufferedReader bufferedReader = new BufferedReader(is);) {
            int n = Integer.parseInt(bufferedReader.readLine());
            PriorityQueue<Mission> queue=new PriorityQueue<Mission>();
            for(int i=0;i<n;i++){
                String line=bufferedReader.readLine();
                String[] words=line.split("\\s+");
                queue.add(new Mission(Integer.parseInt(words[0]),Integer.parseInt(words[1])));
            }
            int currentTime=queue.poll().endTime;
            int maxMachineNumber=1;
            int currentMachineNumber=1;
            while(!queue.isEmpty()){
                Mission current=queue.poll();
                if(current.endTime<currentTime){
                    //currentMachineNumber
                }
            }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

}
