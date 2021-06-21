package algorithms.searching.tough;

public class BinarySearchBadVersion {
    int number;
    int BAD_VERSION;

    public BinarySearchBadVersion(int BAD_VERSION) {
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
        while(left <= right) {
            int  mid = left + (right-left)/2;
            if(isBadVersion(mid) && (mid == 0 || !isBadVersion(mid - 1))) {
                return mid;
            } else if (!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
