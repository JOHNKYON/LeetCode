package questions.leetcode284;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer>{
    Integer cache;
    Iterator<Integer> iter;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        cache = null;
        iter = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (cache == null)
            cache = iter.next();
        return cache;
    }

    // hasNext() and next() should behave the same as in t
    // he Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (cache != null){
            Integer res = cache;
            cache = null;
            return res;
        }
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        if (cache != null)
            return true;
        return iter.hasNext();
    }
}
