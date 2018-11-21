package sematech.training.Drafts.mvpCity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import sematech.training.R;
import sematech.training.custom_views.MyEditText;
import sematech.training.utils.BaseActivity;
import sematech.training.utils.Constants;

public class MVPCityActivity extends BaseActivity implements MVPContract.View {
    MVPContract.Presenter presenter = new MVPPresenter();
    ListView list;
    Button addItem;
    CustomDialog d;

    RoundedImageView addFlagImg, addCityImg;
    Uri addFlagUri,addCityUri;
    MyEditText addCity, addCountry, addCurrency, addLanguage, addPopulation;
    Button btnAdd, btnCancel;
    cityAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpcity);
        list = findViewById(R.id.city_list);
        d = new CustomDialog(mContext);
        addItem = findViewById(R.id.addItem);
        presenter.attachView(this);
        presenter.loadData();
        addItem.setOnClickListener(V -> {
            d.show();
        });


    }

    public class CustomDialog extends Dialog implements View.OnClickListener {

        public CustomDialog(Context context) {
            super(context);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.custom_dialog);
            bind();
            btnAdd.setOnClickListener(this);
            btnCancel.setOnClickListener(this);
            addFlagImg.setOnClickListener(this);
            addCityImg.setOnClickListener(this);
        }

        private void bind() {

            addFlagImg = findViewById(R.id.addFlagImg);
            addCityImg = findViewById(R.id.addCityImg);
            addCity = findViewById(R.id.addCity);
            addCountry = findViewById(R.id.addCountry);
            addCurrency = findViewById(R.id.addCurrency);
            addLanguage = findViewById(R.id.addLanguage);
            addPopulation = findViewById(R.id.addPopulation);
            btnAdd = findViewById(R.id.btnAdd);
            btnCancel = findViewById(R.id.btnCancel);


        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnAdd:
                    if (checkValidData()){
                        presenter.getDataFromUser(addCity.text(),addCountry.text(),addCurrency.text(),addLanguage.text(),Long.parseLong(addPopulation.text()),addFlagUri,addCityUri);
                        d.dismiss();
                        clearForm();
                    }
                    break;
                case R.id.btnCancel:
                    d.dismiss();
                    break;
                case R.id.addFlagImg:
                    intentToGallery(Constants.PICK_IMAGE_FLAG);
                    break;
                case R.id.addCityImg:
                    intentToGallery(Constants.PICK_IMAGE_CITY);
                    break;
            }

        }

        private void clearForm() {
            addFlagImg.setBackground(getResources().getDrawable(R.drawable.addsquarebutton));
            addCityImg.setBackground(getResources().getDrawable(R.drawable.addsquarebutton));
            addCity.setText("");
            addCountry.setText("");
            addCurrency.setText("");
            addLanguage.setText("");
            addPopulation.setText("");
        }

        private boolean checkValidData() {
            return true;
        }

        private void intentToGallery(int requestCode) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"),requestCode);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Constants.PICK_IMAGE_FLAG){
            Uri img = data.getData();
            addFlagImg.setImageURI(img);
            addFlagUri = img;
        }else if(requestCode == Constants.PICK_IMAGE_CITY) {
            Uri img = data.getData();
            addCityImg.setImageURI(img);
            addCityUri = img;
        }
    }

    @Override
    public void dataLoaded(List<cityModel>cities){
        adapter = new cityAdapter(mContext, cities);
        list.setAdapter(adapter);
    }

    @Override
    public void userDataSaved() {
        adapter.notifyDataSetChanged();
    }


}
