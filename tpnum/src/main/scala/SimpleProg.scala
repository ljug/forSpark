/* SimpleProg.scala */
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object SimpleProg {
  def main(args: Array[String]) {
    val myFile = "file://"+args(0)
    val config = new SparkConf().setAppName("Application Simple")
    val sc = new SparkContext(config)
    val myData = sc.textFile(myFile, 2).cache()
    val nbclass = myData.filter(line => line.contains("class")).count()
    val nbjavascript = myData.filter(line => line.contains("javascript")).count()
    println("Lignes avec javascript : %s, lignes avec class : %s".format(nbjavascript, nbclass))
   println("Args is %s".format(args(0)+"abc"));
  }
}
