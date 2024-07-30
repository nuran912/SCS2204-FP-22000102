object InventorySystem{

  var inventory1: Map[Int, (String, Int, Double)] = Map(
    101 -> ("ProductA", 50, 10.5),
    102 -> ("ProductB", 20, 15.0),
    103 -> ("ProductC", 10, 20.0)
  )

  var inventory2: Map[Int, (String, Int, Double)] = Map(
    102 -> ("ProductB", 30, 17.0),
    104 -> ("ProductD", 5, 25.0)
  )

  def getAllProductNames(inventory: Map[Int, (String, Int, Double)]): List[String] = {
    inventory.values.map(_._1).toList
  }

  def calculateTotalValue(inventory: Map[Int, (String, Int, Double)]): Double = {
    inventory.values.map { case (_, quantity, price) => quantity * price }.sum
  }

  def isInventoryEmpty(inventory: Map[Int, (String, Int, Double)]): Boolean = {
    inventory.isEmpty
  }

  def mergeInventories(inv1: Map[Int, (String, Int, Double)], inv2: Map[Int, (String, Int, Double)]): Map[Int, (String, Int, Double)] = {
    (inv1.keySet ++ inv2.keySet).map { id =>
      val product1 = inv1.get(id)
      val product2 = inv2.get(id)
      val mergedProduct = (product1, product2) match {
        case (Some((name1, qty1, price1)), Some((name2, qty2, price2))) =>
          (name1, qty1 + qty2, math.max(price1, price2))
        case (Some(product), None) => product
        case (None, Some(product)) => product
        case _ => throw new IllegalStateException("This should not happen")
      }
      id -> mergedProduct
    }.toMap
  }

  def checkProductExists(inventory: Map[Int, (String, Int, Double)], productId: Int): Unit = {
    inventory.get(productId) match {
      case Some((name, quantity, price)) =>
        println(s"Product ID: $productId, Name: $name, Quantity: $quantity, Price: $price")
      case None =>
        println(s"Product ID: $productId does not exist in the inventory")
    }
  }

  def main(args: Array[String]): Unit = {
    println("All product names in inventory1: " + getAllProductNames(inventory1))
    println("Total value of all products in inventory1: " + calculateTotalValue(inventory1))
    println("Is inventory1 empty? " + isInventoryEmpty(inventory1))
    val mergedInventory = mergeInventories(inventory1, inventory2)
    println("Merged Inventory: " + mergedInventory)
    checkProductExists(inventory1, 102)
    checkProductExists(inventory1, 105)
  }
}
