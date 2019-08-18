import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author ahscuml
 * @date 2019/3/6
 * @time 23:53
 */
public class test {

    /*public static void main(String[] args) {
        final int Inf = Integer.MAX_VALUE;
        int[][] graph = {{0, 4, Inf, 2, Inf},
                {4, 0, 4, 1, Inf},
                {Inf, 4, 0, 1, 3},
                {2, 1, 1, 0, 7},
                {Inf, Inf, 3, 7, 0}};

        int[] dist = {Inf, Inf, Inf, Inf, Inf};
        System.out.println(Dijkstra(graph,dist,0,5));
    }

    public static int Dijkstra(int[][] graph, int[] dist, int start, int end) {
        int pre = start;

        return 0;
    }*/

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        Collections.sort(list);
        System.out.println(list.toString());
        Collections.reverse(list);

        ArrayList<Integer> listSorted = new ArrayList<Integer>(Arrays.asList(new Integer[list.size()]));
        Collections.copy(listSorted, list);
    }
}