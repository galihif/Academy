package com.giftech.academy.ui.bookmark

import androidx.lifecycle.ViewModel
import com.giftech.academy.data.CourseEntity
import com.giftech.academy.utils.DataDummy

class BookmarkViewModel:ViewModel() {

    fun getBookmarks(): List<CourseEntity> = DataDummy.generateDummyCourses()

}