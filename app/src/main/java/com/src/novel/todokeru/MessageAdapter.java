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

    String[][] DATA = {
            {"Aさん", "https://www.pakutaso.com/assets_c/2016/02/model_akanesaya-thumb-320x320-20922.jpg"},
            {"Bさん", "https://www.pakutaso.com/assets_c/2015/03/kawamurayuka-thumb-600x600-12130.jpg"},
            {"Cさん", "https://www.pakutaso.com/assets_c/2017/12/ookawa201712-thumb-1000x1000-37933.jpg"},
            {"Dさん", "https://www.pakutaso.com/assets_c/2016/03/satouyui-thumb-400x400-21434.jpg"},
            {"Eさん", "https://www.pakutaso.com/assets_c/2014/05/model_lalawapv-thumb-160x160-4613.jpg"},
            {"Fさん", "https://www.pakutaso.com/assets_c/2016/12/modellistup-thumb-600x600-28895.jpg"},
            {"Gさん", "https://www.pakutaso.com/assets_c/2016/02/model_akanesaya-thumb-320x320-20922.jpg"},
            {"Hさん", "https://www.pakutaso.com/assets_c/2014/05/model_akinapv-thumb-160x160-4624.jpg"},
    };

    private Message mMessage;

    public MessageAdapter(Message message) {

        this.mMessage = message;
    }

    @Override
    public int getCount() {

        if(mMessage.getData() == null){
            return 0;
        }

        return mMessage.getData().size();
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

        binding.title.setText(DATA[position%DATA.length][0]);
        Picasso.with(parent.getContext()).load(DATA[position%DATA.length][1])
                .transform(new PicassoTransform()).into(binding.image);
        binding.message.setText("詳細コメント：" + position);

        return convertView;
    }
}
