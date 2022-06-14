package com.example.moodtracker

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.Navigation
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate.MATERIAL_COLORS
import com.github.mikephil.charting.utils.ColorTemplate.VORDIPLOM_COLORS

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Report.newInstance] factory method to
 * create an instance of this fragment.
 */
class Report : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var pieChart:PieChart? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_report, container, false)
        view.findViewById<ImageButton>(R.id.home1).setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_report_to_homePage) }
        view.findViewById<ImageButton>(R.id.share1).setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_report_to_others_mood) }
        view.findViewById<ImageButton>(R.id.setting1).setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_report_to_setting) }
        pieChart = view.findViewById<PieChart>(R.id.PieChart)
        setupPieChart()
        loadPieChartData()
        return view
    }

    private fun setupPieChart() {
        pieChart?.setDrawHoleEnabled(true)
        pieChart?.setUsePercentValues(true)
        pieChart?.setEntryLabelColor(Color.BLACK)
        pieChart?.setCenterText("MOSTLY HAPPY")
        pieChart?.setCenterTextSize(24f)
        pieChart?.getDescription()?.setEnabled(false)

        val  legend: Legend? = pieChart?.getLegend()
        legend?.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP)
        legend?.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT)
        legend?.setOrientation(Legend.LegendOrientation.VERTICAL)
        legend?.setDrawInside(false)
        legend?.setEnabled(true)
    }

    private fun loadPieChartData(){
        val entries: Array<PieEntry> = arrayOf(PieEntry(22f,"HAPPY"),PieEntry(3f,"ANGRY"),
            PieEntry(2f,"DOWN"),PieEntry
                (2f,"HAPPINESS"),PieEntry
                (1f,"CONFUSED"))
        val colors = mutableListOf<Int>().apply(){
            for(color in MATERIAL_COLORS){
                add(color)
            }
            for(color in VORDIPLOM_COLORS){
                add(color)
            }
        }
        val dataset:PieDataSet = PieDataSet(entries.toMutableList(),"Ex")
        dataset.setColors(colors)

        val data:PieData = PieData(dataset)
        data.setDrawValues(true)
        data.setValueFormatter(PercentFormatter(pieChart))
        data.setValueTextSize(12f)
        data.setValueTextColor(Color.BLACK)

        pieChart?.setData(data)
        pieChart?.invalidate()

        pieChart?.animateY(1400,Easing.EaseInOutQuad)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Report.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Report().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}