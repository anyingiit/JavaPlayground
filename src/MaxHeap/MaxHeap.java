package MaxHeap;

import Array.Array;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<E>(capacity);
    }

    public MaxHeap(){
        data = new Array<E>();
    }

    // 返回堆中的元素个数
    public int size(){
        return data.getSize();
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index){
        if(index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return index * 2 + 2;
    }

    // 向堆中添加元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k){

        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0 ){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    // 看堆中的最大元素
    public E findMax(){
        if(data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    // 取出堆中最大元素
    public E extractMax(){

        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return ret;
    }

//    private void siftDown(int k){
//        int inspect = k;
//        while (true){
//            if(data.get(leftChild(inspect)).compareTo(data.get(inspect)) < 0 && data.get(rightChild(inspect)).compareTo(data.get(inspect)) < 0) {
//                break;
//            }
//            if(data.get(leftChild(inspect)).compareTo(data.get(rightChild(inspect))) > 0) {
//                data.swap(inspect, leftChild(inspect));
//                inspect = leftChild(inspect);
//            }else {
//                data.swap(inspect, rightChild(inspect));
//                inspect = rightChild(inspect);
//            }
//        }
//    }

//    private void siftDown(int k){
//        int inspect = k;
//        while (true){
//            // 到达尾部
//            if(!hasIndex(leftChild(inspect)) && !hasIndex(rightChild(inspect))){
//                break;
//            }
//
//            // 当不存在右孩子时, 当前节点大于左孩子则siftDown完成
//            // 或
//            // 当左右孩子同时存在时, 并且当前节点同时大于左右孩子则siftDown完成
//            if((!hasIndex(leftChild(inspect)) && data.get(inspect).compareTo(data.get(leftChild(inspect))) > 0) || (hasIndex(rightChild(inspect)) && data.get(inspect).compareTo(data.get(leftChild(inspect))) < 0 && data.get(inspect).compareTo(data.get(rightChild(inspect))) < 0)){
//                break;
//            }
//
//            // 当右侧节点不存在时一定左孩子大于当前节点, 则执行交换
//            // 或
//            // *写不下去了, 太啰嗦还要再次判断左右谁更大, 更大的一方是否大于当前节点
//            if(!hasIndex(rightChild(inspect)) || data.get(leftChild(inspect)).compareTo(data.get(inspect)) > 0){
//                data.swap(leftChild(inspect), inspect);
//                inspect = leftChild(inspect);
//            }else {
//                data.swap(rightChild(inspect), inspect);
//                inspect = rightChild(inspect);
//            }
//        }
//    }

//    private void siftDown(int k){
//        int inspect = k;
//        while (true){
//            // 到达尾部
//            if(!hasIndex(leftChild(inspect)) && !hasIndex(rightChild(inspect))){
//                break;
//            }
//
//            if(!hasIndex(rightChild(inspect))){
//                if (data.get(leftChild(inspect)).compareTo(data.get(inspect)) > 0){
//                    data.swap(leftChild(inspect), inspect);
//                    inspect = leftChild(inspect);
//                }else {
//                    break;
//                }
//            }else {
//                int maxIndex;
//                if(data.get(leftChild(inspect)).compareTo(data.get(inspect)) > 0){ //当左孩子更大时
//                    maxIndex = leftChild(inspect);
//                }else {
//                    maxIndex = rightChild(inspect);
//                }
//
//                if(data.get(maxIndex).compareTo(data.get(inspect)) > 0){
//                    data.swap(maxIndex, inspect);
//                    inspect = maxIndex;
//                }else {
//                    break;
//                }
//            }
//        }
//    }

    private void siftDown(int k){
        int inspect = k;
        while (true){
            // 到达尾部
            if(!hasIndex(leftChild(inspect)) && !hasIndex(rightChild(inspect))){// 1. 保证了一定存在左孩子
                break;
            }

            // 2. 保证了后续一定会和最大的一方进行比较
            int maxIndex = leftChild(inspect);// 代码运行到这里说明左节点一定是存在的
            if (hasIndex(rightChild(inspect)) && data.get(rightChild(inspect)).compareTo(data.get(leftChild(inspect))) > 0){
                maxIndex = rightChild(inspect);
            }

            if(data.get(maxIndex).compareTo(data.get(inspect)) > 0){
                data.swap(maxIndex, inspect);
                inspect = maxIndex;
            }else {
                break;
            }
        }
    }

    private boolean hasIndex(int index){
        if (index < 0 || index > data.getSize()-1){
            return false;
        }
        return true;
    }
}
