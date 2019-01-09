package com.yf.milling.ui.fragment

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.yf.base.ext.enable
import com.yf.base.ext.onClick
import com.yf.base.ui.fragment.BaseFragment
import com.yf.base.ui.fragment.BaseMvpFragment
import com.yf.milling.data.protocol.MillingInfo
import com.yf.milling.injection.component.DaggerMillingComponent
import com.yf.milling.injection.module.MillingModule
import com.yf.milling.presenter.UploadDataPresenter
import com.yf.milling.presenter.view.UploadDataView
import com.yf.milling.ui.adapter.MillingToolAdapter
import com.yf.toolchanging.R
import kotlinx.android.synthetic.main.left_fragment.*

import org.jetbrains.anko.support.v4.toast

class LeftMenuFragment : BaseFragment() {

    private lateinit var mAdapter: MillingToolAdapter
    private var mUserName:String? = null
    private var mUserGender:String? = null
    private var mUserSign:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.left_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
