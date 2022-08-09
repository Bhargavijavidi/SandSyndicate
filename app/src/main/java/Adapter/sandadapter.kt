package Adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.sandsyndicate.R
import org.w3c.dom.Text
import java.sql.Time

class sandadapter(private val context: Activity,private val arrayList: ArrayList<sanddata>):
    ArrayAdapter<sanddata>(context, R.layout.sanddesign) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater:LayoutInflater= LayoutInflater.from(context)
        val view:View=inflater.inflate(R.layout.sanddesign,null)
        val Drivername:TextView=view.findViewById(R.id.sanddriver)
        val Trucknumber:TextView=view.findViewById(R.id.sandtruck)
        val Brassquality:TextView=view.findViewById(R.id.sandquality)
        val Payment:TextView=view.findViewById(R.id.sandpayment)
        val Message:TextView=view.findViewById(R.id.sandmessage)
        val img3:ImageView=view.findViewById(R.id.sandimg1)
        val img4:ImageView=view.findViewById(R.id.sandimg2)
       /* Timetamp.text=arrayList[position].Timestamp
        Image.setImageResource(arrayList[position].Image)*/
        Drivername.text=arrayList[position].Drivername
        Trucknumber.text=arrayList[position].Trucknumber
        Brassquality.text=arrayList[position].Qualitybrass
        Payment.text=arrayList[position].Payment
        Message.text=arrayList[position].Message
        img3.setImageResource(arrayList[position].img3)
        img4.setImageResource(arrayList[position].img4)
        return view
    }
}