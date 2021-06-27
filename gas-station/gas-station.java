class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length,gasSum=0,costSum=0,tank=0,start=0;
        
        for(int i=0;i<n;i++) {
            gasSum+=gas[i];
            costSum+=cost[i];
            tank+=gas[i]-cost[i];
            
            if(tank<0) {
                start=i+1;
                tank=0;
            }
        }
        
        if(gasSum>=costSum)
            return start;
        
        return -1;
    }
}