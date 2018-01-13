package com.teguholica.androidbottomsheet

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.content_main.*
import android.support.design.widget.BottomSheetDialog




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(vToolbar)

        val sheetBehavior = BottomSheetBehavior.from(vBottomSheet)

        sheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        btnBottomSheet.text= "Close Sheet"
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        btnBottomSheet.text = "Expand Sheet"
                    }
                }
            }
        })

        btnBottomSheet.setOnClickListener {
            when(sheetBehavior.state) {
                BottomSheetBehavior.STATE_EXPANDED -> {
                    sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                    btnBottomSheet.text = "Close Sheet"
                }
                else -> {
                    sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                    btnBottomSheet.text = "Expand Sheet"
                }
            }
        }

        btnBottomSheetDialog.setOnClickListener {
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(layoutInflater.inflate(R.layout.fragment_bottom_sheet_dialog, null))
            dialog.show()
        }

        btnBottomSheetDialogFragment.setOnClickListener {
            val bottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
        }
    }
}
