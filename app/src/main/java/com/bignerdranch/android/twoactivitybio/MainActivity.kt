package com.bignerdranch.android.twoactivitybio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

private const val REQUEST_CODE_DISPLAY = 0

class MainActivity : AppCompatActivity() {

    private lateinit var bsButton: RadioButton
    private lateinit var basButton: RadioButton
    private lateinit var baButton: RadioButton
    private lateinit var bfaButton: RadioButton
    private lateinit var msButton: RadioButton
    private lateinit var maButton: RadioButton
    private lateinit var mfaButton: RadioButton
    private lateinit var mbaButton: RadioButton
    private lateinit var phdButton: RadioButton
    private lateinit var mdButton: RadioButton
    private lateinit var ddsButton: RadioButton
    private lateinit var jdButton: RadioButton
    private lateinit var radioButtonList: List<RadioButton>
    private lateinit var createButton: Button
    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var schoolEditText: EditText
    private lateinit var gradYearEditText: EditText
    private lateinit var favActivitiesEditText: EditText
    private lateinit var majorSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bsButton = findViewById(R.id.bsButton)
        basButton = findViewById(R.id.basButton)
        baButton = findViewById(R.id.baButton)
        bfaButton = findViewById(R.id.bfaButton)
        msButton = findViewById(R.id.msButton)
        maButton = findViewById(R.id.maButton)
        mfaButton = findViewById(R.id.mfaButton)
        mbaButton = findViewById(R.id.mbaButton)
        phdButton = findViewById(R.id.phdButton)
        mdButton = findViewById(R.id.mdButton)
        ddsButton = findViewById(R.id.ddsButton)
        jdButton = findViewById(R.id.jdButton)
        createButton = findViewById(R.id.createButton)
        firstNameEditText = findViewById(R.id.first_name_edit_text)
        lastNameEditText = findViewById(R.id.last_name_edit_text)
        schoolEditText = findViewById(R.id.school_edit_text)
        gradYearEditText = findViewById(R.id.grad_year_edit_text)
        majorSpinner = findViewById(R.id.majorSpinner)
        favActivitiesEditText = findViewById(R.id.fav_act_edit_text)

        ArrayAdapter.createFromResource(
            this,
            R.array.majors_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            majorSpinner.adapter = adapter
        }

        radioButtonList = listOf(bsButton, basButton, baButton, bfaButton,
            msButton, maButton, mfaButton, mbaButton, phdButton,
            mdButton, ddsButton, jdButton)

        bsButton.setOnClickListener {
            update(bsButton)
        }
        basButton.setOnClickListener{
            update(basButton)
        }
        baButton.setOnClickListener{
            update(bfaButton)
        }
        bfaButton.setOnClickListener{
            update(bfaButton)
        }
        msButton.setOnClickListener{
            update(msButton)
        }
        maButton.setOnClickListener{
            update(maButton)
        }
        mfaButton.setOnClickListener{
            update(mfaButton)
        }
        mbaButton.setOnClickListener{
            update(mbaButton)
        }
        phdButton.setOnClickListener{
            update(phdButton)
        }
        mdButton.setOnClickListener {
            update(mdButton)
        }
        ddsButton.setOnClickListener {
            update(ddsButton)
        }
        jdButton.setOnClickListener {
            update(jdButton)
        }

        createButton.setOnClickListener{

            val firstName = firstNameEditText.text.toString()
            val lastName = lastNameEditText.text.toString()
            val school = schoolEditText.text.toString()
            val gradYear = gradYearEditText.text.toString()
            val major =  majorSpinner.selectedItem.toString()

            val degree = when{
                bsButton.isChecked -> "B.S"
                baButton.isChecked -> "B.A"
                basButton.isChecked -> "BAS"
                bfaButton.isChecked -> "BFA"
                msButton.isChecked -> "M.S."
                maButton.isChecked -> "M.A."
                mfaButton.isChecked -> "MFA"
                mbaButton.isChecked -> "MBA"
                phdButton.isChecked -> "Ph.D."
                mdButton.isChecked -> "M.D."
                ddsButton.isChecked -> "DDS"
                jdButton.isChecked -> "J.D."
                else -> "Empty"
            }


            val favAct = favActivitiesEditText.text.toString()

            val toDisplay = String.format("$firstName $lastName graduated in "+
                    "$gradYear with a concentration in $major from $school. Their favourite" +
                    " activites are $favAct.")

            val intent = DisplayActivity.newIntent(this@MainActivity, toDisplay)
            startActivityForResult(intent, REQUEST_CODE_DISPLAY)


        }

    }

    private fun update(button : RadioButton){
        radioButtonList.forEach {
            button.isChecked = true
            if(it.id != button.id) it.isChecked = false
        }
    }
}