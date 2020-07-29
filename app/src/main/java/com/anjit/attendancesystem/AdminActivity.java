package com.anjit.attendancesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView addTeacher;
    String uid;
    TextView welcome;
    EditText date;
    Spinner std_class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        addTeacher = (CardView) findViewById(R.id.addTeacher);

        addTeacher.setOnClickListener(this);
        welcome = findViewById(R.id.welcomeadmin);
        this.setTitle("Admin");
        uid = getIntent().getExtras().getString("UID");
        welcome.setText("Welcome " + uid + " !!!");
        date = findViewById(R.id.date_admin);
        std_class = findViewById(R.id.class_admin);
    }

    @Override
    public void onClick(View v) {

    }


    public void view_student(View view) {
     Intent intent = new Intent(getApplicationContext(), ManageStudentActivity.class);

     startActivity(intent);

    }

    public void view_teachers(View view) {
    Intent intent = new Intent(getApplicationContext(),ManageTeacherActivity.class);
    startActivity(intent);
    }

    public void view_attendance(View v) {
        if (date.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Date Required", Toast.LENGTH_LONG).show();

        } else {

            Intent intent = new Intent(getApplicationContext(), ViewStudentsAttendanceActivity.class);
            intent.putExtra("CLASS", std_class.getSelectedItem().toString());
            intent.putExtra("DATE", date.getText().toString());
            startActivity(intent);
        }
    }


}
