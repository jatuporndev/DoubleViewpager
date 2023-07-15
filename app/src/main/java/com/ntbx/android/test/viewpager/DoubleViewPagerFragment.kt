package com.ntbx.android.test.viewpager

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.viewpager2.widget.MarginPageTransformer
import com.google.android.material.tabs.TabLayoutMediator
import com.ntbx.android.test.viewpager.databinding.FragmentDoubleViewPagerBinding
import com.ntbx.android.test.viewpager.models.LoanData


class DoubleViewPagerFragment : Fragment() {

    lateinit var binding: FragmentDoubleViewPagerBinding
    lateinit var loanCardAdapter: LoanCardAdapter
    lateinit var loanInfoAdapter: LoanInfoAdapter

    private val data = MutableLiveData<List<LoanData>>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDoubleViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loanCardAdapter = LoanCardAdapter()
        loanInfoAdapter = LoanInfoAdapter()

        val loanDataList = ArrayList<LoanData>()
        loanDataList.add(
            LoanData(
                name = "test1",
                detail = "dddd"
            ),
        )
        loanDataList.add(
            LoanData(
                name = "test2",
                detail = "dddd"
            ),
        )
        loanDataList.add(
            LoanData(
                name = "test3",
                detail = "dddd"
            ),
        )

        data.observe(viewLifecycleOwner) {
            loanCardAdapter.submitList(loanDataList)
            loanInfoAdapter.submitList(loanDataList)
        }

        binding.pager1.adapter = loanCardAdapter
        binding.pager2.adapter = loanInfoAdapter

        setUpPreviewPager()
        data.postValue(loanDataList)
    }

    private fun setUpPreviewPager() {
        val offsetPx = 16.dpToPx(resources.displayMetrics)
        val pageMarginPx = 8.dpToPx(resources.displayMetrics)
        val marginTransformer = MarginPageTransformer(pageMarginPx)

        binding.pager1.apply {
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 2
            setPadding(offsetPx, 0, offsetPx, 0)
            setPageTransformer(marginTransformer)
        }

        TabLayoutMediator(binding.tabIndicator, binding.pager1) { _, _ -> }.attach()
        TabLayoutMediator(binding.tabIndicator, binding.pager2) { _, _ -> }.attach()
    }

    private fun Int.dpToPx(displayMetrics: DisplayMetrics): Int = (this * displayMetrics.density).toInt()

}