int reverseDigitsInPairs(int n) {
    String str = n + "";
    String res = "";
    for(int i = 0; i < str.length(); i = i + 2){
        if(i + 1 < str.length()){
            res += str.charAt(i + 1) + "" + str.charAt(i);
        }
        else{
            res += str.charAt(i);
        }
    }
    return Integer.parseInt(res);
}