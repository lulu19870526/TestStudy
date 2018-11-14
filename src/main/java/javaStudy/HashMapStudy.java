package javaStudy;

import java.io.IOException;

/**
 * Created by zengqx on 2018/10/31.
 */
public class HashMapStudy {

/*
    final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap, newThr = 0;
        if (oldCap > 0) {//桶数组table已被初始化
            if (oldCap >= MAXIMUM_CAPACITY) {//桶数组table的容量>=2的30次方，不再扩容，只是调大threshold
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                    oldCap >= DEFAULT_INITIAL_CAPACITY)//2倍桶数组table容量和2倍threshold，注意移位可能导致溢出
                newThr = oldThr << 1; // double threshold
        }
        else if (oldThr > 0)//桶数组table未被初始化且threshold>0,是调用HashMap(int initialCapacity, float loadFactor)或HashMap(int initialCapacity)这两个构造函数
        //上面两个构造函数中initialCapacity参数没有被保存下来,是通过threshold最终赋值给了newCap，参与桶数组的初始化过程
            newCap = oldThr;
        else {//oldCap=0&&oldThr=0,桶数组table未被初始化,是调用默认的构造函数如HashMap<String ,String> map  = new HashMap<String ,String>();
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {//调用HashMap(int initialCapacity, float loadFactor)或HashMap(int initialCapacity)这两个构造函数或移位溢出
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                    (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
        if (oldTab != null) { //将原来map中非null的元素rehash之后再放到newTab里面去
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)//如果oldTab[j]就一个元素，那么就直接放到newTab对应index的位置
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { //把该位置index对应的链表，按照(e.hash & oldCap)这个条件构成2个链表，值为0的链表还是放在newTab对应index上；值为oldCap链表放在newTab对应（index+原容量）位置上
                        Node<K,V> loHead = null, loTail = null;//放在原来位置
                        Node<K,V> hiHead = null, hiTail = null;//放在“j + oldCap”（当前位置index+原容量的值）
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) { //(e.hash & oldCap)，它只有两种结果，一个是0，一个是oldCap
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }


    public V remove(Object key) {
        Node<K,V> e;
        return (e = removeNode(hash(key), key, null, false, true)) == null ?
                null : e.value;
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    final Node<K,V> removeNode(int hash, Object key, Object value,
                               boolean matchValue, boolean movable) {
        Node<K,V>[] tab; Node<K,V> p; int n, index;
        if ((tab = table) != null && (n = tab.length) > 0 &&
                (p = tab[index = (n - 1) & hash]) != null) {//定位删除的key在桶数组table中的index
            Node<K,V> node = null, e; K k; V v;
            if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))//要删除的元素是链表的第一个节点
                node = p;
            else if ((e = p.next) != null) {
                if (p instanceof TreeNode)
                    node = ((TreeNode<K,V>)p).getTreeNode(hash, key);
                else {//遍历，找到要删除的节点
                    do {
                        if (e.hash == hash &&
                                ((k = e.key) == key ||
                                        (key != null && key.equals(k)))) {
                            node = e;
                            break;
                        }
                        p = e;
                    } while ((e = e.next) != null);
                }
            }
            //删除节点
            if (node != null && (!matchValue || (v = node.value) == value ||
                    (value != null && value.equals(v)))) {
                if (node instanceof TreeNode)
                    ((TreeNode<K,V>)node).removeTreeNode(this, tab, movable);
                else if (node == p)//要删除的元素是链表的第一个节点
                    tab[index] = node.next;
                else
                    p.next = node.next;
                ++modCount;
                --size;
                afterNodeRemoval(node);
                return node;
            }
        }
        return null;
    }
*/

    /*
    private void writeObject(java.io.ObjectOutputStream s)
            throws IOException {
        int buckets = capacity();
        // Write out the threshold, loadfactor, and any hidden stuff
        s.defaultWriteObject();
        s.writeInt(buckets);
        s.writeInt(size);
        internalWriteEntries(s);
    }

    final int capacity() {
        //优先级从右向左
        /**
         *  如果桶数组table不为空，则直接返回该table的大小
         *  如果桶数组table为空，且
         *       threshold>0,则返回threshold
         *       反之，返回16
         */
    /*
        return (table != null) ? table.length :
                (threshold > 0) ? threshold :
                        DEFAULT_INITIAL_CAPACITY;
    }
    */

}
