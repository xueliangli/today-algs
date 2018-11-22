
<div align="center"><h1>today-algs</h1></div>
<div align="center">:speaking_head: Talk is easy, show me your code! :pencil2:</div>
<br>
<br>
<div style="font-family: 'Microsoft YaHei UI Light',serif ">
    <strong>:memo:项目介绍</strong>
</div>
<div>本项目主要目的是记录算法学习过程中的重点和具体代码实现</div>
<br>

<div style="font-family: 'Microsoft YaHei UI Light',serif ">
    <strong>1、初级阶段 ---</strong>
</div>
<br>

<table width="100%" align="center">
    <tr align="center">
        <td style="width: 30%">:books: 书籍</td>
        <td ><a href="books/《算法图解》.pdf">《图解算法》</a>、<a href="books/《大话数据结构》.pdf">《大话数据结构》</a>、<a href="books/《算法 第4版》.pdf">《算法4》</a></td>
    </tr>
    <tr align="center">
        <td style="width: 30%">:hammer_and_pick: 工具</td>
        <td > idea、<a href="https://algs4.cs.princeton.edu/home/">算法4官网(工具库+测试用例)</a></td>
    </tr>
</table>
<br>
<br>
<div style="font-family: 'Microsoft YaHei UI Light',serif ">
    <strong>:key: 重要概念</strong>
</div>
<br>

>递归

- 栈实现
- 关键确定基线条件和递归条件
- 函数式编程大量使用递归
- 与数组联系时，基线条件为：数组为空或只包含一个元素 len(array) < 2

>分治

- 找出基线条件，这种条件必须尽可能简单
- 不断将问题分解（或者说缩小规模），直到符合基线条件

>栈

- 找出基线条件，这种条件必须尽可能简单
- 不断将问题分解（或者说缩小规模），直到符合基线条件

>队列

- 找出基线条件，这种条件必须尽可能简单
- 不断将问题分解（或者说缩小规模），直到符合基线条件

>散列

- 找出基线条件，这种条件必须尽可能简单
- 不断将问题分解（或者说缩小规模），直到符合基线条件

>分治

- 找出基线条件，这种条件必须尽可能简单
- 不断将问题分解（或者说缩小规模），直到符合基线条件


<br>
<br>
<div style="font-family: 'Microsoft YaHei UI Light',serif ">
    <strong>:key: 排序算法</strong>
</div>
<br>

<table width="100%" align="center">
    <tr align="center">
        <td style="width: 20%">算法</td>
        <td style="width: 35%">时间复杂度</td>
        <td style="width: 35%">10万词排序时间</td>
        <td>实现</td>
    </tr>
    <tr align="center">
        <td style="width: 20%">快速排序</td>
        <td style="width: 35%">O (n * log n )</td>
        <td style="width: 35%">100毫秒</td>
        <td><a href="algs\src\sort\Quick01.java">:computer:</a></td>
    </tr>
    <tr align="center">
        <td style="width: 20%">选择排序</td>
        <td style="width: 35%">O (n 2 )</td>
        <td style="width: 35%">40000毫秒</td>
        <td ><a href="algs\src\sort\Selection01.java">:computer:</a></td>
    </tr>
</table>

>快速排序 

- 两种实现方法
- 利用分治和递归思想

>选择排序

- 设定每次外循环的左边为最小值
- 遍历内循环的过程中发现比假设小的就交换
- 利用嵌套for循环实现







