package com.example.demoapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoapplication.data.network.ApiClient
import com.example.demoapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.edu_tip.*
import kotlinx.android.synthetic.main.top_post.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.ViewModelProviders


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<HomeViewModel>()
    private val homeRecyclerViewAdapter = HomeRecyclerViewAdapter()
    lateinit var myadapter:HomeRecyclerViewAdapter
    lateinit var eduType: HomeRecyclerViewItem.EduType
    // lateinit var vm: HomeViewModel


    // lateinit var progerssProgressDialog: ProgressDialog
    var dataList = ArrayList<HomeRecyclerViewItem>()
   // lateinit var recyclerView: RecyclerView
    lateinit var adapter:HomeRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = homeRecyclerViewAdapter
        }





//        viewModel.homeListItemsLiveData.observe(this){ result ->
//            when(result){
//                is Resource.Failure -> {
//                    binding.progressBar.hide()
//                    //handle failure case here
//                }
//                Resource.Loading -> binding.progressBar.show()
//                is Resource.Success<*> -> {
//                    binding.progressBar.hide()
//                    homeRecyclerViewAdapter.items = result.value as List<HomeRecyclerViewItem>
//                }
//            }
//        }
        getData()

        }


    private fun getData() {
        val call: Call<List<HomeRecyclerViewItem>> = ApiClient.getClient.getData()
        call.enqueue(object : Callback<List<HomeRecyclerViewItem>> {

            override fun onResponse(
                call: Call<List<HomeRecyclerViewItem>>?,
                response: Response<List<HomeRecyclerViewItem>>?
            ) {
                print("res")
                if (response != null) {
               //     edutipTitle.text = response.body()?.get(1)?.feedType
                    response.body()?.let { print (it.size) }

                    maintextView.text = response.body()?.get(0)?.feedType
                }
                // progerssProgressDialog.dismiss()
                if (response != null) {
                    homeRecyclerViewAdapter.items = response.body() as List<HomeRecyclerViewItem>

                    print( homeRecyclerViewAdapter.items[0])



                }

                dataList.addAll(response!!.body()!!)
                    recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<HomeRecyclerViewItem>>?, t: Throwable?) {
                print("fail")
                //  progerssProgressDialog.dismiss()
            }

        })
    }

    }

