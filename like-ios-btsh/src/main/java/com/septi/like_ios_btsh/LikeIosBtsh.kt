package com.septi.like_ios_btsh

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.septi.like_ios_btsh.models.DialogItem
import kotlinx.android.synthetic.main.fragment_bottom_sheet.view.*
import java.util.*

class IosLikeBtsh() : BottomSheetDialogFragment() {

    private lateinit var mOnSelectionListener: OnSelectionListener

    companion object {
        fun show(
            fragmentManager: androidx.fragment.app.FragmentManager,
            title: String,
            options: ArrayList<DialogItem>,
            OnSelectionListener: OnSelectionListener
        ) =
            IosLikeBtsh().apply {
                this.mOnSelectionListener = OnSelectionListener
                this.options = options
                this.title = title
                show(fragmentManager, UUID.randomUUID().toString())
            }
    }

    private lateinit var adapter: DialogAdapter
    private lateinit var options: ArrayList<DialogItem>
    private lateinit var title: String

    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)
        val contentView = View.inflate(context, R.layout.fragment_bottom_sheet, null)
        dialog.setContentView(contentView)
        contentView.list_view_dialog.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                mOnSelectionListener.onSelection(options[position].text)
                dismiss()
            }
        adapter = DialogAdapter(context!!, options)
        contentView.tv_dialog_cancel.setOnClickListener {
            dismiss()
        }
        contentView.tv_dialog_title.text = title
        contentView.list_view_dialog.adapter = this.adapter
        adapter.notifyDataSetChanged()

        dialog.setOnShowListener {
            val d = it as BottomSheetDialog
            val bottomSheet = d.findViewById<View>(R.id.design_bottom_sheet)
            val behavior = BottomSheetBehavior.from(bottomSheet)
            bottomSheet?.let { sheet ->
                behavior.peekHeight = sheet.height
                sheet.parent.parent.requestLayout()
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.MarginLeftRightBottomSheetDialogTheme)
    }

    interface OnSelectionListener {
        fun onSelection(option: String)
    }
}

class DialogAdapter(private var context: Context, private var items: ArrayList<DialogItem>) :
    BaseAdapter() {
    private class ViewHolder(row: View?) {
        var optionName: TextView? = null

        init {
            this.optionName = row?.findViewById(R.id.tv_dialog)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.item_bottom_sheet, null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        val option = items[position]
        viewHolder.optionName?.text = option.text
        //viewHolder.optionName?.setTextColor(Color.parseColor(option.color))
        return view
    }

    override fun getItem(i: Int): DialogItem {
        return items[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }
}