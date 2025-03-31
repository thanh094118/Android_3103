package com.example.a313

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a313.adapter.SinhVienAdapter
import com.example.a313.data.SinhVien
import com.example.a313.data.SinhVienRepository

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var sinhVienAdapter: SinhVienAdapter
    private val sinhVienRepository = SinhVienRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtHoTen = findViewById<EditText>(R.id.edtHoTen)
        val edtMSSV = findViewById<EditText>(R.id.edtMSSV)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        recyclerView = findViewById(R.id.recyclerView)

        sinhVienAdapter = SinhVienAdapter(sinhVienRepository.getAll().toMutableList()) { position ->
            xoaSinhVien(position)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = sinhVienAdapter

        btnAdd.setOnClickListener {
            val hoTen = edtHoTen.text.toString().trim()
            val mssv = edtMSSV.text.toString().trim()
            if (hoTen.isNotEmpty() && mssv.isNotEmpty()) {
                themSinhVien(hoTen, mssv)
                edtHoTen.text.clear()
                edtMSSV.text.clear()
            }
        }
    }

    private fun themSinhVien(hoTen: String, mssv: String) {
        sinhVienRepository.addSinhVien(SinhVien(hoTen, mssv))
        sinhVienAdapter.capNhatDanhSach(sinhVienRepository.getAll().toMutableList())
    }

    private fun xoaSinhVien(position: Int) {
        sinhVienRepository.removeSinhVien(position)
        sinhVienAdapter.capNhatDanhSach(sinhVienRepository.getAll().toMutableList())
    }
}
