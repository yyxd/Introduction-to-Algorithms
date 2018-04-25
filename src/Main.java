public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Chap1_InsertionSort isort = new Chap1_InsertionSort();
        int [] nums = new int[]{12,22,4,7,32,2,24,76,48,6,8,33,22,45};
        int [] mergeSortTest = new int[]{3,6,9,10,12,15,1,4,5,7};
        Chap2_MergeSort mSort = new Chap2_MergeSort();
        mSort.MergeSort(nums,0,nums.length-1);
        int []res = mSort.Merge(mergeSortTest,0,5,9);
for (int j:res)
    System.out.print(j+"    ");
System.out.println();
//        int [] ans = isort.ISort2(nums);
//        for (int i :ans)
//        {
//            System.out.print(i+"    ");
//        }
//        System.out.println();
    }
}
