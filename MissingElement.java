//Time Complexity O(log n) (binary search)
//Space Compelxity: O(1)
public class MissingElement {
    public int findMissingElement(int[] nums) {

        int left = 0;
        int right = nums.length -1;
        int mid = 0;
        //always ask if the array will be 0 or 1 here as there will no missing element.
        if (right == 0 || right == -1) {
            return Integer.MAX_VALUE;
        }

        while (right -left > 1) {
            mid = left + (right-left)/2;
            // if the mid element - mid is equal to left element - left then we know all numbers are present on the left so now we need to go to right. Checking left element - left index is very important otherwise in 2nd pass we get stuck(happened in the interview)
            if (nums[mid]-mid == nums[left]-left) {
                left = mid;
            } else if (nums[mid]-mid == nums[right]-right){
                right = mid;
            }
        }
        return nums[left]+1;

    }


    public static void main(String[] args) {
        MissingElement me = new MissingElement();
        int[] nums = {1,2,3,4,6,7,8,9};
        System.out.println("Missing element:" +me.findMissingElement(nums));
        int[] nums1 = {1,3,4,5,6,7,8};
        System.out.println("Missing element:" +me.findMissingElement(nums1));
        int[] nums2 = {1,3};
        System.out.println("Missing element:" +me.findMissingElement(nums2));
        int[] nums3 = {100,101,102,103,105,106,107,108};
        System.out.println("Missing element:" +me.findMissingElement(nums3));
    }

}
