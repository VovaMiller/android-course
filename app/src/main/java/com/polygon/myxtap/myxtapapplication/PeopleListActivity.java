package com.polygon.myxtap.myxtapapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PeopleListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Person> peopleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_list);

        mRecyclerView = findViewById(R.id.people_list);
        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Initializing the list.
        for (int i = 0; i < 16; i += 1) {
            peopleList.add(new Person(i, "name_" + i));
        }

        // Specifying an adapter.
        mAdapter = new PeopleListAdapter(PeopleListActivity.this, peopleList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
