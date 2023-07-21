package tarc.edu.my.practical3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import tarc.edu.my.practical3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inflate = load UI to memory
        binding = ActivityMainBinding.inflate(layoutInflater)
        //show the UI
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener {
            val age = binding.spinnerAge.selectedItemPosition
            val gender = binding.radioGroupGender.checkedRadioButtonId
            val smoker = binding.checkBoxSmoker.isChecked
            var premium = 0
           // val textViewPremium: TextView = findViewById(R.id.textViewPremium)
            if(age == 0) {//Less than 17
                premium += 60
            }
            else if (age == 1) {
                premium += 70
            }
            else if (age == 2) {
                premium += 90
            }
            else if (age == 3) {
                premium += 120
            }
            else if (age == 4 || age == 5) {
                premium += 150
            }

            if (gender == binding.radioButtonMale.id){
                if(age == 1) {
                    premium += 50
                }
                else if (age == 2) {
                    premium += 100
                }
                else if (age == 3) {
                    premium += 150
                }
                else if (age == 4 || age == 5) {
                    premium += 200
                }
            }
            if (smoker) {
                if(age == 1) {
                    premium += 100
                }
                else if (age == 2) {
                    premium += 150
                }
                else if (age == 3) {
                    premium += 200
                }
                else if (age == 4) {
                    premium += 250
                }
                else if (age == 5) {
                    premium += 300
                }
            }
            //textViewPremium.text = premium.toString()
            //binding.textViewPremium.text = String.format("%d", premium)
            binding.textViewPremium.text = premium.toString()
        }
        binding.buttonReset.setOnClickListener {
            binding.spinnerAge.selectedItemPosition == 0
            binding.radioGroupGender.checkedRadioButtonId == 0
            binding.textViewPremium.text = getString(R.string.premium)
        }
    }
}