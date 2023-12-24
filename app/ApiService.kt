import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users") // Sesuaikan dengan endpoint API yang Anda inginkan dari Regres.in
    fun getUsers(@Query("page") page: Int, @Query("per_page") perPage: Int): Call<List<User>>
}
