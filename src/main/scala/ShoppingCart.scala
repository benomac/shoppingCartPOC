import cats.implicits.*
import cats.Foldable
import cats.kernel.Semigroup

import scala.collection.immutable

final case class Item(item: String)
final case class ShoppingCart(
                               user: String,
                               items: Map[Item, Int] = Map.empty,
                               readyForCheckout: Boolean = false,
                               checkoutCompleted: Boolean = false) {
  def addToCart(itemToAdd: Item): ShoppingCart =
    val itemsAdded = Semigroup[Map[Item, Int]].combine(items, Map(itemToAdd -> 1))
    ShoppingCart(user, itemsAdded)

  def editQuantityOfItem(item: Item, quantity: Int): ShoppingCart =
    val newItems: Map[Item, Int] = items.map { case (k, v) =>
      if (k == item) k -> (v * quantity)
      else k -> v
    }
    ShoppingCart(user, newItems)


  def removeItem(item: Item): ShoppingCart = items.get(item) match {
    case Some(_) => ShoppingCart(user, items - item)
    case None => this
  }

  def cartReadyForCheckout(): ShoppingCart = {
    val cart: ShoppingCart = this
    cart.copy(readyForCheckout = true)
  }
  def completedCheckout(): ShoppingCart =
    if(readyForCheckout) {
      val cart: ShoppingCart = this
      cart.copy(checkoutCompleted = true)
    } else this

  def isCompleted() = checkoutCompleted
}

