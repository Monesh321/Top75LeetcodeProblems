package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        //loop through each index and skip the same index for calculating products of other indexes and store the product in similar index of a new array
        //time complexity O(n^2)
        int[] arr = new int[nums.length];
        //outer loop to store result prods of each index in a new array
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            //looping through the given nums array
            for (int j = 0; j < nums.length; j++) {
                //skip if index is self
                if (j == i) {
                    System.out.println("skipping self while multiplying");
                } else {
                    //get product of rest of the indexes
                    product = product * nums[j];
                }
            }
            arr[i] = product;
        }

        return arr;
    }

    //Optimized code
    public static int[] productExceptSelf2(int[] nums) {
        //compute in 3 parts-- if count of zero = 1 then all other products are zero except itself
        //if count of zero is > 1 then all products are zero
        //if no zeros found then product except self is totalProd/itself
        //NB:calculate total prod product by skipping zeros and multiplying rest
        //time complexity O(n)
        int noOfZeros = 0;
        int index = -1;
        int prod = 1;
        int[] arr = new int[nums.length];
        //getting count of zeros and index of zero if there is one zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                noOfZeros++;
                index = i;
            } else {
                prod = prod * nums[i];
            }
        }
        //for more than one zero found then set all products to 0
        if (noOfZeros > 1) {
            Arrays.fill(arr, 0);
        }
        //if only one zero then set all as zero except self and find product after substituting self with 1
        else if (noOfZeros == 1) {
            nums[index] = 1;
            for (int i = 0; i < nums.length; i++) {
                if (i == index) {
                    int prod2 = prod / nums[i];
                    arr[i] = prod2;

                } else {
                    arr[i] = 0;
                }
            }

        }
        //if no zeros found then calculate each prod by dividing total prod with the number at each index
        else if (noOfZeros == 0) {
            for (int i = 0; i < nums.length; i++) {
                int prod2 = prod / nums[i];
                arr[i] = prod2;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] result1 = productExceptSelf2(new int[]{1, 2, 3, 4});
        int[] result2 = productExceptSelf2(new int[]{-1, 1, 0, -3, 3});
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }
}
