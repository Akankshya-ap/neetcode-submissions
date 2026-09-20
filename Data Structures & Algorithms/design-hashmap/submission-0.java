class MyHashMap {
    private int[] map;
    public MyHashMap() {
        map = new int[10000001];
        for(int i = 0;i<1000001; i++){
            map[i] = -1;
        }
    }
    
    public void put(int key, int value) {
        map[key] = value;
    }
    
    public int get(int key) {
        if(map[key]!=-1) return map[key];
        else return -1;
    }
    
    public void remove(int key) {
        map[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */