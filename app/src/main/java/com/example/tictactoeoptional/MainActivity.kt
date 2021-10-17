package com.example.tictactoeoptional

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var btn3:Button
    lateinit var btn4:Button
    lateinit var btn5:Button
    lateinit var btn6:Button
    lateinit var btn7:Button
    lateinit var btn8:Button
    lateinit var btn9:Button

    lateinit var tv1:TextView
    lateinit var tv2:TextView
    lateinit var tv3:TextView

    lateinit var buttons:List<Button>
    var activ = true
    var add = "X"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        whichPlayerActive(activ)
        buttonPressed()



    }


    fun init() {
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)

        tv1 = findViewById(R.id.tv1)
        tv2 = findViewById(R.id.tv2)
        tv3 = findViewById(R.id.tv3)

        buttons = listOf(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)

    }

    fun whichPlayerActive(aa:Boolean) {
        if (aa) {
            tv1.setBackgroundColor(Color.YELLOW)
            tv2.setBackgroundColor(Color.WHITE)
            add = "X"
            if (checkButtons()) {
                 tv3.text = "${tv1.text}  Winner\n Play again?"
            }
            } else {
                tv2.setBackgroundColor(Color.YELLOW)
                tv1.setBackgroundColor(Color.WHITE)
                add = "O"
            if (checkButtons()) {
                tv3.text = "${tv2.text}  Winner\n Play again?"
            }

            }
        endGame()

    }

    fun endGame(){
        if (checkButtons()) {
            tv1.text = "yes"
            tv1.setBackgroundColor(Color.GREEN)
            tv2.text = "No"
            tv2.setBackgroundColor(Color.RED)
            tv1.setOnClickListener{this.recreate()}
        }
    }

    fun buttonPressed(){
        for (i in buttons){
            if (i.isClickable){
                i.setOnClickListener {
                    i.text = add
                    activ = !activ
                    whichPlayerActive(activ)
                    endGame()
                }

            }
        }
    }

    fun checkButtons():Boolean{
        //Virticall
        if (btn1.text == btn2.text && btn2.text == btn3.text && btn3.text == add){return true}
        else if (btn4.text == btn5.text && btn5.text == btn6.text && btn6.text == add){return true}
        else if (btn7.text == btn8.text && btn8.text == btn9.text && btn9.text == add){return true}
         //horizontal
        else if (btn1.text == btn4.text && btn4.text == btn7.text && btn7.text == add){return true}
        else if (btn2.text == btn5.text && btn5.text == btn8.text && btn8.text == add){return true}
        else if (btn3.text == btn6.text && btn6.text == btn9.text && btn9.text == add){return true}
        //corner
        else if (btn3.text == btn5.text && btn5.text == btn7.text && btn7.text == add){return true}
        else if (btn1.text == btn5.text && btn5.text == btn9.text && btn9.text == add){return true}
        return false

    }
    }

