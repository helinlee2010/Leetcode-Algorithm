// Keywords: find 2 sum closest to a target

public class Solution {
	static class PairInt{
		int id; 
		int distance;
	
		PairInt(int id, int distance){
			this.id = id;
			this.distance = distance;
		}
		@Override
		public String toString() {
			return "[" + this.id + ", " + this.distance + "]";
		} 
	}
	static class RoutePair{
		int diff;
		int forwardId;
		int returnId;
		RoutePair(int diff, int forwardId, int returnId){
			this.diff = diff;
			this.forwardId = forwardId;
			this.returnId = returnId;
		}
	}
	static List<PairInt> optimalUtilization(int maxTravelDist,
	List<PairInt> forwardRouteList, List<PairInt> returnRouteList){
		// First, sort forward & return route list by ascending distance
		Collections.sort(forwardRouteList, (a,b) -> (a.distance - b.distance));
		Collections.sort(returnRouteList, (a,b)->(a.distance - b.distance));
		
		// min heap, pq w/ ascending diff
		PriorityQueue<RoutePair> pq = new PriorityQueue<>((a,b)->(a.diff-b.diff));
		
		int minDiff = Integer.MAX_VALUE;
		
		// Two pointers: l - left - scanning forwardRouteList from the start
		// r - right - scanning returnRouteList from the end
		int l = 0, r = returnRouteList.size()-1;
		while(l<forwardRouteList.size() && r>=0){
			PairInt forwardRoute = forwardRouteList.get(l);
			int forwardDist = forwardRoute.distance;
			PairInt returnRoute = returnRouteList.get(r);
			int returnDist = returnRoute.distance;
			int diff = maxTravelDist - (forwardDist + returnDist);
			if (diff>=0) {
			pq.add(new RoutePair(diff, forwardRoute.id, returnRoute.id));
			l++;
			}else { r--; }
		}
		
		List<PairInt> result = new ArrayList<>();
		RoutePair first = pq.poll();
		result.add(new PairInt(first.forwardId, first.returnId));
		
		// Keep polling out if the diff is the same
		while(pq.peek() != null){
			RoutePair next = pq.poll();
			if(next.diff == first.diff){
				result.add(new PairInt(next.forwardId, next.returnId)); 
			}
			if(next.diff != first.diff) break;
		}
		
		return result; 
	} 
	
	public static void main(String[] args) {
		List<PairInt> forwardRouteList1 = Arrays.asList(
			new PairInt(1,2000), 
			new PairInt(2,4000),
			new PairInt(3,6000)
		);
		List<PairInt> returnRouteList1 = Arrays.asList(
			new PairInt(1,2000)
		);
		List<PairInt> result1 = optimalUtilization(7000, forwardRouteList1, returnRouteList1);
		List<PairInt> forwardRouteList = Arrays.asList(
			new PairInt(2,5000), 
			new PairInt(1,3000),
			new PairInt(3,7000),
			new PairInt(4, 10000)
		);
		List<PairInt> returnRouteList = Arrays.asList(
			new PairInt(2,3000), 
			new PairInt(1,2000),
			new PairInt(3,4000),
			new PairInt(4, 5000)
		);
		List<PairInt> result2 = optimalUtilization(10000, forwardRouteList, returnRouteList);
		System.out.println("Result of Example 1: " + result1);
		System.out.println("Result of Example 2: " + result2);
	}
}
