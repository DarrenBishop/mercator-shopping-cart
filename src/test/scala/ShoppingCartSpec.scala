import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ShoppingCartSpec extends AnyFlatSpec with Matchers {

  val priceList = Map(
    "Apple" -> 0.60,
    "Orange" -> 0.25
  )

  def calculate(goods: List[String]): String = {
    "£%.02f".format(goods.map(priceList).fold(0d)(_ + _))
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
