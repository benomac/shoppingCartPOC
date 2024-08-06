import Item.*
import Shop.User
import cats.implicits.*
import cats.Foldable
import cats.kernel.Semigroup

import scala.collection.immutable


final case class ShoppingCart(user: User, items: Map[Item, Int] = Map.empty, readyForCheckout: Boolean = false, checkoutCompleted: Boolean = false) {
  def addToCart(itemsToAdd: List[Item]): ShoppingCart =
    val itemsToAddToMap = Foldable[List].foldMap(itemsToAdd)(item => Map(item -> 1))
    val combinedMap = Semigroup[Map[Item, Int]].combine(items, itemsToAddToMap)

    ShoppingCart(user, combinedMap)

  def editQuantityOfItem(item: Item, quantity: Int): ShoppingCart =
    val newItems: Map[Item, Int] = items.map { case (k, v) =>
      if (k == item) k -> (v - quantity)
      else k -> v
    }
    ShoppingCart(user, newItems)


  def removeItem(item: Item): ShoppingCart = items.get(item) match {
    case Some(_) => ShoppingCart(user, items - item)
    case None => this
  }

}

