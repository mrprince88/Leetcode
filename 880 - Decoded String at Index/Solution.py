class Solution:
    def decodeAtIndex(self, s: str, k: int) -> str:
        len=0
        for i in s:  
            if i.isdigit():
                len=len*int(i)
            else:
                len+=1
                
        for i in reversed(s):   
            k%=len    
            if k==0 and i.isalpha():
                return i      
            if i.isdigit():
                len=len/int(i)       
            else:
                len-=1  