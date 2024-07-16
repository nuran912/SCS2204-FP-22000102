import scala.io.StdIn.readLine

object Products{
    var products: List[String] = List();

    def getProductList(): List[String] = {
        println("Enter product name: ");

        var product: String = "";

        while({
            product = readLine();
            product.toLowerCase != "done"
            }){
                products = products :+ product;
            }
        products
    }

    def printProductList(products: List[String]): Unit = {
        for(i <- 0 until products.length){
            println(i+1 + ". " +  products(i))
        }
    }
    def getTotalProducts(products: List[String]): Unit = {
        println("Total products: " + products.length)
    } 
    def main(args: Array[String]): Unit = {
        getProductList();
        printProductList(products);
        getTotalProducts(products);
    }
}