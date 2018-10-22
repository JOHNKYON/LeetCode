package questions.codejam;

import java.io.*;

public class ProductTriplets {

    public void solve() throws IOException {
        FileInputStream input = new FileInputStream("questions/codejam/A-large.in");
        File fout = new File("questions/codejam/A.txt");
        FileOutputStream fos = new FileOutputStream(fout);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));

        int cases = Integer.parseInt(bufferedReader.readLine());
        for (int i=0; i<cases; i++){
            System.out.print(i);
            bufferedReader.readLine();
            String s = bufferedReader.readLine();
            StringBuilder sb = new StringBuilder();
            sb.append("Case #");
            sb.append(i+1);
            sb.append(": ");
            sb.append(count(s));
            bw.write(sb.toString());
            bw.newLine();
        }
        bw.close();
        bufferedReader.close();
    }

    public int count(String s) {
        String[] strs = s.split(" ");
        long[] numbers = new long[strs.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Long.parseLong(strs[i]);
        }

//        Arrays.sort(numbers);

        int count = 0;

        for (int z=2; z<numbers.length; z++){
            for (int y = 1; y < z; y++) {
                for (int x = 0; x < y; x++) {
                    if (numbers[x] * numbers[y] == numbers[z] ||
                            numbers[x] * numbers[z] == numbers[y] ||
                            numbers[y] * numbers[z] == numbers[x])
                        count++;
                }
            }
        }
        return count;
    }

//        while (z < numbers.length) {
//            if (numbers[x] * numbers[y] == numbers[z]) {
//                int x_temp = numbers[x];
//                int y_temp = numbers[y];
//                if (x_temp == y_temp) {
//                    int len = y - x + 1;
//                    int temp_count = 1;
//                    while (len-- > 0)
//                        temp_count *= len;
//                    count += temp_count;
//                } else {
//                    int count_x = 0;
//                    int count_y = 0;
//                    while (numbers[x++] == x_temp)
//                        count_x++;
//                    while (numbers[y--] == y_temp)
//                        count_y++;
//                    count += count_x * count_y;
//                }
//            }
//            if (numbers[x] * numbers[y] > numbers[z])
//                z++;
//            if (numbers[x] * numbers[y] < numbers[z]) {
//                int last_y = y;
//                y = z-1;
//                x = 0;
//                while (y > last_y && x < y) {
//                    if (numbers[x] * numbers[y] < numbers[z])
//                        x++;
//                    else if (numbers[x] * numbers[y] > numbers[z])
//                        y--;
//                    else {
//                        int x_temp = numbers[x];
//                        int y_temp = numbers[y];
//                        if (x_temp == y_temp) {
//                            int len = y - x + 1;
//                            int temp_count = 1;
//                            while (len-- > 0)
//                                temp_count *= len;
//                            count += temp_count;
//                        } else {
//                            int count_x = 0;
//                            int count_y = 0;
//                            while (numbers[x++] == x_temp)
//                                count_x++;
//                            while (numbers[y--] == y_temp)
//                                count_y++;
//                            count += count_x * count_y;
//                        }
//                    }
//                }
//                z++;
//            }
//        }
//        return count;
//    }
}
