long[] matrixQueries(int n, int m, int[][] queries) {
    HashSet<Integer> diactiveRows = new HashSet<>();
    HashSet<Integer> diactiveCols = new HashSet<>();
    ArrayList<Long> outputList = new ArrayList<>();
    for(int i = 0; i < queries.length; i++){
        if(queries[i][0] == 0){
            Long minRow = findMin(diactiveRows, n);
            Long minCol = findMin(diactiveCols, m);
            outputList.add(minRow * minCol);
        }
        else if(queries[i][0] == 1){
            diactiveRows.add(queries[i][1]);
        }
        else if(queries[i][0] == 2){
            diactiveCols.add(queries[i][1]);
        }
    }
    long[] resArr = new long[outputList.size()];
    for(int i = 0; i < outputList.size(); i++){
        resArr[i] = outputList.get(i);
    }
    return resArr;
}

public Long findMin(HashSet<Integer> set, int n){
    for(int i = 1; i <= n; i++){
        if(!set.contains(i)) return Long.valueOf(i);
    }
    return 0L;
}