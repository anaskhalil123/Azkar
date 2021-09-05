package com.a.khalil.azkarapplication

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ThekerAdapter(val context: Context, val athkar: ArrayList<Theker>) :
    RecyclerView.Adapter<ThekerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvIntro = itemView.findViewById<TextView>(R.id.tvIntro)
        val tvTheker = itemView.findViewById<TextView>(R.id.tvTheker)
        val tvbtunClick = itemView.findViewById<TextView>(R.id.btnClick)
        val imgRe = itemView.findViewById<ImageView>(R.id.imgRe)
        val imgEvidence = itemView.findViewById<ImageView>(R.id.imgEvidence)
        val tvReward = itemView.findViewById<TextView>(R.id.tvReward)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.theker, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var num2: Int = 0
        if (athkar[position].intro.isNotEmpty()) {
            holder.tvIntro.text = athkar[position].intro
        } else {
            holder.tvIntro.visibility = View.GONE
        }
        holder.tvTheker.text = athkar[position].text
        holder.tvbtunClick.text = athkar[position].buttonNumber.toString()

        holder.tvReward.setText(athkar[position].reward)
        num2 = Integer.parseInt(holder.tvbtunClick.text.toString())

        holder.tvbtunClick.setOnClickListener {
            var num = Integer.parseInt(holder.tvbtunClick.text.toString())
            if (num > 0) {
                num--
            } else {
                num = 0
            }
            holder.tvbtunClick.text = num.toString()
        }

        holder.imgRe.setOnClickListener {
            holder.tvbtunClick.text = num2.toString()
        }

        holder.imgEvidence.setOnClickListener {
            val dialogView = LayoutInflater.from(context).inflate(R.layout.alert_dialog, null)

            val alertDialog = AlertDialog.Builder(context)
                .setView(dialogView)
                .setCancelable(false)
                .show()

            val btnOk = dialogView.findViewById<Button>(R.id.btnOk)
            val tvEvidence = dialogView.findViewById<TextView>(R.id.tvEvidence)

            tvEvidence.setText(athkar[position].evidence)

            btnOk.setOnClickListener {
                alertDialog.dismiss()
            }
        }

    }

    override fun getItemCount(): Int {
        return athkar.size
    }

}