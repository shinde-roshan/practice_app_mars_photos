package com.example.marsphotos

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.marsphotos.network.MarsPhoto
import com.example.marsphotos.overview.PhotoGridAdapter

@BindingAdapter("imgUrl")   //tells data binding to execute this binding adapter when a View item has the imageUrl attribute.
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUrl) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("listData")
fun bindingRecyclerView(recyclerView: RecyclerView, data: List<MarsPhoto>?)
{
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}