package br.com.pitagoras.mobile.jogardados

/** Exemplo baseado em código disponível no site google developers.
 * <!--
~ Copyright 2018, The Android Open Source Project
~
~ Licensed under the Apache License, Version 2.0 (the "License");
~ you may not use this file except in compliance with the License.
~ You may obtain a copy of the License at
~
~     http://www.apache.org/licenses/LICENSE-2.0
~
~ Unless required by applicable law or agreed to in writing, software
~ distributed under the License is distributed on an "AS IS" BASIS,
~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
~ See the License for the specific language governing permissions and
~ limitations under the License.
-->
 */
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import br.com.pitagoras.mobile.jogardados.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        configurarComponentes()
    }

    private fun configurarComponentes() {
        binding.buttonVamosLa.setOnClickListener {
            abrirNovaTela()
        }
    }

    private fun abrirNovaTela() {
        val idItemSelecionado = binding.radioGroupQuantidadeDados.checkedRadioButtonId
        val radioButtonSelecionado = findViewById<RadioButton>(idItemSelecionado)
        Log.d("[PITAGORAS]", "Id item selecionado: $idItemSelecionado")
        Log.d(
            "[PITAGORAS]",
            "Rótulo do botão selecionado: " +
                    "${radioButtonSelecionado?.text ?: "Nenhum item foi seleciondo"}"
        )
        // TODO(Informar ao usuário que ele deve selecionar a quantidade de dados, e não abrir a outra activity.)
        // TODO(Conferir se o objeto radioButtonselecionado não é nulo antes de realizar a conversão para inteiro na linha 58)
        val intent = Intent(this, RolarDadosActivity::class.java).apply {
            putExtra(
                TAG,
                if (radioButtonSelecionado.text.equals(getString(R.string.rotulo_um_dado))) 1 else 2
            )
        }
        startActivity(intent)
    }

    companion object {
        const val TAG = "qtdDados"
    }
}