import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author ahscuml
 * @date 2019/3/6
 * @time 23:53
 */
public class test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(0);
        list.set(0, 4);
        Collections.sort(list);
        for (int i: list) {
            System.out.print(i);
        }
    }
}