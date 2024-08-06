import Store.Storage

object Shop {

  val storage = new Storage[User, ShoppingCart]
  def createCart(user: User): ShoppingCart =
    val newCart = ShoppingCart(user)
    storage.add(user, newCart)
    newCart



}
