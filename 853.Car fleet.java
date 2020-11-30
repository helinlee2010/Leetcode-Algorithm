// O(nlogn) Approach with Priority Queue

public class Car{
    double time;
    int location; // bigger = closer to target
    Car(double t, int loc){
        this.time = t;
        this.location = loc;
    }
}

public int carFleet(int target, int[] position, int[] speed) {
    int num = position.length;
    if (num <1) return 0;
    
    PriorityQueue<Car> pq = new PriorityQueue<>((a,b) -> (b.location-a.location));
    for(int i = 0; i<num; i++){
        double time = (double) (target - position[i])/speed[i];
        pq.offer(new Car(time, position[i]));
    }
    
    int ans = 1;
    while(!pq.isEmpty()){
        Car curr = pq.poll();
        while(!pq.isEmpty() && pq.peek().time <= curr.time) pq.poll();
        if(!pq.isEmpty()) ans ++;
    }
    return ans;
}

// Optimization: O(N) Approach
// Instead of PQ, use array (no need to sort it)
// Array index-->Position;   Array value-->Speed

class Solution {
    
    public int carFleet(int target, int[] position, int[] speed) {
        int num = position.length;
        if (num <1) return 0;
        
        int[] speeds = new int[target];
        for(int i=0; i<num; i++){
            speeds[position[i]] = speed[i];
        }
        
        // First assume each car is a car fleet
        int ans = num;
        double slowestCar = -1;
        // Find the fleet, starting from the car closest to target
        for(int i=speeds.length-1; i>=0; i--){
            if(speeds[i]==0) continue;
            double time = (double) (target-i)/speeds[i];
            if(time > slowestCar){
                slowestCar = time;
            }else{
                ans--;
            }
        }
        return ans;
    }
}
