package com.target.targetcasestudy.ui.main.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.api.ApiHelper
import com.target.targetcasestudy.data.api.RetrofitBuilder
import com.target.targetcasestudy.data.model.ItemDetails
import com.target.targetcasestudy.data.model.ProductsItem
import com.target.targetcasestudy.ui.base.ViewModelFactory
import com.target.targetcasestudy.ui.main.viewmodel.DealItemViewModel
import com.target.targetcasestudy.utils.Status
import kotlinx.android.synthetic.main.fragment_deal_item.*

class DealItemFragment(private var productsItem: ProductsItem?) : Fragment() {

  private lateinit var viewModel: DealItemViewModel

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_deal_item, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setupObservers()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setupViewModel()
  }

  private fun setupViewModel() {
    viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
    ).get(DealItemViewModel::class.java)
  }

  private fun setupObservers() {
    viewModel.getDetailsOfTheItem(productsItem?.id).observe(this, Observer {
      it?.let { resource ->
        when (resource.status) {
          Status.SUCCESS -> {
            setProgressbarVisibility(View.GONE)
            setVisibiltyForViews(View.VISIBLE)
            resource.data?.let { items -> setTheData(items) }
          }
          Status.ERROR -> {
            setProgressbarVisibility(View.GONE)
            setVisibiltyForViews(View.VISIBLE)
            Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
          }
          Status.LOADING -> {
            setProgressbarVisibility(View.VISIBLE)
            setVisibiltyForViews(View.GONE)
          }
        }
      }
    })
  }

  @SuppressLint("SetTextI18n")
  private fun setTheData(items: ItemDetails) {
    tvOrgPrice.text = items.salePrice?.displayString ?: BASE_VALUE
    tvNewPrice.text = getString(R.string.line,(items.regularPrice?.displayString ?: BASE_VALUE))
    tvTitle.text =items.title
    tvSummary.text =items.description
    Glide.with(ivHolder.context)
            .load(items.imageUrl)
            .into(ivHolder)
  }

  private fun setVisibiltyForViews(visible: Int) {
    ivHolder.visibility = visible
    tvOrgPrice.visibility = visible
    tvNewPrice.visibility = visible
    tvTitle.visibility =visible
    tvSummary.visibility =visible
    clBottomLayout.visibility =visible
  }

  private fun setProgressbarVisibility(visible: Int){
    progress_bar.visibility = visible
  }

  companion object{
    const val BASE_VALUE ="$0.0"
  }

}
