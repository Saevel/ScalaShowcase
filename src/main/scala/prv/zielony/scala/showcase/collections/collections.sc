//Latwe tworzenie kolekcji

import scala.util.Random

val list = List.fill(10)(Random.nextDouble())

val otherList = List(1,2,3,4,5)

val array = new Array(10)

//Przetwarzanie element po elemencie przy pomocy lambd

val intList = list.map { element =>
  Math.floor(element * 100).toInt
}

//Filtrowanie elementów przy pomocy lambd

val pairNumbers = intList.filter { element =>
  element % 2 == 0
}

//'Spłaszczanie' kolekcji
val flatList = otherList.flatMap { element =>
  List.range(0, element)
}
