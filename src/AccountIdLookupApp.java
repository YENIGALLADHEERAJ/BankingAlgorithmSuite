import java.util.*;

public class AccountIdLookupApp {
    public static void main(String[] args) {
        String[] logs = {"accB", "accA", "accB", "accC", "accD", "accB"};
        String target = "accB";

        int firstIndex = linearSearchFirst(logs, target);
        int lastIndex = linearSearchLast(logs, target);

        System.out.println("Target: " + target);
        System.out.println("First Occurrence Index: " + firstIndex);
        System.out.println("Last Occurrence Index: " + lastIndex);

        Arrays.sort(logs);
        int count = countOccurrences(logs, target);
        System.out.println("Sorted Logs: " + Arrays.toString(logs));
        System.out.println("Binary Search Count: " + count);
    }

    public static int linearSearchFirst(String[] arr, String target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) return i;
        }
        return -1;
    }

    public static int linearSearchLast(String[] arr, String target) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].equals(target)) return i;
        }
        return -1;
    }

    public static int countOccurrences(String[] arr, String target) {
        int count = 0;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid].equals(target)) {
                count++;
                int temp = mid - 1;
                while (temp >= 0 && arr[temp].equals(target)) { count++; temp--; }
                temp = mid + 1;
                while (temp < arr.length && arr[temp].equals(target)) { count++; temp++; }
                break;
            } else if (arr[mid].compareTo(target) < 0) low = mid + 1;
            else high = mid - 1;
        }
        return count;
    }
}