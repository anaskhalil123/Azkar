package com.a.khalil.azkarapplication

import android.app.AlertDialog
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.a.khalil.azkarapplication.model.Theker

class ThekerAdapter(val context: Context, val athkar: Array<Array<Any>>) :
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

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val theker = athkar[position][0] as Theker

        if (theker.intro.isNotEmpty()) {
            holder.tvIntro.text = theker.intro
        } else {
            holder.tvIntro.visibility = View.GONE
        }
        holder.tvTheker.text = theker.text
        holder.tvbtunClick.text = (athkar[position][1] as Int).toString()
        holder.tvReward.text = theker.reward

        holder.tvbtunClick.setOnClickListener {

            if (athkar[position][1] as Int > 0) {
                athkar[position][1] = athkar[position][1] as Int - 1
                holder.tvbtunClick.text = (athkar[position][1] as Int).toString()
            }
        }

        holder.imgRe.setOnClickListener {
            athkar[position][1] = theker.buttonNumber
            holder.tvbtunClick.text = (athkar[position][1] as Int).toString()
        }

        holder.imgEvidence.setOnClickListener {
            val dialogView = LayoutInflater.from(context).inflate(R.layout.alert_dialog, null)

            val alertDialog = AlertDialog.Builder(context)
                .setView(dialogView)
                .setCancelable(false)
                .show()

            val btnOk = dialogView.findViewById<Button>(R.id.btnOk)
            val tvEvidence = dialogView.findViewById<TextView>(R.id.tvEvidence)

            tvEvidence.setText(theker.evidence)

            btnOk.setOnClickListener {
                alertDialog.dismiss()
            }
        }
    }

    override fun getItemCount(): Int {
        return athkar.size
    }

}