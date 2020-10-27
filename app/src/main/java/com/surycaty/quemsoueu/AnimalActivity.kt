package com.surycaty.quemsoueu

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.TimeUnit


class AnimalActivity : AppCompatActivity() {

    lateinit var animals: Array<String>
    lateinit var txtName: TextView
    lateinit var txtCountDown: TextView
    lateinit var countDown: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal)

        animals = resources.getStringArray(R.array.animals)
        Log.d("Animais", animals.contentDeepToString())

        txtName = findViewById<TextView>(R.id.txtAnimalName)
        txtCountDown = findViewById<TextView>(R.id.txtCountDown)

        val FORMAT_COUNTER = "%02d:%02d:%02d";
        val mStartValue = 90L
        countDown = object : CountDownTimer(mStartValue * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
//                txtCountDown.text = String.format(FORMAT_COUNTER,
//                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),  // HOURS PASSED
//                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),  // MINUTES PASSED (over the hours)
//                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)) // SECONDS PASSED (over the minutes)
//                )
                txtCountDown.text = String.format("%d", millisUntilFinished / 1000)
            }

            override fun onFinish() {
                txtCountDown.setTextColor(Color.parseColor("#FF0000"))
                playEndSound()
            }
        }

        getCard()

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action) {
            MotionEvent.ACTION_UP -> getCard()
        }
        return super.onTouchEvent(event)
    }

    fun playEndSound() {
        val player: MediaPlayer = MediaPlayer.create(this, R.raw.sound_end)
        player.start()
    }

    private fun getCard() {

        val img = findViewById<ImageView>(R.id.imgAnimal)

        val animal = animals.random()

        when (animal) {
            "Camelo" -> img.setImageResource(R.drawable.img_camel)
            "Gato" -> img.setImageResource(R.drawable.img_cat)
            "Vaca" -> img.setImageResource(R.drawable.img_cow)
            "Cachorro" -> img.setImageResource(R.drawable.img_dog)
            "Pato" -> img.setImageResource(R.drawable.img_duck)
            "Elefante" -> img.setImageResource(R.drawable.img_elephant)
            "Peixe" -> img.setImageResource(R.drawable.img_fish)
            "Girafa" -> img.setImageResource(R.drawable.img_girafa)
            "Ganso" -> img.setImageResource(R.drawable.img_goose)
            "Lula" -> img.setImageResource(R.drawable.img_grilled_squid)
            "Joaninha" -> img.setImageResource(R.drawable.img_ladybug)
            "Leão" -> img.setImageResource(R.drawable.img_lion)
            "Macaco" -> img.setImageResource(R.drawable.img_monkey)
            "Panda" -> img.setImageResource(R.drawable.img_panda)
            "Pinguim" -> img.setImageResource(R.drawable.img_pinguin)
            "Coelho" -> img.setImageResource(R.drawable.img_rabbit)
            "Rato" -> img.setImageResource(R.drawable.img_rat)
            "Camarão" -> img.setImageResource(R.drawable.img_shrimp_prawn)
            "Cobra" -> img.setImageResource(R.drawable.img_snake)
            "Tigre" -> img.setImageResource(R.drawable.img_tigre)
            "Touro" -> img.setImageResource(R.drawable.img_touro)
            "Tartaruga" -> img.setImageResource(R.drawable.img_turtle)
            "Tubarão" -> img.setImageResource(R.drawable.img_wireshark)
            "Zebra" -> img.setImageResource(R.drawable.img_zebra)
            else -> img.setImageResource(R.drawable.img_elephant)

        }

        txtName.text = animal

        countDown.start()

    }

}