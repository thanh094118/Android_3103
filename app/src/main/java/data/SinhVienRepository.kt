package com.example.a313.data

class SinhVienRepository {
    private val danhSachSinhVien = mutableListOf<SinhVien>()

    fun getAll(): List<SinhVien> = danhSachSinhVien

    fun addSinhVien(sinhVien: SinhVien) {
        danhSachSinhVien.add(0, sinhVien)  // Thêm vào đầu danh sách
    }

    fun removeSinhVien(position: Int) {
        if (position in danhSachSinhVien.indices) {
            danhSachSinhVien.removeAt(position)
        }
    }
}
