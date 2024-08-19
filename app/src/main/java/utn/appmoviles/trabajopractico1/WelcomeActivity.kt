package utn.appmoviles.trabajopractico1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WelcomeActivity : AppCompatActivity() {

    //Variables de Clase
    private lateinit var username : String
    private lateinit var messege : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Llamada de las funciones
        initComponets()
        messegeWelcome()
    }

    private fun initComponets() {
        username = intent.extras?.getString("username").orEmpty()
        messege = findViewById<TextView>(R.id.messageWelcome)
    }

    private fun messegeWelcome() {
        messege.text = "Hola Bienvenido $username"
    }

}