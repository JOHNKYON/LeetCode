package questions.leetcode72;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] cur = new int[n+1];

        for(int i=0; i<=n; i++){
            cur[i] = i;
        }

        for(int j=1;j<=m;j++){
            int pre=cur[0];
            cur[0]=j;

            for(int i=1;i<=n;i++){
                int temp = cur[i];
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    cur[i]=pre;
                else{
                    cur[i] = Math.min(pre+1, Math.min(cur[i-1]+1, cur[i]+1));
                }
                pre = temp;
            }
        }

        return cur[n];
    }
}
