package RotateArray;

public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) return;
        int n = nums.length;
        k = k % n;
        if (k < 0) k += n;
        if (k == 0) return;
        
        // method 1, copy back, 287ms
        /*
        int[] copy = new int[n];
        for (int i=0;i<n;i++) copy[i] = nums[i];
        for (int i=0;i<n;i++) nums[(i+k<n)?(i+k):(i+k-n)] = copy[i];
        */
        
        // method 2, copy out k (<= n/2) numbers£¬257ms
        /*
        boolean goLeft = false;
        if (k > n/2) {
            goLeft = true;
            k = n - k;
        }
        int[] copy = new int[k];
        if (goLeft) {
            for (int i=0;i<k;i++) copy[i] = nums[i];
            for (int i=k;i<n;i++) nums[i-k] = nums[i];
            for (int i=n-k;i<n;i++) nums[i] = copy[i-n+k];
        } else {
            for (int i=0;i<k;i++) copy[i] = nums[n-k+i];
            for (int i=n-k-1;i>=0;i--) nums[i+k] = nums[i];
            for (int i=0;i<k;i++) nums[i] = copy[i];
        }
        */
        
        // method 3, in place, 273ms
        /*
        int rotated = 0;
        int index = n-1;
        while (rotated < n) {
            int copy = nums[index];
            int current = index;
            int next = index - k;
            if (next < 0) next += n;
            while (next != index) {
                nums[current] = nums[next];
                rotated++;
                current = next;
                next = current - k;
                if (next < 0) next += n;
            }
            nums[current] = copy;
            rotated++;
            index--;
        }
        */
        
        // method 3 again, copy out gcd(k, n) numbers, 269ms
        int gcd = n, remain = k;
        while (remain != 0) {
            int temp = gcd % remain;
            gcd = remain;
            remain = temp;
        }
        int[] copy = new int[gcd];
        for (int i=0;i<gcd;i++) copy[i] = nums[n-gcd+i];
        int index = n-gcd;
        for (int j=0;j<n/gcd-1;j++) {
            for (int i=0;i<gcd;i++) {
                int cur = (index+i<n)?(index+i):(index+i-n);
                int next = (index+i-k<0)?(index+i-k+n):(index+i-k);
                nums[cur] = nums[next]; 
            }
            index = (index-k<0)?(index-k+n):(index-k);
        }
        for (int i=0;i<gcd;i++) nums[-gcd+i+k] = copy[i];
    }
}