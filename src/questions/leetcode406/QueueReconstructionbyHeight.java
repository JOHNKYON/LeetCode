package questions.leetcode406;

import java.util.ArrayList;
import java.util.List;

public class QueueReconstructionbyHeight {
    /*Sort and Insert*/
    public int[][] reconstructQueue(int[][] people) {
        sortByK(people);
        sortByH(people);
        return insert(people);
    }

    private int[][] insert(int[][] people){
        List<int[]> myList = new ArrayList<>();

        int index = 0;
        int k_now = 0;
        int last_pos = 0;

        for(int i=0; i<people.length; i++){
            if(people[i][1] == 0){
                myList.add(index, people[i]);
                index++;
            } else {
                if (k_now != people[i][1])
                    last_pos = 0;
                int count = people[i][1];
                for (index=0; index<myList.size() && count > 0; index++){
                    if (myList.get(index)[0] >= people[i][0])
                        count--;
                }
                if (last_pos >= index){
                    index = last_pos+1;
                }
                k_now = people[i][1];
                last_pos = index;
                myList.add(index, people[i]);
                index=0;
            }
        }
        return toArray(myList);
    }

    private int[][] toArray(List<int[]> list){
        int[][] array = new int[list.size()][];

        for (int i=0; i<list.size(); i++){
            array[i] = list.get(i);
        }

        return array;
    }

    private void sortByK(int[][] people){
        quickSort(people, 0, people.length-1, 1);
    }

    private void sortByH(int[][] people){
        int left = 0;
        int right = 0;
        while(right < people.length){
            if (people[right][1] != people[left][1]){
                quickSort(people, left, right-1, 0);
                left = right;
            } else{
                right++;
            }
        }
        quickSort(people, left, right-1, 0);
    }

    private void quickSort(int[][] people, int left, int right, int flag){
        if (left >= right)  return;
        int pivot = people[(left+right)/2][flag];

        int ptr1 = left;

        swap(people, (left+right)/2, right);

        while (people[ptr1][flag] < pivot){
            ptr1++;
        }
        int ptr2 = ptr1;
        while (ptr2 <= right){
            if (people[ptr2][flag] < pivot){
                swap(people, ptr2, ptr1);
                ptr1++;
            }
            ptr2++;
        }
        swap(people, ptr1, right);
        quickSort(people, left, ptr1-1, flag);
        quickSort(people, ptr1+1, right, flag);
    }

    private void swap(int[][] people, int left, int right){
        int[] temp = people[left];
        people[left] = people[right];
        people[right] = temp;
    }
}
