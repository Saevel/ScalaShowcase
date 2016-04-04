//Wyrażenia lambda - "przenośne metody"
val factorial:(Int => Int) = { a:Int =>
  if(a == 0) {
    1
  }
  else {
    a*factorial(a-1)
  }
}

factorial(4)

//Zastosowanie lambdy
val ints = List(0, 1, 2, 3, 4, 5, 6)
ints.map(factorial)

//Kompozycja funkcji
val cutInHalf:(Int => Int) = { a:Int =>
  Math.floorDiv(a, 2)
}

val halfFactorial = cutInHalf andThen factorial

ints.map(halfFactorial)

//TODO:Stworzenie zlozonej funkcji przy pomocy partiali: :