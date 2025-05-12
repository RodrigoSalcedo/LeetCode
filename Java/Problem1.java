class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> merge = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length || j < nums2.length) {
            if (j >= nums2.length || (i < nums1.length && nums1[i] <= nums2[j])) {
                merge.add(nums1[i++]);
            } else {
                merge.add(nums2[j++]);
            }
        }

        int n = merge.size();
        if (n % 2 == 0) {
            return (merge.get(n / 2 - 1) + merge.get(n / 2)) / 2.0;
        } else {
            return merge.get(n / 2);
        }
    }
}