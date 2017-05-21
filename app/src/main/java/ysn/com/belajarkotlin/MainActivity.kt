package ysn.com.belajarkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG: String? = "MainActivityTAG"
    private var editTextValue1ActivityMain: EditText? = null
    private var editTextValue2ActivityMain: EditText? = null
    private var buttonAdditionActivityMain: Button? = null
    private var buttonSubtrationActivityMain: Button? = null
    private var buttonMultiplicationActivityMain: Button? = null
    private var buttonDivisionActivityMain: Button? = null
    private var textViewResultActivityMain: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToolbar()
        initComponent()
        /*val coordinatorLayoutContainerActivityMain = findViewById(R.id.coordinator_layout_container_activity_main) as CoordinatorLayout;
        val toolbarActivityMain = findViewById(R.id.toolbar_activity_main) as Toolbar
        toolbarActivityMain.title = title;
        setSupportActionBar(toolbarActivityMain)

        val message = resources.getString(R.string.message)
        val buttonClick = findViewById(R.id.button_activity_main) as Button;
        buttonClick.setOnClickListener { view -> Snackbar.make(coordinatorLayoutContainerActivityMain, message, Snackbar.LENGTH_LONG).show() }*/


    }

    private fun initComponent() {
        editTextValue1ActivityMain = findViewById(R.id.edit_text_value_1_activity_main) as EditText
        editTextValue2ActivityMain = findViewById(R.id.edit_text_value_2_activity_main) as EditText
        buttonAdditionActivityMain = findViewById(R.id.button_addition_activity_main) as Button
        buttonSubtrationActivityMain = findViewById(R.id.button_subtraction_activity_main) as Button
        buttonMultiplicationActivityMain = findViewById(R.id.button_multiplication_activity_main) as Button
        buttonDivisionActivityMain = findViewById(R.id.button_division_activity_main) as Button
        textViewResultActivityMain = findViewById(R.id.text_view_result_activity_main) as TextView

        buttonAdditionActivityMain?.setOnClickListener(this)
        buttonSubtrationActivityMain?.setOnClickListener(this)
        buttonMultiplicationActivityMain?.setOnClickListener(this)
        buttonDivisionActivityMain?.setOnClickListener(this)

    }

    private fun setToolbar() {
        var toolbarActivityMain = findViewById(R.id.toolbar_activity_main) as Toolbar
        toolbarActivityMain.title = title
        setSupportActionBar(toolbarActivityMain)
    }

    override fun onClick(view: View?) {
        Log.d(TAG, "view: " + view?.id)
        when (view?.id) {
            R.id.button_addition_activity_main -> {
                val hashMapNilai = getEditTextValue()
                if (hashMapNilai?.get("nilai1") != null && hashMapNilai?.get("nilai2") != null) {
                    textViewResultActivityMain?.text = "" + (hashMapNilai?.get("nilai1")?.plus(hashMapNilai?.get("nilai2") as Int))
                } else {
                    textViewResultActivityMain?.text = "Value not valid"
                }
            }
            R.id.button_subtraction_activity_main -> {
                val hashMapNilai = getEditTextValue()
                if (hashMapNilai?.get("nilai1") != null && hashMapNilai?.get("nilai2") != null) {
                    textViewResultActivityMain?.text = "" + (hashMapNilai?.get("nilai1")?.minus(hashMapNilai?.get("nilai2") as Int))
                } else {
                    textViewResultActivityMain?.text = "Value not valid"
                }
            }
            R.id.button_multiplication_activity_main -> {
                val hashMapNilai = getEditTextValue()
                if (hashMapNilai?.get("nilai1") != null && hashMapNilai?.get("nilai2") != null) {
                    textViewResultActivityMain?.text = "" + (hashMapNilai?.get("nilai1")?.times(hashMapNilai?.get("nilai2") as Int))
                } else {
                    textViewResultActivityMain?.text = "Value not valid"
                }
            }
            R.id.button_division_activity_main -> {
                val hashMapNilai = getEditTextValue()
                if (hashMapNilai?.get("nilai1") != null && hashMapNilai?.get("nilai2") != null) {
                    textViewResultActivityMain?.text = "" + (hashMapNilai?.get("nilai1")?.div(hashMapNilai?.get("nilai2") as Int))
                } else {
                    textViewResultActivityMain?.text = "Value not valid"
                }
            }
            else -> {
                // nothing to do in here
            }
        }
    }

    private fun getEditTextValue(): HashMap<String, Int>? {
        val strNilai1 = editTextValue1ActivityMain?.text.toString()
        val strNilai2 = editTextValue2ActivityMain?.text.toString()
        val hashMapNilai = HashMap<String, Int>()
        if (TextUtils.isEmpty(strNilai1)) {
            showToast("Value 1 is empty")
        } else if (TextUtils.isEmpty(strNilai2)) {
            showToast("Value 2 is empty")
        } else {
            try {
                hashMapNilai.put("nilai1", strNilai1.toInt())
                hashMapNilai.put("nilai2", strNilai2.toInt())
            } catch (e: Exception) {
                e.printStackTrace()
                showToast("Value not valid")
            }
        }
        return hashMapNilai
    }

    private fun showToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG)
                .show()
    }

}

