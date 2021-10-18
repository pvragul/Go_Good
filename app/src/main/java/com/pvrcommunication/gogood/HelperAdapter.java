package com.pvrcommunication.gogood;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class HelperAdapter extends RecyclerView.Adapter<HelperAdapter.MyViewClass> {


    ArrayList<String> arrname;
    ArrayList<String> arruserName;
    ArrayList<String> arremail;
    ArrayList<String> arrid;
    ArrayList<String> arrphone;
    ArrayList<String> arrwebsite;
    ArrayList<String> arrstreet;
    ArrayList<String> arrsuite;
    ArrayList<String> arrcity;
    ArrayList<String> arrzipcode;
    ArrayList<String> arrcompanyname;
    ArrayList<String> arrcompanycp;
    ArrayList<String> arrcompanybs;
    //ArrayList<String> arrgeolat;
    //ArrayList<String> arrgeolng;

    Context context;

    public HelperAdapter(ArrayList<String> id, ArrayList<String> name, ArrayList<String> userName, ArrayList<String> email,  ArrayList<String> phone,
                         ArrayList<String> website, ArrayList<String> street, ArrayList<String> suite, ArrayList<String> city,
                         ArrayList<String> zipcode, ArrayList<String> companyname, ArrayList<String> companycp, ArrayList<String> companybs,
                         /*ArrayList<String> lat, ArrayList<String> lng,*/ Context context) {
        this.arrid = id;
        this.arrname = name;
        this.arruserName = userName;
        this.arremail = email;
        this.arrphone = phone;
        this.arrwebsite = website;
        this.arrstreet = street;
        this.arrsuite = suite;
        this.arrcity = city;
        this.arrzipcode = zipcode;
        this.arrcompanyname = companyname;
        this.arrcompanycp = companycp;
        this.arrcompanybs = companybs;
        /*this.arrgeolat = lat;
        this.arrgeolng = lng;*/
        this.context = context;


    }

    @NonNull
    @Override
    public MyViewClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_details,parent,false);
        //MyViewClass vc = new MyViewClass(view);
        return new MyViewClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewClass holder, int position) {

        holder.recid.setText((arrid.get(position)));
        holder.recname.setText(arrname.get(position));
        holder.recuserName.setText(arruserName.get(position));
        holder.recemail.setText(arremail.get(position));
        holder.recphone.setText(arrphone.get(position));
        holder.recwebsite.setText(arrwebsite.get(position));
        holder.reccompanyName.setText(arrcompanyname.get(position));
        holder.reccompanycp.setText(arrcompanycp.get(position));
        holder.reccompanybs.setText(arrcompanybs.get(position));
        holder.recstreet.setText(arrstreet.get(position));
        holder.recsuite.setText(arrsuite.get(position));
        holder.reccity.setText(arrcity.get(position));
        holder.reczipcode.setText(arrzipcode.get(position));

        /*holder.recgeoloc.setOnClickListener(view -> {


            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("google.streetview:cbll="+arrgeolat+","+arrgeolng));
            intent.setPackage("com.google.android.apps.maps");


        });*/


        holder.itemView.setOnClickListener(view -> Toast.makeText(context,"Item Clicked", Toast.LENGTH_SHORT).show());
    }



    @Override
    public int getItemCount() {
        return arruserName.size();
    }

    public static class MyViewClass extends RecyclerView.ViewHolder{

        TextView recid;
        TextView recname;
        TextView recuserName;
        TextView recemail;
        TextView recphone;
        TextView recwebsite;
        TextView recstreet;
        TextView recsuite;
        TextView reccity;
        TextView reczipcode;
        TextView reccompanyName;
        TextView reccompanycp;
        TextView reccompanybs;
        //ImageButton recgeoloc;


        public MyViewClass(@NonNull View itemView) {
            super(itemView);

            recid = itemView.findViewById(R.id.receivedIDNo);
            recname = itemView.findViewById(R.id.receivedName);
            recuserName = itemView.findViewById(R.id.receivedUserName);
            recemail = itemView.findViewById(R.id.receivedEmail);
            recphone = itemView.findViewById(R.id.receivedphoneNumber);
            recwebsite = itemView.findViewById(R.id.receivedWebsite);
            recstreet = itemView.findViewById(R.id.receivedStreet);
            recsuite = itemView.findViewById(R.id.receivedSuite);
            reccity = itemView.findViewById(R.id.receivedCity);
            reczipcode = itemView.findViewById(R.id.receivedZipcode);
            reccompanyName = itemView.findViewById(R.id.receivedcompanyName);
            reccompanycp = itemView.findViewById(R.id.receivedcompanycp);
            reccompanybs = itemView.findViewById(R.id.receivedcompanybs);
            //recgeoloc = itemView.findViewById(R.id.receivedgeoLocation);
        }
    }
}
