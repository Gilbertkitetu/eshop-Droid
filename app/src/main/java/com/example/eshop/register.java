package com.example.eshop;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link register#newInstance} factory method to
 * create an instance of this fragment.
 */
public class register<mDatabase> extends Fragment {

    //private DatabaseReference mDatabase;
    //mDatabase = FirebaseDatabase.getInstance().getReference();
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText fullname, gender, idNumber, address;
    Button register, login;

    public register() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment register.
     */
    // TODO: Rename and change types and number of parameters
    public static register newInstance(String param1, String param2) {
        register fragment = new register();
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
        // Inflate the layout for this fragment


        View root = inflater.inflate( R.layout.fragment_register, null, false );
        fullname = (EditText) root.findViewById(R.id.fullname);
        gender = (EditText) root.findViewById( R.id.gender );
        idNumber = (EditText) root.findViewById( R.id.idnumber );
        address = (EditText) root.findViewById( R.id.address );
        register = (Button) root.findViewById( R.id.register );
        login = (Button) root.findViewById( R.id.login );

        login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), login.class);
                startActivity( intent );
                //finish();
            }
        } );

        register.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText( getActivity().getApplicationContext(), "Register clicked", Toast.LENGTH_SHORT ).show();
            rootNode = FirebaseDatabase.getInstance();
            reference = rootNode.getReference("details");

            //get all the values
                String full_name = fullname.getText().toString();
                String user_gender = gender.getText().toString();
                String id = idNumber.getText().toString();
                String user_address = address.getText().toString();

            registerHelper register = new registerHelper(full_name, user_gender, id, user_address);

            reference.child( id ).setValue( register );

                Toast toast = Toast.makeText(
                    getActivity().getApplicationContext(), "Register clicked"+ full_name, Toast.LENGTH_LONG
            );
            toast.setGravity( Gravity.CENTER, 0, 0 );
            toast.show();
            }
        } );

        //return inflater.inflate(R.layout.fragment_register, container, false);
        return root;
    }
}