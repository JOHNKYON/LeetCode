package questions.codejam;

import java.io.*;

public class CaveEscape {
    int max;
    boolean flag;

    public void solve() throws IOException {
        FileInputStream input = new FileInputStream("questions/codejam/B_small.in");
        File fout = new File("questions/codejam/A.txt");
        FileOutputStream fos = new FileOutputStream(fout);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));

        int cases = Integer.parseInt(bufferedReader.readLine());
        for (int i=0; i<cases; i++){
            max = -1;
            flag = false;
            int N, M, E, Sr, Sc, Tr, Tc;
            String[] strs = bufferedReader.readLine().split(" ");
            N = Integer.parseInt(strs[0]);
            M = Integer.parseInt(strs[1]);
            E = Integer.parseInt(strs[2]);
            Sr = Integer.parseInt(strs[3]);
            Sc = Integer.parseInt(strs[4]);
            Tr = Integer.parseInt(strs[5]);
            Tc = Integer.parseInt(strs[6]);
            int[][] cave = new int[N+1][M+1];

            for (int row=1; row<=N; row++) {
                String[] line = bufferedReader.readLine().split(" ");
                for (int col=1; col<=M; col++) {
                    cave[row][col] = Integer.parseInt(line[col]);
                }
            }

            System.out.print(i);
            bufferedReader.readLine();
            String s = bufferedReader.readLine();
            StringBuilder sb = new StringBuilder();
            sb.append("Case #");
            sb.append(i+1);
            sb.append(": ");
            sb.append(escape(cave, E, Sr, Sc, Tr, Tc));
            bw.write(sb.toString());
            bw.newLine();
        }
        bw.close();
        bufferedReader.close();
    }

    public int escape(int[][] cave, int e, int sr, int sc, int tr, int tc) {
        return 0;
    }
}
