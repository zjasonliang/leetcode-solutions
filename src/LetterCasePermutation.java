import com.sun.prism.ReadbackRenderTarget;

import java.util.*;

public class LetterCasePermutation {
    public static int majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i< nums.length; i++)
            list.add(nums[i]);

        while (list.size() != 1) {
            List<Integer> newList = new ArrayList<>();

            for (int i = 0; i < list.size() / 2; i++)
                if (list.get(2 * i).equals(list.get(2 * i + 1)))
                    newList.add(list.get(2 * i));

            if (list.size() % 2 != 0 && (newList.size() * 2 + 1) % 4 == 1)
                newList.add(list.get(list.size() - 1));

            list = newList;
        }

        return list.get(0);
    }

    public static void main(String[] args) {
        int[] nums = {8,8,7,7,7};
        System.out.println(majorityElement(nums));
    }
}
