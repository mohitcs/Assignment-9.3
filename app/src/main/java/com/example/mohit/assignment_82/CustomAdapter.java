package com.example.mohit.assignment_82;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<CustomHandler> data;
    LayoutInflater inflater;
    int colors[] = new int[]{R.color.colorAccent, R.color.l1, R.color.l2,
            R.color.l3, R.color.l4, R.color.l5};

    public CustomAdapter(Context context, ArrayList<CustomHandler> data){
        this.context=context;
        this.data= data;
        inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return data.size();
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView= inflater.inflate(R.layout.custom_row, parent, false);
            holder= new ViewHolder();
            holder.view= (TextView)convertView.findViewById(R.id.view);
            holder.text= (TextView)convertView.findViewById(R.id.text);
            holder.description= (TextView)convertView.findViewById(R.id.description);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder)convertView.getTag();
        }
        holder.view.setBackgroundColor(ContextCompat.getColor(context,colors[position%6]));
        holder.text.setText(data.get(position).getName());
        holder.description.setText(data.get(position).getDescription());
        return convertView;
    }


    public class ViewHolder{
        TextView view;
        TextView text, description;
    }
}
