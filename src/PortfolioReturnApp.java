import java.util.*;

class Asset {
    String name;
    double rate;

    Asset(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return name + ":" + rate + "%";
    }
}

public class PortfolioReturnApp {
    public static void main(String[] args) {
        Asset[] assets = {
                new Asset("AAPL", 12),
                new Asset("TSLA", 8),
                new Asset("GOOG", 15)
        };

        mergeSort(assets, 0, assets.length - 1);
        System.out.println("Merge: " + Arrays.toString(assets));

        quickSort(assets, 0, assets.length - 1);
        System.out.println("Quick (desc): " + Arrays.toString(assets));
    }

    public static void mergeSort(Asset[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(Asset[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        Asset[] L = new Asset[n1];
        Asset[] R = new Asset[n2];
        for (int i = 0; i < n1; ++i) L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j) R[j] = arr[m + 1 + j];
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i].rate <= R[j].rate) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void quickSort(Asset[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Asset[] arr, int low, int high) {
        double pivot = arr[high].rate;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].rate > pivot) {
                i++;
                Asset temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Asset temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}