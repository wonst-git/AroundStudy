package com.aroundstudy.ui.fragment.study.detail

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import com.aroundstudy.R
import com.aroundstudy.base.BaseFragment
import com.aroundstudy.data.datamodel.server.study.StudyDataEntity
import com.aroundstudy.databinding.FragmentStudyInfoBinding
import com.aroundstudy.ui.activity.study.MemberListActivity
import com.aroundstudy.ui.activity.study.StudyDetailActivity
import com.aroundstudy.ui.activity.study.viewmodel.StudyDetailViewModel
import com.aroundstudy.ui.fragment.study.detail.adapter.MembersAdapter
import com.aroundstudy.ui.fragment.study.detail.adapter.SuggestStudyAdapter
import com.aroundstudy.util.constants.Constants

class StudyInfoFragment : BaseFragment(), View.OnClickListener {
    private lateinit var _binding: FragmentStudyInfoBinding
    override val binding get() = _binding

    private val viewModel: StudyDetailViewModel by activityViewModels()

    private var memberListAdapter: MembersAdapter? = null

    private val onStudyClick: (StudyDataEntity) -> Unit = {
        startStudyDetailActivity(it)
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.btnViewMember -> {
                startMemberListActivity()
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentStudyInfoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun initData() {

    }

    override fun initLayout() {
        memberListAdapter = MembersAdapter()
        binding.memberList.adapter = memberListAdapter
    }

    override fun initListener() {
        binding.btnViewMember.setOnClickListener(this)
    }

    override fun initObserve() {
        viewModel.studyData.observe(this) {
            binding.txtCategory.text = it.category
            binding.txtStudyTitle.text = it.title
            binding.txtProcess.text = it.process
            binding.txtPlace.text = it.place
            binding.txtMeetTime.text = it.time
            binding.txtHeadcount.text = getString(R.string.study_members_count_format, it.members.size, it.maxNumberPeople)

            setContent(3, it.content, true)

            memberListAdapter?.submitList(it.members)
        }
        viewModel.suggestStudyList.observe(this) {
            binding.suggestStudyList.adapter = SuggestStudyAdapter(it, onStudyClick)
        }
    }

    private fun setContent(maxLines: Int, content: String, isMore: Boolean) {
        binding.txtStudyContent.text = content

        binding.txtStudyContent.post {
            if (isMore) {
                if (binding.txtStudyContent.lineCount > maxLines) {
                    val moreClick = object : ClickableSpan() {
                        override fun onClick(widget: View) {
                            setContent(0, viewModel.studyData.value?.content.toString(), false)
                        }

                        override fun updateDrawState(ds: TextPaint) {
                            super.updateDrawState(ds)
                            ds.color = ContextCompat.getColor(requireContext(), R.color.color_868686)
                            ds.isUnderlineText = true
                        }
                    }

                    val lastChar = binding.txtStudyContent.layout.getLineVisibleEnd(maxLines - 1)

                    binding.txtStudyContent.maxLines = maxLines

                    val moreString = getString(R.string.study_content_ellipsize) + " " + getString(R.string.study_content_more)

                    val actionDisplayText = content.substring(0, lastChar - 5) + moreString

                    val spannableString = SpannableString(actionDisplayText)
                    val startIndex = actionDisplayText.lastIndexOf(getString(R.string.study_content_more))

                    spannableString.apply {
                        setSpan(moreClick, startIndex, spannableString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                    }

                    binding.txtStudyContent.text = spannableString
                    binding.txtStudyContent.movementMethod = LinkMovementMethod.getInstance()
                }
                binding.txtStudyContent.setOnClickListener(null)
            } else {
                binding.txtStudyContent.maxLines = 9999

                binding.txtStudyContent.setOnClickListener {
                    setContent(3, viewModel.studyData.value?.content.toString(), true)
                }
            }
        }
    }

    private fun startMemberListActivity() {
        val memberListIntent = Intent(requireActivity(), MemberListActivity::class.java)
            .putExtra(Constants.ActivityExtra.STUDY_MEMBER_EXTRA, viewModel.studyData.value?.members)

        startActivity(memberListIntent)
        requireActivity().overridePendingTransition(R.anim.slide_in_rtl, R.anim.slide_out_rtl)
    }

    private fun startStudyDetailActivity(studyData: StudyDataEntity) {
        val studyDetailIntent = Intent(requireActivity(), StudyDetailActivity::class.java)
            .putExtra(Constants.ActivityExtra.STUDY_DATA_EXTRA, studyData)

        startActivity(studyDetailIntent)
        requireActivity().overridePendingTransition(R.anim.slide_in_rtl, R.anim.slide_out_rtl)
    }
}