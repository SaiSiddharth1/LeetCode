class Solution {
    public int maxDepth(String s) {
        Stack<Character> stk = new Stack<>();
        int max = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                stk.push('(');
            }
            else if(s.charAt(i) == ')'){
                if(!stk.isEmpty()){
                    stk.pop();
                }
            }
            max = Math.max(max,stk.size());
        }
        return max;
    }
}