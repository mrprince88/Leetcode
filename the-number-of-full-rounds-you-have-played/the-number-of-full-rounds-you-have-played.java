class Solution {
    public int numberOfRounds(String startTime, String endTime) {
        int start=convert(startTime),end=convert(endTime);
        
        if(start>end)
            end+=24*60;
        
        start=(start+14)/15;
        end/=15;
        return Math.max(0,end-start);
    }
    
    int convert(String time) {
        String []a=time.split(":");
        return Integer.parseInt(a[0])*60 + Integer.parseInt(a[1]);
    }
}