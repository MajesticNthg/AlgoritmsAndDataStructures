import java.util.ArrayList;

public class oneMoreIntersectionFunction {
    public PowerSet moreIntersection(ArrayList<PowerSet> listPowerSet) {
        PowerSet emptySet = new PowerSet();
        PowerSet first = listPowerSet.getFirst();
        PowerSet second = listPowerSet.get(1);
        PowerSet main = oneMoreIntersection(first, second);

        if (main.size() == 0) {
            return emptySet;
        }

        for (int i = 1; i < listPowerSet.size(); i++) {
            main = oneMoreIntersection(main, listPowerSet.get(i));
            if (main.size() == 0) {
                return emptySet;
            }
        }
        return main;
    }

    private PowerSet oneMoreIntersection(PowerSet set1, PowerSet set2) {
        PowerSet intersectionSet = new PowerSet();

        for (int i = 0; i < set1.size; i++) {
            if (set1.slots[i] == null) {
                continue;
            }

            if (set2.get(set1.slots[i])) {
                intersectionSet.put(set1.slots[i]);
            }
        }

        return intersectionSet;
    }
}
