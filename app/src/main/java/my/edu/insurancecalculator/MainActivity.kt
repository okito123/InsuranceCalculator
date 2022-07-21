package my.edu.insurancecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import my.edu.insurancecalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    //Todo(2): create instance of view binding
    //lateinit = late initialise
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Todo(3): initialise view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener{
            //Todo(4): get input from the user
            val age = binding.spinnerAge.selectedItemPosition
            val gender = binding.radioGroupGender.checkedRadioButtonId
            val smoker = binding.checkBoxSmoker.isChecked
            var premium = 0

            if (age==0){
               premium +=60
            }
            else if (age==1){
                premium+=70
                if(smoker){
                    premium+=100
                }
                if (gender==binding.radioMale.id){
                    premium+=50
                }
            }else if (age==2){
                premium+=90
                if(smoker){
                    premium+=150
                }
                if (gender==binding.radioMale.id){
                    premium+=100
                }
            }else if (age==3){
                premium+=120
                if(smoker) {
                    premium += 200
                }
                if (gender==binding.radioMale.id){
                    premium+=150
                }
            }else if (age==4){
                premium+=150
                if(smoker){
                    premium+=250
                }
                if (gender==binding.radioMale.id){
                    premium+=200
                }
            }else{
                premium+=150
                if(smoker){
                    premium+=300
                }
                if (gender==binding.radioMale.id){
                    premium+=200
                }
            }


            val final_premium = NumberFormat.getCurrencyInstance().format(premium)
            binding.textViewPremium.text = final_premium
        }

        binding.buttonReset.setOnClickListener{
            //Todo(5): clear input
            binding.textViewPremium.text = ""
            binding.checkBoxSmoker.isChecked=false
            binding.radioGroupGender.clearCheck()
            binding.spinnerAge.setSelection(0)
        }

    }
}