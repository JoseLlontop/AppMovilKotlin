package utn.appmoviles.trabajopractico1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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

    private var userActual = ""
    private var passwordActual = ""

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
        initListener()
    }

    //Definion de las funciones
    private fun initComponets() {
        inputUsername = findViewById(R.id.inputUser)
        inputPassword = findViewById(R.id.inputPassword)
        btnLogin = findViewById(R.id.btnLogin)
    }

    private fun initListener() {
        btnLogin.setOnClickListener {

            userActual = inputUsername.text.toString()
            passwordActual = inputPassword.text.toString()

            if (validarUsuario(userActual) && validarPassword(passwordActual)) {

                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("username", userActual)
                startActivity(intent)
            }
        }
    }

    // Función para validar la contraseña
    private fun validarPassword(password: String): Boolean {

        if (password.isEmpty()) {
            Toast.makeText(this, "El campo de contraseña está vacío", Toast.LENGTH_SHORT).show()
            return false
        } else if (password != PASSWORD_PERMITIDO) {
            Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    // Función para validar el usuario
    private fun validarUsuario(usuario: String): Boolean {

        if (usuario.isEmpty()) {
            Toast.makeText(this, "El campo de usuario está vacío", Toast.LENGTH_SHORT).show()
            return false
        } else if (usuario != USUARIO_PERMITIDO) {
            Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}
