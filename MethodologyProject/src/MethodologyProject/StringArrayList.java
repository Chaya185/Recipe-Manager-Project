package MethodologyProject;

import java.util.ArrayList;
import java.util.List;

public class StringArrayList {
    private ArrayList<String> stringList;

    public StringArrayList(String[] stringArray) {
        stringList = new ArrayList<>();
        for (String str : stringArray) {
            stringList.add(str);
        }
    }

    public ArrayList<String> getStringList() {
        return stringList;
    }
}