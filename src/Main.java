public class Main {
    public static void main(String[] args) {
        final int[] initialArray = {4, 5, 6, 4, 5, 3, 4, 2, 4, 5, 7};

        int[] resultArray = new int[initialArray.length];
        int[] amountsArray = new int[initialArray.length];

        int amountOfDistinctValues = 0;
        // set distinctive values into the array
        for (int i = 0; i < initialArray.length; i++) {
            boolean isDistinct = false;
            for (int j = 0; j < i; j++) {
                if (initialArray[i] == initialArray[j]) {
                    isDistinct = true;
                    break;
                }
            }
            if (!isDistinct) {
                resultArray[amountOfDistinctValues++] = initialArray[i];
            }
        }

        // count amounts of identical values
        for (int i = 0; i < amountOfDistinctValues; i++) {
            int countIdentical = 0;
            for (int initialItem : initialArray) {
                if (initialItem == resultArray[i]) {
                    countIdentical++;
                }
            }
            amountsArray[i] = countIdentical;
        }

        // simple bubble sort to set into the ascending (by values) order
        for (int i = 0; i < amountOfDistinctValues; i++) {
            for (int j = i; j < amountOfDistinctValues; j++) {
                if (resultArray[i] > resultArray[j]) {
                    swapInts(resultArray, i, j); // swap values of the array
                    swapInts(amountsArray, i, j); // swap values of identical amounts of values
                }
            }
        }

        // map-like output of two arrays
        for (int i = 0; i < amountOfDistinctValues; i++) {
            System.out.println(resultArray[i] + " - " + amountsArray[i]);
        }
    }

    private static void swapInts(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
