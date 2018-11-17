package sematech.training.Drafts.mvpA;

public class MVPModel implements MVPContract.Model{
    MVPContract.Presenter presenter;
    @Override
    public void attachPressenter(MVPContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onGetAge(String name) {
        int age= 0;
        if(name.equals("Alireza"))
            age = 25;
        else if(name.equals("Asghar"))
            age = 45;
        else
            age = 60;
        presenter.onAgeRecevied(age);
    }
}
