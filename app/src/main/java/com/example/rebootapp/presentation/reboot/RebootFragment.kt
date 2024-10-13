package com.example.rebootapp.presentation.reboot

import com.example.rebootapp.databinding.FragmentRebootBinding
import com.example.rebootapp.presentation.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.getViewModel


class RebootFragment : BaseFragment<FragmentRebootBinding, RebootViewModel>() {

    override val viewModel: RebootViewModel
        get() = getViewModel()

    override fun getViewBinding(): FragmentRebootBinding =
        FragmentRebootBinding.inflate(layoutInflater)


    override fun initView() {
      //Add recycler view list
    }
}