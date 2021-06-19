package algorithms.searching.medium;

public class BinarySearchSpaces {
    public int sparseSearch(String[] array, String target) {
        int left = 0, right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid].isEmpty()) {
                int leftEnd = mid - 1, rightStart = mid + 1;
                while (leftEnd >= left || rightStart <= right) {
                    if (leftEnd >= left && !array[leftEnd].isEmpty()) {
                        mid = leftEnd;
                        break;
                    } else if (rightStart <= right && !array[rightStart].isEmpty()) {
                        mid = rightStart;
                        break;
                    }
                    leftEnd--;
                    rightStart++;
                }

                if (leftEnd < left && rightStart > right) {
                    return -1;
                }
            }

            if (array[mid] == target) {
                return mid;
            } else if (array[mid].compareTo(target) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
