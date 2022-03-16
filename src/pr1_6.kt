fun main() {
    val ggs: String = "4561 2612 1234 5467"
    println(ggs.isValidCCNumber())
}

fun String.isValidCCNumber(): Boolean {
    var intArr = mutableListOf<Int>()
    var intArrOdd = mutableListOf<Int>()
    var sumAll = 0
    this.onEach { if (it in '0'..'9')intArr.add(it.toInt() - 48) }
    intArr.reverse()
    var tmp = true
    for (gg in intArr) {
        if (tmp) sumAll += gg.toInt() else intArrOdd.add(gg)
        tmp = !tmp
    }
    for (value in intArrOdd) {
        sumAll += if (value * 2 > 9) value * 2 % 10 + value * 2 / 10 else value * 2
    }

    return sumAll % 10 == 0
}