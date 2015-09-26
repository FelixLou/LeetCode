Question: https://leetcode.com/problems/peeking-iterator/
```
    public Iterator<Integer> iterator;
    public int cache;
    public boolean afterPeek = false;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	}
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
	    if(afterPeek) return cache;
	    if(iterator.hasNext()){
	        cache = iterator.next();
            afterPeek = true;
            return cache;
	    }
        return null;
	}
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(afterPeek == true){
	       afterPeek = false;
	       return cache;
	    }
	    else{
	        if(iterator.hasNext())
	            return iterator.next();
	       return null;
	    }
	}

	@Override
	public boolean hasNext() {
	    return iterator.hasNext() || afterPeek;
	}
///////////////////////////////////////////////////////
    Integer n = null;                                  //新技能 GET！表示一个数不是int的时候，用Integer == null.
    private Iterator<Integer> iterator = null;
    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    public Integer peek() {
        if (n == null && iterator.hasNext()){       // remember check .hasNext() first!
            n = iterator.next();
        }
        return n;
    }
    public Integer next() {
        if (n!=null){
            int temp = n;
            n = null;
            return temp;
        }
        return iterator.next();
    }
    public boolean hasNext() {
        if (n!=null){
            return true;
        }
        return iterator.hasNext();
    }
```
