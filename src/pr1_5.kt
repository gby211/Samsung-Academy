

//  internal class Point(var x:Int, var y:Int)
//  internal class CloudOfPoints(val points: ArrayList<Point>)


interface Movable {
    fun move( dx: Int, dy: Int)
}


// Ваш фрагмент будет помещён здесь
internal class Point(var x:Int, var y:Int): Movable{
    override fun move(dx: Int, dy: Int) {
        x += dx
        y += dy
    }
}

internal class CloudOfPoints(val points: ArrayList<Point>): Movable{
    override fun move(dx: Int, dy: Int) {
        for (point in points){
            point.x += dx
            point.y += dy
        }
    }

}


fun main() {
    val p = Point(1,1)
    val cloud = CloudOfPoints(arrayListOf(Point(1,1)))
    for (cl in cloud.points){
        println("${cl.x} ${cl.y}")
    }
    p.move(1,1); cloud.move(2,2)
    val p2 = cloud.points[0]
    println("${p.x} ${p.y}")
    println("${p2.x} ${p2.y}")
}