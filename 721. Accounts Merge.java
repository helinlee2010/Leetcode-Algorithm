// Time & Space Complexity: O(m*n)
// m: accounts.size()
// n: number of emails in each account
// Approach: Undirected Graph + DFS / Recursion

public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToOwner = new HashMap<>();
        
        // Undirected graph for emails, each email treated as node
        // Key: Email; Value: Its neighbor (not all, but it's ok)
        Map<String, Set<String>> emailGraph = new HashMap<>();
        Set<String> emails = new HashSet<>();
        Set<String> visited = new HashSet<>();
        
        // Firstly, loop through each account, and each emails in this account. O(m*n). Map to owner, add to unique emails list, build undirected graph
        for(List<String> acc: accounts){
                String owner = acc.get(0);
                for(int i = 1; i<acc.size(); i++){
                        String email = acc.get(i);
                        emailToOwner.put(email, owner);
                        emails.add(email);
                        emailGraph.putIfAbsent(email, new HashSet<String>());
                        if(i == 1) continue;
                        // 2 directions
                        // Link curr email with its prev email
                        emailGraph.get(acc.get(i-1)).add(email);
                        emailGraph.get(email).add(acc.get(i-1)); 
                }
        }
        List<List<String>> result = new ArrayList<>();
        for(String email: emails){
                if(!visited.contains(email)){
                        List<String> emailsFromSamePerson = new ArrayList<>();
                        emailsFromSamePerson.add(email);
                        visited.add(email);
                        
                        dfs(emailGraph, email, visited, emailsFromSamePerson);
                        Collections.sort(emailsFromSamePerson);
                        
                        // Append the owner into this emails list
                        emailsFromSamePerson.add(0, emailToOwner.get(email));
                        result.add(emailsFromSamePerson);
                }
        }
        return result;
}


// Add all the neighor emails and neighor's neighobors

private void dfs(Map<String, Set<String>> emailGraph, String currEmail, Set visited, List<String> emailsFromSamePerson){
        
        Set<String> neighbors = emailGraph.get(currEmail);
        
        for(String nei: neighbors){
                if(!visited.contains(nei)){
                        emailsFromSamePerson.add(nei);
                        visited.add(nei);
                        dfs(emailGraph, nei, visited, emailsFromSamePerson);
                }
        } 
}
