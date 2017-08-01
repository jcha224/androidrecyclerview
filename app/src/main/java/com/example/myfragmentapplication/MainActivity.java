package com.example.myfragmentapplication;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.myfragmentapplication.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            if (findViewById(R.id.activity_main) != null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.activity_main, new ItemFragment())
                        .commit();

            }
        }
        Log.d("ACTIVITY", "onCreate()");
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        DetailsFragment df = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.details);

        if (df != null) {
            df.updateContent(item);
        } else {
            df = new DetailsFragment();
            Bundle args = new Bundle();
            args.putSerializable(df.ITEM, item);
            df.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activity_main, df)
                    .addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ACTIVITY", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ACTIVITY", "onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ACTIVITY", "onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ACTIVITY", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();



        Log.d("ACTIVITY", "onStop()");
    }
}
