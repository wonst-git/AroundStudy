package com.aroundstudy.ui.activity.search

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.activity.viewModels
import com.aroundstudy.R
import com.aroundstudy.base.BaseActivity
import com.aroundstudy.databinding.ActivitySearchAddressBinding
import com.aroundstudy.ui.activity.search.adapter.SearchAddressAdapter
import com.aroundstudy.ui.activity.search.viewmodel.SearchAddressViewModel
import com.aroundstudy.util.constants.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchAddressActivity : BaseActivity(), TextWatcher {
    override val binding: ActivitySearchAddressBinding by lazy { ActivitySearchAddressBinding.inflate(layoutInflater) }
    override val viewModel: SearchAddressViewModel by viewModels()

    private var nowLocation: String? = null
    private var editSearch: EditText? = null
    private var searchAddressAdapter: SearchAddressAdapter? = null

    private val addressClick: (address: String) -> Unit = {
        intent.putExtra(Constants.ActivityExtra.SEARCH_ADDRESS_EXTRA, it)
        setResult(RESULT_OK, intent)
        finish()
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v) {
            binding.btnSetNowLocation -> {
                intent.putExtra(Constants.ActivityExtra.SEARCH_ADDRESS_EXTRA, nowLocation)
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        viewModel.getSearchAddress(editSearch?.text.toString())
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun afterTextChanged(s: Editable?) {
    }

    override fun onDestroy() {
        super.onDestroy()
        editSearch?.removeTextChangedListener(this)
    }

    override fun initData() {
        if (intent.hasExtra(Constants.ActivityExtra.SEARCH_ADDRESS_EXTRA)) {
            nowLocation = intent.getStringExtra(Constants.ActivityExtra.SEARCH_ADDRESS_EXTRA)
        }
    }

    override fun initLayout() {
        setTitleType(listOf(Constants.TitleType.BTN_BACK, Constants.TitleType.SEARCH))
        editSearch = getTitleView(R.id.editSearch) as EditText?
        editSearch?.hint = getString(R.string.com_location_dong_eup_myeon)

        binding.btnSetNowLocation.isEnabled = !nowLocation.isNullOrEmpty()
        searchAddressAdapter = SearchAddressAdapter(viewModel.addressList, addressClick)
        binding.addressList.adapter = searchAddressAdapter
    }

    override fun initListener() {
        editSearch?.addTextChangedListener(this)
//        editSearch?.setOnEditorActionListener { v, actionId, event ->
//            if (actionId == EditorInfo.IME_ACTION_DONE) {
//                viewModel.getSearchAddress(editSearch?.text.toString())
//            }
//            false
//        }
        binding.btnSetNowLocation.setOnClickListener(this)
    }

    override fun initObserve() {
        viewModel.addressList.observe(this) {
            binding.addressList.adapter = searchAddressAdapter
        }
    }
}