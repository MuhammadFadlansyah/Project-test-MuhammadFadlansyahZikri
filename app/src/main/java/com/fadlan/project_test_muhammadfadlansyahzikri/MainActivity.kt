package com.fadlan.project_test_muhammadfadlansyahzikri

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var nameInput: EditText
    private lateinit var palindromeInput: EditText
    private lateinit var checkButton: Button
    private lateinit var nextButton: Button
    private val REQUEST_CODE = 101 // Arbitrary request code for starting MainActivity2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameInput = findViewById(R.id.nama)
        palindromeInput = findViewById(R.id.palindrome)
        checkButton = findViewById(R.id.btncek)
        nextButton = findViewById(R.id.btnnext)

        checkButton.setOnClickListener {
            val inputSentence = palindromeInput.text.toString()

            val isPalindrome = isPalindrome(inputSentence)
            val message = isPalindrome.toString()
            showDialog(message)
            palindromeInput.text.clear()
        }

        nextButton.setOnClickListener {
            val inputName = nameInput.text.toString()

            // Start MainActivity2 with data transfer
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("name", inputName) // Send inputName to MainActivity2
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    // Function to check palindrome
    private fun isPalindrome(sentence: String): Boolean {
        val cleanSentence = sentence.replace("\\s+".toRegex(), "").toLowerCase()
        if (cleanSentence.isEmpty()) {
            return false
        }
        return cleanSentence == cleanSentence.reversed()
    }

    // Function to show dialog
    private fun showDialog(message: String) {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setMessage(message)
        alertDialogBuilder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}
