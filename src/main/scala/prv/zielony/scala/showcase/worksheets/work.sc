//Tworzenie prostej zmiennej w Scali
var sample = 17

//Prosta operacja na zmiennej
sample = sample + 13

//Tworzenie stałej
val other = 134

//Tworzenie list
val names = List("Jan", "Tomasz", "Artur", "Emil", "Piotr")

//Tworzenie map
val map = Map(1 -> "Jeden", 2 -> "Dwa", 3 -> "Trzy")

//Tworzenie metody
def square(i:Int) = i*i

//Wywołanie metody
square(12)

//Kolejna metoda + interpolacja Stringów
def otherMethod(a:Int, b:String)= {
  s"String ${b}, Int: ${a}"
}

