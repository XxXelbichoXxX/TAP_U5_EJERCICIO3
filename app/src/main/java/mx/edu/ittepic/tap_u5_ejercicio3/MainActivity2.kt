package mx.edu.ittepic.tap_u5_ejercicio3

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    var fraseEnviada = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //pregunto si existe ya el permiso otorgado para el envio de mensajes
        val permiso = ActivityCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS)
        if(permiso == PackageManager.PERMISSION_DENIED){
            //ejecutar ventana de permisos
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.SEND_SMS),0)
        }
        //Desempaquetar el extra que envio Activity1
        val extra = intent!!.extras!!
        fraseEnviada = extra.getString("fraseSMS").toString()
        campoSMS.setText(fraseEnviada)

        button2.setOnClickListener {
            SmsManager.getDefault().sendTextMessage(numerocelular.text.toString(),null, campoSMS.text.toString(),null,null)
        }

        button3.setOnClickListener { finish() }
    }
}