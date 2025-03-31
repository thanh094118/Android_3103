// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    // Xóa dòng plugin compose riêng vì không cần thiết
}

// Cấu hình Compose trong file build.gradle module, không cần plugin riêng