package br.com.pitagoras.mobile.jogardados

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.com.pitagoras.mobile.jogardados.databinding.ActivityRolarDadosBinding
import kotlin.random.Random

class RolarDadosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRolarDadosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRolarDadosBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        configurarComponentes()
    }

    private fun configurarComponentes() {
        // Capituramos dados vindos da outra activity (1, caso nada seja enviado)
        var quantidadeDados = intent.getIntExtra(MainActivity.TAG, 1)
        Log.d("[PITAGORAS]", "Quantidade de dados passada: $quantidadeDados")
        configurarBotoes(quantidadeDados)

        // Exemplo de como remover um elemento da view
        binding.ivDado2.visibility = View.GONE
    }

    private fun configurarBotoes(quantidadeDados: Int) {
        binding.btRolarDados.setOnClickListener {
            rolarDados(quantidadeDados)
        }
    }

    // TODO(Utilizar a quantidade de dados para determinar a quantidade de números aleatóris gerados e também quantos dados serão exibidos)
    private fun rolarDados(quantidadeDados: Int) {
        val resultado = Random.nextInt(6) + 1

        val faceDoDado = when (resultado) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Altera a imagem exibida de acordo com o comando da linha 37 (seleção de imagem)
        binding.ivDado1.setImageResource(faceDoDado)

    }
}
