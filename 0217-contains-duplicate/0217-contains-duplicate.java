class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
        }
        if(nums.length!=list.size()){
            return true;
        }
        return false;
    }
}