// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    
    Iterator<Integer> i=null;
    Integer nextEle=null;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        
        i=iterator;
        nextEle=i.next();
	    
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return nextEle;
        
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer ans=nextEle;
        if(i.hasNext())
            nextEle=i.next();
        else
            nextEle=null;
        return ans;
	}
	
	@Override
	public boolean hasNext() {
        return nextEle!=null;
	    
	}
}