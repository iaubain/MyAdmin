package fragments;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.olranz.payfuel.myadmin.R;

import java.util.ArrayList;
import java.util.List;

import config.ClientData;
import config.ClientServices;
import config.ServerClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import simplebean.tankbean.TankBean;
import simplebean.tankbean.TankList;
import simplebean.tankingbean.TankingBean;
import simplebean.tankingbean.TankingResp;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnTankingInteraction} interface
 * to handle interaction events.
 * Use the {@link Tanking#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tanking extends Fragment {
    private static final String ARG_USER_ID = "userId";
    private static final String ARG_BRANCH_ID = "branchId";

    private int userId;
    private int branchId;

    private Spinner mSpinner;
    private EditText pretank, postTank, theoretical, delivered, numberPlate, waterValue;
    private Button submit;

    private int selectedTankId;
    private String selectedTankName;
    private List<Integer> tankIds;
    private List<String> tankNames;
    private List<String> viewTankNames;
    private ArrayAdapter<String> adapter;

    private OnTankingInteraction mListener;

    public Tanking() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param userId Parameter 1.
     * @param branchId Parameter 2.
     * @return A new instance of fragment Tanking.
     */
    public static Tanking newInstance(int userId, int branchId) {
        Tanking fragment = new Tanking();
        Bundle args = new Bundle();
        args.putInt(ARG_USER_ID, userId);
        args.putInt(ARG_BRANCH_ID, branchId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userId = getArguments().getInt(ARG_USER_ID);
            branchId = getArguments().getInt(ARG_BRANCH_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tanking_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getTanks();

        pretank=(EditText) view.findViewById(R.id.preTank);
        postTank=(EditText) view.findViewById(R.id.postTank);
        theoretical=(EditText) view.findViewById(R.id.theoretical);
        delivered=(EditText) view.findViewById(R.id.delivered);
        numberPlate=(EditText) view.findViewById(R.id.numberPlate);
        waterValue =(EditText) view.findViewById(R.id.waterValue);
        submit=(Button) view.findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validate fields
                long preT,postT,theor, waterV;
                String deliv, numberP;
                if(!TextUtils.isEmpty(pretank.getText().toString())&&
                        !TextUtils.isEmpty(postTank.getText().toString())&&
                        !TextUtils.isEmpty(theoretical.getText().toString())&&
                        !TextUtils.isEmpty(delivered.getText().toString())&&
                        !TextUtils.isEmpty(numberPlate.getText().toString())){

                    preT=Long.valueOf(pretank.getText().toString());
                    postT=Long.valueOf(postTank.getText().toString());
                    theor=Long.valueOf(theoretical.getText().toString());
                    if(TextUtils.isEmpty(waterValue.getText().toString()))
                        waterV=0;
                    else
                        waterV=Long.valueOf(waterValue.getText().toString());
                    deliv=delivered.getText().toString();
                    numberP=numberPlate.getText().toString();

                    //proceed to confirm box
                    TankingBean tankingBean=new TankingBean(userId, selectedTankId,waterV,postT,preT,theor,numberP,deliv);
                    confirmBox(tankingBean);
                }else{
                    // setting error to any field which has an error
                    uiFeed(getContext().getResources().getString(R.string.invalidData));
                }
            }
        });
    }

    private void confirmBox(final TankingBean tankingBean){
        if(tankingBean != null){
            //show a box
            final Dialog dialog = new Dialog(getContext(), android.R.style.Theme_Black_NoTitleBar_Fullscreen);
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setContentView(R.layout.dialog_confirm);

            TextView close=(TextView) dialog.findViewById(R.id.close);
            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            TextView title=(TextView) dialog.findViewById(R.id.title);
            title.setText(getResources().getString(R.string.tankingBoxTitle));

            TextView content=(TextView) dialog.findViewById(R.id.dialogContent);
            content.setText(mSpinner.getSelectedItem().toString());
            content.append(getResources().getString(R.string.ln));

            content.append(getResources().getString(R.string.pretank));
            content.append(String.valueOf(tankingBean.getPreTankedValue()));
            content.append(getResources().getString(R.string.ln));

            content.append(getResources().getString(R.string.posttank));
            content.append(String.valueOf(tankingBean.getPostTankedValue()));
            content.append(getResources().getString(R.string.ln));

            content.append(getResources().getString(R.string.theoritical));
            content.append(String.valueOf(tankingBean.getTheoreticalTanked()));
            content.append(getResources().getString(R.string.ln));

            content.append(getResources().getString(R.string.water));
            content.append(String.valueOf(tankingBean.getWaterValue()));
            content.append(getResources().getString(R.string.ln));

            content.append(getResources().getString(R.string.ln));

            content.append(getResources().getString(R.string.delivered));
            content.append(tankingBean.getDeliveredBy());
            content.append(getResources().getString(R.string.ln));

            content.append(getResources().getString(R.string.numberplate));
            content.append(tankingBean.getPlateNumber());
            content.append(getResources().getString(R.string.ln));

            Button cancel=(Button) dialog.findViewById(R.id.cancel);
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            Button submit=(Button) dialog.findViewById(R.id.submit);
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //attempt to make a URL post
                    dialog.dismiss();
                    publishTankingValues(tankingBean);
                }
            });

            dialog.show();
        }
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnTankingInteraction) {
            mListener = (OnTankingInteraction) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnTankingInteraction");
        }
    }

    private void publishTankingValues(final TankingBean tankingBean){
        try {
            ClientServices clientServices = ServerClient.getClient().create(ClientServices.class);
            Call<TankingResp> callService = clientServices.tanking(tankingBean);
            callService.enqueue(new Callback<TankingResp>() {
                @Override
                public void onResponse(Call<TankingResp> call, Response<TankingResp> response) {

                    //HTTP status code
                    int statusCode = response.code();
                    try{
                        final TankingResp tankingResp = response.body();

                        if(tankingResp.getStatusCode() == 100){
                            //Successful Tanking
                            uiFeed(tankingResp.getMessage());
                        }else{
                            //Notify User that an error happened
                            uiFeed(tankingResp.getMessage());
                        }

                    } catch (final Exception e) {
                        uiFeed(e.getMessage());
                    }
                }

                @Override
                public void onFailure(Call<TankingResp> call, Throwable t) {
                    // Log error here since request failed
                    Log.e(getClass().getSimpleName(), t.toString());
                    uiFeed(t.getMessage()+"");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            uiFeed(e.getMessage());
        }
    }

    private void getTanks(){
        tankIds=new ArrayList<>();
        tankNames=new ArrayList<>();
        viewTankNames =new ArrayList<>();
        try{
            mSpinner=(Spinner) getView().findViewById(R.id.mTankView);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            ClientServices clientServices = ServerClient.getClient().create(ClientServices.class);
            Call<TankList> callService = clientServices.getTankList();
            callService.enqueue(new Callback<TankList>() {
                @Override
                public void onResponse(Call<TankList> call, Response<TankList> response) {

                    //HTTP status code
                    int statusCode = response.code();
                    try{
                        Log.d(getClass().getSimpleName(),new ClientData().mapping(response.body()));
                        final TankList tankList = response.body();

                        if(tankList.getStatusCode() == 100){
                            //launch Admin app home screen
                            populateSpinner(tankList.getmTanks());
                        }else{
                            //Notify User that an error happened
                            uiFeed(tankList.getMessage());
                        }

                    } catch (final Exception e) {
                        uiFeed(e.getMessage());
                    }
                }

                @Override
                public void onFailure(Call<TankList> call, Throwable t) {
                    // Log error here since request failed
                    Log.e(getClass().getSimpleName(), t.toString());
                    uiFeed(t.getMessage()+"");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            uiFeed(e.getMessage());
        }
    }

    private void populateSpinner(List<TankBean> mTanks){
        if(!mTanks.isEmpty()){
            for(TankBean tank: mTanks){
//                if((tank.getStatus() == 7) && (tank.getBranchId() == branchId)) {
//                    viewTankNames.add(tank.getTankId() + ": " + tank.getName());
//                    tankNames.add(tank.getName());
//                    tankIds.add(tank.getTankId());
//                }

                // dummy data
                viewTankNames.add(tank.getTankId() + ": " + tank.getName());
                tankNames.add(tank.getName());
                tankIds.add(tank.getTankId());
            }

            if(!viewTankNames.isEmpty()){
                adapter=new ArrayAdapter<String>(getContext(),R.layout.tank_style, viewTankNames);
                mSpinner.setAdapter(adapter);
                mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                        selectedTankId=tankIds.get(position);
                        selectedTankName=tankNames.get(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }
        }
    }

    private void uiFeed(String feedBack){
        try{
            final TextView tv=(TextView) getView().findViewById(R.id.tv);
            if(!TextUtils.isEmpty(feedBack)){
                tv.setText(feedBack);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText("");
                    }
                }, 4000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnTankingInteraction {
        void onTankingInteraction(Object object, int statusCode, String message);
    }
}
