class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0,j=0,k=0;
        int n=nums1.length;
        int m=nums2.length;
        int[] num3=new int[n+m];
        while((i<n)&&(j<m)){
            if(nums1[i]<=nums2[j]){
                num3[k]=nums1[i];
                i++;
                k++;
            }
            else{
                num3[k]=nums2[j];
                j++;
                k++ ;
            }
        }
        while(i<n){
            num3[k]=nums1[i];
                i++;
                k++ ;
        }
        while(j<m){
             num3[k]=nums2[j];
                j++;
                k++;
        }
        int a;
        double median=0.000;
        if(num3.length%2==0){
          a=num3.length/2;
            median= (num3[a]+num3[a-1])/2.0;
           return median;
        }
        else{
            a=num3.length/2;
            return num3[a];
        }

       
    }
}