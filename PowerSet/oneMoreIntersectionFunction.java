import java.util.List;

public PowerSet moreIntersection(List<PowerSet> listPowerSet) {
    PowerSet emptySet = new PowerSet();

    PowerSet main = listPowerSet.getFirst();
    for (int i = 1; i < listPowerSet.size(); i++) {
        main = main.intersection(listPowerSet.get(i));
        if (main.size() == 0) {
            return emptySet;
        }
    }
    return main;
}
