package sample.com.androiddbgreendao;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sample.com.androiddbgreendao.db.DaoMaster;
import sample.com.androiddbgreendao.db.DaoSession;
import sample.com.androiddbgreendao.db.SaveUserModel;
import sample.com.androiddbgreendao.db.SaveUserModelDao;

public class MainActivity extends AppCompatActivity {

    //Dao --> Data Access Object
    private SaveUserModelDao userDao; // Sql access object

    private final String DB_NAME = "my-app-db";  //Name of Db file in the Device

    @BindView(R.id.text)
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        //Initialise DAO
        userDao = setupDb();
        text.setText(getFromSQL().get(0).getName());
    }
    public List<SaveUserModel> getFromSQL() {
        List<SaveUserModel> userses = userDao.queryBuilder().orderDesc(SaveUserModelDao.Properties.Id).build().list();
        return userses;
    }
    //Return the Configured LogDao Object
    public SaveUserModelDao setupDb() {
        DaoMaster.DevOpenHelper masterHelper = new DaoMaster.DevOpenHelper(this, DB_NAME, null); //create database db file if not exist
        SQLiteDatabase db = masterHelper.getWritableDatabase();  //get the created database db file
        DaoMaster master = new DaoMaster(db);//create masterDao
        DaoSession masterSession = master.newSession(); //Creates Session session
        return masterSession.getSaveUserModelDao();
    }
}
