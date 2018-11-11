import java.util.*;

public class MajorityElementII {
    private static boolean isMajority(int[] nums, int key) {
        int count = 0;
        for (int n : nums)
            if (n == key)
                count++;
        return count > nums.length / 3;
    }

    public static List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (counts.containsKey(nums[i])) {
                counts.put(nums[i], counts.get(nums[i]) + 1);
            } else {
                if (counts.size() < 2)
                    counts.put(nums[i], 1);
                else {
                    Iterator<Integer> it = counts.keySet().iterator();
                    while (it.hasNext()) {
                        Integer key = it.next();
                        if (counts.get(key) == 1) it.remove();
                        else counts.put(key, counts.get(key) - 1);
                    }

                    // for (Integer key : counts.keySet()) {
                    //     if (counts.get(key) == 1) counts.remove(key);
                    //     else counts.put(key, counts.get(key) - 1);
                    // }
                }
            }
        }
        List<Integer> res = new ArrayList<>();

        for (Integer key : counts.keySet()) {
            if (isMajority(nums, key)) res.add(key);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(majorityElement(nums));

        LinkedList<Integer> list = new LinkedList <>();
        list.addFirst(1);
    }
}
