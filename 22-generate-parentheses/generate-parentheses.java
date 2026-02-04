class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();

        dp.add(Arrays.asList("")); // dp[0]

        for (int i = 1; i <= n; i++) {

            List<String> curr = new ArrayList<>();

            for (int j = 0; j < i; j++) {

                for (String left : dp.get(j)) {
                    for (String right : dp.get(i - 1 - j)) {

                        curr.add("(" + left + ")" + right);
                    }
                }
            }

            dp.add(curr);
        }

        return dp.get(n);
    }
}