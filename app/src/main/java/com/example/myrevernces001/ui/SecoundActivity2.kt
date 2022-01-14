package com.example.myrevernces001.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myrevernces001.R
import com.example.myrevernces001.model.User
import com.example.myrevernces001.ui.adapter.UserRecyclerView
import com.example.myrevernces001.ui.adapter.onItemClickRecycler

class SecoundActivity2 : AppCompatActivity(),onItemClickRecycler {

    lateinit var rv_showData:RecyclerView
    lateinit var edt_message:EditText
    lateinit var btn_add:Button

    var userListArsal:ArrayList<User> = ArrayList()
    var userName_secound:String? = null

    // اوبجكت من الريسايكلر فيو
    //  بس كذا يحجز اوبجكت في الممري حتى لو ما بستخدمه ولكن في طريقه افضل انك تسوي طريقه
    //  دليقست باي ليزي تاخر ولا تكريت اوبجكت الاى اذا استخدمتها
    //var userRecyclerView:UserRecyclerView= UserRecyclerView()
    val userRecyclerViewObject:UserRecyclerView by lazy {
        UserRecyclerView()
    }

    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secound2)

        if (intent != null){
           userName_secound = intent.getStringExtra("userName").toString()
        }
                                    //الريسايكلر هذا اربطه بالادبتر الي انا سويته
        rv_showData= findViewById(R.id.rv_showDataREC)
        edt_message=findViewById(R.id.ed_message)
        btn_add=findViewById(R.id.btn_add)
        // انا محتاج الان عشان خاطر ابدا فعليا اضيف للاري ليست نفسها اري ليسن ارسلها للريسايكلر فيو
        // محتاج اسوي اري ليست واعبيها عشان ارسلها للريسايكلر فيو
        // عشان اسوي اكشن على البتن add الاول احتاج يكون عندي اوبجكت من الريسايكلر فيو نفسه

        // اقله الريسايكلر لي اوت ان الادبتر تبعك هو الادبتر الي اخذنا منه ابجكت فوق
        rv_showData.adapter =userRecyclerViewObject

        btn_add.setOnClickListener {
                if (edt_message.text.isNotBlank()){


                // اول شي اسويه اعبي الاري ليست الي سويتها هنا
                userListArsal.add(
                    User(
                        userName_secound.toString(),
                        edt_message.text.toString(),
                        R.drawable.ic_launcher_background
                    )
                )

                //الان ضفناها للاري لست في كل علميه ضغط باقي نعرضها الان على الريسايكلر فيو في كل عملية اضافه في سطر
                userRecyclerViewObject.setUser(userListArsal)
                // الان بعد ا ضفنا نفرغ الادت تكست عشان نقدر نضيق مره اخرى
                edt_message.setText("")
                }else
            Toast.makeText(this,"الحقل فارغ ",Toast.LENGTH_LONG).show()

        }
        // نقول اوبجكت الريسايكلر فيو دون الفريبول الي عرفناه داخل الريسايكلر فيو يساوي الاستماع
        // تبعه على this هي مين هي الفنكشن الموجوده داخل الاكتفتي هنا
        userRecyclerViewObject.onListItemClickVar = this
    }

    override fun onItemClickRec(user: User) {
        super.onItemClickRec(user)
        Toast.makeText(this,"the user name $userName_secound \n${user.messageUs}",Toast.LENGTH_LONG).show()
    }
}