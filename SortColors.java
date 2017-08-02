package sortColor;

import java.util.ArrayList;
import java.util.LinkedList;

class Point {
    int val;
    Point next;
    public Point(int a){
        this.val = a;
        this.next = null;
    }
}

public class SortColors {
    public void sortColors(int[] nums){
        Point pointZero = null;
        Point pointOne = null;

        Point head = new Point(-1);

        for (int i = 0; i < nums.length; i++){
            switch (nums[i]){
                case 0:
                    Point tmp = new Point(0);
                    tmp.next = head.next;
                    head.next = tmp;
                    if (pointZero == null){
                        pointZero = tmp;
                    }
                    break;
                case 1:
                    tmp = new Point(1);
                    if (pointZero == null){
                        tmp.next = head.next;
                        head.next = tmp;
                    }
                    else {
                        tmp.next = pointZero.next;
                        pointZero.next = tmp;
                    }
                    if (pointOne == null){
                        pointOne = tmp;
                    }
                    break;
                case 2:
                    tmp = new Point(2);
                    if (pointOne == null){
                        if (pointZero == null){
                            tmp.next = head.next;
                            head.next = tmp;
                        }
                        else {
                            tmp.next = pointZero.next;
                            pointZero.next = tmp;
                        }
                    }
                    else {
                        tmp.next = pointOne.next;
                        pointOne.next = tmp;
                    }
            }

        }
        Point pointer = head.next;
        int i = 0;
        while (pointer != null){
            nums[i] = pointer.val;
            pointer = pointer.next;
            i++;
        }
    }

    public static void main(String[] args){
        SortColors t = new SortColors();
        int[] nums = new int[]{1,2,1,1,2,0,1,2};
        t.sortColors(nums);
        for (int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
