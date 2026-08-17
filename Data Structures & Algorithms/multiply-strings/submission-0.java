class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];

        //reversing the strings
        StringBuilder sb1 = new StringBuilder(num1);
        StringBuilder sb2 = new StringBuilder(num2);
        sb1.reverse(); sb2.reverse();

        char[] n1 = sb1.toString().toCharArray();
        char[] n2 = sb2.toString().toCharArray();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int digit = (n1[i] - '0') * (n2[j] - '0');

                res[i + j] += digit;
                res[i + j + 1] += (res[i + j] / 10);
                res[i + j] = res[i + j] % 10;
            }
        }

        StringBuilder ans = new StringBuilder();
        int beg = m + n - 1;
        while(beg >= 0 && res[beg] == 0){
            beg--;
        }

        while(beg >= 0){
            ans.append(res[beg--]);
        }

        return ans.toString();
    }
}
