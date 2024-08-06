
val map1 = Map("a" -> 1)
val map2 = Map("a" -> 1)

val combinedMap = map1 ++ map2.map { case (k, v) => k -> (v + map1.getOrElse(k, 0)) }
