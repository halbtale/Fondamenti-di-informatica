public class SetTester {
    public static void main(String[] args) {
        SortedSet set = new ArraySet();
        SortedSet set2 = new ArraySet();

        set.add("OK 1");
        set.add("OK 2");
        set.add("OK 3");
        set2.add("OK 3");
        set2.add("OK 19");
        set2.add("OK 4");

        SortedSet setMerged = ArraySet.subtract(set, set2);

        System.out.println(setMerged);
    }
}