class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = Arrays.stream(gas).sum();
        int costSum = Arrays.stream(cost).sum();
        if(gasSum < costSum){
            return -1;
        }
        int gasBalance = 0;
        int res = 0;
        for(int i=0; i<gas.length; i++){
            gasBalance += (gas[i] - cost[i]);
            if(gasBalance < 0){
                gasBalance = 0;
                res = i+1;
            }
        }
        return res;
    }
}
