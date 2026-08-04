class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int balance = 0, defect = 0, res = 0;
        for(int i=0; i<gas.length; i++){
            balance += (gas[i] - cost[i]);
            if(balance < 0){
                defect += balance;
                balance = 0;
                res = i + 1;
            }
        }
        return (balance + defect) >= 0 ? res : -1;
    }
}