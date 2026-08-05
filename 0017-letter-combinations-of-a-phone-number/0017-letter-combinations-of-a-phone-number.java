class Solution {
        List<String> allPaths;
        StringBuilder path;
        String[] options = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        allPaths = new ArrayList<>();
        path = new StringBuilder();
        helper(digits,0);
        return allPaths;
    }
    void helper(String d,int i){
        if(i >= d.length()){
            allPaths.add(path.toString());
            return;
        }
        for(char ch : options[d.charAt(i) - '0'].toCharArray()){
            path.append(ch);
            helper(d,i + 1);
            path.setLength(path.length() - 1);
        }
    }
}