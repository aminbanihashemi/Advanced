package sematech.training.Drafts.mvpCity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;
import sematech.training.R;
import sematech.training.custom_views.MyImageView;
import sematech.training.custom_views.MyTextView;

public class cityAdapter extends BaseAdapter {

    Context mContext;
    List<cityModel> cars;
    cityModel car;

    public cityAdapter(Context mContext, cityModel car) {
        this.mContext = mContext;
        this.car = car;
    }

    public cityAdapter(Context mContext, List<cityModel> cars) {
        this.mContext = mContext;
        this.cars = cars;
    }

    @Override
    public int getCount() {
        return cars.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.city_items,parent,false);

        MyTextView nameCity,country,currency,language,population;
        RoundedImageView roundedImg;
        MyImageView imgCity;

        nameCity = view.findViewById(R.id.nameCity);
        country = view.findViewById(R.id.country);
        currency = view.findViewById(R.id.currency);
        language = view.findViewById(R.id.language);
        population = view.findViewById(R.id.population);
        imgCity = view.findViewById(R.id.imgCity);
        roundedImg = view.findViewById(R.id.roundedImg);

        nameCity.setText(cars.get(position).name);
        country.setText(cars.get(position).country);
        currency.setText(cars.get(position).currency);
        language.setText(cars.get(position).language);
        population.setText(cars.get(position).population+"");
        imgCity.load(cars.get(position).imgCity);

        Picasso.get().load(cars.get(position).imgFlag).fit().into(roundedImg);

        return view;
    }
}
