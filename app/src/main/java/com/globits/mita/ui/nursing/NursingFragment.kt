package com.globits.mita.ui.nursing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.globits.mita.R
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.databinding.FragmentNursingBinding
import com.globits.mita.ui.MainActivity
import com.globits.mita.ui.patients.ListPatientFragment
import com.globits.mita.ui.patients.SetLayoutListPatientFragment


class NursingFragment : MitaBaseFragment<FragmentNursingBinding>() {

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNursingBinding {
        return FragmentNursingBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        views.content.setContent {
            SetLayoutListPatientFragment() {
                (activity as MainActivity).navigateTo(R.id.action_nursingFragment_to_patientInfoFragment)
            }
        }
    }

}