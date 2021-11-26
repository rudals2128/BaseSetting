package com.example.basesetting

import android.Manifest
import android.content.Context
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission

class TedPermission(context: Context) {
    var mContext: Context = context

    var permissionListener: PermissionListener = object : PermissionListener {
        override fun onPermissionGranted() {
            //권한 허가시 실행
        }

        override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
            //권한 거부시 실행
        }

    }
    //Manifests에 uses-permission 추가, TedPermission 이용하기위해 build.gradle에 implementation "gun0912.ted:tedpermission:2.2.3" 추가하기
    fun permissionCheck() {
        TedPermission.with(mContext).setPermissionListener(permissionListener)
            .setRationaleMessage("앱의 기능을 사용하기 위해서는 권한이 필요합니다.")
            .setDeniedMessage("앱에서 요구하는 권한 설정이 필요합니다.\n[설정] > [권한] 에서 사용으로 활성화해주세요.")
            .setPermissions(//필요한 권한 추가
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ).check()
    }

    /**
     *
     * -- 사용방법 --
     * var per = TedPermission(this)
     * per.permissionCheck()
     *
     */
}