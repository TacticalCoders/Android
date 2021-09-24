클래스와 main( ) 함수가 있는 경우
class Person(var name:String, var age:Int) //생성자
fun main() {
    var hong = Person("hong",24) // 클래스 인스턴스(객체)를 생성
    var kim = Person("Kim",27)
    println(hong.name)
    println(kim.age)
}

Kotlin functions (1/2)
fun main() {
    println(sum(23,47))
    print_sum(12,23)
}
fun sum(a:Int, b:Int):Int{
    return a + b;
}
fun print_sum(a:Int, b:Int):Unit{
    println("sum of $a and $b is ${a+b}")
}


fun main() {
    println(sum(23,47))
    print_sum(12,23)
}
fun sum(a:Int, b:Int) = a + b
fun print_sum(a: Int, b: Int){ //unit 생략 가능
    println("sum of $a + $b is ${a+b}")
}

Kotlin functions (2/2)
fun main() {
    println(max(17,23))
}

fun max(a:Int, b:Int):Int {
    return if(a>b) a else b
}
// = fun max(a:Int,b: Int):Int = if(a>b) a else b
// = fun max(a:Int,b: Int) = if(a>b) a else b
// return타입 생략은 본문이 식인 함수에서만 사용가능(블록 함수에서는 생략 불가)

Numbers 예 (1/2)
fun main() {
    println("Byte: " + Byte.MIN_VALUE + ", " + Byte.MAX_VALUE + ", " + Byte.SIZE_BYTES)
    println("Short: " + Short.MIN_VALUE + ", " + Short.MAX_VALUE + ", " + Short.SIZE_BYTES)
    println("Int: " + Int.MIN_VALUE + ", " + Int.MAX_VALUE + ", " + Int.SIZE_BYTES)
    println("Long: " + Long.MIN_VALUE +", "+ Long.MAX_VALUE + ", " + Long.SIZE_BYTES)
    println("Float: " +Float.MIN_VALUE+", "+Float.MAX_VALUE+", "+Float.SIZE_BYTES)
    println("Double: "+ Double.MIN_VALUE +", "+Double.MAX_VALUE+", "+Double.SIZE_BYTES)

    var f : Float = 3.9f
    var i : Int = f.toInt()

    println()
    println("f = $f, i = $i")
}

Numbers 예 (2/2)
fun main (){
    var f = 3.14f
    var d = 3.14
    var i:Short = 3
    var fd = f.toDouble()
    var i2f = i.toFloat()

    typeCheck(f)
    typeCheck(d)
    typeCheck(i)
    typeCheck(fd)
    typeCheck(i2f)
}

fun typeCheck (v:Any){
    when(v){ //Java의 switch case 문
        is Short -> println("The type of $v is Short") //is는 Java의 instanceof
        is Int -> println("The type of $v is Int")
        is Float -> println("The type of $v is Float")
        is Double -> println("The type of $v is Double")
    }
}

Char (1/2)
fun main(){
    var c:Char = 'A' //var c:Char = 65는 에러 발생
    var code:Int = 65
    var han_code:Char = '\uD55c' //'한'의 유니코드

    println(c)
    println(code.toChar()+", "+(code+1).toChar())
    println(han_code)
}

Char (2/2)
fun main(){
    for (i in '0'..'9')
        println("${decimalValue(i)}")
    println()
}

fun decimalValue(c: Char):Int {
    if(c !in '0'..'9')
        throw IllegalArgumentException("out of range")
    return c.digitToInt(10) - '0'.digitToInt(10)
}

Boolean
fun main(){
    val foo : Boolean = true
    val bar = false

    println( foo && bar )
    println( foo || bar )
    println( !foo )
}

String (1/2)
fun main(){
    var foo: String = "My First Kotlin"
    var ch1:Char = foo.get(3)
    var ch2:Char = foo[9]
    println("ch1 = $ch1 and ch2 = $ch2")

    foo = foo.substring(0,9) + "python"
    println(foo)

    var foo2 = foo.replace("Kotlin","python")
    println(foo2)
    println(foo == foo2)
}

String (2/2)
import kotlin.math.PI

fun main(){
    val pi: Float = PI.toFloat()
    val digit = 10
    val str = "Hello"
    val length = 3000

    val lengthStr: String = String.format("Length: %d meters",length)
    println("pi = %.2f, %3d, %s".format(pi,digit,str))
    println(lengthStr)
}

string templates (1/2)
fun main(){
    var a = 1
    val s1 = "a is $a"

    a = 2
    val s2 = "${s1.replace("is","was")}, but now is $a"
    println(s2)

    val s = "abc"
    println("$s.length is ${s.length}")
}

