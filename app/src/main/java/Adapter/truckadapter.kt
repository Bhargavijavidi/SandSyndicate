package Adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.sandsyndicate.R

class truckadapter (private val context: Activity, private val arrayList: ArrayList<truckdata>):
    ArrayAdapter<truckdata>(context, R.layout.truckdesign,arrayList){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View =inflater.inflate(R.layout.truckdesign,null)
        val Drivername: TextView =view.findViewById(R.id.dname)
        val Trucknumber: TextView =view.findViewById(R.id.tnumber)
        Drivername.text=arrayList[position].TruckDrivername
        Trucknumber.text=arrayList[position].Numbertruck
        return view
    }
}