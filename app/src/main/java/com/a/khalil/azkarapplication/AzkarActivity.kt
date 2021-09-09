package com.a.khalil.azkarapplication

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/*لو بدي أضيف قسم جديد من الأذكار بدي أراعي التالي:
1- لو في ذكر يقال أكثر من مرة لازم أزبط الnum2الي في الadapter عشان تتلائم معاه
2- لازم لما أعمل الelse, if إله أنتبه لموضوع أنو أخلي الbuttonsNumbers فاضية لو كانت من قسم تاني من أقسام الأذكار، وذلك عن طريق أني أسألها هل أنت تحتوي على (وأكتب دعاء خاص بهذا القسم ولا يوجد في غيره من الأقسام) لو نعم أخليها كما هي لو لا أخليها فاضية
3- لو أضيف عدد المرات التي يقال فيها الذكر بدي أعمل الif أنو لو كانت المجموعة ليست فارغة فالرقم هو العدد المحاذي من عناصر المجموعة
والله ولي التوفيق
 */


class AzkarActivity : AppCompatActivity() {

    val recyclerView: RecyclerView by lazy { findViewById(R.id.recyclerView) }
    val azkarList: ArrayList<Theker> = ArrayList()
    val tv_toolbar: TextView by lazy { findViewById(R.id.toolbarText) }
    var buttonsNumbers: ArrayList<Int> = ArrayList()
    private val TAG = "AzkarActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_azkar)

        window.statusBarColor = ContextCompat.getColor(this, R.color.statusBarColor)

        if (savedInstanceState?.getIntegerArrayList("buttonNumbers")?.isNotEmpty() == true)
            buttonsNumbers = savedInstanceState.getIntegerArrayList("buttonNumbers")!!

