import ShoppingCart.*
import Item.*
import Shop.{User, createCart, storage}
import Store.Storage
object main extends App {

  println(storage.getAll)
  val bensCart = createCart(User("ben"))

  println(bensCart.addToCart(List(Orange)))

  val dawnsCart = createCart(User("danw"))
  println(storage.getAll)
  println(storage.get(User("danw")) match {
    case Some(v) => v.addToCart(List(Orange))
    case None => None
  })
}
