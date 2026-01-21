class Solution {
    public String minWindow(String s, String t) {
        int left = 0, count = 0, minLen = Integer.MAX_VALUE, stIndex = -1;
        int n = s.length();
        int m = t.length();

        int hash[] = new int[256];
        Arrays.fill(hash, 0);
        for(int i = 0; i < m; i++){
            hash[t.charAt(i)-'A']++;
        }

        for(int right = 0; right < n; right++){
            if(hash[s.charAt(right)-'A']>0){
                count++;
            }
            hash[s.charAt(right)-'A']--;

            while(count == m){
                if(right -left +1 < minLen){
                    minLen = right - left +1;
                    stIndex = left;
                }

                hash[s.charAt(left)-'A']++;
                if(hash[s.charAt(left)-'A']>0) count--;
                left++;
            }
        }

        return (stIndex == -1)? "": s.substring(stIndex, stIndex+minLen);
    }
}
