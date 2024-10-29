
// 1.LinearSearch/LinearSearch.java
public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Target found
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 0, 1, 9};
        int target = 1;
        int result = linearSearch(arr, target);
        System.out.println("Element found at index: " + result);
    }
}
//2.BinarySearch/BinarySearch.java
import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid; // Target found
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 8, 9};
        int target = 6;
        int result = binarySearch(arr, target);
        System.out.println("Element found at index: " + result);
    }
}
//3. JumpSearch/JumpSearch.java
import java.util.Arrays;

public class JumpSearch {
    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int step = (int) Math.sqrt(n);
        int prev = 0;

        while (arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n) return -1; // Target not found
        }

        while (arr[prev] < target) {
            prev++;
            if (prev == Math.min(step, n)) return -1; // Target not found
        }
        return (arr[prev] == target) ? prev : -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 5, 6, 7, 8, 9};
        int target = 5;
        int result = jumpSearch(arr, target);
        System.out.println("Element found at index: " + result);
    }
}

//4. InterpolationSearch/InterpolationSearch.java
public class InterpolationSearch {
    public static int interpolationSearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high && target >= arr[low] && target <= arr[high]) {
            if (low == high) {
                if (arr[low] == target) return low;
                return -1;
            }

            int pos = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low]);
            if (arr[pos] == target) return pos;
            if (arr[pos] < target) low = pos + 1;
            else high = pos - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        int target = 30;
        int result = interpolationSearch(arr, target);
        System.out.println("Element found at index: " + result);
    }
}

//5. ExponentialSearch/ExponentialSearch.java
public class ExponentialSearch {
    public static int exponentialSearch(int[] arr, int target) {
        if (arr[0] == target) return 0;
        int i = 1;
        while (i < arr.length && arr[i] <= target) {
            i *= 2;
        }
        return binarySearch(arr, i / 2, Math.min(i, arr.length - 1), target);
    }

    private static int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int target = 10;
        int result = exponentialSearch(arr, target);
        System.out.println("Element found at index: " + result);
    }
}

//6.TernarySearch/TernarySearch.java
public class TernarySearch {
    public static int ternarySearch(int[] arr, int target, int left, int right) {
        if (right >= left) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            if (arr[mid1] == target) return mid1;
            if (arr[mid2] == target) return mid2;

            if (target < arr[mid1]) return ternarySearch(arr, target, left, mid1 - 1);
            else if (target > arr[mid2]) return ternarySearch(arr, target, mid2 + 1, right);
            else return ternarySearch(arr, target, mid1 + 1, mid2 - 1);
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        int result = ternarySearch(arr, target, 0, arr.length - 1);
        System.out.println("Element found at index: " + result);
    }
}
