package com.jantonioc.caculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.jantonioc.caculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //late init que se inicia despues y por eso es var
    private lateinit var binding : ActivityMainBinding
    //declaramos la variable privada, con inicializacion despues y que hereda de editext
    private lateinit var number1 : EditText
    private lateinit var number2 : EditText
    private lateinit var txtresul: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inicializar el binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        //le pasamos el binding root
        setContentView(binding.root)

        number1 = binding.edtNum1
        number2 = binding.edtNum2

        val btnsum = binding.btnsum
        val btnres = binding.btnres
        val btndiv = binding.btndiv
        val btnmulti = binding.btnmulti

        txtresul = binding.txtresult

        //otra forma de hacer el click
        /*btnsum.setOnClickListener{
            validarCampos()
            val n1 = number1.text.toString().toInt()
            val n2 = number2.text.toString().toInt()

            val sum = n1 + n2
            txtresul.text = "Resultado: $sum"
        }

        btnres.setOnClickListener{
            val n1 = number1.text.toString().toInt()
            val n2 = number2.text.toString().toInt()

            val res = n1 - n2
            txtresul.text = "Resultado: $res"
        }

        btndiv.setOnClickListener{
            val n1 = number1.text.toString().toInt()
            val n2 = number2.text.toString().toInt()

            if (n2==0)
            {
                Toast.makeText(this,"División entre 0 no permitida",Toast.LENGTH_SHORT).show()
            }
            else
            {
                val div = n1 / n2
                txtresul.text = "Resultado: $div"
            }

        }

        btnmulti.setOnClickListener{
            val multi = number2.text.toString().toInt() * number1.text.toString().toInt()
            txtresul.text = "Resultado: $multi"
        }*/



    }
    //llamamos a esta funcion desde las vista
    fun onButtonClick(view: View)
    {
        if(number1.text.isEmpty() || number2.text.isEmpty())
        {
            Toast.makeText(this,"Debe llenar todos los campos",Toast.LENGTH_SHORT).show()
            return
        }
        when(view.id)
        {
            R.id.btnsum ->{ val sum = number1.text.toString().toInt() + number2.text.toString().toInt()
                txtresul.text = "Resultado: $sum" }

            R.id.btnres ->{ val res = number1.text.toString().toInt() - number2.text.toString().toInt()
                txtresul.text = "Resultado: $res" }

            R.id.btnmulti ->{ val multi = number1.text.toString().toInt() * number2.text.toString().toInt()
                txtresul.text = "Resultado: $multi" }

            R.id.btndiv ->{ val div = number1.text.toString().toInt() / number2.text.toString().toInt()
                txtresul.text = "Resultado: $div" }
        }


    }

    fun validarCampos()
    {
        if(number1.text.toString().isEmpty())
        {
            Toast.makeText(this,"No puede dejar el texto vacio",Toast.LENGTH_SHORT).show()
        }
    }
}