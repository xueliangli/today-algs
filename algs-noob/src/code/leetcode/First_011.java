package code.leetcode;

/**
 * @program: algs-noob
 * @description: 数组
 * @analysis: 中等难度
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-06 22:20
 **/
public class First_011 {
    /**
     * @description: 暴力法 ,n2,1
     */
    public int maxArea(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                //计算公式的获得,从内向外
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxarea;
    }

    /**
     * @description: 双指针, n, 1
     */
    public int maxArea2(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
