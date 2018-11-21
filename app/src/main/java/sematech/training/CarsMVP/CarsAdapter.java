package sematech.training.CarsMVP;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import sematech.training.R;
import sematech.training.custom_views.MyImageView;
import sematech.training.custom_views.MyTextView;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.Holder> {
    Context mContext;
    List<CarEntity> cars;

    public CarsAdapter(Context mContext, List<CarEntity> cars) {
        this.mContext = mContext;
        this.cars = cars;
    }

    @Override
    public CarsAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.cars_items,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarsAdapter.Holder holder, int i) {
        holder.img.load(cars.get(i).getImg());
        holder.name.setText(cars.get(i).getName());
        holder.price.setText(cars.get(i).getPrice()+"");
        holder.company.setText(cars.get(i).getCompany());
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        MyImageView img;
        MyTextView name,price,company;
        public Holder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgCar);
            name = itemView.findViewById(R.id.tvName);
            price = itemView.findViewById(R.id.tvPrice);
            company = itemView.findViewById(R.id.tvCompany);
            img.setOnClickListener(V->{
                CarEntity selectedCar = cars.get(getAdapterPosition());
                selectCar.onCarSelect(selectedCar);

            });
        }
    }
    SelectCar selectCar;

    public void setSelectCar(SelectCar selectCar) {
        this.selectCar = selectCar;
    }

    interface SelectCar{
        void onCarSelect(CarEntity car);
    }
}
