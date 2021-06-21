import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ShoppingCartSpec extends AnyFlatSpec with Matchers {

  case class Offer(count: Int, reduction:Int)
  case class ShoppingItem(price: Double, offer:Offer = Offer(1, 1))

  val priceList = Map(
    "Apple" -> ShoppingItem(0.60, Offer(2, 1)),
    "Orange" -> ShoppingItem(0.25, Offer(3, 2))
  )

  def discount(n: Int, offer:Offer): Int =
    (n / offer.count) * offer.reduction + (n % offer.count)

  def calculate(goods: List[String]): String = {
    "£%.02f".format(
      goods
        .groupMapReduce(priceList)(_ => 1)(_ + _)
        .map { case (ShoppingItem(price, offer), count) => price * discount(count, offer) }
        .sum)
  }

  behavior of "Shopping Cart"
  note(f"Applying discounts: buy one, get one free on Apples (£${priceList("Apple").price}%.02f); 3 for the price of 2 on Oranges (£${priceList("Orange").price}%.02f)")

  {
    val inputs = List("Apple", "Apple", "Orange", "Apple")

    val expectation = "£1.45"

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
