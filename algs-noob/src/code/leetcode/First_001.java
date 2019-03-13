package code.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: algs-noob
 * @description: 数组
 * @analysis: 抄写, 返回数组中和为目标值的索引
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-06 21:30
 **/
public class First_001 {
    /**
     * @description: 第一种方法，暴力法，时间复杂度 on2，空间复杂度 o1
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == target - nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No solution");
    }

    /**
     * @description: 利用 hashmap ,返回的是索引
     */
    public int[] twoSum2(int[] nums, int target) {
        //以数组中的值作为键，索引作为值
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            //为什么要判断不是那个元素本身呢？因为那就不是两数的和了，而是只有一个数就等于
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No solution");
    }
}
