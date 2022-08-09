package Adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.sandsyndicate.R

class approveradapter(private val context: Activity, private val arrayList: ArrayList<approverdata>):
    ArrayAdapter<approverdata>(context, R.layout.approvedesign,arrayList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater:LayoutInflater=LayoutInflater.from(context)
        val view:View=inflater.inflate(R.layout.approvedesign,null)
        val name:TextView=view.findViewById(R.id.appname)
        val email:TextView=view.findViewById(R.id.appemail)
        val contact:TextView=view.findViewById(R.id.appcontact)
        val type:TextView=view.findViewById(R.id.apptype)
        val app1:ImageView=view.findViewById(R.id.appright)
        val app2:ImageView=view.findViewById(R.id.appwrong)
        name.text=arrayList[position].name
        email.text=arrayList[position].email
        contact.text=arrayList[position].contact
        type.text=arrayList[position].type
        app1.setImageResource(arrayList[position].app1)
        app2.setImageResource(arrayList[position].app2)
        return view
    }
}