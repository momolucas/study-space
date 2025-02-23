/* Searching the largest number in a integer array */
fun getLargestNumber(array: IntArray): Int {
    var largest = array[0]
    for (number in 1 until array.size) {
        if (largest < array[number]) largest = array[number]
    }
    return largest
}

fun revertArray(array: IntArray): IntArray {
    val newArray = IntArray(array.size)
    var newIndex = 0
    for (i in array.size - 1 downTo 0) {
        newArray[newIndex] = array[i]
        newIndex++
    }
    return newArray
}

fun reversedArray(array: IntArray): IntArray {
    return array.reversedArray()
}

fun sumOfElements(array: IntArray): Int {
    var sum = 0
    for (number in array) {
        sum += number
    }
    return sum
}

fun sumOfElementsKotlin(array: IntArray): Int {
    return array.sum()
}

fun printSamplesArrays() {
    val arraySample = intArrayOf(1, 7, 3, 10, 5)
    println("For a sample array[ ${arraySample.joinToString()} ]: ")
    println("Search the largest number O(n): ${getLargestNumber(arraySample)}") // Should print 10
    println("Revert array O(n): [ ${revertArray(arraySample).joinToString()} ]")
    println("Revert array using reversedArray() O(n): [ ${reversedArray(arraySample).joinToString()} ]")
    println("Sum of elements in Array O(n): ${sumOfElements(arraySample)}")
    println("Sum of elements in Array using sum O(n): ${sumOfElementsKotlin(arraySample)}")
}