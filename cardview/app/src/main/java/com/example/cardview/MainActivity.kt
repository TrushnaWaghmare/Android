
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.cardview.R

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        val webView = findViewById<CardView>(R.id.button2)
        val youtube = findViewById<CardView>(R.id.button)

        webView.setOnClickListener {
            val intents = Intent(Intent.ACTION_VIEW)
            intents.data = Uri.parse("https://poki.com/")
            startActivity(intents)
        }
        youtube.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
           intent.data = Uri.parse("https://www.youtube.com/")
            startActivity(intent)
        }
    }
}
