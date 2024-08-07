import Store.{Storage, storage}

object Shop {

  def createCart(user: String): ShoppingCart = {
      val newCart = ShoppingCart(user)
      storage.add(user, newCart)
      newCart
    }

  def retrieveCart(name: String): Option[ShoppingCart] =
    storage.get(name)

  def removeCart(name: String): String =
    storage.get(name) match
      case Some(value) => {
        storage.remove(name)
        storage.get(name) match
          case Some(value) => s"Error removing ${value.user}"
          case None => s"$name's cart removed successfully"
      }
      case None => s"Error $name cart not recognised"


}
