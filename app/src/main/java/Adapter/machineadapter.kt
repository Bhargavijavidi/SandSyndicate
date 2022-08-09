package Adapter

import android.animation.BidirectionalTypeConverter
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.sandsyndicate.R

open class machineadapter(private val context: Activity, private val arrayList: ArrayList<machinedata>):
ArrayAdapter<machinedata>(context,R.layout.machinedesign,arrayList){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater:LayoutInflater=LayoutInflater.from(context)
        val view:View=inflater.inflate(R.layout.machinedesign,null)
        val Machinename:TextView=view.findViewById(R.id.macname)
        val Fuel:TextView=view.findViewById(R.id.macfuel)
        val Startnumber:TextView=view.findViewById(R.id.macstart)
        val Endnumber:TextView=view.findViewById(R.id.macend)
        val Drivername:TextView=view.findViewById(R.id.macdriver)

        Machinename.text=arrayList[position].Machinename
        Fuel.text=arrayList[position].Fuel
        Startnumber.text=arrayList[position].Startnumber
        Endnumber.text=arrayList[position].Endnumber
        Drivername.text=arrayList[position].Drivername
        return view

    }
}