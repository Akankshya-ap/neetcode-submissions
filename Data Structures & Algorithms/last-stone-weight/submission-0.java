class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> weight = new PriorityQueue<>((a,b)->(b-a));
        for(int stone: stones){
            weight.add(stone);
        }

        while(weight.size()>0){
            if(weight.size()==1) return weight.peek();

            int stone1 = weight.poll();
            int stone2 = weight.poll();
            if(stone1==stone2){
                continue;
            }
            weight.add(Math.abs(stone1-stone2));
        }

        return 0;
    }
}
