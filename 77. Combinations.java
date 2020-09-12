// Recursion/ DFS


public List<List<Integer>> combine(int n, int k) {     
    List<List<Integer>> result = new ArrayList<>();
    // Edge case: if(n <=0 || k<-0 || k>n) return result;
    
    List<Integer> comb = new ArrayList<>();
    helper(1, n, k, comb, result);
    return result;
}

public void helper(int start, int end, int spots, List<Integer> combination, List<List<Integer>> result){
    if( spots == 0){
        result.add(new ArrayList<Integer>(combination));
        return;
    }
    // much faster than i<= end
    for(int i = start; i<= end - spots + 1; i++){
        combination.add(i);
        // DFS
        helper( i+1, end, spots-1, combination, result);
        combination.remove(combination.size()-1);  
    }
    return;
}
