// Double directd Graph (Map), Recursion (DFS)
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 1. Create Map
        // Key: equations[i][0]
        // Value: (Map) equations[i][1], values[i]
        // And also the opposite
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for(int i=0; i<equations.size(); i++){
            String start = equations.get(i).get(0);
            String end = equations.get(i).get(1);
            double answer = values[i];
            graph.putIfAbsent(start, new HashMap<>());
            graph.get(start).put(end, answer);
            
            graph.putIfAbsent(end, new HashMap<>());
            graph.get(end).put(start, 1.0/answer);
        }
        
        // 2. Loop throught queries
        double[] result = new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            result[i] = findPath(start, end, graph, new HashSet<String>());
        }
        return result;
        
    }
    // 3. Helper functions: To find path
    private double findPath(String start, String end, Map<String, Map<String, Double>> graph, Set<String>visited){
        if(!graph.containsKey(start)) return -1.0;
        if(graph.get(start).containsKey(end)){
            return graph.get(start).get(end);
        }
        visited.add(start);
        for(Map.Entry<String, Double> entry: graph.get(start).entrySet()){
            String newStart = entry.getKey();
            if(!visited.contains(newStart)){
                // Recursion
                double bridge = findPath(newStart, end, graph, visited);
                if(bridge != -1.0){
                    return entry.getValue()*bridge;
                }
            }
        }
        return -1.0;    
    }
}
