package com.example.daltonico

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.daltonico.databinding.ActivityMainBinding
import com.example.daltonico.databinding.ActivityRespostaBinding

class RespostaActivity : AppCompatActivity() {

    lateinit var binding: ActivityRespostaBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_resposta)

        var params:Bundle? = intent.extras
        var opcao = params?.getString("opcao")
        if (opcao.toString() == "buttonTeste1") {
            binding.imageView.setImageResource(R.drawable.primeiro)
        }else if (opcao.toString() == "buttonTeste2") {
            binding.imageView.setImageResource(R.drawable.segunda)
        }else if (opcao.toString() == "buttonTeste3") {
            binding.imageView.setImageResource(R.drawable.terceira)
        }

        binding.buttonEnviarResposta.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val bundle = Bundle()

            bundle.putString("result", binding.editTextDigiteAresposta.text.toString())
            intent.putExtras(bundle)

            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        binding.buttonCancelar.setOnClickListener {
            Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}