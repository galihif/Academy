package com.giftech.academy.ui.bookmark


import com.giftech.academy.data.source.local.entity.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}

