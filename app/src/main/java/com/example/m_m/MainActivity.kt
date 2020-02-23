package com.example.m_m

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add.setOnClickListener{
            addComponent.text="nicuu"
        }


        pieChartConfiguration()

        val yValues = ArrayList<PieEntry>()

        yValues.add(PieEntry(11f, "Moldova"))
        yValues.add(PieEntry(3f, "Boreaaa"))
        yValues.add(PieEntry(10f, "USA"))
        yValues.add(PieEntry(30f, "Russia"))
        yValues.add(PieEntry(1f, "Tu"))

        pieChart.animateY(1000,Easing.EaseInOutCubic)

        val dataSet = PieDataSet(yValues, "Countries")
        dataSet.yMax
        dataSet.sliceSpace = 3f
        dataSet.selectionShift = 5f

        dataSet.colors = ColorTemplate.JOYFUL_COLORS.toList()

        val data = PieData((dataSet))
        // data.setValueFormatter()
        data.setValueTextSize(10f)
        data.setValueTextColor(Color.WHITE)
        pieChart.data = data
        pieChart.invalidate()

        var sum:Float=0f
        for (item in yValues){
            sum+=item.value
        }

        totalMoney.text=sum.toString()


        val sdf = SimpleDateFormat("dd-MMMM")
        val currentDateandTime = sdf.format(Date())
        dayAndMonth.text=currentDateandTime
    }

    private fun pieChartConfiguration(){

        pieChart.setUsePercentValues(false)
        pieChart.description.isEnabled = false
        pieChart.setExtraOffsets(5f, 10f, 5f, 5f)
        pieChart.isDrawHoleEnabled = true
        pieChart.setHoleColor(Color.WHITE)
        pieChart.transparentCircleRadius = 61f
        pieChart.setTouchEnabled(false)
        pieChart.dragDecelerationFrictionCoef=0.2f
    }

}
