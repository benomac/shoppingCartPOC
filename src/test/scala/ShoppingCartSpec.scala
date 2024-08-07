import Shop.createCart
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ShoppingCartSpec extends AnyFlatSpec with Matchers {
  val testCart = createCart("testCart")

  behavior of "ShoppingCart"

  it should "update the cart with a new item" in {
    testCart.addToCart(Item("apple")) shouldBe
      ShoppingCart("testCart", Map(Item("apple") -> 1))
  }

  it should "edit the quantity of the item in the cart" in {
    testCart.addToCart(Item("apple")).editQuantityOfItem(Item("apple"), 5) shouldBe
      ShoppingCart("testCart", Map(Item("apple") -> 5))
  }

  it should "remove an item from the cart" in {
    testCart.addToCart(Item("apple")).removeItem(Item("apple")) shouldBe
      ShoppingCart("testCart", Map.empty)
  }

  it should "set the cart to ready for checkout" in {
    testCart.cartReadyForCheckout().readyForCheckout shouldBe true
  }

  it should "set the cart to completed checkout" in {
    testCart.cartReadyForCheckout().completedCheckout().checkoutCompleted shouldBe true
  }

}

    