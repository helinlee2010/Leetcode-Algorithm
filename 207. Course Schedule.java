// Directed Graph, DFS

public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count =0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] pre : prerequisites){
            int course = pre[0];
            int prereq = pre[1];
            if(!map.containsKey(course)){
                map.put(course, new LinkedList<>());
            }
            map.get(course).add(prereq);            
        }
        
        int[] status = new int[numCourses];
        
        for(int i=0; i<numCourses; i++){
            if(checkCycleDFS(i, status, map)) return false;
        }
        return true;
    }
    
    public boolean checkCycleDFS(int curr, int[] status, Map<Integer, List<Integer>> map){
        // Not visited yet: status[i] == 0
        // Visiting: status[i] == 1
        // Visited already : status[i] == 2
        if(status[curr] == 1){
            // there is a cycle
            return true;
        }else if(status[curr] == 2){
            // no cycle
            return false;
        }
        
        status[curr] = 1;
        
        List<Integer> prereqs = map.get(curr);
        if(prereqs!=null){
            for(int next: prereqs){
                if(checkCycleDFS(next, status, map)) return true;
            }
        }
        status[curr] = 2;
        return false;
    }
