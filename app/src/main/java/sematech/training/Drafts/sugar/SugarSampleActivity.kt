package sematech.training.Drafts.sugar

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_sugar_sample.*
import sematech.training.R
import sematech.training.Drafts.kotlin.PublicMethod
import sematech.training.utils.BaseActivity

class SugarSampleActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        if(v?.id==R.id.register){
            val std = StudentModel()
            std.setName(name.text())
            std.setFamily(family.text())
            std.setAge(age.text().toInt())
            std.save()

            name.setText("")
            family.setText("")
            age.setText("")

            PublicMethod.toast(mContext,"user Registered")
            loadStudents();


        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sugar_sample)
        loadStudents();
        register.setOnClickListener(this)

    }

    fun loadStudents(){

//        val city : String = "Tehran"
//        print("my city is $city")
//        print("$city length is ${city.length} ")

        var students : List<StudentModel>? = StudentModel.listAll(StudentModel::class.java)

        students?.forEach {
            val res:String = "name is ${it.getName()}"
            results.append(res)
        }
    }
}
