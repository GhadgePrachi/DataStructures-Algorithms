package algorithms.searching.easy;

public class BinarySearchBounds {
    int number;
    int BAD_VERSION;

    public BinarySearchBounds(int BAD_VERSION) {
        this.BAD_VERSION = BAD_VERSION;
    }
    boolean isBadVersion(int version){
        if(version == BAD_VERSION){
            return true;
        }
        return false;
    }

    public int firstBadVersion(int n) {
        this.number = n;
        int left = 1 , right = n;
        while(left < right) {
            int  mid = left + (right-left)/2;
            if(isBadVersion(mid)) {
                right = mid;
            } else {
                left=mid+1;
            }
        }

        if(!isBadVersion(left)){
            return -1;
        } else {
            return left;
        }
    }
}
