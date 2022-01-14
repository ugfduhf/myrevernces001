package com.example.myrevernces001.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myrevernces001.R

// هنا استدعاء الانتر فيس الليسنر وتم توقيفه
class MainActivity : AppCompatActivity()  // View.OnClickListener
 {
     //Global variables
     val userName:String="yasser"
     val password:String="059"
    // Global references
    lateinit var edt_username: EditText
    lateinit var edt_password: EditText
    lateinit var btn_login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //فوق عرفناها وهنا نربطهم بال
        edt_username = findViewById(R.id.edNameLogin)
        edt_password = findViewById(R.id.passwordLogin)
        btn_login = findViewById(R.id.btn_login)

        //يعني تحط مستمع اول ما يكلك على البتن يتوجه الى داله اون كلك وينفذ
        // بعد ما تعرفها وتعرف الفنكشن تعملها استدعاء للفنكشن وتعطيها الكلاس المنفذ الي هو المين
       // btn_login.setOnClickListener(this)

        //الطريقة الثالثه هي انك تستدعي اون كلك لسنر وتنفذ على طول الكود جوتها على طول
        //!edt_password.text.toString().isNullOrEmpty()
        btn_login.setOnClickListener {

            if (edt_username.text.toString().isNullOrEmpty() || edt_username.text.toString() != userName){
                Toast.makeText(this, "Enter your correct username", Toast.LENGTH_LONG).show()
            }else if(edt_password.text.toString().isNullOrEmpty() || edt_password.text.toString() != password){
                    Toast.makeText(this, "Empty or Enter your correct password", Toast.LENGTH_LONG).show()
                   }else if(edt_username.text.toString() == userName && edt_password.text.toString() == password){
                Toast.makeText(this, " correct data", Toast.LENGTH_LONG).show()
                var intent = Intent(this, SecoundActivity2::class.java)
                intent.putExtra("userName",edt_username.text.toString())
                startActivity(intent)
            }
            else {
              true //Toast.makeText(this, "your input field wrong", Toast.LENGTH_LONG).show()
            }

        }

    }
    // تسويها لسنر عن طريق الانتر فيس  اذا كان فيه بتن كثير
//    override fun onClick(v: View?) {
//        //اعطيه الفربول فيو واعطيها تعجب واقول انه ما ينفع ياخذ نل بالطريقه هذي دو اي دي ويقارن بال اي دي
//        when(v!!.id){
//            R.id.btn_login ->{
//                Toast.makeText(this,"good to is",Toast.LENGTH_LONG).show()
//            }
//        }


// هذي طريقه الليسنر عن طريق xml الطريقه الاولى وما احد يفضلها
//    fun btnles(view: android.view.View) {
//        Toast.makeText(this,"good to is",Toast.LENGTH_LONG).show()
//    }
}