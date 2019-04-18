package misc;

import java.util.*;

public class Test {

  private static List<List<String>> groupAnagrams(String[] words) {

    Map<String, List<String>> h = new HashMap<>();

    for (String wordStr : words) {
      char[] w = wordStr.toCharArray();
      Arrays.sort(w);
      h.computeIfAbsent(new String(w), k -> new ArrayList<>()).add(wordStr);
    }

    List<List<String>> res = new ArrayList<>();
    res.addAll(h.values());

    return res;
  }

  public static void main(String[] args) {

    //Comparator<Integer> cmp = Comparator.comparingInt(x -> x);
    //SortedMap<Integer, Integer> h = new TreeMap<>(cmp);
    //h.put(3, 1);
    //h.put(1, 2);
    //h.put(2, 3);
//
    //((TreeMap<Integer, Integer>) h).tailMap(1);
//
    //for (int key : h.keySet()) {
    //  System.out.println(key);
    //}


    String s = "ABC AND DEF AND alkdjla";
    String[] parts = s.split("AND");
    for (String part : parts) System.out.println(part);

  }

}
