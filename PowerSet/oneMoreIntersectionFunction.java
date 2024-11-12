import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class oneMoreIntersectionFunction {
    public Set moreIntersection(ArrayList<Set> listPowerSet) {
        Set emptySet = new HashSet<>();
        Set main = new HashSet<>(listPowerSet.getFirst());

        for (int i = 1; i < listPowerSet.size(); i++) {
            main.retainAll(listPowerSet.get(i));
            if (main.isEmpty()) {
                return emptySet;
            }
        }
        return main;
    }
}
