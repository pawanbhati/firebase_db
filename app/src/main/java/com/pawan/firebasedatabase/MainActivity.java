package com.pawan.firebasedatabase;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onInsertClick(View view) {
        insertUserToDB(getUser1());
        insertUserToDB(getUser2());
        insertUserToDB(getUser3());
        insertUserToDB(getUser4());
        insertUserToDB(getUser5());
        insertUserToDB(getUser6());
        insertUserToDB(getUser7());
        insertUserToDB(getUser8());
        insertUserToDB(getUser9());
    }

    public void onUpdateClicked(View view) {

    }

    public void onDelClicked(View view) {

    }

    private Users getUser1() {
        Users user = new Users();
        user.setAge(19);
        user.setUserId(1);
        user.setTimeStamp(System.currentTimeMillis());
        user.setUserName("Pawan");
        return user;
    }


    private Users getUser2() {
        Users user = new Users();
        user.setUserId(2);
        user.setAge(20);
        user.setTimeStamp(System.currentTimeMillis());
        user.setUserName("Nitish");
        return user;
    }

    private Users getUser3() {
        Users user = new Users();
        user.setAge(21);
        user.setUserId(3);
        user.setTimeStamp(System.currentTimeMillis());
        user.setUserName("Priyanka");
        return user;
    }

    private Users getUser4() {
        Users user = new Users();
        user.setUserId(4);
        user.setAge(22);
        user.setTimeStamp(System.currentTimeMillis());
        user.setUserName("Manish");
        return user;
    }

    private Users getUser5() {
        Users user = new Users();
        user.setUserId(5);
        user.setAge(23);
        user.setTimeStamp(System.currentTimeMillis());
        user.setUserName("Pradnya");
        return user;
    }

    private Users getUser6() {
        Users user = new Users();
        user.setUserId(6);
        user.setAge(24);
        user.setTimeStamp(System.currentTimeMillis());
        user.setUserName("Sadique");
        return user;
    }

    private Users getUser7() {
        Users user = new Users();
        user.setUserId(7);
        user.setAge(25);
        user.setTimeStamp(System.currentTimeMillis());
        user.setUserName("Deepak");
        return user;
    }

    private Users getUser8() {
        Users user = new Users();
        user.setUserId(8);
        user.setAge(26);
        user.setTimeStamp(System.currentTimeMillis());
        user.setUserName("Phani");
        return user;
    }

    private Users getUser9() {
        Users user = new Users();
        user.setUserId(9);
        user.setAge(27);
        user.setTimeStamp(System.currentTimeMillis());
        user.setUserName("Shivkant");
        return user;
    }

    private void insertUserToDB(Users user) {
        DatabaseReference firebaseDatabase = FirebaseDatabase.getInstance().getReference();
        String userId = firebaseDatabase.push().getKey();
        firebaseDatabase.child("users").child(userId).setValue(user);
    }
}
