import java.util.*;

public class RiskThresholdSearchApp {
    public static void main(String[] args) {
        int[] riskBands = {10, 25, 50, 100, 200};
        int threshold = 30;

        int floor = findFloor(riskBands, threshold);
        int ceiling = findCeiling(riskBands, threshold);

        System.out.println("Sorted Risk Bands: " + Arrays.toString(riskBands));
        System.out.println("Threshold: " + threshold);
        System.out.println("Floor (Largest <= 30): " + floor);
        System.out.println("Ceiling (Smallest >= 30): " + ceiling);
    }

    public static int findFloor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                ans = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int findCeiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                ans = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}