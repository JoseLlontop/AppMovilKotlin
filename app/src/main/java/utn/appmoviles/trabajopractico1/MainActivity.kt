package utn.appmoviles.trabajopractico1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val USUARIO_PERMITIDO = "Juan Torres"
const val PASSWORD_PERMITIDO = "1234utn"

class MainActivity : AppCompatActivity() {

    //Variables de Clase
    private lateinit var inputUsername : EditText
    private lateinit var inputPassword : EditText
    private lateinit var btnLogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Llamada de las funciones
        initComponets()
    }

    //Definion de las funciones
    private fun initComponets() {
        inputUsername = findViewById(R.id.inputUser)
        inputPassword = findViewById(R.id.inputPassword)
        btnLogin = findViewById(R.id.btnLogin)
    }

}