        if (!intent.getStringExtra("btnName")!!.equals(null) && intent.getStringExtra("btnName")
                .equals(getString(R.string.spaah))
        ) {
            tv_toolbar.setText(getString(R.string.spaah))

            azkarList.clear()
            azkarList.add(
                Theker(
                    "",
                    "سبحان الله وبحمده.",
                    if (buttonsNumbers.isEmpty()) {
                        Log.d(TAG, "buttonNumbers is empty, $buttonsNumbers")
                        100
                    } else buttonsNumbers[0],
                    " حطت خطاياه وإن كانت مثل زبد البحر و لم يأت أحد يوم القيامة بأفضل مما جاء به إلا أحد قال مثل ما قال أو زاد عليه.",
                    "عن أبي هريرة رضي الله عنه عن النبي صلى الله عليه وسلم قال (من قال حين يصبح وحين يمسي: سبحان الله وبحمده مائة مرة لم يأت أحد يوم القيامة بأفضل مما جاء به إلا أحد قال مثل ما قال أو زاد عليه) رواه مسلم."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "أصبحنا وأصبح الملك لله، والحمد لله، لا إله إلا الله وحده لا شريك له، له الملك وله الحمد وهو على كل شيء قدير، رب أسألك خير ما في هذا اليوم، وخير ما بعده، وأعوذ بك من شر ما في هذا اليوم وشر ما بعده، رب أعوذ بك من الكسل وسوء الكبر، رب أعوذ بك من عذاب في النار، وعذاب في القبر.",
                    if (buttonsNumbers.isEmpty()) 1 else buttonsNumbers[1],
                    "",
                    "عن عبد الله بن مسعود رضي الله عنه قال: " +
                            "كان نبي الله صلى الله عليه وسلم إذا أمسى قال: (أمسينا وأمسى الملك لله، والحمد لله، لا إله إلا الله وحده لا شريك له، له الملك وله الحمد وهو على كل شيء قدير، رب أسألك خير ما في هذه الليلة، وخير ما بعدها، وأعوذ بك من شر ما في هذه الليلة وشر ما بعدها، رب أعوذ بك من الكسل وسوء الكبر، رب أعوذ بك من عذاب في النار، وعذاب في القبر) وإذا أصبح قال ذلك أيضاً أصبحنا وأصبح الملك لله رواه مسلم.\n"
                )
            )
            azkarList.add(
                Theker(
                    "",
                    "اللهم أنت ربي، لا إله إلا أنت، خلقتني وأنا عبدك، وأنا على عهدك ووعدك ما استطعت، أعوذ بك من شر ما صنعت، أبوء لك بنعمتك عليَّ، وأبوء لك بذنبي، فاغفر لي فإنه لا يغفر الذنوب إلا أنت.",
                    if (buttonsNumbers.isEmpty()) 1 else buttonsNumbers[2],
                    "من قالها من النهار موقناً بها فمات من يومه قبل أن يمسي فهو من أهل الجنة، ومن قالها من الليل وهو موقن بها فمات قبل أن يصبح فهو من أهل الجنة.",
                    "عن شداد بن أوس رضي الله عنه عن النبي صلى الله عليه وسلم قال: (سيد الاستغفار: اللهم أنت ربي، لا إله إلا أنت، خلقتني وأنا عبدك، وأنا على عهدك ووعدك ما استطعت، أعوذ بك من شر ما صنعت، أبوء لك بنعمتك عليَّ، وأبوء لك بذنبي، فاغفر لي فإنه لا يغفر الذنوب إلا أنت. قال: ومن قالها من النهار موقناً بها فمات من يومه قبل أن يمسي فهو من أهل الجنة، ومن قالها من الليل وهو موقن بها فمات قبل أن يصبح فهو من أهل الجنة) رواه البخاري"
                )
            )

            azkarList.add(
                Theker(
                    getString(R.string.basmallah),
                    "قل هو الله أحد الله الصمد لم يولد ولم يولد ولم يكن له كفواً أحد.",
                    if (buttonsNumbers.isEmpty()) 3 else buttonsNumbers[3],
                    "من قالها حين يصبح وحين يمسي كفته من كل شيء(الإخلاص والمعوذتين).",
                    "عن عبد الله بن حبيب قال: خرجنا في ليلة مطر وظلمة شديدة نطلب النبي صلى الله عليه وسلم ليصلي لنا فأدركناه فقال: (قل) فلم أقل شيئاً، ثم قال: (قل) فلم أقل شيئاً، تم قال: (قل): فقلت: يا رسول الله ما أقول، قال:( قل: قل هو الله أحد والمعوذتين حين تمسي وحين تصبح ثلاث مرات تكفيك من كل شيء) رواه أبو داود، والترمذي، والنسائي بإسناد حسن."
                )
            )

            azkarList.add(
                Theker(
                    getString(R.string.basmallah),
                    "قل أعوذ برب الفلق من شر ما خلق ومن شر غاسق إذا وقب ومن شر النفاثات في العقد ومن شر حاسد إذا حسد.",
                    if (buttonsNumbers.isEmpty()) 3 else buttonsNumbers[4],
                    "من قالها حين يصبح وحين يمسي كفته من كل شيء(الإخلاص والمعوذتين).",
                    "عن عبد الله بن حبيب قال: خرجنا في ليلة مطر وظلمة شديدة نطلب النبي صلى الله عليه وسلم ليصلي لنا فأدركناه فقال: (قل) فلم أقل شيئاً، ثم قال: (قل) فلم أقل شيئاً، تم قال: (قل): فقلت: يا رسول الله ما أقول، قال:( قل: قل هو الله أحد والمعوذتين حين تمسي وحين تصبح ثلاث مرات تكفيك من كل شيء) رواه أبو داود، والترمذي، والنسائي بإسناد حسن."
                )
            )

            azkarList.add(
                Theker(
                    getString(R.string.basmallah),
                    "قل أعوذ برب الناس ملك الناس إله الناس  من شر الوسواس الخناس  الذي يوسوس في صدور الناس من الجنة والناس",
                    if (buttonsNumbers.isEmpty()) 3 else buttonsNumbers[5],
                    "من قالها حين يصبح وحين يمسي كفته من كل شيء(الإخلاص والمعوذتين).",
                    "عن عبد الله بن حبيب قال: خرجنا في ليلة مطر وظلمة شديدة نطلب النبي صلى الله عليه وسلم ليصلي لنا فأدركناه فقال: (قل) فلم أقل شيئاً، ثم قال: (قل) فلم أقل شيئاً، تم قال: (قل): فقلت: يا رسول الله ما أقول، قال:( قل: قل هو الله أحد والمعوذتين حين تمسي وحين تصبح ثلاث مرات تكفيك من كل شيء) رواه أبو داود، والترمذي، والنسائي بإسناد حسن."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "اللهم بك أصبحنا وبك أمسينا وبك نحيا وبك نموت وإليك النشور.",
                    if (buttonsNumbers.isEmpty()) 1 else buttonsNumbers[6],
                    "",
                    "عن أبي هريرة رضي الله عنه عن النبي صلى الله عليه وسلم أنه كان يعلم أصحابه يقول: (إذا أصبح أحدكم فليقل: اللهم بك أصبحنا وبك أمسينا وبك نحيا وبك نموت وإليك النشور، وإذا أمسى فليقل اللهم بك أمسينا وبك أصبحنا وبك نحيا وبك نموت وإليك المصير) رواه أبو داود والترمذي والنسائي وابن ماجه، واسناده عند أبي داود وابن ماجه صحيح."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "اللهم فاطر السموات والأرض، عالم الغيب والشهادة رب كل شيء ومليكه أشهد أن لا إله إلا أنت، أعوذ بك من شرِ نفسي وشر الشيطان وشركه وأن أقترف على نفسي سوءاً أو أجره إلى مسلم.",
                    if (buttonsNumbers.isEmpty()) 1 else buttonsNumbers[7],
                    "",
                    "عن أبي هريرة رضي الله عنه، أن أبا بكر الصديق رضي الله عنه قال: «يا رسول الله، مرنى بكلمات أقولهن إذا أصبحت وإذا أمسيت قال:( قل: اللهم فاطر السموات والأرض، عالم الغيب والشهادة رب كل شيء ومليكه أشهد أن لا إله إلا أنت، أعوذ بك من شرِ نفسي وشر الشيطان وشركه وأن أقترف على نفسي سوءا أو أجره إلى مسلم). قال:( قلها إذا أصبحت وإذا أمسيت وإذا أخذت مضجعك)  رواه الِإمام أحمد وأبو داود والترمذي والنسائي والبخاري في الأدب المفرد بإسناد صحيح."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "بسم الله الذي لا يضر مع اسمه شيء في الأرض ولا في السماء وهو السميع العليم.",
                    if (buttonsNumbers.isEmpty()) 3 else buttonsNumbers[8],
                    "لم يضره شيء.",
                    "عن عثمان بن عفان رضي الله عنه قال: قال رسول الله صلى الله عليه وسلم: (ما من عبد يقول في صباح كل يوم ومساء كل ليلة: بسم الله الذي لا يضر مع اسمه شيء في الأرض ولا في السماء وهو السميع العليم ثلاث مرات فيضره شيء) : رواه الِإمام أحمد والترمذي وابن ماجه، وقال الترمذي: حديث صحيح وهو كما قال رحمه الله."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "رضيت بالله رباً وبالِإسلام ديناَ وبمحمد صلى الله عليه وسلم نبياً.",
                    if (buttonsNumbers.isEmpty()) 3 else buttonsNumbers[9],
                    "كان حقاً على الله أن يرضيه يوم القيامة.",
                    "عن ثوبان خادم النبي صلى الله عليه وسلم، أن رسول الله صلى الله عليه وسلم قال: (ما من عبد مسلم يقول حين يصبح وحينِ يمسي ثلاث مرات رضيت بالله رباً وبالِإسلام ديناَ وبمحمد صلى الله عليه وسلم نبياً، إلا كان حقاً على الله أن يرضيه يوم القيامة) رواه الِإمام أحمد وأبو داود وابن ماجه بإسناد حسن، وهذا لفظ أحمد."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "اللهم ما أصبح بين نعمة أو بأحد من خلقك فمنك وحدك لا شريك لك فلك الحمد ولك الشكر.",
                    if (buttonsNumbers.isEmpty()) 1 else buttonsNumbers[10],
                    "يؤدي شكر يومه.",
                    "عن عبد الله بن غنام رضي الله عنه أن رسول الله صلى الله عليه وسلم قال: (من قال حين يصبح: اللهم ما أصبح بين نعمة أو بأحد من خلقك فمنك وحدك لا شريك لك فلك الحمد ولك الشكر فقد أدى شكر يومه، ومن قال ذلك حين يمسي فقد أدى شكر ليلته) رواه أبو داود والنسائي في عمل اليوم والليلة بإسناد حسن."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "اللهم إني أصبحت أشهدك وأشهد حملة عرشك، وملائكتك وجميع خلقك بأنك أنت الله لا إله إلا أنت وحدك لا شريك لك، وأن محمداً عبدك ورسولك.",
                    if (buttonsNumbers.isEmpty()) 4 else buttonsNumbers[11],
                    "يعتقه الله من النار.",
                    "عن أنس بن مالك رضي الله عنه أن النبي صلى الله عليه وسلم قال: (من قال حين يصبح أو يمسي: اللهم إني أصبحت أشهدك وأشهد حملة عرشك، وملائكتك وجميع خلقك بأنك أنت الله لا إله إلا أنت وحدك لا شريك لك، وأن محمداً عبدك ورسولك أعتق الله ربعه من النار. ومن قالها مرتين أعتق الله نصفه من النار. ومن قالها ثلاثا أعتق الله ثلاثة أرباعه من النار، فإن قالها أربعا أعتقه الله من النار) رواه أبو داود بإسناد حسن."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "اللهم إني أسألك العافية في الدنيا والآخرة، اللهم إني أسألك العفو والعافية في ديني ودنياي وأهلي ومالي، اللهم استر عوراتي وآمن روعاتي، اللهم احفظني من بين يدي ومن خلفي وعن يميني وعن شمالي ومن فوقى، وأعوذ بعظمتك أن اغتال من تحتي.",
                    if (buttonsNumbers.isEmpty()) 1 else buttonsNumbers[12],
                    "",
                    "عن  عبد الله بن عمر رضي الله عنهما قال: لم يكن النبي صلى الله عليه وسلم يدع هؤلاء الدعوات حين يمسي وحين يصبح. (اللهم إني أسألك العافية في الدنيا والآخرة، اللهم إني أسألك العفو والعافية في ديني ودنياي وأهلي ومالي، اللهم استر عوراتي وآمن روعاتي، اللهم احفظني من بين يدي ومن خلفي وعن يميني وعن شمالي ومن فوقى، وأعوذ بعظمتك أن اغتال من تحتي) أخرجه الِإمام أحمد في المسند، وأبو داود والنسائي وابن ماجه وصححه الحاكم."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "لا إله إلا الله وحده لا شريك له، له الملك وله الحمد، وهو على كل شيءٍ قدير.",
                    if (buttonsNumbers.isEmpty()) 10 else buttonsNumbers[13],
                    "كتب الله له مائة حسنة، ومحا عنه مائة سيئة، وكانت له عدل رقبة.",
                    "عن أبي هريرة رضي الله عنه قال: قال رسول الله صلى الله عليه وسلم: (من قال: لا إله إلا الله وحده لا شريك له، له الملك وله الحمد وهو على كل شيء قدير، من قالها عشر مرات حين يصبح كتب الله له مائة حسنة، ومحا عنه مائة سيئة، وكانت له عدل رقبة، وحفظ بها يومئذ حتى يمسي. ومن قالها مثل ذلك حين يمسي كان له مثل ذلك) رواه الِإمام أحمد في مسنده بإسناد حسن."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "أصبحنا على فطرة الِإسلام وعلى كلمة الِإخلاص وعلى دين نبينا محمد صلى الله عليه وسلم وعلى ملة أبينا إبراهيم حنيفا مسلماً وما كان من المشركين.",
                    if (buttonsNumbers.isEmpty()) 1 else buttonsNumbers[14],
                    "",
                    "عن عبد الله بن عبد الرحمن بن أبيه عن أبيه رضي الله عنه أن النبي صلى الله عليه وسلم كان يقول إذا أصبح وإذا أمسى (أصبحنا على فطرة الِإسلام وعلى كلمة الِإخلاص وعلى دين نبينا محمد صلى الله عليه وسلم وعلى ملة أبينا إبراهيم حنيفا مسلماً وما كان من المشركين) رواه الِإمام أحمد في مسنده بإسناد صحيح."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "اللهم عافني في بدني، اللهم عافني في سمعي، اللهم عافني فيِ بصري لا إله إلا أنت اللهم إني أعوذ بك من الكفر والفقر وأعوذ بك من عذاب القبر لا إله إلا أنت.",
                    if (buttonsNumbers.isEmpty()) 3 else buttonsNumbers[15],
                    "",
                    "عن عبد الرحمن بن أبي بكرة أنه قال لأبيه: يا أبتِ إني أسمعك تدعو كل غداة اللهم عافني في بدني، اللهم عافني في سمعي، اللهم عافني فيِ بصري لا إله إلا أنت  تعيدها ثلاثا حين تصبح وثلاثا حين تمسي، وتقول: اللهم إني أعوذ بك من الكفر والفقر وأعوذ بك من عذاب القبر لا إله إلا أنت، تعيدها حين تصبح ثلاثاً وحين تمسي ثلاثاً، قال: ( نعم يا بني إني سمعت النبي صلى الله عليه وسلم يدعو بهن فأحب أن أستن بسنته) رواه الإمام أحمد والبخاري في الأدب المفرد وأبو داود والنسائي بإسناد حسن."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "لا إله إلا الله وحده لا شريك له، له الملك وله الحمد، وهو على كل شيءٍ قدير.",
                    if (buttonsNumbers.isEmpty()) 100 else buttonsNumbers[16],
                    "كتبت له مائة حسنة ومحيت عنه مائة سيئة، وكانت له حرزاً من الشيطان يومه ذلك حتى يمسي ولم يأت أحد بأفضل مما جاء به إلا رجل عمل أكثر من ذلك.",
                    "عن أبي هريرة رضي الله عنه قال قال النبي صلى الله عليه وسلم (من قال: لا إله إلا الله وحده لا شريك له، له الملك وله الحمد وهو على كل شيء قدير في يوم مائة مرة كانت له عدل عشر رقاب، كتبت له مائة حسنة ومحيت عنه مائة سيئة، وكانت له حرزاً من الشيطان يومه ذلك حتى يمسي ولم يأت أحد بأفضل مما جاء به إلا رجل عمل أكثر من ذلك) رواه البخاري ومسلم."
                )
            )
        } else if (!intent.getStringExtra("btnName")!!
                .equals(null) && intent.getStringExtra("btnName")
                .equals(getString(R.string.masaa))
        ) {

            tv_toolbar.setText(getString(R.string.masaa))

            azkarList.clear()

            azkarList.add(
                Theker(
                    "",
                    "سبحان الله وبحمده.",
                    if (buttonsNumbers.isEmpty()) 100 else buttonsNumbers[0],
                    " حطت خطاياه وإن كانت مثل زبد البحر و لم يأت أحد يوم القيامة بأفضل مما جاء به إلا أحد قال مثل ما قال أو زاد عليه.",
                    "عن أبي هريرة رضي الله عنه عن النبي صلى الله عليه وسلم قال (من قال حين يصبح وحين يمسي: سبحان الله وبحمده مائة مرة لم يأت أحد يوم القيامة بأفضل مما جاء به إلا أحد قال مثل ما قال أو زاد عليه) رواه مسلم."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "أمسينا وأمسى الملك لله، والحمد لله، لا إله إلا الله وحده لا شريك له، له الملك وله الحمد وهو على كل شيء قدير، رب أسألك خير ما في هذه الليلة، وخير ما بعدها، وأعوذ بك من شر ما في هذه الليلة وشر ما بعدها، رب أعوذ بك من الكسل وسوء الكبر، رب أعوذ بك من عذاب في النار، وعذاب في القبر.",
                    if (buttonsNumbers.isEmpty()) 1 else buttonsNumbers[1],
                    "",
                    "عن عبد الله بن مسعود رضي الله عنه قال: كان نبي الله صلى الله عليه وسلم إذا أمسى قال: (أمسينا وأمسى الملك لله، والحمد لله، لا إله إلا الله وحده لا شريك له، له الملك وله الحمد وهو على كل شيء قدير، رب أسألك خير ما في هذه الليلة، وخير ما بعدها، وأعوذ بك من شر ما في هذه الليلة وشر ما بعدها، رب أعوذ بك من الكسل وسوء الكبر، رب أعوذ بك من عذاب في النار، وعذاب في القبر) وإذا أصبح قال ذلك أيضاً أصبحنا وأصبح الملك لله رواه مسلم."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "اللهم أنت ربي، لا إله إلا أنت، خلقتني وأنا عبدك، وأنا على عهدك ووعدك ما استطعت، أعوذ بك من شر ما صنعت، أبوء لك بنعمتك عليَّ، وأبوء لك بذنبي، فاغفر لي فإنه لا يغفر الذنوب إلا أنت.",
                    if (buttonsNumbers.isEmpty()) 1 else buttonsNumbers[2],
                    "من قالها من النهار موقناً بها فمات من يومه قبل أن يمسي فهو من أهل الجنة، ومن قالها من الليل وهو موقن بها فمات قبل أن يصبح فهو من أهل الجنة.",
                    "بن أوس رضي الله عنه عن النبي صلى الله عليه وسلم قال: (سيد الاستغفار: اللهم أنت ربي، لا إله إلا أنت، خلقتني وأنا عبدك، وأنا على عهدك ووعدك ما استطعت، أعوذ بك من شر ما صنعت، أبوء لك بنعمتك عليَّ، وأبوء لك بذنبي، فاغفر لي فإنه لا يغفر الذنوب إلا أنت. قال: ومن قالها من النهار موقناً بها فمات من يومه قبل أن يمسي فهو من أهل الجنة، ومن قالها من الليل وهو موقن بها فمات قبل أن يصبح فهو من أهل الجنة) رواه البخاري."
                )
            )

            azkarList.add(
                Theker(
                    getString(R.string.basmallah),
                    "قل هو الله أحد الله الصمد لم يولد ولم يولد ولم يكن له كفواً أحد.",
                    if (buttonsNumbers.isEmpty()) 3 else buttonsNumbers[3],
                    "من قالها حين يصبح وحين يمسي كفته من كل شيء(الإخلاص والمعوذتين).",
                    "عن عبد الله بن حبيب قال: خرجنا في ليلة مطر وظلمة شديدة نطلب النبي صلى الله عليه وسلم ليصلي لنا فأدركناه فقال: (قل) فلم أقل شيئاً، ثم قال: (قل) فلم أقل شيئاً، تم قال: (قل): فقلت: يا رسول الله ما أقول، قال:( قل: قل هو الله أحد والمعوذتين حين تمسي وحين تصبح ثلاث مرات تكفيك من كل شيء)."
                )
            )

            azkarList.add(
                Theker(
                    getString(R.string.basmallah),
                    "قل أعوذ برب الفلق من شر ما خلق ومن شر غاسق إذا وقب ومن شر النفاثات في العقد ومن شر حاسد إذا حسد.",
                    if (buttonsNumbers.isEmpty()) 3 else buttonsNumbers[4]
                )
            )

            azkarList.add(
                Theker(
                    getString(R.string.basmallah),
                    "قل أعوذ برب الناس ملك الناس إله الناس  من شر الوسواس الخناس  الذي يوسوس في صدور الناس من الجنة والناس.",
                    if (buttonsNumbers.isEmpty()) 3 else buttonsNumbers[5]
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "اللهم بك أمسينا وبك أصبحنا وبك نحيا وبك نموت وإليك المصير.",
                    if (buttonsNumbers.isEmpty()) 1 else buttonsNumbers[6],
                    "",
                    "عن أبي هريرة رضي الله عنه عن النبي صلى الله عليه وسلم أنه كان يعلم أصحابه يقول: (إذا أصبح أحدكم فليقل: اللهم بك أصبحنا وبك أمسينا وبك نحيا وبك نموت وإليك النشور، وإذا أمسى فليقل اللهم بك أمسينا وبك أصبحنا وبك نحيا وبك نموت وإليك المصير) رواه أبو داود والترمذي والنسائي وابن ماجه، واسناده عند أبي داود وابن ماجه صحيح."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "اللهم فاطر السموات والأرض، عالم الغيب والشهادة رب كل شيء ومليكه أشهد أن لا إله إلا أنت، أعوذ بك من شرِ نفسي وشر الشيطان وشركه وأن أقترف على نفسي سوءاً أو أجره إلى مسلم.",
                    if (buttonsNumbers.isEmpty()) 1 else buttonsNumbers[7],
                    "",
                    "عن أبي هريرة رضي الله عنه، أن أبا بكر الصديق رضي الله عنه قال: «يا رسول الله، مرنى بكلمات أقولهن إذا أصبحت وإذا أمسيت قال:( قل: اللهم فاطر السموات والأرض، عالم الغيب والشهادة رب كل شيء ومليكه أشهد أن لا إله إلا أنت، أعوذ بك من شرِ نفسي وشر الشيطان وشركه وأن أقترف على نفسي سوءا أو أجره إلى مسلم). قال:( قُلها إذا أصبحت وإذا أمسيت وإذا أخذت مضجعك) رواه الِإمام أحمد وأبو داود والترمذي والنسائي والبخاري في الأدب المفرد بإسناد صحيح."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "بسم الله الذي لا يضر مع اسمه شيء في الأرض ولا في السماء وهو السميع العليم.",
                    if (buttonsNumbers.isEmpty()) 3 else buttonsNumbers[8],
                    "لم يضره شيء.",
                    "عن عثمان بن عفان رضي الله عنه قال: قال رسول الله صلى الله عليه وسلم: (ما من عبد يقول في صباح كل يوم ومساء كل ليلة: بسم الله الذي لا يضر مع اسمه شيء في الأرض ولا في السماء وهو السميع العليم ثلاث مرات فيضره شيء) : رواه الِإمام أحمد والترمذي وابن ماجه، وقال الترمذي: حديث صحيح وهو كما قال رحمه الله."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "رضيت بالله رباً وبالِإسلام ديناَ وبمحمد صلى الله عليه وسلم نبياً.",
                    if (buttonsNumbers.isEmpty()) 3 else buttonsNumbers[9],
                    "كان حقاً على الله أن يرضيه يوم القيامة",
                    "عن ثوبان خادم النبي صلى الله عليه وسلم، أن رسول الله صلى الله عليه وسلم قال: (ما من عبد مسلم يقول حين يصبح وحينِ يمسي ثلاث مرات رضيت بالله رباً وبالِإسلام ديناَ وبمحمد صلى الله عليه وسلم نبياً، إلا كان حقاً على الله أن يرضيه يوم القيامة) رواه الِإمام أحمد وأبو داود وابن ماجه بإسناد حسن، وهذا لفظ أحمد."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "اللهم إني أمسيت أشهدك وأشهد حملة عرشك، وملائكتك وجميع خلقك بأنك أنت الله لا إله إلا أنت وحدك لا شريك لك، وأن محمداً عبدك ورسولك.",
                    if (buttonsNumbers.isEmpty()) 4 else buttonsNumbers[10],
                    "يعتقه الله من النار",
                    "عن أنس بن مالك رضي الله عنه أن النبي صلى الله عليه وسلم قال: (من قال حين يصبح أو يمسي: اللهم إني أصبحت أشهدك وأشهد حملة عرشك، وملائكتك وجميع خلقك بأنك أنت الله لا إله إلا أنت وحدك لا شريك لك، وأن محمداً عبدك ورسولك أعتق الله ربعه من النار. ومن قالها مرتين أعتق الله نصفه من النار. ومن قالها ثلاثا أعتق الله ثلاثة أرباعه من النار، فإن قالها أربعا أعتقه الله من النار) رواه أبو داود بإسناد حسن."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "اللهم ما أمسى بين نعمة أو بأحد من خلقك فمنك وحدك لا شريك لك فلك الحمد ولك الشكر.",
                    if (buttonsNumbers.isEmpty()) 1 else buttonsNumbers[11],
                    "يؤدي شكر ليلته.",
                    "عن عبد الله بن غنام رضي الله عنه أن رسول الله صلى الله عليه وسلم قال: (من قال حين يصبح: اللهم ما أصبح بين نعمة أو بأحد من خلقك فمنك وحدك لا شريك لك فلك الحمد ولك الشكر فقد أدى شكر يومه، ومن قال ذلك حين يمسي فقد أدى شكر ليلته) رواه أبو داود والنسائي في عمل اليوم والليلة بإسناد حسن."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "اللهم إني أسألك العافية في الدنيا والآخرة، اللهم إني أسألك العفو والعافية في ديني ودنياي وأهلي ومالي، اللهم استر عوراتي وآمن روعاتي، اللهم احفظني من بين يدي ومن خلفي وعن يميني وعن شمالي ومن فوقى، وأعوذ بعظمتك أن اغتال من تحتي.",
                    if (buttonsNumbers.isEmpty()) 1 else buttonsNumbers[12],
                    "",
                    "عن  عبد الله بن عمر رضي الله عنهما قال: لم يكن النبي صلى الله عليه وسلم يدع هؤلاء الدعوات حين يمسي وحين يصبح. (اللهم إني أسألك العافية في الدنيا والآخرة، اللهم إني أسألك العفو والعافية في ديني ودنياي وأهلي ومالي، اللهم استر عوراتي وآمن روعاتي، اللهم احفظني من بين يدي ومن خلفي وعن يميني وعن شمالي ومن فوقى، وأعوذ بعظمتك أن اغتال من تحتي) أخرجه الِإمام أحمد في المسند، وأبو داود والنسائي وابن ماجه وصححه الحاكم."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "لا إله إلا الله وحده لا شريك له، له الملك وله الحمد، وهو على كل شيءٍ قدير.",
                    if (buttonsNumbers.isEmpty()) 10 else buttonsNumbers[13],
                    ": كتب الله له مائة حسنة، ومحا عنه مائة سيئة، وكانت له عدل رقبة",
                    "عن أبي هريرة رضي الله عنه قال: قال رسول الله صلى الله عليه وسلم: (من قال: لا إله إلا الله وحده لا شريك له، له الملك وله الحمد وهو على كل شيء قدير، من قالها عشر مرات حين يصبح كتب الله له مائة حسنة، ومحا عنه مائة سيئة، وكانت له عدل رقبة، وحفظ بها يومئذ حتى يمسي. ومن قالها مثل ذلك حين يمسي كان له مثل ذلك) رواه الِإمام أحمد في مسنده بإسناد حسن."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "أمسينا على فطرة الِإسلام وعلى كلمة الِإخلاص وعلى دين نبينا محمد صلى الله عليه وسلم وعلى ملة أبينا إبراهيم حنيفا مسلماً وما كان من المشركين.",
                    if (buttonsNumbers.isEmpty()) 1 else buttonsNumbers[14],
                    "",
                    "عن عبد الله بن عبد الرحمن بن أبيه عن أبيه رضي الله عنه أن النبي صلى الله عليه وسلم كان يقول إذا أصبح وإذا أمسى (أصبحنا على فطرة الِإسلام وعلى كلمة الِإخلاص وعلى دين نبينا محمد صلى الله عليه وسلم وعلى ملة أبينا إبراهيم حنيفا مسلماً وما كان من المشركين) رواه الِإمام أحمد في مسنده بإسناد صحيح."
                )
            )


            azkarList.add(
                Theker(
                    "",
                    "اللهم عافني في بدني، اللهم عافني في سمعي، اللهم عافني فيِ بصري لا إله إلا أنت اللهم إني أعوذ بك من الكفر والفقر وأعوذ بك من عذاب القبر لا إله إلا أنت.",
                    if (buttonsNumbers.isEmpty()) 3 else buttonsNumbers[15],
                    ": لم تضره حمة تلك الليلة، والحمة سم ذوات السموم كالعقرب والحية ونحوهما.",
                    "عن عبد الرحمن بن أبي بكرة أنه قال لأبيه: يا أبتِ إني أسمعك تدعو كل غداة اللهم عافني في بدني، اللهم عافني في سمعي، اللهم عافني فيِ بصري لا إله إلا أنت  تعيدها ثلاثا حين تصبح وثلاثا حين تمسي، وتقول: اللهم إني أعوذ بك من الكفر والفقر وأعوذ بك من عذاب القبر لا إله إلا أنت، تعيدها حين تصبح ثلاثاً وحين تمسي ثلاثاً، قال: ( نعم يا بني إني سمعت النبي صلى الله عليه وسلم يدعو بهن فأحب أن أستن بسنته) رواه الإمام أحمد والبخاري في الأدب المفرد وأبو داود والنسائي بإسناد حسن."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "أعوذ بكلمات الله التامات من شر ما خلق.",
                    if (buttonsNumbers.isEmpty()) 3 else buttonsNumbers[16],
                    "",
                    "عن أبي هريرة رضي الله عنه قال: قال النبي صلى الله عليه وسلم: (من قال إذا أمسى ثلاث مرات: أعوذ بكلمات الله التامات من شر ما خلق، لم تضره حمة تلك الليلة) رواه الِإمام أحمد والترمذي بإسناد حسن."
                )
            )

        } else if (!intent.getStringExtra("btnName")!!
                .equals(null) && intent.getStringExtra("btnName")
                .equals(getString(R.string.naoom))
        ) {
            tv_toolbar.setText(getString(R.string.naoom))

            azkarList.clear()

            azkarList.add(
                Theker(
                    "",
                    "اللهم باسمك أموت وأحيا.",
                    if (buttonsNumbers.isEmpty()) 1 else buttonsNumbers[0],
                    "",
                    ": عن حذيفة رضي الله عنه قال: كان رسول الله صلى الله عليه وسلم إذا أخذ مضجعه من الليل وضع يده تحت خده ثم يقول: (اللهم باسمك أموت وأحيا) رواه البخاري."
                )
            )

            azkarList.add(
                Theker(
                    getString(R.string.basmallah),
                    "آمن الرسول بما أنزل إليه من ربه والمؤمنون كل آمن بالله وملائكته وكتبه ورسله لا نفرق بين أحد من رسله وقالوا سمعنا وأطعنا غفرانك ربنا وإليك المصير  لا يكلف الله نفسا إلا وسعها لها ما كسبت وعليها ما اكتسبت ربنا لا تؤاخذنا إن نسينا أو أخطأنا ربنا ولا تحمل علينا إصرا كما حملته على الذين من قبلنا ربنا ولا تحملنا ما لا طاقة لنا به واعف عنا واغفر لنا وارحمنا أنت مولانا فانصرنا على القوم الكافرين.",
                    if (buttonsNumbers.isEmpty()) 1 else buttonsNumbers[1],
                    "كفتاه أي: كفتاه من قيام الليل أو كفتاه من الشيطان أو كفتاه كلَ سوء، قال النووي -رحمه الله- (ويحتمل أن يراد الجميع).",
                    "عن أبي مسعود الأنصاري رضي الله عنه عن النبي صلى الله عليه وسلم قال: (من قرأ الآيتين من آخر سورة البقرة في ليلة كفتاه) رواه البخاري، ومسلم."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "اللهم أسلمت نفسي إليك ووجهت وجهي إليك، وفوضت أمري إليك، وألجأت ظهري إليك رغبة ورهبة إليك، لا ملجأ ولا منجى منك إلا إليك، آمنت بكتابك الذي أنزلت، ونبيك الذي أرسلت.",
                    if (buttonsNumbers.isEmpty()) 1 else buttonsNumbers[2],
                    "إن مات يموت على الفطرة أي على دين الإسلام وسنة خير الأنام.",
                    "عن البراء بن عازب رضي الله عنه قال: قال رسول الله صلى الله عليه وسلم: (إذا أتيت مضجعك فتوضأ وضوءك للصلاة ثم اضطجع على شقك الأيمن وقل: اللهم أسلمت نفسي إليك ووجهت وجهي إليك، وفوضت أمري إليك، وألجأت ظهري إليك رغبة ورهبة إليك، لا ملجأ ولا منجى منك إلا إليك، آمنت بكتابك الذي أنزلت، ونبيك الذي أرسلت، فإن متَ من ليلتك متَ على الفطرة واجعلهن آخر ما تقول)  رواه البخاري و مسلم."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "اللهم رب السموات، ورب الأرض، ورب العرش العظيم، ربنا ورب كل شيء، فالق الحب والنوى، ومنزل التوراة والإنجيل والفرقان، أعوذ بك من شر كل شيء أنت آخذ بناصيته، اللهم أنت الأول فليس قبلك شيء، وأنت الآخر فليس بعدك شيء، وأنت الظاهر فليس فوقك شيء، وأنت الباطن فليس دونك شيء، اقض عنا الدين، واغننا من الفقر.",
                    if (buttonsNumbers.isEmpty()) 1 else buttonsNumbers[3],
                    "",
                    " عن أبي هريرة صلى الله عليه وسلم الله عنه عن النبي صلى الله عليه وسلم أنه كان يقول إذا أوى إلى فراشه: (اللهم رب السموات، ورب الأرض، ورب العرش العظيم، ربنا ورب كل شيء، فالق الحب والنوى، ومنزل التوراة والإنجيل والفرقان، أعوذ بك من شر كل شيء أنت آخذ بناصيته، اللهم أنت الأول فليس قبلك شيء، وأنت الآخر فليس بعدك شيء، وأنت الظاهر فليس فوقك شيء، وأنت الباطن فليس دونك شيء، اقض عنا الدين، واغننا من الفقر) رواه مسلم."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "اللهم قني عذابك يوم تبعث عبادك.",
                    if (buttonsNumbers.isEmpty()) 3 else buttonsNumbers[4],
                    "",
                    "عن حفصة أم المؤمنين رضي الله عنها «أن النبي صلى الله عليه وسلم كان إذا أراد أن يرقد وضع يده اليمنى تحت خده الأيمن ثم يقول: ( اللهم قني عذابك يوم تبعث عبادك) ثلاث مرات رواه الإمام أحمد وأبو داود بإسناد حسن."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "الحمد لله الذي أطعمنا وسقانا، وكفانا، وأوانا، فكم ممن لا كافي له، ولا مؤوي.",
                    if (buttonsNumbers.isEmpty()) 1 else buttonsNumbers[5],
                    "",
                    "عن أنس رضي الله عنه «أن النبي صلى الله عليه وسلم كان إذا أوى إلى فراشه قال: (الحمد لله الذي أًطعمنا وسقانا، وكفانا، وأوانا، فكم ممن لا كافي له، ولا مؤوي) أخرجه مسلم."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "اللهم خلقتَ نفسي وأنت تتوفاها، لك مماتها ومحياها، إن أحييتها فاحفظها، وإن أمتها فاغفر لها، اللهم إني أسألك العافية.",
                    if (buttonsNumbers.isEmpty()) 1 else buttonsNumbers[6],
                    "",
                    ": عن ابن عمر رضي الله عنهما أنه أمر رجلاً إذا أخذ مضجعه أن يقول: (اللهم خلقت نفسي وأنت تتوفاها، لك مماتها ومحياها، إن أحييتها فاحفظها، وإن أمتها فاغفر لها، اللهم إني أسألك العافية). قال ابن عمر: سمعته من رسول الله صلى الله عليه وسلم  أخرجه مسلم."
                )
            )

            azkarList.add(
                Theker(
                    "",
                    "سبحان الله (33 مرة)، والحمد لله (33 مرة)، والله أكبر (34 مرة).",
                    if (buttonsNumbers.isEmpty()) 33 else buttonsNumbers[7],
                    "",
                    "عن علي رضي الله عنه أن فاطمة رضي الله عنها أتت النبي صلى الله عليه وسلم تسأله خادماً فلم تجده، ووجدت عائشة رضي الله عنها فأخبرتها. قال علي: فجاءنا النبي صلى الله عليه وسلم وقد أخذنا مضاجعنا فقال: ( ألا أدلكما على ما هو خير لكما من خادم، إذا أويتما إلى فراشكما فسبحا ثلاثا وثلاثين، واحمدا ثلاثاً وثلاثين، وكبرا أربعاً وثلاثين، فإنه خير لكما من خادم) . قال علي: فما تركتهن منذ سمعتهن من رسول الله صلى الله عليه وسلم رواه البخاري ومسلم."
                )
            )

            azkarList.add(
                Theker(
                    "ذكر لمن استيقظ من الليل",
                    "لا إله إلا الله وحده لا شريك له، له الملك، وله الحمد وهو على كل شيء قدير، الحمد لله وسبحان الله، ولا إله إلا الله، والله أكبر، ولا حول ولا قوة إلا بالله.",
                    if (buttonsNumbers.isEmpty()) 1 else buttonsNumbers[8],
                    " إن قال بعدها اللهم أغفر لي  أو دعا استجيب له، فإن توضأ وصلى قبلت صلاته",
                    "عن عبادة بن الصامت رضي الله عنه عن النبي صلى الله عليه وسلم قال: (من تعارَّ من الليل فقال: لا إله إلا الله وحده لا شريك له، له الملك، وله الحمد وهو على كل شيء قدير، الحمد لله وسبحان الله، ولا إله إلا الله، والله أكبر، ولا حول ولا قوة إلا بالله، ثم قال: اللهم اغفر لي أو دعا استجيب له، فإن توضأ وصلى قبلت صلاته) رواه البخاري."
                )
            )

        } else {

        }

        recyclerView.adapter = ThekerAdapter(this, azkarList)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        buttonsNumbers.clear()

        azkarList.forEach {
            buttonsNumbers.add(it.buttonNumber)
        }

        outState.putIntegerArrayList("buttonNumbers", buttonsNumbers)
        Log.d(TAG, "onSaveInstanceState called, with buttonNumbers= $buttonsNumbers")
    }
}