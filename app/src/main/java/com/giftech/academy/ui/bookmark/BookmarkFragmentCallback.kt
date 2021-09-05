package com.giftech.academy.ui.bookmark

import com.giftech.academy.data.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}
