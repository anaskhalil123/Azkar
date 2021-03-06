package com.a.khalil.azkarapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Layout
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import com.a.khalil.azkarapplication.DB.DB
import com.a.khalil.azkarapplication.databinding.ActivityMainBinding
import com.a.khalil.azkarapplication.model.Classification
import com.a.khalil.azkarapplication.model.Theker
import java.lang.reflect.Type
import java.util.*

class MainActivity : AppCompatActivity() {

    var btnName: String? = null
    private val TAG = "MainActivity"
    lateinit var database: DB
    lateinit var binding: ActivityMainBinding

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = DB(this)

        /*************************************************/
        if (database.getTheker(1) == null) {
            database.insertTheker(
                Theker(
                    1,
                    "",
                    getString(R.string.tasbehAndHamd),
                    100,
                    " حطت خطاياه وإن كانت مثل زبد البحر و لم يأت أحد يوم القيامة بأفضل مما جاء به إلا أحد قال مثل ما قال أو زاد عليه.",
                    "عن أبي هريرة رضي الله عنه عن النبي صلى الله عليه وسلم قال (من قال حين يصبح وحين يمسي: سبحان الله وبحمده مائة مرة لم يأت أحد يوم القيامة بأفضل مما جاء به إلا أحد قال مثل ما قال أو زاد عليه) رواه مسلم."
                )
            )

            database.insertThekerToClass(1, 1, 100)
            database.insertThekerToClass(1, 2, 100)

            database.insertTheker(
                Theker(
                    2,
                    "",
                    "أصبحنا وأصبح الملك لله، والحمد لله، لا إله إلا الله وحده لا شريك له، له الملك وله الحمد وهو على كل شيء قدير، رب أسألك خير ما في هذا اليوم، وخير ما بعده، وأعوذ بك من شر ما في هذا اليوم وشر ما بعده، رب أعوذ بك من الكسل وسوء الكبر، رب أعوذ بك من عذاب في النار، وعذاب في القبر.",
                    1,
                    "",
                    "عن عبد الله بن مسعود رضي الله عنه قال: " +
                            "كان نبي الله صلى الله عليه وسلم إذا أمسى قال: (أمسينا وأمسى الملك لله، والحمد لله، لا إله إلا الله وحده لا شريك له، له الملك وله الحمد وهو على كل شيء قدير، رب أسألك خير ما في هذه الليلة، وخير ما بعدها، وأعوذ بك من شر ما في هذه الليلة وشر ما بعدها، رب أعوذ بك من الكسل وسوء الكبر، رب أعوذ بك من عذاب في النار، وعذاب في القبر) وإذا أصبح قال ذلك أيضاً أصبحنا وأصبح الملك لله رواه مسلم.\n"
                )
            )

            database.insertThekerToClass(2, 1, 1)

            database.insertTheker(
                Theker(
                    3,
                    "",
                    getString(R.string.saeedAstkvar),
                    1,
                    "من قالها من النهار موقناً بها فمات من يومه قبل أن يمسي فهو من أهل الجنة، ومن قالها من الليل وهو موقن بها فمات قبل أن يصبح فهو من أهل الجنة.",
                    "عن شداد بن أوس رضي الله عنه عن النبي صلى الله عليه وسلم قال: (سيد الاستغفار: اللهم أنت ربي، لا إله إلا أنت، خلقتني وأنا عبدك، وأنا على عهدك ووعدك ما استطعت، أعوذ بك من شر ما صنعت، أبوء لك بنعمتك عليَّ، وأبوء لك بذنبي، فاغفر لي فإنه لا يغفر الذنوب إلا أنت. قال: ومن قالها من النهار موقناً بها فمات من يومه قبل أن يمسي فهو من أهل الجنة، ومن قالها من الليل وهو موقن بها فمات قبل أن يصبح فهو من أهل الجنة) رواه البخاري"
                )
            )
            database.insertThekerToClass(3, 1, 1)
            database.insertThekerToClass(3, 2, 1)

            database.insertTheker(
                Theker(
                    4,
                    getString(R.string.basmallah),
                    "قُلْ هُوَ اللَّهُ أَحَدٌ، اللَّهُ الصَّمَدُ، لَمْ يَلِدْ وَلَمْ يُولَدْ، وَلَمْ يَكُن لَّهُ كُفُوًا أَحَدٌ .",
                    3,
                    "من قالها حين يصبح وحين يمسي كفته من كل شيء(الإخلاص والمعوذتين).",
                    "عن عبد الله بن حبيب قال: خرجنا في ليلة مطر وظلمة شديدة نطلب النبي صلى الله عليه وسلم ليصلي لنا فأدركناه فقال: (قل) فلم أقل شيئاً، ثم قال: (قل) فلم أقل شيئاً، تم قال: (قل): فقلت: يا رسول الله ما أقول، قال:( قل: قل هو الله أحد والمعوذتين حين تمسي وحين تصبح ثلاث مرات تكفيك من كل شيء) رواه أبو داود، والترمذي، والنسائي بإسناد حسن."
                )
            )

            database.insertThekerToClass(4, 1, 3)
            database.insertThekerToClass(4, 2, 3)

            database.insertTheker(
                Theker(
                    5,
                    getString(R.string.basmallah),
                    "قُلْ أَعُوذُ بِرَبِّ الْفَلَقِ،  مِن شَرِّ مَا خَلَقَ،  وَمِن شَرِّ غَاسِقٍ إِذَا وَقَبَ،  وَمِن شَرِّ النَّفَّاثَاتِ فِي الْعُقَدِ،  وَمِن شَرِّ حَاسِدٍ إِذَا حَسَدَ .",
                    3,
                    "من قالها حين يصبح وحين يمسي كفته من كل شيء(الإخلاص والمعوذتين).",
                    "عن عبد الله بن حبيب قال: خرجنا في ليلة مطر وظلمة شديدة نطلب النبي صلى الله عليه وسلم ليصلي لنا فأدركناه فقال: (قل) فلم أقل شيئاً، ثم قال: (قل) فلم أقل شيئاً، تم قال: (قل): فقلت: يا رسول الله ما أقول، قال:( قل: قل هو الله أحد والمعوذتين حين تمسي وحين تصبح ثلاث مرات تكفيك من كل شيء) رواه أبو داود، والترمذي، والنسائي بإسناد حسن."
                )
            )

            database.insertThekerToClass(5, 1, 3)
            database.insertThekerToClass(5, 2, 3)

            database.insertTheker(
                Theker(
                    6,
                    getString(R.string.basmallah),
                    "قُلْ أَعُوذُ بِرَبِّ النَّاسِ، مَلِكِ النَّاسِ،  إِلَٰهِ النَّاسِ،  مِن شَرِّ الْوَسْوَاسِ الْخَنَّاسِ،  الَّذِي يُوَسْوِسُ فِي صُدُورِ النَّاسِ،  مِنَ الْجِنَّةِ وَالنَّاسِ .",
                    3,
                    "من قالها حين يصبح وحين يمسي كفته من كل شيء(الإخلاص والمعوذتين).",
                    "عن عبد الله بن حبيب قال: خرجنا في ليلة مطر وظلمة شديدة نطلب النبي صلى الله عليه وسلم ليصلي لنا فأدركناه فقال: (قل) فلم أقل شيئاً، ثم قال: (قل) فلم أقل شيئاً، تم قال: (قل): فقلت: يا رسول الله ما أقول، قال:( قل: قل هو الله أحد والمعوذتين حين تمسي وحين تصبح ثلاث مرات تكفيك من كل شيء) رواه أبو داود، والترمذي، والنسائي بإسناد حسن."
                )
            )

            database.insertThekerToClass(6, 1, 3)
            database.insertThekerToClass(6, 2, 3)

            database.insertTheker(
                Theker(
                    7,
                    "",
                    "اللهم بك أصبحنا وبك أمسينا وبك نحيا وبك نموت وإليك النشور.",
                    1,
                    "",
                    "عن أبي هريرة رضي الله عنه عن النبي صلى الله عليه وسلم أنه كان يعلم أصحابه يقول: (إذا أصبح أحدكم فليقل: اللهم بك أصبحنا وبك أمسينا وبك نحيا وبك نموت وإليك النشور، وإذا أمسى فليقل اللهم بك أمسينا وبك أصبحنا وبك نحيا وبك نموت وإليك المصير) رواه أبو داود والترمذي والنسائي وابن ماجه، واسناده عند أبي داود وابن ماجه صحيح."
                )
            )

            database.insertThekerToClass(7, 1, 1)

            database.insertTheker(
                Theker(
                    8,
                    "",
                    getString(R.string.alhomeAlema),
                    1,
                    "",
                    "عن أبي هريرة رضي الله عنه، أن أبا بكر الصديق رضي الله عنه قال: «يا رسول الله، مرنى بكلمات أقولهن إذا أصبحت وإذا أمسيت قال:( قل: اللهم فاطر السموات والأرض، عالم الغيب والشهادة رب كل شيء ومليكه أشهد أن لا إله إلا أنت، أعوذ بك من شرِ نفسي وشر الشيطان وشركه وأن أقترف على نفسي سوءا أو أجره إلى مسلم). قال:( قلها إذا أصبحت وإذا أمسيت وإذا أخذت مضجعك)  رواه الِإمام أحمد وأبو داود والترمذي والنسائي والبخاري في الأدب المفرد بإسناد صحيح."
                )
            )

            database.insertThekerToClass(8, 1, 1)
            database.insertThekerToClass(8, 2, 1)

            database.insertTheker(
                Theker(
                    9,
                    "",
                    getString(R.string.besmallahAlthe),
                    3,
                    "لم يضره شيء.",
                    "عن عثمان بن عفان رضي الله عنه قال: قال رسول الله صلى الله عليه وسلم: (ما من عبد يقول في صباح كل يوم ومساء كل ليلة: بسم الله الذي لا يضر مع اسمه شيء في الأرض ولا في السماء وهو السميع العليم ثلاث مرات فيضره شيء) : رواه الِإمام أحمد والترمذي وابن ماجه، وقال الترمذي: حديث صحيح وهو كما قال رحمه الله."
                )
            )

            database.insertThekerToClass(9, 1, 3)
            database.insertThekerToClass(9, 2, 3)


            database.insertTheker(
                Theker(
                    10,
                    "",
                    getString(R.string.radeto),
                    3,
                    "كان حقاً على الله أن يرضيه يوم القيامة.",
                    "عن ثوبان خادم النبي صلى الله عليه وسلم، أن رسول الله صلى الله عليه وسلم قال: (ما من عبد مسلم يقول حين يصبح وحينِ يمسي ثلاث مرات رضيت بالله رباً وبالِإسلام ديناَ وبمحمد صلى الله عليه وسلم نبياً، إلا كان حقاً على الله أن يرضيه يوم القيامة) رواه الِإمام أحمد وأبو داود وابن ماجه بإسناد حسن، وهذا لفظ أحمد."
                )
            )

            database.insertThekerToClass(10, 1, 3)
            database.insertThekerToClass(10, 2, 3)

            database.insertTheker(
                Theker(
                    11,
                    "",
                    "اللهم ما أصبح بي من نعمة أو بأحد من خلقك فمنك وحدك لا شريك لك فلك الحمد ولك الشكر.",
                    1,
                    "يؤدي شكر يومه.",
                    "عن عبد الله بن غنام رضي الله عنه أن رسول الله صلى الله عليه وسلم قال: (من قال حين يصبح: اللهم ما أصبح بي من نعمة أو بأحد من خلقك فمنك وحدك لا شريك لك فلك الحمد ولك الشكر فقد أدى شكر يومه، ومن قال ذلك حين يمسي فقد أدى شكر ليلته) رواه أبو داود والنسائي في عمل اليوم والليلة بإسناد حسن."
                )
            )

            database.insertThekerToClass(11, 1, 1)

            database.insertTheker(
                Theker(
                    12,
                    "",
                    "اللهم إني أصبحت أشهدك وأشهد حملة عرشك، وملائكتك وجميع خلقك بأنك أنت الله لا إله إلا أنت وحدك لا شريك لك، وأن محمداً عبدك ورسولك.",
                    4,
                    "يعتقه الله من النار.",
                    "عن أنس بن مالك رضي الله عنه أن النبي صلى الله عليه وسلم قال: (من قال حين يصبح أو يمسي: اللهم إني أصبحت أشهدك وأشهد حملة عرشك، وملائكتك وجميع خلقك بأنك أنت الله لا إله إلا أنت وحدك لا شريك لك، وأن محمداً عبدك ورسولك أعتق الله ربعه من النار. ومن قالها مرتين أعتق الله نصفه من النار. ومن قالها ثلاثا أعتق الله ثلاثة أرباعه من النار، فإن قالها أربعا أعتقه الله من النار) رواه أبو داود بإسناد حسن."
                )
            )

            database.insertThekerToClass(12, 1, 4)


            database.insertTheker(
                Theker(
                    13,
                    "",
                    getString(R.string.alahmaAfeni),
                    1,
                    "",
                    "عن  عبد الله بن عمر رضي الله عنهما قال: لم يكن النبي صلى الله عليه وسلم يدع هؤلاء الدعوات حين يمسي وحين يصبح. (اللهم إني أسألك العافية في الدنيا والآخرة، اللهم إني أسألك العفو والعافية في ديني ودنياي وأهلي ومالي، اللهم استر عوراتي وآمن روعاتي، اللهم احفظني من بين يدي ومن خلفي وعن يميني وعن شمالي ومن فوقى، وأعوذ بعظمتك أن اغتال من تحتي) أخرجه الِإمام أحمد في المسند، وأبو داود والنسائي وابن ماجه وصححه الحاكم."
                )
            )
            database.insertThekerToClass(13, 1, 1)
            database.insertThekerToClass(13, 2, 1)


            database.insertTheker(
                Theker(
                    14,
                    "",
                    getString(R.string.kalema_twhed),
                    10,
                    "كتب الله له مائة حسنة، ومحا عنه مائة سيئة، وكانت له عدل رقبة.",
                    "عن أبي هريرة رضي الله عنه قال: قال رسول الله صلى الله عليه وسلم: (من قال: لا إله إلا الله وحده لا شريك له، له الملك وله الحمد وهو على كل شيء قدير، من قالها عشر مرات حين يصبح كتب الله له مائة حسنة، ومحا عنه مائة سيئة، وكانت له عدل رقبة، وحفظ بها يومئذ حتى يمسي. ومن قالها مثل ذلك حين يمسي كان له مثل ذلك) رواه الِإمام أحمد في مسنده بإسناد حسن."
                )
            )

            database.insertThekerToClass(14, 1, 10)
            database.insertThekerToClass(14, 2, 10)

            database.insertTheker(
                Theker(
                    15,
                    "",
                    "أصبحنا على فطرة الِإسلام وعلى كلمة الِإخلاص وعلى دين نبينا محمد صلى الله عليه وسلم وعلى ملة أبينا إبراهيم حنيفا مسلماً وما كان من المشركين.",
                    1,
                    "",
                    "عن عبد الله بن عبد الرحمن بن أبيه عن أبيه رضي الله عنه أن النبي صلى الله عليه وسلم كان يقول إذا أصبح وإذا أمسى (أصبحنا على فطرة الِإسلام وعلى كلمة الِإخلاص وعلى دين نبينا محمد صلى الله عليه وسلم وعلى ملة أبينا إبراهيم حنيفا مسلماً وما كان من المشركين) رواه الِإمام أحمد في مسنده بإسناد صحيح."
                )
            )

            database.insertThekerToClass(15, 1, 1)

            database.insertTheker(
                Theker(
                    16,
                    "",
                    getString(R.string.alhomaAfeni),
                    3,
                    "",
                    "عن عبد الرحمن بن أبي بكرة أنه قال لأبيه: يا أبتِ إني أسمعك تدعو كل غداة اللهم عافني في بدني، اللهم عافني في سمعي، اللهم عافني فيِ بصري لا إله إلا أنت  تعيدها ثلاثا حين تصبح وثلاثا حين تمسي، وتقول: اللهم إني أعوذ بك من الكفر والفقر وأعوذ بك من عذاب القبر لا إله إلا أنت، تعيدها حين تصبح ثلاثاً وحين تمسي ثلاثاً، قال: ( نعم يا بني إني سمعت النبي صلى الله عليه وسلم يدعو بهن فأحب أن أستن بسنته) رواه الإمام أحمد والبخاري في الأدب المفرد وأبو داود والنسائي بإسناد حسن."
                )
            )

            database.insertThekerToClass(16, 1, 3)
            database.insertThekerToClass(16, 2, 3)

            database.insertTheker(
                Theker(
                    17,
                    "",
                    getString(R.string.kalema_twhed),
                    100,
                    "كتبت له مائة حسنة ومحيت عنه مائة سيئة، وكانت له حرزاً من الشيطان يومه ذلك حتى يمسي ولم يأت أحد بأفضل مما جاء به إلا رجل عمل أكثر من ذلك.",
                    "عن أبي هريرة رضي الله عنه قال قال النبي صلى الله عليه وسلم (من قال: لا إله إلا الله وحده لا شريك له، له الملك وله الحمد وهو على كل شيء قدير في يوم مائة مرة كانت له عدل عشر رقاب، كتبت له مائة حسنة ومحيت عنه مائة سيئة، وكانت له حرزاً من الشيطان يومه ذلك حتى يمسي ولم يأت أحد بأفضل مما جاء به إلا رجل عمل أكثر من ذلك) رواه البخاري ومسلم."
                )
            )

            database.insertThekerToClass(17, 1, 100)

            database.insertTheker(
                Theker(
                    18,
                    "",
                    "أمسينا وأمسى الملك لله، والحمد لله، لا إله إلا الله وحده لا شريك له، له الملك وله الحمد وهو على كل شيء قدير، رب أسألك خير ما في هذه الليلة، وخير ما بعدها، وأعوذ بك من شر ما في هذه الليلة وشر ما بعدها، رب أعوذ بك من الكسل وسوء الكبر، رب أعوذ بك من عذاب في النار، وعذاب في القبر.",
                    1,
                    "",
                    "عن عبد الله بن مسعود رضي الله عنه قال: كان نبي الله صلى الله عليه وسلم إذا أمسى قال: (أمسينا وأمسى الملك لله، والحمد لله، لا إله إلا الله وحده لا شريك له، له الملك وله الحمد وهو على كل شيء قدير، رب أسألك خير ما في هذه الليلة، وخير ما بعدها، وأعوذ بك من شر ما في هذه الليلة وشر ما بعدها، رب أعوذ بك من الكسل وسوء الكبر، رب أعوذ بك من عذاب في النار، وعذاب في القبر) وإذا أصبح قال ذلك أيضاً أصبحنا وأصبح الملك لله رواه مسلم."
                )
            )

            database.insertThekerToClass(18, 2, 1)

            database.insertTheker(
                Theker(
                    19,
                    "",
                    "اللهم بك أمسينا وبك أصبحنا وبك نحيا وبك نموت وإليك المصير.",
                    1,
                    "",
                    "عن أبي هريرة رضي الله عنه عن النبي صلى الله عليه وسلم أنه كان يعلم أصحابه يقول: (إذا أصبح أحدكم فليقل: اللهم بك أصبحنا وبك أمسينا وبك نحيا وبك نموت وإليك النشور، وإذا أمسى فليقل اللهم بك أمسينا وبك أصبحنا وبك نحيا وبك نموت وإليك المصير) رواه أبو داود والترمذي والنسائي وابن ماجه، واسناده عند أبي داود وابن ماجه صحيح."
                )
            )

            database.insertThekerToClass(19, 2, 1)

            database.insertTheker(
                Theker(
                    20,
                    "",
                    "اللهم إني أمسيت أشهدك وأشهد حملة عرشك، وملائكتك وجميع خلقك بأنك أنت الله لا إله إلا أنت وحدك لا شريك لك، وأن محمداً عبدك ورسولك.",
                    4,
                    "يعتقه الله من النار",
                    "عن أنس بن مالك رضي الله عنه أن النبي صلى الله عليه وسلم قال: (من قال حين يصبح أو يمسي: اللهم إني أصبحت أشهدك وأشهد حملة عرشك، وملائكتك وجميع خلقك بأنك أنت الله لا إله إلا أنت وحدك لا شريك لك، وأن محمداً عبدك ورسولك أعتق الله ربعه من النار. ومن قالها مرتين أعتق الله نصفه من النار. ومن قالها ثلاثا أعتق الله ثلاثة أرباعه من النار، فإن قالها أربعا أعتقه الله من النار) رواه أبو داود بإسناد حسن."
                )
            )

            database.insertThekerToClass(20, 2, 4)

            database.insertTheker(
                Theker(
                    21,
                    "",
                    "اللهم ما أمسى بي من نعمة أو بأحد من خلقك فمنك وحدك لا شريك لك فلك الحمد ولك الشكر.",
                    1,
                    "يؤدي شكر ليلته.",
                    "عن عبد الله بن غنام رضي الله عنه أن رسول الله صلى الله عليه وسلم قال: (من قال حين يصبح: اللهم ما أصبح بي من نعمة أو بأحد من خلقك فمنك وحدك لا شريك لك فلك الحمد ولك الشكر فقد أدى شكر يومه، ومن قال ذلك حين يمسي فقد أدى شكر ليلته) رواه أبو داود والنسائي في عمل اليوم والليلة بإسناد حسن."
                )
            )

            database.insertThekerToClass(21, 2, 1)

            database.insertTheker(
                Theker(
                    22,
                    "",
                    "أمسينا على فطرة الِإسلام وعلى كلمة الِإخلاص وعلى دين نبينا محمد صلى الله عليه وسلم وعلى ملة أبينا إبراهيم حنيفا مسلماً وما كان من المشركين.",
                    1,
                    "",
                    "عن عبد الله بن عبد الرحمن بن أبيه عن أبيه رضي الله عنه أن النبي صلى الله عليه وسلم كان يقول إذا أصبح وإذا أمسى (أصبحنا على فطرة الِإسلام وعلى كلمة الِإخلاص وعلى دين نبينا محمد صلى الله عليه وسلم وعلى ملة أبينا إبراهيم حنيفا مسلماً وما كان من المشركين) رواه الِإمام أحمد في مسنده بإسناد صحيح."
                )
            )

            database.insertThekerToClass(22, 2, 1)

            database.insertTheker(
                Theker(
                    23,
                    "",
                    "أعوذ بكلمات الله التامات من شر ما خلق.",
                    3,
                    "",
                    "عن أبي هريرة رضي الله عنه قال: قال النبي صلى الله عليه وسلم: (من قال إذا أمسى ثلاث مرات: أعوذ بكلمات الله التامات من شر ما خلق، لم تضره حمة تلك الليلة) رواه الِإمام أحمد والترمذي بإسناد حسن."
                )
            )

            database.insertThekerToClass(23, 2, 3)

            database.insertTheker(
                Theker(
                    24,
                    "",
                    "اللهم باسمك أموت وأحيا.",
                    1,
                    "",
                    " عن حذيفة رضي الله عنه قال: كان رسول الله صلى الله عليه وسلم إذا أخذ مضجعه من الليل وضع يده تحت خده ثم يقول: (اللهم باسمك أموت وأحيا) رواه البخاري."
                )
            )

            database.insertThekerToClass(24, 4, 1)

            database.insertTheker(
                Theker(
                    25,
                    getString(R.string.esteatha),
                    "آمَنَ الرَّسُولُ بِمَا أُنزِلَ إِلَيْهِ مِن رَّبِّهِ وَالْمُؤْمِنُونَ ۚ كُلٌّ آمَنَ بِاللَّهِ وَمَلَائِكَتِهِ وَكُتُبِهِ وَرُسُلِهِ لَا نُفَرِّقُ بَيْنَ أَحَدٍ مِّن رُّسُلِهِ ۚ وَقَالُوا سَمِعْنَا وَأَطَعْنَا ۖ غُفْرَانَكَ رَبَّنَا وَإِلَيْكَ الْمَصِيرُ، لَا يُكَلِّفُ اللَّهُ نَفْسًا إِلَّا وُسْعَهَا ۚ لَهَا مَا كَسَبَتْ وَعَلَيْهَا مَا اكْتَسَبَتْ ۗ رَبَّنَا لَا تُؤَاخِذْنَا إِن نَّسِينَا أَوْ أَخْطَأْنَا ۚ رَبَّنَا وَلَا تَحْمِلْ عَلَيْنَا إِصْرًا كَمَا حَمَلْتَهُ عَلَى الَّذِينَ مِن قَبْلِنَا ۚ رَبَّنَا وَلَا تُحَمِّلْنَا مَا لَا طَاقَةَ لَنَا بِهِ ۖ وَاعْفُ عَنَّا وَاغْفِرْ لَنَا وَارْحَمْنَا ۚ أَنتَ مَوْلَانَا فَانصُرْنَا عَلَى الْقَوْمِ الْكَافِرِينَ.",
                    1,
                    "كفتاه أي: كفتاه من قيام الليل أو كفتاه من الشيطان أو كفتاه كلَ سوء، قال النووي -رحمه الله- (ويحتمل أن يراد الجميع).",
                    "ن أبي مسعود الأنصاري رضي الله عنه عن النبي صلى الله عليه وسلم قال: (من قرأ الآيتين من آخر سورة البقرة في ليلة كفتاه) رواه البخاري، ومسلم."
                )
            )

            database.insertThekerToClass(25, 4, 1)

            database.insertTheker(
                Theker(
                    26,
                    "",
                    "اللهم رب السموات، ورب الأرض، ورب العرش العظيم، ربنا ورب كل شيء، فالق الحب والنوى، ومنزل التوراة والإنجيل والفرقان، أعوذ بك من شر كل شيء أنت آخذ بناصيته، اللهم أنت الأول فليس قبلك شيء، وأنت الآخر فليس بعدك شيء، وأنت الظاهر فليس فوقك شيء، وأنت الباطن فليس دونك شيء، اقض عنا الدين، واغننا من الفقر.",
                    1,
                    "",
                    " عن أبي هريرة صلى الله عليه وسلم الله عنه عن النبي صلى الله عليه وسلم أنه كان يقول إذا أوى إلى فراشه: (اللهم رب السموات، ورب الأرض، ورب العرش العظيم، ربنا ورب كل شيء، فالق الحب والنوى، ومنزل التوراة والإنجيل والفرقان، أعوذ بك من شر كل شيء أنت آخذ بناصيته، اللهم أنت الأول فليس قبلك شيء، وأنت الآخر فليس بعدك شيء، وأنت الظاهر فليس فوقك شيء، وأنت الباطن فليس دونك شيء، اقض عنا الدين، واغننا من الفقر) رواه مسلم."
                )
            )

            database.insertThekerToClass(26, 4, 1)

            database.insertTheker(
                Theker(
                    27,
                    "",
                    "اللهم أسلمت نفسي إليك ووجهت وجهي إليك، وفوضت أمري إليك، وألجأت ظهري إليك رغبة ورهبة إليك، لا ملجأ ولا منجى منك إلا إليك، آمنت بكتابك الذي أنزلت، ونبيك الذي أرسلت.",
                    1,
                    "إن مات يموت على الفطرة أي على دين الإسلام وسنة خير الأنام.",
                    "عن البراء بن عازب رضي الله عنه قال: قال رسول الله صلى الله عليه وسلم: (إذا أتيت مضجعك فتوضأ وضوءك للصلاة ثم اضطجع على شقك الأيمن وقل: اللهم أسلمت نفسي إليك ووجهت وجهي إليك، وفوضت أمري إليك، وألجأت ظهري إليك رغبة ورهبة إليك، لا ملجأ ولا منجى منك إلا إليك، آمنت بكتابك الذي أنزلت، ونبيك الذي أرسلت، فإن متَ من ليلتك متَ على الفطرة واجعلهن آخر ما تقول)  رواه البخاري و مسلم."
                )
            )

            database.insertThekerToClass(27, 4, 1)

            database.insertTheker(
                Theker(
                    28,
                    "",
                    "اللهم قني عذابك يوم تبعث عبادك.",
                    3,
                    "",
                    "عن حفصة أم المؤمنين رضي الله عنها «أن النبي صلى الله عليه وسلم كان إذا أراد أن يرقد وضع يده اليمنى تحت خده الأيمن ثم يقول: ( اللهم قني عذابك يوم تبعث عبادك) ثلاث مرات رواه الإمام أحمد وأبو داود بإسناد حسن."
                )
            )

            database.insertThekerToClass(28, 4, 3)

            database.insertTheker(
                Theker(
                    29,
                    "",
                    "الحمد لله الذي أطعمنا وسقانا، وكفانا، وأوانا، فكم ممن لا كافي له، ولا مؤوي.",
                    1,
                    "",
                    "عن أنس رضي الله عنه «أن النبي صلى الله عليه وسلم كان إذا أوى إلى فراشه قال: (الحمد لله الذي أًطعمنا وسقانا، وكفانا، وأوانا، فكم ممن لا كافي له، ولا مؤوي) أخرجه مسلم."
                )
            )

            database.insertThekerToClass(29, 4, 1)

            database.insertTheker(
                Theker(
                    30,
                    "",
                    "اللهم خلقتَ نفسي وأنت تتوفاها، لك مماتها ومحياها، إن أحييتها فاحفظها، وإن أمتها فاغفر لها، اللهم إني أسألك العافية.",
                    1,
                    "",
                    ": عن ابن عمر رضي الله عنهما أنه أمر رجلاً إذا أخذ مضجعه أن يقول: (اللهم خلقت نفسي وأنت تتوفاها، لك مماتها ومحياها، إن أحييتها فاحفظها، وإن أمتها فاغفر لها، اللهم إني أسألك العافية). قال ابن عمر: سمعته من رسول الله صلى الله عليه وسلم  أخرجه مسلم."
                )
            )

            database.insertThekerToClass(30, 4, 1)

            database.insertTheker(
                Theker(
                    31,
                    "",
                    "سبحان الله (33 مرة)، والحمد لله (33 مرة)، والله أكبر (34 مرة).",
                    33,
                    "",
                    "عن علي رضي الله عنه أن فاطمة رضي الله عنها أتت النبي صلى الله عليه وسلم تسأله خادماً فلم تجده، ووجدت عائشة رضي الله عنها فأخبرتها. قال علي: فجاءنا النبي صلى الله عليه وسلم وقد أخذنا مضاجعنا فقال: ( ألا أدلكما على ما هو خير لكما من خادم، إذا أويتما إلى فراشكما فسبحا ثلاثا وثلاثين، واحمدا ثلاثاً وثلاثين، وكبرا أربعاً وثلاثين، فإنه خير لكما من خادم) . قال علي: فما تركتهن منذ سمعتهن من رسول الله صلى الله عليه وسلم رواه البخاري ومسلم."
                )
            )

            database.insertThekerToClass(31, 4, 33)

            database.insertTheker(
                Theker(
                    32,
                    "ذكر لمن استيقظ من الليل",
                    "لا إله إلا الله وحده لا شريك له، له الملك، وله الحمد وهو على كل شيء قدير، الحمد لله وسبحان الله، ولا إله إلا الله، والله أكبر، ولا حول ولا قوة إلا بالله.",
                    1,
                    " إن قال بعدها اللهم أغفر لي  أو دعا استجيب له، فإن توضأ وصلى قبلت صلاته",
                    "عن عبادة بن الصامت رضي الله عنه عن النبي صلى الله عليه وسلم قال: (من تعارَّ من الليل فقال: لا إله إلا الله وحده لا شريك له، له الملك، وله الحمد وهو على كل شيء قدير، الحمد لله وسبحان الله، ولا إله إلا الله، والله أكبر، ولا حول ولا قوة إلا بالله، ثم قال: اللهم اغفر لي أو دعا استجيب له، فإن توضأ وصلى قبلت صلاته) رواه البخاري."
                )
            )

            database.insertThekerToClass(32, 4, 1)

            database.insertTheker(
                Theker(
                    33,
                    "",
                    " أستغفر الله استغفر الله أستغفر الله اللهم أنت السلام ومنك السلام تباركت يا ذا الجلال والإكرام",
                    1,
                    "",
                    "عن ثوبان مولى رسول الله صلى الله عليه وسلم قال : (كانَ رَسولُ اللهِ صَلَّى اللَّهُ عليه وسلَّمَ، إذَا انْصَرَفَ مِن صَلَاتِهِ اسْتَغْفَرَ ثَلَاثًا وَقالَ: اللَّهُمَّ أَنْتَ السَّلَامُ وَمِنْكَ السَّلَامُ، تَبَارَكْتَ ذَا الجَلَالِ وَالإِكْرَامِ.) رواه مسلم."
                )
            )
            database.insertThekerToClass(33, 3, 1)

            database.insertTheker(
                Theker(
                    34,
                    "",
                    "لا إله إلا الله وحده لا شريك له، له الملك وله الحمد وهو على كل شيءٍ قدير، لا إله إلا الله، ولا نعبد إلا إياه، له النعمة وله الفضل وله الثناء الحسن، لا إله إلا الله، مخلصين له الدين ولو كره الكافرون",
                    1,
                    "",
                    "كانَ ابنُ الزُّبَيْرِ يقولُ: في دُبُرِ كُلِّ صَلَاةٍ حِينَ يُسَلِّمُ لا إلَهَ إلَّا اللَّهُ وَحْدَهُ لا شَرِيكَ له، له المُلْكُ وَلَهُ الحَمْدُ وَهو علَى كُلِّ شيءٍ قَدِيرٌ، لا حَوْلَ وَلَا قُوَّةَ إلَّا باللَّهِ، لا إلَهَ إلَّا اللَّهُ، وَلَا نَعْبُدُ إلَّا إيَّاهُ، له النِّعْمَةُ وَلَهُ الفَضْلُ، وَلَهُ الثَّنَاءُ الحَسَنُ، لا إلَهَ إلَّا اللَّهُ مُخْلِصِينَ له الدِّينَ ولو كَرِهَ الكَافِرُونَ وَقالَ: كانَ رَسولُ اللهِ صَلَّى اللَّهُ عليه وسلَّمَ يُهَلِّلُ بهِنَّ دُبُرَ كُلِّ صَلَاةٍ) رواه مسلم."
                )
            )

            database.insertThekerToClass(34, 3, 1)

            database.insertTheker(
                Theker(
                    35,
                    "",
                    "لا إله إلا الله وحده لا شريك له، له الملك وله الحمد وهو على كل شيء قدير، اللهم لا مانع لما أعطيت ولا معطي لما منعت ولا ينفع ذا الجَدِ منك الجَدُ",
                    1,
                    "الجد: الغنى، يعني لا ينفع ذا الغنى منك غناه، فلا ينفعه إلا العمل الصلاح لا الغنى ولا المال والجاه ولا غيره",
                    "عن المغيرة بن شعبة رضي الله عنه قال (إنَّ نَبِيَّ اللَّهِ صَلَّى اللهُ عليه وسلَّمَ كانَ يقولُ في دُبُرِ كُلِّ صَلَاةٍ: لا إلَهَ إلَّا اللَّهُ وحْدَهُ لا شَرِيكَ له، له المُلْكُ، وله الحَمْدُ، وهو علَى كُلِّ شيءٍ قَدِيرٌ، اللَّهُمَّ لا مَانِعَ لِما أعْطَيْتَ، ولَا مُعْطِيَ لِما مَنَعْتَ، ولَا يَنْفَعُ ذَا الجَدِّ مِنْكَ الجَدُّ) رواه البخاري."
                )
            )

            database.insertThekerToClass(35, 3, 1)

            database.insertTheker(
                Theker(
                    36,
                    "",
                    "سبحان الله (33 مرة) ، والحمد لله (33 مرة)، والله أكبر (33 مرة)، ويقول تمام المائة (لا إله إلا الله، وحده لا شريك له، له الملك وله الحمد، وهو على كل شيء قدير)",
                    33,
                    "غفرت له خطاياه وإن كانت مثل زبد البحر.",
                    "عن أبي هريرة رضي الله عنه قال: قال النبي صلى الله عليه وسلم (مَنْ سَبَّحَ اللَّهَ فِي دُبُرِ كُلِّ صَلاةٍ ثَلاثًا وَثَلاثِينَ وَحَمِدَ اللَّهَ ثَلاثًا وَثَلاثِينَ وَكَبَّرَ اللَّهَ ثَلاثًا وَثَلاثِينَ فَتْلِكَ تِسْعَةٌ وَتِسْعُونَ وَقَالَ تَمَامَ الْمِائَةِ لا إِلَهَ إِلاّ اللَّهُ وَحْدَهُ لا شَرِيكَ لَهُ لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ غُفِرَتْ خَطَايَاهُ وَإِنْ كَانَتْ مِثْلَ زَبَدِ الْبَحْرِ ) رواه مسلم."
                )
            )
            database.insertThekerToClass(36, 3, 33)

            database.insertTheker(
                Theker(
                    37,
                    getString(R.string.esteatha),
                    "اللَّهُ لَا إِلَٰهَ إِلَّا هُوَ الْحَيُّ الْقَيُّومُ ۚ لَا تَأْخُذُهُ سِنَةٌ وَلَا نَوْمٌ ۚ لَّهُ مَا فِي السَّمَاوَاتِ وَمَا فِي الْأَرْضِ ۗ مَن ذَا الَّذِي يَشْفَعُ عِندَهُ إِلَّا بِإِذْنِهِ ۚ يَعْلَمُ مَا بَيْنَ أَيْدِيهِمْ وَمَا خَلْفَهُمْ ۖ وَلَا يُحِيطُونَ بِشَيْءٍ مِّنْ عِلْمِهِ إِلَّا بِمَا شَاءَ ۚ وَسِعَ كُرْسِيُّهُ السَّمَاوَاتِ وَالْأَرْضَ ۖ وَلَا يَئُودُهُ حِفْظُهُمَا ۚ وَهُوَ الْعَلِيُّ الْعَظِيمُ.",
                    1,
                    "لم يمنعه من دخول الجنة إلا أن يموت.",
                    "عن أبي أمامة رضي الله عنه قال : قال رسول الله\n" +
                            "صلى الله عليه وسلم: (مَنْ قَرَأَ آيَةَ الْكُرْسِيِّ فِي دُبُرِ كُلِّ صَلَاةٍ مَكْتُوبَةٍ لَمْ يَمْنَعْهُ مِنْ دُخُولِ الْجَنَّةِ إِلَّا أَنْ يَمُوتَ) رواه النسائي، والطبراني، وقال ابن كثير رحمه الله (فهو إسناد على شرط البخاري)."
                )
            )

            database.insertThekerToClass(37, 3, 1)

            database.insertTheker(
                Theker(
                    38,
                    getString(R.string.basmallah),
                    "قُلْ هُوَ اللَّهُ أَحَدٌ، اللَّهُ الصَّمَدُ، لَمْ يَلِدْ وَلَمْ يُولَدْ، وَلَمْ يَكُن لَّهُ كُفُوًا أَحَدٌ .",
                    3,
                    "تقال 3 مرات في صلاتي المغرب والفجر، ومرة واحدة في باقي الصلوات",
                    "عن عقبة بن عامر رضي الله عنه قال: (أمَرني رسولُ اللهِ صلَّى اللهُ عليه وسلَّم أنْ أقرَأَ المُعوِّذاتِ دُبُرَ كلِّ صلاةٍ) رواه أبو داود ، والترمذي ، والنسائي ، وأحمد. وقال الترمذيُّ( حسنٌ غريب)."
                )
            )
            database.insertThekerToClass(38, 3, 3)

            database.insertTheker(
                Theker(
                    39,
                    getString(R.string.basmallah),
                    "قُلْ أَعُوذُ بِرَبِّ الْفَلَقِ،  مِن شَرِّ مَا خَلَقَ،  وَمِن شَرِّ غَاسِقٍ إِذَا وَقَبَ،  وَمِن شَرِّ النَّفَّاثَاتِ فِي الْعُقَدِ،  وَمِن شَرِّ حَاسِدٍ إِذَا حَسَدَ .",
                    3,
                    "تقال 3 مرات في صلاتي المغرب والفجر، ومرة واحدة في باقي الصلوات",
                    "عن عقبة بن عامر رضي الله عنه قال: (أمَرني رسولُ اللهِ صلَّى اللهُ عليه وسلَّم أنْ أقرَأَ المُعوِّذاتِ دُبُرَ كلِّ صلاةٍ) رواه أبو داود ، والترمذي ، والنسائي ، وأحمد. وقال الترمذيُّ( حسنٌ غريب)."
                )
            )

            database.insertThekerToClass(39, 3, 3)

            database.insertTheker(
                Theker(
                    40,
                    getString(R.string.basmallah),
                    "قُلْ أَعُوذُ بِرَبِّ النَّاسِ، مَلِكِ النَّاسِ،  إِلَٰهِ النَّاسِ،  مِن شَرِّ الْوَسْوَاسِ الْخَنَّاسِ،  الَّذِي يُوَسْوِسُ فِي صُدُورِ النَّاسِ،  مِنَ الْجِنَّةِ وَالنَّاسِ .",
                    3,
                    "تقال 3 مرات في صلاتي المغرب والفجر، ومرة واحدة في باقي الصلوات",
                    "عن عقبة بن عامر رضي الله عنه قال: (أمَرني رسولُ اللهِ صلَّى اللهُ عليه وسلَّم أنْ أقرَأَ المُعوِّذاتِ دُبُرَ كلِّ صلاةٍ) رواه أبو داود ، والترمذي ، والنسائي ، وأحمد. وقال الترمذيُّ( حسنٌ غريب)."
                )
            )

            database.insertThekerToClass(40, 3, 3)

            database.insertTheker(
                Theker(
                    41,
                    "",
                    "لا إله إلا الله، وحده لا شريك له، له الملك وله الحمد، يحيي ويميت، وهو على كل شيء قدير",
                    10,
                    " بعد صلاتي المغرب والفجر فقط .\n" +
                            "كنَّ له كعدل أربع رقاب، وكتب له بهنَّ عشر حسنات، ومحي عنه بهنَّ عشر سيئات، ورفه له بهنَّ عشر درجات، وكُنْ\n" +
                            "له حرساً من الشيطان حتى يمسي",
                    "عن أبي أيوب الأنصاري رضي الله عنه قال: قال رسول الله صلى الله عليه وسلم: (مَن قال إذا صلَّى الصُّبحَ: لا إلهَ إلَّا اللهُ، وَحْدَه لا شَريكَ له، له المُلكُ وله الحَمدُ، وهو على كُلِّ شَيءٍ قَديرٌ، عَشْرَ مرَّاتٍ؛ كُنَّ كعَدْلِ أربَعِ رِقابٍ، وكُتِبَ له بهِنَّ عَشْرُ حَسَناتٍ، ومُحِيَ عنه بهِنَّ عَشْرُ سيِّئاتٍ، ورُفِعَ له بهِنَّ عَشْرُ دَرَجاتٍ، وكُنْ له حَرَسًا مِن الشَّيْطانِ حتى يُمسِيَ، وإذا قالَها بعدَ المَغرِبِ فمِثلُ ذلك) أخرجه الترمذي، والنسائي، وأحمد بإسناد صحيح."
                )
            )
            database.insertThekerToClass(41, 3, 10)

            database.insertTheker(
                Theker(
                    42,
                    "",
                    "الحمد لله الذي أحيانا بعد ما أماتنا، وإليه النشور",
                    1,
                    "",
                    "عن حذيفة بن اليمان رضي الله عنه قال (كانَ النبيُّ صَلَّى اللهُ عليه وسلَّمَ إذَا أوَى إلى فِرَاشِهِ قَالَ: اللَّهُمَّ باسْمِكَ أحْيَا وأَمُوتُ، وإذَا أصْبَحَ قَالَ: الحَمْدُ لِلَّهِ الذي أحْيَانَا بَعْدَ ما أمَاتَنَا، وإلَيْهِ النُّشُورُ)رواه البخاري "
                )
            )
            database.insertThekerToClass(42, 5, 1)
            database.insertTheker(
                Theker(
                    43,
                    "",
                    "الحمد لله الذي ردَّ علي رُوحي، وعافاني في جسدي، وأَذِن لي بذِكره.",
                    1,
                    "",
                    "عن أبي هريرة رضي الله عنه قال: قال رسول الله صلى الله عليه وسلم: ( فإذا استيقظ أحدُكم فلْيَقُلْ : الحمدُ للهِ الذي عافانِى في جَسَدِي ، ورَدَّ عَلَيَّ رُوحِي ، وأَذِنَ لي بذِكْرِه) رواه الترمذي والنسائي."
                )
            )

            database.insertThekerToClass(43, 5, 1)

            /*************************************************/
            database.insertClass(Classification(1, getString(R.string.spaah)))
            database.insertClass(Classification(2, getString(R.string.masaa)))
            database.insertClass(Classification(3, getString(R.string.AfterPrayer)))
            database.insertClass(Classification(4, getString(R.string.naoom)))
            database.insertClass(Classification(5, getString(R.string.wakeup)))
            /*************************************************/
        }
        Log.e("wake thekers", "${database.getTheker(42)}")
        Log.e("wake thekers", "${database.getTheker(43)}")

