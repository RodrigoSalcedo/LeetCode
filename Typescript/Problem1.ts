function findMedianSortedArrays(nums1: number[], nums2: number[]): number {
  let merge: number[] = [];
  let i: number = 0;
  let j: number = 0;
  while (i < nums1.length || j < nums2.length) {
    if (j >= nums2.length || (i < nums1.length && nums1[i] <= nums2[j])) {
      merge.push(nums1[i]);
      i++;
    } else {
      merge.push(nums2[j]);
      j++;
    }
  }
  const n = merge.length;
  if (n % 2 === 0) {
    return (merge[n / 2 - 1] + merge[n / 2]) / 2.0;
  } else {
    return merge[Math.floor(n / 2)];
  }
}
