import Shop.String

// I'm using vars here as I'm treating this as "database" which are mutable,
// and can kinda be considered "not scala" code, as opposed to the Maps in shoppingCart
// sticking with the immutable thing.
object Store:

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

    def update(key: K, value: V): Unit = {
      storage.get(key).foreach(_.set(value))
    }

    def remove(key: K): Unit = {
      storage -= key
    }

    def getAll: Map[K, V] = {
      storage.map { case (k, ref) => k -> ref.get }
    }
  }