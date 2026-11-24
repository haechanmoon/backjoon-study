class Solution {
    public boolean isPalindrome(String s) {
        //List<String> parts
        s = s.toLowerCase();
        List<Character> parts = new ArrayList<>();
        for(int i = 0 ; i<s.length(); i++){
            if((s.charAt(i)>='a'&&s.charAt(i)<='z') || (s.charAt(i)>='0'&&s.charAt(i)<='9')){
                parts.add(s.charAt(i));
            }
        }
        if(parts.size()==2){
            return parts.get(0)==parts.get(1);
        }
        for(int i = 0; i<parts.size()/2;i++){
            if(parts.get(i)!= parts.get(parts.size()-i-1)){
                return false;
            }
        }
        return true;
    }
}