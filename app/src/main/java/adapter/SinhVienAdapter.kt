package com.example.a313.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a313.R
import com.example.a313.data.SinhVien

class SinhVienAdapter(
    private var danhSachSinhVien: MutableList<SinhVien>,  // Đổi từ val sang var để cập nhật dữ liệu
    private val onDelete: (Int) -> Unit
) : RecyclerView.Adapter<SinhVienAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtHoTen: TextView = view.findViewById(R.id.txtHoTen)
        val txtMSSV: TextView = view.findViewById(R.id.txtMSSV)
        val btnDelete: ImageButton = view.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sinhvien, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sinhVien = danhSachSinhVien[position]
        holder.txtHoTen.text = sinhVien.hoTen
        holder.txtMSSV.text = sinhVien.mssv

        holder.btnDelete.setOnClickListener {
            onDelete(position)
        }
    }

    override fun getItemCount(): Int = danhSachSinhVien.size

    // Hàm cập nhật danh sách
    fun capNhatDanhSach(moiDanhSach: MutableList<SinhVien>) {
        danhSachSinhVien = moiDanhSach
        notifyDataSetChanged()
    }
}
