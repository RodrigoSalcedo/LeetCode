class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        merge = []
        i=0
        j=0
        while i < len(nums1) and j < len(nums2):
            if nums1[i] <= nums2[j]:
                merge.append(nums1[i])
                i += 1
            else:
                merge.append(nums2[j])
                j += 1
        merge.extend(nums1[i:])
        merge.extend(nums2[j:])
        n=len(merge)
        if n % 2 == 0:
            return (merge[n // 2 - 1] + merge[n // 2]) / 2.0
        else:
            return merge[n // 2]