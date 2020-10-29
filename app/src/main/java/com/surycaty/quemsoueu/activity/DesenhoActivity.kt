package com.surycaty.quemsoueu.activity

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.surycaty.quemsoueu.R


class DesenhoActivity : AppCompatActivity() {

    private lateinit var desenhos: Array<String>
    private lateinit var txtCountDown: TextView
    private lateinit var countDown: CountDownTimer
    private lateinit var progressBar: ProgressBar

    private val FORMAT_COUNTER = "%02d"
    private val START_VALUE = 90L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desenho)

        desenhos = resources.getStringArray(R.array.desenhos)

        txtCountDown = findViewById(R.id.txtCountDown)
        progressBar = findViewById(R.id.progressBar)

        countDown = object : CountDownTimer(START_VALUE * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                txtCountDown.text = String.format(FORMAT_COUNTER, millisUntilFinished / 1000)
                progressBar.progress = txtCountDown.text.toString().toInt()
            }

            override fun onFinish() {
                txtCountDown.setTextColor(Color.RED)
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

        val img = findViewById<ImageView>(R.id.imgItem)

        val animal = desenhos.random()

        when (animal) {
            "Bob Esponja" -> img.setImageResource(R.drawable.img_desenho_bob_esponja)
            "Princesa Sopia" -> img.setImageResource(R.drawable.img_desenho_princesa_sofia)
            "Dora a Aventureira" -> img.setImageResource(R.drawable.img_desenho_dora)
            "Ben 10" -> img.setImageResource(R.drawable.img_desenho_ben10)
            "Homem Aranha" -> img.setImageResource(R.drawable.img_desenho_spiderman)
            "Blaze in The Monster Machine" -> img.setImageResource(R.drawable.img_desenho_blaze_and_the_monster_machines)
            "Show da Luna" -> img.setImageResource(R.drawable.img_desenho_show_da_luna)
            "Cavaleiros dos Zodíaco" -> img.setImageResource(R.drawable.img_desenho_cavaleiros_dos_zodiacos)
            "Dragon Ball Z" -> img.setImageResource(R.drawable.img_desenho_dragon_ball_z)
            "Sailor moon" -> img.setImageResource(R.drawable.img_desenho_sailor_moon)
            "Pica Pau" -> img.setImageResource(R.drawable.img_desenho_pica_pau)
            "Tom e Jerry" -> img.setImageResource(R.drawable.img_desenho_tom_and_jerry)
            "Garfield" -> img.setImageResource(R.drawable.img_desenho_garfield)
            "Smurfs" -> img.setImageResource(R.drawable.img_desenho_smurf)
            "Capitão Caverna" -> img.setImageResource(R.drawable.img_desenho_capitao_caverna)
            "Corrida Maluca" -> img.setImageResource(R.drawable.img_desenho_corrida_maluca)
            "Caverna do Dragão" -> img.setImageResource(R.drawable.img_desenho_caverna_do_dragao)
            else -> img.setImageResource(R.drawable.img_desenho_princesa_sofia)
        }

        txtCountDown.setTextColor(Color.WHITE)

        countDown.start()

    }

}