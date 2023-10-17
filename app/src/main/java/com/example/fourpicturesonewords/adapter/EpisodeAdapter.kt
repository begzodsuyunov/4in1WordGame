package com.example.fourpicturesonewords.adapter

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fourpicturesonewords.R
import com.example.fourpicturesonewords.databinding.ItemEpisodeBinding
import com.example.fourpicturesonewords.model.MusicStart
import com.example.fourpicturesonewords.model.Pictures
import com.example.fourpicturesonewords.utils.MySharedPreference

class EpisodeAdapter(
    var list: List<Pictures>,
    val context: Context,
    val onClick: (picture: Pictures, pos: Int) -> Unit
) : RecyclerView.Adapter<EpisodeAdapter.ViewHolder>() {

    private lateinit var itemClickSound: MediaPlayer

    inner class ViewHolder(private var binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {


        private val sharedPreference: MySharedPreference? = MySharedPreference.getInstance(context)
        fun onBind(picture: Pictures, pos: Int) {
            itemClickSound = MusicStart.startMusic(context, R.raw.item_click)
            itemView.setOnClickListener {
                onClick(picture, pos)
                if (sharedPreference?.sound == true) {
                    itemClickSound.start()
                } else {
                    itemClickSound.pause()
                }

            }
            binding.item.isClickable = true
            val level: Int = sharedPreference?.level!!
            if (pos < level) {
                binding.image.setImageResource(R.drawable.ic_baseline_check_24)
                binding.item.alpha = 1f
            } else if (pos == level) {
                binding.image.setImageResource(R.drawable.ic_baseline_keyboard_arrow_right_24)
                binding.item.alpha = 1f
            } else {
                binding.item.isClickable = false
                binding.image.setImageResource(R.drawable.ic_baseline_lock_24)
                binding.item.alpha = 0.5f
            }
            binding.episode.text = "Level " + (pos + 1)
            binding.imageOneS.setImageResource(list[pos].picturesOne)
            binding.imageTwoS.setImageResource(list[pos].picturesTwo)
            binding.imageThreeS.setImageResource(list[pos].picturesThree)
            binding.imageFourS.setImageResource(list[pos].picturesFour)

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeAdapter.ViewHolder {
        return ViewHolder(
            ItemEpisodeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: EpisodeAdapter.ViewHolder, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size


}