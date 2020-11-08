package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ArithmeticException
import java.lang.Math.round
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var operatorPressed: Boolean=true
    var equalsPressed=false
    var val1=""
    var val2=""
    var result=""
    var sign=""
    var pSign=""
    //I'M STILL WORKING A FULLY FUNCTIONAL PARSER THAT COULD EVALUATE EXPRESSIONS SUCH AS 2+2*3/3
    // BUT I FOUND THIS APPROACH TO BE EASIER IN THE MEANTIME
    fun buttonClicked(view: View) {
        if (view is Button){
            when (view.id){
                R.id.oneButton -> {
                    operatorPressed=false
                    inputTextView.text=inputTextView.text.toString()+"1"
                }
                R.id.twoButton -> {
                    operatorPressed=false
                    inputTextView.text=inputTextView.text.toString()+"2"
                }
                R.id.threeButton -> {
                    operatorPressed=false
                    inputTextView.text=inputTextView.text.toString()+"3"
                }
                R.id.fourButton -> {
                    operatorPressed=false
                    inputTextView.text=inputTextView.text.toString()+"4"
                }
                R.id.fiveButton -> {
                    operatorPressed=false
                    inputTextView.text=inputTextView.text.toString()+"5"
                }
                R.id.sixButton -> {
                    operatorPressed=false
                    inputTextView.text=inputTextView.text.toString()+"6"
                }
                R.id.sevenButton -> {
                    operatorPressed=false
                    inputTextView.text=inputTextView.text.toString()+"7"
                }
                R.id.eigthButton -> {
                    operatorPressed=false
                    inputTextView.text=inputTextView.text.toString()+"8"
                }
                R.id.nineButton -> {
                    operatorPressed=false
                    inputTextView.text=inputTextView.text.toString()+"9"
                }
                R.id.zeroButton -> {
                    operatorPressed=false
                    inputTextView.text=inputTextView.text.toString()+"0"
                }
                R.id.dotButton ->{
                    operatorPressed=false
                    inputTextView.text=inputTextView.text.toString()+"."
                }

                //WE HAVE TO PREVENT TWO OPERATORS TO BE PRESSED CONSECUTIVELY
                R.id.plusButton -> {
                    if(operatorPressed==false) {
                        inputButtons("+")
                    }
                    operatorPressed = true
                    equalsPressed=false
                }
                R.id.minusButton -> {
                    if(operatorPressed==false) {
                        inputButtons("-")
                    }
                    operatorPressed = true
                    equalsPressed=false
                }
                R.id.multiplyButton -> {
                    if(operatorPressed==false) {
                        inputButtons("X")
                    }
                    equalsPressed=false
                    operatorPressed = true
                }
                R.id.divideButton -> {
                    if(operatorPressed==false) {
                        inputButtons("/")
                    }
                    equalsPressed=false
                    operatorPressed = true
                }
                R.id.equalsButton ->{
                    equalsPressed=true
                    if (operatorPressed==true){

                    }
                    else if(val1.isEmpty() and val2.isEmpty()){

                    }
                    else if(val1.isNotEmpty() and val2.isEmpty() ){
                        if(inputTextView.text.isNotEmpty() and sign.isNotEmpty()){
                            result=calculate(val1,inputTextView.text.toString(),sign).toString()
                            val1=result
                            sign=""
                            pSign=""
                            resultTextView.text=result
                        }
                    }

                    else{
                        result=calculate(val1,inputTextView.text.toString(),sign).toString()
                        resultTextView.text=result
                    }
                }
                R.id.clearButton ->{
                    val1=""
                    val2=""
                    pSign=""
                    sign=""
                    result=""
                    inputTextView.text=""
                    resultTextView.text=""
                }
            }
        }
    }
    fun inputButtons (signs: String): Unit{
        if(sign.isEmpty()){
            sign = signs
            pSign= signs}
        else if(sign.isNotEmpty() and pSign.isNotEmpty()) {
            pSign=sign
            sign=signs
        }
        if(val1.isEmpty() and val2.isEmpty()){
            val1 = inputTextView.text.toString()
            inputTextView.text=""
        }
        else if (val1.isNotEmpty() and val2.isEmpty() and equalsPressed==false){
            val2 = inputTextView.text.toString()
            result= calculate(val1,val2,pSign).toString()
            resultTextView.text=result
            val1=result
            inputTextView.text=""
        }
        else if (val1.isNotEmpty() and val2.isEmpty() and equalsPressed==true) {
            inputTextView.text=""
            val2=""
        }
        else if (val1.isNotEmpty() and val2.isNotEmpty()){
            val1= result
            val2= inputTextView.text.toString()
            result= calculate(val1,val2,pSign).toString()
            resultTextView.text=result
            inputTextView.text=""
        }
    }
    fun calculate(val1: String,val2: String, sign:String): Double{
        var res=0.0
        if (sign=="+"){
            res=val1.toDouble()+val2.toDouble()
        }
        else if (sign=="-"){
            res=val1.toDouble()-val2.toDouble()
        }
        else if (sign=="X"){
            res=val1.toDouble()*val2.toDouble()
        }
        else if (sign=="/"){
            res=val1.toDouble()/val2.toDouble()
        }
        return res
    }
}



