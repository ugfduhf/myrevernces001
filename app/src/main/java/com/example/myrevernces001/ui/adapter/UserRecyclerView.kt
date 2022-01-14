package com.example.myrevernces001.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myrevernces001.R
import com.example.myrevernces001.model.User

//هنا سويه فيو هولدر كستم مخصص واعطيته اسم
class UserRecyclerView:RecyclerView.Adapter<UserRecyclerView.UserViewHolder>() {
    // تعريف الانترفيس لعرض الهولدر فيو
    var onListItemClickVar:onItemClickRecycler?=null

    var userList:ArrayList<User> = ArrayList()
    // فانكشن تستقبل وتعبي الاري
    fun setUser(userList01:ArrayList<User>){
        // وداخلها تعمل امبلمنت للفانكشن
        this.userList = userList01
        //معناه كل ما تضيف قيمه للري لست يبتدي يعمل نتفاي ui كله تتغير بالحاجات الجديده
        notifyDataSetChanged()
    }
                        //بضيف هنا كونستركتر فيه برمتر ايتم فيو من نوع فيو ويبدا يباصيه للبيرنت
   inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var iv_userImage:ImageView= itemView.findViewById(R.id.imageItem_user)
     var tv_userName:TextView = itemView.findViewById(R.id.tv_item_userName)
     var tv_message:TextView = itemView.findViewById(R.id.tv_item_message)
                            // فانكشن بتهولدر البايند
              fun bind(user: User){
                  //
                  iv_userImage.setImageResource(user.imageUs)
                    tv_userName.text = user.nameUs
                    tv_message.text = user.messageUs

                   //عشان اسوي اون كليك ليسنر لازم اسويه داخل فانكشن داخل الهولدر نفسه
                    itemView.setOnClickListener {
      //عشان اسوي انر كلاس حوة كلاس ثاني ويشوف القلوبل فاريبول الموجود في الكلاس الي هو الاوتر الي هو الي برى اكتب  قبل الكلاس inner
                        //بعد ماجهزتها في الريسايكلر فيو تسويلها امبلمنت من اي كلاس از اكتفتي
                        onListItemClickVar?.onItemClickRec(user)
                    }
              }
    }
    // هنا بترجعلي الفيو هولدر كله على بعضه
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        //هنا بترجعلي الفيو هولدر كله على بعضه الامج والتكست
                     //هنا انا مو واقف جوه اكتفتي لو واقف كان عمل سيت كونتكت فيو وانادي
                     // الفيو نفسه لو اربط لو بجيبه فيند فيو باي ايدي
                     // لكن هنا واقف على كلاس عادي اناديها LayoutInflater يعكسلي الي لاوت
                                    //هنا عندي فروم تاخذ كونتكست محتاج شي من نوع فيو
        var view:View= LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        //رحعت فيو هولدر ويستقبله فوق في يوزر فيو هولدر وافرزه فوق
        return UserViewHolder(view)
    }
  // هنا بترجعلي الفيو هولدر كله على بعضه
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        var user:User= userList.get(position)
      holder.bind(user)
    }
    // بتعطي عدد الالفيو هولدر
    override fun getItemCount(): Int {
      return  userList.size
    }
}


