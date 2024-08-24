package utn.appmoviles.trabajopractico1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WelcomeActivity : AppCompatActivity() {

    //Variables de Clase
    private lateinit var username: String
    private lateinit var messege: TextView
    private lateinit var rbAndroid: RadioButton
    private lateinit var rbIOS: RadioButton
    private lateinit var platformLogo: ImageView
    private lateinit var cbOther: CheckBox
    private lateinit var etOtherPreference: EditText
    private lateinit var btnContinue: Button

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
        setupPlatformSelection()
        setupOtherPreferenceVisibility()
    }

    private fun initComponets() {
        // Obtención del nombre de usuario del Intent
        username = intent.extras?.getString("username").orEmpty()
        messege = findViewById(R.id.tvWelcome)

        // Inicialización de las vistas
        rbAndroid = findViewById(R.id.rbAndroid)
        rbIOS = findViewById(R.id.rbIOS)
        platformLogo = findViewById(R.id.platformLogo)
        cbOther = findViewById(R.id.cbOther)
        etOtherPreference = findViewById(R.id.etOtherPreference)
        btnContinue = findViewById(R.id.btnContinue)
    }

    private fun messegeWelcome() {
        // Configuración del mensaje de bienvenida
        messege.text = "Bienvenido $username"
    }

    private fun setupPlatformSelection() {
        // Cambio de logo según la plataforma seleccionada
        rbAndroid.setOnClickListener {
            platformLogo.setImageResource(R.drawable.android_logo) // Cambia a tu imagen de Android
        }

        rbIOS.setOnClickListener {
            platformLogo.setImageResource(R.drawable.ios_logo) // Cambia a tu imagen de iOS
        }
    }

    private fun setupOtherPreferenceVisibility() {
        // Mostrar o esconder el campo adicional si se selecciona "Otra"
        cbOther.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                etOtherPreference.visibility = View.VISIBLE
            } else {
                etOtherPreference.visibility = View.GONE
            }
        }
    }

}