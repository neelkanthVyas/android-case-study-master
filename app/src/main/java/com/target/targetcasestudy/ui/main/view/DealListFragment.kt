package com.target.targetcasestudy.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.api.ApiHelper
import com.target.targetcasestudy.data.api.RetrofitBuilder
import com.target.targetcasestudy.data.model.ListOfItems
import com.target.targetcasestudy.ui.base.ViewModelFactory
import com.target.targetcasestudy.ui.main.adapter.DealItemAdapter
import com.target.targetcasestudy.ui.main.viewmodel.DealListViewModel
import com.target.targetcasestudy.utils.Status
import kotlinx.android.synthetic.main.fragment_deal_list.*


class DealListFragment : Fragment() {

  private lateinit var viewModel: DealListViewModel
  private lateinit var adapter: DealItemAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setupViewModel()
  }

  private fun setupViewModel() {
    viewModel = ViewModelProviders.of(
      this,
      ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
    ).get(DealListViewModel::class.java)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setupUI()
    setupObservers()
  }

  private fun setupUI() {
    recycler_view.layoutManager = LinearLayoutManager(activity)
    adapter = DealItemAdapter(arrayListOf())
    val dividerItemDecoration = DividerItemDecoration(
      recycler_view.context,
      (recycler_view.layoutManager as LinearLayoutManager).orientation
    )
    recycler_view.addItemDecoration(dividerItemDecoration)
    recycler_view.adapter = adapter
  }

  private fun setupObservers() {
    viewModel.getListOfItems().observe(this, Observer {
      it?.let { resource ->
        when (resource.status) {
          Status.SUCCESS -> {
            recycler_view.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
            resource.data?.let { items -> retrieveList(items) }
          }
          Status.ERROR -> {
            recycler_view.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
            Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
          }
          Status.LOADING -> {
            progressBar.visibility = View.VISIBLE
            recycler_view.visibility = View.GONE
          }
        }
      }
    })
  }

  private fun retrieveList(list: ListOfItems) {
    adapter.apply {
      addItems(list.products)
      notifyDataSetChanged()
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_deal_list, container, false)
  }
}
