package Immutable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class A {

    private final int i;
    private final String name;
    private final List<String> stringList;
    private final Map<String, String> hashmapData;

    public A(int i, String name, List<String> stringList, Map<String, String> hashmapData) {
        this.i = i;
        this.name = name;
       // this.stringList = Collections.unmodifiableList(new ArrayList<>(stringList));
       // this.hashmapData = Collections.unmodifiableMap(new HashMap<>(hashmapData));
        this.stringList = stringList;
        this.hashmapData = hashmapData;
    }

    public int getI() {
        return i;
    }

    public String getName() {
        return name;
    }

    public List<String> getStringList() {
    	return stringList;
       // return new ArrayList(stringList);
    }

    public Map<String, String> getHashmapData() {
    	return hashmapData;
      //  return new HashMap<String, String>(hashmapData);
    }
}
