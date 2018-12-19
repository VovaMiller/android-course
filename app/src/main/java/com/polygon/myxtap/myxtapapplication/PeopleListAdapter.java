package com.polygon.myxtap.myxtapapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PeopleListAdapter extends RecyclerView.Adapter<PeopleListAdapter.ViewHolder> {

    private final List<Person> mValues;
    private Context mContext;

    public PeopleListAdapter(Context context, List<Person> items) {
        mContext = context;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.people_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final int iconRid =  mContext.getResources().getIdentifier(
                mValues.get(position).getIconString(),
                "mipmap",
                mContext.getPackageName());
        holder.mImageViewIcon.setImageResource(iconRid);

        holder.mTextViewName.setText(mValues.get(position).getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int pos = holder.getAdapterPosition();

                Intent intent = new Intent(mContext, PersonProfileActivity.class);
                intent.putExtra("image_rid", iconRid);
                intent.putExtra("person_name", mValues.get(pos).getName());
                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mImageViewIcon;
        public final TextView mTextViewName;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageViewIcon = view.findViewById(R.id.imgPersonPhotoPreview);
            mTextViewName = view.findViewById(R.id.textPersonName);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTextViewName.getText() + "'";
        }
    }
}
