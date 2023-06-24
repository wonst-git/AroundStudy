package com.aroundstudy.ui.fragment.input

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import com.aroundstudy.R
import com.aroundstudy.base.BaseActivity
import com.aroundstudy.base.BaseFragment
import com.aroundstudy.databinding.FragmentInputRegionBinding
import com.aroundstudy.ui.activity.start.login.viewmodel.InputViewModel
import com.aroundstudy.ui.activity.search.SearchAddressActivity
import com.aroundstudy.util.LogUtil
import com.aroundstudy.util.constants.Constants

class InputRegionFragment : BaseFragment(), View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private lateinit var _binding: FragmentInputRegionBinding
    override val binding get() = _binding

    private val viewModel by activityViewModels<InputViewModel>()

    private var myLocation: Location? = null

    private val searchAddressResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == RESULT_OK) {
            viewModel.setRegion(it.data?.getStringExtra(Constants.ActivityExtra.SEARCH_ADDRESS_EXTRA) ?: "")
        }
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        viewModel.regionRange = progress
        LogUtil.d("progress: $progress")
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {}

    override fun onStopTrackingTouch(seekBar: SeekBar?) {}

    override fun onClick(v: View?) {
        when (v) {
            binding.btnClear -> {
                viewModel.setRegion("")
            }
            binding.btnSearch -> {
                startSearchAddressActivity()
            }
            binding.btnSetLocation -> {
                viewModel.setRegion(binding.txtMyLocation.text.toString())
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentInputRegionBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun initData() {
        myLocation = (requireActivity() as BaseActivity).getLocation()
    }

    override fun initLayout() {
        myLocation?.let {
            viewModel.getCoordToAddress(it.latitude, it.longitude)
        } ?: kotlin.run {
            binding.txtMyLocation.text = getString(R.string.input_location_fail)
            binding.btnSetLocation.isEnabled = false
        }
    }

    override fun initListener() {
        binding.btnClear.setOnClickListener(this)
        binding.btnSetLocation.setOnClickListener(this)
        binding.btnSearch.setOnClickListener(this)
        binding.seekRegionRange.setOnSeekBarChangeListener(this)
    }

    override fun initObserve() {
        viewModel.region.observe(this) {
            binding.layoutSetNone.isVisible = it.isEmpty()
            binding.layoutSetRegion.isVisible = it.isNotEmpty()
            if (it.isEmpty()) {
                binding.seekRegionRange.progress = 1
            }
            binding.txtRegion.text = it
        }
        viewModel.coordAddress.observe(this) {
            if (it == null || it.documents.isEmpty()) {
                binding.txtMyLocation.text = getString(R.string.input_location_fail)
                binding.btnSetLocation.isEnabled = false
            } else {
                binding.txtMyLocation.text = listOf(it.documents.first().address.region1DepthName, it.documents.first().address.region2DepthName, it.documents.first().address.region3DepthName).joinToString(" ")
                binding.btnSetLocation.isEnabled = true
            }
        }
    }

    private fun startSearchAddressActivity() {
        val searchAddressIntent = Intent(requireContext(), SearchAddressActivity::class.java)
        if (binding.btnSetLocation.isEnabled) {
            searchAddressIntent.putExtra(Constants.ActivityExtra.SEARCH_ADDRESS_EXTRA, binding.txtMyLocation.text.toString())
        }
        searchAddressResult.launch(searchAddressIntent)
        requireActivity().overridePendingTransition(R.anim.slide_in_rtl, R.anim.slide_out_rtl)
    }
}