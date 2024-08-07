import Shop.createCart
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CartSpec extends AnyFlatSpec with Matchers {
  behavior of "Shop"

  it should "create a new cart" in {
    createCart("testCart").user shouldBe "testCart"
  }

  it should "retrieve a cart" in {
    createCart("testCart")
    Shop.retrieveCart("testCart").get.user shouldBe "testCart"
  }

  it should "remove a cart" in {
    createCart("testCart")
    Shop.removeCart("testCart") shouldBe "testCart's cart removed successfully"
  }

  it should "not remove a cart that does not exist" in {
    Shop.removeCart("testCart") shouldBe "Error testCart cart not recognised"
  }

  it should "not remove a cart that has already been removed" in {
    createCart("testCart")
    Shop.removeCart("testCart")
    Shop.removeCart("testCart") shouldBe "Error testCart cart not recognised"
  }

}
