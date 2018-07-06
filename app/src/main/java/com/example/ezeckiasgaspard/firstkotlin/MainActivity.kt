package com.example.ezeckiasgaspard.firstkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import javax.xml.transform.Result

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Nombres
        tv1.setOnClickListener {appendOnExpression("1",true)}
        tv2.setOnClickListener {appendOnExpression("2",true)}
        tv3.setOnClickListener {appendOnExpression("3",true)}
        tv4.setOnClickListener {appendOnExpression("4",true)}
        tv5.setOnClickListener {appendOnExpression("5",true)}
        tv6.setOnClickListener {appendOnExpression("6",true)}
        tv7.setOnClickListener {appendOnExpression("7",true)}
        tv8.setOnClickListener {appendOnExpression("8",true)}
        tv9.setOnClickListener {appendOnExpression("9",true)}
        tv0.setOnClickListener {appendOnExpression("0",true)}
        tvDot.setOnClickListener {appendOnExpression(".",true)}

        //Opérateurs
        tvPlus.setOnClickListener{appendOnExpression("+", false)}
        tvMoins.setOnClickListener{appendOnExpression("-", false)}
        tvFois.setOnClickListener{appendOnExpression("*", false)}
        tvDiv.setOnClickListener{appendOnExpression("/", false)}
        tvEgal.setOnClickListener{appendOnExpression("=", false)}
        tvPA.setOnClickListener{appendOnExpression("(", false)}
        tvPB.setOnClickListener{appendOnExpression(")", false)}
        tvClear.setOnClickListener{appendOnExpression("CE", false)}

        tvClear.setOnClickListener{
            tvExpression.text=""
            tvResult.text=""
        }

        tvEgal.setOnClickListener{
            try{

                val expression = ExpressionBuilder (tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                val floatResult = result.toFloat()
                if(result == longResult.toDouble() )
                    tvResult.text = longResult.toString()
                else tvResult.text = longResult.toString()
                if(result == longResult.toDouble() )
                    tvResult.text = floatResult.toString()
                else tvResult.text = floatResult.toString()

            }catch (e:Exception){
                Log.d("Exception", "message :" +e.message )
            }
        }

        tvBack.setOnClickListener{
            val string = tvExpression.text.toString()
            if(string.isNotEmpty()){
                tvExpression.text = string.substring(0,string.length-1)
            }
            tvResult.text=""
        }
    }

    fun appendOnExpression (string: String, canClear: Boolean){

        if (tvResult.text.isNotEmpty()){
            tvExpression.text = ""
        }

        if (canClear){
            tvResult.text=""
            tvExpression.append(string)
        }
        else{
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text=""
        }
    }
}