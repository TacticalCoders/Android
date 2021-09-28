Kotlin 함수
fun main() {
    val result1 = add(2,4)
    val result2 = add(6,3)
    println(result1)
    println(result2)

    val result3 = max(2,4)
    println(result3)

    val result4 = max2(2,4)
    println(result4)
}

fun add(a:Int, b:Int) = a + b

fun max(a: Int, b:Int)= if(a>b) a else b

fun max2(a: Int, b:Int)= if(a>b) {
    println("$a is greater")
    a
} else {
    println("$b is greater")
    b
    98 //수식형 함수에서 중문을 사용할 경우 맨 마지막 값을 리턴
}

fun main() { 
    max(2,4)
}
fun max(a: Int, b:Int): Unit{
    println("sum of $a and $b is ${a+b}")
}

fun main() {
    println(findVolume(2,4))
    println(findVolume(2,4,30))
    println(findVolume(width = 20,length= 10))
    println(findVolume(width = 20,length = 10,height = 30))
}
fun findVolume(length:Int, width:Int, height:Int=10) = length*width*height

fun main() {
    println(add(1,2))
    println(add(1,2,3))
    println(add(1,2,3,4,5))
}
fun add(vararg values:Int):Int {
    var sum = 0
    for (n in values)
        sum += n
    return sum
}

람다 식과 고차 함수
fun main() {
    //val add:Int = 1
    //val add:(Int, Int)-> Int = { x:Int, y:Int -> x + y }
    //val add:(Int, Int)-> Int = { x, y -> x + y }
    val add = { x:Int, y:Int -> x + y } //엄청나게 코드 길이를 줄일 수 있다.
    println(add(1,2))
}

fun main() {
    val result = add(2,3)
    val result2 = multiply(add(4,5),6) //파라미터에 함수를 대입할 수 있다.
    println(result)
    println(result2)
}
fun add(a:Int, b:Int) = a + b
fun multiply(a:Int, b:Int) = a * b


fun main() {
    val result = add(2,3)
    val result2 = highOrderFunc(5,6)
    println(result)
    println(result2)
}

fun add(a:Int, b:Int) = a + b
fun highOrderFunc(a: Int, b: Int):Int {
    return add(a,b)
}

fun main() {
    val myLambda = { x:Int -> println(x) }
    addTwoNumbers(2,7,myLambda)
}
fun addTwoNumbers(a:Int, b:Int, myFunc:(Int)->Unit){
    val sum = a + b;
    myFunc(sum)
}

fun main() {
    val myLambda = {a:Int, b:Int -> a + b}
    addTwoNumbers(2,7,myLambda)
    addTwoNumbers(2,7,  ) {a,b-> a+b} //맨 마지막 인자의 경우 람다식은 괄호 바깥에서 정의될 수 있다.
}
fun addTwoNumbers(a:Int, b:Int, myFunc:(Int,Int)->Int){
    val sum = myFunc(a,b)
    println(sum)
}
fun main() {
    //val add:(Int, Int)-> Int = fun(a, b) = a+b
    val add = fun(a:Int, b:Int) = a+b //안드로이드 개발할 때는 거의 대부분 람다식을 사용한다.
    //val add = { a:Int, b:Int -> a+b } 람다식? vs 익명함수?
    println(add(1,2))
}

fun main() {
    println(add(1,2))
    println(add(3,4))
}
inline fun add(a:Int, b:Int): Int = a+b

확장 함수와 중위 함수
class Student{
    fun hasPassed(score:Int):Boolean{
        return score>60  }
}
fun Student.isScholar(score: Int):Boolean{
    return  score>90
}
fun main() {
    var st = Student()
    println("Pass status:" + st.hasPassed(78))
    println("Scholarship status:" + st.isScholar(78))
}
fun main() {
    var str1 = "Hello"
    var str2 = "Kotlin"
    var tmp = str1.add(str2)
    println(tmp)
}
fun String.add(s1:String) = this + " " +s1

class NewFunction(var left:Int, var right:Int){
    infix fun increaseBy(amount:Int){
        this.left += amount
        this.right += amount
    }
}

infix fun NewFunction.decreaseBy (amount:Int){
    this.left -= amount
    this.right -= amount
}

fun main() {
   var c = NewFunction(20 ,20)
    println("${c.left}, ${c.right}")
    c increaseBy 40
    println("${c.left}, ${c.right}")
    c decreaseBy 15 //c.decreaseBy(15)
    println("${c.left}, ${c.right}")
}
