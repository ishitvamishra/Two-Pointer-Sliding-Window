class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];

        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j) &&
                   (j - i <= 2 || isPal[i+1][j-1])){
                    isPal[i][j] = true;
                }
            }
        }

        int[] dp = new int[n];

        for(int i = 0; i < n; i++){
            if(isPal[0][i]){
                dp[i] = 0;
            } else {
                int min = Integer.MAX_VALUE;
                for(int j = 0; j < i; j++){
                    if(isPal[j+1][i]){
                        min = Math.min(min, dp[j] + 1);
                    }
                }
                dp[i] = min;
            }
        }

        return dp[n-1];
    }
}
// IS SOLUTION ME TLE AASAKTA H~

// class Solution {
//     int minCut = Integer.MAX_VALUE;
//     public int minCut(String s) {
//         int cut = 0;
//         func(0, cut, s);
//         return minCut-1;
//     }

//     public void func(int index, int cut, String s){
//         if(index == s.length()){
//             minCut = Math.min(minCut, cut);
//             return;
//         }

//         for(int i = index; i < s.length(); i++){
//             if(isPalindrome(index, i, s)){
//                 cut++;
//                 func(i+1, cut, s);
//                 cut--;
//             }
//         }
//     }

//     public boolean isPalindrome(int start, int end, String s){
//         while(start <= end){
//             if(s.charAt(start++) != s.charAt(end--)){
//                 return false;
//             }
//         }
//         return true;
//     }
// }