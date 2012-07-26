import scala.tools.partest.instrumented.Instrumentation._
import instrumented._

object Test {

  def main(args: Array[String]): Unit = {
    // force predef initialization before profiling anything
    Predef

    // Cell1, inlining works
    val cell1: Cell1 = new Cell1
    startProfiling()
    cell1.inc()
    stopProfiling()
    println("Cell1")
    printStatistics()
    println

    // Cell2, inlining broken due to accessing a private field
    val cell2: Cell2 = new Cell2
    resetProfiling(); startProfiling()
    cell2.inc()
    stopProfiling()
    println("Cell2")
    printStatistics()
    println

    // Cell3, inlining doesn't work for traits (we get no warnings)
    val cell3: Cell3 = new Cell3
    resetProfiling(); startProfiling()
    cell3.inc()
    stopProfiling()
    println("Cell3")
    printStatistics()
    println
  }

}
