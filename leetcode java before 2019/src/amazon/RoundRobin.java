package amazon;

import java.util.LinkedList;
import java.util.Queue;

public class RoundRobin {
    public static class Process{
        int arrTime=0;
        int exeTime=0;
        public Process(int arr,int exe){
            this.arrTime=arr;
            this.exeTime=exe;
        }
    }
    public static float waitingTimeRobin1(int[] arrival, int[] run,
            int q) {
        int waitTime=0;
        Queue<Process> queue=new LinkedList<>();
        int curTime=0;
        int nextProIdx=0;
        while(!queue.isEmpty()||nextProIdx<arrival.length){
            if(!queue.isEmpty()){
                Process cur=queue.poll();
                waitTime+=curTime-cur.arrTime;
                curTime+=Math.min(cur.exeTime, q);
                for(int i=nextProIdx;i<arrival.length;i++){
                    if(arrival[i]<=curTime){
                        queue.offer(new Process(arrival[i],run[i]));
                        nextProIdx=i+1;
                    }else{
                        break;
                    }
                }
                if(cur.exeTime>q){
                    queue.offer(new Process(curTime,cur.exeTime-q));
                }
            }else{
                queue.offer(new Process(arrival[nextProIdx],run[nextProIdx]));
                curTime=arrival[nextProIdx];
                nextProIdx++;
            }
        }
        return (float)waitTime/arrival.length;
    }
    
    public static void main(String[] args) {
        int[] arrival1 = {0, 1, 4};
        int[] run1 = {5, 2, 3};
        int q1 = 3;
        System.out.print(waitingTimeRobin1(arrival1, run1, q1));
    }

}
