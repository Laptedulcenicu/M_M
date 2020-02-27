package com.example.m_m

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


open class MainActivity : AppCompatActivity() {

    private val yValues = ArrayList<PieEntry>()
    @SuppressLint("SetTextI18n")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add.setOnClickListener {
            component.text = "nicuu"
        }
        component.setOnClickListener {
            val intent = Intent(this@MainActivity, ComponentSettings::class.java)
            startActivity(intent)
        }

        pieChartConfiguration()
        pieChartSetData()
        setTotalMoney()
        setDateAndMonth()




    }

    private fun pieChartConfiguration() {

        pieChart.setUsePercentValues(false)
        pieChart.description.isEnabled = false
        pieChart.setExtraOffsets(5f, 5f, 5f, 5f)
        pieChart.isDrawHoleEnabled = true
        pieChart.setHoleColor(Color.WHITE)
        pieChart.transparentCircleRadius = 61f
        pieChart.setTouchEnabled(false)
        pieChart.dragDecelerationFrictionCoef = 0.2f
    }

    private fun pieChartSetData() {


       val   componentsName=intent.getStringArrayListExtra("Components")

        componentsName.add("figa")
        componentsName.forEach {
                if (it!=null)
                yValues.add(PieEntry(10f, it) )
        }

        pieChart.animateY(1000, Easing.EaseInOutCubic)

        val dataSet = PieDataSet(yValues, "Components")
        dataSet.yMax
        dataSet.sliceSpace = 3f
        dataSet.selectionShift = 5f
        dataSet.colors = ColorTemplate.JOYFUL_COLORS.toList()

        val data = PieData((dataSet))

        data.setValueTextSize(10f)
        data.setValueTextColor(Color.WHITE)
        pieChart.data = data
        pieChart.invalidate()

    }

    private fun setTotalMoney() {
        var sum = 0f
        for (item in yValues) {
            sum += item.value
        }
        totalMoney.text = sum.toString()

    }

    @SuppressLint("SimpleDateFormat")
    private fun setDateAndMonth() {
        val simpleDateFormatf = SimpleDateFormat("dd-MMMM")
        val currentDateandTime = simpleDateFormatf.format(Date())
        dayAndMonth.text = currentDateandTime

    }


}
