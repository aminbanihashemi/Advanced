package sematech.training.Drafts.mvpA;

public class MVPPresenter implements MVPContract.Presenter {
    MVPContract.View view;
    MVPContract.Model model = new MVPModel();

    @Override
    public void onAgeRecevied(int age) {
        view.onAgeRecevied(age);
    }

    @Override
    public void attachView(MVPContract.View view) {
        this.view = view;
        model.attachPressenter(this);
    }

    @Override
    public void onGetAge(String name) {
        model.onGetAge(name);
    }
}
