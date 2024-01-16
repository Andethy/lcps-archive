package nc.backtracking;

import java.util.ArrayList;
import java.util.List;

class Solution78 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subsetsHelper(nums, 0);
        return result;
    }

    private void subsetsHelper(int[] nums, int curr) {
        if (curr >= nums.length) {
            result.add(new ArrayList<>(temp));
        } else {
            temp.add(nums[curr++]);
            subsetsHelper(nums, curr);
            temp.remove(temp.size() - 1);
            subsetsHelper(nums, curr);
        }
    }
}
