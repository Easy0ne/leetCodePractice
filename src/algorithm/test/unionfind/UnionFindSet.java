package algorithm.test.unionfind;

import java.util.HashMap;
import java.util.List;

class Element<T> {
    public T val;

    public Element(T val) {
        this.val = val;
    }
}

public class UnionFindSet<T> {

    private HashMap<Element<T>, Element<T>> fatherMap;
    private HashMap<Element<T>, Integer> rankMap;

    public UnionFindSet(List<Element<T>> eles) {
        makeSets(eles);
    }

    private void makeSets(List<Element<T>> eles) {
        fatherMap = new HashMap<>();
        rankMap = new HashMap<>();
        //构建单元素并查集合
        for (Element<T> el : eles) {
            fatherMap.put(el, el);
            rankMap.put(el, 1);
        }
    }

    //查找元素所处集合的代表节点并压缩查找路径
    public Element<T> findFather(Element<T> e) {
        Element<T> father = fatherMap.get(e);
        if (e != father) {
            father = findFather(father);
        }
        fatherMap.put(e, father);
        return father;
    }

    //合并集合
    public void union(Element<T> a, Element<T> b) {
        if (a == null || b == null) return;
        Element<T> aF = findFather(a);
        Element<T> bF = findFather(b);
        if (aF != bF) {
            int aFRank = rankMap.get(aF);
            int bFRank = rankMap.get(bF);
            if (aFRank >= bFRank) {
                fatherMap.put(bF, aF);
                rankMap.put(aF, aFRank + bFRank);
            } else {
                fatherMap.put(aF, bF);
                rankMap.put(bF, aFRank + bFRank);
            }
        }//if
    }

    public boolean isSameSet(Element<T> a, Element<T> b) {
        return findFather(a) == findFather(b);
    }

}