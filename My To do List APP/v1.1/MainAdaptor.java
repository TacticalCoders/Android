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

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

//어댑터, 즉 ArrayList<객체>에 저장되어 있는 데이터와 리사이클 뷰의 어댑터를 의미한다.
public class MainAdaptor extends RecyclerView.Adapter<MainAdaptor.CustomViewHolder>{

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
                //remove(holder.getAdapterPosition());

                //PopupMenu객체 생성.
                //생성자함수의 첫번재 파라미터 : Context
                //생성자함수의 두번째 파라미터 : Popup Menu를 붙일 anchor 뷰
                PopupMenu popup = new PopupMenu(v.getContext(), v);

                //Popup Menu에 들어갈 MenuItem 추가.
                //이전 포스트의 컨텍스트 메뉴(Context menu)처럼 xml 메뉴 리소스 사용
                //첫번재 파라미터 : res폴더>>menu폴더>>menu_listview.xml파일 리소스
                //두번재 파라미터 : Menu 객체->Popup Menu 객체로 부터 Menu 객체 얻어오기
                popup.getMenuInflater().inflate(R.menu.menu_listview,popup.getMenu());

                //Popup menu의 메뉴아이템을 눌렀을  때 보여질 ListView 항목의 위치
                //Listener 안에서 사용해야 하기에 final로 선언
                final int index = position;

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()){

                            case R.id.modify:

                                /*
                                final Dialog ed = new Dialog(MainActivity.this);
                                ed.setContentView(R.layout.custom_dialog);
                                ed.setTitle("수정하기");

                                final EditText et = (EditText)ed.findViewById(R.id.et_edit);
                                final Button btn_okay = (Button)ed.findViewById(R.id.btn_okay);
                                final Button btn_cancel = (Button)ed.findViewById(R.id.btn_cancel);

                                btn_okay.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        CheckedTextView ct = (CheckedTextView) view;
                                        String result = et.getText().toString();
                                        ct.setText(result);
                                        listdata.remove(position);
                                        listdata.add(position,result);
                                        ed.dismiss();
                                    }
                                });

                                btn_cancel.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        ed.dismiss();
                                    }
                                });

                                adapter.notifyDataSetChanged();
                                ed.show();
                                 */
                                //Dialog종료
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
