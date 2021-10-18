package com.example.calculadora

import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var numero1:Double=0.0
    private var numero2:Double=0.0
    private var operacion:Int =0



    //binario
    private var contb:Int=0
    private var bnumero1:Long=0
    private var bnumero2:Long=0
    private var decimal1:Int=0
    private var decimal2:Int=0
    private var bresultado:Int=0
    private var botonbinariopulsado:Int=0
    private var botonopulsado:Int=0
    //hexadecimal
    private var conte:Int=0
    private var hnumero1:Long=0
    private var hnumero2:Long=0
    private var hdecimal1:Int=0
    private var hdecimal2:Int=0
    private var hresultado:Int=0
    private var botonhexapulsado:Int=0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.setOnClickListener { numPulsado("1") }
        button2.setOnClickListener { numPulsado("2") }
        button3.setOnClickListener { numPulsado("3") }
        button4.setOnClickListener { numPulsado("4") }
        button5.setOnClickListener { numPulsado("5") }
        button6.setOnClickListener { numPulsado("6") }
        button7.setOnClickListener { numPulsado("7") }
        button8.setOnClickListener { numPulsado("8") }
        button9.setOnClickListener { numPulsado("9") }
        button0.setOnClickListener { numPulsado("0") }



        buttondividir.setOnClickListener { dividir() }
        buttonx.setOnClickListener { multiplicar() }
        buttonrestar.setOnClickListener { restar() }
        buttonsumar.setOnClickListener { sumar() }

        buttonigual.setOnClickListener { igual() }

        buttonpunto.setOnClickListener { punto() }

        buttonvaciar.setOnClickListener { vaciar() }

        buttonBorrar.setOnClickListener { borrar() }


        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(this, "HORIZONTAL", Toast.LENGTH_LONG).show()
            buttonBI.setOnClickListener { binario() }
            button1HEX.setOnClickListener { hexadecimal() }
            buttonA.setOnClickListener {  numPulsado("A")}
            buttonB.setOnClickListener {  numPulsado("B")}
            buttonC.setOnClickListener {  numPulsado("C")}
            buttonD.setOnClickListener {  numPulsado("D")}
            buttonE.setOnClickListener {  numPulsado("E")}
            buttonF.setOnClickListener {  numPulsado("F")}

            buttonA.setEnabled(false)
            buttonB.setEnabled(false)
            buttonC.setEnabled(false)
            buttonD.setEnabled(false)
            buttonE.setEnabled(false)
            buttonF.setEnabled(false)
        }
        else{
            Toast.makeText(this, "VERTICAL", Toast.LENGTH_LONG).show()
        }
    }
    fun hexadecimal(){
        if (conte==0){
            button1HEX.setBackgroundColor(Color.RED)
            contb=0
            Toast.makeText(this, "Modo Hexadecimal", Toast.LENGTH_LONG).show()
            textViewResultado.text = ""
            buttonBI.setBackgroundColor(Color.BLUE)
            button7.setEnabled(true)
            button8.setEnabled(true)
            button9.setEnabled(true)
            button6.setEnabled(true)
            button5.setEnabled(true)
            button4.setEnabled(true)
            button3.setEnabled(true)
            button2.setEnabled(true)
            buttonpunto.setEnabled(true)
            buttonA.setEnabled(true)
            buttonB.setEnabled(true)
            buttonC.setEnabled(true)
            buttonD.setEnabled(true)
            buttonE.setEnabled(true)
            buttonF.setEnabled(true)
            buttonpunto.setEnabled(false)
            botonopulsado=2
            conte=1
        }
        else{
            Toast.makeText(this, "Modo Decimal", Toast.LENGTH_LONG).show()
            button1HEX.setBackgroundColor(Color.BLUE)
            botonhexapulsado = 0

            botonopulsado=0
            conte=0
            buttonA.setEnabled(false)
            buttonB.setEnabled(false)
            buttonC.setEnabled(false)
            buttonD.setEnabled(false)
            buttonE.setEnabled(false)
            buttonF.setEnabled(false)
            textViewResultado.text = ""
        }

    }
    fun binario(){
        if (contb==0){
            conte=0
            button1HEX.setBackgroundColor(Color.BLUE)
            Toast.makeText(this, "Modo Binario; solo funciona el 0 y 1", Toast.LENGTH_LONG).show()
            textViewResultado.text = ""
            buttonBI.setBackgroundColor(Color.RED)
            button7.setEnabled(false)
            button8.setEnabled(false)
            button9.setEnabled(false)
            button6.setEnabled(false)
            button5.setEnabled(false)
            button4.setEnabled(false)
            button3.setEnabled(false)
            button2.setEnabled(false)
            buttonpunto.setEnabled(false)
            buttonA.setEnabled(false)
            buttonB.setEnabled(false)
            buttonC.setEnabled(false)
            buttonD.setEnabled(false)
            buttonE.setEnabled(false)
            buttonF.setEnabled(false)

            contb=1
            botonopulsado=1
        }
        else{
            Toast.makeText(this, "Modo Decimal", Toast.LENGTH_LONG).show()
            textViewResultado.text = ""
            buttonBI.setBackgroundColor(Color.BLUE)
            button7.setEnabled(true)
            button8.setEnabled(true)
            button9.setEnabled(true)
            button6.setEnabled(true)
            button5.setEnabled(true)
            button4.setEnabled(true)
            button3.setEnabled(true)
            button2.setEnabled(true)
            buttonpunto.setEnabled(true)
            buttonA.setEnabled(false)
            buttonB.setEnabled(false)
            buttonC.setEnabled(false)
            buttonD.setEnabled(false)
            buttonE.setEnabled(false)
            buttonF.setEnabled(false)
            textViewResultado.text = ""
            contb=0
            botonopulsado=0
        }

    }

    fun convertBinaryToDecimal(bnumero: Long): Int {
        var num = bnumero
        var decimalNumber = 0
        var i = 0
        var remainder: Long

        while (num.toInt() != 0) {
            remainder = num % 10
            num /= 10
            decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
            ++i
        }
        return decimalNumber
    }

    fun numPulsado(num:String){


        textViewResultado.text="${textViewResultado.text}$num"

    }

    fun borrar() {
        if(textViewResultado.text.isEmpty()){

        }
        else{
            var str = textViewResultado.text.toString()
            str = str.substring(0, str.length - 1)
            textViewResultado.text=str
        }

    }

     fun dividir() {

         if(botonopulsado==0){
             if(textViewResultado.text.isEmpty()){

             }
             else {
                 numero1 = textViewResultado.text.toString().toDouble()
                 textViewResultado.text = ""
                 operacion = 1
             }
         }
         if(botonopulsado==1){
             if(textViewResultado.text.isEmpty()){

             }
             else {
                 bnumero1 = textViewResultado.text.toString().toLong()
                 decimal1= convertBinaryToDecimal(bnumero1)

                 textViewResultado.text = ""
                 operacion = 1
             }
         }
         if(botonopulsado==2){
             if(textViewResultado.text.isEmpty()){

             }
             else {
                 hnumero1 = textViewResultado.text.toString().toLong(radix = 16)
                 textViewResultado.text = Integer.toHexString(hnumero1.toInt())
                 textViewResultado.text = ""
                 operacion = 1;
             }
         }
     }
     fun multiplicar() {
         if(botonopulsado==0){
             if(textViewResultado.text.isEmpty()){

             }
             else{
                 numero1 = textViewResultado.text.toString().toDouble()
                 textViewResultado.text=""
                 operacion=2
             }
         }
         if(botonopulsado==1){
             if(textViewResultado.text.isEmpty()){

             }
             else {
                 bnumero1 = textViewResultado.text.toString().toLong()
                 decimal1= convertBinaryToDecimal(bnumero1)

                 textViewResultado.text = ""
                 operacion = 2
             }
         }
         if(botonopulsado==2){
             if(textViewResultado.text.isEmpty()){

             }
             else {
                 hnumero1 = textViewResultado.text.toString().toLong(radix = 16)
                 textViewResultado.text = Integer.toHexString(hnumero1.toInt())
                 textViewResultado.text = ""
                 operacion = 2;
             }
         }
     }

     fun sumar() {

         if(botonopulsado==0){
             if(textViewResultado.text.isEmpty()){

             }
             else{
                 numero1 = textViewResultado.text.toString().toDouble()
                 textViewResultado.text=""
                 operacion=3
             }
         }
         if(botonopulsado==1){
             if(textViewResultado.text.isEmpty()){

             }
             else {
                 bnumero1 = textViewResultado.text.toString().toLong()
                 decimal1= convertBinaryToDecimal(bnumero1)

                 textViewResultado.text = ""
                 operacion = 3;
             }
         }
         if(botonopulsado==2){
             if(textViewResultado.text.isEmpty()){

             }
             else {
                 hnumero1 = textViewResultado.text.toString().toLong(radix = 16)
                 textViewResultado.text = Integer.toHexString(hnumero1.toInt())
                 textViewResultado.text = ""
                 operacion = 3;
             }
         }
     }
     fun restar() {
         if(botonopulsado==0){
             if(textViewResultado.text.isEmpty()){

             }
             else {
                 numero1 = textViewResultado.text.toString().toDouble()
                 textViewResultado.text=""
                 operacion=4
             }
         }
         if(botonopulsado==1){
             if(textViewResultado.text.isEmpty()){

             }
             else {
                 bnumero1 = textViewResultado.text.toString().toLong()
                 decimal1= convertBinaryToDecimal(bnumero1)

                 textViewResultado.text = ""
                 operacion = 4
             }
         }
         if(botonopulsado==2){
             if(textViewResultado.text.isEmpty()){

             }
             else {
                 hnumero1 = textViewResultado.text.toString().toLong(radix = 16)
                 textViewResultado.text = Integer.toHexString(hnumero1.toInt())
                 textViewResultado.text = ""
                 operacion = 4;
             }
         }
     }

    fun punto(){

        if(textViewResultado.getText().toString().contains(".")||textViewResultado.text.isEmpty()){

        }
        else{
            val coma:String="."
            textViewResultado.text= "${textViewResultado.text}$coma"
        }

    }
    fun vaciar(){
        val cero:String=""
        textViewResultado.text=cero

    }

    fun igual(){
        if(botonopulsado==0){

            if (textViewResultado.text.isEmpty()) {

            } else {
                numero2 = textViewResultado.text.toString().toDouble()
                textViewResultado.text = ""
                if (operacion == 1) {
                    if (numero2 != 0.0) {
                        textViewResultado.text = (numero1 / numero2).toString()
                    } else {
                        textViewResultado.text = "no se puede dividir entre 0 prenda"
                    }
                }
                if (operacion == 2) {
                    textViewResultado.text = (numero1 * numero2).toString()
                }
                if (operacion == 3) {
                    textViewResultado.text = (numero1 + numero2).toString()
                }
                if (operacion == 4) {
                    textViewResultado.text = (numero1 - numero2).toString()
                }

            }
        }
        if(botonopulsado==1){
            if(textViewResultado.text.isEmpty()){

            }
            else{

                bnumero2 = textViewResultado.text.toString().toLong()
                decimal2= convertBinaryToDecimal(bnumero2)

                textViewResultado.text = ""
                if (operacion == 1) {
                    if (decimal2 != 0) {
                        bresultado= (decimal1 / decimal2)
                        textViewResultado.text = Integer.toBinaryString(bresultado)
                    } else {
                        textViewResultado.text = "no se puede dividir entre 0 prenda"
                    }
                }
                if (operacion == 2) {
                    bresultado= (decimal1 * decimal2)
                    textViewResultado.text = Integer.toBinaryString(bresultado)

                }
                if (operacion == 3) {
                    bresultado= (decimal1 + decimal2)
                    textViewResultado.text = Integer.toBinaryString(bresultado)
                }
                if (operacion == 4) {
                    bresultado= (decimal1 - decimal2)
                    textViewResultado.text = Integer.toBinaryString(bresultado)
                }

            }

        }
        if(botonopulsado==2){
            if(textViewResultado.text.isEmpty()){

            }
            else{

                hnumero2 = textViewResultado.text.toString().toLong(radix = 16)
                var h:Int=hnumero2.toInt()

                textViewResultado.text = ""
                if (operacion == 1) {
                    if (h != 0) {
                        bresultado= ((hnumero1 / hnumero2).toInt())
                        textViewResultado.text = Integer.toHexString(bresultado).toUpperCase()
                    } else {
                        textViewResultado.text = "no se puede dividir entre 0 prenda"
                    }
                }
                if (operacion == 2) {
                    bresultado= ((hnumero1 * hnumero2).toInt())
                    textViewResultado.text = Integer.toHexString(bresultado).toUpperCase()

                }
                if (operacion == 3) {
                    bresultado= ((hnumero1 + hnumero2).toInt())
                    textViewResultado.text = Integer.toHexString(bresultado).toUpperCase()
                }
                if (operacion == 4) {
                    bresultado= ((hnumero1 - hnumero2).toInt())
                    textViewResultado.text = Integer.toHexString(bresultado).toUpperCase()
                }

            }

        }

    }




}


