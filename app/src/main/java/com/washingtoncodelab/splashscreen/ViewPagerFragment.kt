package com.washingtoncodelab.splashscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2

class ViewPagerFragment : Fragment() {
private lateinit var viewpager2:ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)
        viewpager2 = view.findViewById(R.id.viewPager2)
        val fragmentList:ArrayList<Fragment> = arrayListOf<Fragment>(
            Fragment1(),
            Fragment2(),
            Fragment3()
        )
        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        viewpager2.adapter = adapter

        return view
    }

}