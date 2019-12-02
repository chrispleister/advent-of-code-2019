import java.io.File

fun main(args: Array<String>) {
    val input = File("input/day1.txt");
    val answer = input.readLines()
        .map { getFuelConsumption(it.toInt()) }
        .sum();
    println(answer);
}

private fun getFuelConsumption(mass: Int): Int {
    //method parameters are val's
    var _mass = mass;
    _mass = mass.div(3).minus(2);
    if (_mass > 0) {
        return _mass.plus(getFuelConsumption(_mass));
    }
    return 0;
}