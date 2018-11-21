package sematech.training.Drafts.mvpB;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;
import sematech.training.utils.Constants;
import sematech.training.utils.flagModels.FlagModel;

public class MVPBModel implements MVPBContract.Model {
    MVPBContract.Presenter presenter;

    @Override
    public void attachPresenter(MVPBContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void orderToGetData() {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(Constants.IP_ADDRESS, new TextHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                presenter.isOnLoading(true);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                presenter.onConnectionFailed();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                parsData(responseString);
            }

            @Override
            public void onFinish() {
                super.onFinish();
                presenter.isOnLoading(false);
            }
        });
    }
    void parsData(String response){
        Gson gson = new Gson();
        FlagModel result = gson.fromJson(response,FlagModel.class);
        presenter.onDataRecevied(result);
    }
}
