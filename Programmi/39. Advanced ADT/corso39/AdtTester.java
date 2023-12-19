public class AdtTester {
    public static void main(String[] args) {
        SortedSet set = new ArraySortedSet();
        SortedSet set2 = new ArraySortedSet();

        set.add("OK 1");
        set.add("OK 2");
        set.add("OK 3");
        set2.add("OK 3");
        set2.add("OK 19");
        set2.add("OK 4");

        SortedSet setMerged = ArraySortedSet.intersection(set, set2);

        System.out.println(setMerged);
    }
}