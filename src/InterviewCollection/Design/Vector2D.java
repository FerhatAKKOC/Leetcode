package InterviewCollection.Design;

import java.util.ArrayList;
import java.util.List;

public class Vector2D {

    public static void main(String[] args) {
        int[][] vector = {{1, 2}, {3}, {4, 5, 6}};

    }

    List<List<Integer>> listOfList;
    int listIndex;
    int elemIndex;

    public Vector2D(List<List<Integer>> vec2d) {
        listOfList = vec2d;
        listIndex = 0;
        elemIndex = 0;
    }

    public int next() {
        return listOfList.get(listIndex).get(elemIndex++);
    }

    public boolean hasNext() {
        while (listIndex < listOfList.size()) {
            if (elemIndex < listOfList.get(listIndex).size()) {
                return true;
            } else {
                listIndex++;
                elemIndex = 0;
            }
        }
        return false;
    }

}
