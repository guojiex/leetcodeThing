package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosePoint {
    
    
    private final static double eps=0.00001;
    public static Point[] findClose3(Point[] arr, int k) {
        if(k==0)    return new Point[0];
        Comparator<Point> comparator=(o1,o2)->{
            double distance=o1.x*o1.x+o1.y*o1.y-o2.x*o2.x-o2.y*o2.y;
            if(distance>0){
                return 1;
            }else if(Math.abs(distance-0)<=eps){
                return 0;
            }else{
                return -1;
            }
        };
        PriorityQueue<Point> minHeap=new PriorityQueue<Point>(k,comparator);
        Point[] result=new Point[k];
        for(Point p:arr){
            minHeap.add(p);
        }
        for(int i=0;i<k;i++){
            result[i]=minHeap.poll();
        }
        
        return result;
    }
    public static void main(String[] args) {
       List<Point> input=new ArrayList<>();

       input.add(new Point(1.0,2.0));
       input.add(new Point(1.9,2.0));
       input.add(new Point(2.9,2.0));
       input.add(new Point(3.9,2.0));
       input.add(new Point(4.9,2.0));
       input.add(new Point(10.9,2.0));
       
       Point[] inputArray=new Point[input.size()];
       inputArray=input.toArray(inputArray);
       Point[] results=findClose3(inputArray, 3);
       for(Point p:results){
           System.out.println(p);
       }
       
    }

}
