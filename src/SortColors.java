import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

public class SortColors {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int current = left;

        while (left != right && current <= right) {
            if (nums[left] == 0) {
                left++;
                continue;
            }

            if (nums[right] == 2) {
                right--;
                continue;
            }

            if (current < left)
                current = left;

            if (nums[current] == 0) {
                nums[current] = nums[left];
                nums[left] = 0;
                continue;
            }

            if (nums[current] == 2) {
                nums[current] = nums[right];
                nums[right] = 2;
                continue;
            }

            current++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0};

        SortColors s = new SortColors();

        s.sortColors(nums);
    }
}
