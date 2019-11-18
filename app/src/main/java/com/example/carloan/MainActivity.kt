package com.example.carloan

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.calculate).setOnClickListener{
            calculate(it)
        }
    }

  private fun calculate(view: View)
  {
      val carprice:Double = findViewById<EditText>(R.id.carprice).text.toString().toDouble()
      val downpayment:Double= findViewById<EditText>(R.id.downpayment).text.toString().toDouble()
      val loanperiod:Double = findViewById<EditText>(R.id.loanperiod).text.toString().toDouble()
      val interestrate:Double = findViewById<EditText>(R.id.interestrate).text.toString().toDouble()
      val carloan = (carprice - downpayment)
      val interest = carloan * interestrate * loanperiod
      val monthlyrepay = ((carloan+ interest)/loanperiod/12 )

      carloanresult.text = "Car Loan : RM %.2f".format(carloan)
      interestresult.text = "Interest : RM %.2f". format(interest)
      monthlyrepayment.text = "Monthly Repayment : RM %.2f".format(monthlyrepay)
      carloanresult.visibility = View.VISIBLE
      interestresult.visibility = View.VISIBLE
      monthlyrepayment.visibility = View.VISIBLE

      val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
      inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

  }

}
