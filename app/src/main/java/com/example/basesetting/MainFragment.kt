package com.example.basesetting

import com.example.basesetting.base.UtilityBase
import com.example.basesetting.databinding.FragmentMainBinding

class MainFragment : UtilityBase.BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    override fun FragmentMainBinding.onCreateView() {

    }

    override fun FragmentMainBinding.onViewCreated() {
        binding.tvFragment.text = "Fragment"
    }
}