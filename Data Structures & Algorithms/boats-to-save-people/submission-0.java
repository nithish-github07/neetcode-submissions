class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int n = people.length;
        int l = 0, r = n-1;
        while(l<=r){
            if(people[l] + people[r] <= limit){
                l++; r--;
            }
            else r--;
            count++;
        }
        return count;
    }
}