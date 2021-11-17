package com.example.eshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link purchase#newInstance} factory method to
 * create an instance of this fragment.
 */
public class purchase extends Fragment {


    TextView textView1, textView2, textView3, textView4, textView5;
    Button price1, price2, price3, price4, price5;
    Button tocart1, tocart2, tocart3, tocart4, tocart5;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public purchase() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment purchase.
     */
    // TODO: Rename and change types and number of parameters
    public static purchase newInstance(String param1, String param2) {
        purchase fragment = new purchase();
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


    List<Integer> sum = new ArrayList<>();
    //push into array function
    void pushToSum(String addPrice){
        int addPrice1 = Integer.parseInt( addPrice );
        sum.add(addPrice1);
        int add = 0;
        for (int i = 0; i < sum.size(); i++) {
            add += sum.get( i );
        }
        Bundle bundle = new Bundle();
        bundle.putString( "price", Integer.toString( add ));
        getParentFragmentManager().setFragmentResult( "data", bundle );
        System.out.println(addPrice);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate( R.layout.fragment_purchase, null, false );
        textView1 = (TextView) root.findViewById(R.id.textView1);
        textView2 = (TextView) root.findViewById(R.id.textView2);
        textView3 = (TextView) root.findViewById(R.id.textView3);
        textView4 = (TextView) root.findViewById(R.id.textView4);
        textView5 = (TextView) root.findViewById(R.id.textView5);

        price1 = (Button) root.findViewById(R.id.price1);
        price2 = (Button) root.findViewById(R.id.price2);
        price3 = (Button) root.findViewById(R.id.price3);
        price4 = (Button) root.findViewById(R.id.price4);
        price5 = (Button) root.findViewById(R.id.price5);

        tocart1 = (Button) root.findViewById(R.id.toCart1);
        tocart2 = (Button) root.findViewById(R.id.toCart2);
        tocart3 = (Button) root.findViewById(R.id.toCart3);
        tocart4 = (Button) root.findViewById(R.id.toCart4);
        tocart5 = (Button) root.findViewById(R.id.toCart5);




        tocart1.setOnClickListener( new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                String price_1 = price1.getText().toString();
                String description = textView1.getText().toString();
                Toast.makeText( getActivity().getApplicationContext(), "Item added to cart"+price_1 + description, Toast.LENGTH_SHORT ).show();
                pushToSum( price_1 );


            }
        });



        tocart2.setOnClickListener( new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                String price_1 = price2.getText().toString();
                String description = textView2.getText().toString();
                Toast.makeText( getActivity().getApplicationContext(), "Item added to cart "+price_1 + description, Toast.LENGTH_SHORT ).show();

                pushToSum( price_1 );

            }
        });
        tocart3.setOnClickListener( new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                String price_1 = price3.getText().toString();
                String description = textView3.getText().toString();
                Toast.makeText( getActivity().getApplicationContext(), "Item added to cart"+price_1 + description, Toast.LENGTH_SHORT ).show();

                pushToSum( price_1 );

            }
        });
        tocart4.setOnClickListener( new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                String price_1 = price4.getText().toString();
                String description = textView4.getText().toString();
                Toast.makeText( getActivity().getApplicationContext(), "Item added to cart"+price_1 + description, Toast.LENGTH_SHORT ).show();

                pushToSum( price_1 );

            }
        });
        tocart5.setOnClickListener( new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                String price_1 = price5.getText().toString();
                String description = textView5.getText().toString();
                Toast.makeText( getActivity().getApplicationContext(), "Item added to cart"+price_1 + description, Toast.LENGTH_SHORT ).show();

                pushToSum( price_1 );

            }
        });

    return root;
        //return inflater.inflate(R.layout.fragment_purchase, container, false);
    }

}