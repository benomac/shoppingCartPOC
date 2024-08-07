// I'm using vars here as I'm treating this as "database" which are mutable,
// as opposed to the Maps in shoppingCart that are immutable.
object Store:

  val storage = new Storage[String, ShoppingCart]
  private class Ref[A](private var value: A) {
    def get: A = value

    def set(newValue: A): Unit = value = newValue
  }

  class Storage[K, V] {
    private var storage: Map[K, Ref[V]] = Map.empty

    def add(key: K, value: V): Unit = {
      storage += (key -> new Ref(value))
    }

    def get(key: K): Option[V] = {
      storage.get(key).map(_.get)
    }

    def remove(key: K): Unit = {
      storage -= key
    }
  }