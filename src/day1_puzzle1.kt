import java.io.File

fun main() {
    val inputFile = File("input/day1.txt");
    val answer = inputFile.
                    readLines()
                    .map { it.toInt().div(3).minus(2) }.sum();
    println(answer);
}