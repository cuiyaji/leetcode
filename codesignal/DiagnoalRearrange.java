import java.util.*;

public class DiagnoalRearrange {
    public String test(char[][] a) {
        if(a == null || a.length == 0) return "";
        Map<Integer, String> map = new HashMap<>();

        for(int j = 0; j < a[0].length; j++) {
            for(int i = 0; i < a.length; i++) {
                int key = i - j >= 0 ? a.length - (i - j) : a.length + j - i;
                String cur = map.getOrDefault(key, "");
                map.put(key, cur + a[i][j]);
            }
        }

        // List<Pair<Integer, String>> list = new ArrayList<>();
        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            String li = entry.getValue();
            int n = li.length();

            for(int i = 0; i < a.length - n; i++) {
                li += li.charAt(i);
                
            }
            map.put(entry.getKey(), li);
            
        }
        
        List<Map.Entry<Integer, String>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        StringBuilder res = new StringBuilder();
        for(Map.Entry<Integer, String> entry : list) {
            res.append(entry.getKey());
        }

        
        return res.toString();
    }



    public static void main (String[] args) 
        { 
            // Scanner scanner  = new Scanner(System.in);
            // String s = scanner.nextLine();
            DiagnoalRearrange T = new DiagnoalRearrange();
            char[][] a = new char[][]{{'b', 'b'}, {'c', 'a'}};
            char[][] b = new char[][]{{'a', 'c', 'a', 'b', 'b'},
                                        {'c', 'b', 'a', 'c', 'b'},
                                        {'a', 'a', 'e', 'c', 'b'},
                                        {'b', 'b', 'd', 'a', 'g'},
                                        {'a', 'b', 'e', 'b', 'a'},
        };
            String res = T.test(b);
            System.out.println(res);
        } 

}