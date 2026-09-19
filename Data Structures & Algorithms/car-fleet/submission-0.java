class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // car1, car2, car3, car4
        // pos1, pos2, pos3, pos4
        // time4, time1, tim2, time3 

        int n = position.length;
        double[][] cars = new double[n][2];
        for(int i = 0;i< n; i++){
            cars[i] = new double[]{position[i], (double)(target-position[i])/speed[i]};
        }

        Arrays.sort(cars, (a,b)-> Double.compare(b[0], a[0]));

        int fleets = 0;
        double currTime = 0;
        for(double[] car: cars){
            double time = car[1];
            if(time>currTime){
                fleets++;
                currTime = time;
            }

        }
        return fleets;


    }
}
