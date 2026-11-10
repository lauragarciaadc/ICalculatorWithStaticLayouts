package com.example.icalculatorwithstaticlayouts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.icalculatorwithstaticlayouts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[CalculatorViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setupClickListeners()
    }

    private fun setupClickListeners() {
        // Botones numéricos
        binding.btn0.setOnClickListener { viewModel.onNumberClick("0") }
        binding.btn1.setOnClickListener { viewModel.onNumberClick("1") }
        binding.btn2.setOnClickListener { viewModel.onNumberClick("2") }
        binding.btn3.setOnClickListener { viewModel.onNumberClick("3") }
        binding.btn4.setOnClickListener { viewModel.onNumberClick("4") }
        binding.btn5.setOnClickListener { viewModel.onNumberClick("5") }
        binding.btn6.setOnClickListener { viewModel.onNumberClick("6") }
        binding.btn7.setOnClickListener { viewModel.onNumberClick("7") }
        binding.btn8.setOnClickListener { viewModel.onNumberClick("8") }
        binding.btn9.setOnClickListener { viewModel.onNumberClick("9") }

        // Botones de operación
        binding.btnAdd.setOnClickListener { viewModel.onOperationClick("+") }
        binding.btnSub.setOnClickListener { viewModel.onOperationClick("-") }
        binding.btnMult.setOnClickListener { viewModel.onOperationClick("*") }
        binding.btnDiv.setOnClickListener { viewModel.onOperationClick("/") }

        // Resultado y borrado
        binding.btnEquals.setOnClickListener { viewModel.onEqualsClick() }
        binding.btnC.setOnClickListener { viewModel.onClearClick() }
    }
}