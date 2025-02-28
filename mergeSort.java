import java.util.Random;

public class mergeSort {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[10000];
        for (int i=0; i <arr.length; i++){
            arr[i] = rand.nextInt(1000000000);
        }
        System.out.println("Before sort");
        printArray(arr);

        mergeSort(arr);

        System.out.println(" \n After sort");
        printArray(arr);


    }
    private static void mergeSort(int[] InputArr) {
        int inputLength = InputArr.length;
        if (inputLength < 2){
            return;
        }
        int middle = inputLength/2;
        int[] leftHalf = new int[middle];
        int[] rightHalf = new int[inputLength - middle];

        for (int i = 0; i<middle; i++){
            leftHalf[i] = InputArr[i];
        }
        for(int i = middle; i<inputLength; i++){
            rightHalf[i - middle] = InputArr[i];
        }
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(InputArr, leftHalf, rightHalf);
    }

    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;
        //compare elements in left and right array
        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]){
                inputArray[k] = leftHalf[i];
                i++;
            }
            else{
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        //Add remaining elements to the end of the array
        while (i<leftSize){
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j<rightSize){
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }

    }
    private static void printArray(int[] arr) {
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + "\n ");
        }
    }
}
