package com.example.dorit.english;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.InputStream;

public class Opening extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView tv;
    Spinner wordgroup;
    Button continuetotwo;
    String text="1";
    String[] english;
    String[] hebrew;
    ToggleButton tb;
    Boolean tbtf=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);

        tv = (TextView) findViewById(R.id.tv);
        wordgroup = (Spinner) findViewById(R.id.wordgroup);
        continuetotwo = (Button) findViewById(R.id.continuetotwo);
        tb = (ToggleButton) findViewById(R.id.tb);

        //spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.group, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        wordgroup.setAdapter(adapter);
        wordgroup.setOnItemSelectedListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent tt = new Intent(this, credits.class);
        startActivity(tt);
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        text = adapterView.getItemAtPosition(i).toString();
        tv.setText("בחרת בקבוצת המילים מספר: " + text+",  לחץ לשינוי >>");
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }


        public void cont(View view) {
            switch (text) {
                case "1": {
                    english = new String[]{"who", "what", "when", "where", "why", "how", "how many", "his", "how often", "how old", "how many times", "what color", "what kind of", "anybody", "which", "whose", "the", "A lot of", "that", "these"};
                    hebrew = new String[]{"מי", "מה", "מתי", "איפה", "למה", "איך", "כמה", "שלו", "באיזו תדירות", "בן כמה", "כמה פעמים", "באיזה צבע", "איזה סוג", "אף אחד", "איזה", "של מי", "ה", "הרבה", "זה", "האלה"};
                }
                break;
                case "2": {
                    english = new String[]{"those", "I", "somebody", "mine", "You", "your", "He", "how much", "yourselves", "she", "her", "we", "our", "Us", "they", "their", "them", "It", "Fewer than", "myself"};
                    hebrew = new String[]{"ההם", "אני", "מישהו", "שלי", "אתה", "שלך", "הוא", "כמה", "עצמכם", "היא", "שלה", "אנחנו", "שלנו", "אנחנו", "הם", "שלהם", "הם", "זה", "מועט מ", "אנוכי"};

                }
                break;
                case "3": {
                    english = new String[]{"The least", "yourself", "Himself", "Herself", "ourselves", "themselves", "him", "outside", "everyone", "several", "A couple of", "at", "this", "Lots of", "Few", "A number of", "Next to", "Little", "Less than"};
                    hebrew = new String[]{"הכי פחות", "עצמך", "עצמו", "עצמה", "עצמינו", "עצמם", "הוא", "מחוץ", "כל אחד", "כמה", "זוג", "ב", "זה", "המון", "מעט", "מספר", "ליד", "קטן", "פחות מ", "זה"};
                }
                break;
                case "4": {
                    english = new String[]{"The most", "my", "someone", "No one", "everybody", "A few", "everywhere", "somewhere", "nowhere", "nobody", "somehow", "what sort of", "to", "in", "inside", "out", "Some", "A great deal of", "into", "towards"};
                    hebrew = new String[]{"הכי", "שלי", "מישהו", "אף אחד", "כולם", "כמה", "בכל מקום", "במקום כלשהו", "בשום מקום", "אף אחד", "איך שהו", "איזה סוג", "ל", "ב", "בפנים", "בחוץ", "כמה", "הרבה", "בתוך", "כלפי"};
                }
                break;
                case "5": {
                    english = new String[]{"In front of", "opposite", "under", "above", "forward", "Near", "A little", "Far from", "usually", "back", "At 5 p.m.", "At 5 a.m.", "At midnight", "In the morning", "In the afternoon", "In the evening", "At night", "Every day", "Every week", "Every month"};
                    hebrew = new String[]{"לפני", "הפך", "מתחת", "מעל", "מקדימה", "ליד", "מעט", "רחוק מ", "בדרך כלל", "אחורה", "ב5 אחר הצהריים", "ב5 לפנות בוקר", "בחצות", "בבוקר", "אחר הצהריים", "בערב", "בלילה", "בכל יום", "בכל שבוע", "בכל חודש"};
                }
                break;
                case "6": {
                    english = new String[]{"Every year", "In the last century", "In the future", "Last week", "Last month", "Last year", "Last summer", "Next week", "Next month", "Next year", "Next summer", "soon", "In a week", "In a month", "frequently", "Right now", "At this moment", "Two years ago", "A week ago", "recently"};
                    hebrew = new String[]{"בכל שנה", "במאה הקודמת", "בעתיד", "השבוע שעבר", "החודש הקודם", "השנה שעברה", "בקיץ הקודם", "השבוע הבא", "החודש הבא", "שנה הבאה", "הקיץ הבא", "בקרוב", "בעוד שבוע", "בעוד חודש", "לעתים תכופות", "עכשיו בדיוק", "ברגע זה", "לפני שנתיים", "לפני שבוע", "בזמן האחרון"};
                }
                break;
                case "7": {
                    english = new String[]{"lately", "Not long ago", "before", "after", "Never", "ever", "often", "usually", "always", "sometimes", "Once in a while", "From time to time", "once", "twice", "Just", "already", "yet", "rarely", "now", "go"};
                    hebrew = new String[]{"לאחרונה", "לא מזמן", "לפני", "אחרי", "אף פעם", "אי פעם", "לעתים תכופות", "בדרך כלל", "תמיד", "לפעמים", "לעתים", "מזמן לזמן", "פעם אחת", "פעמיים", "רק", "כבר", "עוד לא", "לעתים נדירות", "עכשיו", "לך"};
                }
                break;
                case "8": {
                    english = new String[]{"went", "didn't go", "come", "came", "didn't come", "run", "ran", "didn't run", "jump", "jumped", "didn't jump", "Study", "studied", "didn't move", "Play", "Played", "didn't play", "Drive", "Drove", "didn't drive"};
                    hebrew = new String[]{"הלך", "לא הלך", "בוא", "בא", "לא בא", "רוץ", "רץ (עבר)", "לא רץ", "קפיצה", "קפץ", "לא קפץ", "ללמוד", "למד", "לא זז", "לשחק/לנגן", "שיחק/ניגן", "לא שיחק/ניגן", "נהיגה", "נהג", "לא נהג"};
                }
                break;
                case "9": {
                    english = new String[]{"fly", "flew", "didn't fly", "Swim", "Swam", "didn't swim", "Walk", "walked", "Stand", "Stood", "Think", "thought", "remember", "understand", "understood", "know", "knew", "recognize", "recognized", "imagined"};
                    hebrew = new String[]{"לעוף", "עף", "לא עף", "לשחות", "שחה", "לא שחה", "ללכת", "הלך", "לעמוד", "עמד", "לחשוב", "חשב", "לזכור", "להבין", "הבין", "לדעת", "ידע", "לזהות", "זיהה", "דמיין"};
                }
                break;
                case "10": {
                    english = new String[]{"Read", "write", "wrote", "listen", "listened", "learn", "Learned", "move", "moved", "forget", "forgot", "Look at", "watch", "Listen to", "expect", "Wait", "see", "saw", "Hear", "heard"};
                    hebrew = new String[]{"לקרוא", "לכתוב", "כתב", "להקשיב", "הקשיב", "ללמוד", "למד", "זוז", "זז", "לשכוח", "שכח", "להסתכל על", "לצפות", "להקשיב ל", "לצפות", "לחכות", "לראות", "ראה", "לשמוע", "שמע"};
                }
                break;
                case "11": {
                    english = new String[]{"smell", "touch", "feel", "felt", "taste", "miss", "love", "like", "hate", "can't stand", "be hungry", "be thirsty", "be angry", "be happy", "be sad", "be glad", "be sorry", "be tired", "be upset", "be frustrated"};
                    hebrew = new String[]{"ריח", "לגעת", "להרגיש", "הרגיש", "לטעום", "מתגעגע", "אהבה", "מחבב", "שנאה", "לא עומד ב", "להיות רעב", "להיות צמא", "להיות עצבני", "להיות שמח", "להיות עצוב", "להיות שמח", "להצטער", "להיות עייף", "להיות כעוס", "להיות מתוסכל"};
                }
                break;
                case "12": {
                    english = new String[]{"cry", "smile", "laugh", "be sick", "be wrong", "be right", "be aware", "be ready", "be late", "be busy", "big", "Bigger", "The biggest", "large", "Larger", "The largest", "small", "smaller", "The smallest", "Funny"};
                    hebrew = new String[]{"לבכות", "לחייך", "לצחוק", "להיות חולה", "לטעות", "להיות צודק", "להיות מודע", "להיות מוכן", "לאחר", "להיות עסוק", "גדול", "גדול יותר", "הכי גדול", "ענק", "יותר ענק", "הכי ענק", "קטן", "יותר קטן", "הכי קטן", "מצחיק"};
                }
                break;
                case "13": {
                    english = new String[]{"Cheap", "expensive", "beautiful", "More beautiful", "The most beautiful", "opposite", "In front of", "the least", "expensive", "More expensive", "The most expensive", "Good", "Better", "The best", "Bad", "Worse", "The worst", "New", "old", "young"};
                    hebrew = new String[]{"זול", "יקר", "יפה", "יותר יפה", "הכי יפה", "הפך", "לפני", "הכי פחות", "יקר", "יותר יקר", "הכי יקר", "טוב", "יותר טוב", "הכי טוב", "רע", "יותר גרוע", "הכי גרוע", "חדש", "ישן", "צעיר"};
                }
                break;
                case "14": {
                    english = new String[]{"smart", "clever", "sick", "long", "short", "close", "far", "and", "but", "In addition", "moreover", "however", "besides", "first", "finally", "though", "although", "Even though", "On the one hand", "On the other hand"};
                    hebrew = new String[]{"חכם", "פיקח", "חולה", "ארוך", "קצר", "קרוב", "רחוק", "ו", "אבל", "בנוסף", "מעבר לכך", "בכל מקרה", "חוץ מזה", "ראשון", "בסופו של דבר", "אם כי", "למרות ש", "אף על פי", "מצד אחד", "מצד שני"};
                }
                break;
                case "15": {
                    english = new String[]{"eventually", "As a result", "because", "That's why", "so", "In spite of…", "as……as", "Both…and", "Neither…nor", "Either ….or…", "whereas", "While", "Like", "unlike", "answer", "questions", "Tick", "Write", "list", "number"};
                    hebrew = new String[]{"בסופו של דבר", "כתוצאה מ", "בגלל", "מסיבה זו", "אז", "למרות", "בדומה ל", "שניהם", "אך אחד מהאפשרויות", "אחת מהאפשרויות", "ואילו", "כל עוד", "כמו", "בשונה מ", "תשובה", "שאלות", "תקתוק", "לכתוב", "רשימה", "מספר"};
                }
                break;
                case "16": {
                    english = new String[]{"Complete", "Fill in", "mention", "mentioned", "Refer", "Explain", "Writer", "author", "Article", "report", "According to", "Line", "paragraph", "Title", "Cause", "Effect", "Affect", "Result", "because", "reason"};
                    hebrew = new String[]{"להשלים", "למלא", "להזכיר", "מוזכר", "להתייחס", "להסביר", "כתב", "סופר", "כתבה", "דוח", "לפי", "קו", "פסקה", "כותרת", "סיבה", "השפעה", "להשפיע", "תוצאה", "בגלל", "סיבה"};
                }
                break;
                case "17": {
                    english = new String[]{"be", "I Am", "He is", "They are", "I am not", "it isn't", "They aren't", "will be", "Won't be", "do", "does", "did", "don't", "He doesn't", "She didn't", "I have something", "he has something", "They had something", "Was", "wasn't"};
                    hebrew = new String[]{"להיות", "אני", "הוא", "הם", "אני לא", "זה לא", "הם לא", "יהיה", "לא יהיה", "לעשות", "עושה", "עשה", "אל", "הוא לא", "היא לא", "יש לי משהו", "יש לו משהו", "היה להם משהו", "היה", "לא היה"};
                }
                break;
                case "18": {
                    english = new String[]{"Were", "weren't", "how old", "how many times", "mine", "You", "ourselves", "themselves", "A few", "The least", "Fewer than", "The most", "somebody", "No one", "everybody", "somewhere", "Out", "Pretty", "prettier", "The prettiest"};
                    hebrew = new String[]{"היו", "לא היו", "בן כמה", "כמה פעמים", "שלי", "את/ה", "עצמינו", "עצמם", "כמה", "הכי פחות", "פחות מ", "הכי", "מישהו", "אף אחד", "כולם", "איפה שהו", "בחוץ", "יפה", "יותר יפה", "הכי יפה"};
                }
                break;
            }

            if (tb.isChecked())
                tbtf = true;
            else
                tbtf = false;

            Intent t = new Intent(this, BeforeTheGame.class);
            t.putExtra("eng", english);
            t.putExtra("heb", hebrew);
            t.putExtra("tbtf", tbtf);
            startActivity(t);
            }
    }



