class Solution {
    public String largestNumber(int[] nums) {
        String[] str=new String[nums.length];
        
        for(int i=0;i<nums.length;i++)
            str[i]=String.valueOf(nums[i]);
        
        Arrays.sort(str,(a,b)-> (a+b).compareTo(b+a));
        
        StringBuffer sb=new StringBuffer();
        
        for(int i=str.length-1;i>=0;i--)
            sb.append(str[i]);
        
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        
        return sb.toString();
    }
}