import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ShoppingCartSpec extends AnyFlatSpec with Matchers {

  def calculate(goods: List[String]): String = {
    "£0.00"
  }

  behavior of "Shopping Cary"

  {
    val inputs = List("Apple", "Apple", "Orange", "Apple")

    val expectation = "£2.05"

    it should s"output '$expectation' for inputs `${inputs.mkString(", ")}`" in {

      calculate(inputs) should equal(expectation)
    }
  }
}
