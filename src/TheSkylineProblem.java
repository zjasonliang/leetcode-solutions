import java.util.*;

public class TheSkylineProblem {
    static class Event {
        int x;
        int y;
        boolean type; // true for entering, false for leaving

        public Event(int x, int y, boolean type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    public static List<int[]> getSkyline(int[][] buildings) {
        ArrayList<Event> events = new ArrayList <>();

        for (int i = 0; i < buildings.length; i++) {
            events.add(new Event(buildings[i][0], buildings[i][2], true));
            events.add(new Event(buildings[i][1], buildings[i][2], false));
        }


        events.sort((o1, o2) -> {
            if (o1.x == o2.x) {
                // o1 is entering and o2 is leaving
                if (o1.type && !o2.type) {
                    // process the entering event first
                    return -1;
                }

                if (!o1.type && o2.type) {
                    // process the entering event first
                    return 1;
                }

                if (o1.type && o2.type) {
                    return o2.y - o1.y;
                }

                if (!o1.type && !o2.type) {
                    return o1.y - o2.y;
                }
            }

            return o1.x - o2.x;
        });

        // PriorityQueue<Integer> heap = new PriorityQueue<>();
        // TreeSet<Integer> set = new TreeSet <>(Collections.reverseOrder());
        TreeMap<Integer, Integer> map = new TreeMap <>(Collections.reverseOrder());

        // set.add(0, 1);
        map.put(0, 1);

        List<int[]> res = new ArrayList <>();

        for (Event e : events) {
            if (e.type) {
                if (map.isEmpty() || e.y > map.firstKey())
                    res.add(new int[] {e.x, e.y});

                map.put(e.y, map.getOrDefault(e.y, 0) + 1);
            }
            else {
                if (map.get(e.y) == 1)
                    map.remove(e.y);
                else
                    map.put(e.y, map.get(e.y) - 1);
                if (map.isEmpty() || e.y > map.firstKey())
                    res.add(new int[] {e.x, map.firstKey()});
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] buildings = {
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}
        };

        // int[][] buildings = {
        //         {0, 2, 3},
        //         {2, 5, 3}
        // };

        List<int[]> res = getSkyline(buildings);

        System.out.println(res);
    }
}
