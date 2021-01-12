package com.emreaydemir.heelperexample.view.adapter;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emreaydemir.heelperexample.data.ItemBlankModel;
import com.emreaydemir.heelperexample.databinding.ItemBlankBinding;
import com.emreaydemir.heelperexample.view.callback.adapter.IBlankAdapter;

import java.util.List;

//public class BlankAdapter extends RecyclerView.Adapter<BlankAdapter.BlankAdapterViewHolder> {
//
//    /* ItemModel -> Item___Model
//       AdapterCallback -> I___Adapter
//       ItemBinding -> Item___Binding
//     */
//
//    public List<ItemBlankModel> list;
//
//    private final IBlankAdapter callback;
//
//public BlankAdapter(List<ItemBlankModel> list, @NonNull IBlankAdapter callback) {
//        this.list = list;
//        this.callback = callback;
//    }
//
//    @Override
//    public BlankAdapter.BlankAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return BlankAdapter.BlankAdapterViewHolder.create(LayoutInflater.from(parent.getContext()), parent, callback);
//    }
//
//    @Override
//    public void onBindViewHolder(BlankAdapter.BlankAdapterViewHolder holder, int position) {
//        holder.bindto(list.get(position));
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    static class BlankAdapterViewHolder extends RecyclerView.ViewHolder {
//
//        static BlankAdapter.BlankAdapterViewHolder create(LayoutInflater inflater, ViewGroup parent, IBlankAdapter callback) {
//            ItemBlankBinding itemListBinding = ItemBlankBinding.inflate(inflater, parent, false);
//            return new BlankAdapter.BlankAdapterViewHolder(itemListBinding, callback);
//        }
//
//        private ItemBlankBinding binding;
//
//        public BlankAdapterViewHolder(ItemBlankBinding binding, IBlankAdapter callback) {
//            super(binding.getRoot());
//            this.binding = binding;
////            binding.btnView.setOnClickListener(v ->
////                    callback.onBtnClicked(binding.getData()));
//        }
//
//        public void bindto(ItemBlankModel data) {
//            binding.setData(data);
//            binding.executePendingBindings();
//        }
//    }
//}
