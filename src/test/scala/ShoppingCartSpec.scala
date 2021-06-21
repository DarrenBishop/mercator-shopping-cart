import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ShoppingCartSpec extends AnyFlatSpec with Matchers {

  val priceList = Map(
    "Apple" -> 0.60,
    "Orange" -> 0.25
  )

  val discounts = Map(
    "Apple" -> (2, 1),
    "Orange" -> (3, 2)
  )

  def discount(n: Int, disc: (Int, Int)): Int = {
    val (count, reduction) = disc
    (n / count) * reduction + (n % count)
  }

  def calculate(goods: List[String]): String = {
    "£%.02f".format(
      goods
        .groupMapReduce(identity)(_ => 1)(_ + _)
        .map { case (product, count) => priceList(product) * discount(count, discounts(product)) }
        .sum)
  }

  behavior of "Shopping Cart"
  note("Applying discounts: buy one, get one free on Apples; 3 for the price of 2 on Oranges")

  {
    val inputs = List("Apple", "Apple", "Orange", "Apple")

    val expectation = "£1.85"

    it should s"output '$expectation' for inputs `${inputs.mkString(", ")}`" in {

      calculate(inputs) should equal(expectation)
    }
  }

  {
    val inputs = List("Orange")

    val expectation = "£0.25"

    it should s"output '$expectation' for inputs `${inputs.mkString(", ")}`" in {

      calculate(inputs) should equal(expectation)
    }
  }

  {
    val inputs = List("Orange", "Orange")

    val expectation = "£0.50"

    it should s"output '$expectation' for inputs `${inputs.mkString(", ")}`" in {

      calculate(inputs) should equal(expectation)
    }
  }

  {
    val inputs = List("Orange", "Orange", "Orange")

    val expectation = "£0.50"

    it should s"output '$expectation' for inputs `${inputs.mkString(", ")}`" in {

      calculate(inputs) should equal(expectation)
    }
  }

  {
    val inputs = List("Orange", "Orange", "Orange", "Orange")

    val expectation = "£0.75"

    it should s"output '$expectation' for inputs `${inputs.mkString(", ")}`" in {

      calculate(inputs) should equal(expectation)
    }
  }

  {
    val inputs = List("Orange", "Orange", "Orange", "Orange", "Orange")

    val expectation = "£1.00"

    it should s"output '$expectation' for inputs `${inputs.mkString(", ")}`" in {

      calculate(inputs) should equal(expectation)
    }
  }

  {
    val inputs = List("Orange", "Orange", "Orange", "Orange", "Orange", "Orange")

    val expectation = "£1.00"

    it should s"output '$expectation' for inputs `${inputs.mkString(", ")}`" in {

      calculate(inputs) should equal(expectation)
    }
  }

  {
    val inputs = List("Orange", "Orange", "Orange", "Orange", "Orange", "Orange", "Orange")

    val expectation = "£1.25"

    it should s"output '$expectation' for inputs `${inputs.mkString(", ")}`" in {

      calculate(inputs) should equal(expectation)
    }
  }

  {
    val inputs = List("Apple")

    val expectation = "£0.60"

    it should s"output '$expectation' for inputs `${inputs.mkString(", ")}`" in {

      calculate(inputs) should equal(expectation)
    }
  }

  {
    val inputs = List("Apple", "Apple")

    val expectation = "£0.60"

    it should s"output '$expectation' for inputs `${inputs.mkString(", ")}`" in {

      calculate(inputs) should equal(expectation)
    }
  }

  {
    val inputs = List("Apple", "Apple", "Apple")

    val expectation = "£1.20"

    it should s"output '$expectation' for inputs `${inputs.mkString(", ")}`" in {

      calculate(inputs) should equal(expectation)
    }
  }

  {
    val inputs = List("Apple", "Apple", "Apple", "Apple")

    val expectation = "£1.20"

    it should s"output '$expectation' for inputs `${inputs.mkString(", ")}`" in {

      calculate(inputs) should equal(expectation)
    }
  }

  {
    val inputs = Nil

    val expectation = "£0.00"

    it should s"output '$expectation' for inputs `${inputs.mkString(", ")}`" in {

      calculate(inputs) should equal(expectation)
    }
  }
}
