object InputLoader {

  def load(resourcePath: String): Iterator[String] =
    scala.io.Source.fromResource(resourcePath).getLines()

}
