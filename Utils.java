public class Utils {

    // You can add more utilities if needed later!

    // Linear Search (example for searching in a String array)
    public static int linearSearch(String[] arr, String key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equalsIgnoreCase(key)) {
                return i;
            }
        }
        return -1;
    }

    // Selection Sort (example for sorting String array)
    public static void selectionSort(String[] arr) {
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j].compareTo(arr[min_idx]) < 0) {
                    min_idx = j;
                }
            }

            String temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}
