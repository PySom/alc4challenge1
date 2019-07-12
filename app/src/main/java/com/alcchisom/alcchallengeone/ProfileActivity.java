package com.alcchisom.alcchallengeone;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    private User user;
    private TextView email;
    private TextView phone;
    private TextView slack;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        this.getSupportActionBar().setHomeButtonEnabled(true);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        user = DataManager.getInstance().getUser();
        initializeUserDetails();
        setEmailClick();
        setPhoneClick();
        setSlackClick();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void initializeUserDetails() {
        TextView name = findViewById(R.id.alc_user_name);
        TextView track = findViewById(R.id.user_track);
        TextView country = findViewById(R.id.user_country);
        email = findViewById(R.id.user_email);
        phone = findViewById(R.id.user_phone);
        slack = findViewById(R.id.user_slack);
        name.setText(user.getName());
        track.setText(user.getTrack());
        country.setText(user.getCountry());
        email.setText(user.getEmail());
        phone.setText(user.getPhone());
        slack.setText(user.getSlack());

    }

    private void setEmailClick() {
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + user.getEmail()));
                startActivity(intent);
            }
        });
    }

    private void setPhoneClick() {
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + user.getPhone()));
                startActivity(intent);
            }
        });
    }

    private void setSlackClick() {
        slack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("slack://user?team=" + user.getTeamId() +"&id=" + user.getUserId()));
                startActivity(intent);
            }
        });
    }


}
