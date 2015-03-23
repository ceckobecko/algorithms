//merge sort

Random r = new Random()

def arr = []
for (int i = 0; i < 3; i++) {
    arr << r.nextInt(100)
}

def sort(ArrayList array, ArrayList a, ArrayList b) {
    def m = 0, n = 0
    for (int i = 0; i < array.size(); i++) {
        if(a[n] == null){
            array[i] = b[m]
            m++
            continue
        }
        if(b[m] == null){
            array[i] = a[n]
            n++
            continue
        }
        if (a[n] < b[m]) {
            array[i] = a[n]
            n++
        } else {
            array[i] = b[m]
            m++
        }
    }
    return array
}

def merge(ArrayList array) {
    if (array.size() == 1) {
        return array;
    }

    def a = [], b = []
    int middle = array.size() / 2

    for (int i = 0; i < middle; i++) {
        a << array[i]
        b << array[middle + i]
    }

    a = merge(a)
    b = merge(b)
    array = sort(array, a, b)
    return array
}

arr.each {
    print(it.toString() + ' | ')
}
println()
merge(arr).each {
    print(it.toString() + ' | ')
}
