fun main() {
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
    print(str)
}