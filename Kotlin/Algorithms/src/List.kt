/* Create a new list without duplicate numbers */
fun removeDuplicates(list: List<Int>): List<Int> {
    val newList = mutableListOf<Int>()
    newList.add(list[0])
    for (i in 1 until list.size) {
        var isDuplicate = false
        for (numberNew in newList) {
            if (numberNew == list[i]) {
                isDuplicate = true
                break
            }
        }
        if (!isDuplicate) newList.add(list[i])
    }
    return newList
}

/*
* This solution has O(n) complexity and use HashSet who doesn't insure sequence
* because HashSet does not projected to preserver sequence at insertion
*/
fun removeDuplicatesHashSet(list: List<Int>): List<Int> {
    return list.toSet().toList()
}

/*
* This solution has O(n) complexity and use MutableHashSet to optimized memory,
* because does not create extra collections and insure the sequence because we add manually in the loop
*/
fun removeDuplicatesMutableHashSet(list: List<Int>): List<Int> {
    val alreadyAdd = mutableSetOf<Int>()
    alreadyAdd.add(list[0])
    val newList = mutableListOf<Int>()
    newList.add(list[0])

    for (i in 1 until list.size) {
        if (alreadyAdd.add(list[i])) newList.add(list[i])
    }
    return newList
}

/* This solution uses LinkedHashSet to insure sequence and O(n) complexity */
fun removeDuplicatesEfficientKotlin(list: List<Int>): List<Int> {
    return list.distinct()
}

fun printSampleLists() {
    val list = listOf(4, 4, 5, 6, 6, 7 ,9, 10, 22, 10, 6, 9, 7)
    println("For a sample list{ ${list.joinToString()} }:")
    println("Inefficient remove duplicate on list O(n²): { ${removeDuplicates(list).joinToString()} } ")
    println("Efficient remove duplicate with HashSet but doesn't insure the sequence on list O(n): { ${removeDuplicatesHashSet(list).joinToString()} } ")
    println("Efficient remove duplicate on list with MutableHashSet, insure the sequence and avoid create extra collections O(n): { ${removeDuplicatesMutableHashSet(list).joinToString()} } ")
    println("Efficient remove duplicate on list with LinkedHashSet, insure the sequence but consuming more memory O(n): { ${removeDuplicatesEfficientKotlin(list).joinToString()} }")
}