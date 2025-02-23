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

/* Count equals number in a list O(n) */
fun countNumbers(list: List<Int>): Map<Int, Int> {
    val map = mutableMapOf<Int, Int>()
    for (number in list) {
        map[number] = map.getOrDefault(number, 0) + 1
    }
    return map
}

/* Count equals number in a list */
fun countNumbersKotlin(list: List<Int>): Map<Int, Int> {
    return list.groupingBy { it }.eachCount()
}

/* Palindrome check in entire list O(n) but using extra memory */
fun palindromeCheck(list: List<Char>): Boolean {
    return list.reversed() == list
}

/* Palindrome check in entire list looping O(n) */
fun palindromeCheckLooping(list: List<Char>): Boolean {
    var indexDownTo = list.size - 1
    for (index in 0 until list.size / 2) {
        if (list[index] != list[indexDownTo]) {
            return false
        }
        indexDownTo -= 1
    }
    return true
}

fun printSampleLists() {
    val list = listOf(4, 4, 5, 6, 6, 7, 9, 10, 22, 10, 6, 9, 7)
    println("For a sample list{ ${list.joinToString()} }:")
    println("Inefficient remove duplicate on list O(n²): { ${removeDuplicates(list).joinToString()} } ")
    println(
        "Efficient remove duplicate with HashSet but doesn't insure the sequence on list O(n): { ${
            removeDuplicatesHashSet(
                list
            ).joinToString()
        } } "
    )
    println(
        "Efficient remove duplicate on list with MutableHashSet, insure the sequence and avoid create extra collections O(n): { ${
            removeDuplicatesMutableHashSet(
                list
            ).joinToString()
        } } "
    )
    println(
        "Efficient remove duplicate on list with LinkedHashSet, insure the sequence but consuming more memory O(n): { ${
            removeDuplicatesEfficientKotlin(
                list
            ).joinToString()
        } }"
    )
    println("Count equals numbers in list O(n): ${countNumbers(list)} ")
    val noPalindrome = listOf('a', 'b', 'c', 'd', 'e', 'f')
    val palindrome = listOf('a', 'b', 'c', 'f', 'c', 'b', 'a')
    println("Palindrome check in entire list [ ${noPalindrome.joinToString()} ] in O(n) but using extra memory: ${palindromeCheck(noPalindrome)} ")
    println("Palindrome check in entire list [ ${palindrome.joinToString()} ] in entire list looping O(n): ${palindromeCheckLooping(palindrome)} ")
}