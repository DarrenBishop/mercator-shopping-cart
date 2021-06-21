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

  behavior of "Shopping Cary"

  {
    val inputs = List("Apple", "Apple", "Orange", "Apple")

    val expectation = "£2.05"

    it should s"output '$expectation' for inputs `${inputs.mkString(", ")}`" in {

      calculate(inputs) should equal(expectation)
    }
  }

  {
    val inputs = List("Orange", "Orange", "Orange", "Orange")

    val expectation = "£1.00"

    it should s"output '$expectation' for inputs `${inputs.mkString(", ")}`" in {

      calculate(inputs) should equal(expectation)
    }
  }

  {
    val inputs = List("Apple", "Apple", "Apple", "Apple")

    val expectation = "£2.40"

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
