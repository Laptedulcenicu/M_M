package com.example.m_m


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_component_settings.*


class ComponentSettings : AppCompatActivity() {

   private val componentsName = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_component_settings)
        setData()
        backBtn.setOnClickListener {


            val intent = Intent(this@ComponentSettings, MainActivity::class.java)
            intent.putExtra("Components", componentsName)
            startActivity(intent)

        }

        val itemList=componentsName


        val adapter = ArrayAdapter(this, R.layout.list_item, R.id.txtview, itemList)
        val listV = findViewById<View>(R.id.list) as ListView
        listV.adapter = adapter

        btAdd.setOnClickListener {
            val newItem = txtInput.text.toString()
            itemList.add(newItem)
            adapter.notifyDataSetChanged()
            componentsName.add(txtInput.text.toString())
            val intent = Intent(this@ComponentSettings, MainActivity::class.java)
            intent.putExtra("Components", componentsName)
            txtInput.text.clear()
            txtInput.isEnabled=false
            txtInput.isEnabled=true
        }
    }

    private fun setData(){
        componentsName.clear()
        componentsName.add("Transport")
        componentsName.add("BirthDays")
        componentsName.add("Food")
        componentsName.add("University")
        componentsName.add("Travel")
        componentsName.add("Girlfriend")
        componentsName.add("Entertainment")



    }
}

