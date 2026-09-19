class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int half = (m+n+1)/2;

        if(m<n){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tempN = m;
            m=n;
            n=tempN;
        }

        int l =0, r=m-1;

        while(l<=r){
            int i = (l+r)/2;
            int j = half - i-2;

            int Al = i>=0? nums1[i]: Integer.MIN_VALUE;
            int Ar = i<m-1 ? nums1[i+1]:Integer.MAX_VALUE;
            int Bl = j>=0 ? nums2[j]:Integer.MIN_VALUE;
            int Br = j<n-1? nums2[j+1]:Integer.MAX_VALUE;

            if(Al<=Br && Bl<=Ar){
                return (m+n)%2==0? (double)(Math.max(Al,Bl) + Math.min(Ar,Br))/2.0 : Math.max(Al,Bl);
            } else if(Al>Br){
                r = i-1;
            } else{
                l = i+1;
            }
        }
        return -1;
    }
}
