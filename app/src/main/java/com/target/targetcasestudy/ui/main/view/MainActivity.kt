package com.target.targetcasestudy.ui.main.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.model.ProductsItem
import com.target.targetcasestudy.ui.main.adapter.FragmentCallback
import com.target.targetcasestudy.ui.payment.PaymentDialogFragment

class MainActivity : AppCompatActivity(), FragmentCallback {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    supportFragmentManager.beginTransaction()
      .replace(R.id.container,
        DealListFragment()
      )
      .commit()
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.menu_main, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
      R.id.credit_card -> {
        PaymentDialogFragment().show(supportFragmentManager, "CreditCardValidation")
        true
      }
      else -> false
    }
  }

  override fun onClickCell(fragment: DealListFragment?, productsItem: ProductsItem?) {
    supportFragmentManager.beginTransaction()
            .replace(R.id.container,
                    DealItemFragment(productsItem)
            )
            .commit()  }
}
