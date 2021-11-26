package com.example.basesetting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basesetting.base.UtilityBase
import com.example.basesetting.databinding.ActivityMainBinding

class MainActivity : UtilityBase.BaseAppCompatActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun ActivityMainBinding.onCreate() {
        binding.tvActivity.text = "Activity"
    }
}