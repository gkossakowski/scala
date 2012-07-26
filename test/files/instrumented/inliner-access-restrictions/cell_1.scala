// we need to put all classes into some dummy package because inliner doesn't
// find bytecode for classes in default package
package instrumented

/** This is canonical example where inlining works */
class Cell1 {
  final var value: Int = 0
  @inline final def inc(): Unit = value += 1
}

/** We make the var private and it breaks the inliner but we get a warning at least */
class Cell2 {
  private var value: Int = 0
  @inline final def inc(): Unit = value += 1
}

trait CellLike {
  final var value: Int = 0
  @inline final def inc(): Unit = value += 1
}

class Cell3 extends CellLike
