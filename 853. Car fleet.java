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
