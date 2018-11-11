import javafx.scene.layout.BorderPane;

import java.util.LinkedList;
import java.util.Queue;

public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        boolean direction = true;
        int current = 0;

        @SuppressWarnings("unchecked") Queue<Character> [] queues = new LinkedList[numRows];

        for (int i = 0; i < numRows; i++)
            queues[i] = new LinkedList <>();

        for (int i = 0; i < s.length(); i++) {
            queues[current].add(s.charAt(i));

            if (direction) {
                if (current == numRows - 1) {
                    current --;
                    direction = false;
                } else current++;
            } else {
                if (current == 0) {
                    current++;
                    direction = true;
                } else current--;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            while (!queues[i].isEmpty())
                stringBuilder.append(queues[i].poll());
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
