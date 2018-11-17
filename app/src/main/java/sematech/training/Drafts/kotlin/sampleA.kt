package sematech.training.Drafts.kotlin

val name: String = "Meisam"
var family: String = "Banihashemi"

var address :String? = null

fun main(args: Array<String>) {

    if(address!=null)
        print(address)

    println(name)
    println(family)
}

fun setMobile (mobile:String){

}

fun connectToDB(ip:String,user:String):Boolean{

    return true
}

fun useStudentModelFromJava(){

    val std : StudentModel = StudentModel("ali","asghari",25)
    print(std.age)
}