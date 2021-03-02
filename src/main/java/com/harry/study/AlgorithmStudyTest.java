package com.harry.study;

import org.junit.jupiter.api.Test;
import java.util.*;

/**
 *
 * 死磕算法
 *
 * @author harry
 * @date 2021/1/13 10:54 上午
 **/
public class AlgorithmStudyTest {

    /**
     * @Author harry
     * @Description 求字符串数组最长前缀
     * @Date 2021/1/28 0028
     * @Param []
     * @return void
     **/
    @Test
    public void getMaxLongPrefix() {
        String[] array = {"flwe","flw","flwwe","flw"};
        String str = array[0];
        String str2 = "";
        int index = 1;
        while(index < array.length){
            for(int i=0; i < (str.length() < array[index].length()? str.length():array[index].length());
                i++){
                if(str.charAt(i) != array[index].charAt(i)){
                    break;
                }
                str2 += str.charAt(i);
            }
            str = str2;
            str2 = "";
            index++;
        }
        System.out.println(str);
    }

    /**
     * 求最大不重复的字串
     */
    @Test
    public void getMaxNotRepeatLength() {
        String str = "jsagdfjsgfkjsafuwifsjhbcsjbc";
        int length = str.length();
        int left = 0,right = 0,max = 0;
        Map<Character,Integer> map = new HashMap<>();
        while (right < length) {
            Character c = str.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(map.get(c)+1,left);
            }
            map.put(c,right++);
            max = Math.max(max,right-left);
        }
        System.out.println(max);
    }

    /**
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
     * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
     *
     *
     */
    @Test
    public void findRepeatNumber() {
        int[] nums = new int[]{0,2,5,2,3,4,4};
        int temp;
        for (int i = 0;i < nums.length;i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    System.out.println(nums[i]);
                    break;
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
    }

    /**
     * 排序组合合并
     *
     */
    @Test
    public void twoSortArrayMerge() {
        Integer[] array1 = {1,2,3,4};
        Integer[] array2 = new Integer[]{2,3,3};
        //暴力合并
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(array1));
        list.addAll(Arrays.asList(array2));
        list.sort((x,y)->x.compareTo(y));
        System.out.println(Arrays.toString(list.toArray()));
        //归并合并
        int sumLength = array1.length + array2.length;
        int i = 0,j = 0,k = 0;
        int[] array = new int[sumLength];
        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                array[k++] = array1[i++];
            } else {
                array[k++] = array2[j++];
            }
        }
        if (i != array1.length) {
            for (int l = i; l < array1.length; l++) {
                array[k++] = array1[l];
            }
        } else {
            for (int l = j; l < array2.length; l++) {
                array[k++] = array2[l];
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 数组中有个数字超过半数重复，请找出来
     */
    @Test
    public void testFindRepeatNum() {
        int[] nums = new int[]{4,4,6,1,4};
        int result = nums[0];
        int count = 1;
        for (int i = 1;i<nums.length;i++) {
            if (nums[i] == result) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                result = nums[i];
                count = 1;
            }
        }
        System.out.println(result);
    }

    /**
     * 数组中数字成对出现，只有两个是不成对的，找出来
     */
    @Test
    public void test1SizeNum() {
        int sum = 0;
        int[] nums = new int[]{4,4,6,1};
        for (int i = 0;i<nums.length;i++) {
            sum ^= nums[i];
        }
        System.out.println(sum);

        int first = 1;
        while ((sum&first) == 0) {
            first = first << 1;
        }
        System.out.println(first);
        int[] result=new int[2];
        for(int i=0;i<nums.length;i++){
            //将数组分类。
            if((nums[i]&first)==0){
                result[0]^=nums[i];
            } else{
                result[1]^=nums[i];
            }
        }
        System.out.println(result[0] +"----" + result[1]);
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * 合并排序链表
     */
    @Test
    public void mergeKLists() {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        ListNode[] list = new ListNode[]{node1,node2,node3};

        ListNode result = mergeKLists(list);
        System.out.print(result.toString());
    }


    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                q.add(node);
            }
        }
        while (!q.isEmpty()) {
            ListNode poll = q.poll();
            tail.next = poll;
            tail = tail.next;
            if (poll.next != null) {
                q.add(poll.next);
            }
        }
        return dummy.next;
    }

    class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 二叉树中某一路径的和为sum，返回路径
     * @param root
     * @param sum
     * @return
     */
    public void pathSum(TreeNode root, int sum,List<List<Integer>> list,Stack<TreeNode> s) {
        if (root != null) {
            s.push(root);
            if (root.left == null && root.right == null && sum == root.val) {
                List<Integer> list1 = new ArrayList<>();
                for (TreeNode t : s) {
                    list1.add(t.val);
                }
                list.add(list1);
            }
            pathSum(root.left,sum-root.val,list,s);
            pathSum(root.right,sum-root.val,list,s);
            s.pop();
        }
    }

    @Test
    public void testPathSum() {

        List<List<Integer>> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();

        TreeNode treeNode = new TreeNode(8);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(1);
        treeNode.left.left = new TreeNode(2);
        pathSum(treeNode,13,list,s);
        System.out.println(list);
    }

}
