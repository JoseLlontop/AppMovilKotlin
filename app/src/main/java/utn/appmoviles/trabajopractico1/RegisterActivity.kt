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

class RegisterActivity : AppCompatActivity() {

    //Variables de Clase
    private lateinit var etNombre: EditText
    private lateinit var etMail: EditText
    private lateinit var etPass: EditText
    private lateinit var etPass2: EditText
    private lateinit var btnAceptar: Button
    private lateinit var btnCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Llamada de las funciones
        initComponets()

        btnAceptar.setOnClickListener {
            if (validarRegistro()) {
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()  // Cierra la actividad actual para que el usuario no vuelva al registro con el botón de retroceso
            }

        }
        btnCancelar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    //Definion de las funciones
    private fun initComponets() {
        etNombre = findViewById(R.id.etNombre)
        etMail = findViewById(R.id.etMail)
        etPass = findViewById(R.id.etPass)
        etPass2 = findViewById(R.id.etPass2)
        btnAceptar = findViewById(R.id.btnAceptar)
        btnCancelar = findViewById(R.id.btnCancelar)
    }

    private fun validarRegistro(): Boolean {
        val nombreValido = validarNombre(etNombre.text.toString().trim())
        val emailValido = validarEmail(etMail.text.toString().trim())
        val contrasenaValida = validarPassword(etPass.text.toString().trim())
        val contrasenaIgual = validarPasswordsCoinciden(etPass.text.toString(), etPass2.text.toString())

        return nombreValido && emailValido && contrasenaValida && contrasenaIgual
    }

    // Función para validar el nombre
    private fun validarNombre(nombre: String): Boolean {
        if (nombre.isEmpty()) {
            Toast.makeText(this, "El campo de nombre no debe estar vacío", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    // Función para validar el email
    private fun validarEmail(email: String): Boolean {
        if (email.isEmpty()) {
            Toast.makeText(this, "El campo de e-mail no debe estar vacío", Toast.LENGTH_SHORT).show()
            return false
        } else if (!email.contains("@") || !email.contains(".")) {
            Toast.makeText(this, "El e-mail ingresado no es válido", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    // Función para validar la contraseña
    private fun validarPassword(password: String): Boolean {
        val letraRegex = Regex(".*[a-zA-Z].*")
        val numeroRegex = Regex(".*[0-9].*")

        if (password.length < 6) {
            Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show()
            return false
        } else if (!letraRegex.containsMatchIn(password)) {
            Toast.makeText(this, "La contraseña debe contener al menos una letra", Toast.LENGTH_SHORT).show()
            return false
        } else if (!numeroRegex.containsMatchIn(password)) {
            Toast.makeText(this, "La contraseña debe contener al menos un número", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    // Función para validar que las contraseñas coincidan
    private fun validarPasswordsCoinciden(password: String, password2: String): Boolean {
        if (password != password2) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

}