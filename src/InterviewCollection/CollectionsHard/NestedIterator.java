package InterviewCollection.CollectionsHard;

import java.util.*;

public class NestedIterator implements Iterator<Integer> {


    private List<Integer> flattenList;

    private int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        flattenList = new ArrayList<>();
        flatten(nestedList);
        index = 0;
    }

    @Override
    public Integer next() {
        return flattenList.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < flattenList.size();
    }

    private void flatten(List<NestedInteger> nestedList) {
        for (var item : nestedList) {
            if (item.isInteger())
                flattenList.add(item.getInteger());
            else
                flatten(item.getList());
        }
    }
}

//********************************************************
class NestedIterator2 implements Iterator<Integer> {

    private Stack<ListIterator<NestedInteger>> lists;

    public NestedIterator2(List<NestedInteger> nestedList) {
        lists = new Stack<>();
        lists.push(nestedList.listIterator());
    }

    public Integer next() {
        hasNext();
        return lists.peek().next().getInteger();
    }

    public boolean hasNext() {
        while (!lists.empty()) {
            if (!lists.peek().hasNext()) {
                lists.pop();
            } else {
                NestedInteger x = lists.peek().next();
                if (x.isInteger())
                    return lists.peek().previous() == x;
                lists.push(x.getList().listIterator());
            }
        }
        return false;
    }
}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
