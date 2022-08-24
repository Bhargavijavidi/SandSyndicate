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

class FeedbackAdapter(private val context:Activity,private val arrayList: ArrayList<Feedbackdata>):
    ArrayAdapter<Feedbackdata>(context,R.layout.expensesdesign,arrayList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater:LayoutInflater= LayoutInflater.from(context)
        val view:View=inflater.inflate(R.layout.expensesdesign,null)
        val Name:TextView=view.findViewById(R.id.lname)
        val Particular:TextView=view.findViewById(R.id.lparticular)
        val Amount:TextView=view.findViewById(R.id.lamount)
        val Sitenumber:TextView=view.findViewById(R.id.lsite)
        val Image:ImageView=view.findViewById(R.id.creditcard)
        val Image2:ImageView=view.findViewById(R.id.debitcard)
        Name.text=arrayList[position].Name
        Particular.text=arrayList[position].Particular
        Amount.text=arrayList[position].amount
        Sitenumber.text=arrayList[position].sitenumber
        Image.setImageResource(arrayList[position].Image)
        Image2.setImageResource(arrayList[position].Image2)
        return view
    }
}