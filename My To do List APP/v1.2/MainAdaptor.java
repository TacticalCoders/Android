package com.example.recyclerviewex2;

import android.app.Dialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

//어댑터, 즉 ArrayList<객체>에 저장되어 있는 데이터와 리사이클 뷰의 어댑터를 의미한다.
public class MainAdaptor extends RecyclerView.Adapter<MainAdaptor.CustomViewHolder>{

    static final int GET_STRING = 1;

    private ArrayList<MainData> arrayList; //MainData객체를 저장하는 ArrayList 레퍼런스 변수 생성.

    public MainAdaptor(ArrayList<MainData> arrayList) { this.arrayList = arrayList; } //인자로부터 ArryList를 받아 해당 필드에 넣어주는 생성자.

    @Override //레이아웃을 받아와서 커스텀뷰 홀더 객체를 생성 후 반환.
    public MainAdaptor.CustomViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }



    @Override //뷰 홀더를 통해 연결된 변수에다가 ArrayList로부터 데이터를 받아 값을 저장한다.
    public void onBindViewHolder(MainAdaptor.CustomViewHolder holder, int position) {
        holder.btn_check.setImageResource(arrayList.get(position).getBtn_check());
        holder.tv_content.setText(arrayList.get(position).getTv_content());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curContent = holder.tv_content.getText().toString();
                Toast.makeText(v.getContext(),curContent,Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                PopupMenu popup = new PopupMenu(v.getContext(), v);

                popup.getMenuInflater().inflate(R.menu.menu_listview,popup.getMenu());


                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()){

                            case R.id.modify:
                                final Dialog editDialog = new Dialog(v.getContext());
                                editDialog.setContentView(R.layout.custom_dialog);
                                editDialog.setTitle("To-Do-List 수정");

                                final EditText et_edit = (EditText) editDialog.findViewById(R.id.et_edit);
                                Button btn_okay = (Button) editDialog.findViewById(R.id.btn_okay);
                                Button btn_cancel = (Button) editDialog.findViewById(R.id.btn_cancel);

                                et_edit.setText(arrayList.get(position).getTv_content());

                                btn_cancel.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        editDialog.dismiss();
                                    }
                                });

                                btn_okay.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        String result = et_edit.getText().toString();
                                        arrayList.get(position).setTv_content(result);
                                        notifyDataSetChanged();
                                        editDialog.dismiss();
                                    }
                                });
                                editDialog.show();
                                break;


                            case R.id.delete:
                                remove(holder.getAdapterPosition());
                                notifyItemRemoved(position);
                                break;
                        }
                        return false;
                    }
                });
                popup.show();

                return true;
            }

        });
    }



    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public void remove(int position){ //직접 구현한 삭제 메소드.
        try{
            arrayList.remove(position);
            notifyItemRemoved(position);
        }catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
    }



    public class CustomViewHolder extends RecyclerView.ViewHolder{ //본 클래스에서 사용할 변수와 id를 연결해주는 과정

        protected ImageButton btn_check;
        protected TextView tv_content;

        public CustomViewHolder(View itemView) {
            super(itemView);
            this.btn_check = (ImageButton) itemView.findViewById(R.id.btn_check);
            this.tv_content = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }

}
