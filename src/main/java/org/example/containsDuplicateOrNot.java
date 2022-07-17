package org.example;

import java.util.HashMap;

public class containsDuplicateOrNot {

    public static boolean containsDuplicate(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], 1);
            }
        }

        return false;

    }

    public static void main(String[] args) {
        boolean result1 = containsDuplicate(new int[]{1, 2, 3, 1});
        boolean result2 = containsDuplicate(new int[]{1, 2, 3, 4});
        boolean result3 = containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2});
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

    }


}
