import java.util.*;

public class BinaryWatch {
    List<String> res = new ArrayList<>();

    private void backtrack(int watch, int num, int current) {
        if (num == 0) {
            int hour = watch >> 6;
            int minute =  watch & 0b111111;
            if (hour < 12 && minute < 60)
                res.add(hour + ":" + String.format("%02d", minute));
            return;
        }

        if (current == 10) return;

        backtrack(watch | (1 << current), num - 1, current + 1);
        backtrack(watch, num, current + 1);
    }


    public List<String> readBinaryWatch(int num) {
        if (num == 0) {
            res.add("0:00");
            return res;
        }

        int watch;
        backtrack(0, num, 0);

        return res;
    }

    public static void main(String[] args) {
        BinaryWatch s = new BinaryWatch();

        System.out.println(s.readBinaryWatch(1));
    }
}
