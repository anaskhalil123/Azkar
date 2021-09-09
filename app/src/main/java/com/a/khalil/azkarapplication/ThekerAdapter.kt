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
        if (athkar[position].intro.isNotEmpty()) {
            holder.tvIntro.text = athkar[position].intro
        } else {
            holder.tvIntro.visibility = View.GONE
        }
        holder.tvTheker.text = athkar[position].text
        holder.tvbtunClick.text = athkar[position].buttonNumber.toString()

        holder.tvReward.setText(athkar[position].reward)
        val num2 = when (holder.tvTheker.text) {
            ("سبحان الله وبحمده.") -> 100
            ("لا إله إلا الله وحده لا شريك له، له الملك وله الحمد، وهو على كل شيءٍ قدير.") -> {
                if (holder.tvReward.text.equals("كتب الله له مائة حسنة، ومحا عنه مائة سيئة، وكانت له عدل رقبة.")) {
                    100
                } else {
                    10
                }
            }
            "قل هو الله أحد الله الصمد لم يولد ولم يولد ولم يكن له كفواً أحد." -> 3
            "قل أعوذ برب الفلق من شر ما خلق ومن شر غاسق إذا وقب ومن شر النفاثات في العقد ومن شر حاسد إذا حسد." -> 3
            "قل أعوذ برب الناس ملك الناس إله الناس  من شر الوسواس الخناس  الذي يوسوس في صدور الناس من الجنة والناس." -> 3
            "بسم الله الذي لا يضر مع اسمه شيء في الأرض ولا في السماء وهو السميع العليم." -> 3
            "رضيت بالله رباً وبالِإسلام ديناَ وبمحمد صلى الله عليه وسلم نبياً." -> 3
            "اللهم إني أصبحت أشهدك وأشهد حملة عرشك، وملائكتك وجميع خلقك بأنك أنت الله لا إله إلا أنت وحدك لا شريك لك، وأن محمداً عبدك ورسولك." -> 4
            "اللهم إني أمسيت أشهدك وأشهد حملة عرشك، وملائكتك وجميع خلقك بأنك أنت الله لا إله إلا أنت وحدك لا شريك لك، وأن محمداً عبدك ورسولك." -> 4
            "اللهم عافني في بدني، اللهم عافني في سمعي، اللهم عافني فيِ بصري لا إله إلا أنت اللهم إني أعوذ بك من الكفر والفقر وأعوذ بك من عذاب القبر لا إله إلا أنت." -> 3
            "أعوذ بكلمات الله التامات من شر ما خلق." -> 3
            "اللهم قني عذابك يوم تبعث عبادك." -> 3
            "سبحان الله (33 مرة)، والحمد لله (33 مرة)، والله أكبر (34 مرة)." -> 33
            else -> 1
        }

        holder.tvbtunClick.setOnClickListener {
            var num = Integer.parseInt(holder.tvbtunClick.text.toString())
            if (num > 0) {
                num--
            } else {
                num = 0
            }
            holder.tvbtunClick.text = num.toString()
            athkar[position].buttonNumber--
        }

        holder.imgRe.setOnClickListener {
            holder.tvbtunClick.text = num2.toString()
            athkar[position].buttonNumber = num2
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