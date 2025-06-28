import com.example.roadmapandroid.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("products")
    fun getProduct(): Call<List<Product>>
}