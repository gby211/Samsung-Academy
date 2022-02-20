import java.util.Arrays

fun main() {
    arrayTest()
}

fun helloWorld(){
    print("Hello WORLD!!!!")
}

fun timeOfDay() {
    print("Enter hour of day - ")
    val hourOfDay: Int = readLine()!!.toInt()
    val timeOfDay: String

    timeOfDay = when (hourOfDay) {
        in 0..5 -> "Early morning"
        in 6..11 -> "Morning"
        in 12..16 -> "Afternoon"
        in 17..19 -> "Evening"
        in 20..23 -> "Late evening"
        else -> "Invalid"
    }
    println("Now - $timeOfDay")
}

fun templates(){
    val s = "abc"
    val str = "$s.length is ${s.length}" // evaluates to "abc.length is 3"
    println(str)
}

fun arrayTest(){
    val array:IntArray = intArrayOf(10,23,324,324,0x12,0b10010101)
    println(array.contentToString())

    var arrayConstr = IntArray(10, {0})
    println(arrayConstr.contentToString())

    val asc = IntArray(5) { i -> (i+1) }
    println(asc.contentToString())
    val asc2 = IntArray(5) { i -> (i*i) }
    println(asc2.contentToString())

}