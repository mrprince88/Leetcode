class Solution {
    int n;
    public boolean circularArrayLoop(int[] nums) {
        n=nums.length;
        
        // for(int i=0;i<n;i++) {
        //     if(nums[i]==0) continue;
        //     int j=i,len=0;
        //     while(nums[i]*nums[j] > 0) {
        //         int next=getNext(j,nums);
        //         if(next==j) break;
        //         j=next;
        //         len++;
        //         if(len>n) return true;
        //     }
        //     j=i;
        //     while(len-->0) {
        //         nums[j]=0; j=getNext(j,nums);
        //     }
        // }
        // return false;
        
        for(int i=0;i<n;i++) {
            
            if(nums[i]==0) continue;
            
            int slow=i,fast=getNext(i,nums);
            
            while(nums[slow]*nums[fast]>0 && nums[fast]*nums[getNext(fast,nums)]>0) {
                if(slow==fast) {
                    if(slow==getNext(slow,nums)) break;
                    return true;
                }
                slow=getNext(slow,nums); fast=getNext(getNext(fast,nums),nums);
            }
            
            int j=i;
            while(nums[j]*nums[i]>0) {
                nums[j]=0;
                j=getNext(j,nums);
            }
        }
        return false;
    }
    
    int getNext(int i,int[] nums) {
        int next=(i+nums[i])%n;
        return next<0 ? next+n : next;
    }
}


// class Solution {
//     int n;
//     public boolean circularArrayLoop(int[] nums) {
//         n=nums.length;
        
//         int []visited=new int[n];
        
//         for(int i=0;i<n;i++)
//             if(visited[i]==0 && dfs(nums,visited,i)) return true;
        
//         return false;
//     }
    
//     boolean dfs(int[] nums,int []visited,int curr) {
//         if(visited[curr]==2) return false;
//         if(visited[curr]==1) return true;
        
//         visited[curr]=1;
//         int next=(curr+nums[curr])%n;
//         if(next<0) next+=n;
        
//         if(next==curr || nums[next]*nums[curr]<0) {
//             visited[curr]=2;
//             return false;
//         }
        
//         if(dfs(nums,visited,next)) return true;
//         visited[curr]=2;
//         return false;
//     }
// }