//задачата е да преброим колко инжверсии има в не сортираният списък (IntegerArray.txt) използваме divide and conquer  алгоритъм - merge sort
// тук съм подобрил сортировката да работи дори различен от 2^n
class CountInversions {
    long counter = 0;

    def sort(ArrayList arrayList, ArrayList a, ArrayList b) {
        int n = 0, m = 0, i;
        for (i = 0; i < arrayList.size(); i++) {
            if (a[n] == null) {
                arrayList[i] = b[m]
                m++
                continue
            }
            if (b[m] == null) {
                arrayList[i] = a[n]
                n++
                continue
            }
            if (a[n] < b[m]) {
                arrayList[i] = a[n]
                n++
            } else if (b[m] < a[n]) {
                counter += a.size() - n
                arrayList[i] = b[m]
                m++
            }
        }
        return arrayList
    }

    def mergeSort(ArrayList arrayList) {
        if (arrayList.size() == 1) {
            return arrayList
        }
        def a = [], b = [];
        int middle = arrayList.size() / 2

        for (int i = 0; i < middle; i++) {
            a << arrayList[i]
            b << arrayList[middle + i]
        }
        if (arrayList.size() % 2 != 0) {
            b << arrayList[arrayList.size() - 1]
        }
        a = mergeSort(a)
        b = mergeSort(b)
        return sort(arrayList, a, b)
    }

    public static void main(String[] args) {
        def array = []
        //test case
        //def array = [6,3,2,1,4,7]
        //Random r = new Random()

        def file = new File('IntegerArray.txt');
        file.eachLine {
            array << Integer.parseInt(it)
        }

        def ci = new CountInversions()
        ci.mergeSort(array)
        println("Number of inversions is $ci.counter")

    }
}