string templates (2/2)
fun main(){
    val expr:String = "My First Kotlin"
    val price = 10
    
    val lengthStr = "text length: ${expr.length}"
    val priceStr = "price: ${'$'}$price"
    val priceStr2 = "price: \$$price"
    
    println(lengthStr)
    println(priceStr)
    println(priceStr2)
    
    println("\"Hey\", I have only $price\$.")
    println("${'"'}, I have only $price${'S'}.")
}

Safe call (1/2)
fun main(){
    var str:String? //기본은 null 값을 갖지 않음. ?를 붙히면 null값 허용
    str  = null
    
    if(str.isNullOrBlank())
        println("Str is null")
    else
        println("str is NOT null")
    
}

Safe call (2/2)
fun main(){
    var str:String? = "Hello, Kotlin"
    str = null

    //println("str: $str length = ${str.length}")
    println("str: $str length = ${str?.length}")

    val len = str?.length ?: -1
    println("str: $str? length = ${len}")
}

Smart cast와 Type check
fun main(){
    var num:Number = 8L
    val str:Any

    typeCheck(num)
    typeCheck(8)
    var ld = num as Long
    typeCheck(ld)
  str = "Hello, Kotlin"
    if(str is String)
        println("\"$str\" is ${str.javaClass}")
}

fun typeCheck(x: Any){
    if(x is Int)
        println("$x is ${x.javaClass}")
    else if(x !is Int)
        println("$x is NOT Int. The type is ${x.javaClass}")
}

if-else (1/2)
fun main() {
    val a = 12
    val b = 7

    val maxValue = if (a>b){
        println("$a is chosen")
        a
    } else {
        println("$b is chosen")
        b
    }
    println(maxValue)
}

if-else (2/2)
fun main() {
    print("Exter the score: ")
    val score = readLine()!!.toFloat()
    var grade = 'F'
    
    if(score >= 90)
        grade='A'
    else if (score in 80.0..89.9)
        grade = 'B'
    else if (score in 70.0..79.9)
        grade = 'C'
    
    println("Your grade is $grade")
}

when (1/3)
fun main() {
    checkValue(1)
    checkValue(3)
    checkValue(5)
}

fun checkValue(x: Int){
    when(x){
        1 -> println("x is 1")
        2 -> println("x is 2")
        3,4 -> println("x is 3 or 4")
        else -> {
            println("x is greater than or equal to 5")
        }
    }
}

when (2/3)
fun main() {
    print("Enter the score: ")
    val score = readLine()!!.toFloat()
    var grade = 'F'
    
    when(score){
        in 90.0..100.0 -> grade ='A'
        in 80.0..89.9 -> grade = 'B'
        in 70.0..79.9 -> grade = 'C'
    }
    println("score: $score, grade: $grade")
}

when (3/3) – enum 클래스
enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

fun main() {
    println(getMnemonics(Color.BLUE))
    println(getWarmth(Color.ORANGE))
}

fun getMnemonics(color: Color): String{
    return when(color){
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
        else -> {
            "Not a defined color"
        }
    }
}

fun getWarmth(color: Color):String{
    return when(color){
        Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
        Color.GREEN -> "neutral"
        Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
        else -> {
            "Not a defined color"
        }
    }
}

Range and loop : for, while, do-while
fun main() {
    for(i in 1..100){
        print(fizzBuzz(i))
        if(i % 10 == 0) println()
    }
    
    var j = 1 
    while (j <= 100){
        print(fizzBuzz(j))
        if(j % 10 == 0) println()
        j++
    }
    
    var k = 1
    do{
        print(fizzBuzz(k))
        if(k % 10 == 0) println()
        k++
    }while (k  <=100)
    
}

fun fizzBuzz(i:Int):String{
    return when {
        i % 15 == 0 -> "FizzBuzz"
        i % 3 == 0 -> "Fizz"
        i % 5 == 0 -> "Buzz"
        else -> "$i"
    }
}

One dimensional arrays
fun main() {
    val numbers = arrayOf(1,2,3)
    val mixedArray = arrayOf(7,"Kotlin",false)
    
    val intOnlyArray = arrayOf<Int>(1,2,3)
    val intOnlyArray2 = intArrayOf(4,5,6,7)
    
    var i = intOnlyArray[0]
    var i2 = intOnlyArray2.get(2)
    println("i=$i , i2=$i2")
    println("${intOnlyArray.size}, ${intOnlyArray2.size}")
    println("${intOnlyArray.first()}, ${intOnlyArray2.last()}")
    
    intOnlyArray[0] = 0
    intOnlyArray2.set(3,9)
    println(intOnlyArray.contentToString())
    println(intOnlyArray2.contentToString())
}

1차원 배열 원소 출력 (1/3)
fun main() {

    val intOnlyArray = arrayOf<Int>(1,2,3)
    val intOnlyArray2 = intArrayOf(4,5,6,7)
    
    showElement(intOnlyArray)
    showElement(intOnlyArray2)
}

fun showElement(arr:Array<Int>){
    for(i in arr)
        print("$i\t")
    println()
}

1차원 배열 원소 출력 (2/3)
fun main() {
    val intOnlyArray = arrayOf<Int>(1,2,3)
    val intOnlyArray2 = intArrayOf(4,5,6,7)

    intOnlyArray.forEach {  element -> println("$element") }
    println()
    intOnlyArray2.forEachIndexed{
        i, e -> println("intOnlyArra2[$i] = $e")
    }
    
    val iter:Iterator<Int> = intOnlyArray.iterator()
    while (iter.hasNext()){
        val e = iter.next()
        print("$e ")
    }
    println()
}

1차원 배열 원소 출력 (3/3)
fun main() {
   val words : Array<String> = arrayOf("python", "kotlin", "swift")
   val intOnlyArray = arrayOf(4,5,6,7)
    
    unified<String>(words)
    unified<Int>(intOnlyArray)
}

fun <T> unified(arr:Array<T>){
    for (i in arr)
        println(i)
}

Two dimensional arrays
fun main() {
    val array1 = arrayOf(1,2,3)
    val array2 = arrayOf(4,5,6)
    val array3 = arrayOf(7,8,9)
    
    val arr2d = arrayOf(array1,array2,array3)
    
    for(e1 in arr2d){
        for(e2 in e1){
            print(e2)
        }
        println()
    }
    println(arr2d[2][1])
}
