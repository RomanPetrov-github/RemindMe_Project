package com.shockwave.reminder.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.shockwave.reminder.R;
import com.shockwave.reminder.adapter.RemindListAdapter;
import com.shockwave.reminder.dto.RemindDTO;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends AbstractTabFragment {

    private static final int LAYOUT = R.layout.fragment_history;

    public static HistoryFragment getInstance(Context context){
        Bundle args = new Bundle();
        HistoryFragment fragment = new HistoryFragment();
        fragment.setArguments(args);

        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_history));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new RemindListAdapter(getMockRemindListData()));
        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    private List<RemindDTO> getMockRemindListData() {
        List<RemindDTO> data = new ArrayList<>();

        data.add(new RemindDTO("Item a"));
        data.add(new RemindDTO("Item b"));
        data.add(new RemindDTO("Item c"));
        data.add(new RemindDTO("Item d"));
        data.add(new RemindDTO("Item e"));
        data.add(new RemindDTO("Item f"));

        return data;
    }
}
