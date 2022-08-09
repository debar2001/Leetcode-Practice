class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int n:nums){
            pq.add(n);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
        // int n = nums.length;
        // Arrays.sort(nums);
        // return nums[n-k];
    }
}