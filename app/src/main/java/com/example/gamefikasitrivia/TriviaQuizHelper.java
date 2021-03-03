package com.example.gamefikasitrivia;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


class TriviaQuizHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DB_NAME = "TQuiz.db";
    private static final int DB_VERSION = 3;
    private static final String TABLE_NAME = "TQ";
    private static final String UID = "_UID";
    private static final String QUESTION = "QUESTION";
    private static final String OPTA = "OPTA";
    private static final String OPTB = "OPTB";
    private static final String OPTC = "OPTC";
    private static final String OPTD = "OPTD";
    private static final String ANSWER = "ANSWER";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + QUESTION + " VARCHAR(255), " + OPTA + " VARCHAR(255), " + OPTB + " VARCHAR(255), " + OPTC + " VARCHAR(255), " + OPTD + " VARCHAR(255), " + ANSWER + " VARCHAR(255));";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    TriviaQuizHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    void allQuestion() {
        ArrayList<TriviaQuestion> arraylist = new ArrayList<>();

        arraylist.add(new TriviaQuestion("Program yang diciptakaan oleh hacker yang bertujuan untuk mengontrol sistem tanpa diketahui oleh Administrator", "Virus", "Backdoor", "Phising", "Malware", "Backdoor"));

        arraylist.add(new TriviaQuestion("Program yang dibuat oleh para hacker bertujuan untuk mengerjakan pekerjaanya secara otomatis", "Backdoor", "Bot", "Brute Force", "Malware", "Bot"));

        arraylist.add(new TriviaQuestion("Suatu aktifitas dimana seorang hacker merusak sebuah situs kemudian merubah tampilan situs tersebut", "Hacking", "Surfing", "Deface", "Exploite", "Deface"));

        arraylist.add(new TriviaQuestion("Sebuah program komputer atau bisa juga disebut virus yang dapat menggandakan dirinya secara sendiri dalam sistem komputer", "Trojan", "Worm", "Phising", "Keylogger", "Worm"));

        arraylist.add(new TriviaQuestion("Salah satu tingkatan sertifikasi yang ditawarkan oleh EC-Council (lembaga sertifikasi di bidang cyber security)", "CEH", "Blackhat", "Whitehat", "Certified Hacker", "CEH"));

        arraylist.add(new TriviaQuestion("Suatu sistem terdapat kelemahan atau kerentanan yang membahayakan sistem atau aplikasi itu sendiri", "Bug", "Patch", "Weakness", "Vulnerable", "Vulnerable"));

        arraylist.add(new TriviaQuestion("Kegiatan dimana seseorang menambal atau menutup suatu kerentanan adalah", "Patch", "Repair", "Fixing", "Closing", "Patch"));

        arraylist.add(new TriviaQuestion("Kesalahan pada program yang mengakibatkan terdapat kerentanan pada suatu aplikasi", "Bug", "Patch", "Weakness", "Vulnerability", "Bug"));

        arraylist.add(new TriviaQuestion("Suatu aktifitas yang dilakukan para hacker, untuk mencuri kartu kredit dan lain-lain, dan membelanjakannya secara ilegal", "Hacking", "Carding", "Stealing", "Hijacking", "Carding"));

        arraylist.add(new TriviaQuestion("Suatu aplikasi yang merekam aktivitas pengguna komputer, dengan tujuan memata-matai", "Spy", "Vlogger", "Keylogger", "Recorder", "Keylogger"));

        arraylist.add(new TriviaQuestion("Bahasa dimana seorang hacker telah meretas sistem itu", "Pwnd", "Deface", "Exploited", "Leaked", "Pwnd"));

        arraylist.add(new TriviaQuestion("Suatu aktifitas pembobolan atau membobol suatu aplikasi hingga suatu jaringan", "Spy", "Hijacking", "Dork", "Crack", "Crack"));

        arraylist.add(new TriviaQuestion("Aktifitas seorang hacker yang membocorkan sebuah informasi rahasia ke publik", "Surfing", "Leaked", "Jump", "Back Connect", "Leaked"));

        arraylist.add(new TriviaQuestion("Aktifitas penyerangan dengan cara membanjiri dan dengan tujuan merusak suatu sistem", "Flood", "Scam", "Crack", "DDOS", "Flood"));

        arraylist.add(new TriviaQuestion("Sekumpulan program yang saling terhubung melalui Internet yang berkomunikasi dengan program-program sejenis untuk melakukan tugas tertentu", "Hijacking", "Flood", "Botnet", "Honeynet", "Botnet"));

        arraylist.add(new TriviaQuestion("Manipulasi psikologis dari seseorang dalam melakukan aksi atau menguak suatu informasi rahasia", "Leet", "Dork", "Social Engineering", "Spoof", "Social Engineering"));

        arraylist.add(new TriviaQuestion("Sistem komunikasi digital yang dirancang agar orang yang menerima pesan atau konten hanyalah pihak-pihak yang berhak menerimanya", "End to end encyrption", "Cryptography", "PGP", "TextSecure", "End to end encryption"));

        arraylist.add(new TriviaQuestion("Salah satu metode yang digunakan oleh hacker untuk memperoleh informasi tentang targetnya dengan menggunakan teknik-teknik pengamatan langsung, seperti memeriksa tingkah laku seseorang, untuk mendapat informasi", "Surfing", "Hijacking", "Espionage", "Manifest", "Surfing"));

        arraylist.add(new TriviaQuestion("Exploit yang dipublikasikan secara cuma-cuma oleh para Debugger untuk para Script Kiddie", "Shell", "Zero Day", "PoC", "CEH", "Zero Day"));

        arraylist.add(new TriviaQuestion("Memperoleh informasi pribadi seperti password atau data-data lainnya menggunakan situs palsu", "Phising", "Social Engineering", "Scam", "Flood", "Phising"));

        this.addAllQuestions(arraylist);

    }


    private void addAllQuestions(ArrayList<TriviaQuestion> allQuestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            for (TriviaQuestion question : allQuestions) {
                values.put(QUESTION, question.getQuestion());
                values.put(OPTA, question.getOptA());
                values.put(OPTB, question.getOptB());
                values.put(OPTC, question.getOptC());
                values.put(OPTD, question.getOptD());
                values.put(ANSWER, question.getAnswer());
                db.insert(TABLE_NAME, null, values);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }


    List<TriviaQuestion> getAllOfTheQuestions() {

        List<TriviaQuestion> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, OPTD, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);


        while (cursor.moveToNext()) {
            TriviaQuestion question = new TriviaQuestion();
            question.setId(cursor.getInt(0));
            question.setQuestion(cursor.getString(1));
            question.setOptA(cursor.getString(2));
            question.setOptB(cursor.getString(3));
            question.setOptC(cursor.getString(4));
            question.setOptD(cursor.getString(5));
            question.setAnswer(cursor.getString(6));
            questionsList.add(question);
        }

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return questionsList;
    }
}
