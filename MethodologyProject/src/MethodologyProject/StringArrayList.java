//This class is attempting to accept an array and turn it into an arrayList (to be used in Recipt object) to lessen the code for each hardcoded recipe object.
//still doesnt work correctly with main and Recipe...to be figured out
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
