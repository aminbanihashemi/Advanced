package sematech.training.Drafts.mvpB;

import sematech.training.utils.flagModels.FlagModel;

public interface MVPBContract {
    interface View {
        void onDataRecevied(FlagModel result);
        void onConnectionFailed();
        void showLoading(Boolean show);
    }

    interface Presenter {
        void attachView(View view);
        void orderToGetData();
        void onDataRecevied(FlagModel result);
        void onConnectionFailed();
        void isOnLoading(Boolean load);
    }

    interface Model {
        void attachPresenter(Presenter presenter);
        void orderToGetData();
    }
}
