import Pacientes.{E, Hora, NB, Nombre, PA, SA, fecha, hum, sobres, temp}

import java.security.KeyStore.TrustedCertificateEntry
import java.util.Collections
import scala.collection.mutable.ListBuffer
import scala.concurrent.ExecutionContext.global
import scala.io.StdIn.{readDouble, readInt, readLine}
//import scala.reflect.internal.util.Collections

class Datos(N:String,pa:String,sa:String,e:Int,f:String,h:String,nb:Int,te:Double,huu:Double){
  //println(N,pa,sa,e,f,h,nb,te,huu)
  Nombre+=N
  //println(Nombre)
  PA+=pa
  //println(PA)
  SA+=sa
  //println(SA)
  E+=e
  //println(E)
  fecha+=f
  //println(fecha)
  Hora+=h
  //println(Hora)
  NB+=nb
  //println(NB)
  temp+=te
  //println(temp)
  hum+=huu
  //println(hum)

  def Maximos():Unit={
    println("Edades:"+E)
    println("Nivel de Bienestar:"+NB)
    println("Temperatura:"+temp)
    println("Humedad:"+hum)
    println("<--------------------------------------------------->")
    var suma=0
    for(i<-NB){
      suma+=i
    }
    println("Promedio del nivel de Bienestar:"+suma/NB.length)
    var MNB= Integer.MIN_VALUE
    for (j<-NB){
      if(j>MNB){
        MNB=j
      }
    }
    println("Mayor Nivel de Bienestar:"+MNB)
    var Mtemp = Double.MinValue
    for (i<-temp) {
      if (i > Mtemp) {
        Mtemp = i;
      }
    }
    println("Mayor Temperatura:"+Mtemp)
    var Mhum = Double.MinValue
    for (i<-hum) {
      if (i > Mhum) {
        Mhum =i;
      }
    }
    println("Mayor Humedad:"+Mhum)
    var Medad = Integer.MIN_VALUE
    for (x<-E) {
      if (x > Medad) {
        Medad = x;
      }
    }
    println("Mayor Edad:"+Medad)
  }
  def Minimos():Unit={
    var MNB= Integer.MAX_VALUE
    for (j<-NB){
      if(j<MNB){
        MNB=j
      }
    }
    println("Menor Nivel de Bienestar:"+MNB)
    var Mtemp = Double.MaxValue
    for (i<-temp) {
      if (i < Mtemp) {
        Mtemp = i;
      }
    }
    println("Menor Temperatura:"+Mtemp)
    var Mhum = Double.MaxValue
    for (i<-hum) {
      if (i < Mhum) {
        Mhum = i;
      }
    }
    println("Menor Humedad:"+Mhum)
    var Medad = Integer.MAX_VALUE
    for (x<-E) {
      if (x < Medad) {
        Medad = x;
      }
    }
    println("Menor Edad:"+Medad)

  }

}
object Pacientes {
  val Nombre= new ListBuffer[String]()
  val PA= new ListBuffer[String]()
  val SA= new ListBuffer[String]()
  val E= new ListBuffer[Int]()
  val fecha= new ListBuffer[String]()
  val Hora= new ListBuffer[String]()
  val NB= new ListBuffer[Int]()
  val temp= new ListBuffer[Double]()
  val hum = new ListBuffer[Double]()
  var sobres=0
  var xd =1
  def main(args: Array[String]): Unit = {
    //var xd=1
    while(xd==1){
      println("Quieres agregar un Paciente 1=Si, 2=No:")
      xd=readInt()
      damed()
    }
  }
  def damed():Unit={
    println("Nombre del Paciente:")
    val name = readLine()
    println("Primer Apeido del Paciente:")
    val ap = readLine()
    println("Segundo Apeido del Paciente:")
    val sa = readLine()
    println("Edad del Paciente:")
    val e = readInt()
    println("Fecha:")
    val f = readLine()
    println("Hora:")
    val h = readLine()
    println("Nivel de Bienestar (1-5):")
    val nb = readInt()
    println("Temperatura:")
    val temp = readDouble()
    println("Humedad:")
    val hum = readDouble()
    val d = new Datos(name, ap, sa, e, f, h, nb, temp, hum)
    if(xd==2){
      d.Maximos()
      println("<--------------------------------------------------->")
      d.Minimos()
    }
  }
}
