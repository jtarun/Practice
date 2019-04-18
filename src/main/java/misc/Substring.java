package misc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Substring {

  static List<String> substr(String s) {

    TreeSet<String> tokens = new TreeSet<>();

    Set<Character> vowels = new HashSet<>();
    vowels.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    int n = s.length();
    for (int i = 0; i < n-1; i++) {
      char c = s.charAt(i);
      if (!vowels.contains(c)) continue;

      for (int j = i+1; j < n; j++) {
        char d = s.charAt(j);
        if (vowels.contains(d)) continue;
        String cur = s.substring(i, j+1);
        if (tokens.size() > 2 && cur.compareTo(tokens.last()) > 0) {
          tokens.remove(tokens.last());
        }
        tokens.add(cur);
      }
    }

    return Arrays.asList(tokens.first(), tokens.last());
  }

  public static void main(String[] args) {
    Substring.substr("aab").forEach(System.out::println);
  }

}
