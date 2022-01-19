package com.inu.appcenter.retrofitstudy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RepoAdapter(var items: MutableList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.repo_item,parent,false)
        return RepoHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val repoName = items[position]
        when(holder) {
            is RepoHolder -> holder.bind(repoName)
        }
    }

    override fun getItemCount(): Int = items.size

    class RepoHolder(view: View): RecyclerView.ViewHolder(view){
        private val text : TextView = view.findViewById(R.id.repoName)

        fun bind(repoName:String){
            text.text = repoName
        }
    }

}