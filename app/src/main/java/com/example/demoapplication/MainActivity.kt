package com.example.demoapplication

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapplication.data.network.ApiClient
import com.example.demoapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.edu_tip.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<HomeViewModel>()
    private val homeRecyclerViewAdapter = HomeRecyclerViewAdapter()
    lateinit var myadapter:DataAdpter
    lateinit var eduType: HomeRecyclerViewItem.EduType


    // lateinit var progerssProgressDialog: ProgressDialog
    var dataList = ArrayList<DataModel>()
   // lateinit var recyclerView: RecyclerView
    lateinit var adapter:DataAdpter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //setting up the adapter
//        recyclerView.adapter= DataAdpter(dataList,this)
//        recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

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
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapter

            //callApi



            }
        }


    private fun getData() {
        val call: Call<List<DataModel>> = ApiClient.getClient.getData()
        call.enqueue(object : Callback<List<DataModel>> {

            override fun onResponse(
                call: Call<List<DataModel>>?,
                response: Response<List<DataModel>>?
            ) {
                print("res")
                if (response != null) {
               //     edutipTitle.text = response.body()?.get(1)?.feedType
                    response.body()?.let { print (it.size) }






                }
                // progerssProgressDialog.dismiss()
                dataList.addAll(response!!.body()!!)
                //    recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<DataModel>>?, t: Throwable?) {
                print("fail")
                //  progerssProgressDialog.dismiss()
            }

        })
    }







    }

