There are 8 prison cells in a row, and each cell is either occupied(1)or vacant(0).
Each day, whether the cell is occupied or vacant changes according to the following rules:
If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied. Otherwise, it becomes vacant.
Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)
Input: cells = [0,1,0,1,1,0,0,1], N = 7
Output: [0,0,1,1,0,0,0,0]

public int[] prisonAfterNDays(int[] cells, int N) {

    HashSet<String> versions = new HashSet<>();
    boolean startRepeating = false;
    int totalStates = 0;

    for(int i=0; i<N; i++){
        int[] nextDay = findNextState(cells);
        String nextDayString = Arrays.toString(nextDay);

        if(!versions.contains(nextDayString)){
            versions.add(nextDayString);
            totalStates ++;

        }else{
            //The next day pattern has been seen & stored
            startRepeating = true;
            break;
        }
        cells = nextDay;
    }
    if(startRepeating){

        N %= totalStates;

        for(int i=0; i< N; i++){
            cells = findNextState(cells);
        }
    }
    return cells;
}

private int[] findNextState(int[] curr){

    int[] newState = new int[curr.length];

    for(int i=1; i<curr.length-1; i++){

        newState[i] = curr[i-1] == curr[i+1]? 1: 0;
    }
    return newState;
}