        val classifications = database.getClasses()
        var topMarginForButtons = 65
        for (classs in classifications) {
            val set1 = ConstraintSet()

            val button = makeThekerButton(classs)

            set1.clone(binding.constraint)
            set1.connect(
                button.id,
                ConstraintSet.TOP,
                binding.imageView.id,
                ConstraintSet.BOTTOM,
                topMarginForButtons
            )
            topMarginForButtons += 210
            set1.applyTo(binding.constraint)
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun makeThekerButton(classs: Classification): Button {
        val button = Button(this)
        button.id = View.generateViewId()
        button.setBackgroundColor(Color.rgb(157, 192, 46))
        button.x = 190F
        button.layoutParams = ViewGroup.LayoutParams(750, 155)
        val snapString = SpannableString(classs.name)
        snapString.setSpan(StyleSpan(Typeface.BOLD), 0, snapString.length, 0)
        button.text = snapString
        button.textSize = 23f
        button.setTextColor(Color.BLACK)
        button.textAlignment = Button.TEXT_ALIGNMENT_CENTER
        binding.constraint.addView(button)

        button.setOnClickListener {
            startActivity(
                Intent(this, AzkarActivity::class.java).putExtra("azkarClass", classs.id)
                    .putExtra("name", classs.name)
            )
        }
        return button
    }

}
