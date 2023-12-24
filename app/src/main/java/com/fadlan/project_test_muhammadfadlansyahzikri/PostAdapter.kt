import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fadlan.project_test_muhammadfadlansyahzikri.PostResponse
import com.fadlan.project_test_muhammadfadlansyahzikri.databinding.ItemPostBinding

class PostAdapter(private val list: List<PostResponse>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(postResponse: PostResponse) {
            val text = "id: ${postResponse.id}\n" +
                    "email:${postResponse.email}\n" +
                    "first_name:${postResponse.first_name}\n" +
                    "last_name:${postResponse.last_name}\n" +
                    "avatar:${postResponse.avatar}"
            binding.tvText.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPostBinding.inflate(inflater, parent, false)
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(list[position])
    }
}
