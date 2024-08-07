import Shop.createCart

object Main {
  def main(args: Array[String]): Unit = {

    def itemsToBuy(): Either[String, List[Item]] = {
      if (args.length == 0) Left("Error no items given, please run again with items for sale.")
      else Right(args.toList.map(x => Item.apply(x)))
    }
    def printAvailableItems(): Unit =
      itemsToBuy() match
        case Left(error) => println(error)
        case Right(items) =>
          println(s"Here are the available items for purchase \n${items.map(_.item).mkString(",\n")}")

    def getName(): String = {
      val name = scala.io.StdIn.readLine("Please enter your name:")
      if(name.isBlank) getName()
      else name
    }
    def createACartMessage(): Unit =
      val reply = scala.io.StdIn.readLine("Would you like to create a cart? y/n :")
      reply match
        case s: String if s == "y" || s == "Y" => {
          val cart = createCart(getName())
          println(s"${cart.user}'s Cart created successfully")
        }
        case s: String if s == "n" || s == "N" =>
          println("Ok then, bye!")
        case _ => {
          println("Invalid response please enter y or n")
          createACartMessage()
        }

    itemsToBuy() match
      case Left(error) => println(error)
      case Right(value) => createACartMessage()

  }
}
