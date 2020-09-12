class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int remaining = candies;
        int i = 0;
        int[] result = new int[num_people];
        
        while(remaining >0){
            int distribute = i+1;
            if(remaining >= distribute){
                result[i % num_people] += distribute;
            }else{
                result[i % num_people] += remaining;
                break;
            }
            
            remaining = remaining - distribute;
            i++;
        }
        return result;
    }
}
