package datastructure.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大堆特点：
 * 1、父节点的健值总是大于或者等于任何一个子节点的健值
 * 2、底层通过动态数组来实现
 * <p>
 * 添加步骤（上调算法）：
 * 1、将数据加到最后
 * 2、尽可能的将数据向上挪动，直到挪不动为止
 * <p>
 * 删除步骤：
 * 1、先删除该数据
 * 2、用最大堆中最后一个元素插入这个空位
 * 3、不断向上填补空位，保证替换后仍然是最大堆
 */
public class MaxHeap<T extends Comparable> {
    /**
     * 0、利用动态数组创建堆
     */
    private List<T> mHeap;

    MaxHeap() {
        this.mHeap = new ArrayList<>();
    }

    /**
     * 1、最大堆向下调整算法
     *
     * @param start 被下调节点的起始位置(一般为0，表示从第1个开始)
     * @param end   截至范围(一般为数组中最后一个元素的索引)
     */
    private void filterDown(int start, int end) {
        int c = start;
        int l = 2 * c + 1;
        T tmp = mHeap.get(c);
        while (l <= end) {
            int cmp = mHeap.get(l).compareTo(mHeap.get(l + 1));
            if (l < end && cmp < 0)
                l++;
            cmp = tmp.compareTo(mHeap.get(l));
            if (cmp >= 0)
                break;
            else {
                mHeap.set(c, mHeap.get(l));
                c = 1;
                l = 2 * l + 1;
            }
        }
        mHeap.set(c, tmp);
    }

    /**
     * 2、删除最大堆中的数值
     * <p>
     * 返回值为 0 或者 1
     *
     * @param data 要删除的数据
     */
    public int remove(T data) {
        if (mHeap.isEmpty())
            return -1;
        int index = mHeap.indexOf(data);
        if (index == -1)
            return -1;
        int size = mHeap.size();
        mHeap.set(index, mHeap.get(size - 1));
        mHeap.remove(size - 1);
        if (mHeap.size() > 1)
            filterDown(index, mHeap.size() - 1);
        return 0;
    }

    /**
     * 3、最大堆的向上调整算法(从start开始向上直到0，调整堆)
     *
     * @param start 被上调节点的起始位置(一般为数组中最后一个元素的索引)
     */
    private void filterUp(int start) {
        int c = start;
        int p = (c - 1) / 2;
        T tmp = mHeap.get(c);
        while (c > 0) {
            int cmp = mHeap.get(p).compareTo(tmp);
            if (cmp >= 0)
                break;
            else {
                mHeap.set(c, mHeap.get(p));
                c = p;
                p = (p - 1) / 2;
            }
        }
        mHeap.set(c, tmp);
    }

    /**
     * 4、将数据插入到二叉堆中
     * <p>
     * 无参数无返回值
     */
    void insert(T data) {
        int size = mHeap.size();
        mHeap.add(data);
        filterUp(size);
    }

    /**
     * 5、输出堆，将其转换成字符串
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T aMHeap : mHeap) {
            sb.append(aMHeap).append(" ");
        }
        return sb.toString();
    }
}
