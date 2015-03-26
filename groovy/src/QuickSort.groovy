/**
 * Created by Tzvetan on 23.3.2015 г..
 */
class QuickSort {
    def array = new ArrayList<Integer>()

    def generateRandom(int maxSize) {
        def r = new Random()
        for (int i = 0; i < maxSize; i++) {
            array << r.nextInt(100)
        }
//        array = [3, 8, 2, 5, 1, 4, 7, 6]
    }

    def swap(Integer left, Integer right) {
        def temp = array[left]
        array[left] = array[right]
        array[right] = temp
    }

    def quickSort(Integer pivot, Integer left, Integer right) {
        if (right < left) return
        for (def i = left; i < right; i++) {
            if (array[i] < array[pivot]) {
                swap(left, i)
                left++
            }
        }
        swap(pivot, left - 1)
        println()
        print()
        quickSort(pivot, pivot + 1, left - 1)
        quickSort(left, left + 1, right)
    }

    def run() {
        Integer pivot = 0
        Integer left = pivot + 1
        Integer right = array.size()
        quickSort(pivot, left, right)
    }

    def print() {
        array.each {
            print(it + ' | ')
        }
    }


    public static void main(String[] args) {
        QuickSort qs = new QuickSort()
        qs.generateRandom(13)
        qs.print()
        qs.run()
        println()
        qs.print()
    }
}

