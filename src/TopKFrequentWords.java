import java.util.*;

public class TopKFrequentWords {
    class Word {
        int count;
        String s;
        Word(String s, int count) {
            this.s = s;
            this.count = count;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Word> pq = new PriorityQueue<>((w1, w2) -> {
            if (w1.count == w2.count) {
                return w2.s.compareTo(w1.s);
            } else {
                return w2.count - w1.count;
            }
        });

        for (String s : map.keySet()) {
            pq.add(new Word(s, map.get(s)));
        }

        List<String> res = new ArrayList<>();

        for (int i = 0; i < k; i++)
            res.add(pq.poll().s);

        return res;
    }
}
