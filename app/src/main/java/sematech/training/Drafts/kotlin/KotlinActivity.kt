package sematech.training.Drafts.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_kotlin.*
import sematech.training.R

class KotlinActivity : AppCompatActivity(), View.OnClickListener {

//    var saveBTN: MyButton? = null

    override fun onClick(v: View?) {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

//        saveBTN= findViewById(R.id.save)
//        saveBTN?.text="Asghariiiiii"
//        saveBTN?.setOnClickListener(this)

        save.setOnClickListener(this)
        txt.setText("dfdfdfdfdfdf")

        PublicMethod.toast(this,"Helloooooooooo")
    }
}
