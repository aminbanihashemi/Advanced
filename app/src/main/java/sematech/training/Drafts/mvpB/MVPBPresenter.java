package sematech.training.Drafts.mvpB;

import sematech.training.utils.flagModels.FlagModel;

public class MVPBPresenter implements MVPBContract.Presenter {
    MVPBContract.Model model = new MVPBModel();
    MVPBContract.View view;
    @Override
    public void attachView(MVPBContract.View view) {
        this.view=view;
        model.attachPresenter(this);
        model.orderToGetData();
    }

    @Override
    public void orderToGetData() {
        model.orderToGetData();
    }

    @Override
    public void onDataRecevied(FlagModel result) {
        view.onDataRecevied(result);
    }

    @Override
    public void onConnectionFailed() {
        view.onConnectionFailed();
    }

    @Override
    public void isOnLoading(Boolean load) {
        view.showLoading(load);
    }
}
