class DynamicArray {

    int[] dynamicArray;
    int count;
    int capacity;

    public DynamicArray(int capacity) {
        this.dynamicArray = new int[capacity];
        this.count = 0;
        this.capacity = capacity;
    }

    public int get(int i) {
        return dynamicArray[i];
    }

    public void set(int i, int n) {
        dynamicArray[i] = n;
    }

    public void pushback(int n) {
        if(count == capacity){
            resize();
        } 
        dynamicArray[count] = n;
        count++;
    }

    public int popback() {
        if(count>0){ count--; }
        return dynamicArray[count];
    }

    private void resize() {
        capacity*=2;
        int[] dynamicArrayDouble = new int[capacity];
        for(int i = 0; i<count; i++){
            dynamicArrayDouble[i] = dynamicArray[i];
        }
        dynamicArray = dynamicArrayDouble;
    }

    public int getSize() {
        return this.count;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
