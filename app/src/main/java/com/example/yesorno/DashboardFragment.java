package com.example.yesorno;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {

    private RecyclerView recyclerView;
    private DashboardAdapter adapter;
    private List<DashboardItem> itemList = new ArrayList<>();
    private ItemDAO itemDAO;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dashboard_layout, container, false);
        recyclerView = view.findViewById(R.id.dashboard_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        itemDAO = new ItemDAO(getActivity());
        itemDAO.open();

        List<DashboardItem> itemList = itemDAO.getAllItems();
        adapter = new DashboardAdapter(itemList, new DashboardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Get the clicked item
                DashboardItem clickedItem = itemList.get(position);

                if(clickedItem.getTitle().equals("Monte Cara"))
                    startActivity(new Intent(getActivity(), MonteCaraActivity.class));
                else if(clickedItem.getTitle().equals("Vulcao"))
                    startActivity(new Intent(getActivity(), VulcaoActivity.class));
                else if(clickedItem.getTitle().equals("Carbeirinho"))
                    startActivity(new Intent(getActivity(), CarbeirinhoActivity.class));
                else if(clickedItem.getTitle().equals("Salinas Pedra de Lume"))
                    startActivity(new Intent(getActivity(), SalinasPedraDeLumeActivity.class));
                else if(clickedItem.getTitle().equals("Praia de Santa Maria"))
                    startActivity(new Intent(getActivity(), PraiaDeSantaMariaActivity.class));
                else if(clickedItem.getTitle().equals("Deserto de Viana"))
                    startActivity(new Intent(getActivity(), DesertoDeVianaActivity.class));
                else
                    startActivity(new Intent(getActivity(), ParqueNaturalDeMonteNacgordoActivity.class));
            }
        });
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        itemDAO.close();
    }
}