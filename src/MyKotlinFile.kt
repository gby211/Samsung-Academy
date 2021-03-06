import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val ggs = true && false
    println(ggs)
    var robot = Robot(-100, 110, Direction.UP)
    println(robot.toString())
    moveRobot(robot, 10, 10)
    println(robot.toString())

}

//////////////////////////////////// модуль 1.1

/*
ДНК состоит из 4 типов нуклеотидов: A (аденин), T (тимин), G (гуанин), C (цитозин).

Ваша программа получает на вход строку вида ATGCCTCTCTC и должна посчитать число нуклеотидов каждого типа (вывести числа через пробел в порядке как в строке выше).
 */
fun practicalWork1_2() {

    val string2 = readLine()?.toCharArray()
    val charsMap = mutableMapOf<Char, Int>()
    charsMap['A'] = 0
    charsMap['T'] = 0
    charsMap.put('G', 0)
    charsMap.put('C', 0)

    val builder = StringBuilder()

    string2?.forEach {
        charsMap[it] = charsMap.getOrDefault(it, 0) + 1
    }

    for (count in charsMap) builder.append("${count.value} ")
    println(builder.dropLast(1))
}

/*
Дана комната со сторонами a и b и ковер со сторонами m и n. Определить помещается ли ковер в комнату (ковер можно поворачивать, но нельзя складывать). На вход программе подается четыре вещественных числа, разделенных пробелом: a, b, m и n. На выходе необходимо напечатать "YES", если ковер помещается в комнату и "NO" в противном случае.

Пример входных данных:
10 5 7 3

Пример выходных данных:
YES
*/
fun practicalWork1_1() {
    val (aa, bb, mm, nn) = readLine()!!.split(' ')
    val a = aa.toDouble()
    val b = bb.toDouble()
    val m = mm.toDouble()
    val n = nn.toDouble()
    if (a * b < m * n) {
        println("NO")
    } else if (a < m && b < m) {
        println("NO")
    } else if (a < n && b < n) {
        println("NO")
    } else println("YES")
}

fun helloWorld() {
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

fun templates() {
    val s = "abc"
    val str = "$s.length is ${s.length}" // evaluates to "abc.length is 3"
    println(str)
}

fun arrayTest() {
    val array: IntArray = intArrayOf(10, 23, 324, 324, 0x12, 0b10010101)
    println(array.contentToString())

    var arrayConstr = IntArray(10, { 0 })
    println(arrayConstr.contentToString())

    val asc = IntArray(5) { i -> (i + 1) }
    println(asc.contentToString())
    val asc2 = IntArray(5) { i -> (i * i) }
    println(asc2.contentToString())

}

fun sumEven() {
    var rand = Random()
    val intAr = IntArray(10) { rand.nextInt(300) }
    var sum = 0
    val intArEv: ArrayList<Int> = ArrayList()
    for (value in intAr) {
        if (value % 2 == 0) {
            sum += value
            intArEv.add(value)
        }
    }
    println("Initial array - ${intAr.contentToString()}")
    println("ArrayList of even numbers - $intArEv")
    println("Sum of even numbers - $sum")
}

fun DimensionalArray() {
    var rand = Random()
    val intAr2 = Array(5, { IntArray(6, { rand.nextInt(10) }) })
    var max = Int.MIN_VALUE

    for (strArray in intAr2) {
        println(strArray.contentToString())
        var sum = 0
        for (num in strArray) {
            sum += num
        }
        if (max < sum)
            max = sum
    }
    println(max)

}

//////////////////////////////////// модуль 1.2


class InitOrderDemo(name: String) {
    val firstProperty = "Первое свойство: $name".also(::println)

    init {
        println("Первый блок инициализации: ${name}")
    }

    val secondProperty = "Второе свойство: ${name.length}".also(::println)

    init {
        println("Второй блок инициализации: ${name.length}")
    }
}


enum class CatDocument {
    VIBRISSAE, PAWS, TAIL
}


/*
Необходимо разработать класс для управления роботом (Robot), содержащий поля координат `x`, `y` (тип Int) и направления `direction`.
Для направления уже определён заранее тип `Direction`:

enum class Direction {
UP, DOWN, RIGHT, LEFT
}

Обратите внимание, что мы используем тип enum для указания направления. Для управления роботом определите методы turnLeft(),
turnRight(), stepForward(). Конструктор получает параметры (`x`, `y`, `direction`). Предусмотрите вывод состояния робота методом
`toString()` в виде "x: $x, y: $y, dir: $direction"

 */

enum class Direction {
    UP, DOWN, RIGHT, LEFT
}

class Robot(var x: Int, var y: Int, var direction: Direction) {

    fun turnLeft() {
        when (this.direction) {
            Direction.LEFT -> this.direction = Direction.DOWN
            Direction.RIGHT -> this.direction = Direction.UP
            Direction.DOWN -> this.direction = Direction.RIGHT
            Direction.UP -> this.direction = Direction.LEFT
        }
    }

    fun turnRight() {
        when (this.direction) {
            Direction.LEFT -> this.direction = Direction.UP
            Direction.RIGHT -> this.direction = Direction.DOWN
            Direction.DOWN -> this.direction = Direction.LEFT
            Direction.UP -> this.direction = Direction.RIGHT
        }
    }

    fun stepForward() {
        when (this.direction) {
            Direction.LEFT -> this.x -= 1
            Direction.RIGHT -> this.x += 1
            Direction.DOWN -> this.y -= 1
            Direction.UP -> this.y += 1
        }
    }

    override fun toString(): String {
        return "x: $x, y: $y, dir: $direction"
    }


    // Задача 2 пр 1.4


}
fun moveRobot(r: Robot, toX: Int, toY: Int) {
    while (!(r.x == toX && r.y == toY)) {
        while (toX != r.x) {
            if (r.x > toX) {
                while (r.direction != Direction.LEFT) {
                    r.turnRight()
                }
            } else {
                while (r.direction != Direction.RIGHT) {
                    r.turnRight()
                }
            }
            r.stepForward()
        }
        if (r.y > toY) {
            while (r.direction != Direction.DOWN) {
                r.turnRight()
            }
        } else {
            while (r.direction != Direction.UP) {
                r.turnRight()
            }
        }
        r.stepForward()
    }
}







