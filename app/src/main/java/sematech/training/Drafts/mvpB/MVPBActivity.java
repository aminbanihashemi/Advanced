package sematech.training.Drafts.mvpB;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;
import sematech.training.R;
import sematech.training.custom_views.MyButton;
import sematech.training.custom_views.MyEditText;
import sematech.training.custom_views.MyImageView;
import sematech.training.custom_views.MyTextView;
import sematech.training.utils.BaseActivity;
import sematech.training.utils.Publics;
import sematech.training.utils.flagModels.FlagModel;

public class MVPBActivity extends BaseActivity implements MVPBContract.View {
    MVPBContract.Presenter presenter = new MVPBPresenter();
    MyTextView result;
    MyButton getData;
    MyImageView flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpb2);
        bind();
        presenter.attachView(this);

        getData.setOnClickListener(V->{
            presenter.orderToGetData();
        });
    }

    private void bind() {
        result = findViewById(R.id.resultip);
        getData = findViewById(R.id.btnGettData);
        flag = findViewById(R.id.flag);
    }


    @Override
    public void onDataRecevied(FlagModel response) {
        result.setText("");
        flag.load(response.getFlag());
        result.append(response.getIp());
        result.append("\n");
        result.append(response.getCountryName());
        result.append("\n");
        result.append(response.getOrganisation());
    }

    @Override
    public void onConnectionFailed() {
        Toast.makeText(this, "Error in Connecting", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading(Boolean show) {
        if(show)
            dialog.show();
        else
            dialog.dismiss();
    }
}
