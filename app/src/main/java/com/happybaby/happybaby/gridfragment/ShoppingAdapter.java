//package com.happybaby.happybaby.gridfragment;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.CheckBox;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.happybaby.happybaby.R;
//import com.happybaby.happybaby.bean.GridBean;
//import com.squareup.picasso.Picasso;
//
//import java.util.List;
//
//
//public class ShoppingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
//
//    //===========================================
//    //====================点击监听接口========================
//    //==========================================
//    public interface OnItemClickListener{
//        void itemClick(View itemView, int position);
//    };
//
//    public interface OnItemLongClickListener{
//        void itemLongCilck(View itemView, int position);
//    }
//
//    private OnItemClickListener itemClickListener;
//    private OnItemLongClickListener  itemLongClickListener;
//
//    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
//        this.itemClickListener = itemClickListener;
//    }
//
//    public void setOnItemLongClickListener(OnItemLongClickListener itemLongClickListener) {
//        this.itemLongClickListener = itemLongClickListener;
//    }
//    //===========================================
//    //====================点击监听接口========================
//    //==========================================
//
//    private Context context; //上下文
//    private List<GridBean.DataBeanX.DataBean.ListBean> datas; // 数据源
//    private LayoutInflater inflater; // 布局加载器
//
//    public ShoppingAdapter(Context context, List<GridBean.DataBeanX.DataBean.ListBean> datas) {
//        this.context = context;
//        this.datas = datas;
//        inflater = LayoutInflater.from(context);
//    }
//
//    //创建ViewHolder
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        //由布局生成生成View
//        View converView = inflater.inflate(R.layout.place_topic_view, parent, false);
//        MyViewHolder viewHolder = new MyViewHolder(converView);
//        return viewHolder;
//    }
//
//    //绑定数据
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        MyViewHolder viewHolder = (MyViewHolder) holder;
//        //获得指定位置数据
//        GridBean.DataBeanX.DataBean.ListBean data = datas.get(position);
//        //绑定数据
//        Picasso.with(context).load(data.getTopic_image()).into(viewHolder.treasureIv);  //加载商品图片
//        viewHolder.detailsTv.setText(data.getTopic_name());   //加载商品详情接受
//
//        viewHolder.itemTv2.setText(data.getTopic_join());
//
//
////        treasureIv = (ImageView) convertView.findViewById(R.id.treasure_iv);  //商品图片
////        detailsTv = (TextView) convertView.findViewById(R.id.details_tv);  //商品详情介绍
////        priceTv = (TextView) convertView.findViewById(R.id.price_tv);   //商品价格
////        numberMinus = (TextView) convertView.findViewById(R.id.number_minus);   //减少一件该商品
////        numberTv = (TextView) convertView.findViewById(R.id.number_tv);   //要购买商品的数量
////        numberPlus = (TextView) convertView.findViewById(R.id.number_plus);   //增加一件该商品
////        checkboxShipments= (CheckBox) convertView.findViewById(R.id.checkbox_shipments); //购买商品发货方式
////        checkboxItem= (CheckBox) convertView.findViewById(R.id.checkbox_item); //购买商品单选
//
////        //holder.itemView ViewHolder所对应的子View
////        holder.itemView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                itemClickListener.itemClick(holder.itemView, holder.getLayoutPosition());
////            }
////        });
////
////        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
////            @Override
////            public boolean onLongClick(View view) {
////                itemLongClickListener.itemLongCilck(holder.itemView, holder.getLayoutPosition());
////                return true;
////            }
////        });
//    }
//
//    //返回数据源长度
//    @Override
//    public int getItemCount() {
//        return datas.size();
//    }
//
//    //自定义ViewHolder
//    class MyViewHolder extends RecyclerView.ViewHolder{
//
//        ImageView treasureIv;
//        TextView detailsTv,priceTv,numberMinus,numberTv,numberPlus;
//        CheckBox checkboxShipments,checkboxItem;
//
//
//        public MyViewHolder(View convertView) {
//            super(convertView);
//            treasureIv = (ImageView) convertView.findViewById(R.id.treasure_iv);  //商品图片
//            detailsTv = (TextView) convertView.findViewById(R.id.details_tv);  //商品详情介绍
//            priceTv = (TextView) convertView.findViewById(R.id.price_tv);   //商品价格
//            numberMinus = (TextView) convertView.findViewById(R.id.number_minus);   //减少一件该商品
//            numberTv = (TextView) convertView.findViewById(R.id.number_tv);   //要购买商品的数量
//            numberPlus = (TextView) convertView.findViewById(R.id.number_plus);   //增加一件该商品
//            checkboxShipments= (CheckBox) convertView.findViewById(R.id.checkbox_shipments); //购买商品发货方式
//            checkboxItem= (CheckBox) convertView.findViewById(R.id.checkbox_item); //购买商品单选
//
//
//            //itemView ViewHolder所对应的子View
////            itemView.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View view) {
////                    itemClickListener.itemClick(itemView, getLayoutPosition());
////                }
////            });
////
////                    itemView.setOnLongClickListener(new View.OnLongClickListener() {
////                @Override
////                public boolean onLongClick(View view) {
////                    itemLongClickListener.itemLongCilck(itemView, getLayoutPosition());
////                    return true;
////                }
////            });
//
//        }
//    }
//
//    ///////////////////////////////////////////////////////////////////////////
//    // 以下方法为UI界面刷新方法
//    ///////////////////////////////////////////////////////////////////////////
//    //重新加载资源
//    public void reloadRecyclerView(List<GridBean.DataBeanX.DataBean.ListBean> _datas) {
//        datas.addAll(_datas);
//        notifyDataSetChanged();
//    }
//
//    //适配器中添加单条数据，刷新UI
//    public void addItem(GridBean.DataBeanX.DataBean.ListBean data, int position) {
//        datas.add(position, data);
//        notifyItemInserted(position);
//    }
//
//
//}
