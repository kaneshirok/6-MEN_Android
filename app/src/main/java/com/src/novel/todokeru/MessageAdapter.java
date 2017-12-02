package com.src.novel.todokeru;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.squareup.picasso.Picasso;
import com.src.novel.todokeru.databinding.FragmentMessageRowBinding;
import com.src.novel.todokeru.model.Message;

/**
 * Created by pdc-k-kamiya on 2017/12/02.
 */

public class MessageAdapter extends BaseAdapter {

    private Message mMessage;

    public MessageAdapter(Message message) {

        this.mMessage = message;
    }

    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        FragmentMessageRowBinding binding;

        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.fragment_message_row, null, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (FragmentMessageRowBinding) convertView.getTag();
        }

        binding.title.setText(mMessage.getData().get(position%mMessage.getData().size()).get);
        Picasso.with(parent.getContext()).load(DATA[position%DATA.length][1])
                .transform(new PicassoTransform()).into(binding.image);
        binding.message.setText("詳細コメント：" + position);

        return convertView;
    }
}
