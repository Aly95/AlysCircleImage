package alyhuggan.circularlibrary

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.circularimage.AlysCircleImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<AlysCircleImageView>(R.id.mCircleImage)

        image.showImage(R.drawable.icn_union_jack, 400f)
        image.addStroke(Color.WHITE, 12f)
    }
}