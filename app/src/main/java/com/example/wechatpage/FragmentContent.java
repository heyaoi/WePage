package com.example.wechatpage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FragmentContent extends Fragment {
    //    private ListAdapter listAdapter;
    private RecyclerAdapter recyclerAdapter;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataManager dataManager = new DataManager();
//        listAdapter = new ListAdapter();
        recyclerAdapter = new RecyclerAdapter(dataManager.getContactList());
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content_recyclerview, container, false);
        return view;
    }

  /*  public View generateItemView(){
        return LayoutInflater.from(mViewContainer.getContext()).inflate(R.layout.item_content, mViewContainer, false);
    }

    public View bindData2View(View view,JavaBean data){

        TextView name = view.findViewById(R.id.tv_name);
        TextView phone = view.findViewById(R.id.tv_phone);

        name.setText(data.getName());
        phone.setText(data.getPhone());

        return view;
    }

    int index = 0;
    public void addItemView(){
        View view = generateItemView();

        bindData2View(view,dataManager.getContactList().get(index++));

        mViewContainer.addView(view);

    }*/

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        
//        mBtnAddView = view.findViewById(R.id.btn_addview);
//        mViewContainer = view.findViewById(R.id.item_container);
//        mViewContainer.setAdapter(listAdapter);

        //    private Button mBtnAddView;
        //    private LinearLayout mViewContainer;
        //    private ListView mViewContainer;
        RecyclerView mViewContainer = view.findViewById(R.id.item_container);

        mViewContainer.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mViewContainer.setAdapter(recyclerAdapter);



/*        mBtnAddView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"++",Toast.LENGTH_SHORT).show();
                // TODO: 2021/8/28 实现添加一个view的功能  addview
//                addItemView();
                if (listAdapter.getCount() == 0){
                    listAdapter.setData(dataManager.getContactList());
                }


            }
        });*/
        
        super.onViewCreated(view, savedInstanceState);
    }
}
