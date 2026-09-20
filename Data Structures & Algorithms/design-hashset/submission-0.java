class MyHashSet {
    // private boolean data[];
    private int[] set;

    public MyHashSet() {
        // data = new boolean[100000];
        set = new int[31251];
    }
    
    public void add(int key) {
        // if(data[key]!=true){
        //     data[key]=true;
        // }

        set[key/32] |= getMask(key);
    }

    private int getMask(int key){
        return 1<<(key%32);
    }
    
    public void remove(int key) {
        // data[key]=false
        if(contains(key)){
            set[key/32] ^=getMask(key);
        }
    }
    

    public boolean contains(int key) {
        // return data[key];
        return (set[key/32] & getMask(key))!=0;

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */