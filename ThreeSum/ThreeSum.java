import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ThreeSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> data = new ArrayList<Integer>();

        while (scanner.hasNextInt()) {
            data.add(scanner.nextInt());
        }

        Collections.sort(data);

        for (int i = 0; i < data.size()-2; ++i) {
            int j = i+1;
            int k = data.size()-1;

            while (j < k) {
                int sum = data.get(i) + data.get(j) + data.get(k);

                if (sum == 0) {
                    System.out.println("i = " + data.get(i) +
                            " j = " + data.get(j) +
                            " k = " + data.get(k));
                }

                if (sum >= 0) {
                    --k;
                } else {
                    ++j;
                }
            }
        }
    }
}

/*
12
3
4
6
1
2
9
40
20
-20
-2
-8
-7
-5
-12
-8
^d
i = -12 j = -8 k = 20
i = -12 j = 3 k = 9
i = -8 j = 2 k = 6
i = -8 j = 2 k = 6
i = -7 j = -5 k = 12
i = -7 j = -2 k = 9
i = -7 j = 1 k = 6
i = -7 j = 3 k = 4
i = -5 j = 1 k = 4
i = -5 j = 2 k = 3
*/